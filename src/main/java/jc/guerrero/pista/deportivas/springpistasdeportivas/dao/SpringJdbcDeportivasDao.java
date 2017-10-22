package jc.guerrero.pista.deportivas.springpistasdeportivas.dao;

import jc.guerrero.pista.deportivas.springpistasdeportivas.domain.AlquilerPista;
import jc.guerrero.pista.deportivas.springpistasdeportivas.domain.Pista;
import jc.guerrero.pista.deportivas.springpistasdeportivas.domain.Rol;
import jc.guerrero.pista.deportivas.springpistasdeportivas.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by Juan Carlos on 26/09/2017.
 */
@Repository
public class SpringJdbcDeportivasDao implements DeportivasDao {

    @Autowired
    private NamedParameterJdbcTemplate parameterJdbcTemplate;

    public void insertUsuario(Usuario usuario) {
        String sql = "insert into deportivas.usuarios (id, nombre, apellidos, dni, fecha_alta, localidad, direccion, id_rol, nombre_usuario) values " +
                "(:id, :nombre, :apellidos, :dni, CURRENT_DATE, :localidad, :direccion, :id_rol, :username)";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", usuario.getId());
        params.addValue("nombre", usuario.getNombre());
        params.addValue("apellidos", usuario.getApellidos());
        params.addValue("dni", usuario.getDni());
        params.addValue("localidad", usuario.getLocalidad());
        params.addValue("direccion", usuario.getDireccion());
        params.addValue("id_rol", usuario.getId_rol().getId());
        params.addValue("username", usuario.getNombre_usuario());

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

    //métodos para obtener la ultima id de cada tabla
    public int getLastIdUsuarios(){
        String sql = "select max(id) from deportivas.usuarios";
        MapSqlParameterSource params = new MapSqlParameterSource();

        return parameterJdbcTemplate.queryForObject(sql, params, Integer.class);
    }

    public int getLastIdPistas(){
        String sql = "select max(id) from deportivas.pistas";

        MapSqlParameterSource params = new MapSqlParameterSource();

        return parameterJdbcTemplate.queryForObject(sql, params, Integer.class);
    }
    ////

    public List<Pista> getAllListaPistas(){
        String sql = "select id, nombre, tipo, ubicacion from pistas";

        MapSqlParameterSource params = new MapSqlParameterSource();

        return  parameterJdbcTemplate.query(sql, params, new PistaRowMapper());
    }

    public List<Pista> getListaPistasByTipo(String tipo){
        String sql = "select id, nombre, tipo, ubicacion from pistas where tipo = :tipo";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("tipo", tipo);

        return parameterJdbcTemplate.query(sql, params, new PistaRowMapper());
    }



    public Pista getPistaById(int pistaId){
        String sql = "select id, nombre, tipo, ubicacion from pistas where id = :id";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", pistaId);

        Pista pista;
        try {
            pista = parameterJdbcTemplate.queryForObject(sql, params, new PistaRowMapper());
        } catch (EmptyResultDataAccessException ex) {
            pista = null;
        }
        return pista;
    }


    /*ROWMAPPERS*/
    public class PistaRowMapper implements RowMapper<Pista> {
        public Pista mapRow(ResultSet rs, int i) throws SQLException {
            Pista pista = new Pista();

            pista.setId_pista(rs.getInt("id"));
            pista.setNombre(rs.getString("nombre"));
            pista.setTipo(rs.getString("tipo"));
            pista.setUbicacion(rs.getString("ubicacion"));

            return pista;
        }
    }


}
