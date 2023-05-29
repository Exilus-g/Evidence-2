package programa;

import java.util.Scanner;
import java.util.Vector;  
import java.util.Collections;
import java.util.Comparator;
import java.io.*;


public class PapeleriaMain {
	static Vector<Papeleria> producto= new Vector<>();
	
	public static void leeArchivo()
    {
		producto.clear();
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
 
        try // bloque try. Las instrucciones que serviran para algo.
        {
            archivo = new File("./resultado.csv");
            fr = new FileReader (archivo);
            br = new BufferedReader(fr);

            // Lectura del archivo
            System.out.println("Contenido del archivo resultado.csv");
            String linea;
            int i=1;

            while((linea=br.readLine())!=null)
              {
                 if (i==1)
                   {
                     System.out.println("Los metadatos son: ");
                     System.out.println(">>  " + linea); 
                     i++;  
                   }
                 else 
                   {
                    if (linea.length()!=0) 
                      {  
                       

                        // Divide un renglon del archivo CSV buscando las comas

                        String[] partes = linea.split(",");
                        if (partes.length == 6) {
                        	 String id=partes[0].trim();
                             String nombre=partes[1].trim();
                             String marca=partes[2].trim();
                             String precio=partes[3].trim();
     						 String existencia=partes[4].trim();
                             String categoria=partes[5].trim();
                            
                             Papeleria p = new Papeleria(Integer.parseInt(id),nombre,marca,precio,Integer.parseInt(existencia),categoria);
                             producto.add(p);
                        }
                          
                      } //if
                } //else
             }//while   
        }
        catch (ArrayIndexOutOfBoundsException excArreglo )
        {
          System.out.println("Se excedio el indice del arreglo. ");
          System.exit(0);
        }
        catch (FileNotFoundException fileNotFound)
        {
         System.out.println(fileNotFound.getMessage() + " en el directorio.");
         System.out.println("Revise la ruta del archivo antes de volver a ejecutar este programa.");
         System.out.println(" G R A C I A S. ");
         System.exit(0);  
        }

        // Bloque catch. Contiene las instruciones para manejar las excepciones
        catch (Exception e)  // El catch atrapa una excepcion en el objeto e
        {
           e.printStackTrace();  
        }
       
        finally
         {
           try 
           {
              if(null!= fr) 
              {
                 fr.close();
              }
           }
           catch (Exception e2) 
           {
              e2.printStackTrace();
           }
        }
    }
	
	public static void escribeVector(Scanner sc){
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
	
	
	
	/*public static void leeArchivo() {
		char op;
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        
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
            //guardarCsv(producto, archivo.getAbsolutePath());
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
	                    escribeCsv();
	                    System.out.println("Se ha creado un nuevo CSV...");
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
    }*/
	
	
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
        System.out.println("4. Ordenamiento por ID.");
        System.out.println("5. Salir");
        System.out.print("Ingrese su opción: ");
        int opcion=sc.nextInt();
        return opcion;
	}
	
	public static void ImpPorCategoria(){
		Collections.sort(producto,Comparator.comparing(Papeleria::getCategoria));
		 String newCsvFilePath = "./resultado.csv";
	        try (FileWriter fw = new FileWriter(newCsvFilePath)) {
	        	fw.write("Id,Nombre,Marca,Precio,Existencia,Categoria\n");
	            for (Papeleria papeleria : producto) {
	                fw.write(papeleria.toCsv() + "\n");
	            }
	            System.out.println("Archivo CSV correctamente ordenado y sobreescrito por CATEGORIA");
	        } catch (IOException e) {
	            System.out.println("Ha ocurrido un error al escribir en el archivo CSV ordenado");
	        }     
    }
	

	public static void ImpPorNombre() {
		Collections.sort(producto,Comparator.comparing(Papeleria::getNombre));
		 String newCsvFilePath = "./resultado.csv";
	        try (FileWriter fw = new FileWriter(newCsvFilePath)) {
	        	fw.write("Id,Nombre,Marca,Precio,Existencia,Categoria\n");
	            for (Papeleria papeleria : producto) {
	                fw.write(papeleria.toCsv() + "\n");
	            }
	            System.out.println("Archivo CSV correctamente ordenado y sobreescrito por NOMBRE");
	        } catch (IOException e) {
	            System.out.println("Ha ocurrido un error al escribir en el archivo CSV ordenado");
	        }  
	}
	
	
	public static void ImpPorPrecio(){
		Collections.sort(producto,Comparator.comparing(Papeleria::getPrecio));
		 String newCsvFilePath = "./resultado.csv";
	        try (FileWriter fw = new FileWriter(newCsvFilePath)) {
	        	fw.write("Id,Nombre,Marca,Precio,Existencia,Categoria\n");
	            for (Papeleria papeleria : producto) {
	                fw.write(papeleria.toCsv() + "\n");
	            }
	            System.out.println("Archivo CSV correctamente ordenado y sobreescrito por PRECIO");
	        } catch (IOException e) {
	            System.out.println("Ha ocurrido un error al escribir en el archivo CSV ordenado");
	        }       
    }
	public static void ImpPorId(){
		Collections.sort(producto,Comparator.comparing(Papeleria::getId));
		 String newCsvFilePath = "./resultado.csv";
	        try (FileWriter fw = new FileWriter(newCsvFilePath)) {
	        	fw.write("Id,Nombre,Marca,Precio,Existencia,Categoria\n");
	            for (Papeleria papeleria : producto) {
	                fw.write(papeleria.toCsv() + "\n");
	            }
	            System.out.println("Archivo CSV correctamente ordenado y sobreescrito por ID");
	        } catch (IOException e) {
	            System.out.println("Ha ocurrido un error al escribir en el archivo CSV ordenado");
	        }       
    }
	

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int opcion;
		int op2;
        do {
        	leeArchivo();
        	opcion=menu(sc);
            switch (opcion) {
                case 1:
                	do {
                    	op2=submenu(sc);
                        switch (op2) {
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
                            	ImpPorId();
                                break;
                            case 5:
                            	System.out.println("Saliendo...");
                                break;
                            default:
                                System.out.println("Opción inválida. Intente nuevamente.");
                                break;
                        }
                    } while (op2 != 5);
                    break;
                    
                case 2:
                	System.out.println("-----Agregar Nuevo Producto-----");
                	producto.clear();
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
