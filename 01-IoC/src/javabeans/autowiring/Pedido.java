package javabeans.autowiring;

public class Pedido {
	private int codigo;
	private double total;
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return "Pedido [codigo=" + codigo + ", total=" + total + "]";
	}
}
