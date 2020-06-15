import java.util.Scanner;

public class PayPal implements MetodoPagamento {

    @Override
    public boolean pagar(double valor) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite se email:");
        String numero = sc.nextLine();
        System.out.println("Digite sua senha:");
        String validade = sc.nextLine();

        System.out.println("Pagamento confirmado!");
        return true;
    }
}
