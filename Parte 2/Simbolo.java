public class Simbolo {
    private String nombre;  // Nombre que se le asigna a la variable
    private String tipo;    // Tipo de la variable definida
    private Object valor;   // Valor asignado a la variable

    public Simbolo(String nombre, String tipo, Object valor){
        this.nombre = nombre;
        this.tipo = tipo;
        this.valor = valor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Simbolo {" +
                "nombre='" + nombre + '\'' +
                ", tipo='" + tipo + '\'' +
                ", valor=" + valor +
                '}';
    }
}
