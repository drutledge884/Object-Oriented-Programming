package posTest;

import java.math.BigDecimal;
import posPD.*;
import posDM.*;
import posPD.Item;
import java.time.LocalDate;

public class StoreTest 
{
	public static void main(String args[])
    {
		//uncomment to launch part 2.1
		//Store myStore = new Store("42069", "Daniel's Shop");
		//myStore = storeTest(myStore);
		//storePrint(myStore);
		
		//uncomment to launch part 2.2
		Store myStore = new Store("42069", "Daniel's Shop");
		DataManagement dm = new DataManagement();
		myStore = dm.dataPopulate(myStore);
		storePrint(myStore);
    }
	
	public static Store storeTest(Store myStore)
	{
		//initialize a tax category and a tax rate and add both to the store
		TaxCategory taxCategory1 = new TaxCategory("electronics");
		TaxRate taxRate1 = new TaxRate("01/01/2016", new BigDecimal("0.07"));
		taxCategory1.addTaxRate(taxRate1);
		myStore.addTaxCategory(taxCategory1);
		//initialize items with a number and description
		Item item1 = new Item("1001", "Xbox");
		Item item2 = new Item("1002", "Playstation");
		Item item3 = new Item("1003", "Wii");
		//initialize upcs for each item
		UPC upc1 = new UPC("11111111111");
		UPC upc2 = new UPC("22222222222");
		UPC upc3 = new UPC("33333333333");
		//initialize prices with effective dates for each item
		Price price1 = new Price("349.99", "01/01/2016");
		Price price2 = new Price("249.99", "01/01/2016");
		Price price3 = new Price("149.99", "01/01/2016");
		//add the UPCs to their respective items
		item1.addUPC(upc1);
		item2.addUPC(upc2);
		item3.addUPC(upc3);
		//add the prices to their respective items
		item1.addPrice(price1);
		item2.addPrice(price2);
		item3.addPrice(price3);
		//adds the tax category "electronics" to all the items
		item1.setTaxCategory(taxCategory1);
		item2.setTaxCategory(taxCategory1);
		item3.setTaxCategory(taxCategory1);
		//initialize people with names, addresses, SSNs, phones, and addresses
		Person Joseph = new Person("Joseph Joestar", "309 Hermit Purple St", "092-127-0092", "811644071");
		Person DIO = new Person("DIO Brando", "988 The World Dr", "948-265-2112", "021749221");
		Person Speedwagon = new Person("R.E.O. Speedwagon", "0177 Hamon Ct", "858-022-1155", "003862994");
		//initialize three cashiers with people, passwords, and numbers
		Cashier cashier1 = new Cashier("1", Joseph, "hermitpurple1");
		Cashier cashier2 = new Cashier("2", DIO, "theworld1");
		Cashier cashier3 = new Cashier("3", Speedwagon, "hamonoverdrive1");
		//create three registers with numbers
		Register register1 = new Register("1");
		Register register2 = new Register("2");
		Register register3 = new Register("3");
		//create a session with a person at register 1 and start a sale of two items
		Session session1 = new Session(cashier1, register1);
		Sale sale1 = new Sale("n");
		SaleLineItem sli1 = new SaleLineItem(item1, "3");
		SaleLineItem sli2 = new SaleLineItem(item3, "1");
		sale1.addSaleLineItem(sli1);
		sale1.addSaleLineItem(sli2);
		//adds the sales to the session
		session1.addSale(sale1);
		//adds all the UPCs to the store
		myStore.addUPC(upc1);
		myStore.addUPC(upc2);
		myStore.addUPC(upc3);
		//adds all the cashiers to the store
		myStore.addCashier(cashier1);
		myStore.addCashier(cashier2);
		myStore.addCashier(cashier3);
		//adds all the registers to the store
		myStore.addRegister(register1);
		myStore.addRegister(register2);
		myStore.addRegister(register3);
		//adds all the sessions to the store
		myStore.addSession(session1);
		//adds all the items to the store
		myStore.addItem(item1);
		myStore.addItem(item2);
		myStore.addItem(item3);
				
		return myStore;
	}
	
	public static void storePrint(Store myStore)
	{
		//print the store data
		System.out.println("==================================================");
		System.out.println(myStore.toString());
		//print all the cashiers
		System.out.println("==================================================");
		System.out.println("Cashiers:");
		String s1;
		for(int i = 1; i < myStore.getCashiers().size() + 1; i++)
		{
			s1 = String.valueOf(i);
			System.out.println(myStore.findCashierForNumber(s1).toString());
		}
		//print all the registers
		System.out.println("==================================================");
		System.out.println("Registers:");
		String s2;
		for(int i = 1; i < myStore.getRegisters().size() + 1; i++)
		{
			s2 = String.valueOf(i);
			System.out.println(myStore.findRegisterbyNumber(s2.toString()));
		}
		//print all the items
		System.out.println("==================================================");
		System.out.println("Items:");
		String s3 = new String();
		for(int i = 1; i < myStore.getItems().size() + 1; i++)
		{
			s3 = String.valueOf(i);
			System.out.println(myStore.findItemForNumber("100" + s3.toString()).toString());
		}
		//print the sessions and the sales
		System.out.println("==================================================");
		for(int i = 1; i < myStore.getSessions().size() + 1; i++)
		{
			System.out.println(myStore.getSessions().get(i - 1).toString());
		}
		System.out.println("==================================================");
	}
}
