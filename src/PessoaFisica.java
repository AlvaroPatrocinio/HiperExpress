//Pessoa Física é a implementação concreta da interface Tipo Cliente, retornando uma String com o tipo de cliente.

public class PessoaFisica implements TipoCliente {
    
    @Override
    public String obterTipoCliente(){
        return "Pessoa Física";
    }

}
