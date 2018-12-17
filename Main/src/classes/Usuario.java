package src.classes;
import java.util.ArrayList;
import java.util.Date;

public class Usuario implements Observer{
    private String nome;
    private int notifies;
    private int codigo;
    private EmprestimoBehavior tipoEmprestimo;
    private ArrayList<Emprestimo> emprestimos;
    private ArrayList<Reserva> reservas;
    
    public Usuario(String nome, int codigo, EmprestimoBehavior tipoEmprestimo) {
        this.nome = nome;
        this.codigo = codigo;
        this.tipoEmprestimo = tipoEmprestimo;
        this.setNotifies(0);
        this.emprestimos = new ArrayList<Emprestimo>();
        this.reservas = new ArrayList<Reserva>();
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNotifies() {
		return notifies;
	}

	public void setNotifies(int notifies) {
		this.notifies = notifies;
	}

	public int getCodigo() {
        return this.codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public EmprestimoBehavior getTipoEmprestimo() {
        return this.tipoEmprestimo;
    }

    public void setTipoEmprestimo(EmprestimoBehavior tipoEmprestimo) {
        this.tipoEmprestimo = tipoEmprestimo;
    }
    
    public void emprestar(Livro livro){
        this.tipoEmprestimo.fazerEmprestimo(livro, this);
    }
    
    public void devolver(Livro livro) {
    	Emprestimo emp;
    	for(int i=0; i<emprestimos.size(); i++) {
    		emp = emprestimos.get(i);
    		if(emp.getExemplar().getCodigoLivro() == livro.getCodigo()) {
    			Date dataDevolucao = new Date();
    			emp.setDataDevolucaoReal(dataDevolucao);
    			emp.getExemplar().setStatus("disponivel");
    			System.out.println("Usuário: " + this.getNome());
    			System.out.println("Livro " + livro.getTitulo() + " devolvido com sucesso!");
    			return;
    		}
    	}
    	System.out.println("Usuário: " + this.getNome() + " não possui o livro " + livro.getTitulo() + " emprestado");
    }
    
    public void reservar(Livro livro) {
    	int numReservas = this.reservas.size();
    	if(numReservas == 3) {
    		System.out.println("Reserva negada: Usuário " + this.getNome() + " já está no limite de reservas");
    		return;
    	}
    	if(this.temReserva(livro)) {
    		System.out.println("Reserva negada: Usuário " + this.getNome() + " já possui reserva do livro " + livro.getTitulo());
    		return;
    	}
    	Reserva res = new Reserva(this, livro);
    	Date dataReserva = new Date();
    	res.setDataReserva(dataReserva);
    	this.addReserva(res);
    	livro.addReserva(this);
    	System.out.println("Reserva do livro " + livro.getTitulo() + " para " + this.getNome() + " realizada com sucesso");
    }
    
    public void removerReserva(Livro livro) {
    	Reserva res;
    	for(int i=0; i<reservas.size(); i++) {
    		res = reservas.get(i);
    		if(res.getLivro().getCodigo() == livro.getCodigo()) {
    			reservas.remove(i);
    			livro.unsetReservasAtivas();
    			livro.removeReserva(this);
    		}
    	}
    }
    
    public void addEmprestimo(Emprestimo emp) {
    	emprestimos.add(emp);
    }
    
    public void addReserva(Reserva res) {
    	reservas.add(res);
    }
    
    public boolean temDebito() {
    	Emprestimo emp;
    	for(int i=0; i<emprestimos.size(); i++) {
    		emp = emprestimos.get(i);
    		if(emp.checkDebt()) {
    			return true;
    		}
    	}
    	return false;
    }
    
    public int calcularEmprestimosAbertos() {
    	int abertos = 0;
    	Emprestimo emp;
    	for(int i=0; i<emprestimos.size(); i++) {
    		emp = emprestimos.get(i);
    		if(emp.getDataDevolucaoReal() == null) {
    			abertos++;
    		}
    	}
    	return abertos;
    }
    
    public boolean temReserva(Livro livro) {
    	Reserva res;
    	for(int i=0; i<reservas.size(); i++) {
    		res = reservas.get(i);
    		if(res.getLivro().getCodigo() == livro.getCodigo()) {
    			return true;
    		}
    	}
    	return false;
    }
    
    public boolean temEmprestado(Livro livro) {
    	Emprestimo emp;
    	for(int i=0; i<emprestimos.size(); i++) {
    		emp = emprestimos.get(i);
    		if(emp.getExemplar().getCodigoLivro() == livro.getCodigo()) {
    			return true;
    		}
    	}
    	return false;
    	
    }

	@Override
	public void update() {
		this.setNotifies(this.getNotifies() + 1);
	}
	
	public void consulta() {
		System.out.println("Usuário: " + this.getNome());
		System.out.println("Lista de empréstimos:");
		Emprestimo emp;
		for(int i=0; i<emprestimos.size(); i++) {
			emp = emprestimos.get(i);
			System.out.println("Título: " + emp.getExemplar().getLivro().getTitulo());
			System.out.println("Data do empréstimo: " + emp.getDataEmprestimo());
			if(emp.getDataDevolucaoReal() == null) {
				System.out.println("Status: em curso");
				System.out.println("Data devolução prevista: " + emp.getDataDevolucaoPrevista());
			}else {
				System.out.println("Status: finalizado");
				System.out.println("Devolvido em: " + emp.getDataDevolucaoReal());
			}
		}
		System.out.println();
		System.out.println("Lista de reservas:");
		Reserva res;
		for(int i=0; i<reservas.size(); i++) {
			System.out.println("Título: " + res.getLivro().getTitulo());
			System.out.println("Data da reserva: " + res.getDataReserva());
		}
		System.out.println();
	}
}