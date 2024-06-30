import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Component;
import java.awt.FlowLayout;
import java.util.Date;
import java.util.List;

import com.toedter.calendar.JDateChooser;

public class manageBooking extends JFrame implements ActionListener {


	private JTable tblBooking;
    Object[] TableData = new Object[4];

	bookingList ObjBookingList;

	SimpleDateFormat dcn = new SimpleDateFormat ("yyyy-MM-dd");
	private JScrollPane jScrollPane1;
	private JButton btnUpdate, btnSearch, btnClear, btnModify, btnDelete,btnView, btnBack ;
	private JTextField txtName, txtIC, txtPhone, txtEmail, txtRoomID, txtSubTotal, txtService, txtTourTax, txtTotalPrice, txtSearch ;
	private JDateChooser txtDate;
	private JSpinner txtDuration;

	int index, tableRow, rowtoedit;

	List<booking> filteredList = new ArrayList<>();
	boolean searching = false;



	public manageBooking() {

		//Initialize GUI
		gui_init();


		//Read booking from file and store to BookingList Object
		ObjBookingList = new bookingList();

        try {
			ObjBookingList.readBookingDetailsFromFile();
        }catch (Exception e) {

        }

		//Display booking to table
        DefaultTableModel model = (DefaultTableModel)tblBooking.getModel();
        for(int i =0;i<ObjBookingList.size(); i++){
//            Booking temp = tempList.get(i);
            TableData[0] = ObjBookingList.getBooking(i).getName();
            TableData[1] = ObjBookingList.getBooking(i).getRoomID();
            TableData[2] = ObjBookingList.getBooking(i).getDate();
            TableData[3] = ObjBookingList.getBooking(i).getduration();
            model.addRow(TableData);

        }
		
		
		
	}




