package com.uisrael.proyecto;

public class ConsTareas {
    private String materia;
    private  String detalle;
    private String fechai;
    private String fechaf;

    public ConsTareas(String materia, String detalle, String fechai, String fechaf) {
        this.materia = materia;
        this.detalle = detalle;
        this.fechai = fechai;
        this.fechaf = fechaf;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getFechai() {
        return fechai;
    }

    public void setFechai(String fechai) {
        this.fechai = fechai;
    }

    public String getFechaf() {
        return fechaf;
    }

    public void setFechaf(String fechaf) {
        this.fechaf = fechaf;
    }
}
