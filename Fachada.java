import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Fachada {

    private final List<AddProductObserver> observer = new ArrayList<>();
    private Scanner sc;

    public void addAddProductObserver(AddProductObserver observer) {
        this.observer.add(observer);
    }

    public Fachada() {
        sc = new Scanner(System.in);
    }

    public void finaliza() {
        FactoryPagamento pagamento = new FactoryPagamento();
        while(true) {
            System.out.println("Preco total: " + Carrinho.getInstance(false).getValorTotal());
            System.out.println("Escolha o metodo de pagamento:\n1 - Cartão de Débito\n2 - Cartão de Crédito\n3 - Boleto Bancário\n4 - PayPal");
            int opcao = sc.nextInt();
            MetodoPagamento metodo = pagamento.instanciaMP(opcao);
            if(metodo == null){
                System.out.println("Numero invalido!");
            }else{
                if(metodo.pagar(Carrinho.getInstance(false).getValorTotal())){
                    System.out.println("Pedido Finalizado!");
                    Carrinho.getInstance(true);
                    return;
                }else{
                    System.out.println("Erro no pagamento!");
                }
            }
        }
    }

    public void add() {
        System.out.println("Digite o produto:");
        String s = sc.nextLine();
        System.out.println("Digite o preco do produto:");
        double p = sc.nextDouble();

        Produto product = new Produto(s, p);
        System.out.println(product.toString());

        System.out.println("Adicionar ao carrinho? (1-sim, 2-nao)");
        if (sc.nextInt() == 1) {
            AddProductEvent event = new AddProductEvent(product);
            for (AddProductObserver observer : this.observer) {
                observer.addProduct(event);
            }
        }
    }
}
