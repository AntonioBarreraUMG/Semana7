/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.util.*;
import negocio.*;

/**
 *
 * @author Antonio
 */
public class ClsPrincipal {
    private static final Scanner scanner = new Scanner(System.in);
    private static int opcion = -1;
    private static final String nombreArchivo = "c:\\tmp\\empleados.txt";
    private static final NominaEmpleados empleados = new NominaEmpleadosImpl();
    
    /**
     * @param args the commando line arguments
     */
    public static void main(String[] args) {
        while (opcion != 0) {
            try {
                System.out.println("Elegir opcion:\n1-. Iniciar Nomina de Empleados"
                        + "\n2-. Mayor y Menor Vendedor por Mes"
                        + "\n3-. Mayor Vendedor General"
                        + "\n4-. Editar Dato Especifico "
                        + "\n5-. Buscar por Cantidad"
                        + "\n6-. Listar  Informacion"
                        + "\n0-. Salir");
                
                opcion = Integer.parseInt(scanner.nextLine());
                
                switch (opcion) {
                    case 1:
                        System.out.println("PENDIENTE");
                        break;
                    case 2:
                        System.out.println("PENDIENTE");
                        break;
                    case 3:
                        System.out.println("PENDIENTE");
                        break;
                    case 4:
                        System.out.println("PENDIENTE");
                        break;
                    case 5:
                        System.out.println("PENDIENTE");
                        break;
                    case 6:
                        System.out.println("PENDIENTE");
                        break;
                    default:
                        System.out.println("PENDIENTE");
                        break;
                }
                System.out.println("\n");
            } catch (Exception ex) {
                System.out.println("Error");
            }
        }
    }
}
