package student;

import javax.swing.*;

import connect.Database;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.regex.*;

public class StudentLogin extends JFrame {
	JLabel UsernameLable,PasswordLable,LoginLable;
	public static StudentPanel s;

    JTextField UserTextbox;
    JButton LoginButton,RegisterButton;
    JPasswordField passwordField = new JPasswordField();
    
    StudentLogin(){
    	if(s == null) {
	        setLayout(null);
	
	        UsernameLable=new JLabel("Username :");
	        PasswordLable=new JLabel("Password :");
	        LoginLable=new JLabel("Student Login");
	        UsernameLable.setFont(new Font("Book Antique",Font.BOLD,15));
	        PasswordLable.setFont(new Font("Book Antique",Font.BOLD,15));
	        LoginLable.setFont(new Font("Book Antique",Font.BOLD+Font.ITALIC,30));
	        UsernameLable.setBounds(80,150,100,25);
	        PasswordLable.setBounds(80,200,100,25);
	        LoginLable.setBounds(110,60,200,40);
	        UsernameLable.setForeground(Color.BLACK);
	        PasswordLable.setForeground(Color.BLACK);
	        LoginLable.setForeground(Color.BLACK);
	
	        UserTextbox=new JTextField();
	        UserTextbox.setFont(new Font("Book Antique",Font.BOLD,15));
	        UserTextbox.setBounds(180,150,150,25);
	
	        passwordField.setFont(new Font("Book Antique",Font.BOLD,15));
	        passwordField.setBounds(180,200,150,25);
	
	        LoginButton=new JButton("Login");
	        LoginButton.setFont(new Font("Book Antique",Font.BOLD,15));
	        LoginButton.setBackground(Color.orange);
	        LoginButton.setForeground(Color.BLACK);
	        LoginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
	        LoginButton.setBounds(150,260,90,25);
	
	        RegisterButton=new JButton("Register");
	        RegisterButton.setFont(new Font("Book Antique",Font.BOLD,15));
	        RegisterButton.setBackground(Color.orange);
	        RegisterButton.setForeground(Color.BLACK);
	        RegisterButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
	        RegisterButton.setBounds(140,310,110,25);
	
	        add(UsernameLable);
	        add(PasswordLable);
	        add(LoginLable);
	        add(UserTextbox);
	        add(passwordField);
	        add(LoginButton);
	        add(RegisterButton);
	
	        setTitle("Student Login Page");
	        setLocation(300,200);
	        setSize(400,400);
	        setBackground(Color.GRAY);
	        setForeground(Color.BLACK);
	        setResizable(false);
	        setVisible(true);
	
	
	        LoginButton.addActionListener(new ActionListener() {
	
	            public void actionPerformed(ActionEvent e) {
	                String userName = UserTextbox.getText();
	                String password = passwordField.getText();
	                login(userName,password);	
	            }
	        });
	        
	        LoginButton.addKeyListener(new KeyListener() {
				
				@Override
				public void keyTyped(KeyEvent e) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void keyReleased(KeyEvent e) {
					
					
				}
				
				@Override
				public void keyPressed(KeyEvent e) {
					String userName = UserTextbox.getText();
	                String password = passwordField.getText();
	                login(userName,password);
				}
			});
	
	        RegisterButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					StudentRegister.studentRegister();
					
				}
			});
	        addWindowListener(new WindowAdapter(){
	            public void windowClosing(WindowEvent e) {
	                dispose();
	            }
	        });
    	}
    	else {
    		s.setVisible(true);
    	}
    }
    
    private void login(String userName,String password) {
    	String department;
    	
        JLabel l1 = new JLabel();
        l1.setBounds(125,255, 300,40);
        l1.setFont(new Font("Book Antique",Font.BOLD,18));
        l1.setForeground(Color.red);

        if(Pattern.matches("^[a-zA-Z0-9]{9}$",userName))
        {
            
                try {
                    Connection connection = Database.getConnection();

                    PreparedStatement st = connection
                            .prepareStatement("Select department from HostelStudents where RegisterNo=? and Password=?");

                    st.setString(1, userName);
                    st.setString(2, password);
                    ResultSet rs = st.executeQuery();
                    if (rs.next()) { 
                    	department = rs.getString(1);
                        dispose();
                        l1.setForeground(Color.blue);
                        l1.setText("You have successfully logged in");
                        JOptionPane.showMessageDialog(LoginButton,l1);
                        s = new StudentPanel(userName,department);
                    } else {
                        l1.setText("Wrong Username & Password");
                        JOptionPane.showMessageDialog(LoginButton,l1);
                    }
                    rs.close();
                    st.close();
                }
                catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
        }
        else
        {
            JOptionPane.showMessageDialog(LoginButton, "Unknown User !");
        }

    }
    
    public static void studentLogin() {
        new StudentLogin();
    }
}
