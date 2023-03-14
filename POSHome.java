package posUI;

import javax.swing.JPanel;

import posPD.Store;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class POSHome extends JPanel 
{

	/**
	 * Create the panel.
	 */
	public POSHome(Store store) 
	{
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel(store.getName());
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(80, 122, 290, 16);
		add(lblNewLabel);

	}
}
