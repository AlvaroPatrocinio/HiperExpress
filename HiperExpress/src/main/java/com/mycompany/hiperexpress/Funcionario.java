package com.mycompany.hiperexpress;

/**
 * Representa um funcionário com informações como nome, senha, CPF e cargo.
 */
public class Funcionario {
   /** Nome do funcionário. */
   private String nome;
   /** Senha do funcionário. */
   private String senha;
   /** CPF do funcionário. */
   private String CPF;
   /** Cargo do funcionário. */
   private String cargo;

    /**
     * Construtor que inicializa um funcionário com nome, senha e CPF.
     * O cargo é definido como nulo.
     * @param nome O nome do funcionário.
     * @param senha A senha do funcionário.
     * @param CPF O CPF do funcionário.
     */
    public Funcionario(String nome, String senha, String CPF) {
        this.nome = nome;
        this.senha = senha;
        this.CPF = CPF;
    }
    /**
     * Construtor que inicializa um funcionário com nome, senha, CPF e cargo.
     * @param nome O nome do funcionário.
     * @param senha A senha do funcionário.
     * @param CPF O CPF do funcionário.
     * @param cargo O cargo do funcionário.
     */
    public Funcionario(String nome, String senha, String CPF, String cargo) {
        this.nome = nome;
        this.senha = senha;
        this.CPF = CPF;
        this.cargo = cargo;
    }
    
     /**
     * Obtém o nome do funcionário.
     * @return O nome do funcionário.
     */
    public String getNome() {
        return nome;
    }
    
     /**
     * Define um novo nome para o funcionário.
     * @param nome O novo nome do funcionário.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    /**
     * Obtém a senha do funcionário.
     * @return A senha do funcionário.
     */
    public String getSenha() {
        return senha;
    }
    
    /**
     * Define uma nova senha para o funcionário.
     * @param senha A nova senha do funcionário.
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    /**
     * Obtém o CPF do funcionário.
     * @return O CPF do funcionário.
     */
    public String getCPF() {
        return CPF;
    }

     /**
     * Define um novo CPF para o funcionário.
     * @param CPF O novo CPF do funcionário.
     */    
    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

     /**
     * Obtém o cargo do funcionário.
     * @return O cargo do funcionário.
     */
    public String getCargo() {
        return cargo;
    }
    
     /**
     * Define um novo cargo para o funcionário.
     * @param cargo O novo cargo do funcionário.
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
    
     /**
     * Representação em formato de string do funcionário.
     * @return Uma string representando o funcionário.
     */
    //Questão 3
    @Override
    public String toString() {
        return "Funcionario{" + "nome=" + nome + ", senha=" + senha + ", CPF=" + CPF + ", cargo=" + cargo + '}';
    }
   
}
