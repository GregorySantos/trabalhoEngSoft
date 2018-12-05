public class Usuario{

    private String nome;
    private Int codigo;
    private EmprestimoBehavior tipoEmprestimo;

    

    public Usuario(String nome, Int codigo, EmprestimoBehavior tipoEmprestimo) {
        this.nome = nome;
        this.codigo = codigo;
        this.tipoEmprestimo = tipoEmprestimo;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Int getCodigo() {
        return this.codigo;
    }

    public void setCodigo(Int codigo) {
        this.codigo = codigo;
    }

    public EmprestimoBehavior getTipoEmprestimo() {
        return this.tipoEmprestimo;
    }

    public void setTipoEmprestimo(EmprestimoBehavior tipoEmprestimo) {
        this.tipoEmprestimo = tipoEmprestimo;
    }
    
    public void emprestar(Livro livro){
        this.tipoEmprestimo.fazerEmprestimo(livro);
    }
}