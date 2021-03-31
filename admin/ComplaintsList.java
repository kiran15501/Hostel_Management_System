package admin;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ComplaintsList extends JFrame implements ActionListener {
	
	JButton[] b;
	JLabel l;
	
	ComplaintsList(int n) {
		setLayout(null);
		setBounds(100, 100, 500, 500);
		setTitle("Unchecked Complaints");
		l = new JLabel();
		l.setBounds(190, 20, 200, 20);
		l.setFont(new Font("Book Antique",Font.BOLD,16));
		add(l);
		
		if(n!=0) {		
				l.setText("New Complaints");
				b = new JButton[n];
				int j = 0;
				for (int i = 0; i < b.length; i++) {
					if(i%4 == 0) j++;
					b[i] = new JButton(String.valueOf(i+1));
					b[i].setFont(new Font("Book Antique",Font.BOLD,12));
			        b[i].setBackground(Color.orange);
			        b[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
					b[i].addActionListener(this);
					b[i].setBounds(90*(i%4+1), 60*j,55 , 25);
					add(b[i]);
				}
		}
		else {
			l.setText("No New Complaints !");
		}
		
		setResizable(false);
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Complaint.describeComplaint(Integer.parseInt(e.getActionCommand())-1);
		dispose();
	}
	
}

