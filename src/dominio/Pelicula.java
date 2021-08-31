/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

/**
 *
 * @author Ruldin
 */
public class Pelicula {
    private String nombre;
    
    public Pelicula(String nombrePeli){
        this.nombre = nombrePeli;
    }
    
    @Override
    public String toString(){
        return this.getNombre();
    }
    
    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }
}
