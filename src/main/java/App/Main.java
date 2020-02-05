package App;

import App.Models.AddressBook;
import App.Models.BuddyInfo;
import App.Models.buddyRepo;
import App.Models.repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class Main {

	private static final Logger log = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}
/*
	@Bean
	public CommandLineRunner demo(repo repository) {
		return (args) -> {
			// save a few customers
			BuddyInfo kyle = new BuddyInfo();
			kyle.setAll("Kyle","123","1@1.com");
			BuddyInfo CoolGuy = new BuddyInfo("Cool Guy");

			AddressBook a1 = new AddressBook();

			a1.addBuddy(kyle);
			a1.addBuddy(CoolGuy);
			a1.setName("CoolBook");
			BuddyInfo MEMER = new BuddyInfo();
			kyle. setAll("MEME","123","1@1.com");
			BuddyInfo CoolBwoy = new BuddyInfo("Cool Bwoy");

			AddressBook a2 = new AddressBook();

			a2.addBuddy(MEMER);
			a2.addBuddy(CoolBwoy);



			repository.save(a1);
			repository.save(a2);


			// fetch all customers
			log.info("Everything found with findAll():");
			log.info("-------------------------------");
			for (AddressBook a : repository.findAll()) {
				log.info("Address Book id=" + a.getId());
				log.info("List of Buddy\n----------------");

				for (BuddyInfo b : a.getBuddies()) {
					log.info(b.getName() + " (id=" + b.getId() + ")");
				}
			}

			log.info("");

			// fetch an individual book by ID
			AddressBook book = repository.findById(1L);
			log.info("Book found with findById(1L):");
			log.info("--------------------------------");
			log.info(book.toString());
			log.info("");

			// fetch book by last name
			log.info("Customer found with findByLastName('Bauer'):");
			log.info("--------------------------------------------");
			repository.findByName("CoolBook").forEach(CoolBook -> {
				log.info("Address Book id=" + CoolBook.getId());
				log.info("List of Buddy\n----------------");

				for (BuddyInfo b : CoolBook.getBuddies()) {
					log.info(b.getName() + " (id=" + b.getId() + ")");
				}
			});
			// for (Customer bauer : repository.findByLastName("Bauer")) {
			//  log.info(bauer.toString());
			// }
			log.info("");
		};
	}
*/
}

