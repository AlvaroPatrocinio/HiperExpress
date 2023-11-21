//Cliente PJ é uma classe que estende 'ClienteBase'.

public class ClientePJ extends ClienteBase {

    public ClientePJ(TipoCliente tipoCliente) {
        super(tipoCliente);
            }

    //Foi implementado o método 'Exibir Informações' que utiliza a implementação de 'Tipo Cliente' para exibir informações específicas sobre o cliente.
    @Override
    public void exibirInformacoes(){
        System.out.println("Cliente Pessoa Jurídica do tipo: " + tipoCliente.obterTipoCliente());
    }
    
}
