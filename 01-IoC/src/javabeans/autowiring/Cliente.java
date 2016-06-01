package javabeans.autowiring;

public class Cliente {
	private Pedido pedido;

	@Override
	public String toString() {
		return "Cliente [pedido=" + pedido + "]";
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
}
