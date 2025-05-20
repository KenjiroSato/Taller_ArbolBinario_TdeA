import java.util.Scanner;

public class MainArbolTaller {
    public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n      /ÁRBOL BINARIO/  ");
            System.out.println(" 1)  Agregar nodo");
            System.out.println(" 2)  Recorrido Pre-Orden");
            System.out.println(" 3)  Recorrido In-Orden");
            System.out.println(" 4)  Recorrido Post-Orden");
            System.out.println(" 5)  Buscar Nodo");
            System.out.println(" 6)  Mostrar altura");
            System.out.println(" 7)  Contar hojas");
            System.out.println(" 8)  Eliminar nodo");
            System.out.println(" 9)  Vaciar árbol");
            System.out.println(" 0)  Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el valor: ");
                    arbol.agregar(sc.nextInt());
                    break;
                case 2:
                    arbol.preOrden();
                    break;
                case 3:
                    arbol.inOrden();
                    break;
                case 4:
                    arbol.postOrden();
                    break;
                case 5:
                    System.out.print("Valor a buscar: ");
                    System.out.println(arbol.buscar(sc.nextInt()) ? "Existe" : "No existe");
                    break;
                case 6:
                    System.out.println("Altura: " + arbol.altura());
                    break;
                case 7:
                    System.out.println("Hojas: " + arbol.contarHojas());
                    break;
                case 8:
                    System.out.print("Valor a eliminar: ");
                    arbol.eliminar(sc.nextInt());
                    break;
                case 9:
                    arbol.vaciar();
                    System.out.println("Árbol vaciado.");
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
                    break;
            }
        } while (opcion != 0);
        sc.close();
    }
}