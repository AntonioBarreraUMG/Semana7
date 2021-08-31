/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

/**
 *
 * @author Antonio
 */
public interface NominaEmpleados {
    public void iniciarArchivo(String nombreArchivo);
    public void agregarEmpleado(String nombreArchivo, String nombreEmpleado, Double enero, Double febrero, Double marzo);
    public void buscarMayorMenorVendedorPorMes(String nombreArchivo, int mes);
    public void buscarMayorVendedorGeneral(String nombreArchivo);
    public void editarDato(String nombreArchivo, String nuevoDato, int registro, int columna);
    public void buscarPorCantidad(String nombreArchivo, Double cantidad);
    public void listarEmpleados(String nombreArchivo);
}
