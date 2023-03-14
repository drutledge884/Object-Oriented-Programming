package posPD;

import posPD.*;
import posPD.Session;
import posPD.Person;
import java.util.*;

/**
 * A Person who works a register
 */
public class Cashier 
{

	/**
	 * Every Cashier is a Person
	 */
	private Person person;
	/**
	 * The session the cashier is active
	 */
	private ArrayList<Session> sessions;
	/**
	 * The cashier ID number
	 */
	private String number;
	/**
	 * A password to access the register
	 */
	private String password;

	public Person getPerson() 
	{
		return this.person;
	}

	public void setPerson(Person person) 
	{
		this.person = person;
	}

	public ArrayList<Session> getSessions() 
	{
		return this.sessions;
	}

	public String getNumber() 
	{
		return this.number;
	}

	public void setNumber(String number) 
	{
		this.number = number;
	}

	public String getPassword() 
	{
		return this.password;
	}

	public void setPassword(String password) 
	{
		this.password = password;
	}

	public Cashier() 
	{
		this.password = new String();
		this.number = new String();
		this.person = new Person();
	}

	/**
	 * Instantiates a Cashier with their ID number and Person information
	 * 
	 * @param number
	 * @param person
	 * @param password
	 */
	public Cashier(String number, Person person, String password) 
	{
		this.number = new String(number);
		this.person = person;
		this.password = new String(password);
	}

	/**
	 * Creates a session
	 * 
	 * @param session
	 */
	public void addSession(Session session) 
	{
		sessions.add(session);
	}

	/**
	 * Ends the session and saves that session's data
	 * 
	 * @param session
	 */
	public void removeSession(Session session) 
	{
		sessions.remove(session);
	}

	/**
	 * Checks if the user is authorized to work a register
	 * 
	 * @param password
	 */
	public Boolean isAuthorized(String password) 
	{
		if (this.password.equals(password))
			return true;
		else
			return false;
	}

	public String toString() 
	{
		String cashierInfo = new String("Cashier #" + getNumber());
		cashierInfo += ": " + getPerson().getName();
		return cashierInfo;
	}

}