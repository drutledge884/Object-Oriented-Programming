package posPD;

import java.math.BigDecimal;

import posPD.*;

/**
 * a drawer in the register that holds cash
 */
public class CashDrawer 
{

	/**
	 * the amount of cash in the drawer
	 */
	private BigDecimal cashAmount;
	private int position;

	public BigDecimal getCashAmount() 
	{
		return this.cashAmount;
	}

	public void setCashAmount(BigDecimal cashAmount) 
	{
		this.cashAmount = cashAmount;
	}

	public CashDrawer() 
	{
		this.cashAmount = new BigDecimal(0);
		this.position = 0;
	}

	/**
	 * Instantiates a CashDrawer
	 * 
	 * @param cash
	 * @param position
	 */
	public CashDrawer(BigDecimal cash, int position) 
	{
		this.cashAmount = cash;
		this.position = position;
	}

	/**
	 * add cash to the drawer
	 * 
	 * @param cash
	 */
	public void addCash(BigDecimal cash) 
	{
		this.cashAmount = cashAmount.add(cash);
	}

	/**
	 * remove cash from the drawer
	 * 
	 * @param cash
	 */
	public void removeCash(BigDecimal cash) 
	{
		this.cashAmount = cashAmount.subtract(cash);
	}

	public String toString() 
	{
		String drawer = new String();
		drawer += "Cash: " + getCashAmount();
		return drawer;
	}

}