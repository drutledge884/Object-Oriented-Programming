package posUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import posPD.Item;
import posPD.Store;
import posPD.UPC;

public class UPCEditPanel extends JPanel {
	private JTextField textField;


	/**
	 * Create the panel.
	 */
	public UPCEditPanel(JFrame currentFrame, JPanel currentPanel, Store store, Item item, UPC upc, Boolean isAdd) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Edit UPC");
		lblNewLabel.setBounds(194, 43, 66, 13);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("UPC Code: ");
		lblNewLabel_1.setBounds(59, 106, 69, 13);
		add(lblNewLabel_1);
		String upcString = "";
		
		textField = new JTextField(upcString);
		textField.setBounds(138, 103, 96, 19);
		if(upc.getUPC()!=null) 
		{
		textField.setText(upc.getUPC().toString());
		}
		add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				upc.setUPC((textField.getText()));
				if(isAdd) {
					item.addUPC(upc);
					store.addUPC(upc);
				}
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(currentPanel);
				//currentFrame.getContentPane().add(new ItemEditPanel(currentFrame, store, item, true));
				currentFrame.getContentPane().revalidate();
				currentFrame.getContentPane().repaint();
			}
		});
		
		btnNewButton.setBounds(54, 197, 85, 21);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(currentPanel);
				//currentFrame.getContentPane().add(new ItemEditPanel(currentFrame, store, item, false));
				currentFrame.getContentPane().revalidate();
				currentFrame.getContentPane().repaint();
			}
		});
		btnNewButton_1.setBounds(175, 197, 85, 21);
		add(btnNewButton_1);
		
		

	}
}
