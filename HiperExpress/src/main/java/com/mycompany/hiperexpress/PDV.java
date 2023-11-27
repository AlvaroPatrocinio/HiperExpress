package com.mycompany.hiperexpress;
import java.util.HashMap;
import java.util.Map;
import java.util.Date;
import java.util.List;
  import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;


public class PDV {
    private Caixa caixa;
    private Map<Date, Double> fechamentoDiario;
    private double fechamentoMensal;
    private Funcionario operador;
    private List<Venda> vendas;
    
    
    public PDV(Caixa caixa, Funcionario operador) {
        this.caixa = caixa;
        this.operador = operador;
        this.fechamentoDiario = new HashMap<>();
        this.fechamentoMensal = 0.0;
    }
    
     public void realizarFechamentoDiario() {
         int totalVendas = 0;
         for (Venda venda : vendas) {
            Date dataVenda = venda.getDataVenda();
                if (mesmaData(new Date(), dataVenda)) {
                    totalVendas += venda.calcularTotalVenda();
            }
        }
        System.out.println("Fechamento diário realizado para o caixa " + caixa.getNumero());
        System.out.println("Total de vendas no dia: " + totalVendas);
        
        //Casting no (double), convertendo totalVendas para double
        fechamentoDiario.put(new Date(), (double) totalVendas);
     }

    public void realizarFechamentoMensal() {
        // precisa implementar
        
        System.out.println("Fechamento mensal: ");
          
    }

    public int getCaixa() {
        return caixa.getNumero();
    }

    public void setCaixa(Caixa caixa) {
        this.caixa = caixa;
    }
   
   public Funcionario getOperador(){
       return operador;
   }
   
   public void setOperador(Funcionario operador){
       this.operador = operador;
   }
   

    private boolean mesmaData(Date date1, Date date2) {
        
        // Converte data1 em um instante,
        // Depois adiciona o fuso horario padrão da nossa zona 
        // E converte em LocalDate
        LocalDate localDate1 = date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate localDate2 = date2.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        //Compara o instante 1 com o instante 2
        return localDate1.isEqual(localDate2);
}

}
