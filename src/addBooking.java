import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.concurrent.TimeUnit;

public class addBooking extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtIC, txtPhone, txtCheckOut, txtEmail;
	private JButton btnSubmit, btnBack;
	javax.swing.JSpinner txtDuration;

	JRadioButton btnS01, btnS02,btnS03,btnS04,btnS05,btnS06,btnS07,btnS08,btnS09,btnS10,btnJ01,btnJ02,btnJ03,btnJ04,btnJ05,btnJ06,btnJ07,btnJ08,btnJ09,btnJ10;
	
	ButtonGroup btnGroup;
	com.toedter.calendar.JDateChooser dateBefore;

	String room;
	String dateAfterFormat;

	bookingList ObjBookingList;


	public addBooking() {

		ObjBookingList = new bookingList();

		//reads the booking file and store it on the booking list object
		try {
			ObjBookingList.readBookingDetailsFromFile();
		}catch (Exception e) {

		}

		txtDuration = new javax.swing.JSpinner();
		gui_init();


		
	}



	private void gui_init(){
		setTitle("Add Booking");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 782, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Add Booking", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel Left = new JPanel();
		contentPane.add(Left);
		Left.setLayout(new BoxLayout(Left, BoxLayout.Y_AXIS));

		JPanel leftTop = new JPanel();
		Left.add(leftTop);
		leftTop.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JPanel namePanel = new JPanel();
		Left.add(namePanel);

		JLabel lblName = new JLabel("Name");
		lblName.setPreferredSize(new Dimension(90, 14));
		namePanel.add(lblName);

		txtName = new JTextField();
		namePanel.add(txtName);
		txtName.setColumns(15);

		JPanel passportPanel = new JPanel();
		Left.add(passportPanel);

		JLabel lblIC = new JLabel("IC/Passport");
		lblIC.setPreferredSize(new Dimension(90, 14));
		passportPanel.add(lblIC);

		txtIC = new JTextField();
		passportPanel.add(txtIC);
		txtIC.setColumns(15);

		JPanel numberPanel = new JPanel();
		Left.add(numberPanel);

		JLabel lblNumber = new JLabel("Phone Number");
		lblNumber.setPreferredSize(new Dimension(90, 14));
		numberPanel.add(lblNumber);

		txtPhone = new JTextField();
		numberPanel.add(txtPhone);
		txtPhone.setColumns(15);

		JPanel checkinPanel = new JPanel();
		Left.add(checkinPanel);

		JLabel lblCheckIn = new JLabel("Check-in Date");
		lblCheckIn.setPreferredSize(new Dimension(90, 14));
		checkinPanel.add(lblCheckIn);


		dateBefore = new com.toedter.calendar.JDateChooser();
		dateBefore.setDateFormatString("yyyy-MM-dd");
		dateBefore.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
			public void propertyChange(java.beans.PropertyChangeEvent evt) {
				dateBeforePropertyChange(evt);
			}
		});
		dateBefore.setPreferredSize(new Dimension(168, 20));

		checkinPanel.add(dateBefore);

		JPanel durationPanel = new JPanel();
		Left.add(durationPanel);

		JLabel lblDuration = new JLabel("Duration");
		lblDuration.setPreferredSize(new Dimension(90, 14));
		durationPanel.add(lblDuration);

				
		txtDuration.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
		txtDuration.setPreferredSize(new Dimension(140, 20));
		txtDuration.addChangeListener(new javax.swing.event.ChangeListener() {
			public void stateChanged(javax.swing.event.ChangeEvent evt) {
				txtDurationStateChanged(evt);
			}
		});


		durationPanel.add(txtDuration);

		JLabel lblDays = new JLabel("Days");
		durationPanel.add(lblDays);

		JPanel checkoutPanel = new JPanel();
		Left.add(checkoutPanel);

		JLabel lblCheckOut = new JLabel("Check-out Date");
		lblCheckOut.setPreferredSize(new Dimension(90, 14));
		checkoutPanel.add(lblCheckOut);
		checkoutPanel.setPreferredSize(new Dimension(1, 75));
		txtCheckOut = new JTextField();
		txtCheckOut.setPreferredSize(new Dimension(128, 20));
		txtCheckOut.setEditable(false);
		txtCheckOut.setColumns(15);
		checkoutPanel.add(txtCheckOut);

		JPanel right = new JPanel();
		contentPane.add(right, BorderLayout.EAST);
		right.setPreferredSize(new Dimension(370, 1));
		right.setLayout(new BorderLayout(0, 0));

		JPanel rightNorth = new JPanel();
		rightNorth.setPreferredSize(new Dimension(1, 75));
		right.add(rightNorth, BorderLayout.NORTH);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setPreferredSize(new Dimension(90, 14));
		rightNorth.add(lblEmail);

		txtEmail = new JTextField();
		rightNorth.add(txtEmail);
		txtEmail.setColumns(15);


		JPanel rightCenter = new JPanel();
		rightCenter.setBorder(new TitledBorder(null, "Room", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		right.add(rightCenter, BorderLayout.CENTER);
		rightCenter.setLayout(new BorderLayout(0, 0));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		rightCenter.add(tabbedPane);

		JPanel seaPanel = new JPanel();
		tabbedPane.addTab("Sea", null, seaPanel, null);
		seaPanel.setLayout(new GridLayout(1, 2, 0, 0));

		JPanel seaPanelLeft = new JPanel();
		seaPanel.add(seaPanelLeft);
		seaPanelLeft.setLayout(new BoxLayout(seaPanelLeft, BoxLayout.Y_AXIS));

		btnS01 = new JRadioButton("Room 01");
		seaPanelLeft.add(btnS01);


		btnS02 = new JRadioButton("Room 02");
		seaPanelLeft.add(btnS02);


		btnS03 = new JRadioButton("Room 03");
		seaPanelLeft.add(btnS03);


		btnS04 = new JRadioButton("Room 04");
		seaPanelLeft.add(btnS04);

		btnS05 = new JRadioButton("Room 05");
		seaPanelLeft.add(btnS05);

		JPanel seaPanelRight = new JPanel();
		seaPanel.add(seaPanelRight);
		seaPanelRight.setLayout(new BoxLayout(seaPanelRight, BoxLayout.Y_AXIS));

		btnS06 = new JRadioButton("Room 06");
		seaPanelRight.add(btnS06);

		btnS07 = new JRadioButton("Room 07");
		seaPanelRight.add(btnS07);

		btnS08 = new JRadioButton("Room 08");
		seaPanelRight.add(btnS08);

		btnS09 = new JRadioButton("Room 09");
		seaPanelRight.add(btnS09);

		btnS10 = new JRadioButton("Room 10");
		seaPanelRight.add(btnS10);

		JPanel junglePanel = new JPanel();
		tabbedPane.addTab("Jungle", null, junglePanel, null);
		junglePanel.setLayout(new GridLayout(1, 2, 0, 0));

		JPanel junglePanelLeft = new JPanel();
		junglePanel.add(junglePanelLeft);
		junglePanelLeft.setLayout(new BoxLayout(junglePanelLeft, BoxLayout.Y_AXIS));

		btnJ01 = new JRadioButton("Room 01");
		junglePanelLeft.add(btnJ01);

		btnJ02 = new JRadioButton("Room 02");
		junglePanelLeft.add(btnJ02);

		btnJ03 = new JRadioButton("Room 03");
		junglePanelLeft.add(btnJ03);

		btnJ04 = new JRadioButton("Room 04");
		junglePanelLeft.add(btnJ04);

		btnJ05 = new JRadioButton("Room 05");
		junglePanelLeft.add(btnJ05);

		JPanel junglePanelRight = new JPanel();
		junglePanel.add(junglePanelRight);
		junglePanelRight.setLayout(new BoxLayout(junglePanelRight, BoxLayout.Y_AXIS));

		btnJ06 = new JRadioButton("Room 06");
		junglePanelRight.add(btnJ06);

		btnJ07 = new JRadioButton("Room 07");
		junglePanelRight.add(btnJ07);

		btnJ08 = new JRadioButton("Room 08");
		junglePanelRight.add(btnJ08);

		btnJ09 = new JRadioButton("Room 09");
		junglePanelRight.add(btnJ09);

		btnJ10 = new JRadioButton("Room 10");
		junglePanelRight.add(btnJ10);

		JPanel roomInfoPanel = new JPanel();
		rightCenter.add(roomInfoPanel, BorderLayout.SOUTH);

		JLabel lblRoomInfo = new JLabel("Rooms that are unavailable for the duration are greyed out.");
		roomInfoPanel.add(lblRoomInfo);

		JPanel rightSouth = new JPanel();
		rightSouth.setPreferredSize(new Dimension(1, 90));
		right.add(rightSouth, BorderLayout.SOUTH);

		btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(this);
		rightSouth.add(btnSubmit);

		btnBack = new JButton("Back");
		btnBack.addActionListener(this);
		rightSouth.add(btnBack);


		btnGroup = new ButtonGroup();
		btnGroup.add(btnS01);
		btnGroup.add(btnS02);
		btnGroup.add(btnS03);
		btnGroup.add(btnS04);
		btnGroup.add(btnS05);
		btnGroup.add(btnS06);
		btnGroup.add(btnS07);
		btnGroup.add(btnS08);
		btnGroup.add(btnS09);
		btnGroup.add(btnS10);
		btnGroup.add(btnJ01);
		btnGroup.add(btnJ02);
		btnGroup.add(btnJ03);
		btnGroup.add(btnJ04);
		btnGroup.add(btnJ05);
		btnGroup.add(btnJ06);
		btnGroup.add(btnJ07);
		btnGroup.add(btnJ08);
		btnGroup.add(btnJ09);
		btnGroup.add(btnJ10);
		btnS01.addActionListener(this);
		btnS02.addActionListener(this);
		btnS03.addActionListener(this);
		btnS04.addActionListener(this);
		btnS05.addActionListener(this);
		btnS06.addActionListener(this);
		btnS07.addActionListener(this);
		btnS08.addActionListener(this);
		btnS09.addActionListener(this);
		btnS10.addActionListener(this);
		btnJ01.addActionListener(this);
		btnJ02.addActionListener(this);
		btnJ03.addActionListener(this);
		btnJ04.addActionListener(this);
		btnJ05.addActionListener(this);
		btnJ06.addActionListener(this);
		btnJ07.addActionListener(this);
		btnJ08.addActionListener(this);
		btnJ09.addActionListener(this);
		btnJ10.addActionListener(this);
	}


	private void dateBeforePropertyChange(java.beans.PropertyChangeEvent evt) {
		roomCheck();
    }

	private void txtDurationStateChanged(javax.swing.event.ChangeEvent evt) {
		roomCheck();
	}

	//Room check will room on specified date and block the room button if they are occupied
	private void roomCheck(){
		int duration = (Integer) txtDuration.getValue();
		try {
			SimpleDateFormat dcn = new SimpleDateFormat ("yyyy-MM-dd");
			Date date1 = dateBefore.getDate();
			long longduration = TimeUnit.MILLISECONDS.convert (duration, TimeUnit.DAYS);
			long chkoutmilli = date1.getTime() + longduration;
			Date dateAfter = new Date(chkoutmilli);
			dateAfterFormat = dcn.format(dateAfter);
			txtCheckOut.setText(dateAfterFormat);
			btnGroup.clearSelection();
			room = null;
			Enumeration<AbstractButton> enumeration = btnGroup.getElements();
			//BlockCheck var = new BlockCheck();
			while (enumeration.hasMoreElements()) {
				enumeration.nextElement().setEnabled(true);
			}

			for(int i =0;i<ObjBookingList.size(); i++){
				// booking temp = tempList.get(i);
				Date comDateBf = dcn.parse(ObjBookingList.getBooking(i).getDate());
				int Duration = (Integer.parseInt(ObjBookingList.getBooking(i).getduration()));
				String CheckDate;

				CheckDate = booking.CheckDate(date1, dateAfter, comDateBf, Duration);
				if(CheckDate.equals("True")){
					String roomid = ObjBookingList.getBooking(i).getRoomID();
				//	System.out.println("conflict detected, " + roomid + " will be blocked");
					switch(roomid){
						case "S01":
							btnS01.setEnabled(false);
							break;
						case "S02":
							btnS02.setEnabled(false);
							break;
						case "S03":
							btnS03.setEnabled(false);
							break;
						case "S04":
							btnS04.setEnabled(false);
							break;
						case "S05":
							btnS05.setEnabled(false);
							break;
						case "S06":
							btnS06.setEnabled(false);
							break;
						case "S07":
							btnS07.setEnabled(false);
							break;
						case "S08":
							btnS08.setEnabled(false);
							break;
						case "S09":
							btnS09.setEnabled(false);
							break;
						case "S10":
							btnS10.setEnabled(false);
							break;
						case "J01":
							btnJ01.setEnabled(false);
							break;
						case "J02":
							btnJ02.setEnabled(false);
							break;
						case "J03":
							btnJ03.setEnabled(false);
							break;
						case "J04":
							btnJ04.setEnabled(false);
							break;
						case "J05":
							btnJ05.setEnabled(false);
							break;
						case "J06":
							btnJ06.setEnabled(false);
							break;
						case "J07":
							btnJ07.setEnabled(false);
							break;
						case "J08":
							btnJ08.setEnabled(false);
							break;
						case "J09":
							btnJ09.setEnabled(false);
							break;
						case "J10":
							btnJ10.setEnabled(false);
							break;


					}


				}



			}
		}
		catch(Exception Ex)
		{

		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSubmit)
		{


			// get all the values on the GUI, write them to the object, write it to file and check room occupied
			try{
				if(room == null){
					throw new ArithmeticException();
				}
				String Name = txtName.getText();
				String IC = txtIC.getText();
				String Number = txtPhone.getText();
				String Email = txtEmail.getText();
				String Duration = txtDuration.getValue().toString();
				SimpleDateFormat dcn = new SimpleDateFormat ("yyyy-MM-dd");
				String date1 = dcn.format(dateBefore.getDate() );
				int result = JOptionPane.showConfirmDialog(null,"Are you sure you want to add this booking?", "Confirmation",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE );
				if(result == JOptionPane.YES_OPTION){
					booking newBooking = new booking(Name, IC, Number, Email, room, date1 , Duration );
					ObjBookingList.addBooking(newBooking);
					ObjBookingList.writeBookingDetailsToFile();
					JOptionPane.showMessageDialog(null, "Booking Added!");

					roomCheck();
//					addBooking add = new addBooking();
//					add.setVisible(true);
//					this.dispose();
				}



			}
			catch (Exception ex) {JOptionPane.showMessageDialog(null, "Please enter data to all the fields", "Error", JOptionPane.WARNING_MESSAGE);}


		}else if (e.getSource() == btnBack)
		{
			//go back to main menu
			MainMenuGUI back = new MainMenuGUI();
			back.setVisible(true);
			this.dispose();



			//Buttons below will set the room string variable with its selected room
		}else if (e.getSource() == btnS01){
			room = "S01";
		}else if (e.getSource() == btnS02){
			room = "S02";
		}
		else if (e.getSource() == btnS03){
			room = "S03";
		}
		else if (e.getSource() == btnS04){
			room = "S04";
		}
		else if (e.getSource() == btnS05){
			room = "S05";
		}
		else if (e.getSource() == btnS06){
			room = "S06";
		}
		else if (e.getSource() == btnS07){
			room = "S07";
		}
		else if (e.getSource() == btnS08){
			room = "S08";
		}
		else if (e.getSource() == btnS09){
			room = "S09";
		}
		else if (e.getSource() == btnS10){
			room = "S10";
		}
		else if (e.getSource() == btnJ01){
			room = "J01";
		}
		else if (e.getSource() == btnJ02){
			room = "J02";
		}
		else if (e.getSource() == btnJ03){
			room = "J03";
		}
		else if (e.getSource() == btnJ04){
			room = "J04";
		}
		else if (e.getSource() == btnJ05){
			room = "J05";
		}
		else if (e.getSource() == btnJ06){
			room = "J06";
		}
		else if (e.getSource() == btnJ07){
			room = "J07";
		}
		else if (e.getSource() == btnJ08){
			room = "J08";
		}
		else if (e.getSource() == btnJ09){
			room = "J09";
		}
		else if (e.getSource() == btnJ10){
			room = "J10";
		}



	}
}

