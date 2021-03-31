package admin;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class OutpassButton extends JFrame implements ActionListener{
	JButton[] b;
	JLabel l1;
	OutpassButton(int n){
		if(n!=0) {
			l1 = new JLabel("OUTPASSES");
			add(l1);
			b = new JButton[n];
			int j = 0;
			for(int i=0;i<n;i++)
			{
				if(i%4 == 0) j++;
				b[i] = new JButton(String.valueOf(i+1));
				b[i].addActionListener(this);
				b[i].setBackground(Color.orange);
				b[i].setBounds(90*(i%4+1), 60*j,55 , 25);
				add(b[i]);
			}
		}
		else {
			l1 = new JLabel("No New Requests !");
		}
		l1.setFont(new Font(Font.SANS_SERIF,Font.BOLD,24));
		l1.setBounds(150, 0, 200, 50);
		setTitle("Unchecked Outpass Requests");
		setLayout(null);
		setBounds(100, 100, 500, 500);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	    Outpass.viewreason(Integer.parseInt(e.getActionCommand())-1);
	}
}