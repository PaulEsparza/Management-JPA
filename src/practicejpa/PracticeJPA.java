package practicejpa;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
//import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;

public class PracticeJPA {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAPU"); //Gestor de entidades
        EntityManager em = emf.createEntityManager(); //Instancia para trabajar con las entidades en este caso de la clase Alumnos
        //EntityTransaction tx = em.getTransaction(); // Permite hacer transacciones
/*
        //INSERCIONES (1 en 1) con un solo objeto, sino crear varios objetos
        Alumno alumno, alumno2, alumno3;
        alumno = new Alumno("Contreras Barbosa", "Isaac Adrian", 1, 1);
        alumno2 = new Alumno("Esparza Guevara", "Nestor Paul", 1, 1);
        alumno3 = new Alumno("Perez Bustos", "Joaquin Alejandro", 1, 1);
        //alumno = new Alumno("Diaz Anguiano", "Armando", 1, 1);
        //alumno = new Alumno("Cordoba Alonso", "Silvia Yanely", 1, 1);
        //alumno = new Alumno("Ramirez Gonzalez", "Isaac", 1, 1);
        //tx.begin(); //Abrir la transaccion
        try {
            em.getTransaction().begin(); //Abrir la transaccion
            em.persist(alumno); // Grabe al alumno en la base de datos
            em.persist(alumno2); // Grabe al alumno en la base de datos
            em.persist(alumno3); // Grabe al alumno en la base de datos
            em.getTransaction().commit(); // Termine la transaccion
            JOptionPane.showMessageDialog(null, "El alumno fue"
                    + " registrado correctamente");
            em.close();
            //em.flush(); // Para guardar en la base de datos(Va a la base de datos forzando que se haga la indicacion en la BD)
            //em.refresh(alumno); // Regresar al estado anterior que se encontaba la entidad
            //tx.commit(); // Termine la transaccion
        } catch (Exception e) {
            //tx.rollback();
            em.getTransaction().rollback();
            em.close();
        }
         */

        //LECTURA DE DATOS
        Alumno alumno;
        // CASO 1
        try {
            em.getTransaction().begin(); //Abrir la transaccion
            //CONSULTA CASO 1
            //String ps = "SELECT a FROM alumnos a";
            //Query query = em.createQuery(ps);

            //CONSULTA CASO 2
            String ps1 = "SELECT * FROM alumnos";
            Query query1 = em.createNativeQuery(ps1);

            // RECORRIDO CASO 2
            List<Object[]> res = query1.getResultList();
            for (Object[] alum : res) {
                System.out.println(alum[0] + ", " + alum[1] + ", " + alum[2]
                + ", " + alum[3] + ", " + alum[4]);
            }
            /*
            // CONSULTA PARA OBTENER SOLO ALGUNAS PROPIEDADES
            String ps2 = "SELECT a.nombre, a.apellidos FROM alumnos a";
            Query query2 = em.createQuery(ps2);
            List<Object[]> res2 = query2.getResultList();
            for (Object[] alum : res2) {
                System.out.println(alum[0] + ", " + alum[1]);
            }
             */
            //RECORRIDO CASO 1
            //List<Alumno> resultados = new ArrayList<>();
            //resultados = query.getResultList();
            //List<Alumno> resultados = query.getResultList();
            //JOptionPane.showMessageDialog(null, resultados.size());
            //if (resultados.size() > 0) {
            //  for (Alumno alum : resultados) {
            //       System.out.println(alum.getApellidos() + ", " + alum.getNombre());
            //  }
            //} else {
            //    JOptionPane.showMessageDialog(null, "NO EXISTEN REGISTROS");
            //}

            em.close();
            //em.flush(); // Para guardar en la base de datos(Va a la base de datos forzando que se haga la indicacion en la BD)
            //em.refresh(alumno); // Regresar al estado anterior que se encontaba la entidad
            //tx.commit(); // Termine la transaccion
        } catch (Exception e) {
            //tx.rollback();
            System.out.println("ex" + e);
            //em.getTransaction().rollback();
            em.close();
        }

        /*
        //BUSQUEDA
        Alumno alumno;
        try {
            em.getTransaction().begin(); //Abrir la transaccion
            alumno = em.find(Alumno.class, 1L);
            if (alumno != null) {
                JOptionPane.showMessageDialog(null, alumno.getNombre());
            } else {
                JOptionPane.showMessageDialog(null, "NO EXISTE EL ALUMNO");
            }
            em.close();
            //em.flush(); // Para guardar en la base de datos(Va a la base de datos forzando que se haga la indicacion en la BD)
            //em.refresh(alumno); // Regresar al estado anterior que se encontaba la entidad
            //tx.commit(); // Termine la transaccion
        } catch (Exception e) {
            //tx.rollback();
            //em.getTransaction().rollback();
            em.close();
        }
         */
 /*
        //MODIFICAR
        Alumno alumno;
        try {
            em.getTransaction().begin(); //Abrir la transaccion
            alumno = em.find(Alumno.class, 51L);
            if (alumno != null) {
                alumno.setNombre("Jose Luis");
                alumno.setApellidos("Martinez Sanchez");
                em.getTransaction().commit(); // Termine la transaccion
                JOptionPane.showMessageDialog(null, "El alumno fue"
                        + " actualizado correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "NO EXISTE EL ALUMNO");
            }
            em.close();
            //em.flush(); // Para guardar en la base de datos(Va a la base de datos forzando que se haga la indicacion en la BD)
            //em.refresh(alumno); // Regresar al estado anterior que se encontaba la entidad
            //tx.commit(); // Termine la transaccion
        } catch (Exception e) {
            //tx.rollback();
            //em.getTransaction().rollback();
            em.close();
        }
         */
 /*
        // ELIMINAR
        Alumno alumno;
        try {
            em.getTransaction().begin(); //Abrir la transaccion
            alumno = em.find(Alumno.class, 1L);
            if (alumno != null) {
                String nombre = alumno.getNombre();
                em.remove(alumno);
                em.getTransaction().commit(); // Termine la transaccion
                JOptionPane.showMessageDialog(null, "El alumno: " + nombre + " fue"
                        + " eliminado correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "NO EXISTE EL ALUMNO");
            }
            em.close();
            //em.flush(); // Para guardar en la base de datos(Va a la base de datos forzando que se haga la indicacion en la BD)
            //em.refresh(alumno); // Regresar al estado anterior que se encontaba la entidad
            //tx.commit(); // Termine la transaccion
        } catch (Exception e) {
            //tx.rollback();
            //em.getTransaction().rollback();
            em.close();
        }
         */
    }
}

/**
 * *
 * CREAMOS UN PROYECTO JAVA. IMPORTAMOS LIBRERIAS DEL DRIVER DE MYSQL Y
 * ECLIPSELINK JPA(2.1). CREAMOS NUEVA BD (DESDE APARTADO SERVICES EN IDE
 * NETBEANS), CONECTADO A NUESTRO SERVIDOR. CONFIGURAMOS NUESTRO ARCHIVO
 * "PERSISTENCE.XML" DE NUESTRO PAQUETE META-INF (CREAR EL PAQUETE SI NO ESTA
 * CREADO). CREAMOS LAS ENTIDADES (NEW->ENTITY CLASS).
 *
 *
 */
