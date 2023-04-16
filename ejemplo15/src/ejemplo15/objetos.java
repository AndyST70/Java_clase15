package ejemplo15;

public class objetos {
   private int codigo;
    private String nombre;
    private double precio;
    private int duracion;
    private String tamano;

     public objetos(int codigo, String nombre, double precio, int duracion, String tamano) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.duracion = duracion;
        this.tamano = tamano;
    }
     
//public objetos(){}
  
 public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getTamano() {
        return tamano;
    }

    public void setTamano(String tamano) {
        this.tamano = tamano;
    }

    @Override
    public String toString() {
        return "objetos{" + "codigo=" + codigo + ", nombre=" + nombre + ", precio=" + precio + ", duracion=" + duracion + ", tamano=" + tamano + '}';
    }

    
    
}

    

