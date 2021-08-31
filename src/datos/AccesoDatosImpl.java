/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import dominio.Pelicula;
import excepciones.*;
import java.io.*;
import java.util.*;

/**
 *
 * @author Ruldin
 */
public class AccesoDatosImpl implements AccesoDatos {
    /** @param nombreArchivo
    * @exception AccesoDatosEx
    * @pdOid 482213a6-85eb-4673-88f5-00c579ed64a0 */
    @Override
    public boolean existe(String nombreArchivo) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
        return archivo.exists();
    }
    
    /** @param nombreArchivo
    * @exception LecturaDatosEx
    * @pdOid 94530568-a4cb-4297-96e0-3cac88bada7e */
    @Override
    public List<Pelicula> listar(String nombreArchivo) throws LecturaDatosEx {
        List<Pelicula> peliculas = new ArrayList();
        try {
            BufferedReader entrada = null;
            File archivo = new File(nombreArchivo);
            entrada = new BufferedReader(new FileReader(archivo));
            String linea = null;
            linea = entrada.readLine();
            while (linea != null){
                Pelicula pelicula = new Pelicula(linea);
                peliculas.add(pelicula);
                linea = entrada.readLine();
            }
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
        return peliculas;
    }
    
    /** @param pelicula
    * @param nombreArchivo
    * @param anexar
    * @exception EscrituraDatosEx
    * @pdOid ac225a72-846e-4700-ab01-ac2ee29fefac */
    @Override
    public void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) throws EscrituraDatosEx {
        PrintWriter salida = null;
        try {
            File archivo = new File(nombreArchivo);
            salida = new PrintWriter(new FileWriter(archivo,anexar));
            salida.println(pelicula.toString());
            salida.close();
            System.out.println("Se ha escrito el registro en el archivo");
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        } finally {
            salida.close();
        }
    }
    
    /** @param nombreArchivo
    * @param buscar
    * @pdOid 74d2bc4a-8157-4371-9100-92acfea2a4d1 */
    @Override
    public String buscar(String nombreArchivo, String buscar) {
        BufferedReader entrada = null;
        String resultado = null;
        try {
            File archivo = new File(nombreArchivo);
            entrada = new BufferedReader(new FileReader(archivo));
            String linea = null;
            int i=0;
            linea = entrada.readLine();
            while (linea != null){
                if(buscar != null && buscar.equalsIgnoreCase(linea)){
                    resultado = " Pelicula: "+ linea + " encontrada en el indice " + i;
                    break;
                }
                linea = entrada.readLine();
                i++;
            } 
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                entrada.close();
            } catch (IOException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return resultado;
    }
    
    /** @param nombreArchivo
    * @pdOid c2d9fcb6-be82-4c10-a7a2-c8e0b07811be */
    public void crear(String nombreArchivo) {
        PrintWriter salida = null;
        try {
            File archivo = new File(nombreArchivo);
            salida = new PrintWriter(new FileWriter(archivo));
            salida.close();
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        } finally {
            salida.close();
        }
    }
    
    /** @param nombreArchivo
    * @exception AccesoDatosEx
    * @pdOid 51d99696-2469-491c-ab14-45a2ccad0fc5 */
    @Override
    public void borrar(String nombreArchivo) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
        archivo.delete();
        System.out.println("Se ha borrado el archivo");
    }
}
