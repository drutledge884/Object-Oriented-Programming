package posPD;

import posPD.*;
import posPD.Payment;
import posPD.SaleLineItem;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

/**
 * a sale made during the session
 */
public class Sale 
{

	/**
	 * payments made by a customer
	 */
	private ArrayList<Payment> payments;
	/**
	 * items that are on the sale
	 */
	private ArrayList<SaleLineItem> saleLineItems;
	/**
	 * the date and time the sale was made
	 */
	private LocalDateTime dateTime;
	/**
	 * checks to see if an item does not need to be taxed
	 */
	private Boolean taxFree;

	public ArrayList<Payment> getPayments() 
	{
		return this.payments;
	}

	public ArrayList<SaleLineItem> getSaleLineItems()
	{
		return this.saleLineItems;
	}

	public LocalDateTime getDateTime() 
	{
		return this.dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) 
	{
		this.dateTime = dateTime;
	}

	public Boolean getTaxFree() 
	{
		return this.taxFree;
	}

	public void setTaxFree(Boolean taxFree) 
	{
		this.taxFree = taxFree;
	}

	public Sale() 
	{
		this.payments = new ArrayList<Payment>();
		this.saleLineItems = new ArrayList<SaleLineItem>();
		this.dateTime = LocalDateTime.now();
		this.taxFree = false;
	}

	/**
	 * Instantiates a sale with an item before tax
	 * 
	 * @param taxFree
	 */
	public Sale(String taxFree) 
	{
		// TODO - implement Sale.Sale
		this.payments = new ArrayList<Payment>();
		this.saleLineItems = new ArrayList<SaleLineItem>();
		this.dateTime = LocalDateTime.now();
		if (taxFree.equals("y"))
			setTaxFree(true);
		if (taxFree.equals("Y"))
			setTaxFree(true);
		if (taxFree.equals("n"))
			setTaxFree(false);
		if (taxFree.equals("N"))
			setTaxFree(false);
	}

	/**
	 * add a payment
	 * 
	 * @param payment
	 */
	public void addPayment(Payment payment) 
	{
		this.payments.add(payment);

	}

	/**
	 * remove a payment
	 * 
	 * @param payment
	 */
	public void removePayment(Payment payment) 
	{
		this.payments.remove(payment);
	}

	/**
	 * 
	 * @param sli
	 */
	public void addSaleLineItem(SaleLineItem sli) 
	{
		this.saleLineItems.add(sli);
		sli.setSale(this);
	}

	/**
	 * 
	 * @param sli
	 */
	public void removeSaleLineItem(SaleLineItem sli) 
	{
		this.saleLineItems.remove(sli);
	}

	/**
	 * calculate the total cost of the sale
	 */
	public BigDecimal calcTotal() 
	{

		BigDecimal tempTotal = calcSubTotal().add(calcTax());
		return tempTotal;
	}

	/**
	 * calculate the sub total
	 */
	public BigDecimal calcSubTotal() 
	{
		BigDecimal tempTotal = new BigDecimal(0);
		for (SaleLineItem sli : saleLineItems) 
		{
			tempTotal = tempTotal.add(sli.calcSubTotal());
			//System.out.println(sli.calcSubTotal() + "\n");
		}
		tempTotal = tempTotal.setScale(2, RoundingMode.HALF_UP);
		return tempTotal;
	}

	/**
	 * calculate the tax of the sale
	 */
	public BigDecimal calcTax() 
	{
		BigDecimal tempTotal = new BigDecimal(0);
		
		tempTotal = tempTotal.setScale(2, RoundingMode.HALF_UP);
		if (getTaxFree()) 
		{
			return tempTotal;
		}
		//System.out.println(" SIZE IS: " + saleLineItems.size());
		for (SaleLineItem sli : saleLineItems) 
		{
			tempTotal = tempTotal.add(sli.calcTax());
		}
		
		return tempTotal;
	}

	public BigDecimal getTotalPayments() 
	{
		BigDecimal tempAmount = new BigDecimal(0);
		for (Payment payment : payments) 
		{
			tempAmount = tempAmount.add(payment.getAmount());
		}
		tempAmount = tempAmount.setScale(2, RoundingMode.HALF_UP);
		return tempAmount;
	}

	/**
	 * checks to see if the payment made is enough to cover the cost of the sale
	 */
	public Boolean isPaymentEnough() 
	{
		if (getTotalPayments() == calcTotal()) 
		{
			return true;
		} else
			return false;
	}

	/**
	 * if the amount tendered is enough to cover the payment, return the amount of
	 * change owed. If the payment is not enough, return the amount of money that is
	 * needed to complete the sale.
	 * 
	 * @param amtTendered
	 */
	public BigDecimal calcAmount(BigDecimal amtTendered) 
	{
		BigDecimal need = new BigDecimal(0);// sets change to zero
		BigDecimal keep = new BigDecimal(0);
		need = calcTotal().subtract(getTotalPayments());
		if (need.compareTo(amtTendered) > 0) 
		{
			keep = amtTendered;
		} else
			keep = need;

		return keep;
	}

	/**
	 * calculate the change that needs to be given to the sale
	 */
	public BigDecimal calcChange() 
	{
		// change = total cost - amtTendered, as long as cost < amtTendered.
		BigDecimal change = new BigDecimal(0);
		change = calcAmtTendered().subtract(calcTotal());
		change = change.setScale(2, RoundingMode.HALF_UP);
		return change;
	}

	public BigDecimal calcAmtTendered() 
	{
		// this only adds what is authorized
		BigDecimal totalAmtTendered = new BigDecimal(0);
		for (Payment payment : payments) 
		{
			totalAmtTendered = totalAmtTendered.add(payment.getAmtTendered());
		}
		totalAmtTendered = totalAmtTendered.setScale(2, RoundingMode.HALF_UP);
		return totalAmtTendered;
	}

	public String toString() 
	{
		String saleInfo = new String("\tSale: ");
		saleInfo += "subtotal: $";
		saleInfo += this.calcSubTotal() + "   ";
		saleInfo += "tax: $";
		saleInfo += this.calcTax() + "   ";
		saleInfo += "total: $";
		saleInfo += this.calcTotal() + "   ";
		saleInfo += "payment: $";
		saleInfo += this.calcAmtTendered() + "   ";
		saleInfo += " change: $";
		saleInfo += this.calcChange() + "   ";
		for(int i = 0; i < this.getSaleLineItems().size(); i++)
		{
			saleInfo += "\n\t\t" + this.getSaleLineItems().get(i).toString();
		}
		
		return saleInfo;
	}
}
