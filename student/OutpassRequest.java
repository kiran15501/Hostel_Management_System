package student;

import javax.swing.*;

import connect.Database;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class OutpassRequest extends JFrame {
    OutpassRequest()
    {
        JLabel txt = new JLabel("Enter your outpass reason :");
        txt.setBounds(25,15,480,30);
        txt.setFont(new Font("Book Antique",Font.BOLD,18));

        JPanel panel =new JPanel(new FlowLayout());
        panel.setBounds(25,40,480,190);


        JTextArea tf=new JTextArea(6,25);
        tf.setFont(new Font("Book Antique",Font.BOLD,20));
        tf.setForeground(Color.blue);
        tf.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.black));
        JScrollPane scroll=new JScrollPane(tf,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        tf.setCaretColor(Color.black);
        tf.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        add(panel);

        panel.add(scroll);
        add(txt);

        JButton Registerbtn=new JButton("Request Outpass");
        Registerbtn.setBackground(Color.orange);
        Registerbtn.setForeground(Color.BLACK);
        Registerbtn.setBounds(185,245,140,30);
        Registerbtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(Registerbtn);
        Registerbtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JLabel l1 =new JLabel();
                l1.setBounds(125,255, 300,40);
                l1.setFont(new Font("Book Antique",Font.BOLD,18));
                l1.setForeground(Color.orange);
                String content = tf.getText();
                LocalDateTime tym= LocalDateTime.now();
                DateTimeFormatter tymfor = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String time = tym.format(tymfor);


                if (tf.getText().isEmpty())
                {

                    l1.setText("No Reason Typed");
                    JOptionPane.showMessageDialog(panel,l1);}

                else {
                    int result = JOptionPane.showConfirmDialog(panel,"Are you sure..?", "Confirmation",JOptionPane.YES_NO_OPTION);
                    if(result == JOptionPane.YES_OPTION) {
                        tf.setText(" ");
                        try {
                            Connection connection = Database.getConnection();
                            PreparedStatement s = connection.prepareStatement("insert into Outpass (RegisterNo,Reason,DateAndTime,status,department) values (?,?,?,?,?)");
                            s.setString(1, StudentLogin.s.userName);
                            s.setString(2, content);
                            s.setString(3, time);
                            s.setInt(4,2);
                            s.setString(5, StudentLogin.s.department);
                            s.executeUpdate();
                            l1.setText("Outpass requested successfully...!!!");
                            JOptionPane.showMessageDialog(panel, l1);
                            dispose();
                            new StudentLogin();
                        } catch (SQLException sqlException) {
                            sqlException.printStackTrace();
                        }
                    }
                    else{
                        dispose();
                        new OutpassRequest();
                    }

                }

            }
        });

        setSize(535, 330);        //setting size.
        setTitle("Student Outpass");  //setting title.
        setLocation(700,300);
        setBackground(Color.GRAY);
        setLayout(null);	 //set default layout for frame.
        setVisible(true);           //set frame visibilty true.
        setResizable(false);
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e) {
                dispose();
                new StudentLogin();
            }
        });
    }

}
