package posUI;

import javax.swing.JFrame;
import javax.swing.JPanel;

import posPD.Cash;
import posPD.Sale;
import posPD.Session;
import posPD.Store;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.awt.event.ActionEvent;

public class CashEditPanel extends JPanel 
{
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public CashEditPanel(JFrame currentFrame, Store store, Session session, Sale sale) 
	{
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter Cash Payment");
		lblNewLabel.setBounds(77, 32, 101, 13);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Amount Tendered:");
		lblNewLabel_1.setBounds(23, 58, 76, 13);
		add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(109, 55, 76, 19);
		add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				Cash cash = new Cash();
				cash.setAmount(new BigDecimal(textField.getText()));
				//cash.setAmount(sale.calcAmountForPayment(new BigDecimal(textField.getText())));
				cash.setAmount(sale.calcAmount(new BigDecimal(textField.getText())));

				System.out.println("Cash Payment Amount :"+cash.getAmount().toString());
				sale.addPayment(cash);
				currentFrame.getContentPane().removeAll();
				//currentFrame.getContentPane().add(new PaymentPanel(currentFrame, store, session, sale));
				currentFrame.getContentPane().revalidate();
		
			}
		});
		btnNewButton.setBounds(40, 114, 85, 21);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.setBounds(148, 114, 85, 21);
		add(btnNewButton_1);

	}

}
