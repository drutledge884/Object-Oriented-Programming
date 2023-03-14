package posUI;

import javax.swing.JFrame;
import javax.swing.JPanel;

import posPD.Cashier;
import posPD.Store;
import posPD.TaxCategory;
import posPD.TaxRate;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TaxCategoryEditPanel extends JPanel {
	private JTextField textField;
	private DefaultListModel taxRateModel;
	private JList <TaxRate>list;
	
	/**
	 * Create the panel.
	 */
	public TaxCategoryEditPanel(JFrame currentFrame, Store store, TaxCategory taxCategory, Boolean isAdd) {
		
		JPanel currentPanel = this;
		
		addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent arg0) {
				taxRateModel = new DefaultListModel<TaxRate>();
				for (TaxRate tr : taxCategory.getTaxRates())
				{
					taxRateModel.addElement(tr);
				}
				list.setModel(taxRateModel);
			}

			@Override
			public void ancestorRemoved(AncestorEvent event) 
			{
				// TODO Auto-generated method stub
				
			}

			@Override
			public void ancestorMoved(AncestorEvent event) 
			{
				// TODO Auto-generated method stub
				
			}
		});
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tax Category Edit");
		lblNewLabel.setBounds(171, 39, 150, 13);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Category:");
		lblNewLabel_1.setBounds(30, 95, 90, 13);
		add(lblNewLabel_1);
		
		textField = new JTextField(taxCategory.getCategory());
		textField.setBounds(99, 92, 96, 19);
		add(textField);
		textField.setColumns(10);
		
		taxRateModel = new DefaultListModel<TaxRate>();
		for (TaxRate tr : taxCategory.getTaxRates())
		{
			taxRateModel.addElement(tr);
		}
		
		list = new JList<TaxRate>(taxRateModel);
		list.addListSelectionListener(new ListSelectionListener() 
		{
			public void valueChanged(ListSelectionEvent e) 
			{
				
			}
		});
		list.setBounds(242, 89, 168, 110);
		add(list);
		
		JLabel lblNewLabel_2 = new JLabel("Tax Rates");
		lblNewLabel_2.setBounds(304, 66, 80, 13);
		add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new TaxRateEditPanel(currentFrame, currentPanel, store, taxCategory, new TaxRate(), true));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnNewButton.setBounds(226, 209, 58, 21);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Edit");
		btnNewButton_1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new TaxRateEditPanel(currentFrame, currentPanel, store, taxCategory, list.getSelectedValue(), false));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnNewButton_1.setBounds(294, 209, 58, 21);
		add(btnNewButton_1);
		btnNewButton_1.setEnabled(false);
		
		JButton btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				TaxRate selectedTaxRate = list.getSelectedValue();
				taxCategory.removeTaxRate(selectedTaxRate);
				taxRateModel.removeElement(selectedTaxRate);
				/*
				if(selectedTaxRate.isOkToDelete()) //raise a function, something related to or items
				{
					taxCategory.removeTaxCategory(selectedTaxCat);
					taxRateList.removeElement(selectedTaxCat);
					taxCategory.removeTaxRate(selectedTaxRate);
					taxRateList.removeElement(selectedTaxRate);
				}
				*/
			}
		});
		btnNewButton_2.setBounds(362, 209, 78, 21);
		add(btnNewButton_2);
		btnNewButton_2.setEnabled(false);
		
		JButton btnNewButton_3 = new JButton("Save");
		btnNewButton_3.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				taxCategory.setCategory((textField.getText()));
				if(isAdd == true) 
				{
					store.addTaxCategory(taxCategory);
				}
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new TaxCategoryListPanel(currentFrame, store));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnNewButton_3.setBounds(86, 252, 85, 21);
		add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Cancel");
		btnNewButton_4.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new TaxCategoryListPanel(currentFrame, store));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnNewButton_4.setBounds(220, 252, 85, 21);
		add(btnNewButton_4);
		

		list.addListSelectionListener(new ListSelectionListener() 
		{
			public void valueChanged(ListSelectionEvent e) 
			{
				if (!list.isSelectionEmpty()) 
				{
					btnNewButton_1.setEnabled(true);
					btnNewButton_2.setEnabled(true);
				} 
				else
				{
					btnNewButton_1.setEnabled(false);
					btnNewButton_2.setEnabled(false);
				}
			}
		});
	}
}
