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
    	System.out.println("Reserva do livro " + livro.getTitulo() + " para " + this.getNome() + " realizada com sucesso");
    }
    
    public void removerReserva(Livro livro) {
    	Reserva res;
    	for(int i=0; i<reservas.size(); i++) {
    		res = reservas.get(i);
    		if(res.getLivro().getCodigo() == livro.getCodigo()) {
    			reservas.remove(i);
    			livro.unsetReservasAtivas();
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
}