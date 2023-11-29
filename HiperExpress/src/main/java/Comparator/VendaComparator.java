package Comparator;
import com.mycompany.hiperexpress.Venda;
import java.util.Comparator;


public class VendaComparator implements Comparator<Venda.ItemVenda> {

    @Override
    public int compare(Venda.ItemVenda item1, Venda.ItemVenda item2) {
        // Comparação pela quantidade vendida (em ordem decrescente)
        return Integer.compare(item2.getQuantidade(), item1.getQuantidade());
    }
}
