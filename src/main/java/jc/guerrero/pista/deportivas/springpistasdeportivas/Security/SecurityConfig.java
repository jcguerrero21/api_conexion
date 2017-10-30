package jc.guerrero.pista.deportivas.springpistasdeportivas.Security;

import jc.guerrero.pista.deportivas.springpistasdeportivas.dao.DeportivasDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Created by Juan Carlos on 30/10/2017.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    @Autowired
    private DeportivasDao deporDao;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers("/deportivas/login").permitAll() //permitimos el acceso a /login a cualquiera
                .anyRequest().authenticated() //cualquier otra peticion requiere autenticacion
                .and()
                // Las peticiones /login pasaran previamente por este filtro
                .addFilterBefore(new LoginFilter("/deportivas/login", authenticationManager()),
                        UsernamePasswordAuthenticationFilter.class)

                // Las demás peticiones pasarán por este filtro para validar el token
                .addFilterBefore(new JwtFilter(),
                        UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // Creamos una cuenta de usuario si los datos que viene son correctos
        auth.inMemoryAuthentication()
                .withUser("jcguerrero")
                .password("1234")
                .roles("ADMIN");
    }

    public User comprobarUsuario(String user, String contraseña){
        if (deporDao.getUsuarioByNameAndPassword(user, contraseña) != 0){
            User usuario = new User().setUsername(user).setPassword(contraseña);
            return usuario;
        }
        return null;
    }
}
