package programa;

import java.util.*;
import java.io.*;


public class PapeleriaMain {
	public static Vector<Papeleria>producto= new Vector<>();
	
	public static void escribeVector(Scanner sc){
		producto.clear();
		sc.nextLine();
		String nombre;
		String marca;
		String precio;
		int existencia;
		String categoria;
		Papeleria p;
		do {
			System.out.println("Si desea finalizar escriba Fin");
			System.out.println("nombre: ");
			nombre=sc.nextLine();
			if(!nombre.equalsIgnoreCase("Fin")) {
				System.out.println("marca: ");
				marca=sc.nextLine();
				System.out.println("precio: ");
				precio=sc.nextLine();
				System.out.println("existencia: ");
				existencia=Integer.parseInt(sc.nextLine());
				System.out.println("categoria: ");
				categoria=sc.nextLine();
				p= new Papeleria(nombre,marca,precio,existencia,categoria);
				producto.add(p);
			}
			
		}while(!nombre.equalsIgnoreCase("Fin"));
		return;
	}
	
	
	public static void leeArchivo() {
		char op;
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        List<Papeleria> producto = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        try {
            archivo = new File("ruta_del_archivo");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            String linea;
            while ((linea = br.readLine()) != null) {

                String[] datos = linea.split(",");

                if (datos.length == 5) {
                    
                	int id = Integer.parseInt(datos[0].trim());
                    String nombre = datos[1].trim();
                    String marca = datos[2].trim();
                    String precio = datos[3].trim();
                    int existencia = Integer.parseInt(datos[4].trim());
                    String categoria = datos[5].trim();


                    boolean tienePrecio = linea.contains("$");
                        
                    if (!tienePrecio) {
                    		System.out.println("El producto con id " + id + "no tiene precio.");
                        } else {
                        	Papeleria pa = new Papeleria(nombre, marca, precio, existencia, categoria);
                        	producto.add(pa);
                        }
                }
            }
        } catch (ArrayIndexOutOfBoundsException excArreglo) {
            System.out.println("Se excedió el índice del arreglo.");
            System.exit(0);
        } catch (IOException e) {
            System.out.println(e.getMessage() + " en el directorio.");
            System.out.println("No se encontró el archivo, .");
            System.out.println("Si la ruta es correcta, ¿desea crear un archivo nuevo?: (y/n)");
            op = sc.nextLine().charAt(0);
            do {
            	switch (Character.toLowerCase(op)) {
                	case 'y':
	                    System.out.println("Se ha creado un nuevo CSV...");
	                    escribeCsv();
	                    break;
	                case 'n':
	                    System.out.println("Revise la ruta del archivo o cree uno nuevo antes de volver a ejecutar este programa.");
	                    break;
	                default:
	                    System.out.println("Opción inválida. Intente nuevamente.");
	                    break;
	            }
            } while (Character.toLowerCase(op) != 'n');
	            
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }
	
	
	
	
	public static void escribeCsv() {
		File f = new File("./resultado.csv");
		try(FileWriter fw= new FileWriter(f);){
			for(Papeleria papeleria:producto) {
				fw.write(papeleria.toCsv()+"\n");
			}
		}catch(Exception e) {
			System.out.println("Ha ocurrido un error");
		}
	}
	public static void ingresaToCSV() {
		try (FileWriter fw = new FileWriter("./resultado.csv", true)) {
            for (Papeleria papeleria : producto) {
                fw.write(papeleria.toCsv() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error al escribir en el archivo CSV");
        }
    }
		
	
	
	
	
	
	
	public static int menu(Scanner sc) {
		
		System.out.println("=== Papelería ===");
        System.out.println("1. Crear un nuevo CSV nota: Esto borara el que esta en la ruta especificada.");
        System.out.println("2. Mostrar inventario ordenado por Nombre.");
        System.out.println("3. Agregar nuevo elemento al Csv Existente.");
        System.out.println("4. Salir");

        System.out.print("Ingrese su opción: ");
        int opcion=sc.nextInt();
        return opcion;
	}
	
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int opcion;
		
        do {
        	opcion=menu(sc);
            switch (opcion) {
                case 1:
                	System.out.println("-----Crear un Nuevo Csv-----");
                	escribeVector(sc);
            		escribeCsv();
                    break;
                case 2:
                	System.out.println("Aquí muestra inventario por nombre");
                    break;
                case 3:
                	System.out.println("Prueba");
                	escribeVector(sc);
                	ingresaToCSV();
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }
        } while (opcion != 4);
        sc.close();
		
	}
	
}
