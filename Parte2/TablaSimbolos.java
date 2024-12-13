import java.util.HashMap;

public class TablaSimbolos {
    private HashMap<String, Simbolo> tabla;

    public TablaSimbolos(){
        this.tabla = new HashMap<>();
    }

    public void agregarSimbolo(String nombre, FinalFactors tipo, Object valor){
        if(tabla.containsKey(nombre)){
            System.out.println("Error: La variable " + nombre + " ya está declarada.");
        } else {
            tabla.put(nombre, new Simbolo(nombre, tipo, valor));
        }
    }

    public void agregarSimbolo(String nombre, Simbolo simbolo){
        if(tabla.containsKey(nombre)){
            System.out.println("Error: La variable " + nombre + " ya está declarada.");
        } else {
            tabla.put(nombre, simbolo);
        }
    }

    public void actualizarValor(String nombre, String tipo, Object valor){
        if(tabla.containsKey(nombre)){
            tabla.get(nombre).setValor(valor);
        } else {
            System.out.println("Error: la variable " + nombre + " no está declarada");
        }
    }

    public Simbolo buscarSimbolo(String nombre){
        return tabla.get(nombre);
    }

    public void imprimirTabla(){
        System.out.println("Tabla de símbolos: ");
        for(Simbolo simbolo : tabla.values()){
            System.out.println(simbolo);
        }
    }
}
