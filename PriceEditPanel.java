package posUI;

import javax.swing.JFrame;
import javax.swing.JPanel;

import posPD.Item;
import posPD.Price;
import posPD.PromoPrice;
import posPD.Store;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class PriceEditPanel extends JPanel 
{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private PromoPrice promoPrice;

	/**
	 * Create the panel.
	 */
	public PriceEditPanel(JFrame currentFrame, JPanel currentPanel, Store store, Item item, Price price, Boolean isAdd) 
	{
		setLayout(null); 
		
		
		JLabel lblNewLabel = new JLabel("Edit Price");
		lblNewLabel.setBounds(192, 35, 61, 13);
		add(lblNewLabel);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Promo Price");
		chckbxNewCheckBox.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if (chckbxNewCheckBox.isSelected())
				{
				lblNewLabel_3.setEnabled(true);
				textField_2.setEnabled(true);

				}
				else 
				{
					lblNewLabel_3.setEnabled(false);
					textField_2.setEnabled(false);
				}
			}
		});
		chckbxNewCheckBox.setBounds(160, 52, 100, 21);
		add(chckbxNewCheckBox);
		chckbxNewCheckBox.setEnabled(false);
		if (isAdd)
		{
			chckbxNewCheckBox.setEnabled(true);
		}
		
		
		
		JLabel lblNewLabel_1 = new JLabel("Price:");
		lblNewLabel_1.setBounds(20, 109, 45, 13);
		add(lblNewLabel_1);
		String strprice = "";
		
		textField = new JTextField(strprice);
		textField.setBounds(119, 106, 96, 19);
		if(price.getPrice()!=null) 
		{
			textField.setText(price.getPrice().toString());
		}
		add(textField);
		textField.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Effective Date:");
		lblNewLabel_2.setBounds(20, 159, 90, 13);
		add(lblNewLabel_2);
		String strdate = "";
		
		textField_1 = new JTextField(strdate);
		textField_1.setBounds(119, 156, 96, 19);
		if(price.getPrice()!=null) 
		{
			textField_1.setText(price.getEffectiveDate().toString());
		}
		add(textField_1);
		textField_1.setColumns(10);
		
		lblNewLabel_3 = new JLabel("End Date: ");
		lblNewLabel_3.setBounds(20, 200, 67, 14);
		add(lblNewLabel_3);
		lblNewLabel_3.setEnabled(false);
		
		textField_2 = new JTextField();
		textField_2.setBounds(119, 200, 97, 20);
		add(textField_2);
		textField_2.setColumns(10);
		textField_2.setEnabled(false);
		
		if(price instanceof PromoPrice)
		{
			lblNewLabel_3.setEnabled(true);
			textField_2.setEnabled(true);
			textField_2.setText((DateTimeFormatter.ofPattern("M/d/yy").format(((PromoPrice)price).getEndDate())));
		}
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(price instanceof PromoPrice)
				{
					price.setEffectiveDate(LocalDate.parse(textField_1.getText(), DateTimeFormatter.ofPattern("M/d/yy")));
					((PromoPrice)price).setEndDate(LocalDate.parse(textField_1.getText(), DateTimeFormatter.ofPattern("M/d/yy")));
					//price.setPrice(new BigDecimal(textField.getText()));
					price.setPrice(textField.getText());

				}
				else
				{
					//price.setEffectiveDate(LocalDate.parse(textField_1.getText(), DateTimeFormatter.ofPattern("M/d/yy")));
					price.setEffectiveDate(LocalDate.parse(textField_1.getText(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));

					//price.setPrice(new BigDecimal(textField.getText()));
					price.setPrice(textField.getText());

				}


				if(isAdd) 
				{
					price.setItem(item);
					item.addPrice(price);
				}
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new ItemEditPanel(currentFrame, store, item, true));
				currentFrame.getContentPane().revalidate();
				currentFrame.getContentPane().repaint();
			}
		});
		btnNewButton.setBounds(71, 241, 85, 21);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new ItemEditPanel(currentFrame, store, item, true));
				currentFrame.getContentPane().revalidate();
				currentFrame.getContentPane().repaint();
			}
		});
		btnNewButton_1.setBounds(192, 241, 85, 21);
		add(btnNewButton_1);
		
		
	}
	


}
