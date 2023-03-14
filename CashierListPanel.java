package posUI;

import javax.swing.JFrame;
import javax.swing.JPanel;

import posPD.Store;
import posPD.Cashier;
import posPD.Register;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CashierListPanel extends JPanel 
{
	JButton btnNewButton_1;
	JButton btnNewButton_2;

	/**
	 * Create the panel.
	 */
	public CashierListPanel(JFrame currentFrame, Store store) 
	{
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cashier List");
		lblNewLabel.setBounds(202, 29, 99, 13);
		add(lblNewLabel);
		
		DefaultListModel<Cashier> cashierList = new DefaultListModel<Cashier>();
		for(Cashier cashier : store.getCashiers().values()) 
		{
			cashierList.addElement(cashier);
			}
		
		JList <Cashier> list = new JList <Cashier>(cashierList);
		list.addListSelectionListener(new ListSelectionListener() 
		{
			public void valueChanged(ListSelectionEvent e) 
			{
				if (!list.isSelectionEmpty()) 
				{
					btnNewButton_1.setEnabled(true);
					btnNewButton_2.setEnabled(true);
					/*if (list.getSelectedValue().isOkToDelete())
					{
						btnNewButton_2.setEnabled(true);
					}
					else
					{
						btnNewButton_2.setEnabled(false);
					}
					*/
				} 
				else
				{
					btnNewButton_1.setEnabled(false);
					btnNewButton_2.setEnabled(false);
				}
			}
		});
		list.setBounds(157, 68, 164, 113);
		add(list);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new CashierEditPanel(currentFrame, store, new Cashier(), true));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnNewButton.setBounds(69, 211, 85, 21);
		add(btnNewButton);
		
		btnNewButton_1 = new JButton("Edit");
		btnNewButton_1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new CashierEditPanel(currentFrame, store, list.getSelectedValue(), false));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnNewButton_1.setBounds(185, 211, 85, 21);
		btnNewButton_1.setEnabled(false);
		add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				Cashier selectedCashier = list.getSelectedValue();
				/*if(selectedCashier.isOkToDelete())
				{
					store.removeCashier(selectedCashier);
					cashierList.removeElement(selectedCashier);
				}
				*/
				store.removeCashier(selectedCashier);
				cashierList.removeElement(selectedCashier);
			}
		});
		btnNewButton_2.setBounds(296, 211, 85, 21);
		btnNewButton_2.setEnabled(false);
	
		add(btnNewButton_2);

	}

}
