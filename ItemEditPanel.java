package posUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextPane;

import posPD.Item;
import posPD.Store;
import posPD.TaxCategory;
import posPD.UPC;
import posPD.Price;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.awt.event.ActionEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.AncestorEvent;

public class ItemEditPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private DefaultListModel <UPC> upcListModel;
	private DefaultListModel <Price> priceListModel;
	private JList<UPC> upcList;
	private JList<Price> priceList;
	private JPanel currentPanel;
	JButton btnNewButton;
	JButton btnNewButton_2;
	JButton btnNewButton_3;
	JButton btnNewButton_5;
		

	/**
	 * Create the panel.
	 */
	public ItemEditPanel(JFrame currentFrame, Store store, Item item, Boolean isAdd) 
	{
		currentPanel = this;
		
		  addAncestorListener(new AncestorListener() 
		  {
			  public void ancestorAdded(AncestorEvent arg0) 
			  {
				  upcListModel = new DefaultListModel <UPC>();
				  priceListModel = new DefaultListModel<Price>();

				  if (item.getUPCs().isEmpty())
				  {
					  //System.out.println("empty");
				  }

				  for (UPC upc: item.getUPCs().values())
				  {
					 upcListModel.addElement(upc);
				  }
				  for (Price price: item.getPrices())
				  {
					  priceListModel.addElement(price);
				  }

				  upcList.setModel(upcListModel);
				  priceList.setModel(priceListModel);
			  }
			  public void ancestorMoved(AncestorEvent arg0) 
			  {
				  
			  }
			  public void ancestorRemoved(AncestorEvent arg0) 
			  {
				  
			  }
		});
		  
		
		setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("Edit Item");
		lblNewLabel.setBounds(153, 43, 60, 13);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Item Number:");
		lblNewLabel_1.setBounds(5, 88, 88, 13);
		add(lblNewLabel_1);
		
		textField = new JTextField(item.getNumber());
		textField.setBounds(86, 85, 96, 19);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Description:");
		lblNewLabel_2.setBounds(5, 127, 88, 13);
		add(lblNewLabel_2);
		
		textField_1 = new JTextField(item.getDescription());
		textField_1.setBounds(86, 124, 96, 19);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Tax Category:");
		lblNewLabel_3.setBounds(5, 168, 88, 13);
		add(lblNewLabel_3);
		
		DefaultComboBoxModel tcList = new DefaultComboBoxModel(store.getTaxCategory().values().toArray()); //store.getTaxCategoryList().toArray()
		JComboBox<TaxCategory> comboBox = new JComboBox<TaxCategory>(tcList);
		
		if(!isAdd) comboBox.setSelectedItem(item.getTaxCategory());
		
		comboBox.setBounds(86, 164, 96, 21);
		add(comboBox);
		
		JLabel lblNewLabel_4 = new JLabel("UPCs");
		lblNewLabel_4.setBounds(230, 30, 280, 30);
		add(lblNewLabel_4);
		DefaultListModel<UPC> list = new DefaultListModel<UPC>();
		upcList = new JList<UPC>(list);
		
		  for (UPC upc: item.getUPCs().values())
		  {
			 list.addElement(upc);
		  }

		upcList.addListSelectionListener(new ListSelectionListener() 
		{
		public void valueChanged(ListSelectionEvent e) 
		{
			if (!upcList.isSelectionEmpty()) 
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
		upcList.setBounds(262, 10, 111, 71);
		add(upcList);
		
		
		btnNewButton = new JButton("Edit");
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
			
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new UPCEditPanel(currentFrame, currentPanel, store, item, upcList.getSelectedValue(), false));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnNewButton.setBounds(227, 90, 85, 21);
		btnNewButton.setEnabled(false);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Add");
		btnNewButton_1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new UPCEditPanel(currentFrame, currentPanel, store, item, new UPC(), true));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnNewButton_1.setBounds(322, 90, 85, 21);
		add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				UPC selectedUPC = upcList.getSelectedValue();
				item.removeUPC(selectedUPC); 
				store.removeUPC(selectedUPC);
				upcListModel.removeElement(selectedUPC);
			}
		});
		btnNewButton_2.setBounds(276, 121, 85, 21);
		btnNewButton_2.setEnabled(false);
		add(btnNewButton_2);
		
		
		DefaultListModel<Price> list_1 = new DefaultListModel<Price>();
		priceList = new JList<Price>(list_1);
		
		priceList.addListSelectionListener(new ListSelectionListener() 
		{
			public void valueChanged(ListSelectionEvent e) 
			{
				if (!priceList.isSelectionEmpty()) 
				{
					btnNewButton_3.setEnabled(true);
					btnNewButton_5.setEnabled(true);
				} 
				else
				{
					btnNewButton_3.setEnabled(false);
					btnNewButton_5.setEnabled(false);
				}
			}
		});
		priceList.setBounds(262, 152, 127, 88);
		add(priceList);
		
		JLabel lblNewLabel_5 = new JLabel("Prices");
		lblNewLabel_5.setBounds(220, 152, 127, 88);
		add(lblNewLabel_5);
		
		btnNewButton_3 = new JButton("Edit");
		btnNewButton_3.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new PriceEditPanel(currentFrame, currentPanel, store, item, priceList.getSelectedValue(), false));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnNewButton_3.setBounds(227, 243, 85, 21);
		btnNewButton_3.setEnabled(false);
		add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Add");
		btnNewButton_4.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new PriceEditPanel(currentFrame, currentPanel, store, item, new Price(), true));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnNewButton_4.setBounds(322, 243, 85, 21);
		add(btnNewButton_4);
		
		btnNewButton_5 = new JButton("Delete");
		btnNewButton_5.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				Price selectedPrice = priceList.getSelectedValue();
				item.removePrice(selectedPrice);
				priceListModel.removeElement(selectedPrice);
			}
		});
		btnNewButton_5.setBounds(276, 269, 85, 21);
		btnNewButton_5.setEnabled(false);
		add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Save");
		btnNewButton_6.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(!isAdd && !item.getNumber().equals(textField.getText()))
				{
					store.removeItem(item);
					item.setNumber(textField.getText());
					store.addItem(item);
				}
				if(isAdd) {
					item.setNumber(textField.getText());
					store.addItem(item);
				}
				
				
				item.setDescription(textField_1.getText());
				item.setTaxCategory((TaxCategory)comboBox.getSelectedItem());
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new ItemListPanel(currentFrame, store));
				currentFrame.getContentPane().revalidate();
			}
		});

		btnNewButton_6.setBounds(21, 257, 85, 21);
		add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("Cancel");
		btnNewButton_7.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new ItemListPanel(currentFrame, store));
				currentFrame.getContentPane().revalidate();
			
			}
		});
		btnNewButton_7.setBounds(116, 257, 85, 21);
		add(btnNewButton_7);

	}
}
