package archivos;

import ejemplo15.objetos;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class lector {
List<objetos> pizzas;
    
 //  ArrayList<objetos> pizza;
   //   objetos pizzaTemporal;
    public lector() {
       // pizza = new ArrayList<objetos>();        
       pizzas = new ArrayList<objetos>();
        File archivo = new File("entrada.json");
       if(archivo.exists()){
            //lectura_datos();
            pizzas = leer_Informacion();
        }
    }
  //FUNCIONAN CORRETAMENTE  
  public List<objetos> leer_Informacion(){
    JSONParser parser = new JSONParser();
    // creamos el objeto para guardar lo que se lee el FILEREADER
    List<objetos> listaPizzas = new ArrayList<>();
    
    try (FileReader reader = new FileReader("entrada.json")){
        Object obj = parser.parse(reader);
        // Se almacena un objeto JSON
        JSONObject pizzeria = (JSONObject) obj;
        // Extraer la lista JSON del objeto
        JSONArray pizzas = (JSONArray) pizzeria.get("Pizzeria");
        for (Object pizzaObj : pizzas) {
            // GUARDAMOS LOS DATOS
            // creamos los siguientes objetos
            JSONObject pizza = (JSONObject) pizzaObj;
            // guardamos los valores
               int codigo = Integer.parseInt(pizza.get("codigo").toString());
                String nombre = (String) pizza.get("nombre");
                float precio = Float.parseFloat(pizza.get("precio").toString());
                int duracion = Integer.parseInt(pizza.get("duracion").toString());
                String tamano = (String) pizza.get("tamaño");
            
            // instanciamos el dato y lo guardamos
             objetos pizzaNueva = new objetos(codigo, nombre, precio, duracion, tamano);
            listaPizzas.add(pizzaNueva);
            
        }
   } catch (IOException | ParseException | ClassCastException e) {
        e.printStackTrace();
    } catch (NumberFormatException e) {
        System.out.println("El archivo JSON tiene un valor numérico mal formateado");
        e.printStackTrace();
    }
      System.out.println(listaPizzas);
    return listaPizzas;
}
  
   public void escribir_informacion(List<objetos> lista_pizzas) {
        JSONObject pizzeria = new JSONObject();
        JSONArray pizzas = new JSONArray();
        // Guardamos la lista de pizzas
        for (objetos pizza : lista_pizzas) {
            JSONObject pizzaJson = new JSONObject();
            pizzaJson.put("codigo", pizza.getCodigo());
            pizzaJson.put("nombre", pizza.getNombre());
            pizzaJson.put("precio", pizza.getPrecio());
            pizzaJson.put("duracion", pizza.getDuracion());
            pizzaJson.put("tamaño", pizza.getTamano());
            pizzas.add(pizzaJson);
        }
        // Agregamos la lista de pizzas al objeto pizzeria
        pizzeria.put("Pizzeria", pizzas);
          // Leemos el contenido del archivo existente y lo agregamos a la lista
        JSONParser parser = new JSONParser();
        JSONArray pizzasExistente = new JSONArray();
        try (FileReader file = new FileReader("entrada.json")) {
            Object obj = parser.parse(file);
            JSONObject jsonObject = (JSONObject) obj;
            pizzasExistente = (JSONArray) jsonObject.get("Pizzeria");
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        pizzasExistente.addAll(pizzas);
        pizzeria.put("Pizzeria", pizzasExistente);
        // Escribimos el archivo completo
        try (FileWriter file = new FileWriter(new File("entrada.json"))) {
            file.write(pizzeria.toJSONString());
            System.out.println("Información escrita exitosamente en entrada.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
}
  
   public static void leerJSON(String rutaArchivo) {
        JSONParser parser = new JSONParser();

        try (FileReader reader = new FileReader(rutaArchivo)) {
            // Lee el archivo JSON y lo parsea a un objeto JSON
            Object obj = parser.parse(reader);
            JSONObject pizzeria = (JSONObject) obj;

            // Obtiene la lista de pizzas
            JSONArray pizzas = (JSONArray) pizzeria.get("Pizzeria");

            // Itera sobre la lista de pizzas
            for (Object pizzaObj : pizzas) {
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
            e.printStackTrace();
        }
    }

   
   public void mostrarInformacion(List<objetos> pizzas) {
    for(objetos pizza : pizzas) {
        System.out.println("Código: " + pizza.getCodigo());
        System.out.println("Nombre: " + pizza.getNombre());
        System.out.println("Precio: $" + pizza.getPrecio());
        System.out.println("Duración: " + pizza.getDuracion() + " minutos");
        System.out.println("Tamaño: " + pizza.getTamano());
        System.out.println();
    }
}

   public List<objetos> getPizzas() {
    return pizzas;
}

public void mostrarInformacion2(List<objetos> pizzas) {
    for(objetos pizza : pizzas) {
        System.out.println("Código: " + pizza.getCodigo());
        System.out.println("Nombre: " + pizza.getNombre());
        System.out.println("Precio: $" + pizza.getPrecio());
        System.out.println("Duración: " + pizza.getDuracion() + " minutos");
        System.out.println("Tamaño: " + pizza.getTamano());
        System.out.println();
    }
   
   
   
}
}




    

//========================================

    //NO APROBADOS
    /*
    public void agregar(objetos dato_entrada){
        pizza.add(dato_entrada);
    }
    public void lectura_datos() {
    JSONParser parser = new JSONParser();
    // creamos el objeto para guardar lo que se lee el FILEREADER
    try (FileReader reader = new FileReader("entrada.json")){
        Object obj = parser.parse(reader);
        // Se almacena un objeto JSON
        JSONObject jsonObjeto = (JSONObject) obj;
        // Extraer la lista JSON del objeto
        JSONArray pizzas_array = (JSONArray) jsonObjeto.get("Pizzeria");
        for(int i=0; i<pizzas_array.size(); i++){
            objetos ord_pizzas = new objetos();
            //se extrae el json del array
            JSONObject objeto_pizzas = (JSONObject) pizzas_array.get(i);
            //Se rellenan los datos correspondientes
            ord_pizzas.setCodigo(((Number) objeto_pizzas.get("codigo")).intValue());
            ord_pizzas.setNombre(((String) objeto_pizzas.get("nombre")));
            ord_pizzas.setPrecio(Double.parseDouble((String) objeto_pizzas.get("precio")));
            ord_pizzas.setDuracion(((Long) objeto_pizzas.get("duracion")).intValue());
            ord_pizzas.setTamano(((String) objeto_pizzas.get("tamaño")));
            //agregamos la pizza cargada
            System.out.println(ord_pizzas);
            this.pizza.add(ord_pizzas);
        }
    } catch (IOException | ParseException e) {
        e.printStackTrace();
    }
}*/
    