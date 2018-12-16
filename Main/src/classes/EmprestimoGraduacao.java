package src.classes;
import java.util.Calendar;
import java.util.Date;

public class EmprestimoGraduacao implements EmprestimoBehavior{

    public void fazerEmprestimo(Livro livro, Usuario usuario){
        if(livro.getExemplarDisponivel() == null) {
        	System.out.println("Empréstimo não realizado: Não há exemplar disponível do livro " + livro.getTitulo());
        	return;
        }
        if(usuario.temDebito()) {
        	System.out.println("Empréstimo não realizado: Usuário " + usuario.getNome() + " possui débito com a biblioteca.");
        	return;
        }
        if(usuario.calcularEmprestimosAbertos() == 3) {
        	System.out.println("Empréstimo não realizado: Usuário " + usuario.getNome() + " está no limite de empréstimos simultâneos.");
        	return;
        }
        if(usuario.temEmprestado(livro)) {
        	System.out.println("Empréstimo não realizado: Usuário " + usuario.getNome() + " já possui um exemplar do livro " + livro.getTitulo() + " em empréstimo.");
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
        	System.out.println("Empréstimo do livro " + livro.getTitulo() + " para usuário(a) " + usuario.getNome() + " realizado com sucesso!");
        }else {
        	System.out.println("Empréstimo não realizado: Todos os exemplares disponíveis do livro " + livro.getTitulo() + " estão reservados.");
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