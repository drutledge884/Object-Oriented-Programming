package posUI;

import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.time.*;
import java.time.format.*;

import posPD.Store;
import posPD.TaxCategory;
import posPD.TaxRate;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.awt.event.ActionEvent;

public class TaxRateEditPanel extends JPanel 
{
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */

	public TaxRateEditPanel(JFrame currentFrame, JPanel currentPanel, Store store, TaxCategory taxCat, TaxRate taxRate, Boolean isAdd ) 
	{
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Edit Tax Rate");
		lblNewLabel.setBounds(167, 30, 100, 13);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Effective Date");
		lblNewLabel_1.setBounds(20, 85, 90, 13);
		add(lblNewLabel_1);
		String strdate = "";
		
		textField = new JTextField(strdate);
		textField.setBounds(101, 82, 96, 19);
		
		if(taxRate.getTaxRate()!=null) 
		{
			textField.setText(taxRate.getEffectiveDate().toString());
		}
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Rate");
		lblNewLabel_2.setBounds(46, 142, 45, 13);
		add(lblNewLabel_2);
		String taxRateString = "";
		if(taxRate.getTaxRate()!=null) 
		{
			taxRateString = taxRate.getTaxRate().toString();
		}
		textField_1 = new JTextField(taxRateString);
		textField_1.setBounds(101, 139, 96, 19);
		add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				taxRate.setTaxRate(new BigDecimal(textField_1.getText())); 
				taxRate.setEffectiveDate(LocalDate.parse(textField.getText(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));

				if(isAdd)
				{
					taxCat.addTaxRate(taxRate);
				}
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(currentPanel);
				currentFrame.getContentPane().revalidate();
				currentFrame.getContentPane().repaint();
			}
		});
		btnNewButton.setBounds(73, 227, 85, 21);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(currentPanel);
				currentFrame.getContentPane().revalidate();
				currentFrame.getContentPane().repaint();
			}
		});
		btnNewButton_1.setBounds(226, 227, 85, 21);
		add(btnNewButton_1);
	}
}