	//my eyes pain reading gui_init(), thank god for eclipse allowing u to hide sections
	private void gui_init(){
		setTitle("Manage Booking");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 905, 541);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(null, "Manage Booking", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel center = new JPanel();
		contentPane.add(center, BorderLayout.CENTER);
		center.setLayout(new BorderLayout(0, 0));

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
		center.add(jScrollPane1, BorderLayout.CENTER);

		JPanel centerSouth = new JPanel();
		centerSouth.setPreferredSize(new Dimension(10, 250));
		center.add(centerSouth, BorderLayout.SOUTH);
		centerSouth.setLayout(new BorderLayout(0, 0));

		JPanel middlePanel = new JPanel();
		centerSouth.add(middlePanel);

		JPanel box = new JPanel();
		middlePanel.add(box);
		box.setLayout(new BoxLayout(box, BoxLayout.Y_AXIS));

		btnSearch = new JButton("Search");
		btnSearch.setPreferredSize(new Dimension(80, 25));
		btnSearch.setMaximumSize(new Dimension(80, 25));
		box.add(btnSearch);

		btnModify = new JButton("Modify");
		btnModify.setPreferredSize(new Dimension(80, 25));
		btnModify.setMaximumSize(new Dimension(80, 25));
		box.add(btnModify);

		btnDelete = new JButton("Delete");
		btnDelete.setPreferredSize(new Dimension(80, 25));
		btnDelete.setMaximumSize(new Dimension(80, 25));
		box.add(btnDelete);

		btnView = new JButton("View");
		btnView.setPreferredSize(new Dimension(80, 25));
		btnView.setMaximumSize(new Dimension(80, 25));
		box.add(btnView);

		JPanel searchPanel = new JPanel();
		searchPanel.setPreferredSize(new Dimension(200, 104));
		middlePanel.add(searchPanel);

		txtSearch = new JTextField();
		txtSearch.setColumns(15);
		searchPanel.add(txtSearch);

		JPanel clearPanel = new JPanel();
		clearPanel.setPreferredSize(new Dimension(100, 104));
		middlePanel.add(clearPanel);

		btnClear = new JButton("Clear");
		btnClear.setPreferredSize(new Dimension(80, 25));
		btnClear.setMaximumSize(new Dimension(80, 25));
		clearPanel.add(btnClear);

		JPanel bottom = new JPanel();
		centerSouth.add(bottom, BorderLayout.SOUTH);
		bottom.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btnBack = new JButton("Back");
		bottom.add(btnBack);


		JPanel east = new JPanel();
		east.setPreferredSize(new Dimension(400, 10));
		contentPane.add(east, BorderLayout.EAST);
		east.setLayout(new BorderLayout(0, 0));

		JPanel eastCenter = new JPanel();
		eastCenter.setBorder(new TitledBorder(null, "Details", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		east.add(eastCenter);

		JPanel namePanel = new JPanel();
		eastCenter.add(namePanel);

		JLabel lblName = new JLabel("Name");
		lblName.setPreferredSize(new Dimension(90, 14));
		namePanel.add(lblName);

		txtName = new JTextField();
		txtName.setEditable(false);
		txtName.setColumns(15);
		namePanel.add(txtName);

		JPanel icPanel = new JPanel();
		eastCenter.add(icPanel);

		JLabel lblIC = new JLabel("IC/Passport");
		lblIC.setPreferredSize(new Dimension(90, 14));
		icPanel.add(lblIC);

		txtIC = new JTextField();
		txtIC.setEditable(false);
		txtIC.setColumns(15);
		icPanel.add(txtIC);

		JPanel phonePanel = new JPanel();
		eastCenter.add(phonePanel);

		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setPreferredSize(new Dimension(90, 14));
		phonePanel.add(lblPhone);

		txtPhone = new JTextField();
		txtPhone.setEditable(false);
		txtPhone.setColumns(15);
		phonePanel.add(txtPhone);

		JPanel emailPanel = new JPanel();
		eastCenter.add(emailPanel);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setPreferredSize(new Dimension(90, 14));
		emailPanel.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setEditable(false);
		txtEmail.setColumns(15);
		emailPanel.add(txtEmail);

		JPanel roomPanel = new JPanel();
		eastCenter.add(roomPanel);

		JLabel lblRoom = new JLabel("Room ID");
		lblRoom.setPreferredSize(new Dimension(90, 14));
		roomPanel.add(lblRoom);

		txtRoomID = new JTextField();
		txtRoomID.setEditable(false);
		txtRoomID.setColumns(15);
		roomPanel.add(txtRoomID);
		txtRoomID.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				txtRoomIDKeyReleased(evt);
			}
		});

		JPanel datePanel = new JPanel();
		eastCenter.add(datePanel);

		JLabel lblDate = new JLabel("Date");
		lblDate.setPreferredSize(new Dimension(90, 14));
		datePanel.add(lblDate);

