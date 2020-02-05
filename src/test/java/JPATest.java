import static org.junit.Assert.*;

import App.Models.AddressBook;
import App.Models.BuddyInfo;
import org.junit.Test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class JPATest {

    @Test
	public void performJPA() {


		// Creating objects representing some products
		BuddyInfo buddy1 = new BuddyInfo();
		buddy1.setName("Kyle");

		BuddyInfo buddy2 = new BuddyInfo();
		buddy2.setName("Meet");

        AddressBook ABook = new AddressBook();
        ABook.addBuddy(buddy1);
        ABook.addBuddy(buddy2);

		// Connecting to the database through EntityManagerFactory
		// connection details loaded from persistence.xml
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-test");

		EntityManager em = emf.createEntityManager();

		// Creating a new transaction
		EntityTransaction tx = em.getTransaction();

		tx.begin();

		// Persisting the product entity objects
		em.persist(ABook);
		em.persist(buddy1);
		em.persist(buddy2);

		tx.commit();

		// Querying the contents of the database using JPQL query
		Query q = em.createQuery("SELECT b FROM AddressBook b");

		@SuppressWarnings("unchecked")
		List<AddressBook> results = q.getResultList();

     	System.out.println("List of Address Books\n----------------");
		for (AddressBook a : results) {
            System.out.println("Address Book id=" + a.getId());
            System.out.println("List of Buddy\n----------------");

            for (BuddyInfo b : a.getBuddies()) {
                assertTrue(b.getName() == "Kyle" || b.getName() == "Meet");
                System.out.println(b.getName() + " (id=" + b.getId() + ")");
            }

		}

		// Closing connection
		em.close();

		emf.close();
	}
}