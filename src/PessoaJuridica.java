//Pessoa Jurídica é a implementação concreta da interface Tipo Cliente, retornando uma String com o tipo de cliente.

public class PessoaJuridica implements TipoCliente {

    @Override
    public String obterTipoCliente(){
        return "Pessoa Jurídica";
    }
    
}
