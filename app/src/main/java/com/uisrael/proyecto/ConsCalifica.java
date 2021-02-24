package com.uisrael.proyecto;

public class ConsCalifica {
    private String Materia;
    private String Primer_Parcial;
    private String Segundo_Parcial;
    private String Nota_Final;

    public ConsCalifica(String materia, String primer_Parcial, String segundo_Parcial, String nota_Final) {
        Materia = materia;
        Primer_Parcial = primer_Parcial;
        Segundo_Parcial = segundo_Parcial;
        Nota_Final = nota_Final;
    }

    public String getMateria() {
        return Materia;
    }

    public void setMateria(String materia) {
        Materia = materia;
    }

    public String getPrimer_Parcial() {
        return Primer_Parcial;
    }

    public void setPrimer_Parcial(String primer_Parcial) {
        Primer_Parcial = primer_Parcial;
    }

    public String getSegundo_Parcial() {
        return Segundo_Parcial;
    }

    public void setSegundo_Parcial(String segundo_Parcial) {
        Segundo_Parcial = segundo_Parcial;
    }

    public String getNota_Final() {
        return Nota_Final;
    }

    public void setNota_Final(String nota_Final) {
        Nota_Final = nota_Final;
    }
}
