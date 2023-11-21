//Cliente base é uma classe abstrata que implementa a interface 'Cliente'. 
public abstract class ClienteBase implements Cliente {
    
    //Ela contem um campo 'TipoCliente.

    protected TipoCliente tipoCliente;

    //Foi realizado a implementação de um construtor que recebe uma instância de 'TipoCliente' para inicializar esse campo.
    public ClienteBase(TipoCliente tipoCliente){
        this.tipoCliente = tipoCliente;
            }
    
}
