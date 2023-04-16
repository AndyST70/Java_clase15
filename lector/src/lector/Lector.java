
package lector;
//importar 
import java.io.FileReader; // lectura de nuestros documentos
import java.io.IOException; //  
import org.json.simple.JSONArray; // trabajar arreglos importar 
import org.json.simple.JSONObject; // objetos
import org.json.simple.parser.JSONParser; // parsear el texto, como un objeto para poder trabajarlo
import org.json.simple.parser.ParseException; // 

/**
 *
 * @author andye
 */
public class Lector {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //parserar nuestro doco
        JSONParser parser = new JSONParser();
        
        try (FileReader reader = new FileReader("p1/entrada2.json")) {
            // Lee el archivo JSON y lo parsea a un objeto JSON  
            Object obj = parser.parse(reader);
            JSONObject pizzeria = (JSONObject) obj;
            
            
//===================================================
            // Obtiene la lista de pizzas
            
            JSONArray pizzas = (JSONArray) pizzeria.get("Pizzeria");
            System.out.println(pizzas);
            // Itera sobre la lista de pizzas
            //rrecorre el arreglo del objeto tipo jsonarray
            // JSONARRAY -> 1, 2
            for (Object pizzaObj : pizzas) {
                //guardame todos los datos que vamos a iterar en el for
                JSONObject pizza = (JSONObject) pizzaObj;

                // Obtiene los datos de la pizza
                long codigo = (long) pizza.get("codigo");
                String nombre = (String) pizza.get("nombre");
                String precio = (String) pizza.get("precio");
                String duracion = (String) pizza.get("duracion");
                String tamaño = (String) pizza.get("tamaño");

                // Imprime los datos de la pizza
                System.out.println("Código: " + codigo);
                System.out.println("Nombre: " + nombre);
                System.out.println("Precio: " + precio);
                System.out.println("Duración: " + duracion);
                System.out.println("Tamaño: " + tamaño);
                System.out.println();
            }

        } catch (IOException | ParseException e) {
            //e: 
            //ex:
            e.printStackTrace();
        }
    }
}
   