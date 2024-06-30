import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class viewReceiptGUI extends JFrame implements ActionListener {

	Object[] yes = new Object[4];


	bookingList ObjBookingList;
	//ArrayList<booking> tempList = new ArrayList<> ();
	JTable tblBooking;
	JScrollPane jScrollPane1;

	private JButton btnView, btnBack;



	private JTextField txtName, txtIC, txtPhone, txtEmail, txtRoomID, txtDate, txtDuration, txtSubtotal, txtServiceTax, txtTourismTax, txtTotalPrice;




	public viewReceiptGUI() {

		//generate ui
		gui_init();



		//reads the booking from file
		ObjBookingList = new bookingList();

		try {
			ObjBookingList.readBookingDetailsFromFile();
		}catch (Exception e) {

		}

		//display booking name, room id, date, duration to the table
		DefaultTableModel model = (DefaultTableModel)tblBooking.getModel();
		for(int i =0;i<ObjBookingList.size(); i++){
			// Booking temp = tempList.get(i);
			yes[0] = ObjBookingList.getBooking(i).getName();
			yes[1] = ObjBookingList.getBooking(i).getRoomID();
			yes[2] = ObjBookingList.getBooking(i).getDate();
			yes[3] = ObjBookingList.getBooking(i).getduration();
			model.addRow(yes);

		}

	}


	private void gui_init(){
		setTitle("View Receipt");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 889, 553);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(null, "View Receipt", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel center = new JPanel();
		center.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(center);
		center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));

		JPanel tablePanel = new JPanel();
		center.add(tablePanel);

		tblBooking = new JTable();


		tblBooking.setModel(new javax.swing.table.DefaultTableModel(
				new Object [][] {

				},
				new String [] {
						"Name", "Room ID", "Date", "Duration"
				}
		));
		jScrollPane1 = new javax.swing.JScrollPane();
		jScrollPane1.setViewportView(tblBooking);
		tablePanel.add(jScrollPane1, BorderLayout.CENTER);

		JPanel bottomPanel = new JPanel();
		center.add(bottomPanel);

		btnView = new JButton("View Receipt");
		bottomPanel.add(btnView);

		btnBack = new JButton("Back");
		bottomPanel.add(btnBack);


		JPanel detailsPanel = new JPanel();
		detailsPanel.setPreferredSize(new Dimension(300, 10));
		contentPane.add(detailsPanel, BorderLayout.EAST);
		detailsPanel.setLayout(new BorderLayout(0, 0));

		JPanel innerDetailsPanel = new JPanel();
		innerDetailsPanel.setBorder(new TitledBorder(null, "Details", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		detailsPanel.add(innerDetailsPanel, BorderLayout.CENTER);

		JPanel namePanel = new JPanel();
		innerDetailsPanel.add(namePanel);

		JLabel lblName = new JLabel("Name");
		lblName.setPreferredSize(new Dimension(80, 14));
		namePanel.add(lblName);

		txtName = new JTextField();
		txtName.setEditable(false);
		txtName.setColumns(15);
		namePanel.add(txtName);

		JPanel icPanel = new JPanel();
		innerDetailsPanel.add(icPanel);

		JLabel lblIC = new JLabel("IC/Passport");
		lblIC.setPreferredSize(new Dimension(80, 14));
		icPanel.add(lblIC);

		txtIC = new JTextField();
		txtIC.setEditable(false);
		txtIC.setColumns(15);
		icPanel.add(txtIC);

		JPanel phonePanel = new JPanel();
		innerDetailsPanel.add(phonePanel);

		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setPreferredSize(new Dimension(80, 14));
		phonePanel.add(lblPhone);

		txtPhone = new JTextField();
		txtPhone.setEditable(false);
		txtPhone.setColumns(15);
		phonePanel.add(txtPhone);

		JPanel emailPanel = new JPanel();
		innerDetailsPanel.add(emailPanel);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setPreferredSize(new Dimension(80, 14));
		emailPanel.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setEditable(false);
		txtEmail.setColumns(15);
		emailPanel.add(txtEmail);

		JPanel roomPanel = new JPanel();
		innerDetailsPanel.add(roomPanel);

		JLabel lblRoomID = new JLabel("Room ID");
		lblRoomID.setPreferredSize(new Dimension(80, 14));
		roomPanel.add(lblRoomID);

		txtRoomID = new JTextField();
		txtRoomID.setEditable(false);
		txtRoomID.setColumns(15);
		roomPanel.add(txtRoomID);

		JPanel datePanel = new JPanel();
		innerDetailsPanel.add(datePanel);

		JLabel lblDate = new JLabel("Name");
		lblDate.setPreferredSize(new Dimension(80, 14));
		datePanel.add(lblDate);

		txtDate = new JTextField();
		txtDate.setEditable(false);
		txtDate.setColumns(15);
		datePanel.add(txtDate);

		JPanel durationPanel = new JPanel();
		innerDetailsPanel.add(durationPanel);

		JLabel lblDuration = new JLabel("Duration");
		lblDuration.setPreferredSize(new Dimension(80, 14));
		durationPanel.add(lblDuration);

		txtDuration = new JTextField();
		txtDuration.setEditable(false);
		txtDuration.setColumns(15);
		durationPanel.add(txtDuration);

		JPanel pricePanel = new JPanel();
		pricePanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Price", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pricePanel.setPreferredSize(new Dimension(10, 200));
		detailsPanel.add(pricePanel, BorderLayout.SOUTH);

		JPanel subtotalPanel = new JPanel();
		pricePanel.add(subtotalPanel);

		JLabel lblSubtotal = new JLabel("Subtotal");
		lblSubtotal.setPreferredSize(new Dimension(80, 14));
		subtotalPanel.add(lblSubtotal);

		txtSubtotal = new JTextField();
		txtSubtotal.setEditable(false);
		txtSubtotal.setColumns(15);
		subtotalPanel.add(txtSubtotal);

		JPanel servicePanel = new JPanel();
		pricePanel.add(servicePanel);

		JLabel lblService = new JLabel("Name");
		lblService.setPreferredSize(new Dimension(80, 14));
		servicePanel.add(lblService);

		txtServiceTax = new JTextField();
		txtServiceTax.setEditable(false);
		txtServiceTax.setColumns(15);
		servicePanel.add(txtServiceTax);

		JPanel tourisPanel = new JPanel();
		pricePanel.add(tourisPanel);

		JLabel lblTourismTax = new JLabel("Tourism Tax");
		lblTourismTax.setPreferredSize(new Dimension(80, 14));
		tourisPanel.add(lblTourismTax);

		txtTourismTax = new JTextField();
		txtTourismTax.setEditable(false);
		txtTourismTax.setColumns(15);
		tourisPanel.add(txtTourismTax);

		JPanel totalPanel = new JPanel();
		pricePanel.add(totalPanel);

		JLabel lblTotal = new JLabel("Total Price");
		lblTotal.setPreferredSize(new Dimension(80, 14));
		totalPanel.add(lblTotal);

		txtTotalPrice = new JTextField();
		txtTotalPrice.setEditable(false);
		txtTotalPrice.setColumns(15);
		totalPanel.add(txtTotalPrice);



		btnBack.addActionListener(this);
		btnView.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBack)
		{

			//return back to main menu
			MainMenuGUI back = new MainMenuGUI();
			back.setVisible(true);
			this.dispose();


		}else if (e.getSource() == btnView)
		{

			//when clicked, display the selected booking on the table to the details column
			try{
				int row  = tblBooking.getSelectedRow();


				txtName.setText(ObjBookingList.getBooking(row).getName());
				txtIC.setText(ObjBookingList.getBooking(row).getIC());
				txtPhone.setText(ObjBookingList.getBooking(row).getPhone());
				txtEmail.setText(ObjBookingList.getBooking(row).getEmail());
				txtRoomID.setText(ObjBookingList.getBooking(row).getRoomID());
				txtDate.setText(ObjBookingList.getBooking(row).getDate());
				txtDuration.setText(ObjBookingList.getBooking(row).getduration());
				int subtotal = Integer.parseInt(ObjBookingList.getBooking(row).getduration()) * 350;
				txtSubtotal.setText("€" + Integer.toString(subtotal) + ".00");
				double sTax = subtotal *0.1 ;
				txtServiceTax.setText("€" + Double.toString(sTax) + "0");
				int tourtax = Integer.parseInt(ObjBookingList.getBooking(row).getduration()) *  10;
				txtTourismTax.setText("€" + Integer.toString(tourtax) + ".00");
				double total = subtotal + sTax + tourtax;
				txtTotalPrice.setText("€" + Double.toString(total) + "0");
			}
			catch(Exception ex){
				JOptionPane.showMessageDialog(null, "Please select an Entry to view", "Error", JOptionPane.WARNING_MESSAGE);

			}
		}
	}
}
