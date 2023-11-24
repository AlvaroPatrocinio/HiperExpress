package com.mycompany.hiperexpress;
import java.util.HashMap;
import java.util.Map;
import java.util.Date;
import java.util.List;


public class PDV {
    private int numeroCaixa;
    private Map<Date, Double> fechamentoDiario;
    private double fechamentoMensal;
    private Funcionario operador;
    private List<Venda> vendas;
    
    
    public PDV(int numeroCaixa, Funcionario operador) {
        this.numeroCaixa = numeroCaixa;
        this.operador = operador;
        this.fechamentoDiario = new HashMap<>();
        this.fechamentoMensal = 0.0;
    }
    
     public void realizarFechamentoDiario() {
        double totalVendas = 0;
        for (Venda venda : vendas) {
            
        }
            Date dataVenda = venda.getData();
            if(isSameDay(data, dataVenda)) {
                totalVendas += venda.getValorTotal();
                
                System.out.println("Fechamento diário realizado para o caixa " + numeroCaixa);
    }

    public void realizarFechamentoMensal() {
        //adicionar fechamento quando pronto
        
                System.out.println("Fechamento mensal realizado para o caixa " + numeroCaixa);
    }

    public int getNumeroCaixa() {
        return numeroCaixa;
    }

    public void setNumeroCaixa(int num) {
        this.numeroCaixa = numeroCaixa;
    }
   
   public Funcionario getOperador(){
       return operador;
   }
   
   public void setOpeardor(Funcionario Operador){
       this.operador = operador;
   }
}
