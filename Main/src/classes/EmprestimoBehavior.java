
package src.classes;


import java.util.Date;

public interface EmprestimoBehavior{
   public void fazerEmprestimo(Livro livro, Usuario usuario);
   public Date calcularDataDevolucao();
}