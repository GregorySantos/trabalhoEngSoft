import java.util.ArrayList;

public class Biblioteca{

    private ArrayList<Livro> acervo;
    private ArrayList<Usuario> usuarios;
    
    public Biblioteca() {
    	acervo = new ArrayList<Livro>();
    	usuarios = new ArrayList<Usuario>();
    }
    
    public void addLivro(Livro livro) {
    	acervo.add(livro);
    }
    
    public void addUsuario(Usuario usuario) {
    	usuarios.add(usuario);
    }
    
    public Usuario getUserById(int id) {
    	Usuario user;
    	for(int i=0; i<usuarios.size(); i++) {
    		user = usuarios.get(i);
    		if(user.getCodigo() == id) {
    			return user;
    		}
    	}
    	return null;
    }
    
    public Livro getLivroById(int id) {
    	Livro book;
    	for(int i=0; i<acervo.size(); i++) {
    		book = acervo.get(i);
    		if(book.getCodigo() == id) {
    			return book;
    		}
    	}
    	return null;
    }

    public void efetuarEmprestimo(int codigoUsuario, int codigoLivro){
    	Usuario user = this.getUserById(codigoUsuario);
    	Livro livro = this.getLivroById(codigoLivro);  	
    	user.emprestar(livro);
    } 
}