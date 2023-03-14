package posUI;

import javax.swing.JFrame;
import javax.swing.JPanel;

import posPD.Cashier;
import posPD.Register;
import posPD.Store;
import posPD.TaxCategory;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class TaxCategoryListPanel extends JPanel 
{
	JButton btnNewButton_1;
	JButton btnNewButton_2;

	/**
	 * Create the panel.
	 */
	public TaxCategoryListPanel(JFrame currentFrame, Store store) 
	{
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tax Category List");
		lblNewLabel.setBounds(180, 39, 141, 13);
		add(lblNewLabel);
		
		DefaultListModel <TaxCategory> taxCatList = new DefaultListModel<TaxCategory>();
		for(TaxCategory tc : store.getTaxCategory().values())
		{
			taxCatList.addElement(tc);
		}
		
		JList <TaxCategory> list = new JList<TaxCategory>(taxCatList);
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

		list.setBounds(139, 82, 191, 118);
		add(list);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new TaxCategoryEditPanel(currentFrame, store, new TaxCategory(), true));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnNewButton.setBounds(85, 225, 85, 21);
		add(btnNewButton);
		
		btnNewButton_1 = new JButton("Edit");
		btnNewButton_1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				TaxCategory selectedTaxCategory = list.getSelectedValue();
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new TaxCategoryEditPanel(currentFrame, store, selectedTaxCategory, false));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnNewButton_1.setBounds(180, 225, 85, 21);
		btnNewButton_1.setEnabled(false);
		add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) {
				TaxCategory selectedTaxCategory = list.getSelectedValue();
				store.removeTaxCategory(selectedTaxCategory);
				taxCatList.removeElement(selectedTaxCategory);
				
				/*
				if(selectedTaxCategory.isOkToDelete()) //raise this function, something related om items
				{
					store.removeTaxCategory(selectedTaxCategory);
					taxCatList.removeElement(selectedTaxCategory);
				}*/
			}
		});
		btnNewButton_2.setBounds(275, 225, 85, 21);
		btnNewButton_2.setEnabled(false);
		add(btnNewButton_2);

	}

}
