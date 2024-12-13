import enums.FinalFactors;

public class Simbolo {
    private String nombre;  // Nombre que se le asigna a la variable
    private FinalFactors tipo;    // Tipo de la variable definida
    private Object valor;   // Valor asignado a la variable
    private String[] registro = new String[2];
    private static Integer indice_int = 0;
    private static Integer indice_float = 0;
    private static Integer indice_array = 0;

    public Simbolo(String nombre, FinalFactors tipo, Object valor){
        this.nombre = nombre;
        this.tipo = tipo;
        this.valor = valor;

        switch (tipo) {
            case NUMBER:
            case CHAR:
            case BOOLEAN:
                this.registro[0] = "istore_" + indice_int;
                this.registro[1] = "iload_" + indice_int;
                indice_int++;
                break;
            case FLOAT:
                this.registro[0] = "fstore_" + indice_float;
                this.registro[1] = "fload_" + indice_float;
                indice_float++;
                break;
            case STRING:
            case ARRAY:
                this.registro[0] = "astore_" + indice_array;
                this.registro[1] = "aload_" + indice_array;
                indice_array++;
                break;
            default:
                break;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public FinalFactors getTipo() {
        return tipo;
    }

    public void setTipo(FinalFactors tipo) {
        this.tipo = tipo;
    }

    public Object getValor() {
        //if(tipo == FinalFactors.STRING)
        //    return "\"" + valor + "\"";
        return valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }

    public String asignar() { return this.registro[0]; }

    //public void setRegistro(String registro) { this.registro[0] = registro; }

    public String cargarEnPila() { return this.registro[1]; }
    @Override
    public String toString() {
        return "Simbolo {" +
                "nombre='" + nombre + '\'' +
                ", tipo='" + tipo + '\'' +
                ", valor=" + valor +
                '}';
    }
}
