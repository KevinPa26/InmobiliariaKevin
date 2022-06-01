package com.example.inmobiliariakevin.modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class Contrato implements Serializable {

    private int id;
    private int inmuebleid;
    private int inquilinoid;
    private String fecha_inicio;
    private String fecha_fin;
    private double monto_mes;
    private String garante_nombre;
    private String garante_apellido;
    private String garante_dni;
    private String garante_tel;
    private Inquilino inquilino;
    private Inmueble inmueble;

    public Contrato(int id, int inmuebleid, int inquilinoid, String fecha_inicio, String fecha_fin, double monto_mes, String garante_nombre, String garante_apellido, String garante_dni, String garante_tel, Inquilino inquilino, Inmueble inmueble) {
        this.id = id;
        this.inmuebleid = inmuebleid;
        this.inquilinoid = inquilinoid;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.monto_mes = monto_mes;
        this.garante_nombre = garante_nombre;
        this.garante_apellido = garante_apellido;
        this.garante_dni = garante_dni;
        this.garante_tel = garante_tel;
        this.inquilino = inquilino;
        this.inmueble = inmueble;
    }

    public Contrato() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getInmuebleid() {
        return inmuebleid;
    }

    public void setInmuebleid(int inmuebleid) {
        this.inmuebleid = inmuebleid;
    }

    public int getInquilinoid() {
        return inquilinoid;
    }

    public void setInquilinoid(int inquilinoid) {
        this.inquilinoid = inquilinoid;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public double getMonto_mes() {
        return monto_mes;
    }

    public void setMonto_mes(double monto_mes) {
        this.monto_mes = monto_mes;
    }

    public String getGarante_nombre() {
        return garante_nombre;
    }

    public void setGarante_nombre(String garante_nombre) {
        this.garante_nombre = garante_nombre;
    }

    public String getGarante_apellido() {
        return garante_apellido;
    }

    public void setGarante_apellido(String garante_apellido) {
        this.garante_apellido = garante_apellido;
    }

    public String getGarante_dni() {
        return garante_dni;
    }

    public void setGarante_dni(String garante_dni) {
        this.garante_dni = garante_dni;
    }

    public String getGarante_tel() {
        return garante_tel;
    }

    public void setGarante_tel(String garante_tel) {
        this.garante_tel = garante_tel;
    }

    public Inquilino getInquilino() {
        return inquilino;
    }

    public void setInquilino(Inquilino inquilino) {
        this.inquilino = inquilino;
    }

    public Inmueble getInmueble() {
        return inmueble;
    }

    public void setInmueble(Inmueble inmueble) {
        this.inmueble = inmueble;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contrato contrato = (Contrato) o;
        return id == contrato.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}