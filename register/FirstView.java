package register;

import javax.swing.*;

import admin.AdminRegister;
import student.StudentRegister;
import home.HomePage;

import java.awt.*;
import java.awt.event.*;

public class FirstView extends JFrame{
	JFrame f;
    JButton studentRegister,adminRegister;

    public FirstView()
    {
        setLayout(null);

        studentRegister=new JButton("Student Register");
        studentRegister.setFont(new Font("Book Antique",Font.BOLD,20));
        studentRegister.setBackground(Color.orange);
        studentRegister.setForeground(Color.BLACK);
        studentRegister.setCursor(new Cursor(Cursor.HAND_CURSOR));
        studentRegister.setBounds(60,70,200,30);

        adminRegister=new JButton("Admin Register");
        adminRegister.setFont(new Font("Book Antique",Font.BOLD,20));
        adminRegister.setBackground(Color.orange);
        adminRegister.setForeground(Color.BLACK);
        adminRegister.setCursor(new Cursor(Cursor.HAND_CURSOR));
        adminRegister.setBounds(300,70,200,30);

        add(studentRegister);
        add(adminRegister);

        setTitle("Register First View");
        setLocation(300,200);
        setSize(550,200);
        setBackground(Color.GRAY);
        setForeground(Color.BLACK);
        setResizable(false);
        setVisible(true);

        studentRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	dispose();
                StudentRegister.studentRegister();
            }
        });

       adminRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	dispose();
                AdminRegister.adminRegister();
            }
        });

    }

}
