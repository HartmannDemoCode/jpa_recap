package facade;

import entities.Borrower;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class LibraryFacade {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");

    public LibraryFacade(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public Borrower createBorrower(Borrower borrower) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(borrower);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return borrower;
    }

    public static void main(String[] args) {
        LibraryFacade facade = new LibraryFacade(emf);
        Borrower borrower = new Borrower("1101", "John", java.time.LocalDate.now(),"Rolighedsvej 22");
        Borrower b = facade.createBorrower(borrower);
        System.out.println(b);
    }

}
