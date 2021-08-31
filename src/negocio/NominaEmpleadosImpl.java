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
    
    public NominaEmpleadosImpl(){
        this.datos = new AccesoDatosImpl();
    }
    
    @Override
    public void iniciarArchivo(String nombreArchivo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void agregarEmpleado(String nombreArchivo, String nombreEmpleado, Double enero, Double febrero, Double marzo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void buscarMayorMenorVendedorPorMes(String nombreArchivo, int mes) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void buscarMayorVendedorGeneral(String nombreArchivo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editarDato(String nombreArchivo, String nuevoDato, int registro, int columna) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void buscarPorCantidad(String nombreArchivo, Double cantidad) {
       throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void listarEmpleados(String nombreArchivo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
