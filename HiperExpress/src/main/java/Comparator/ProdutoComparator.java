package Comparator;
import java.util.Comparator;
import com.mycompany.hiperexpress.Produto;

public class ProdutoComparator implements Comparator<Produto> {
    
     @Override
    public int compare(Produto produto1, Produto produto2) {
        
        // Comparação pelo nome do produto
        return produto1.getNome().compareToIgnoreCase(produto2.getNome());
        
        
    }
}

