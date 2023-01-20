package com.otro.project.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)


    private int id;
    private String nombre;
    private String apellido;
    private String password;
    private int nucleo;
    private String correo;

    public Usuario() {
    }

    public Usuario(int id, String nombre, String apellido,String password ,int nucleo, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.password = password;
        this.nucleo = nucleo;
        this.correo = correo;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getNucleo() {
        return this.nucleo;
    }

    public void setNucleo(int nucleo) {
        this.nucleo = nucleo;
    }

    public String getCorreo() {
        return this.correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
