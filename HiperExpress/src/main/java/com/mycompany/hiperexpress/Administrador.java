package com.mycompany.hiperexpress;

/**
 * Representa um administrador, que é um tipo específico de funcionário, com informações como nome, senha e CPF.
 */
public class Administrador extends Funcionario {
    /** Nome do administrador. */
    private String nome;
    /** Senha do administrador. */
    private String senha;
    /** CPF do administrador. */
    private String cpf;

    /**
     * Construtor que inicializa um administrador com nome, senha e CPF, utilizando o construtor da classe pai (Funcionario).
     * @param nome O nome do administrador.
     * @param senha A senha do administrador.
     * @param cpf O CPF do administrador.
     */
    public Administrador(String nome, String senha, String cpf) {
        //Questão 4
        super(nome, senha, cpf);
        this.nome = nome;
        this.senha = senha;
        this.cpf = cpf;
    }
    
    /**
     * Obtém o nome do administrador.
     * @return O nome do administrador.
     */
    public String getNome() {
        return nome;
    }
    
    /**
     * Obtém a senha do administrador.
     * @return A senha do administrador.
     */
    public String getSenha() {
        return senha;
    }
    
    /**
     * Obtém o CPF do administrador.
     * @return O CPF do administrador.
     */
    public String getCPF() {
        return cpf;
    }
    
    /**
     * Define um novo nome para o administrador.
     * @param nome O novo nome do administrador.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    /**
     * Define uma nova senha para o administrador.
     * @param senha A nova senha do administrador.
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
   /**
     * Define um novo CPF para o administrador.
     * @param cpf O novo CPF do administrador.
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    /**
     * Retorna uma representação em formato de string do administrador.
     * @return Uma string representando as informações do administrador, incluindo nome, senha e CPF.
     */
    //Questão 3
    @Override
    public String toString() {
        return "Administrador{" +
                "nome='" + nome + '\'' +
                ", senha='" + senha + '\'' +
                ", cpf='" + cpf + '\'' +
                '}';
    }
}
