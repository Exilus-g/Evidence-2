import java.util.Scanner;

public class PapeleriaMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Papeleria papeleria = new Papeleria();

        int opcion;
        do {
            System.out.println("=== Papelería ===");
            System.out.println("1. Mostrar inventario");
            System.out.println("2. Agregar nuevo elemento");
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
