/**
 * Stationery class, contains all the attributes related to a product. 
 * @author GabrielHL
 * @author AlejandroTC
 */
package progama;

public class Papeleria {
	private String nombre;
	private String marca;
	private String precio;
	private int existencia;
	private String categoria;
	
	public Papeleria(String nombre, String marca,String precio, int existencia, String categoria) {
		this.nombre=nombre;
		this.marca=marca;
		this.precio=precio;
		this.existencia=existencia;
		this.categoria=categoria;
	}
	public String getNombre() {
		return nombre;
	}
	
	
}
