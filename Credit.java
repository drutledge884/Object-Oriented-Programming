package posPD;

import java.math.BigDecimal;
import java.time.LocalDate;

import posPD.*;

/**
 * payment with a credit card
 */
public class Credit extends AuthorizedPayment 
{

	/**
	 * the type of card
	 */
	private String cardType;
	/**
	 * the account number associated with the card
	 */
	private String acctNumber;
	/**
	 * the expiration date of the card
	 */
	private LocalDate expireDate;

	public String getCardType() 
	{
		return this.cardType;
	}

	public void setCardType(String cardType) 
	{
		this.cardType = cardType;
	}

	public String getAcctNumber() 
	{
		return this.acctNumber;
	}

	public void setAcctNumber(String acctNumber) 
	{
		this.acctNumber = acctNumber;
	}

	public LocalDate getExpireDate() 
	{
		return this.expireDate;
	}

	public void setExpireDate(LocalDate expireDate) 
	{
		this.expireDate = expireDate;
	}

	public Credit() 
	{
		this.cardType = new String("none");
		this.acctNumber = new String("00000");
		this.expireDate = LocalDate.now();
	}

	/**
	 * Instantiates a Credit Card with its type, account number, and expiration date
	 * 
	 * @param cardType
	 * @param acctNumber
	 * @param expireDate
	 */
	public Credit(String cardType, String acctNumber, LocalDate expireDate) 
	{
		this.cardType = cardType;
		this.acctNumber = acctNumber;
		this.expireDate = expireDate;
	}

	/**
	 * checks to see if the card is valid
	 */
	public Boolean isAuthorized() 
	{
		return true;
	}

	public Boolean countsAsCash() 
	{
		return false;
	}

	/**
	 * calculates the change that needs to be given
	 */
	public BigDecimal calcChange() 
	{
		// TODO - implement Credit.calcChange
		throw new UnsupportedOperationException();
	}

	public String toString() 
	{
		// TODO - implement Credit.toString
		String creditString = this.getCardType();
		return creditString;
	}

}