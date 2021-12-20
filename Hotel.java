import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JMonthChooser;
import java.awt.BorderLayout;
import java.sql.*;
import javax.swing.DefaultComboBoxModel;

public class Hotel {

	private JFrame frame;
	private JTable table;
	private JTextField jtxtCustomerRef;
	private JTextField jtxtFirstname;
	private JTextField jtxtSurname;
	private JTextField jtxtMobile;
	private JTextField jtxtPostCode;
	private JTextField textField_5;
	private JTextField jtxtTotal;
	private JTextField jtxtSubTotal;
	private JTextField jtxtTax;
	private JTextField textField_18;
	
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs  = null;
	
	DefaultTableModel model = new DefaultTableModel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField jtxtAddress;
	private JTextField textField_4;
	private JTextField jtxtEmail;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	

	/**
	 * Launch the application.
	 */
	
	public void updateTable() {
		conn = hotelData.ConnectDB();
		
		if(conn!= null) {
			String sql = "Select cusRef,Firstname,Surname,Address,PostCode,"
					+ "Mobile,Email,Gender,DOB,Nationality,DateIn,DateOut,RoomType,RoomNo,RoomExt";
		}
		
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			Object[] columnData = new Object[16];
			
			while(rs.next()) {
				columnData[0] = rs.getString("CusRef");
				columnData[1] = rs.getString("Firstname");
				columnData[2] = rs.getString("Surname");
				columnData[3] = rs.getString("Address");
				columnData[4] = rs.getString("PostCode");
				columnData[5] = rs.getString("Mobile");
				columnData[6] = rs.getString("Email");
				columnData[7] = rs.getString("Gender");
				columnData[8] = rs.getString("DOB");
				columnData[9] = rs.getString("Nationality");
				columnData[10] = rs.getString("ProveofID");
				columnData[11] = rs.getString("DateIn");
				columnData[12] = rs.getString("DateOut");
				columnData[13] = rs.getString("RoomType");
				columnData[14] = rs.getString("RoomNo");
				columnData[15] = rs.getString("RoomExt");
				
				model.addRow(columnData);
				
			}
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Connection Error");
		}
	}
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hotel window = new Hotel();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Hotel() {
		initialize();
		
		Object col[] = {"CusRef","Firstname","Surname","Address","PostCode","Mobile","Email","Gender","DOB",
				"Nationality","ProveofID","DateIn","DateOut","RoomType","RoomNo","RoomExt"};
		model.setColumnIdentifiers(col);
		table.setModel(model);
        conn = hotelData.ConnectDB();
        
        updateTable();
		}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 1470, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(22, 23, 278, 730);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Customer Ref");
		lblNewLabel.setBounds(22, 21, 75, 35);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 10));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("First Name");
		lblNewLabel_1.setBounds(22, 77, 56, 13);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Sur Name");
		lblNewLabel_2.setBounds(22, 122, 56, 13);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Address");
		lblNewLabel_3.setBounds(22, 171, 45, 13);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 10));
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Post Code");
		lblNewLabel_4.setBounds(22, 219, 56, 13);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 10));
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Mobile");
		lblNewLabel_5.setBounds(22, 265, 45, 13);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 10));
		panel.add(lblNewLabel_5);
		
		textField_5 = new JTextField();
		textField_5.setBounds(120, 261, 135, 25);
		panel.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Email");
		lblNewLabel_6.setBounds(22, 306, 45, 19);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 10));
		panel.add(lblNewLabel_6);
		
		JLabel cboGender = new JLabel("Gender");
		cboGender.setBounds(22, 343, 45, 13);
		cboGender.setFont(new Font("Tahoma", Font.BOLD, 10));
		panel.add(cboGender);
		
		JLabel lblNewLabel_8 = new JLabel("Date of Birth");
		lblNewLabel_8.setBounds(22, 379, 75, 19);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 10));
		panel.add(lblNewLabel_8);
		
		  
		
		JLabel lblNewLabel_9 = new JLabel("Nationality");
		lblNewLabel_9.setBounds(22, 429, 56, 13);
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 10));
		panel.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("New label");
		lblNewLabel_10.setBounds(35, 510, 37, -21);
		panel.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Prove of ID");
		lblNewLabel_11.setBounds(22, 476, 75, 19);
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 10));
		panel.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("Check in date");
		lblNewLabel_12.setBounds(22, 517, 75, 19);
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 10));
		panel.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("Check out date");
		lblNewLabel_13.setBounds(22, 546, 75, 19);
		lblNewLabel_13.setFont(new Font("Tahoma", Font.BOLD, 10));
		panel.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("Room type");
		lblNewLabel_14.setBounds(22, 610, 75, 21);
		lblNewLabel_14.setFont(new Font("Tahoma", Font.BOLD, 10));
		panel.add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel("Room No");
		lblNewLabel_15.setBounds(22, 653, 45, 13);
		lblNewLabel_15.setFont(new Font("Tahoma", Font.BOLD, 10));
		panel.add(lblNewLabel_15);
		
		JLabel lblNewLabel_16 = new JLabel("Room Ext No");
		lblNewLabel_16.setBounds(22, 689, 75, 21);
		lblNewLabel_16.setFont(new Font("Tahoma", Font.BOLD, 10));
		panel.add(lblNewLabel_16);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select Ext No", "1000", "1001", "1002", "1003", "1004", "1005", "1006", "1007", "1008", "1009", "1010"}));
		comboBox.setBounds(120, 685, 135, 25);
		panel.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Select Room No", "100", "101", "102", "103", "104", "105", "106", "107", "108", "109", "110"}));
		comboBox_1.setBounds(120, 645, 135, 25);
		panel.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Select Room Type", "Single", "Double ", "Family"}));
		comboBox_2.setBounds(120, 606, 135, 25);
		panel.add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(120, 425, 135, 25);
		panel.add(comboBox_3);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"Select prove ID", "Student ID", "Passport", "Driving Licence", "Pilot Licence"}));
		comboBox_4.setBounds(120, 471, 135, 24);
		panel.add(comboBox_4);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"Select Gender", "Male", "Female"}));
		comboBox_5.setBounds(120, 335, 135, 25);
		panel.add(comboBox_5);
		
		JComboBox comboBox_6 = new JComboBox();
		comboBox_6.setModel(new DefaultComboBoxModel(new String[] {"Select Meal", "Breakfast", "Lunch", "Dinner"}));
		comboBox_6.setBounds(120, 567, 135, 29);
		panel.add(comboBox_6);
		
		JLabel lblNewLabel_20 = new JLabel("Meal");
		lblNewLabel_20.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_20.setBounds(22, 575, 56, 25);
		panel.add(lblNewLabel_20);
		
		textField = new JTextField();
		textField.setBounds(120, 29, 135, 27);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(119, 74, 136, 29);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(120, 119, 135, 29);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		jtxtAddress = new JTextField();
		jtxtAddress.setBounds(120, 168, 135, 35);
		panel.add(jtxtAddress);
		jtxtAddress.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(120, 219, 135, 32);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		jtxtEmail = new JTextField();
		jtxtEmail.setBounds(120, 296, 135, 25);
		panel.add(jtxtEmail);
		jtxtEmail.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(117, 379, 138, 25);
		panel.add(textField_7);
		textField_7.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(347, 23, 1120, 529);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 30, 1051, 470);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, "", null, null, null, null, null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"CustomerRef", "FirstName", "SurName", "Address", "Post Code", "Mobile", "Email", "Gender", "Date of Birth", "Nationality", "Prove of ID", "Check in Date", "Check out Date", "Room type", "Room No", "Room Ext No"
			}
		));
		scrollPane.setViewportView(table);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2.setBounds(347, 601, 963, 127);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_17 = new JLabel("Tax");
		lblNewLabel_17.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_17.setBounds(29, 21, 45, 13);
		panel_2.add(lblNewLabel_17);
		
		JLabel lblNewLabel_18 = new JLabel("Sub Total");
		lblNewLabel_18.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_18.setBounds(10, 59, 64, 13);
		panel_2.add(lblNewLabel_18);
		
		JLabel lblNewLabel_19 = new JLabel("Total");
		lblNewLabel_19.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_19.setBounds(29, 92, 45, 13);
		panel_2.add(lblNewLabel_19);
		
		
		
		
		
		textField_18 = new JTextField();
		textField_18.setBounds(93, 92, 115, 25);
		panel_2.add(textField_18);
		textField_18.setColumns(10);
		
		JButton btnNewButton = new JButton("Total");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(244, 21, 115, 99);
		panel_2.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Update");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String sql = "Insert INTO hoteldb(CusRef,Firstname,Surname,Address,PostCode,Mobile,Email,Gender,
						 DOB,Nationality,"  + "ProveofID,DateIn,DateOut,RoomType,RoomNo,RoomExt)
		                        VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		                try {
		                	pst = conn.prepareStatement(sql);
		                	pst.setString(1, jtxtCustomerRef.getText());
		                	pst.setString(2, jtxtFirstname.getText());
		                	pst.setString(3, jtxtSurname.getText());
		                	pst.setString(4, jtxtAddress.getText());
		                	pst.setString(5, jtxtPostCode.getText());
		                	pst.setString(6, jtxtMobile.getText());
		                	pst.setString(7, jtxtEmail.getText());
		                	pst.setString(8, (String) cboGender.getSelectedItem());
		                	pst.setString(9, jtxtCustomerRef.getText());
		                	
		                      
		                	
		                }
		                        	
			}
			catch(Exception ev){
				
				JOptionPane.showMessageDialog(null, ev);
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_1.setBounds(369, 21, 115, 99);
		panel_2.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel mod = (DefaultTableModel) table.getModel();
				
				if(table.getSelectedRow() == -1) {
					if(table.getSelectedRow() == 0) {
						JOptionPane.showMessageDialog(null, "No date to be deleted","Hotel System",JOptionPane.OK_OPTION);
					}else {
						JOptionPane.showMessageDialog(null, "Select row to delete", "Hotel System",JOptionPane.OK_OPTION);
					}
					
				}else {
					mod.removeRow(table.getSelectedRow());
				}
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_2.setBounds(494, 21, 106, 99);
		panel_2.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Reset");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					jtxtCustomerRef.setText(null);
					jtxtFirstname.setText(null);
					jtxtSurname.setText(null);
					jtxtAddress.setText(null);
					jtxtPostCode.setText(null);
					jtxtMobile.setText(null);
					jtxtEmail.setText(null);
					cboGender.setSelectedIndex(0);
				}
				catch(Exception ev){
					JOptionPane.showMessageDialog(null, ev);
					
				}
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_3.setBounds(610, 21, 106, 99);
		panel_2.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Print");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

               table.print();
			}
				catch(java.awt.print.PrinterException ev) {
					System.err.format("No printer  found", ev.getMessage());
				}
			}
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_4.setBounds(726, 21, 107, 96);
		panel_2.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Exit");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame = new JFrame("Exit");
				if(JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit","Hotel System",
						JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_5.setBounds(847, 18, 106, 99);
		panel_2.add(btnNewButton_5);
		
		textField_8 = new JTextField();
		textField_8.setBounds(98, 19, 110, 25);
		panel_2.add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setBounds(94, 57, 114, 25);
		panel_2.add(textField_9);
		textField_9.setColumns(10);
	}
}
