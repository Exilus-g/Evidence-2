/**
 * Stationer class, contains all the attributes related to a product. 
 * @author GabrielHL
 * @author AlejandroTC
 */
package programa;

public class Papeleria {
	private int id;
	private String nombre;
	private String marca;
	private String precio;
	private int existencia;
	private String categoria;
	
	public Papeleria(int id,String nombre, String marca,String precio,int existencia, String categoria) {
		this.setId(id);
		this.setNombre(nombre);
		this.setMarca(marca);
		this.setPrecio(precio);
		this.setExistencia(existencia);
		this.setCategoria(categoria);
	}
	/**
     *  Get methods to obtain attribute values
     * */
	public int getIdi() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	
	public String getMarca() {
		return marca;
	}
	
	public String getPrecio() {
		return precio;
	}
	
	public int getExistencia() {
		return existencia;
	}
	
	public String getCategoria() {
		return categoria;
	}

	/**
	 * Set methods for assigning values to attributes
	 * @param nombre
	 * @param marca
	 * @param precio
	 * @param existencia
	 * @param categoria
	 */
	public void setId(int id) {
		this.id = id;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public void setPrecio(String precio) {
		this.precio = precio;
	}
	
	public void setExistencia(int existencia) {
		this.existencia = existencia;
	}
	
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public String toCsv() {
		return this.nombre+","+this.marca+","+this.precio+","+this.existencia+","+this.categoria;
	}

}
