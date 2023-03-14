package posPD;

import posPD.*;
import posPD.Sale;
import posPD.Cashier;
import posPD.Register;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

/**
 * The time that a cashier and register are active
 */
public class Session 
{

	/**
	 * a sale made during the session
	 */
	private ArrayList<Sale> sales;
	/**
	 * the cashier working the session
	 */
	private Cashier cashier;
	/**
	 * the register being used in the session
	 */
	private Register register;
	/**
	 * the start date and time of the session
	 */
	private LocalDateTime startDateTime;// note that this object type is different than LocalDate
	/**
	 * the end date and time of the session
	 */
	private LocalDateTime endDateTime;

	public ArrayList<Sale> getSales() 
	{
		return this.sales;
	}

	public Cashier getCashier() 
	{
		return this.cashier;
	}

	public void setCashier(Cashier cashier) 
	{
		this.cashier = cashier;
	}

	public Register getRegister() 
	{
		return this.register;
	}

	public void setRegister(Register register) 
	{
		this.register = register;
	}

	public LocalDateTime getStartDateTime() 
	{
		return this.startDateTime;
	}

	public void setStartDateTime(LocalDateTime startDateTime) 
	{
		this.startDateTime = startDateTime;
	}

	public LocalDateTime getEndDateTime() 
	{
		return this.endDateTime;
	}

	public void setEndDateTime(LocalDateTime endDateTime) 
	{
		this.endDateTime = endDateTime;
	}

	/**
	 * Instantiates a session with a cashier and a register
	 * 
	 * @param cashier
	 * @param register
	 */
	public Session(Cashier cashier, Register register) 
	{
		this.sales = new ArrayList<Sale>();
		this.cashier = cashier;
		this.register = register;
		this.startDateTime = LocalDateTime.now();
		this.endDateTime = LocalDateTime.now();
		// throw new UnsupportedOperationException();
	}

	/**
	 * adds a sale made
	 * 
	 * @param sale
	 */
	public void addSale(Sale sale) 
	{
		this.sales.add(sale);
		// throw new UnsupportedOperationException();
	}

	/**
	 * removes a sale made
	 * 
	 * @param sale
	 */
	public void removeSale(Sale sale) 
	{
		// TODO - implement Session.removeSale
		throw new UnsupportedOperationException();
	}

	/**
	 * calculates the amount of cash at the end of the session, in comparison with
	 * the start of the session
	 * 
	 * @param cash
	 */
	public BigDecimal calcCashCountDiff(BigDecimal cash) 
	{
		return register.getCashDrawer().getCashAmount().subtract(cash);
	}

	public String toString() 
	{
		String sess = new String("Session: ");
		//sess += "Start Date: " + startDateTime.toLocalDate() + "\n";
		sess += "Cashier: " + cashier.getPerson().getName() + "";
		sess += " at register #" + register.getNumber() + " with total of: $" + this.register.getCashDrawer().getCashAmount();
		sess += " starting at " + this.getStartDateTime() + "\n";
		//System.out.println(this.getSales().size());
		for(int i = 0; i < sales.size(); i++)
		{
			//System.out.println("hi");
			sess += this.getSales().get(i).toString() + "\n";
		}
		return sess;
	}

}