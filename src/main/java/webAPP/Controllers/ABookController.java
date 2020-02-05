package webAPP.Controllers;

import webAPP.Models.AddressBook;
import webAPP.Models.buddyRepo;
import webAPP.Models.repo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import webAPP.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ABookController {

	@Autowired
	private repo book;

	@Autowired
	private buddyRepo buddy;
	private static final Logger log = LoggerFactory.getLogger(Main.class);



	@GetMapping("/")
	public String getBook(Model model)
	{
		log.info("ZOO WEE MAMA");
		AddressBook bb = book.findAll().get(0);
		model.addAttribute("buds", bb.getBuddies());
		return "bilbobook";
	}

	@PostMapping("/addbud")
	public String addBuddy(@RequestParam(value = "id") Long id, Model model)
	{
		log.info("ZOO WEE MAMA 222");

		AddressBook bb = book.findAll().get(0);
		bb.addBuddy(buddy.findById(id).get());
		book.save(bb);
		model.addAttribute("buds", bb.getBuddies());
		return "bilbobook";
	}

}
