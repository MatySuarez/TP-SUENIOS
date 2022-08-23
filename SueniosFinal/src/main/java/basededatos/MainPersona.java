package basededatos;

import  basededatos.db;
import  basededatos.dbPersona;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.lang.String;

public class MainPersona {

    public static void main(String[] args) {
        db datos = new db();
        datos.leerPersona();

        List<dbPersona> listaPersonas = datos.getListaPersonas();

        for (dbPersona persona: listaPersonas) {
            guardar(persona);
        }

        List<dbPersona> personasIngresadas = buscarPersonas();

        System.out.println("Ingresando datos a base de datos...");
        System.out.println();

        System.out.println("---------------------------------------------------------------------------------------");
        System.out.printf("%10s %20s %20s %20s", "NOMBRE", "APELLIDO", "EDAD", "SUENIO");
        System.out.println();
        System.out.println("---------------------------------------------------------------------------------------");
        assert personasIngresadas != null;
        for (dbPersona persona: personasIngresadas) {
            System.out.format("%10s %20s %20d %20s", persona.getNombre(), persona.getApellido(), persona.getEdad(), persona.getSuenio());
            System.out.println();
        }
        System.out.println("---------------------------------------------------------------------------------------");
    }

    private static void guardar(dbPersona personaFichero) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Personas");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(personaFichero);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    private static List<dbPersona> buscarPersonas() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Personas");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            return em.createQuery("SELECT p FROM dbPersona p", dbPersona.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return null;
    }

}
