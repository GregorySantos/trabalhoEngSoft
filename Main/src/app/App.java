package src.app;

import src.classes.Livro;
import src.classes.Usuario;
import src.classes.Biblioteca;
import src.classes.EmprestimoGraduacao;
import src.classes.EmprestimoPos;
import src.classes.EmprestimoProfessor;

public class App {
    public static void main(String[] args) throws Exception {
    	
        System.out.println("Bem vindo a nossa biblioteca! Por favor digite um comando:");
        Biblioteca biblioteca = Biblioteca.getInstancia();
        Livro liv = new Livro ("Engenharia de Software", 100, "Addison Wesley", "Ian Sommervile", 6, 2000);
        liv.addExemplar(1, "Disponível");
        liv.addExemplar(2, "Disponível");
        biblioteca.addLivro(liv);
        liv = new Livro("UML - Guia do Usuário", 101, "Campus", "Grady Booch, James Rumbaugh, Ivar Jacobson", 7, 2000);
        liv.addExemplar(3, "Disponível");
        biblioteca.addLivro(liv);
        liv = new Livro("Code Complete", 200, "microsoft Press", "Steve McConnell", 2, 2014);
        liv.addExemplar(4, "Disponível");
        biblioteca.addLivro(liv);
        liv = new Livro("Agile Software Developmente, Principles, Patterns and Practrices", 201, "Prentice Hall", "Robert Martin", 1,2002);
        liv.addExemplar(5, "Disponível");
        biblioteca.addLivro(liv);
        liv = new Livro("Refactoring: Improving the Design of Existing Code", 300, "Addison-Wesley Professional", "Martin Fowler", 1, 1999);
        liv.addExemplar(6, "Disponível");
        liv.addExemplar(7, "Disponível");
        biblioteca.addLivro(liv);
        liv = new Livro("Software Metrics: A Rigorous and Practical Approach", 301, "CRC Press", "Norman Fenton, James Bieman", 3, 2014);
        biblioteca.addLivro(liv);
        liv = new Livro("Design Patterns: Elements of Reusable Object-Oriented Software", 400, "Addison-Wesley Professional", "Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides", 1, 1994);
        liv.addExemplar(8, "Disponível");
        liv.addExemplar(9, "Disponível");
        biblioteca.addLivro(liv);
        liv = new Livro("UML Distilled: A Brief Guide to the Standard Object Modeling Language", 401, "Addison-Wesley Professional", "Martin Fowler", 3, 2003);
        biblioteca.addLivro(liv);
        
        Usuario usu = new Usuario("João da Silva" , 123, new EmprestimoGraduacao());
        biblioteca.addUsuario(usu);
        usu = new Usuario("Luiz Fernando Rodrigues" , 456, new EmprestimoPos());
        biblioteca.addUsuario(usu);
        usu = new Usuario("Pedro Paulo" , 789, new EmprestimoGraduacao());
        biblioteca.addUsuario(usu);
        usu = new Usuario("Carlos Lucena", 100, new EmprestimoProfessor());
        biblioteca.addUsuario(usu);
        
        while(biblioteca.getCommand());
        
        System.out.println("Obrigado por utilizar nossa biblioteca!");
        


       
    }
}