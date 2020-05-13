package ui1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame{
	private JPanel main_panel;
	private JLabel usn_label, pwd_label, message;
	private JTextField usn_input;
	private JPasswordField pwd_input;
	private JButton submit_btn;
	private int height = 400;
	private int width = 800;
	Login() {
		JPanel main_panel = new JPanel();
		JPanel right_panel = new JPanel();
		
		// left_panel
		ImageIcon bg = new ImageIcon(new ImageIcon("img/login_sidebg.jpg").getImage().getScaledInstance(width/2, height, Image.SCALE_SMOOTH));
		JLabel bg_label = new JLabel(bg);
		
		// right_panel
		right_panel.setLayout(new GridBagLayout());
		right_panel.setSize(width/2, height);
		right_panel.setBackground(Color.ORANGE);
		JLabel usn_label = new JLabel("Username");
		usn_input = new JTextField(16);
		JLabel pwd_label = new JLabel("Password");
		pwd_input = new JPasswordField(16);
		JLabel title = new JLabel("ĐĂNG NHẬP");
		submit_btn = new JButton("Đăng nhập");
		GridBagConstraints c = new GridBagConstraints();
		c.gridy = 0;
		c.ipady = 60;
		c.gridwidth = 2;
		c.anchor = GridBagConstraints.CENTER;
		right_panel.add(title, c);
		c.ipady = 0; // reset ipad
		c.gridwidth = 1; // reset width
		c.anchor = GridBagConstraints.LINE_START;
//		c.fill = GridBagConstraints.HORIZONTAL;
		//usn label
		c.gridy = 1;
		c.gridx = 0;
		c.insets = new Insets(10, 10, 0, 0);
		right_panel.add(usn_label, c);
		// usn input
		c.gridx = 1;
		right_panel.add(usn_input, c);
		// pwd label
		c.gridy = 2;
		c.gridx = 0;
		right_panel.add(pwd_label, c);
		// pwd input
		c.gridx = 1;
		right_panel.add(pwd_input, c);
		// login btn
		c.gridx = 1;
		c.gridy = 3;
		c.gridwidth = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		submit_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String usn = usn_input.getText();
				String pwd = new String(pwd_input.getPassword());
				try {
					String url = "jdbc:postgresql://localhost/testing_app?user=postgres&password=1&ssl=false";
					Connection conn = DriverManager.getConnection(url);
					System.out.println("Connect successfully");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		right_panel.add(submit_btn, c);
		// main_panel
		main_panel.setLayout(new BorderLayout());
		main_panel.add(bg_label, BorderLayout.LINE_START);
		main_panel.add(right_panel, BorderLayout.CENTER);
		// Login
		this.add(main_panel);
		setLocationRelativeTo(null);
		setTitle("Đăng nhập - Phần mềm trắc nghiệm");
		setSize(width, height);
		
	}
}
