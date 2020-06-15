public class FactoryPagamento {

    public MetodoPagamento instanciaMP(int metodo){
        switch(metodo){
            case 1:
                return new CartaoDebito();
            case 2:
                return new CartaoCredito();
            case 3:
                return new BoletoBancario();
            case 4:
                return new PayPal();
        }
        return null;
    }
}
