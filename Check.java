package posPD;

import java.math.BigDecimal;

//import posPD.*;

//when paying with a check
public class Check extends AuthorizedPayment 
{
	private String routingNumber; //routing number of the check
	
	private String accountNumber; //account number of the check
	
	private String checkNumber; //number of the check

	public String getRoutingNumber() 
	{
		return this.routingNumber;
	}

	public void setRoutingNumber(String routingNumber) 
	{
		this.routingNumber = routingNumber;
	}

	public String getAccountNumber() 
	{
		return this.accountNumber;
	}

	public void setAccountNumber(String accountNumber) 
	{
		this.accountNumber = accountNumber;
	}

	public String getCheckNumber() 
	{
		return this.checkNumber;
	}

	public void setCheckNumber(String checkNumber) 
	{
		this.checkNumber = checkNumber;
	}

	public Check() 
	{
		this.setAmount(new BigDecimal(0));
		this.routingNumber = new String("0000000000");
		this.accountNumber = new String("0000000000");
		this.checkNumber = new String("0000000000");
	}

	/**
	 * Instantiates a Check with the amount, the account number, and the
	 * check number
	 * 
	 * @param amount
	 * @param accountNumber
	 * @param checkNumber
	 */
	public Check(String amount, String routingNumber, String accountNumber, String checkNumber) 
	{
		this.routingNumber = routingNumber;

		this.setAmount(new BigDecimal(amount));
		this.accountNumber = accountNumber;
		this.checkNumber = checkNumber;
	}

	public Boolean isAuthorized() //checks to see if the check is valid
	{
		return true;
	}
	
	public BigDecimal calcChange() //calculates the change that needs to be given
	{
		// TODO - implement Check.calcChange
		throw new UnsupportedOperationException();
	}

	public String toString() 
	{
		String checkInfo = new String("Filler string for info");
		return checkInfo;
	}
}