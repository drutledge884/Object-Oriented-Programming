package posPD;

import posPD.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

/**
 * a category of taxation that will be different for various items
 */
public class TaxCategory 
{

	/**
	 * a description of the tax category
	 */
	private String category;
	/**
	 * the rates associated with a category
	 */
	private TreeSet<TaxRate> taxRates;

	/**
	 * Instantiates a Tax Category with a description of the category
	 * 
	 * @param category
	 */
	public TaxCategory(String category) 
	{
		this.category = category;
		this.taxRates = new TreeSet<TaxRate>();
	}

	public TaxCategory() 
	{
		this.category = new String("None");
		this.taxRates = new TreeSet<TaxRate>();
	}

	public String getCategory() 
	{
		return this.category;
	}

	public void setCategory(String category) 
	{
		this.category = category;
	}

	public TreeSet<TaxRate> getTaxRates() 
	{
		return this.taxRates;
	}

	/**
	 * gets the tax rate for the date
	 * 
	 * @param date
	 */
	public BigDecimal getTaxRateForDate(LocalDate date) 
	{
		BigDecimal money = new BigDecimal(0);
		TaxRate tempRate = new TaxRate(date.toString(), money);
		int tempInt = 0;
		
		for (TaxRate taxRate : taxRates) 
		{
			if (taxRate.isEffective(date)) 
			{

				money = taxRate.getTaxRate();
				if (tempRate.isEffective(LocalDate.now()) != false)// this will always be false on the first loop
				{
					tempInt = taxRate.compareTo(tempRate);
					if (tempInt == -1)
						money = taxRate.getTaxRate();
				}
			}
			tempRate = taxRate;
		}
		
		return money;
	}

	/**
	 * adds a tax rate to the category
	 * 
	 * @param taxRate
	 */
	public void addTaxRate(TaxRate taxRate) 
	{
		taxRates.add(taxRate);
	}

	public String toString() 
	{
		String categoryInformation = new String();
		categoryInformation += getCategory() + ". ";
		return categoryInformation;

	}

	/**
	 * removes a tax rate from the category
	 * 
	 * @param taxRate
	 */
	public void removeTaxRate(TaxRate taxRate) 
	{
		taxRates.remove(taxRate);
	}

}