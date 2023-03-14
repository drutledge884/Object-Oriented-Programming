package posPD;

import posPD.*;

import java.math.BigDecimal;

public class Payment 
{

	private BigDecimal amount;// what counts towards the total payment
	private BigDecimal amtTendered;// how much they give you

	public void setAmount(BigDecimal amount) 
	{
		this.amount = amount;
	}

	public BigDecimal getAmount() 
	{
		return this.amount;
	}

	public void setAmtTendered(BigDecimal amtTendered) 
	{
		this.amtTendered = amtTendered;
	}

	public BigDecimal getAmtTendered() 
	{
		return this.amtTendered;
	}

	public BigDecimal calcChange() 
	{
		// TODO - implement Payment.calcChange
		throw new UnsupportedOperationException();
	}

	public Boolean countsAsCash() 
	{
		if (countsAsCash()) 
		{
			return true;
		} else
			return false;
	}

}
