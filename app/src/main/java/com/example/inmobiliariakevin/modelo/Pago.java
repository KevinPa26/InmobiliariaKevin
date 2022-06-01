package com.example.inmobiliariakevin.modelo;

import java.io.Serializable;
import java.time.LocalDate;

public class Pago implements Serializable {

    private int id;
    private int contratoid;
    private String fecha;
    private double importe;
    private int num_pago;
    private String creado;
    private String modificado;
    private Contrato contrato;

    public Pago() {}

    public Pago(int id, int contratoid, String fecha, double importe, int num_pago, String creado, String modificado, Contrato contrato) {
        this.id = id;
        this.contratoid = contratoid;
        this.fecha = fecha;
        this.importe = importe;
        this.num_pago = num_pago;
        this.creado = creado;
        this.modificado = modificado;
        this.contrato = contrato;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getContratoid() {
        return contratoid;
    }

    public void setContratoid(int contratoid) {
        this.contratoid = contratoid;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public int getNum_pago() {
        return num_pago;
    }

    public void setNum_pago(int num_pago) {
        this.num_pago = num_pago;
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

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }
}
