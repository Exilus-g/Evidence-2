package programa;

import java.util.Scanner;
import java.util.Vector;  
import java.util.Collections;
import java.io.*;

public class PapeleriaMain {
	public static Vector<Papeleria>lee= new Vector<>();
	public static void escribeArchivo(Scanner sc){
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
				
			}
			
		}while(!nombre.equalsIgnoreCase("Fin"));
	}
	
	
}
