package posPD;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

import posPD.*;

/**
 * Items that are being sold
 */
public class SaleLineItem 
{

	/**
	 * an item to be sold
	 */
	private Item item;
	/**
	 * some amount of an item
	 */
	private int quantity;
	private Sale sale;

	/**
	 * Instantiates an item being sold with its item number and how many there are
	 * 
	 * @param itemNumber
	 * @param quantity
	 */
	public SaleLineItem(Item item, String quantity) 
	{
		this.item = item;
		this.quantity = Integer.parseInt(quantity);
	}

	public SaleLineItem() 
	{
		this.item = new Item();
		this.quantity = 0;
	}

	public Item getItem() 
	{
		return this.item;
	}

	public void setItem(Item item) 
	{
		this.item = item;
	}

	public int getQuantity() 
	{
		return this.quantity;
	}

	public void setQuantity(int quantity) 
	{
		this.quantity = quantity;
	}

	/**
	 * calculates the sub total, which is the amount before tax
	 */
	public BigDecimal calcSubTotal() 
	{
		BigDecimal price1 = new BigDecimal(0);
		
		if(this.item.getDescription() == "Turkey Sandwich")
		{
			price1 = new BigDecimal("2.59");
		}
		else if(this.item.getDescription() == "Ham Sandwich")
		{
			price1 = new BigDecimal("2.59");
		}
		else if(this.item.getDescription() == "Coke")
		{
			price1 = new BigDecimal("0.97");
		}
		else if(this.item.getDescription() == "Dr. Pepper")
		{
			price1 = new BigDecimal("0.97");
		}
		price1 = item.getPriceForDate(sale.getDateTime().toLocalDate());
		//price1 = price1.setScale(2, RoundingMode.HALF_UP);
		price1.setScale(2, RoundingMode.HALF_UP);
		BigDecimal subTotal = price1.multiply(new BigDecimal(this.quantity));
		subTotal = subTotal.setScale(2, RoundingMode.HALF_UP);
		return subTotal;
	}

	/**
	 * calculates the total of the sale line item
	 * 
	 * @return total
	 */
	public BigDecimal calcTotal() 
	{
		BigDecimal total = new BigDecimal(0);
		total = total.add(calcSubTotal());
		BigDecimal tax = calcTax();
		total = total.add(tax);
		total = total.setScale(2, RoundingMode.HALF_UP);
		return total;
	}

	/**
	 * calculates the tax
	 */
	public BigDecimal calcTax() 
	{// can we assume the LocalDate.now()?
		// this returns the monetary tax amount
		//BigDecimal multiplier = new BigDecimal(0);
		//multiplier.add(1.0);
		BigDecimal tax = new BigDecimal(0);
		tax = this.calcSubTotal().multiply(item.getTaxRateForDate(sale.getDateTime().toLocalDate()));
		tax = tax.setScale(2, RoundingMode.HALF_UP);
		return tax;
	}

	public Sale getSale() 
	{
		return sale;
	}

	public void setSale(Sale sale) 
	{
		this.sale = sale;
	}

	public String toString()
	{
		//String sli = new String("Item #: " + this.item.getNumber() + " " + this.getQuantity() + " units");
		String sli = new String(this.getQuantity() + " x " + this.item.getDescription() + " for $" + this.item.getPriceForDate(LocalDate.now()));
		return sli;
	}

}