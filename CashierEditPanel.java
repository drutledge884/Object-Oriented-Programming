package posUI;

import javax.swing.JFrame;
import javax.swing.JPanel;

import posPD.Cashier;
import posPD.Store;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CashierEditPanel extends JPanel 
{
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public CashierEditPanel(JFrame currentFrame, Store store, Cashier cashier, Boolean isAdd) 
	{
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cashier Edit");
		lblNewLabel.setBounds(205, 33, 90, 13);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Number");
		lblNewLabel_1.setBounds(43, 95, 80, 13);
		add(lblNewLabel_1);
		
		textField = new JTextField(cashier.getNumber());
		textField.setBounds(110, 92, 96, 19);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Name");
		lblNewLabel_2.setBounds(43, 130, 80, 13);
		add(lblNewLabel_2);
		
		textField_1 = new JTextField(cashier.getPerson().getName());
		textField_1.setBounds(110, 127, 96, 19);
		add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				
				if (!isAdd && !cashier.getNumber().equals(textField.getText())) 
				{//if i am editing and changing my old key value (pq register numbers são as key do tree map)
					store.removeCashier(cashier);
					cashier.setNumber(textField.getText());
					store.addCashier(cashier);
				}
				else
				{
					cashier.setNumber(textField.getText());
				}
				
				cashier.getPerson().setName(textField_1.getText()); 
				if(isAdd) 
				{
					store.addCashier(cashier);
				}
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new CashierListPanel(currentFrame, store));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnNewButton.setBounds(89, 209, 85, 21);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new CashierListPanel(currentFrame, store));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnNewButton_1.setBounds(236, 209, 85, 21);
		add(btnNewButton_1);
	}
}
