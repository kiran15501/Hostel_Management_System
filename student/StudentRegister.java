package student;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.*;
import javax.swing.*;

import admin.AdminLogin;
import admin.AdminRegister;
import connect.Database;

public class StudentRegister {
	JFrame f;
    JLabel topic;
    JLabel name;
    JLabel register_no;
    JLabel email_id;
    JLabel department;
    JLabel phone_number;
    JLabel city;
    JLabel food_prefered;
    JLabel password;
    JLabel comfirm_password;
    JLabel already_registered;
    
    JTextField name_field;
    JTextField register_no_field;
    JTextField email_id_field;
    JTextField phone_number_field;
    JTextField city_field;
    JPasswordField password_field;
    JPasswordField comfirm_password_field;
    JRadioButton veg,non_veg;
    JComboBox<String> department_combo_box;
    JButton submit;
    JButton clear;
    JButton login;
    String department_name[]={"-select-","CSE","IT","ECE","EEE","MECH","MCT","CIVIL","CSBS (TCS)","M.TECH (VIRTUSA)"};
    
    
   StudentRegister()
   {
       f =new JFrame();
       topic=new JLabel("Students Registration Form");
       name=new JLabel("Name");
       register_no=new JLabel("Register No");
       email_id=new JLabel("Email Id");
       department=new JLabel("Department");
       phone_number=new JLabel("Phone Number");
       city=new JLabel("city");
       food_prefered=new JLabel("Food Prefered");
       password=new JLabel("Password");
       comfirm_password=new JLabel("Comfirm Password");
       already_registered=new JLabel("If you have registered already then login");
       
       
       name_field=new JTextField(20);
       register_no_field=new JTextField(20);
       email_id_field=new JTextField(20);
       phone_number_field=new JTextField(20);
       city_field=new JTextField();
       password_field=new JPasswordField(20);
       comfirm_password_field=new JPasswordField(20);
       
       veg=new JRadioButton("Veg");
       non_veg=new JRadioButton("Non Veg");
       ButtonGroup bg=new ButtonGroup();
       bg.add(veg);
       bg.add(non_veg);
       
       department_combo_box=new JComboBox(department_name);
       
       submit=new JButton("Submit");
       clear=new JButton("Clear");
       login=new JButton("Login");
       
       
       topic.setBounds(100,15,500,45);
       name.setBounds(50,70,300,20);
       register_no.setBounds(50,130,400,30);
       email_id.setBounds(50,190,300,30);
       department.setBounds(50, 250,300,30);
       phone_number.setBounds(50,310,300,30);
       city.setBounds(50,380,290,30);
       food_prefered.setBounds(50,460,300,30);
       password.setBounds(50,520 ,300,30);
       comfirm_password.setBounds(50,580,300,30);
       
       name_field.setBounds(300,70,300,40);
       register_no_field.setBounds(300,130,300,40);
       email_id_field.setBounds(300,190,300,40);
       phone_number_field.setBounds(300,310,300,40);
       city_field.setBounds(300,370,300,40);
       password_field.setBounds(300,520,300, 40);
       comfirm_password_field.setBounds(300,580,300,40);
       already_registered.setBounds(125,700,300,20);
       
       veg.setBounds(310,460,150,30);
       non_veg.setBounds(460,460,150,30);
       
       department_combo_box.setBounds(300,250,300,40);
       
       submit.setBounds(330,640,200,40);
       clear.setBounds(100,640 ,200,40);
       login.setBounds(405, 700,100,20);
       
       
       topic.setFont(new Font("Book Antique",Font.BOLD,30));
       name.setFont(new Font("Book Antique",Font.ITALIC,20));
       register_no.setFont(new Font("Book Antique",Font.ITALIC,20));
       email_id.setFont(new Font("Book Antique",Font.ITALIC,20));
       department.setFont(new Font("Book Antique",Font.ITALIC,20));
       phone_number.setFont(new Font("Book Antique",Font.ITALIC,20));
       city.setFont(new Font("Book Antique",Font.ITALIC,20));
       food_prefered.setFont(new Font("Book Antique",Font.ITALIC,20));
       password.setFont(new Font("Book Antique",Font.ITALIC,20));
       comfirm_password.setFont(new Font("Book Antique",Font.ITALIC,20));
       veg.setFont(new Font("Book Antique",Font.ITALIC,20));
       non_veg.setFont(new Font("Book Antique",Font.ITALIC,20));
       already_registered.setFont(new Font("Book Antique",Font.ITALIC,15));
       
       
       f.add(topic);
       f.add(name);
       f.add(register_no);
       f.add(email_id);
       f.add(department);
       f.add(phone_number);
       f.add(city);
       f.add(food_prefered);
       f.add(password);
       f.add(comfirm_password);
       f.add(already_registered);
       
       f.add(name_field);
       f.add(register_no_field);
       f.add(email_id_field);
       f.add(phone_number_field);
       f.add(city_field);
       f.add(password_field);
       f.add(comfirm_password_field);
       
       f.add(veg);
       f.add(non_veg);
       
       f.add(department_combo_box);
       
       f.add(submit);
       f.add(clear);
       f.add(login);
       
       login.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			f.dispose();
			AdminLogin.adminLogin();
			
		}
	});
       
       clear.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               name_field.setText(null);
               register_no_field.setText(null);
               email_id_field.setText(null);
               phone_number_field.setText(null);
               city_field.setText(null);
               password_field.setText(null);
               comfirm_password_field.setText(null);
               
           }
       });
       
       submit.addActionListener(new ActionListener() {
           
           @Override
           public void actionPerformed(ActionEvent e) {
        	   
        	   String food_prefered = "";               
               String name=name_field.getText();
               String register_no=register_no_field.getText();
               String email_id=email_id_field.getText();
               String department=department_combo_box.getItemAt(department_combo_box.getSelectedIndex());
               String phone_number = phone_number_field.getText();
               String city=city_field.getText();
               if(veg.isSelected())
               {
                   food_prefered="veg";
               }
               if(non_veg.isSelected())
               {
                   food_prefered="non veg";
               }
               String password=password_field.getText();
               String comfirm_password=comfirm_password_field.getText();
               if(name.isEmpty() || register_no.isEmpty() || email_id.isEmpty() || department.equals("-select-") || phone_number.isEmpty() || city.isEmpty() ||
            		   password.isEmpty() || comfirm_password.isEmpty() || food_prefered.isEmpty()) {
            	   JOptionPane.showMessageDialog(submit, "Fill all fields properly !");
               }
               else {
	               
	               
	               if(comfirm_password.equals(password)) {
	                   
		               if(Pattern.matches("[0-9]{2}[\\w]{7}$",register_no))
		               {
		                   if(Pattern.matches("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$",email_id)){
		                       
		                       if(Pattern.matches("[6789]{1}[0-9]{9}",phone_number)){
		                           
		                           if(Pattern.matches("^.{8,15}$", password))
		                           {
		                               
		                                       
		                               try {
		                               
			                               Connection con=Database.getConnection();
			                               PreparedStatement st=con.prepareStatement("SELECT RegisterNo from hostelstudents where  RegisterNo=?");
			                               st.setString(1,register_no);
			                               ResultSet rs=st.executeQuery();
			                               if(rs.next()){
			                                   JOptionPane.showMessageDialog(submit,"Already registered");
			                               }
			                               
			                               else {
			                            	   
			                            	   st = con.prepareStatement("select hosteller from collegestudents where RegisterNo=?");
			                            	   st.setString(1, register_no);
			                            	   rs = st.executeQuery();
			                            	   if(rs.next()) {
			                            		   if(rs.getBoolean(1)) {
			
			                            			   PreparedStatement stmt=con.prepareStatement("INSERT INTO  hostelstudents (Name,RegisterNo,Email,Department,Phone,city,Password,food_preferd)VALUES(?,?,?,?,?,?,?,?)");
						                               stmt.setString(1, name);
						                               stmt.setString(2,register_no);
						                               stmt.setString(3,email_id );
						                               stmt.setString(4,department);
						                               stmt.setString(5,phone_number );
						                               stmt.setString(6,city);
						                               stmt.setString(7, password);
						                               stmt.setString(8,food_prefered);
						                               stmt.executeUpdate();
						                               JOptionPane.showMessageDialog(submit,"Student Registered Successfully !");
						                               f.dispose();
						                               StudentLogin.studentLogin();
			                               
			                            		   }
				                            	   else {
				                            		   JOptionPane.showMessageDialog(submit,"You are not a Hosteller !");
				                            	   }
			                            	   } 
			                            	   else {
			                            		   JOptionPane.showMessageDialog(submit,"Invalid student !");
			                            	   }
			                               }
		                               } catch (Exception ex) {
		                            	   System.out.println(ex);
		                               }
		                           }
		                           else{
		                               JOptionPane.showMessageDialog(submit,  "Password must contain only 8-15 characters");
		                           }
		                       }
		                       else{
		                           JOptionPane.showMessageDialog(submit,  "Enter a valid Phone number !");
		                       }
		                   }
		                   else{
		                       JOptionPane.showMessageDialog(submit,  "Enter a valid Email ID !");
		                   }
		               }
		               else{ 
		                   JOptionPane.showMessageDialog(submit,"Enter a valid Register number !");
		               }
	               }
	               else{
	                   JOptionPane.showMessageDialog(submit,"password and Comfirm Password or not equal");
	               }
               }
           }
       });     
       
       f.setTitle("Students Registration Form");    
       f.setLayout(null);
       f.setVisible(true);
       f.setBounds(500,0,670,800);
   }
  

	public static void studentRegister(){
		new StudentRegister();
	}
	
}
