package com.mycompany.hiperexpress;

/**
 * Representa informações de acesso, incluindo nome, ID e senha.
 */
public class Acesso {
    
    /** Nome associado ao acesso. */
    private String nome;
    /** ID associado ao acesso. */
    private String id;
     /** Senha associada ao acesso. */
    private String senha;
    
    
     /**
     * Construtor padrão que inicializa a classe sem parâmetros.
     */
    public Acesso(){
    this.nome = nome;
    this.id = id;
    this.senha = senha;
}
    
    /**
     * Obtém o nome associado ao acesso.
     * @return O nome associado ao acesso.
     */
    public String getNome() {
        return nome;
    }
    
     /**
     * Define um novo nome associado ao acesso.
     * @param nome O novo nome associado ao acesso.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém o ID associado ao acesso.
     * @return O ID associado ao acesso.
     */
    public String getId() {
        return id;
    }
    
    /**
     * Define um novo ID associado ao acesso.
     * @param id O novo ID associado ao acesso.
     */
    public void setId(String id) {
        this.id = id;
    }
    
    /**
     * Obtém a senha associada ao acesso.
     * @return A senha associada ao acesso.
     */
    public String getSenha() {
        return senha;
    }
    
    /**
     * Define uma nova senha associada ao acesso.
     * @param senha A nova senha associada ao acesso.
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    /**
     * Retorna uma representação em formato de string das informações de acesso.
     * @return Uma string representando as informações de acesso, incluindo nome, ID e senha.
     */
    @Override
    public String toString() {
    return String.format("""
                         Acesso: {
                           Nome: '%s',
                           ID: %.2f,
                         Senha: '%s',
                         }""",
        nome, senha, id
    );
}}
