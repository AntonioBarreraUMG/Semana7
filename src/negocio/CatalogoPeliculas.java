/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

/**
 *
 * @author Ruldin
 */
public interface CatalogoPeliculas {
    public void agregarPelicula(String nombrePelicula, String nombreArchivo);
    public void listarPeliculas(String nombreArchivo);
    public void buscarPeliculas(String nombreArchivo, String nombrePelicula);
    public void iniciarArchivo(String nombreArchivo);
}
