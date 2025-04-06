/* 
 * Bernardo Canas
 * 202401637
 * Universidad DaVinci De Guatemala
 * Estructura de Datos
*/
import java.util.Scanner;
public class parcial2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        //Pedir al usuario que ingrese su DPI
        System.out.print("\nIngrese su DPI: ");
        String dpi = scanner.nextLine();
        
        //Validar que solo contenga números
        if (!dpi.matches("\\d+")) {
            System.out.println("El DPI debe contener solo números.");
            return;
        }
        
        //Crear la lista enlazada
        LinkedList dpiList = new LinkedList();
        
        //Agregar cada dígito del DPI a la lista
        for (int i = 0; i < dpi.length(); i++) {
            int digit = Character.getNumericValue(dpi.charAt(i));
            dpiList.add(digit);
        }
        
        System.out.println("\n<--- Operaciones con lista enlazada usando su DPI -->");
        
        //Agregar el número 1 al inicio de la lista
        System.out.println("\n1. Agregando el número 1 al inicio de la lista:");
        dpiList.agregar_primero(1);
        dpiList.mostar_lista();
        
        //Agregar el número 3 al final de la lista
        System.out.println("\n2. Agregando el número 3 al final de la lista:");
        dpiList.add(3);
        dpiList.mostar_lista();
        
        //Agregar el número 5 al medio de la lista (en la posición 1)
        System.out.println("\n3. Agregando el número 5 en la posición 1:");
        dpiList.agregar_medio(5, 1);
        dpiList.mostar_lista();
        
        //Mostrar la lista actual
        System.out.println("\n4. Lista actual:");
        dpiList.mostar_lista();
        
        //Remover el número 3 de la lista
        System.out.println("\n5. Eliminando el número 3 de la lista:");
        dpiList.remove(3);
        dpiList.mostar_lista();
        
        //Mostrar la lista después de la eliminación
        System.out.println("\n6. Lista después de eliminar el 3:");
        dpiList.mostar_lista();
        
        //Agregar el número 7 al final de la lista
        System.out.println("\n7. Agregando el número 7 al final de la lista:");
        dpiList.add(7);
        dpiList.mostar_lista();
        
        //Verificar si el número 5 está en la lista
        System.out.println("\n8. ¿El número 5 está en la lista? " + dpiList.contains(5));
        
        //Verificar si el número 9 está en la lista
        System.out.println("9. ¿El número 9 está en la lista? " + dpiList.contains(9));
        
        //Revertir la lista
        System.out.println("\n10. Revertiendo la lista:");
        dpiList.reverse();
        dpiList.mostar_lista();
        
        //Mostrar la lista después de revertir
        System.out.println("\n11. Lista después de revertir:");
        dpiList.mostar_lista();
        
        //Agregar el número 9 al inicio de la lista
        System.out.println("\n12. Agregando el número 9 al inicio de la lista:");
        dpiList.agregar_primero(9);
        dpiList.mostar_lista();
        
        //Mostrar la lista final
        System.out.println("\n13. Lista final:");
        dpiList.mostar_lista();
        System.out.println("\n");
        scanner.close();
    }
}