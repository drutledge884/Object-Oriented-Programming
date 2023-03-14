package posPD;
/**
 * Responsible for validating payment methods
 */
abstract public class AuthorizedPayment extends Payment 
{
	/**
	 * the authorization code
	 */
	private String authorizationCode;

	public AuthorizedPayment() 
	{
		this.authorizationCode = new String("void");
	}

	public AuthorizedPayment(String authorizationCode) 
	{
		this.authorizationCode = authorizationCode;
	}

	public String getAuthorizationCode() 
	{
		return this.authorizationCode;
	}

	public void setAuthorizationCode(String authorizationCode) 
	{
		this.authorizationCode = authorizationCode;
	}

	/**
	 * checks to see if a payment is authorized
	 */
	public Boolean isAuthorized() 
	{
		return true;// keeps it simple
	}

	/**
	 * checks to see if a payment methods counts as paying with cash
	 */
	public Boolean countsAsCash() 
	{
		// TODO - implement AuthorizedPayment.countsAsCash
		throw new UnsupportedOperationException();
	}

}