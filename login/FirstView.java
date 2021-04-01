package login;

import javax.swing.*;

import admin.AdminLogin;
import student.StudentLogin;

import java.awt.*;
import java.awt.event.*;

public class FirstView extends JFrame{
    JFrame f;
    JButton studentLogin,adminLogin;

    public FirstView()
    {
        setLayout(null);

        studentLogin=new JButton("Student Login");
        studentLogin.setFont(new Font("Book Antique",Font.BOLD,20));
        studentLogin.setBackground(Color.orange);
        studentLogin.setForeground(Color.BLACK);
        studentLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
        studentLogin.setBounds(60,70,200,30);

        adminLogin=new JButton("Admin Login");
        adminLogin.setFont(new Font("Book Antique",Font.BOLD,20));
        adminLogin.setBackground(Color.orange);
        adminLogin.setForeground(Color.BLACK);
        adminLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
        adminLogin.setBounds(300,70,200,30);

        add(studentLogin);
        add(adminLogin);

        setTitle("Login First View");
        setLocation(300,200);
        setSize(550,200);
        setBackground(Color.GRAY);
        setForeground(Color.BLACK);
        setResizable(false);
        setVisible(true);

        studentLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                StudentLogin.studentLogin();
            }
        });

       adminLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                AdminLogin.adminLogin();
            }
        });

    }
    
}

