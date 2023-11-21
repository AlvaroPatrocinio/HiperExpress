public class ClientePJ extends ClienteBase {

    public ClientePJ(TipoCliente tipoCliente) {
        super(tipoCliente);
            }

    @Override
    public void exibirInformacoes(){
        System.out.println("Cliente Pessoa Jurídica do tipo: " + tipoCliente.obterTipoCliente());
    }
    
}
