package posPD;

import java.util.ArrayList;
import posPD.*;
import posPD.CashDrawer;

/**
 * Used to transact sales and hold cash
 */
public class Register 
{

	/**
	 * a drawer that holds cash from sales
	 */
	private CashDrawer cashDrawer;
	/**
	 * the number of the register
	 */
	private String number;

	private ArrayList<Session> sessions;

	public CashDrawer getCashDrawer() 
	{
		return this.cashDrawer;
	}

	public void setCashDrawer(CashDrawer cashDrawer) 
	{
		this.cashDrawer = cashDrawer;
	}

	public String getNumber() 
	{
		return this.number;
	}

	public void setNumber(String number) 
	{
		this.number = number;
	}

	public void addSession(Session session) 
	{
		sessions.add(session);
	}

	public ArrayList<Session> getSessions() 
	{
		return sessions;// use this later, so that the GUI will work
	}

	public Register() 
	{
		this.number = new String("none");
		this.cashDrawer = new CashDrawer();

	}

	/**
	 * Instantiates a register with its number
	 * 
	 * @param number
	 */
	public Register(String number) 
	{
		this.number = number;
		this.cashDrawer = new CashDrawer();
	}

	public String toString() 
	{
		String regInfo = new String("Register #" + this.number + " $" + cashDrawer.getCashAmount());
		return regInfo;
	}

	public Boolean isUsed() 
	{
		if (getSessions().size() > 0)
			return true;
		else
			return false;
	}

}