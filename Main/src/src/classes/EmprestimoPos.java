package src.classes;
import java.util.Calendar;
import java.util.Date;

public class EmprestimoPos implements EmprestimoBehavior{

    public void fazerEmprestimo(Livro livro, Usuario usuario){
    	if(livro.getExemplarDisponivel() == null) {
        	System.out.println("Empr�stimo n�o realizado: N�o h� exemplar dispon�vel deste livro.");
        	return;
        }
        if(usuario.temDebito()) {
        	System.out.println("Empr�stimo n�o realizado: Usu�rio possui d�bito com a biblioteca.");
        	return;
        }
        if(usuario.calcularEmprestimosAbertos() == 4) {
        	System.out.println("Empr�stimo n�o realizado: Usu�rio est� no limite de empr�stimos simult�neos.");
        	return;
        }
        if(usuario.temEmprestado(livro)) {
        	System.out.println("Empr�stimo n�o realizado: Usu�rio j� possui um exemplar deste livro em empr�stimo.");
        	return;
        }
        if((livro.getReservasAtivas() < livro.getNumExemplaresDisponiveis())
        	|| (usuario.temReserva(livro))) {
        	//faz emprestimo
        	Exemplar exemplar = livro.getExemplarDisponivel();
        	Emprestimo emp = new Emprestimo(usuario, exemplar);
        	Date dataEmprestimo = new Date();
        	emp.setDataEmprestimo(dataEmprestimo);
        	emp.setDataDevolucaoPrevista(this.calcularDataDevolucao());
        	usuario.addEmprestimo(emp);	
        	System.out.println("Empr�stimo realizado com sucesso!");
        }else {
        	System.out.println("Empr�stimo n�o realizado: Todos os exemplares dispon�veis est�o reservados.");
        	return;
        }  		 
    }
    
    public Date calcularDataDevolucao() {
    	Date dt = new Date();
    	Calendar dataDevolucao = Calendar.getInstance();
    	dataDevolucao.setTime(dt);
    	dataDevolucao.add(Calendar.DATE, 4);
    	dt = dataDevolucao.getTime();
    	return dt;
    }

}