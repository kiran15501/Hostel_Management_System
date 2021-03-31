package home;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class HomePage extends JFrame{
	JLabel HMS;
    JButton Login,Register;

    public HomePage()
    {
        setLayout(null);

        HMS = new JLabel("Hostel Management System");
        HMS.setFont(new Font("Book Antique",Font.BOLD+Font.ITALIC,30));
        HMS.setForeground(Color.BLACK);
        HMS.setBounds(80,45,450,40);


        Login=new JButton("Login");
        Login.setFont(new Font("Book Antique",Font.BOLD,20));
        Login.setBackground(Color.orange);
        Login.setForeground(Color.BLACK);
        Login.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Login.setBounds(60,130,200,30);

        Register=new JButton("Register");
        Register.setFont(new Font("Book Antique",Font.BOLD,20));
        Register.setBackground(Color.orange);
        Register.setForeground(Color.BLACK);
        Register.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Register.setBounds(300,130,200,30);

        add(HMS);
        add(Login);
        add(Register);

        setTitle("Welcome");
        setLocation(350,250);
        setSize(550,250);
        setBackground(Color.GRAY);
        setForeground(Color.BLACK);
        setResizable(false);
        setVisible(true);

        Login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new login.FirstView();
              
            }
        });
        
        Register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new register.FirstView();              
            }
        });
        
        addWindowListener(new WindowAdapter() {
        	@Override
        	public void windowClosing(WindowEvent arg0) {
        		dispose();
				JOptionPane.showMessageDialog(HMS,"Thank you !");
				System.exit(0);
        	}
		});


    }

}
