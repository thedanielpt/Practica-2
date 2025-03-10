package Practica2.clase;

import java.time.LocalDate;

public class Calendario {
    private int id;
    private LocalDate fecha_inicio;
    private LocalDate fecha_fin;
    private String Bocadillo_quincena_frios[];
    private String Bocadillo_quincena_calientes[];

    public Calendario(int id, LocalDate fecha_inicio, LocalDate fecha_fin, String[] bocadillo_quincena_frios, String[] bocadillo_quincena_calientes) {
        this.id = id;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        Bocadillo_quincena_frios = bocadillo_quincena_frios;
        Bocadillo_quincena_calientes = bocadillo_quincena_calientes;
    }

    public int getId() {
        return id;
    }

    public LocalDate getFecha_fin() {
        return fecha_fin;
    }

    public LocalDate getFecha_inicio() {
        return fecha_inicio;
    }

    public String[] getBocadillo_quincena_frios() {
        return Bocadillo_quincena_frios;
    }

    public String[] getBocadillo_quincena_calientes() {
        return Bocadillo_quincena_calientes;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFecha_inicio(LocalDate fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public void setFecha_fin(LocalDate fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public void setBocadillo_quincena_frios(String[] bocadillo_quincena_frios) {
        Bocadillo_quincena_frios = bocadillo_quincena_frios;
    }

    public void setBocadillo_quincena_calientes(String[] bocadillo_quincena_calientes) {
        Bocadillo_quincena_calientes = bocadillo_quincena_calientes;
    }
}
