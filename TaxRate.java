package posPD;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.time.format.*;
import java.time.format.DateTimeFormatterBuilder;

import posPD.*;

/**
 * A tax rate that is part of a category
 */
public class TaxRate implements Comparable<TaxRate> 
{

	private TaxCategory taxCategory;
	/**
	 * the tax rate
	 */
	private BigDecimal taxRate;
	/**
	 * the date the tax rate is valid until
	 */
	private LocalDate effectiveDate;

	/**
	 * Instantiates a TaxRate with the effectiveDate and the tax rate.
	 * 
	 * @param effectiveDate
	 * @param rate
	 */
	public TaxRate(String effectiveDate, BigDecimal rate)
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yy");
		//LocalDate newDate = LocalDate.parse(effectiveDate, formatter);
		LocalDate newDate = LocalDate.now();
		this.effectiveDate = newDate;
		//this.effectiveDate = newDate;
		this.taxRate = rate;
	}

	public TaxRate() 
	{
		//this.effectiveDate = LocalDate.parse("01/01/30");
		LocalDate newDate = LocalDate.now();
		this.effectiveDate = newDate;
		this.taxRate = new BigDecimal(0);
	}

	public BigDecimal getTaxRate() 
	{
		return this.taxRate;
	}

	public void setTaxRate(BigDecimal taxRate) 
	{
		this.taxRate = taxRate;
	}

	public LocalDate getEffectiveDate() 
	{
		return this.effectiveDate;
	}

	public void setEffectiveDate(LocalDate effectiveDate) 
	{
		this.effectiveDate = effectiveDate;
	}

	/**
	 * checks to see if a tax rate is valid
	 * 
	 * @param date
	 */
	public Boolean isEffective(LocalDate date) 
	{
		if (effectiveDate.isBefore(date))
			return true;
		if (effectiveDate.isEqual(date))
			return true;
		if (effectiveDate.isAfter(date))
			return false;
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param taxRate
	 */
	public int compareTo(TaxRate taxRate) 
	{
		return getEffectiveDate().compareTo(taxRate.getEffectiveDate());
	}

	// public String toString() {
	// TODO - implement TaxRate.toString
	// throw new UnsupportedOperationException();
	// }

	public String getEffectiveDateString() 
	{
		String srtDate = "";
		if (getTaxRate() != null)
			srtDate = getTaxRate().setScale(2, BigDecimal.ROUND_HALF_UP).toString();
		return srtDate;
	}

	public String toString() 
	{
		String rate = new String(getTaxRate().toString());
		return rate;
	}

}
