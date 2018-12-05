public class Biblioteca{

    //acesso pelo código
    private Livro exemplares[];
    private Usuario usuarios[];

    public Void EfetuarEmprestimo(Int idLivro, Int idUsuario){
        this.usuarios[idUsuario].emprestar(exemplares[idLivro]);
    } 
}