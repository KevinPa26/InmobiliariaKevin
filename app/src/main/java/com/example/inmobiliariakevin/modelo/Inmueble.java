package com.example.inmobiliariakevin.modelo;

import java.io.Serializable;
import java.util.Objects;

public class Inmueble implements Serializable {

    private int id;
    private int propietarioId;
    private String direccion;
    private byte uso;
    private byte tipo;
    private int cant_ambiente;
    private double precio;
    private int superficie;
    private byte estado;
    private String creado;
    private String modificado;
    private Propietario propietario;
    private String imagen;

    public Inmueble(int id, int propietarioId, String direccion, byte uso, byte tipo, int cant_ambiente, double precio, int superficie, byte estado, String creado, String modificado, Propietario propietario, String imagen) {
        this.id = id;
        this.propietarioId = propietarioId;
        this.direccion = direccion;
        this.uso = uso;
        this.tipo = tipo;
        this.cant_ambiente = cant_ambiente;
        this.precio = precio;
        this.superficie = superficie;
        this.estado = estado;
        this.creado = creado;
        this.modificado = modificado;
        this.propietario = propietario;
        this.imagen = imagen;
    }

    public Inmueble(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPropietarioId() {
        return propietarioId;
    }

    public void setPropietarioId(int propietarioId) {
        this.propietarioId = propietarioId;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public byte getUso() {
        return uso;
    }

    public void setUso(byte uso) {
        this.uso = uso;
    }

    public byte getTipo() {
        return tipo;
    }

    public void setTipo(byte tipo) {
        this.tipo = tipo;
    }

    public int getCant_ambiente() {
        return cant_ambiente;
    }

    public void setCant_ambiente(int cant_ambiente) {
        this.cant_ambiente = cant_ambiente;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getSuperficie() {
        return superficie;
    }

    public void setSuperficie(int superficie) {
        this.superficie = superficie;
    }

    public byte getEstado() {
        return estado;
    }

    public void setEstado(byte estado) {
        this.estado = estado;
    }

    public String getCreado() {
        return creado;
    }

    public void setCreado(String creado) {
        this.creado = creado;
    }

    public String getModificado() {
        return modificado;
    }

    public void setModificado(String modificado) {
        this.modificado = modificado;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inmueble inmueble = (Inmueble) o;
        return id == inmueble.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}