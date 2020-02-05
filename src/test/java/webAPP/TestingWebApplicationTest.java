package webAPP;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import webAPP.Models.AddressBook;
import webAPP.Models.BuddyInfo;
import webAPP.Models.repo;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class TestingWebApplicationTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private repo book;

    @Test
    public void shouldReturnDefaultMessage() throws Exception {
        //CommandLineRunner should have put a buddy named MEME
        this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("MEME")));
    }
    @Test
    public void addressTest() throws Exception {
        //CommandLineRunner should have put a buddy named MEME
        AddressBook bb = book.findById(0);
        BuddyInfo newBud = new BuddyInfo();
        newBud.setAll("Bonobo","123456789", "123@house.com","123 house");
        bb.addBuddy(newBud);
        book.save(bb);
        this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("123 house")));
    }
/*
    @Test
    public void addBud() throws Exception {
        this.mockMvc.perform(get("/addbud?id=6"));

        this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Cool Bwoy")));
    }
    */
}