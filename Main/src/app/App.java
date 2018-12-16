package src.app;

import src.classes.Biblioteca;


public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello Java");
        Biblioteca biblioteca = Biblioteca.getInstancia();
        while(biblioteca.getCommand());
        
        System.out.println("Obrigado por utilizar nossa biblioteca!");
        


       
    }
}