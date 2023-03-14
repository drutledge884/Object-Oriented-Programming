package posUI;

import javax.swing.JFrame;
import javax.swing.JPanel;

import posPD.Register;
import posPD.Store;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegisterEditPanel extends JPanel 
{
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public RegisterEditPanel(JFrame currentFrame, Store store, Register register, boolean isAdd) 
	{
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Register Edit");
		lblNewLabel.setBounds(188, 41, 125, 13);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Number");
		lblNewLabel_1.setBounds(32, 93, 60, 13);
		add(lblNewLabel_1);
		
		textField = new JTextField(register.getNumber());
		textField.setBounds(110, 90, 96, 19);
		add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				
				if (!isAdd && !register.getNumber().equals(textField.getText())) 
				{
					store.removeRegister(register);
					register.setNumber(textField.getText());
					store.addRegister(register);
				}
				else
				{
					register.setNumber(textField.getText());
				}
				
				if(isAdd) store.addRegister(register);
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new RegisterListPanel(currentFrame, store));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnNewButton.setBounds(52, 182, 85, 21);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new RegisterListPanel(currentFrame, store));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnNewButton_1.setBounds(182, 182, 85, 21);
		add(btnNewButton_1);
	}
}
