public class Biblioteca{

    //acesso pelo código
    private Livro exemplares[];
    private Usuario usuarios[];

    public void EfetuarEmprestimo(int idLivro, int idUsuario){
        this.usuarios[idUsuario].emprestar(exemplares[idLivro]);
    } 
}