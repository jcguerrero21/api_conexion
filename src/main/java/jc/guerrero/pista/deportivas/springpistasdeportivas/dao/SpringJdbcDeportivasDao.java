package jc.guerrero.pista.deportivas.springpistasdeportivas.dao;

import jc.guerrero.pista.deportivas.springpistasdeportivas.domain.AlquilerPista;
import jc.guerrero.pista.deportivas.springpistasdeportivas.domain.Pista;
import jc.guerrero.pista.deportivas.springpistasdeportivas.domain.Rol;
import jc.guerrero.pista.deportivas.springpistasdeportivas.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * Created by Juan Carlos on 26/09/2017.
 */
@Repository
public class SpringJdbcDeportivasDao implements DeportivasDao {

    @Autowired
    private NamedParameterJdbcTemplate parameterJdbcTemplate;

    public void insertUsuario(Usuario usuario) {
        String sql = "insert into deportivas.usuarios (id, nombre, apellidos, dni, fecha_alta, localidad, direccion, id_rol) values " +
                "(:id, :nombre, :apellidos, :dni, :fecha, :localidad, :direccion, :id_rol)";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", usuario.getId());
        params.addValue("nombre", usuario.getNombre());
        params.addValue("apellidos", usuario.getApellidos());
        params.addValue("dni", usuario.getDni());
        params.addValue("fecha", usuario.getFecha_alta());
        params.addValue("localidad", usuario.getLocalidad());
        params.addValue("direccion", usuario.getDireccion());
        params.addValue("id_rol", usuario.getId_rol().getId());

        this.parameterJdbcTemplate.update(sql, params);
    }

    public void insertRol(Rol rol) {
        String sql = "insert into deportivas.roles (id, nombre) values (:id, :nombre)";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", rol.getId());
        params.addValue("nombre", rol.getNombre());

        this.parameterJdbcTemplate.update(sql, params);
    }

    public void insertPista(Pista pista) {
        String sql = "insert into deportivas.pistas (id, nombre, tipo, ubicacion) values (:id, :nombre, :tipo, :ubicacion)";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", pista.getId_pista());
        params.addValue("nombre", pista.getNombre());
        params.addValue("tipo", pista.getTipo());
        params.addValue("ubicacion", pista.getUbicacion());

        this.parameterJdbcTemplate.update(sql, params);
    }

    public void insertFechaAqlquiler(AlquilerPista alquilerPista) {
        String sql = "insert into deportivas.fecha_alquiler_pista (usuario_id, pista_id, fecha, hora) " +
                "values (:usuarioId, :pistaId, :fechaReserva, :fecha, :hora)";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("usuarioId", alquilerPista.getId_usuario());
        params.addValue("pistaId", alquilerPista.getId_pista());
        params.addValue("fecha", alquilerPista.getFecha_reserva());
        params.addValue("hora", alquilerPista.getHora().getId());

        this.parameterJdbcTemplate.update(sql, params);
    }


}
