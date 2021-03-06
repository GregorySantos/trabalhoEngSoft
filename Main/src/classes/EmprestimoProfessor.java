package src.classes;
import java.util.Calendar;
import java.util.Date;

public class EmprestimoProfessor implements EmprestimoBehavior{

    public void fazerEmprestimo(Livro livro, Usuario usuario){
    	if(livro.getExemplarDisponivel() == null) {
    		System.out.println("Empr�stimo n�o realizado: N�o h� exemplar dispon�vel do livro " + livro.getTitulo());
        	return;
        }
        if(usuario.temDebito()) {
        	System.out.println("Empr�stimo n�o realizado: Usu�rio " + usuario.getNome() + " possui d�bito com a biblioteca.");
        	return;
        }        
        //faz emprestimo
        Exemplar exemplar = livro.getExemplarDisponivel();
        Emprestimo emp = new Emprestimo(usuario, exemplar);
        Date dataEmprestimo = new Date();
        emp.setDataEmprestimo(dataEmprestimo);
        emp.setDataDevolucaoPrevista(this.calcularDataDevolucao());
        exemplar.setStatus("emprestado");
        exemplar.setEmprestimo(emp);
        usuario.addEmprestimo(emp);	
        System.out.println("Empr�stimo do livro " + livro.getTitulo() + " para usu�rio(a) " + usuario.getNome() + " realizado com sucesso!"); 
    }
    
    public Date calcularDataDevolucao() {
    	Date dt = new Date();
    	Calendar dataDevolucao = Calendar.getInstance();
    	dataDevolucao.setTime(dt);
    	dataDevolucao.add(Calendar.DATE, 7);
    	dt = dataDevolucao.getTime();
    	return dt;
    }

}