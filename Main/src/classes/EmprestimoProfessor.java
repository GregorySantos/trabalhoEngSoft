package Main.src.classes;

import java.util.Calendar;
import java.util.Date;

public class EmprestimoProfessor implements EmprestimoBehavior{

    public void fazerEmprestimo(Livro livro, Usuario usuario){
    	if(livro.getExemplarDisponivel() == null) {
        	System.out.println("Empréstimo não realizado: Não há exemplar disponível deste livro.");
        	return;
        }
        if(usuario.temDebito()) {
        	System.out.println("Empréstimo não realizado: Usuário possui débito com a biblioteca.");
        	return;
        }        
        //faz emprestimo
        Exemplar exemplar = livro.getExemplarDisponivel();
        Emprestimo emp = new Emprestimo(usuario, exemplar);
        Date dataEmprestimo = new Date();
        emp.setDataEmprestimo(dataEmprestimo);
        emp.setDataDevolucaoPrevista(this.calcularDataDevolucao());
        usuario.addEmprestimo(emp);	
        System.out.println("Empréstimo realizado com sucesso!");		 
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