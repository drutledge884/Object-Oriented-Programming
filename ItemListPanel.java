package posUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import posPD.Cashier;
import posPD.Item;
import posPD.Store;
import posPD.TaxCategory;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ItemListPanel extends JPanel 
{
	JButton btnNewButton;
	JButton btnNewButton_2;

	/**
	 * Create the panel.
	 */
	public ItemListPanel(JFrame currentFrame, Store store) 
	{
		setLayout(null);
		

		JLabel lblNewLabel = new JLabel("Select Item");
		lblNewLabel.setBounds(189, 37, 67, 13);
		add(lblNewLabel);
		
		DefaultListModel<Item> itemList = new DefaultListModel();
		for(Item item : store.getItems().values()) 
		{
			itemList.addElement(item);
		}
		
		JList <Item> list = new JList <Item>(itemList);
		
		list.addListSelectionListener(new ListSelectionListener() 
		{
			public void valueChanged(ListSelectionEvent e) 
			{
				if (!list.isSelectionEmpty()) 
				{
					btnNewButton.setEnabled(true);
					btnNewButton_2.setEnabled(true);
				} 
				else
				{
					btnNewButton.setEnabled(false);
					btnNewButton_2.setEnabled(false);
				}
			}
		});
		
		
		list.setBounds(25, 72, 425, 136);
		add(list);
		
		
		btnNewButton = new JButton("Edit");
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new ItemEditPanel(currentFrame, store, list.getSelectedValue(), false));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnNewButton.setBounds(63, 218, 85, 21);
		btnNewButton.setEnabled(false);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Add");
		btnNewButton_1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new ItemEditPanel(currentFrame, store, new Item(), true));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnNewButton_1.setBounds(171, 218, 85, 21);
		add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				Item selectedItem = list.getSelectedValue();
				store.removeItem(selectedItem);
				itemList.removeElement(selectedItem);
			}
		});
		btnNewButton_2.setBounds(277, 218, 85, 21);
		btnNewButton_2.setEnabled(false);
		add(btnNewButton_2);
	}
}
