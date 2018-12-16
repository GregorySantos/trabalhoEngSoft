package src.classes;
import java.util.Calendar;
import java.util.Date;

public class EmprestimoGraduacao implements EmprestimoBehavior{

    public void fazerEmprestimo(Livro livro, Usuario usuario){
        if(livro.getExemplarDisponivel() == null) {
        	System.out.println("Empr�stimo n�o realizado: N�o h� exemplar dispon�vel do livro " + livro.getTitulo());
        	return;
        }
        if(usuario.temDebito()) {
        	System.out.println("Empr�stimo n�o realizado: Usu�rio " + usuario.getNome() + " possui d�bito com a biblioteca.");
        	return;
        }
        if(usuario.calcularEmprestimosAbertos() == 3) {
        	System.out.println("Empr�stimo n�o realizado: Usu�rio " + usuario.getNome() + " est� no limite de empr�stimos simult�neos.");
        	return;
        }
        if(usuario.temEmprestado(livro)) {
        	System.out.println("Empr�stimo n�o realizado: Usu�rio " + usuario.getNome() + " j� possui um exemplar do livro " + livro.getTitulo() + " em empr�stimo.");
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
        	exemplar.setStatus("emprestado");
        	usuario.addEmprestimo(emp);
        	if(usuario.temReserva(livro)) {
        		usuario.removerReserva(livro);
        	}
        	System.out.println("Empr�stimo do livro " + livro.getTitulo() + " para usu�rio(a) " + usuario.getNome() + " realizado com sucesso!");
        }else {
        	System.out.println("Empr�stimo n�o realizado: Todos os exemplares dispon�veis do livro " + livro.getTitulo() + " est�o reservados.");
        	return;
        }  		
    }
    
    public Date calcularDataDevolucao() {
    	Date dt = new Date();
    	Calendar dataDevolucao = Calendar.getInstance();
    	dataDevolucao.setTime(dt);
    	dataDevolucao.add(Calendar.DATE, 3);
    	dt = dataDevolucao.getTime();
    	return dt;
    }

}