package programa;

import java.util.Scanner;
import java.util.Vector;  
import java.util.Collections;
import java.io.*;

public class PapeleriaMain {
	public static Vector<Papeleria>producto= new Vector<>();
	
	public static void escribeVector(Scanner sc){
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
	
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		escribeVector(sc);
		escribeCsv();
		sc.close();
		int opcion;
        do {
            System.out.println("=== Papelería ===");
            System.out.println("1. Mostrar inventario ordenad.");
            System.out.println("2. Agregar nuevo elemento.");
            System.out.println("3. Salir");
            System.out.print("Ingrese su opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    papeleria.mostrarInventario();
                    break;
                case 2:
                    papeleria.agregarElemento();
                    break;
                case 3:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }
        } while (opcion != 3);
		
		
	}
	
}
