package Practica2.clase;

public class Clase_bocatas {
    private int id;
    private String nombre;
    private String descrip;
    private String[] ingredientes;
    private String[] alergenos;
    private String ciudadpopular;
    private double precio;

    public Clase_bocatas (int id,String nombre, String descrip, String [] ingredientes, String[] alergenos, String ciudadpopular, double precio){
        this.id=id;
        this.nombre=nombre;
        this.descrip=descrip;
        this.ingredientes=ingredientes;
        this.alergenos=alergenos;
        this.ciudadpopular=ciudadpopular;
        this.precio=precio;
    }

    public void mostrarCuriosidades(){
        this.nombre=nombre;
        this.ingredientes=ingredientes;
        this.ciudadpopular=ciudadpopular;

        System.out.println("Sabes que el "+nombre+" es popular en " +ciudadpopular+ " porque en los momentos dificiles al haber pocos recursos se hacia este bocata");
    }

    public void mostrarAlergenos(String nombre,String[] alergenos){
        this.nombre=nombre;
        this.alergenos=alergenos;
        System.out.println("El "+nombre+" tiene estos alergenos:");
        for (int i = 0; i < alergenos.length; i++) {
            System.out.println(alergenos[i]);
        }
    }

    public void mostrarIngredientes(String nombre,String[] ingredientes){
        this.nombre=nombre;
        this.ingredientes=ingredientes;

        System.out.println("El "+nombre+" tiene estos ingreientes:");
        for (int i = 0; i < ingredientes.length; i++) {
            System.out.println(ingredientes[i]);
        }
    }

    public void mostrarinfo(){
        this.id=id;
        this.nombre=nombre;
        this.descrip=descrip;
        this.ingredientes=ingredientes;
        this.alergenos=alergenos;
        this.ciudadpopular=ciudadpopular;
        this.precio=precio;

        System.out.println("----------------\n");
        System.out.println("Id bocata: "+id+ "\nNombre del bocata: "+nombre+"\nDescripción del bocata: "+descrip+"\nIngredientes del bocata: "+ingredientes+"\nAlergenos del bocata: "+alergenos+"\nCiudad popular del bocata: "+ciudadpopular+"\nPrecio del bocata: "+precio);
        System.out.println("\n----------------");
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescrip() {
        return descrip;
    }

    public String[] getIngredientes() {
        return ingredientes;
    }

    public String[] getAlergenos() {
        return alergenos;
    }

    public String getCiudadpopular() {
        return ciudadpopular;
    }

    public double getPrecio() {
        return precio;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public void setIngredientes(String[] ingredientes) {
        this.ingredientes = ingredientes;
    }

    public void setAlergenos(String[] alergenos) {
        this.alergenos = alergenos;
    }

    public void setCiudadpopular(String ciudadpopular) {
        this.ciudadpopular = ciudadpopular;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }


}

