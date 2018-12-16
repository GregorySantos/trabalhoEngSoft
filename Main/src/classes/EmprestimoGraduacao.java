package classes;
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
        if(livro.getReservasAtivas() < livro.getNumExemplaresDisponiveis()) {
        	//faz emprestimo
        }else if(usuario.temReserva(livro)) {
        	//faz emprestimo
        }else {
        	return;
        }  		
    }

}