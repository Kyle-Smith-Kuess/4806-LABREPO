package webAPP.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class BuddyInfo {




	Long id;
	String Name;
	String Number;
	String Email;

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    String Address;

	public BuddyInfo(String name)
	{
		Name = name;
	}
	public BuddyInfo(){};
	
	public static void main(String[] args) {
		BuddyInfo Fareed = new BuddyInfo("Fareed");
		
	
		Fareed.setAll("Fareed", "911", "Fareed@Fareed.com", "123 House");//Call in case of emergency
		
		System.out.println(String.format("Hello %s, Can you still be contacted at:\nEmail:%s\nNumber:%s",Fareed.getName(),Fareed.getEmail(),Fareed.getNumber() ));
	}

	public void setAll(String name, String number, String email, String address)
	{
		setName(name);
		setNumber(number);
		setEmail(email);
		setAddress(address);
	}
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}


	public String getNumber() {
		return Number;
	}


	public void setNumber(String number) {
		Number = number;
	}


	public String getEmail() {
		return Email;
	}


	public void setEmail(String email) {
		Email = email;
	}

	@Override
	public String toString() {
		return "webAPP.Models.BuddyInfo{" +
				"Name='" + Name + '\'' +
				", Number='" + Number + '\'' +
				", Email='" + Email + '\'' +
                ", Address='" + Address + '\'' +
				'}';
	}
}
