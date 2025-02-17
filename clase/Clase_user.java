package Practica2.clase;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.ArrayList;

public class Clase_user {
    private String usuario;
    private String nombre;
    private String correo;
    private String curso;
    private String password;
    private boolean alergico;
    private String[] alergias;
    private String[] bocatasPedidos;
    private LocalDate fecha_nacimiento;
    private int rol;

    public Clase_user(String usuario, String nombre, String correo, String curso, String password, String[] bocatasPedidos,boolean alergico,String[] alergias, LocalDate fecha_nacimiento, int rol) {
        this.usuario = usuario;
        this.nombre = nombre;
        this.correo = correo;
        this.curso = curso;
        this.password = password;
        this.bocatasPedidos=bocatasPedidos;
        this.alergico=alergico;
        this.alergias = alergias;
        this.fecha_nacimiento=fecha_nacimiento;
        this.rol=rol;
    }

    public void mostrarInfo() {
        this.usuario = usuario;
        this.nombre = nombre;
        this.correo = correo;
        this.curso = curso;
        this.password = password;
        this.bocatasPedidos=bocatasPedidos;
        this.alergias = alergias;
        this.alergico=alergico;
        this.fecha_nacimiento = fecha_nacimiento;
        this.rol = rol;

        if (alergico = true) {
            System.out.println("\n----------------");
            System.out.println("Nombre de user = " + usuario + "\nNombre del alumno = " + nombre + "\nCorreo electrónico = " + correo + "\nCurso = " + curso + "\nPassword = " + password + "\nBocatas pedidos: "+bocatasPedidos+ "\nAlergias = " + alergias + "\nFecha de nacimiento = " + fecha_nacimiento + "\nRol = " + rol);
            System.out.println("\n----------------");
        } else {
            System.out.println("\n----------------");
            System.out.println("Nombre de user = " + usuario + "\nNombre del alumno = " + nombre + "\nCorreo electrónico = " + correo + "\nCurso = " + curso + "\nPassword = " + password + "\nBocatas pedidos: "+bocatasPedidos+ "\n¿Eres alérgico? = " + alergico + "\nFecha de nacimiento = " + fecha_nacimiento + "\nRol = " + rol);
            System.out.println("\n----------------");
        }


    }

    public void setBocatasPedidos(String[] bocatasPedidos) {
        this.bocatasPedidos = bocatasPedidos;
    }

    public String[] getBocatasPedidos() {
        return bocatasPedidos;
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

    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    public String[] getAlergias() {
        return alergias;
    }

    public boolean isAlergico() {
        return alergico;
    }

    public void setAlergico(boolean alergico) {
        this.alergico = alergico;
    }

    public void setAlergias(String[] alergias) {
        this.alergias = alergias;
    }
}
