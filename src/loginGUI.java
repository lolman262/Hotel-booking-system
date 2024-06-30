import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.awt.Dimension;

public class loginGUI extends JFrame implements ActionListener{


	private JTextField txtUserN, txtPass;
	private JButton btnLogin, btnClear;


	public loginGUI() {


		//Initialize the GUI components
		gui_init();

		
		
	}
	
	
	
	private void gui_init(){
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 350);
		JPanel contentPane = new JPanel();

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(2, 1, 0, 0));


		JPanel north = new JPanel();
		contentPane.add(north);
		north.setLayout(new BorderLayout(0, 0));

		JPanel northCenter = new JPanel();
		northCenter.setBackground(Color.YELLOW);
		north.add(northCenter, BorderLayout.CENTER);

		//Text_Panel myText_Panel = new Text_Panel("Hotel yes");

		logo myText_Panel = new logo();
		myText_Panel.setPreferredSize(new Dimension(400, 160));
		myText_Panel.setBackground(Color.YELLOW);
		northCenter.add(myText_Panel);



		JPanel center = new JPanel();
		center.setBackground(Color.GREEN);
		contentPane.add(center);
		center.setLayout(new BorderLayout(0, 0));




		JPanel centerCenter = new JPanel();
		centerCenter.setBackground(Color.GREEN);
		center.add(centerCenter);

		JPanel box = new JPanel();
		centerCenter.add(box);
		box.setLayout(new BoxLayout(box, BoxLayout.Y_AXIS));

		JLabel lblName = new JLabel("Username");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		box.add(lblName);

		JLabel lblPass = new JLabel("Password");
		lblPass.setFont(new Font("Tahoma", Font.PLAIN, 14));
		box.add(lblPass);

		JPanel box2 = new JPanel();
		centerCenter.add(box2);
		box2.setLayout(new BoxLayout(box2, BoxLayout.Y_AXIS));

		txtUserN = new JTextField();
		txtUserN.setColumns(10);
		box2.add(txtUserN);

		txtPass = new JTextField();
		txtPass.setColumns(10);
		box2.add(txtPass);

		JPanel south = new JPanel();
		south.setBackground(Color.CYAN);
		center.add(south, BorderLayout.SOUTH);

		btnLogin = new JButton("Login");
		south.add(btnLogin);
		btnLogin.addActionListener(this);


		btnClear = new JButton("Clear");
		south.add(btnClear);
		btnClear.addActionListener(this);


	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnLogin) {
			//call the login object and call the login method in the login object
			staff objStaff = new staff(txtUserN.getText(), txtPass.getText());
	        if(objStaff.login()){

				//Create the menu gui if login returns true
				MainMenuGUI menu = new MainMenuGUI();
				menu.setVisible(true);
				this.dispose();
			}
	        
	        
		}else if(e.getSource() == btnClear) {


	        txtUserN.setText("");
	        txtPass.setText("");
		}
	}

}
