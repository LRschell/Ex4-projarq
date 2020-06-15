public class BoletoBancario implements MetodoPagamento {

    @Override
    public boolean pagar(double valor) {
        System.out.println("Boleto gerado:\n34191.75041 38244.392528 50040.380003 2 000\n");

        return true;
    }
}
