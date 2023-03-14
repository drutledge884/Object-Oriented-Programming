package posDM;

import java.math.BigDecimal;
import posPD.*;
import posTest.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.io.*;

public class DataManagement 
{
	/**
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Store myStore = new Store();
		myStore = dataPopulate(myStore);
		
	}
	**/
	
	public Store dataPopulate(Store myStore)
	{
		String fileName = "StoreData_v2021.csv";
		String line = null;
		String[] token;
		String dataRowClass;
		
	    try 
	    {
	        // FileReader reads text files in the default encoding.
	        FileReader fileReader = new FileReader(fileName);

	        // Always wrap FileReader in BufferedReader.
	        BufferedReader bufferedReader = new BufferedReader(fileReader);

	        while((line = bufferedReader.readLine()) != null) 
	        {
		       	token = line.split(",");
		       	dataRowClass = token[0];
		       	
		       	if (dataRowClass.equals("Store"))
		       	{
		       		myStore.setName(token[1]);
		       	}
		       	else if (dataRowClass.equals("TaxCategory"))
		       	{
		       		TaxCategory category1 = new TaxCategory(token[1]);
		       		BigDecimal tempDec = new BigDecimal(token[2]);
		       		TaxRate rate1 = new TaxRate(token[3], tempDec);
		       		category1.addTaxRate(rate1);
		       		myStore.addTaxCategory(category1);
		       	}
		       	else if (dataRowClass.equals("Cashier"))
		       	{
		       		Person person1 = new Person(token[2], token[4], token[8], token[3]);
		       		person1.setSSN(token[3]);
		       		person1.setState(token[6]);
		       		person1.setZIP(token[7]);
		       		person1.setPhone(token[8]);
		       		Cashier cashier1 = new Cashier(token[1], person1, token[9]);
		       		myStore.addCashier(cashier1);
		       	}
		       	else if (dataRowClass.equals("Register"))
		       	{
		       		Register register1 = new Register(token[1]);
		       		myStore.addRegister(register1);
		       	}
		       	else if (dataRowClass.equals("Item"))
		       	{
		       		Item item1 = new Item(token[1], token[3]);
		       		UPC upc1 = new UPC(token[2]);
		       		item1.setTaxCategory(myStore.findTaxCategoryForName(token[4]));
		       		if(token.length > 7) //if it's an item with a promo price
		       		{
		       			Price price1 = new Price(token[5], token[6]);
		       			PromoPrice promo1 = new PromoPrice(token[7], token[8], token[9]);
		       			item1.addPrice(promo1);
		       			item1.addPrice(price1);
		       			item1.addUPC(upc1);
		       			myStore.addItem(item1);
		       		}
		       		else if(token.length < 8) //if it's an item without a promo price
		       		{
		       			Price price1 = new Price(token[5], token[6]);
		       			item1.addPrice(price1);
		       			item1.addUPC(upc1);
		       			myStore.addItem(item1);
		       		}
		       	}
		       	else if (dataRowClass.equals("Session"))
		       	{
		       		Session session1 = new Session(myStore.findCashierForNumber(token[1]), myStore.findRegisterbyNumber(token[2]));
		       		myStore.addSession(session1);
		       	}
		       	else if (dataRowClass.equals("Sale"))
		       	{
		       		Sale sale1 = new Sale(token[1]);
		       		myStore.getSessions().get(myStore.getSessions().size()-1).addSale(sale1);
		       		
		       	}
		       	else if (dataRowClass.equals("SaleLineItem"))
		       	{
		       		SaleLineItem sli1 = new SaleLineItem(myStore.findItemForNumber(token[1]), token[2]);
		       		sli1.setSale(myStore.getSessions().get(myStore.getSessions().size() - 1).getSales().get(myStore.getSessions().get(myStore.getSessions().size() - 1).getSales().size() - 1));
		       		sli1.getSale().addSaleLineItem(sli1);
		       	}
		       	
		       	else if (dataRowClass.equals("Payment"))
		       	{
		       		if(token[1].equals("Cash"))
		       		{
		       			BigDecimal amtTend = new BigDecimal(token[3]);
		       			Cash cash1 = new Cash(token[2], amtTend);
		       			//add the payment to the most recent sale
		       			myStore.getSessions().get(myStore.getSessions().size()-1).getSales().get(myStore.getSessions().get(myStore.getSessions().size()-1).getSales().size()-1).addPayment(cash1);
		       		}
		       		else if(token[1].equals("Credit"))
		       		{
		       			DateTimeFormatter formatters = DateTimeFormatter.ofPattern("M/d/yyyy");
		       			Credit credit1 = new Credit(token[4], token[5], LocalDate.parse(token[6], formatters));
		       			BigDecimal amt = new BigDecimal(token[2]);
		       			BigDecimal amtTend = new BigDecimal(token[3]);
		       			credit1.setAmount(amt);
		       			credit1.setAmtTendered(amtTend);
		       			myStore.getSessions().get(myStore.getSessions().size()-1).getSales().get(myStore.getSessions().get(myStore.getSessions().size()-1).getSales().size()-1).addPayment(credit1);
		       		}
		       		else if(token[1].equals("Check"))
		       		{
		       			Check check1 = new Check(token[3], token[4], token[5], token[6]);
		       			BigDecimal amt = new BigDecimal(token[2]);
		       			BigDecimal amtTend = new BigDecimal(token[3]);
		       			check1.setAmount(amt);
		       			check1.setAmtTendered(amtTend);
		       			myStore.getSessions().get(myStore.getSessions().size()-1).getSales().get(myStore.getSessions().get(myStore.getSessions().size()-1).getSales().size()-1).addPayment(check1);
		       		}
		       	}
	        }    

	        // Always close files.
	        bufferedReader.close();            
	    }
	    catch(FileNotFoundException ex) 
	    {
	        System.out.println(
	            "Unable to open file '" + 
	            fileName + "'");                
	    }
	    catch(IOException ex) 
	    {
	        System.out.println(
	            "Error reading file '" 
	            + fileName + "'");   	
		
		}
	    return myStore;
	}

}