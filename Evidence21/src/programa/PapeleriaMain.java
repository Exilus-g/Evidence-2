package programa;

import java.util.*;
import java.io.*;


public class PapeleriaMain {
	public static Vector<Papeleria> producto= new Vector<>();
	
	public static void escribeVector(Scanner sc){
		producto.clear();
		sc.nextLine();
		String nombre;
		String marca;
		String precio;
		int existencia;
		int id;
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
				System.out.println("Id: ");
				id=Integer.parseInt(sc.nextLine());
				p= new Papeleria(id,nombre,marca,precio,existencia,categoria);
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
            archivo = new File("./resultado.csv");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            String linea;
            while ((linea = br.readLine()) != null) {

                String[] datos = linea.split(",");

                if (datos.length == 6) {
                    
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
                        	Papeleria pa = new Papeleria(id,nombre, marca, precio, existencia, categoria);
                        	producto.add(pa);
                        }
                }
            }
            guardarCsv(producto, archivo.getAbsolutePath());
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
       sc.close(); 

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
                System.out.println("Producto(s) agregado(s) correctamente");
            }
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error al escribir en el archivo CSV");
        }
    }
	
	
	public static void guardarCsv(List<Papeleria> producto, String rutaArchivo) {
	    try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo))) {
	        for (Papeleria papeleria : producto) {
	            String linea = papeleria.getIdi() + "," +
	                           papeleria.getNombre() + "," +
	                           papeleria.getMarca() + "," +
	                           papeleria.getPrecio() + "," +
	                           papeleria.getExistencia() + "," +
	                           papeleria.getCategoria();
	            bw.write(linea);
	            bw.newLine();
	        }
	    } catch (IOException e) {
	        System.out.println("Error al guardar el archivo CSV: " + e.getMessage());
	    }
	}
	
	public static int menu(Scanner sc) {
		
		System.out.println("=== Papelería ===");
        System.out.println("1. Menu de ordenamientos.");
        System.out.println("2. Agregar nuevo elemento al Csv Existente.");
        System.out.println("3. Salir");
        System.out.print("Ingrese su opción: ");
        int opcion=sc.nextInt();
        return opcion;
	}
	
	
	public static int submenu(Scanner sc) {
		
		System.out.println("=== Papelería ===");
        System.out.println("1. Ordenamiento por nombre.");
        System.out.println("2. Ordenamiento por precio.");
        System.out.println("3. Ordenamiento por categoría.");
        System.out.println("4. Salir");
        System.out.print("Ingrese su opción: ");
        int opcion=sc.nextInt();
        return opcion;
	}
	
	public static void ImpPorCategoria(){
        if (producto.size() > 0)
          {  
            System.out.println();
            System.out.println("Inventario ordenado por categoría: ");

            Collections.sort(producto, new OrdenarPorCategoria());
            int j;

            for (int i=0; i<producto.size(); i++)
               {
                 j=i+1;
                 System.out.println(producto.elementAt(i).getIdi() + ": " + producto.elementAt(i).getCategoria() + ", "+ producto.elementAt(i).getNombre() + ", "+ producto.elementAt(i).getMarca() + ", " + producto.elementAt(i).getPrecio() + ", " + producto.elementAt(i).getExistencia());
               } 
         }      
    }
	
	
	public static void ImpPorNombre(){
        if (producto.size() > 0)
          {  
            System.out.println();
            System.out.println("Inventario ordenado por nombre: ");

            Collections.sort(producto, new OrdenarPorNombre());
            int j;

            for (int i=0; i<producto.size(); i++)
               {
                 j=i+1;
                 System.out.println(producto.elementAt(i).getIdi() + ": " + producto.elementAt(i).getNombre() + ", "+ producto.elementAt(i).getMarca() + ", " + producto.elementAt(i).getPrecio() + ", " + producto.elementAt(i).getExistencia() + producto.elementAt(i).getCategoria());
               } 
         }      
    }
	
	
	public static void ImpPorPrecio(){
        if (producto.size() > 0)
          {  
            System.out.println();
            System.out.println("Inventario ordenado por precio: ");

            Collections.sort(producto, new OrdenarPorPrecio());
            int j;

            for (int i=0; i<producto.size(); i++)
               {
                 j=i+1;
                 System.out.println(producto.elementAt(i).getIdi() + ": " + producto.elementAt(i).getPrecio() + ", " + producto.elementAt(i).getNombre() + ", "+ producto.elementAt(i).getMarca() + ", " + producto.elementAt(i).getExistencia() + producto.elementAt(i).getCategoria());
               } 
         }      
    }
	

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int opcion;
		
        do {
        	opcion=menu(sc);
            switch (opcion) {
                case 1:
                	do {
                    	opcion=submenu(sc);
                        switch (opcion) {
                            case 1:
                            	ImpPorNombre();
                                break;
                            case 2:
                            	ImpPorPrecio();
                                break;
                            case 3:
                            	ImpPorCategoria();
                                break;
                            case 4:
                            	System.out.println("Saliendo...");
                                break;
                            default:
                                System.out.println("Opción inválida. Intente nuevamente.");
                                break;
                        }
                    } while (opcion != 4);
                    break;
                    
                case 2:
                	System.out.println("-----Agregar Nuevo Producto-----");
                	escribeVector(sc);
                	ingresaToCSV();
                    break;
                case 3:
                	System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }
        } while (opcion != 3);
        sc.close();
	}
	
}
