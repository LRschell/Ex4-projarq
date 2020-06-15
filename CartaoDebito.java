import java.util.Scanner;

public class CartaoDebito implements MetodoPagamento {

    @Override
    public boolean pagar(double valor) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o numero do cartão de débito:");
        String numero = sc.nextLine();
        System.out.println("Digite a data de validade:");
        String validade = sc.nextLine();
        System.out.println("Digite o CVV:");
        String cvv = sc.nextLine();

        System.out.println("Pagamento confirmado!");
        return true;
    }
}
