//package jc.guerrero.pista.deportivas.springpistasdeportivas.security;
//
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.filter.GenericFilterBean;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.http.HttpServletRequest;
//import java.io.IOException;
//
///**
// * Las peticiones que no sean /login pasar�n por este filtro
// * el cu�l se encarga de pasar el "request" a nuestra clase de utilidad JwtUtil
// * para que valide el token.
// */
//public class JwtFilter extends GenericFilterBean {
//
//    @Override
//    public void doFilter(ServletRequest request,
//                         ServletResponse response,
//                         FilterChain filterChain)
//            throws IOException, ServletException {
//
//
//        Authentication authentication = JwtUtil.getAuthentication((HttpServletRequest)request);
//
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//
//        filterChain.doFilter(request,response);
//    }
//}