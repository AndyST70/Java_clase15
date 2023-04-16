/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo15;
import archivos.lector;
import java.util.ArrayList;
import java.util.List;

public class Ejemplo15 {
    public static void main(String[] args) {
    
        // Inicio del código
        
        //ventanas creadas
        inicio ventana = new inicio();
        ventana.setVisible(true);     
        
        
        
 //========================================================
        //traemos el lector de json
         lector miLector = new lector();
         //metemos datos
         
  
        //mostramos los datos guardados
        List<objetos> pizzas = miLector.getPizzas();
        miLector.mostrarInformacion(pizzas);
       
        
               
        // Creamos una lista de pizzas
      
        List<objetos> lista_pizzas = new ArrayList<>();
        objetos pizza1 = new objetos(5, "Pizza de pepperoni", 12.99, 30, "Mediana");
        objetos pizza2 = new objetos(6, "Pizza margarita", 10.99, 25, "Grande");
        objetos pizza3 = new objetos(7, "Pizza piña", 32, 25, "Grande");
        
        lista_pizzas.add(pizza1);
        lista_pizzas.add(pizza2);
        lista_pizzas.add(pizza3);
        
        
        
        // Llamamos al método escribir_informacion de la instancia de la clase lector creada anteriormente
        miLector.escribir_informacion(lista_pizzas);
        List<objetos> pizzas2 = miLector.getPizzas();
         miLector.mostrarInformacion(pizzas2);
        
    }
    
    
        
}