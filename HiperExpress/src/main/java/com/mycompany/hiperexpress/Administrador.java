
package com.mycompany.hiperexpress;

public class Administrador extends Funcionario {
    
    private boolean adm;
    
    
    public Administrador(String nome, String senha, String CPF){
        super(nome, senha, CPF);
        this.setAdm(true);
    }
    
    
       public boolean isAdm() {
       return adm;
    }

    public void setAdm(boolean adm) {
        this.adm = adm;
    }
    
    

    @Override
    public String toString() {
        return "\n------------------------------------------------------------------------"+""
             + "\nNOME = " + this.getNome() + ""
             + "\nSENHA = " + this.getSenha() + ""
             + "\nCPF = " + this.getCPF() + ""
             + "\nADMINSTRADOR = " + this.isAdm()+'\n' + '\n'+
                "------------------------------------------------------------------------";

  }
}

