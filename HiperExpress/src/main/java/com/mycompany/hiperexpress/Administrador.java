
package com.mycompany.hiperexpress;

public class Administrador extends Funcionario {
    private boolean adm;
    
    public Administrador(String nome, String senha, int id){
        super(nome, senha, id);
        this.adm = true;
    }

    public boolean isAdm() {
        return adm;
    }

    public void setAdm(boolean adm) {
        this.adm = adm;
    }
    
    
    @Override
    public String toString() {
    return String.format("""
                         ADM {
                           Nome: '%s',
                           senha: %.2f,
                           iID: '%s',
                           adm: %d
                         }""",
        this.getNome(), this.getSenha(), this.getId(), this.isAdm()
    );
  }
}

