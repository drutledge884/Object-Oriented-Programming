package posPD;

import posPD.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import posPD.Item;

/**
 * the price of an item
 */
public class Price implements Comparable<Price> 
{// compare me to another me: compares objects

	/**
	 * an item
	 */
	private Item item;
	/**
	 * a price
	 */
	private BigDecimal price;
	/**
	 * the date that the price is valid until
	 */
	private LocalDate effectiveDate;

	public Item getItem() 
	{
		return this.item;
	}

	public void setItem(Item item) 
	{
		this.item = item;
	}

	public BigDecimal getPrice() 
	{
		return this.price;
	}

	public void setPrice(String price) 
	{
		this.price = new BigDecimal(price);
	}

	public LocalDate getEffectiveDate() 
	{
		return this.effectiveDate;
	}

	public void setEffectiveDate(LocalDate effectiveDate) 
	{
		this.effectiveDate = effectiveDate;
	}

	public Price() 
	{
		this.effectiveDate = LocalDate.parse("9999-12-31");
		this.price = new BigDecimal(0);
		this.price = this.price.setScale(2, RoundingMode.HALF_UP);
		// throw new UnsupportedOperationException();
	}

	/**
	 * Instantiates the Price with a price and an effective date
	 * 
	 * @param price
	 * @param effectiveDate
	 */
	public Price(String price, String effectiveDate) 
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yy");
		LocalDate newDate = LocalDate.parse(effectiveDate, formatter);
		//LocalDate newDate = LocalDate.now();
		this.effectiveDate = newDate;
		this.price = new BigDecimal(price);
		this.price = this.price.setScale(2, RoundingMode.HALF_UP);
		//this.item.addPrice(this);
	}

	/**
	 * checks to see if the price has at some point been valid
	 * 
	 * @param date
	 */
	public Boolean isEffective(LocalDate date) 
	{ // today's date is being passed in every time

		if (effectiveDate.isBefore(date))
			return true;
		if (effectiveDate.isEqual(date))
			return true;
		if (effectiveDate.isAfter(date))
			return false;
		throw new UnsupportedOperationException();
	}

	/**
	 * calculates the price of some quantity of goods
	 * 
	 * @param quantity
	 */
	public BigDecimal calcAmountForQty(int quantity) 
	{
		BigDecimal parseQuantity = new BigDecimal(quantity);
		parseQuantity = parseQuantity.setScale(2, RoundingMode.HALF_UP);
		return this.getItem().getPriceForDate(LocalDate.now()).multiply(parseQuantity);
	}

	/**
	 * compare one price to another
	 * 
	 * @param price
	 */
	@Override
	public int compareTo(Price price) 
	{// this is currently comparing the effective dates, not the prices.
		// TODO - implement Price.compareTo
		return getEffectiveDate().compareTo(price.getEffectiveDate());
		// throw new UnsupportedOperationException();
	}

	public String toString() 
	{
		String priceString = price.toString();
		return priceString;
	}

}