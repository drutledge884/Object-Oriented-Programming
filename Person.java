package posPD;

import posPD.*;
import posPD.Cashier;

/**
 * Works inside the store
 */
public class Person 
{

	/**
	 * Every Person is a Cashier
	 */
	private Cashier cashier;
	/**
	 * The name of a person
	 */
	private String name;
	/**
	 * The address of a Person
	 */
	private String address;
	/**
	 * The phone number of a person
	 */
	private String phone;
	/**
	 * The SSN of a person
	 */
	private String sSN;
	
	private String state;
	
	private String zip;

	public Cashier getCashier() 
	{
		return this.cashier;
	}

	public void setCashier(Cashier cashier) 
	{
		this.cashier = cashier;
	}
	
	public void setZIP(String zip)
	{
		this.zip = zip;
	}
	
	public String getZIP()
	{
		return this.zip;
	}

	public String getName() 
	{
		return this.name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public String getAddress() 
	{
		return this.address;
	}

	public void setAddress(String address) 
	{
		this.address = address;
	}
	
	public String getState()
	{
		return this.state;
	}

	public String getPhone() 
	{
		return this.phone;
	}
	
	public void setState(String state)
	{
		this.state = state;
	}

	public void setPhone(String phone) 
	{
		this.phone = phone;
	}

	public String getSSN() 
	{
		return this.sSN;
	}

	public void setSSN(String sSN) 
	{
		this.sSN = sSN;
	}

	public Person() 
	{
		this.address = new String();
		// this.cashier = new Cashier();
		this.phone = new String();
		this.name = new String();
		this.sSN = new String();
	}

	/**
	 * Instantiates a person with their name, number, address, and SSN
	 * 
	 * @param name
	 * @param address
	 * @param phone
	 * @param sSN
	 */
	public Person(String name, String address, String phone, String sSN) 
	{
		this.name = new String(name);
		this.address = new String(address);
		this.phone = new String(phone);
		this.sSN = new String(sSN);
		// throw new UnsupportedOperationException();
	}

	public String toString() 
	{
		// TODO - implement Person.toString
		String personInfo = new String(getName() + "\n");
		personInfo += "Address: " + this.address + " \n";
		personInfo += "Phone: " + this.phone + " \n";
		personInfo += "SSN: " + this.sSN;
		return personInfo;
		// throw new UnsupportedOperationException();
	}

}