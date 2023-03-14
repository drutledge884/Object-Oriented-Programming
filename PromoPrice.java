package posPD;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import posPD.*;

/**
 * a promotional price for an item
 */
public class PromoPrice extends Price 
{

	/**
	 * the last day the promo price is valid
	 */
	private LocalDate endDate;

	public LocalDate getEndDate() 
	{
		return this.endDate;
	}

	public void setEndDate(LocalDate endDate) 
	{
		this.endDate = endDate;
	}

	public PromoPrice() 
	{
		this.endDate = LocalDate.of(9999, 12, 31);
	}

	/**
	 * Instantiates the promo price with the price and valid dates
	 * 
	 * @param price
	 * @param effectiveDate
	 * @param endDate
	 */
	public PromoPrice(String price, String effectiveDate, String endDate) 
	{
		DateTimeFormatter formatters = DateTimeFormatter.ofPattern("M/d/yy");
		LocalDate newDate = LocalDate.parse(effectiveDate, formatters);
		//LocalDate newDate = LocalDate.now();
		LocalDate newEndDate = LocalDate.parse(endDate, formatters);
		//LocalDate newEndDate = newDate.plusDays(60);
		this.setPrice(price);
		this.setEffectiveDate(newDate);
		this.setEndDate(newEndDate);
	}

	/**
	 * checks to see if the promo price is still valid
	 * 
	 * @param date
	 */
	public Boolean isEffective(LocalDate date) 
	{
		if (date.isBefore(this.getEndDate()))
			return true;
		if (date.isEqual(this.getEndDate()))
			return true;
		if (date.isAfter(this.getEndDate()))
			return false;
		throw new UnsupportedOperationException();
	}

	/**
	 * compares the promo price to the regular price
	 * 
	 * @param price
	 */
	public int compareTo(Price price) 
	{
		return getEffectiveDate().compareTo(price.getEffectiveDate());
	}

	public String toString() 
	{
		String promo = new String(this.getPrice().toString());
		return promo;
	}

}