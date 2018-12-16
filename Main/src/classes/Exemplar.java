package src.classes;

public class Exemplar {
	private Livro livro;
	private int codigoExemplar;
	private String status;

	
	public Exemplar(Livro livro, int codigoExemplar, String status) {
		this.livro = livro;
		this.codigoExemplar = codigoExemplar;
		this.status = status;
	}
	
	public int getCodigoLivro() {
		return livro.getCodigo();
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public int getCodigoExemplar() {
		return codigoExemplar;
	}

	public void setCodigoExemplar(int codigoExemplar) {
		this.codigoExemplar = codigoExemplar;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
	
}
