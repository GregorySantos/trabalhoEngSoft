public class Livro{

    private String titulo;
    private int codigo;
    private String editora;
    private String autores;
    private int edicao;
	private int anoDaPublicacao;
	private Usuario dono;
	private int devolucao;
	private int reserva;

	public Usuario getDono() {
		return this.dono;
	}

	public void setDono(Usuario dono) {
		this.dono = dono;
	}

	public int getDevolucao() {
		return this.devolucao;
	}

	public void setDevolucao(int devolucao) {
		this.devolucao = devolucao;
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

}