package src.classes;
import java.util.ArrayList;

public class Livro implements Subject{

    private String titulo;
    private int codigo;
    private String editora;
    private String autores;
    private int edicao;
	private int anoDaPublicacao;
	private int reservasAtivas;
	private ArrayList<Usuario> reservas;
	private ArrayList<Exemplar> exemplares;
	private ArrayList<Observer> observers;
	
	public Livro(String titulo, int codigo, String editora, String autores, int edicao, int anoPubli) {
		this.titulo = titulo;
		this.codigo = codigo;
		this.editora = editora;
		this.autores = autores;
		this.edicao = edicao;
		this.anoDaPublicacao = anoPubli;
		exemplares = new ArrayList<Exemplar>();
		observers = new ArrayList<Observer>();
		reservas = new ArrayList<Usuario>();
	}
	
	public void addExemplar(int codigoExemplar, String status) {
		Exemplar exemplar = new Exemplar(this, codigoExemplar, status);
		exemplares.add(exemplar);
	}
	
	public Exemplar getExemplar(int codigoExemplar) {
		return exemplares.get(codigoExemplar);
	}
	
	public Exemplar getExemplarDisponivel() {
		Exemplar exemplar;
		for(int i=0; i<exemplares.size(); i++) {
			exemplar = exemplares.get(i);
			if(exemplar.getStatus() == "Disponível") {
				return exemplar;
			}
		}
		return null;
	}
	
	public int getNumExemplaresDisponiveis() {
		Exemplar exemplar;
		int disponiveis = 0;
		for(int i=0; i<exemplares.size(); i++) {
			exemplar = exemplares.get(i);
			if(exemplar.getStatus() == "Disponível") {
				disponiveis++;
			}
		}
		return disponiveis;
	}
	
	public void addReserva(Usuario usuario) {
		reservas.add(usuario);
	}
	
	public void removeReserva(Usuario usuario) {
		Usuario usu;
		for(int i=0; i<reservas.size(); i++) {
			usu = reservas.get(i);
			if(usu.getCodigo() == usuario.getCodigo()) {
				reservas.remove(i);
				return;
			}
		}
	}

    public int getReservasAtivas() {
		return reservasAtivas;
	}

	public void setReservasAtivas() {
		this.reservasAtivas++;
		if(this.reservasAtivas>=2)notifyObservers();
	}
	
	public void unsetReservasAtivas() {
		this.reservasAtivas--;
	}

	public String getTitulo()
    {
        return this.titulo;
    }

    public void setTitulo(String titulo)
    {
        this.titulo = titulo;
    }

	public int getCodigo()
	{
		return this.codigo;
	}

	public void setCodigo(int codigo)
	{
		this.codigo = codigo;
	}

	public String getEditora()
	{
		return this.editora;
	}

	public void setEditora(String editora)
	{
		this.editora = editora;
	}
    
    public String getAutores()
	{
		return this.autores;
	}

	public void setAutores(String autores)
	{
		this.autores = autores;
	}

    public int getEdicao()
	{
		return this.edicao;
	}

	public void setEdicao(int edicao)
	{
		this.edicao = edicao;
    }
    
	public int getAnodapublicacao()
	{
		return this.anoDaPublicacao;
	}

	public void setAnodapublicacao(int anoDaPublicacao)
	{
		this.anoDaPublicacao = anoDaPublicacao;
	}

	@Override
	public void addObserver(Observer o) {
		observers.add(o);
		
	}

	@Override
	public void removeObserver(Observer o) {
		int i = observers.indexOf(o);
		if (i >= 0) {
			observers.remove(i);
		}
		
	}

	@Override
	public void notifyObservers() {
		for (Observer o : observers) {
			o.update();
		}
	}
	
	public void consulta() {
		System.out.println("T�tulo: " + this.getTitulo());
		System.out.println("Quantidade de reservas: " + this.getReservasAtivas());
		if(this.getReservasAtivas() > 0) {
			Usuario usu;
			for(int i=0; i<reservas.size(); i++) {
				usu = reservas.get(i);
				System.out.println("Reserva para: " + usu.getNome());
			}
		}
		Exemplar exemplar;
		for(int i=0; i<exemplares.size(); i++) {
			exemplar = exemplares.get(i);
			System.out.println("C�digo do exemplar: " + exemplar.getCodigoExemplar() + " -- " + "Status: " + exemplar.getStatus() );
			if(exemplar.getStatus() == "emprestado") {
				System.out.println("Autor do empr�stimo: " + exemplar.getEmprestimo().getUsuario().getNome());
				System.out.println("Data do empr�stimo: " + exemplar.getEmprestimo().getDataEmprestimo());
				System.out.println("Data de devolu��o prevista: " + exemplar.getEmprestimo().getDataDevolucaoPrevista());
			}
		}
		System.out.println();
	}

}