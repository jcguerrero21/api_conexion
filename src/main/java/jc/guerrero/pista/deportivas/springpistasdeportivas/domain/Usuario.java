package jc.guerrero.pista.deportivas.springpistasdeportivas.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Juan Carlos on 26/09/2017.
 */

public class Usuario implements Serializable {

    private int id;
    private String nombre;
    private String apellidos;
    private String dni;
    private Date fecha_alta;
    private String localidad;
    private String direccion;
    private Rol id_rol;
    private String nombre_usuario;
    private String contraseña;

    public Usuario() {
    }

    public Usuario(int id, String nombre, String apellidos, String dni, Date fecha_alta, String localidad, String direccion, Rol id_rol, String username, String contraseña) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.fecha_alta = fecha_alta;
        this.localidad = localidad;
        this.direccion = direccion;
        this.id_rol = id_rol;
        this.nombre_usuario = username;
        this.contraseña = contraseña;
    }

    public int getId() {
        return id;
    }

    public Usuario setId(int id) {
        this.id = id;
        return this;
    }

    public String getNombre() {
        return nombre;
    }

    public Usuario setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public String getApellidos() {
        return apellidos;
    }

    public Usuario setApellidos(String apellidos) {
        this.apellidos = apellidos;
        return this;
    }

    public String getDni() {
        return dni;
    }

    public Usuario setDni(String dni) {
        this.dni = dni;
        return this;
    }

    public Date getFecha_alta() {
        return fecha_alta;
    }

    public Usuario setFecha_alta(Date fecha_alta) {
        this.fecha_alta = fecha_alta;
        return this;
    }

    public String getLocalidad() {
        return localidad;
    }

    public Usuario setLocalidad(String localidad) {
        this.localidad = localidad;
        return this;
    }

    public String getDireccion() {
        return direccion;
    }

    public Usuario setDireccion(String direccion) {
        this.direccion = direccion;
        return this;
    }

    public Rol getId_rol() {
        return id_rol;
    }

    public Usuario setId_rol(Rol id_rol) {
        this.id_rol = id_rol;
        return this;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public Usuario setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
        return this;
    }

    public String getContraseña() {
        return contraseña;
    }

    public Usuario setContraseña(String contraseña) {
        this.contraseña = contraseña;
        return this;
    }
}
