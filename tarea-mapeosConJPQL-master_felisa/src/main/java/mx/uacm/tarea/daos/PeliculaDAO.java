/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.tarea.daos;

import java.util.Date;
import java.util.List;
import mx.uacm.tarea.entidades.Pelicula;

public interface PeliculaDAO extends GenericDAO<Pelicula, Integer> {
    
    //parte 3 de la tarea
    List<Pelicula> peliculasPorFecha(Date fechaMin, Date fechaMax);
    
    //parte 4 de la tarea
    List<Pelicula> peliculasPorNombre(String nombre);
    
    //parte 5 de la tarea
     List<Pelicula> peliculasSinGenero();

}
