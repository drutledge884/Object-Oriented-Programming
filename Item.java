package posPD;

import posPD.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import posPD.SaleLineItem;
import posPD.Price;
import posPD.TaxCategory;
import posPD.UPC;

/**
 * an item that the store provides
 */
public class Item 
{

	/**
	 * an item that will be sold
	 */
	private ArrayList<SaleLineItem> saleLineItems;// do these need to be the proper collections in all classes they are
													// attributes of?
	/**
	 * the price of an item
	 */
	private TreeSet<Price> prices;// every item will have effective dates for its price.
	/**
	 * the UPC for an item
	 */
	private TreeMap<String, UPC> uPCS;
	/**
	 * the tax category an item falls under
	 */
	private TaxCategory taxCategory;
	/**
	 * the inventory number of an item
	 */
	private String number;
	/**
	 * a description of an item
	 */
	private String description;

	public TreeMap<String, UPC> getUPCs() 
	{
		return this.uPCS;
	}

	public ArrayList<SaleLineItem> getSaleLineItems() 
	{
		return this.saleLineItems;
	}

	public void setSaleLineItems(ArrayList<SaleLineItem> saleLineItems) 
	{
		this.saleLineItems = saleLineItems;
	}

	public TreeSet<Price> getPrices() 
	{
		return this.prices;
	}

	public void setTaxCategory(TaxCategory taxCategory) 
	{
		this.taxCategory = taxCategory;
	}

	public TaxCategory getTaxCategory() 
	{
		return this.taxCategory;
	}

	public String getNumber() 
	{
		return this.number;
	}

	public void setNumber(String number) 
	{
		this.number = number;
	}

	public String getDescription() 
	{
		return this.description;
	}

	public void setDescription(String description) 
	{
		this.description = description;
	}

	public Item() 
	{
		// TODO - implement Item.Item
		number = new String("None");
		description = new String("Empty");
		this.prices = new TreeSet<Price>();
		this.saleLineItems = new ArrayList<SaleLineItem>();
		this.uPCS = new TreeMap<String, UPC>();
	}

	/**
	 * Instantiates an item with its number and description
	 * 
	 * @param number
	 * @param description
	 */
	public Item(String number, String description) 
	{
		this.number = number;
		this.description = description;
		this.prices = new TreeSet<Price>();
		this.saleLineItems = new ArrayList<SaleLineItem>();
		this.uPCS = new TreeMap<String, UPC>();
	}
	
	/**
	 * add a price to an item
	 * 
	 * @param price
	 */
	public void addPrice(Price price) 
	{
		prices.add(price);
	}

	/**
	 * remove a price from an item
	 * 
	 * @param price
	 */
	public void removePrice(Price price) 
	{
		prices.remove(price);
	}

	/**
	 * add a UPC for an item
	 * 
	 * @param upc
	 */
	public void addUPC(UPC upc) 
	{
		this.uPCS.put(upc.getUPC(), upc);
	}

	/**
	 * remove a UPC for an item
	 * 
	 * @param upc
	 */
	public void removeUPC(UPC upc) 
	{
		this.uPCS.remove(upc.getUPC());
	}

	/**
	 * get the price for the current date
	 * 
	 * @param date
	 * @return money
	 */
	public BigDecimal getPriceForDate(LocalDate date) 
	{
		BigDecimal money = new BigDecimal(0);
		Price tempPrice = new Price();// defaults the date to all 9's, so it will always be after the current day
		int tempInt = 0;
		for (Price price : prices) 
		{
			if (price.isEffective(date) == true) 
			{
				money = price.getPrice();
				if (tempPrice.isEffective(LocalDate.now()) != false)// always false on the first loop
				{
					tempInt = price.compareTo(tempPrice);
					if (tempInt == -1)
						money = price.getPrice();
				}
			}
			tempPrice = price;
		}
		return money;
	}

	/**
	 * get the tax rate for the current date
	 * 
	 * @param date
	 */
	public BigDecimal getTaxRateForDate(LocalDate date) 
	{
		return taxCategory.getTaxRateForDate(date);
	}

	/**
	 * calculate the amount some quantity of items costs for a date
	 * 
	 * @param date
	 * @param quantity
	 */
	public BigDecimal calcAmountForDateQty(LocalDate date, int quantity) 
	{
		BigDecimal amtForQty = new BigDecimal(0);
		amtForQty = this.getPriceForDate(date).multiply((new BigDecimal(quantity)));
		return amtForQty;
		// throw new UnsupportedOperationException();
	}

	public String toString() 
	{
		String itemInfo = new String("");
		itemInfo += getNumber();
		itemInfo += " " + getDescription();
		itemInfo += " Price: $" + getPriceForDate(LocalDate.now());
		itemInfo += " Tax Rate: " + getTaxRateForDate(LocalDate.now());
		itemInfo += " " + this.getUPCs().firstKey();

		return itemInfo;
	}

}
