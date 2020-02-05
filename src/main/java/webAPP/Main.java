package webAPP;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import webAPP.Models.AddressBook;
import webAPP.Models.BuddyInfo;
import webAPP.Models.buddyRepo;
import webAPP.Models.repo;

@SpringBootApplication
public class Main {

	private static final Logger log = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {


		SpringApplication.run(Main.class, args);
	}

	@Bean
	public CommandLineRunner demo(repo repository, buddyRepo buddies) {
		return (args) -> {
			// save a few customers
			BuddyInfo kyle = new BuddyInfo();
			kyle.setAll("Kyle","123","1@1.com", "123 house");
			BuddyInfo CoolGuy = new BuddyInfo("Cool Guy");

			AddressBook a1 = new AddressBook();

			a1.addBuddy(kyle);
			a1.addBuddy(CoolGuy);
			a1.setName("CoolBook");



			BuddyInfo MEMER = new BuddyInfo();
			MEMER.setAll("MEME","123","1@1.com","123 House");
			BuddyInfo CoolBwoy = new BuddyInfo("Cool Bwoy");

			AddressBook a2 = new AddressBook();

			a2.addBuddy(MEMER);
			a2.addBuddy(CoolBwoy);



			repository.save(a1);
			repository.save(a2);



		};
	}

}

