public class ClientePF extends ClienteBase {
    
    public ClientePF(TipoCliente tipoCliente){
        super(tipoCliente);
    }

    @Override
    public void exibirInformacoes(){
        System.out.println("Cliente Pessoa Fisica do tipo: " + tipoCliente.obterTipoCliente());
    }
}
