public class App {
    public static void main(String[] args) throws Exception {

        TipoCliente PessoaFisica = new PessoaFisica();
        TipoCliente PessoaJuridica = new PessoaJuridica();

        Cliente ClientePF = new ClientePF(PessoaFisica);
        Cliente ClientePJ = new ClientePJ(PessoaJuridica);

        ClientePF.exibirInformacoes();
        ClientePJ.exibirInformacoes();

    }
}
