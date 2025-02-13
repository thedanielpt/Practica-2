package Practica2.clase;

import java.time.LocalDate;
import java.util.ArrayList;

public class Clase_user {
    private String usuario;
    private String nombre;
    private String correo;
    private String curso;
    private String password;
    private ArrayList alergias;
    private LocalDate fecha_nacimiento;
    private int rol;

    public Clase_user(String usuario, String nombre, String correo, String curso, String password, ArrayList alergias, int rol) {
        this.usuario = usuario;
        this.nombre = nombre;
        this.correo = correo;
        this.curso = curso;
        this.password = password;
        this.alergias = alergias;
        this.rol=rol;
    }

    public void mostrarInfo() {
        this.usuario = usuario;
        this.nombre = nombre;
        this.correo = correo;
        this.curso = curso;
        this.password = password;
        this.alergias = alergias;
        this.fecha_nacimiento = fecha_nacimiento;
        this.rol = rol;

        System.out.println("Nombre de user = " + usuario + "\nNombre del alumno = " + nombre + "\nCorreo electrónico = " + correo + "\nCurso = " + curso + "\npassword = " + password + "\nTienes alergia = " + alergias + "\nFecha de nacimiento = " + fecha_nacimiento + "\nRol = " + rol);
    }

    public String getUsuario() {
        return usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getCurso() {
        return curso;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList getAlergias() {
        return alergias;
    }

    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public int getRol() {
        return rol;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAlergias(ArrayList alergias) {
        this.alergias = alergias;
    }

    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }
}
