package posUI;

import posDM.DataManagement;
import posPD.Store;
import posTest.StoreTest;

public class POSStart {
	
	public static Store myStore = new Store();

	
	public static void main (String[]args)
	{
		Store myStore = new Store("42069", "Daniel's Shop");
		DataManagement dm = new DataManagement();
		myStore = dm.dataPopulate(myStore);
		POSFrame.open(myStore);
	}
	
}
