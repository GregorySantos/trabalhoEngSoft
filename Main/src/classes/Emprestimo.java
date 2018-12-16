package src.classes;

import java.util.Date;

public class Emprestimo {
	private Usuario usuario;
	private Exemplar exemplar;
	private Date dataEmprestimo;
	private Date dataDevolucaoPrevista;
	private Date dataDevolucaoReal;
	
	public Emprestimo(Usuario usuario, Exemplar exemplar) {
		this.usuario = usuario;
		this.exemplar = exemplar;
		this.dataDevolucaoReal = null;
	}
	
	public Date getDataEmprestimo() {
		return dataEmprestimo;
	}
	public void setDataEmprestimo(Date dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}
	public Date getDataDevolucaoPrevista() {
		return dataDevolucaoPrevista;
	}
	public void setDataDevolucaoPrevista(Date dataDevolucaoPrevista) {
		this.dataDevolucaoPrevista = dataDevolucaoPrevista;
	}
	public Date getDataDevolucaoReal() {
		return dataDevolucaoReal;
	}
	public void setDataDevolucaoReal(Date dataDevolucaoReal) {
		this.dataDevolucaoReal = dataDevolucaoReal;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Exemplar getExemplar() {
		return exemplar;
	}

	public void setExemplar(Exemplar exemplar) {
		this.exemplar = exemplar;
	}

	public boolean checkDebt() {
		Date agora = new Date();
		if(this.dataDevolucaoReal == null && this.dataDevolucaoPrevista.before(agora)) {
			return true;
		}
		return false;
	}
	
	

}
