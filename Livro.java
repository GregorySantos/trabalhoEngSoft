public class Livro{

    private String titulo;
    private Int codigo;
    private String editora;
    private String autores;
    private Int edicao;
    private Int anoDaPublicacao;

    public String getTitulo()
    {
        return this.titulo;
    }

    public void setTitulo(String titulo)
    {
        this.titulo = titulo;
    }

	public Int getCodigo()
	{
		return this.codigo;
	}

	public void setCodigo(Int codigo)
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

    public Int getEdicao()
	{
		return this.edicao;
	}

	public void setEdicao(Int edicao)
	{
		this.edicao = edicao;
    }
    
	public Int getAnodapublicacao()
	{
		return this.anoDaPublicacao;
	}

	public void setAnodapublicacao(Int anoDaPublicacao)
	{
		this.anoDaPublicacao = anoDaPublicacao;
	}

}