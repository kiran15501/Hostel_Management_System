package student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HistoryDashboard extends JFrame {
    JButton Outpass,Complain;

    HistoryDashboard()
    {
        setLayout(null);

        Outpass=new JButton("Outpass");
        Outpass.setFont(new Font("Book Antique",Font.BOLD,20));
        Outpass.setBackground(Color.orange);
        Outpass.setForeground(Color.BLACK);
        Outpass.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Outpass.setBounds(80,70,130,30);

        Complain=new JButton("Complain");
        Complain.setFont(new Font("Book Antique",Font.BOLD,20));
        Complain.setBackground(Color.orange);
        Complain.setForeground(Color.BLACK);
        Complain.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Complain.setBounds(300,70,130,30);

        add(Outpass);
        add(Complain);

        setTitle("History");
        setLocation(700,400);
        setSize(500,200);
        setBackground(Color.GRAY);
        setForeground(Color.BLACK);
        setResizable(false);
        setVisible(true);

        Outpass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	new OutpassHistory();
            }
        });

        Complain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	new ComplaintHistory();
            }
        });


        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }
}
