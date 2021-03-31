package admin;

import javax.swing.*;

import connect.Database;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.regex.*;

public class StudentDetailsDashboard extends JFrame {
	JLabel RegNoLab;
    JTextField RegNoBox;
    JButton  DetailsButton;

    public static String RegNo,RegisterNumber,Name,roomNo,PhoneNo,city;

    StudentDetailsDashboard()
    {
        setLayout(null);

        RegNoLab = new JLabel("Register No : ");
        RegNoLab.setFont(new Font("Book Antique",Font.BOLD,20));
        RegNoLab.setBounds(100,40,150,30);
        RegNoLab.setForeground(Color.BLACK);

        RegNoBox = new JTextField();
        RegNoBox.setFont(new Font("Book Antique",Font.BOLD,20));
        RegNoBox.setBounds(250,40,150,30);
        RegNoBox.setForeground(Color.BLACK);

        DetailsButton = new JButton("Details");
        DetailsButton.setFont(new Font("Book Antique",Font.BOLD,20));
        DetailsButton.setBackground(Color.orange);
        DetailsButton.setForeground(Color.BLACK);
        DetailsButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        DetailsButton.setBounds(180,100,100,30);


        add(RegNoLab);
        add(RegNoBox);
        add(DetailsButton);

        setTitle("Student Details");
        setSize(500,200);
        setLocation(700,400);
        setBackground(Color.GRAY);
        setForeground(Color.BLACK);
        setResizable(false);
        setVisible(true);

        RegNoBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DetailsButton.requestFocusInWindow();
            }
        });

        DetailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	RegNo = RegNoBox.getText();
            	viewDetails(RegNo);
            }
        });

        DetailsButton.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
            	RegNo = RegNoBox.getText();
            	viewDetails(RegNo);
            }
        });
        
        


        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }
    
    private void viewDetails(String RegNo) {

        JLabel l1 = new JLabel();
        l1.setBounds(125,255, 300,40);
        l1.setFont(new Font("Book Antique",Font.BOLD,18));

        if (Pattern.matches("^[a-zA-Z0-9]{9}$",RegNo))
        {
            try {
                Connection connection = Database.getConnection();

                PreparedStatement st = connection
                        .prepareStatement("Select RegisterNo,Name,RoomNo,phone,city from HostelStudents where RegisterNo=? and department=?");

                st.setString(1, RegNo);
                st.setString(2, AdminLogin.s.department);
                ResultSet rs = st.executeQuery();
                if (rs.next()) {
                    dispose();
                    RegisterNumber = rs.getString(1);
                    Name = rs.getString(2);
                    roomNo = rs.getString(3);
                    PhoneNo = rs.getString(4);
                    city = rs.getString(5);
                    new StudentDetails();
                }
                else
                    {
                    l1.setForeground(Color.red);
                    l1.setText("Student not under your control !");
                    JOptionPane.showMessageDialog(DetailsButton,l1);
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
            l1.setForeground(Color.red);
            l1.setText("Enter Valid Student Register Number");
            JOptionPane.showMessageDialog(DetailsButton,l1);
        }
    }
    
    static void studentDetailsDashboard()
    {
        new StudentDetailsDashboard();
    }
}
