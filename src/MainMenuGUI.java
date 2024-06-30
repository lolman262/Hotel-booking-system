import java.awt.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuGUI extends JFrame implements ActionListener{

	private JPanel cp;
	JButton btnAdd, btnManage, btnViewReceipt, btnLogout;


	public MainMenuGUI() {
		setTitle("Main Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 455);
		cp = new JPanel();

		setContentPane(cp);
		cp.setLayout(new BorderLayout(0, 0));
		
		JPanel north = new JPanel();
		north.setBackground(Color.yellow);
		FlowLayout flowLayout = (FlowLayout) north.getLayout();
		north.setPreferredSize(new Dimension(1, 140));
		cp.add(north, BorderLayout.NORTH);

		logo myText_Panel = new logo();
		myText_Panel.setPreferredSize(new Dimension(400, 160));
		myText_Panel.setBackground(Color.YELLOW);
		north.add(myText_Panel);
		
		JPanel center = new JPanel();
		center.setBackground(new Color(102, 0, 0));
		cp.add(center, BorderLayout.CENTER);
		center.setLayout(new BorderLayout(0, 0));
		
		JPanel south = new JPanel();
		center.add(south, BorderLayout.SOUTH);




		btnLogout = new JButton("Log Out");
		btnLogout.addActionListener(this);
		south.add(btnLogout);
		
		JPanel centerCenter = new JPanel();
		centerCenter.setBackground(Color.GREEN);
		center.add(centerCenter, BorderLayout.CENTER);
		
		JPanel box = new JPanel();
		centerCenter.add(box);
		box.setLayout(new BoxLayout(box, BoxLayout.X_AXIS));



		ImageIcon iconAdd = new ImageIcon("addIcon.png");
		Image imageAddbuffer = iconAdd.getImage();
		Image newimgadd = imageAddbuffer.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH);
		iconAdd = new ImageIcon(newimgadd);
		btnAdd = new JButton("Add Booking");
		btnAdd.setIcon(iconAdd);
		btnAdd.addActionListener(this);
		box.add(btnAdd);
		btnAdd.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnAdd.setHorizontalTextPosition(SwingConstants.CENTER);



		ImageIcon iconManage = new ImageIcon("manageIcon.png");
		Image imageAddManage = iconManage.getImage();
		Image newimgmanage = imageAddManage.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH);
		iconManage = new ImageIcon(newimgmanage);
		btnManage = new JButton("Manage Booking");
		btnManage.addActionListener(this);
		box.add(btnManage);
		btnManage.setIcon(iconManage);
		btnManage.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnManage.setHorizontalTextPosition(SwingConstants.CENTER);

		ImageIcon iconView = new ImageIcon("manageIcon.png");
		Image imageViewManage = iconView.getImage();
		Image newimgview = imageViewManage.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH);
		iconView = new ImageIcon(newimgview);
		btnViewReceipt = new JButton("View Receipt");
		btnViewReceipt.addActionListener(this);
		box.add(btnViewReceipt);
		btnViewReceipt.setIcon(iconView);
		btnViewReceipt.setVerticalTextPosition(SwingConstants.BOTTOM);
		btnViewReceipt.setHorizontalTextPosition(SwingConstants.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btnAdd) 
		{
	        addBooking add = new addBooking();
	        add.setVisible(true);
	        this.dispose();
		}
		else if (e.getSource() == btnManage) 
		{
	        manageBooking manage = new manageBooking();
	        manage.setVisible(true);
	        this.dispose();
		}
		else if (e.getSource() == btnViewReceipt) 
		{
	        viewReceiptGUI view = new viewReceiptGUI();
	        view.setVisible(true);
	        this.dispose();
		}
		else if (e.getSource() == btnLogout) 
		{
	        loginGUI login = new loginGUI();
	        login.setVisible(true);
	        this.dispose();
		}
		
		
	}

}
