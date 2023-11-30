package com.mycompany.hiperexpress;

/**
 * Representa um cliente com informações como nome, telefone, endereço, CPF e identificador único.
 */
public class Cliente {
    /** Nome do cliente. */
    private String nome;
    /** Número de telefone do cliente. */
    private String telefone;
    /** Endereço do cliente. */
    private String endereco;
    /** CPF do cliente. */
    private String cpf;
    /** Identificador único do cliente. */
    private int id;
    
    //Questão 11A
    /** Número total de clientes criados. */
    private static int numClientes = 0;
     //Questão 11B
      /** Número total de clientes criados, acessível mesmo por classes derivadas. */
    protected static int numClientes2 = 0;
    

    
    /**
     * Construtor padrão que incrementa o número total de clientes criados.
     */
    public Cliente() {
        numClientes++;
    }

    
    /**
     * Obtém o número total de clientes criados.
     * @return O número total de clientes criados.
     */
    public static int getNumClientes() {
        return numClientes;
    }
    

     /**
     * Construtor que inicializa um cliente com nome, telefone, endereço e CPF,
     * atribuindo um identificador único e incrementando o número total de clientes criados.
     * @param nome O nome do cliente.
     * @param telefone O número de telefone do cliente.
     * @param endereco O endereço do cliente.
     * @param cpf O CPF do cliente.
     */
    public Cliente(String nome, String telefone, String endereco, String cpf) {
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.cpf = cpf;
        this.id = numClientes;
        numClientes++;
    }

     /**
     * Edita as informações do cadastro do cliente.
     * @param novoNome O novo nome do cliente.
     * @param novoTelefone O novo número de telefone do cliente.
     * @param novoEnd O novo endereço do cliente.
     * @param novoCPF O novo CPF do cliente.
     */
    public void editarCadastro(String novoNome, String novoTelefone, String novoEnd, String novoCPF) {
        this.nome = novoNome;
        this.telefone = novoTelefone;
        this.endereco = novoEnd;
        this.cpf = novoCPF;
    }
    
    /**
     * Obtém o número total de clientes criados, acessível mesmo por classes derivadas.
     * @return O número total de clientes criados.
     */
      public static int getNumClientes2() {
        return numClientes2;
    }
      
    // Getters e setters para os atributos da classe
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    

    /**
    * Retorna uma representação em formato de string do cliente.
    * @return Uma string representando as informações do cliente, incluindo nome, telefone, endereço, CPF e identificador único.
    */
    //Questão 3
    @Override
    public String toString() {
        return "Cliente{" + "nome=" + nome + ", telefone=" + telefone + ", endereco=" + endereco + ", cpf=" + cpf + ", id=" + id + '}';
    }

}
