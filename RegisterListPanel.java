package posUI;

import javax.swing.JFrame;
import javax.swing.JPanel;

import posPD.Register;
import posPD.Store;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.ListSelectionModel;

public class RegisterListPanel extends JPanel 
{
	DefaultListModel<Register> listModel;
	JList <Register> list;
	JButton btnNewButton_1;
	JButton btnNewButton_2;

	/**
	 * Create the panel.
	 */
	public RegisterListPanel(JFrame currentFrame, Store store) 
	{
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Register List");
		lblNewLabel.setBounds(182, 10, 109, 13);
		add(lblNewLabel);
		
		listModel = new DefaultListModel<Register>();
		for (Register register : store.getRegisters().values()) 
		{
			listModel.addElement(register);
		}
		list = new JList <Register>(listModel);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.addListSelectionListener(new ListSelectionListener() 
		{
			public void valueChanged(ListSelectionEvent e) 
			{
				if (!list.isSelectionEmpty()) 
				{
					btnNewButton_1.setEnabled(true);
					
					//if (list.getSelectedValue().isOkToDelete())
					/*if(list.getSelectedValue().isUsed())
					{
						btnNewButton_2.setEnabled(true);
					}
					else
					{
						btnNewButton_2.setEnabled(false);
					}
					*/
					btnNewButton_2.setEnabled(true);
				} 
				else
				{
					btnNewButton_1.setEnabled(false);
					btnNewButton_2.setEnabled(false);
				}
			}
		});
		list.setBounds(135, 46, 180, 124);
		add(list);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new RegisterEditPanel(currentFrame, store, new Register(), true));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnNewButton.setBounds(84, 208, 85, 21);
		add(btnNewButton);
		
		btnNewButton_1 = new JButton("Edit");
		btnNewButton_1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				Register selectedRegister = list.getSelectedValue();
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new RegisterEditPanel(currentFrame, store,selectedRegister, false));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnNewButton_1.setBounds(179, 208, 85, 21);
		btnNewButton_1.setEnabled(false);
		add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				Register selectedRegister = list.getSelectedValue();
				//if(selectedRegister.isOkToDelete())
				/*if(selectedRegister.isUsed())
				{
					store.removeRegister(selectedRegister);
					listModel.removeElement(selectedRegister);
				}
				*/
				store.removeRegister(selectedRegister);
				listModel.removeElement(selectedRegister);
			}});
		btnNewButton_2.setBounds(274, 208, 85, 21);
		//btnNewButton_2.setEnabled(false);
		btnNewButton_2.setEnabled(false);

		add(btnNewButton_2);
	}
}
