package programa;

import java.util.Scanner;
import java.util.Vector;  
import java.util.Collections;
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
        System.out.println("1. Mostrar inventario ordenado por categoria.");
        System.out.println("1. Mostrar inventario ordenado por Nombre.");
        System.out.println("2. Agregar nuevo elemento.");
        System.out.println("3. Salir");
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
        } while (opcion != 3);
        sc.close();
		
	}
	
}
