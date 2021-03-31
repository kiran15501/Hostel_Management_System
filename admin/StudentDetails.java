package admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class StudentDetails extends JFrame {
	JLabel RegNo,Name,PhoneNo,city,RoomNo;

    StudentDetails()
    {
        setLayout(null);
        //Left Side Labels
        RegNo = new JLabel("Register No");
        RegNo.setFont(new Font("Book Antique",Font.BOLD,20));
        RegNo.setBounds(50,50,150,30);
        RegNo.setForeground(Color.BLACK);

        Name = new JLabel("Name");
        Name.setFont(new Font("Book Antique",Font.BOLD,20));
        Name.setBounds(50,130,150,30);
        Name.setForeground(Color.BLACK);

        RoomNo = new JLabel("Room No");
        RoomNo.setFont(new Font("Book Antique",Font.BOLD,20));
        RoomNo.setBounds(50,210,150,30);
        RoomNo.setForeground(Color.BLACK);

        PhoneNo = new JLabel("Phone No");
        PhoneNo.setFont(new Font("Book Antique",Font.BOLD,20));
        PhoneNo.setBounds(50,290,150,30);
        PhoneNo.setForeground(Color.BLACK);

        city = new JLabel("city");
        city.setFont(new Font("Book Antique",Font.BOLD,20));
        city.setBounds(50,370,150,30);
        city.setForeground(Color.BLACK);

        //Semicolon
        JLabel Semi1 = new JLabel(":");
        Semi1.setFont(new Font("Book Antique",Font.BOLD,20));
        Semi1.setBounds(200,50,150,30);

        JLabel Semi2 = new JLabel(":");
        Semi2.setFont(new Font("Book Antique",Font.BOLD,20));
        Semi2.setBounds(200,130,150,30);

        JLabel Semi3 = new JLabel(":");
        Semi3.setFont(new Font("Book Antique",Font.BOLD,20));
        Semi3.setBounds(200,210,150,30);

        JLabel Semi4 = new JLabel(":");
        Semi4.setFont(new Font("Book Antique",Font.BOLD,20));
        Semi4.setBounds(200,290,150,30);

        JLabel Semi5 = new JLabel(":");
        Semi5.setFont(new Font("Book Antique",Font.BOLD,20));
        Semi5.setBounds(200,370,150,30);

        //Student Detail Labels

        JLabel SRegNo = new JLabel(StudentDetailsDashboard.RegNo);
        SRegNo.setFont(new Font("Book Antique",Font.BOLD,20));
        SRegNo.setBounds(230,50,150,30);
        SRegNo.setForeground(Color.BLUE);

        JLabel SName = new JLabel(StudentDetailsDashboard.Name);
        SName.setFont(new Font("Book Antique",Font.BOLD,20));
        SName.setBounds(230,130,150,30);
        SName.setForeground(Color.BLUE);

        JLabel SRoomNo = new JLabel(StudentDetailsDashboard.roomNo);
        SRoomNo.setFont(new Font("Book Antique",Font.BOLD,20));
        SRoomNo.setBounds(230,210,150,30);
        SRoomNo.setForeground(Color.BLUE);

        JLabel SPhoneNo = new JLabel(StudentDetailsDashboard.PhoneNo);
        SPhoneNo.setFont(new Font("Book Antique",Font.BOLD,20));
        SPhoneNo.setBounds(230,290,150,30);
        SPhoneNo.setForeground(Color.BLUE);

        JLabel Scity = new JLabel(StudentDetailsDashboard.city);
        Scity.setFont(new Font("Book Antique",Font.BOLD,20));
        Scity.setBounds(230,370,150,30);
        Scity.setForeground(Color.BLUE);



        add(RegNo);
        add(Name);
        add(RoomNo);
        add(PhoneNo);
        add(city);

        add(Semi1);
        add(Semi2);
        add(Semi3);
        add(Semi4);
        add(Semi5);

        add(SRegNo);
        add(SName);
        add(SRoomNo);
        add(SPhoneNo);
        add(Scity);


        setTitle("Student Details");
        setSize(500,500);
        setLocation(400,100);
        setBackground(Color.GRAY);
        setForeground(Color.BLACK);
        setResizable(false);
        setVisible(true);

        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }
}
