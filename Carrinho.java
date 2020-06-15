import java.util.LinkedList;

public class Carrinho implements AddProductObserver {
    private static Carrinho instanciaCarrinho;
    private LinkedList<Produto> carrinho;
    private double valorTotal;

    private Carrinho() {
        carrinho = new LinkedList<Produto>();
        valorTotal = 0;
    }

    public static Carrinho getInstance(boolean n) {
        if (instanciaCarrinho == null || n) {
            instanciaCarrinho = new Carrinho();
        }
        return instanciaCarrinho;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    @Override
    public void addProduct(AddProductEvent event) {
        Produto p = event.getProduto();
        carrinho.add(p);
        valorTotal += p.getPreco();
    }


    public String toString() {
        String s = "";
        for (Produto p : carrinho) {
            s += p.toString();
        }
        s += "\nValor total: " + getValorTotal();
        return s;
    }
}
