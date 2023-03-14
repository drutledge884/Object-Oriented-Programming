package posPD;

import java.math.BigDecimal;

import posPD.*;

/**
 * a cash payment
 */
public class Cash extends Payment 
{

	public Cash() 
	{
		this.setAmount(new BigDecimal(0));
		this.setAmtTendered(new BigDecimal(0));
	}

	/**
	 * Instantiates cash with the amount needed and the amount given
	 * 
	 * @param amount
	 * @param amtTendered
	 */
	public Cash(String amount, BigDecimal amtTendered) 
	{
		this.setAmount(new BigDecimal(amount));
		this.setAmtTendered(amtTendered);
	}

	/**
	 * calculates the change needed
	 */
	public BigDecimal calcChange() 
	{
		throw new UnsupportedOperationException();
	}

	/**
	 * checks if the payment method counts as cash
	 */
	public Boolean countsAsCash() 
	{
		return true;
	}

	public String toString() 
	{
		String cashString = this.getAmount().toString();
		return cashString;
	}

}
