//Classe MAIN

public class App {
    public static void main(String[] args) throws Exception {

        //Na classe main for instanciado diferentes tipos de implementações, usando as mesmas para criar objetos das classes concretas, PJ e PF.
        TipoCliente PessoaFisica = new PessoaFisica();
        TipoCliente PessoaJuridica = new PessoaJuridica();

        Cliente ClientePF = new ClientePF(PessoaFisica);
        Cliente ClientePJ = new ClientePJ(PessoaJuridica);

        //Assim foi chamado o método de exibir informações. 
        ClientePF.exibirInformacoes();
        ClientePJ.exibirInformacoes();

    }
}
