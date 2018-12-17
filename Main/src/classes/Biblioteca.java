package src.classes;

import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {

	private ArrayList<Livro> acervo;
	private ArrayList<Usuario> usuarios;
	private static Biblioteca instancia;

	private Biblioteca() {
		acervo = new ArrayList<Livro>();
		usuarios = new ArrayList<Usuario>();
	}

	public static Biblioteca getInstancia() {
		if (instancia == null) {
			instancia = new Biblioteca();
		}
		return instancia;
	}

	public void addLivro(Livro livro) {
		acervo.add(livro);
	}

	public void addUsuario(Usuario usuario) {
		usuarios.add(usuario);
	}

	public Usuario getUserById(int id) {
		Usuario user;
		for (int i = 0; i < usuarios.size(); i++) {
			user = usuarios.get(i);
			if (user.getCodigo() == id) {
				return user;
			}
		}
		return null;
	}

	public Livro getLivroById(int id) {
		Livro book;
		for (int i = 0; i < acervo.size(); i++) {
			book = acervo.get(i);
			if (book.getCodigo() == id) {
				return book;
			}
		}
		return null;
	}

	public boolean getCommand() {
		Scanner scanner = new Scanner(System.in);
		String command = scanner.next();
		int usu, liv;
		switch (command) {
		case "emp":
			usu = scanner.nextInt();
			liv = scanner.nextInt();
			this.efetuarEmprestimo(usu, liv);
			return true;
		case "dev":
			usu = scanner.nextInt();
			liv = scanner.nextInt();
			this.efetuarDevolucao(usu, liv);
			return true;
		case "res":
			usu = scanner.nextInt();
			liv = scanner.nextInt();
			this.efetuarReserva(usu, liv);
			return true;

		case "obs":
			usu = scanner.nextInt();
			liv = scanner.nextInt();
			this.criaObserver(usu, liv);
			return true;

		case "liv":
			liv = scanner.nextInt();
			this.consultaLivro(liv);
			return true;
		case "usu":
			usu = scanner.nextInt();
			this.consultaUsuario(usu);
			return true;

		case "ntf":
			usu = scanner.nextInt();
			this.getNotifies(usu);
			return true;
		default:
			scanner.close();
			return false;
		}

	}

	public void efetuarEmprestimo(int codigoUsuario, int codigoLivro) {
		Usuario user = this.getUserById(codigoUsuario);
		Livro livro = this.getLivroById(codigoLivro);
		user.emprestar(livro);
	}

	private void consultaLivro(int liv) {
		Livro livro = this.getLivroById(liv);
		livro.consulta();
	}

	private void consultaUsuario(int usu) {
		Usuario user = this.getUserById(usu);
		user.consulta();
	}

	private void getNotifies(int usu) {
		Usuario user = this.getUserById(usu);
		Integer not = user.getNotifies();
		System.out.println("Vezes que foi notificado: "+not);
	}

	private void criaObserver(int usu, int liv) {
		Usuario user = this.getUserById(usu);
		Livro livro = this.getLivroById(liv);
		livro.addObserver(user);
	}

	private void efetuarDevolucao(int usu, int liv) {
		Usuario user = this.getUserById(usu);
		Livro livro = this.getLivroById(liv);
		user.devolver(livro);
	}

	private void efetuarReserva(int usu, int liv) {
		Usuario user = this.getUserById(usu);
		Livro livro = this.getLivroById(liv);
		user.reservar(livro);
	}
}