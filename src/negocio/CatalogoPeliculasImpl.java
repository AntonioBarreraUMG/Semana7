/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import datos.*;
import dominio.Pelicula;
import excepciones.*;
import java.util.*;

/**
 *
 * @author Ruldin
 */
public class CatalogoPeliculasImpl implements CatalogoPeliculas{
    
    private final AccesoDatos datos;
    
    public CatalogoPeliculasImpl(){
        this.datos = new AccesoDatosImpl(); //poner * en el import datos.*
    }
    
    @Override
    public void agregarPelicula(String nombrePelicula, String nombreArchivo) {
        Pelicula pelicula = new Pelicula(nombrePelicula);
        boolean anexar = false;
        try {
            anexar = datos.existe(nombreArchivo);//bandera si anexa o no
            datos.escribir(pelicula, nombreArchivo, anexar);
        } catch (AccesoDatosEx ex) {
            System.out.println("Error de acceso a datos");
            ex.printStackTrace();
        }
    }

    @Override
    public void listarPeliculas(String nombreArchivo) {
        try {
            List<Pelicula> peliculas = datos.listar(nombreArchivo);
            for(Pelicula pelicula : peliculas){
                System.out.println("Pelicula: "+pelicula);
            }
        } catch (LecturaDatosEx ex) {
            System.out.println("Error de acceso a datos");
            ex.printStackTrace();
        }   
    }

    @Override
    public void buscarPeliculas(String nombreArchivo, String nombrePelicula) {
        String resultado = null;
        try {
            resultado = datos.buscar(nombreArchivo, nombrePelicula);
        } catch (LecturaDatosEx ex) {
            System.out.println("Error al buscar la peli");
            ex.printStackTrace();
        }
         System.out.println("Resultado Busqueda:"+resultado); 
    }

    @Override
    public void iniciarArchivo(String nombreArchivo) {    
        try {
            if(datos.existe(nombreArchivo)){
                datos.borrar(nombreArchivo);
                datos.crear(nombreArchivo);
            } else {
                //crearmos archivo
                datos.crear(nombreArchivo);
            }
        } catch (AccesoDatosEx ex) {
            System.out.println("Error de acceso a datos");
            ex.printStackTrace();
        }
    }
}
