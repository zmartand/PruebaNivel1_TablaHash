import static java.util.Objects.hash;

public class TablaHash {
    //1. Crear tabla

    public static int[] crear_tabla(int tamaño){
        int[] tabla = new int[tamaño];
        return tabla;
    }
    // 2. Agregar(tabla, dato)
    public static void agregar(int[] tabla, int dato){
        int posicion = funcion_hash(dato, tabla.length);
        if (tabla[posicion] == 0) {
            tabla[posicion] = dato;
        } else {
            int nueva_posicion = sondeo(posicion, tabla.length);
            while (tabla[nueva_posicion] != 0) {
                nueva_posicion = sondeo(nueva_posicion, tabla.length);
            }
            tabla[nueva_posicion] = dato;
        }
    }
    // 3. Quitar(tabla, dato)
    public static int quitar(int[] tabla, int dato){
        int posicion = funcion_hash(dato, tabla.length);
        int elemento = 0;
        if (tabla[posicion] == dato) {
            elemento = tabla[posicion];
            tabla[posicion] = 0;
        } else {
            int nueva_posicion = sondeo(posicion, tabla.length);
            while (tabla[nueva_posicion] != dato) {
                nueva_posicion = sondeo(nueva_posicion, tabla.length);
            }
            elemento = tabla[nueva_posicion];
            tabla[nueva_posicion] = 0;
        }
        return elemento;
    }
    // 4. Buscar(tabla, dato)
    public static boolean buscar(int[] tabla, int elemento){
        boolean encontrado = false;
        for (int i = 0; i < tabla.length; i++) {
            if (tabla[i] == elemento) {
                encontrado = true;
                break;
            } else {
                encontrado = false;
            }
        }
        return encontrado;
    }
    // 5. Funcion_hash(dato, tamaño_tabla)
    public static int funcion_hash(int dato, int tamaño_tabla){
        return hash(dato) % tamaño_tabla;
    }
    // 6. Sondeo(posicion, tamaño_tabla)
    public static int sondeo(int posicion, int tamaño_tabla){
        return posicion % tamaño_tabla;
    }
    // 7. Cantidad_elementos(tabla)
    public static int cantidad_elementos(int[] tabla){
        int cantidad = 0;
        for (int i = 0; i < tabla.length; i++) {
            if(tabla[i] != 0){
                cantidad++;
            }
        }
        return cantidad;
    }


}

