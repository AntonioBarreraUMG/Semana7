/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import datos.*;
import dominio.MdEmpleado;
import excepciones.*;
import java.util.*;

/**
 *
 * @author Antonio
 */
public class NominaEmpleadosImpl implements NominaEmpleados{

    private final AccesoDatos datos;
    private final String errorAcceso = "Error de acceso a datos";
    private final String errorLectura = "Error de lectura de datos";
    private final String errorEscritura = "Error de escritura de datos";
    
    public NominaEmpleadosImpl(){
        this.datos = new AccesoDatosImpl();
    }
    
    @Override
    public void iniciarArchivo(String nombreArchivo) {
        try {
            if(datos.existe(nombreArchivo)){
                datos.borrar(nombreArchivo);
                datos.crear(nombreArchivo);
            } else {
                datos.crear(nombreArchivo);
            }
        } catch (AccesoDatosEx ex) {
            System.out.println(errorAcceso);
            ex.printStackTrace();
        }
    }

    @Override
    public void agregarEmpleado(String nombreArchivo, String nombreEmpleado, Double enero, Double febrero, Double marzo) {
        MdEmpleado empleado = new MdEmpleado(nombreEmpleado, enero, febrero, marzo);
        boolean anexar = false;
        try {
            anexar = datos.existe(nombreArchivo);
            datos.escribir(empleado, nombreArchivo, anexar);
            System.out.println("**Registro exitoso**");
        } catch (AccesoDatosEx ex) {
            System.out.println(errorAcceso);
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void buscarMayorVendedorPorMes(String nombreArchivo, int mes) {
        Double mayor = 0.0;
        String resultado = null;
        try {
            List<MdEmpleado> empleados = datos.listar(nombreArchivo); 
            switch (mes) {
                case 1:
                    for (MdEmpleado empleado : empleados) {
                        if (empleado.getEnero() > mayor) {
                            mayor = empleado.getEnero();
                            resultado = empleado.getNombre();
                        }
                    }
                    break;
                case 2:
                    for (MdEmpleado empleado : empleados) {
                        if (empleado.getFebrero() > mayor) {
                            mayor = empleado.getFebrero();
                            resultado = empleado.getNombre();
                        }
                    }
                    break;
                case 3:
                    for (MdEmpleado empleado : empleados) {
                        if (empleado.getMarzo() > mayor) {
                            mayor = empleado.getMarzo();
                            resultado = empleado.getNombre();
                        }
                    }
                    break;
                }
            if (resultado != null) {
                System.out.println("El MAYOR vendedor del mes es " + resultado
                                  + " con " + mayor);
            }
        } catch (LecturaDatosEx ex) {
            System.out.println(errorLectura);
            ex.printStackTrace(System.out);
        }
    }
    
    @Override
    public void buscarMenorVendedorPorMes(String nombreArchivo, int mes) {
        Double menor = 99999999999999.9;
        String resultado = null;
        try {
            List<MdEmpleado> empleados = datos.listar(nombreArchivo);
            switch (mes) {
                case 1:
                    for (MdEmpleado empleado : empleados) {
                        if (empleado.getEnero() < menor) {
                            menor = empleado.getEnero();
                            resultado = empleado.getNombre();
                        }
                    }
                    break;
                case 2:
                    for (MdEmpleado empleado : empleados) {
                        if (empleado.getFebrero() < menor) {
                            menor = empleado.getFebrero();
                            resultado = empleado.getNombre();
                        }
                    }
                    break;
                case 3:
                    for (MdEmpleado empleado : empleados) {
                        if (empleado.getMarzo() < menor) {
                            menor = empleado.getMarzo();
                            resultado = empleado.getNombre();
                        }
                    }
                    break;
                default:
                    System.out.println("Mes no valido");
            }
            if (resultado != null) {
                System.out.println("El MENOR vendedor del mes es " + resultado
                                 + " con " + menor);
            }
        } catch (LecturaDatosEx ex) {
            System.out.println(errorLectura);
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void buscarMayorVendedorGeneral(String nombreArchivo) {
        Double mayor = 0.0;
        String resultado = null;
        try {
            List<MdEmpleado> empleados = datos.listar(nombreArchivo);
            for(MdEmpleado empleado : empleados) {
                if (empleado.getTotal() > mayor) {
                    resultado = empleado.getNombre() + " con " + empleado.getTotal();
                }
            }
            System.out.println("El MAYOR vendedor general es " + resultado);
        } catch (AccesoDatosEx ex) {
            System.out.println(errorAcceso);
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void editarDato(String nombreArchivo, String nuevoDato, int registro, int columna) {
        registro--;
        try {
            List<MdEmpleado> empleados = datos.listar(nombreArchivo);
            String nombre = empleados.get(registro).getNombre();
            Double enero = empleados.get(registro).getEnero();
            Double febrero = empleados.get(registro).getFebrero();
            Double marzo = empleados.get(registro).getMarzo();
            switch (columna) {
                case 1:
                    nombre = nuevoDato;
                    break;
                case 2:
                    enero = Double.valueOf(nuevoDato);
                    break;
                case 3:
                    febrero = Double.valueOf(nuevoDato);
                    break;
                case 4:
                    marzo = Double.valueOf(nuevoDato);
                    break;
                default:
                    System.out.println("Columna no valida");
                    break;
            }
            MdEmpleado empleado = new MdEmpleado(nombre, enero, febrero, marzo);
            empleados.set(registro, empleado);
            boolean anexar = false;
            for (MdEmpleado linea : empleados) {
                datos.escribir(linea, nombreArchivo, anexar);
                anexar = datos.existe(nombreArchivo);
            }  
        } catch (LecturaDatosEx ex) {
            System.out.println(errorLectura);
            ex.printStackTrace(System.out);
        } catch (EscrituraDatosEx ex) {
            System.out.println(errorEscritura);
            ex.printStackTrace(System.out);
        } catch (AccesoDatosEx ex) {
            System.out.println(errorAcceso);
            ex.printStackTrace(System.out);
        } catch (NumberFormatException ex) {
            System.out.println("Error de formato");
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void buscarPorCantidad(String nombreArchivo, Double cantidad) {
        String resultado = null;
        try {
            resultado = datos.buscar(nombreArchivo, cantidad);
        } catch (LecturaDatosEx ex) {
            System.out.println(errorLectura);
            ex.printStackTrace(System.out);
        }
        System.out.println("Resultado: " + resultado);
    }

    @Override
    public void listarEmpleados(String nombreArchivo) {
        try {
            List<MdEmpleado> empleados = datos.listar(nombreArchivo);
            if (empleados.size() > 0) {
                empleados.forEach(empleado -> {
                    System.out.println(empleado);
                });
            } else {
                System.out.println("No exiten registros");
            }
        } catch (LecturaDatosEx ex) {
            System.out.println(errorAcceso);
            ex.printStackTrace(System.out);
        }
    }
}
