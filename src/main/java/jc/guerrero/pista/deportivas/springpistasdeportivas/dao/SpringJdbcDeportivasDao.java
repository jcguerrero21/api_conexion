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
import java.text.SimpleDateFormat;
import java.util.Date;
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
        String sql = "insert into deportivas.usuarios (id, nombre, apellidos, dni, fecha_alta, localidad, direccion, id_rol, nombre_usuario, contraseña) values " +
                "(:id, :nombre, :apellidos, :dni, :fecha, :localidad, :direccion, :id_rol, :username, :contraseña)";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", usuario.getId());
        params.addValue("nombre", usuario.getNombre());
        params.addValue("apellidos", usuario.getApellidos());
        params.addValue("dni", usuario.getDni());
        params.addValue("fecha", new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
        params.addValue("localidad", usuario.getLocalidad());
        params.addValue("direccion", usuario.getDireccion());
        params.addValue("id_rol", usuario.getId_rol().getId());
        params.addValue("username", usuario.getNombre_usuario());
        params.addValue("contraseña", usuario.getContraseña());

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
        params.addValue("id", pista.getId());
        params.addValue("nombre", pista.getNombre());
        params.addValue("tipo", pista.getTipo());
        params.addValue("ubicacion", pista.getUbicacion());

        this.parameterJdbcTemplate.update(sql, params);
    }

    //métodos para obtener la ultima id de cada tabla
    public int getHayUsuarios(){
        String sql = "select count(id) from deportivas.usuarios";
        MapSqlParameterSource params = new MapSqlParameterSource();

        return parameterJdbcTemplate.queryForObject(sql, params, Integer.class);
    }

    public int getLastIdUsuarios() {
        String sql = "select max(id) from deportivas.usuarios";
        MapSqlParameterSource params = new MapSqlParameterSource();

        return parameterJdbcTemplate.queryForObject(sql, params, Integer.class);
    }

    public int getHayPistas(){
        String sql = "select count(id) from deportivas.pistas";

        MapSqlParameterSource params = new MapSqlParameterSource();

        return parameterJdbcTemplate.queryForObject(sql, params, Integer.class);
    }

    public int getLastIdPistas() {
        String sql = "select max(id) from deportivas.pistas";

        MapSqlParameterSource params = new MapSqlParameterSource();

        return parameterJdbcTemplate.queryForObject(sql, params, Integer.class);
    }
    ////

    public List<Pista> getAllListaPistas() {
        String sql = "select id, nombre, tipo, ubicacion from pistas";

        MapSqlParameterSource params = new MapSqlParameterSource();

        return parameterJdbcTemplate.query(sql, params, new PistaRowMapper());
    }

    public List<Pista> getListaPistasByTipo(String tipo) {
        String sql = "select id, nombre, tipo, ubicacion from pistas where tipo = :tipo";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("tipo", tipo);

        return parameterJdbcTemplate.query(sql, params, new PistaRowMapper());
    }


    public Pista getPistaById(int pistaId) {
        String sql = "select id, nombre, tipo, ubicacion from pistas where id = :id";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", pistaId);

        return parameterJdbcTemplate.queryForObject(sql, params, new PistaRowMapper());
    }

    public void alquilarPista(AlquilerPista alquilerPista) {
        String sql = "insert into deportivas.fecha_alquiler_pista(usuario_id, pista_id, fecha, hora) " +
                "values (:usuarioId, :pistaId, :fecha, :hora)";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("usuarioId", alquilerPista.getId_usuario().getId());
        params.addValue("pistaId", alquilerPista.getId_pista().getId());
        params.addValue("fecha", alquilerPista.getFecha_reserva());
        params.addValue("hora", alquilerPista.getHora().getId());

        parameterJdbcTemplate.update(sql, params);
    }

    public int comprobarPistaDisponibleFechaHora(AlquilerPista alquilerPista){
        String sql = "select count(*)  from deportivas.fecha_alquiler_pista " +
                "where pista_id = :pistaId and fecha = :fecha and hora = :hora";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("pistaId", alquilerPista.getId_pista().getId());
        params.addValue("fecha", alquilerPista.getFecha_reserva());
        params.addValue("hora", alquilerPista.getHora().getId());

        return parameterJdbcTemplate.queryForObject(sql, params, Integer.class);
    }


    public List<AlquilerPista> getPistaAlquiladaByUsuario(int usuarioId, String fecha){
        String sql = "select t2.id as idPista, t2.nombre as nombre, t1.fecha as fecha," +
                "t3.hora as hora, t4.nombre as nombreUsuario, t4.apellidos as apellidos " +
                "from deportivas.fecha_alquiler_pista t1, pistas t2, horarios t3, usuarios t4 " +
                "WHERE t1.usuario_id = :usuarioId AND t1.pista_id = t2.id AND t3.id = t1.hora " +
                "AND t1.usuario_id = t4.id AND t1.fecha like :fecha";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("usuarioId", usuarioId);
        params.addValue("fecha",fecha);

        return parameterJdbcTemplate.query(sql, params, new PistaAlquiladaRowMapper());
    }

    public void deleteAlquilerPista(AlquilerPista alquilerPista, int usuarioId){
        String sql = "delete from deportivas.fecha_alquiler_pista where " +
                "usuario_id = :usuarioId and pista_id = :pistaId and fecha = :fecha and hora = :hora";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("usuarioId", usuarioId);
        params.addValue("pistaId", alquilerPista.getId_pista().getId());
        params.addValue("fecha", alquilerPista.getFecha_reserva());
        params.addValue("hora", alquilerPista.getHora().getId());

        parameterJdbcTemplate.update(sql,params);
    }

    public int getUsuarioByNameAndPassword(String userName, String password){
        String sql = "SELECT COUNT(*) FROM deportivas.usuarios WHERE " +
                "nombre_usuario like \":user\" AND contraseña LIKE \":contraseña\"";

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("user", userName);
        params.addValue("contraseña", password);

        return parameterJdbcTemplate.queryForObject(sql, params, Integer.class);
    }

    /*ROWMAPPERS*/
    public class PistaRowMapper implements RowMapper<Pista> {
        public Pista mapRow(ResultSet rs, int i) throws SQLException {
            Pista pista = new Pista();

            pista.setId(rs.getInt("id"));
            pista.setNombre(rs.getString("nombre"));
            pista.setTipo(rs.getString("tipo"));
            pista.setUbicacion(rs.getString("ubicacion"));

            return pista;
        }
    }

    public class PistaAlquiladaRowMapper implements RowMapper<AlquilerPista> {
        public AlquilerPista mapRow(ResultSet rs, int i) throws SQLException {
            AlquilerPista alquilerPista = new AlquilerPista();

            alquilerPista.getId_pista().setId(rs.getInt("idPista"));
            alquilerPista.getId_pista().setNombre(rs.getString("nombre"));
            alquilerPista.setFecha_reserva(rs.getString("fecha"));
            alquilerPista.getHora().setHora(rs.getString("hora"));
            alquilerPista.getId_usuario().setNombre(rs.getString("nombreUsuario"));
            alquilerPista.getId_usuario().setApellidos(rs.getString("apellidos"));

            return alquilerPista;
        }
    }

}
