import java.util.Calendar;
import java.util.Date;

public class EmprestimoGraduacao implements EmprestimoBehavior{

    public void fazerEmprestimo(Livro livro, Usuario usuario){
        if(livro.getExemplarDisponivel() == null) {
        	return;
        }
        if(usuario.temDebito()) {
        	return;
        }
        if(usuario.calcularEmprestimosAbertos() == 3) {
        	return;
        }
        if(usuario.temEmprestado(livro)) {
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
        }else {
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