		txtDate = new JDateChooser();
		txtDate.setPreferredSize(new Dimension(168, 20));
		txtDate.setDateFormatString("yyyy-MM-dd");
		datePanel.add(txtDate);
		txtDate.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
			public void propertyChange(java.beans.PropertyChangeEvent evt) {
				txtDatePropertyChange(evt);
			}
		});

		JPanel durationPanel = new JPanel();
		eastCenter.add(durationPanel);

		JLabel lblDuration = new JLabel("Duration");
		lblDuration.setPreferredSize(new Dimension(90, 14));
		durationPanel.add(lblDuration);

		txtDuration = new JSpinner();
		txtDuration.setPreferredSize(new Dimension(140, 20));
		durationPanel.add(txtDuration);
		txtDuration.addChangeListener(new javax.swing.event.ChangeListener() {
			public void stateChanged(javax.swing.event.ChangeEvent evt) {
				txtDurationStateChanged(evt);
			}
		});

		JLabel lblDays = new JLabel("Days");
		durationPanel.add(lblDays);

		JPanel eastSouth = new JPanel();
		eastSouth.setBorder(new TitledBorder(null, "Price", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		eastSouth.setPreferredSize(new Dimension(10, 200));
		east.add(eastSouth, BorderLayout.SOUTH);
		eastSouth.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JPanel subtotalPanel = new JPanel();
		eastSouth.add(subtotalPanel);

		JLabel lblSubtotal = new JLabel("Subtotal");
		lblSubtotal.setPreferredSize(new Dimension(90, 14));
		subtotalPanel.add(lblSubtotal);

		txtSubTotal = new JTextField();
		txtSubTotal.setEditable(false);
		txtSubTotal.setColumns(15);
		subtotalPanel.add(txtSubTotal);

		JPanel ServiceTaxPanel = new JPanel();
		eastSouth.add(ServiceTaxPanel);

		JLabel lblServiceTax = new JLabel("Service Tax");
		lblServiceTax.setPreferredSize(new Dimension(90, 14));
		ServiceTaxPanel.add(lblServiceTax);

		txtService = new JTextField();
		txtService.setEditable(false);
		txtService.setColumns(15);
		ServiceTaxPanel.add(txtService);

		JPanel touriumTaxPanel = new JPanel();
		eastSouth.add(touriumTaxPanel);

		JLabel lblTourTax = new JLabel("Tourism Tax");
		lblTourTax.setPreferredSize(new Dimension(90, 14));
		touriumTaxPanel.add(lblTourTax);

		txtTourTax = new JTextField();
		txtTourTax.setEditable(false);
		txtTourTax.setColumns(15);
		touriumTaxPanel.add(txtTourTax);

		JPanel totalPricePanel = new JPanel();
		eastSouth.add(totalPricePanel);

		JLabel lblPrice = new JLabel("Total Price");
		lblPrice.setPreferredSize(new Dimension(90, 14));
		totalPricePanel.add(lblPrice);

		txtTotalPrice = new JTextField();
		txtTotalPrice.setEditable(false);
		txtTotalPrice.setColumns(15);
		totalPricePanel.add(txtTotalPrice);

		JPanel updatePanel = new JPanel();
		eastSouth.add(updatePanel);

		btnUpdate = new JButton("Update Record");
		btnUpdate.setPreferredSize(new Dimension(150, 23));
		updatePanel.add(btnUpdate);



		txtDate.setEnabled(false);
		txtDuration.setEnabled(false);
		btnBack.addActionListener(this);
		btnClear.addActionListener(this);
		btnDelete.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnModify.addActionListener(this);
		btnView.addActionListener(this);
		btnSearch.addActionListener(this);
	}



	//This method runs when the user clicks away from the roomid textfield
	private void txtRoomIDKeyReleased(java.awt.event.KeyEvent evt) {
		//this code will check if the give room is available for the specified duration, if not available, create a message dialog and block the update button
		int duration = (Integer)txtDuration.getValue();
		try{
			Date datebefore = txtDate.getDate();
			String roomid = txtRoomID.getText();
			//BlockCheck var = new BlockCheck();
			Boolean Blocked = false;
			for(int i =0;i<ObjBookingList.size(); i++){
				if(index == i){
					continue;
				}
				// Booking temp = tempList.get(i);
				Date comDateBf = dcn.parse(ObjBookingList.getBooking(i).getDate());
				int comDuration = (Integer.parseInt(ObjBookingList.getBooking(i).getduration()));
				String comRoom =ObjBookingList.getBooking(i).getRoomID();
				if (roomid.equals(comRoom)){
					Boolean Block = booking.CheckDate(datebefore, duration, comDateBf, comDuration);
					if(Block){
						System.out.println("conflict detected");
						Blocked = true;
						break;
					}else{
						System.out.println("False");
					}

				}

			}
			if(Blocked){
				btnUpdate.setEnabled(false);
				JOptionPane.showMessageDialog(null, "Room occupied on selected date, please select another date, duration, or Room");
			}else{
				btnUpdate.setEnabled(true);
			}

		} catch (Exception e) {
		}
	}

	//This method will be run when the JSpinner duration has the value changed
	private void txtDurationStateChanged(javax.swing.event.ChangeEvent evt) {
		//this code will check if the give room is available for the specified duration, if not available, create a message dialog and block the update button


		int duration = (Integer)txtDuration.getValue();
		int subtotal = duration * 350;
		txtSubTotal.setText("€" + Integer.toString(subtotal) + ".00");
		double sTax = subtotal *0.1 ;
		txtService.setText("€" + Double.toString(sTax) + "0");
		int tourtax = duration *  10;
		txtTourTax.setText("€" + Integer.toString(tourtax) + ".00");
		double total = subtotal + sTax + tourtax;
		txtTotalPrice.setText("€" + Double.toString(total) + "0");
		try{
			Date datebefore = txtDate.getDate();
			String roomid = txtRoomID.getText();

			Boolean Blocked = false;
			for(int i =0;i<ObjBookingList.size(); i++){
				if(index == i){
					continue;
				}
				//Booking temp = tempList.get(i);
				Date comDateBf = dcn.parse(ObjBookingList.getBooking(i).getDate());
				int comDuration = (Integer.parseInt(ObjBookingList.getBooking(i).getduration()));
				String comRoom = ObjBookingList.getBooking(i).getRoomID();
				if (roomid.equals(comRoom)){
					Boolean Block = booking.CheckDate(datebefore, duration, comDateBf, comDuration);
					if(Block){
						//System.out.println("conflict detected True");
						Blocked = true;
						break;
					}else{
						//System.out.println("False");
					}

				}

			}
			if(Blocked){
				btnUpdate.setEnabled(false);
				JOptionPane.showMessageDialog(null, "Room occupied on selected date, please select another date, duration, or Room");
			}else{
				btnUpdate.setEnabled(true);
			}

		} catch (Exception e) {
		}


	}



	//This method will be run when the date text field has the value changed

	private void txtDatePropertyChange(java.beans.PropertyChangeEvent evt) {
		//this code will check if the give room is available for the specified duration, if not available, create a message dialog and block the update button
		int duration = (Integer)txtDuration.getValue();
		try{
			Date datebefore = txtDate.getDate();
			String roomid = txtRoomID.getText();
			//BlockCheck var = new BlockCheck();
			Boolean Blocked = false;
			for(int i =0;i<ObjBookingList.size(); i++){
				if(index == i){
					continue;
				}
				//Booking temp = tempList.get(i);
				Date comDateBf = dcn.parse(ObjBookingList.getBooking(i).getDate());
				int comDuration = (Integer.parseInt(ObjBookingList.getBooking(i).getduration()));
				String comRoom = ObjBookingList.getBooking(i).getRoomID();
				if (roomid.equals(comRoom)){
					Boolean Block = booking.CheckDate(datebefore, duration, comDateBf, comDuration);
					if(Block){

						System.out.println(ObjBookingList.getBooking(i).getDate());

						System.out.println(datebefore);
						System.out.println(duration);
						System.out.println(comDateBf);
						System.out.println(comDuration);
						System.out.println("conflict detectedTrue");
						Blocked = true;
						break;
					}else{
					}

				}

			}
			if(Blocked){
				btnUpdate.setEnabled(false);
				JOptionPane.showMessageDialog(null, "Conflict detected, please select another date, duration, or Room");
			}else{
				btnUpdate.setEnabled(true);
			}

		} catch (Exception e) {
		}        // TODO add your handling code here:
	}


	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnSearch)
		{
			//this code will search if the keyword appears in any booking details and display those on the table
			String Search = txtSearch.getText();

			filteredList.clear();
			DefaultTableModel model = (DefaultTableModel)tblBooking.getModel();
			model.setRowCount(0);
			tblBooking.clearSelection();

			//this for loop search for the keyword in the array and puts them on the filtered list array
			for(int i =0;i<ObjBookingList.size(); i++){

				if(ObjBookingList.getBooking(i).getArray().toString().toLowerCase().contains(Search.toLowerCase())){

					filteredList.add(ObjBookingList.getBooking(i));
				}



			}

			//this for loop prints the filtered list to the table
			for (booking objBooking : filteredList) {
				Object[] rowData = {objBooking.getName(), objBooking.getRoomID(), objBooking.getDate(), objBooking.getduration()};
				model.addRow(rowData);
			}
			if(!Search.equals("")){
				searching = true;
			}



		}
		else if (e.getSource() == btnClear)
		{
			//this button will reset the table

			filteredList.clear();
			searching = false;
			txtSearch.setText("");
			DefaultTableModel model = (DefaultTableModel)tblBooking.getModel();
			model.setRowCount(0);
			tblBooking.clearSelection();
			for(int i =0;i<ObjBookingList.size(); i++){
				// Booking temp = tempList.get(i);


				TableData[0] = ObjBookingList.getBooking(i).getName();
				TableData[1] = ObjBookingList.getBooking(i).getRoomID();
				TableData[2] = ObjBookingList.getBooking(i).getDate();
				TableData[3] = ObjBookingList.getBooking(i).getduration();
				model.addRow(TableData);



			}
			btnModify.setEnabled(true);
			btnView.setEnabled(true);
			btnDelete.setEnabled(true);


		}
		else if (e.getSource() == btnModify) {



			//this button will get the selected row and display the details on the right column to allow the details to be edited
			tableRow  = tblBooking.getSelectedRow();

			if (tableRow == -1) {
				JOptionPane.showMessageDialog(null, "Please select a booking to modify", "Error", JOptionPane.WARNING_MESSAGE);
			}else if(searching){


				index = ObjBookingList.getIndex(filteredList.get(tableRow));
				rowtoedit = index;
			}else{

				index  = tblBooking.getSelectedRow();
				rowtoedit = index;
			}




			//runs only when a row in the table is selected
			if (tableRow!= -1){

				try{
					// Booking temp = tempList.get(tableRow);
					txtName.setText(ObjBookingList.getBooking(index).getName());
					txtIC.setText(ObjBookingList.getBooking(index).getIC());
					txtPhone.setText(ObjBookingList.getBooking(index).getPhone());
					txtEmail.setText(ObjBookingList.getBooking(index).getEmail());
					txtRoomID.setText(ObjBookingList.getBooking(index).getRoomID());
					String datestr = ObjBookingList.getBooking(index).getDate();
					Date date;

					date = dcn.parse(datestr);

					txtDate.setDate(date);
					txtDuration.setValue(Integer.parseInt(ObjBookingList.getBooking(index).getduration()));
					int subtotal = Integer.parseInt(ObjBookingList.getBooking(index).getduration()) * 350;
					txtSubTotal.setText("€" + Integer.toString(subtotal) + ".00");
					double sTax = subtotal *0.1 ;
					txtService.setText("€" + Double.toString(sTax) + "0");
					int tourtax = Integer.parseInt(ObjBookingList.getBooking(index).getduration()) *  10;
					txtTourTax.setText("€" + Integer.toString(tourtax) + ".00");
					double total = subtotal + sTax + tourtax;
					txtTotalPrice.setText("€" + Double.toString(total) + "0");
					txtName.setEditable(true);
					txtDate.setEnabled(true);
					txtIC.setEditable(true);
					txtRoomID.setEditable(true);
					txtPhone.setEditable(true);
					txtEmail.setEditable(true);
					txtDuration.setEnabled(true);
					btnUpdate.setEnabled(true);}


				catch(Exception ex){

				}
			}
		}
		else if (e.getSource() == btnDelete)
		{


			tableRow  = tblBooking.getSelectedRow();
			if (tableRow== -1){
				JOptionPane.showMessageDialog(null, "Please select an booking to delete", "Error", JOptionPane.WARNING_MESSAGE);}


			else if(searching){


				index = ObjBookingList.getIndex(filteredList.get(tableRow));
			}else{

				index  = tblBooking.getSelectedRow();
			}



			if (tableRow!= -1){



				int result = JOptionPane.showConfirmDialog(null,"Are you sure you want delete this booking?", "Confirmation",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE );
				if(result == JOptionPane.YES_OPTION){




					ObjBookingList.removeBooking(index);

					try {
						ObjBookingList.writeBookingDetailsToFile();
					} catch (IOException ex) {
						throw new RuntimeException(ex);
					}

						System.out.println("File Successfully Rename");
						manageBooking manage = new manageBooking();
						manage.setVisible(true);
						this.dispose();
//					}else{
//						System.out.println("Failed to rename");
//					}
					}
			}

		}
		else if (e.getSource() == btnView)
		{
			try{

				
				if(searching){

					tableRow  = tblBooking.getSelectedRow();
					index = ObjBookingList.getIndex(filteredList.get(tableRow));
				}else{
					index  = tblBooking.getSelectedRow();
				}


				// Booking temp = tempList.get(tableRow);

				txtName.setText(ObjBookingList.getBooking(index).getName());
				txtIC.setText(ObjBookingList.getBooking(index).getIC());
				txtPhone.setText(ObjBookingList.getBooking(index).getPhone());
				txtEmail.setText(ObjBookingList.getBooking(index).getEmail());
				txtRoomID.setText(ObjBookingList.getBooking(index).getRoomID());
				String datestr = ObjBookingList.getBooking(index).getDate();
				Date date;

				date = dcn.parse(datestr);

				txtDate.setDate(date);
				txtDuration.setValue(Integer.parseInt(ObjBookingList.getBooking(index).getduration()));
				int subtotal = Integer.parseInt(ObjBookingList.getBooking(index).getduration()) * 350;
				txtSubTotal.setText("RM" + Integer.toString(subtotal) + ".00");
				double sTax = subtotal *0.1 ;
				txtService.setText("RM" + Double.toString(sTax) + "0");
				int tourtax = Integer.parseInt(ObjBookingList.getBooking(index).getduration()) *  10;
				txtTourTax.setText("RM" + Integer.toString(tourtax) + ".00");
				double total = subtotal + sTax + tourtax;
				txtTotalPrice.setText("RM" + Double.toString(total) + "0");


			}
			catch(Exception ex){
				JOptionPane.showMessageDialog(null, "Please select an Entry to view", "Error", JOptionPane.WARNING_MESSAGE);

			}
			txtName.setEditable(false);
			txtDate.setEnabled(false);
			txtIC.setEditable(false);
			txtRoomID.setEditable(false);
			txtPhone.setEditable(false);
			txtEmail.setEditable(false);
			txtDuration.setEnabled(false);
			btnUpdate.setEnabled(false);

		}
		else if (e.getSource() == btnUpdate)
		{
			try{
				//get values on gui text fields, replace selected row with the new object on the list, and write list to the text file.

				String Name = txtName.getText();
				String IC = txtIC.getText();
				String Number = txtPhone.getText();
				String Email = txtEmail.getText();
				String room = txtRoomID.getText();

				String Duration = txtDuration.getValue().toString();
				SimpleDateFormat dcn = new SimpleDateFormat ("yyyy-MM-dd");
				String date1 = dcn.format(txtDate.getDate() );
				int result = JOptionPane.showConfirmDialog(null,"Are you sure you want to update this booking?", "Confirmation",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE );
				if(result == JOptionPane.YES_OPTION){


					booking write = new booking(Name,IC,Number,Email,room,date1,Duration);

					ObjBookingList.setBooking(rowtoedit, write);
					ObjBookingList.writeBookingDetailsToFile();

						manageBooking manage = new manageBooking();
						manage.setVisible(true);
						this.dispose();
//					}else{
//						System.out.println("Failed to rename");
//					}
				}





			}
			catch (Exception ex)
			{
				JOptionPane.showMessageDialog(null, "Please enter data to all the fields", "Error", JOptionPane.WARNING_MESSAGE);
			}
		}


		else if (e.getSource() == btnBack)
		{

			MainMenuGUI back = new MainMenuGUI();
			back.setVisible(true);
			this.dispose();
		}
	}
}
