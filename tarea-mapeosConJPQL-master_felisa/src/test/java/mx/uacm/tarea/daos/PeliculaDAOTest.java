package mx.uacm.tarea.daos;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import mx.uacm.tarea.daos.impl.PeliculaDAOImpl;
import mx.uacm.tarea.entidades.Pelicula;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PeliculaDAOTest {

    private static EntityManager em;

    private static PeliculaDAO peliculaDAO;

    @BeforeAll
    public static void inicializar() {
        System.out.println("inicializando");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("base-pruebas-memoria");
        //Para usar la base de datos "de verdad", comente la linea de arriba y descomente la siguiente linea.
        //EntityManagerFactory emf = Persistence.createEntityManagerFactory("base-pruebas");
        em = emf.createEntityManager();
        peliculaDAO = new PeliculaDAOImpl(em);
    }

    @AfterAll
    public static void terminar() {
        System.out.println("terminando");
    }

    @BeforeEach
    public void antesDeCadaTest() {
        System.out.println("antes del test");
        em.getTransaction().begin(); //iniciamos transaccion
    }

    @AfterEach
    public void despuesDeCadaTest() {
        System.out.println("despues del test");
        em.flush();
        em.getTransaction().rollback();
    }

    @Test
    public void buscarPorId() {
        Pelicula d = peliculaDAO.buscarPorId(1);
        Assertions.assertNotNull(d);
        
        //Prueba de mapeo pelicula con generoparte 1 de tarea
        assertNotNull(d.getGeneros());
        assertEquals(1,d.getGeneros().size());
        
        
        
    }
    
    //parte 3 de la tarea
    @Test
    public void peliculasPorFechaTest(){
           GregorianCalendar cal1= new GregorianCalendar(1979,3,01);
           Date fechaMin=cal1.getTime();
           
           cal1= new GregorianCalendar(2017,4,27);
           Date fechaMax=cal1.getTime();
           
           List<Pelicula> peliculas = peliculaDAO.peliculasPorFecha(fechaMin,fechaMax);
           System.out.println("peliculas :" +peliculas);
           assertEquals(7,peliculas.size());
          
    }
    
    
    //Parte 4 de la tarea
    @Test
    public void peliculasPorNombreTest(){
         List<Pelicula> peliculas=peliculaDAO.peliculasPorNombre("gran");
         System.out.println("peliculas :" +peliculas);
         assertEquals(2,peliculas.size());
         
         
    
    }
    
    
   //parte 5 de la tarea 
   @Test
    public void peliculasSinGeneroTest(){
          List<Pelicula> peliculas=peliculaDAO.peliculasSinGenero();
          System.out.println("Peliculas sin genero :" + peliculas);
    
    }

}
