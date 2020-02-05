package webAPP.Models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
public class AddressBook {


	private Long id;
	private List<BuddyInfo> buddies = new ArrayList<BuddyInfo>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

	@OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	public List<BuddyInfo> getBuddies() {
		return buddies;
	}

	public void setBuddies(List<BuddyInfo> buddies) {
		this.buddies = buddies;
	}
	
	public void addBuddy(BuddyInfo newBuddy)
	{
		if (newBuddy != null)
		{
			buddies.add(newBuddy);
		}
	}
	public void removeBuddy(int index)
	{
		if(index >= 0 && index < buddies.size())
		{
			buddies.remove(index);  
		}
	}
	public void clear()
	{
		while(buddies.size() > 0)
		{
			removeBuddy(0);
		}
	}
	public int size()
	{
		return buddies.size();
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BuddyInfo kyle = new BuddyInfo();
		kyle.setAll("Kyle","123","1@1.com");
		BuddyInfo CoolGuy = new BuddyInfo("Cool Guy");

		AddressBook book = new AddressBook();
		
		book.addBuddy(kyle);
		book.addBuddy(CoolGuy);

		System.out.println("Address book contains: " + book.getBuddies());
	}
}
