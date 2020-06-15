public class AddProductEvent {

    private final Produto produto;

    public AddProductEvent(Produto produto) {
        super();
        this.produto = produto;
    }

    public Produto getProduto() {
        return produto;
    }
}