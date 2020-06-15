import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Fachada fachada = new Fachada();
        fachada.addAddProductObserver(Carrinho.getInstance(false));

        while (true) {
            System.out.println("0 - Finalizar compra\n1 - Adicionar um produto\n2 - Encerrar sistema");
            System.out.println(Carrinho.getInstance(false).toString());

            int in = sc.nextInt();
            switch (in) {
                case 0:
                    fachada.finaliza();
                    break;
                case 1:
                    fachada.add();
                    break;
                case 2:
                    System.out.println("Encerrando...");
                    return;
                default:
                    System.out.println("Numero invalido, digite novamente!");
                    break;
            }
        }
    }
}
