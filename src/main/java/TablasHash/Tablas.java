package TablasHash;

import java.util.HashMap;

public class Tablas {
    HashMap<String, HashMap<Integer, HashMap<String, Integer>>> tablasHash;

    public Tablas() {
        tablasHash = new HashMap<String, HashMap<Integer, HashMap<String, Integer>>>();
    }

    public void cargarBarco(int numero, String nombre, String tipo, int nivel) {
        // Verificar si ya existe una tabla hash para este tipo de barco
        HashMap<Integer, HashMap<String, Integer>> tablaPorNumero = tablasHash.get(tipo);
        if (tablaPorNumero == null) {
            tablaPorNumero = new HashMap<Integer, HashMap<String, Integer>>();
            tablasHash.put(tipo, tablaPorNumero);
        }

        // Verificar si ya existe una tabla hash para este número de barco
        HashMap<String, Integer> tablaPorNombre = tablaPorNumero.get(numero);
        if (tablaPorNombre == null) {
            tablaPorNombre = new HashMap<String, Integer>();
            tablaPorNumero.put(numero, tablaPorNombre);
        }

        // Agregar los datos del barco a la tabla hash correspondiente
        tablaPorNombre.put(nombre, nivel);
    }
}
