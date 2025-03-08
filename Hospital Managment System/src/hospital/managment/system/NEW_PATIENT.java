package hospital.managment.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class NEW_PATIENT extends JFrame implements ActionListener {

    JTextField textFieldNumber, textName, textFieldDisease, textFieldDeposite;
    JRadioButton r1, r2;

    Choice c1;

    JComboBox comboBox;

    JLabel date;
    JButton b1, b2;


    NEW_PATIENT() {

        JPanel panel = new JPanel();
        panel.setBounds(10, 10, 840, 540);
        panel.setBackground(new Color(90, 156, 163));    //creating a panel
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/patient.png"));
        Image image = imageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon icon = new ImageIcon(image);
        JLabel label = new JLabel(icon);
        label.setBounds(550, 150, 200, 200);
        panel.add(label);               //addd image to panel


        JLabel labelName = new JLabel("NEW PATIENT FORM");
        labelName.setBounds(118, 11, 260, 53);
        labelName.setFont(new Font("Tahoma", Font.BOLD, 20));
        panel.add(labelName);             //create heading new patient


        JLabel labelID = new JLabel("ID :");
        labelID.setBounds(35, 76, 200, 14);
        labelID.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelID.setForeground(Color.white);
        panel.add(labelID);             // label for id

        comboBox = new JComboBox(new String[]{"Aadhar Card", "Voter Id", "Driving License"});
        comboBox.setBounds(271, 73, 150, 20);         //dropdown
        comboBox.setBackground(new Color(3, 45, 48));
        comboBox.setForeground(Color.white);
        comboBox.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(comboBox);     // drop down for label


        JLabel labelNumber = new JLabel("Number :");
        labelNumber.setBounds(35, 111, 200, 14);
        labelNumber.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelNumber.setForeground(Color.white);
        panel.add(labelNumber);     //Number


        textFieldNumber = new JTextField();
        textFieldNumber.setBounds(271, 111, 150, 20);
        panel.add(textFieldNumber);        // text field for number


        JLabel labelName1 = new JLabel("Name :");
        labelName1.setBounds(35, 151, 200, 14);
        labelName1.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelName1.setForeground(Color.white);
        panel.add(labelName1);   //name label


        textName = new JTextField();
        textName.setBounds(271, 151, 150, 20);
        panel.add(textName);       //name textfield


        JLabel labelGender = new JLabel("Gender :");
        labelGender.setBounds(35, 191, 200, 14);
        labelGender.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelGender.setForeground(Color.white);
        panel.add(labelGender);       //gender label


        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Tahoma", Font.BOLD, 14));
        r1.setForeground(Color.white);
        r1.setBackground(new Color(109, 164, 170));
        r1.setBounds(271, 191, 80, 15);
        panel.add(r1);                //radio btn for male and female

        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Tahoma", Font.BOLD, 14));
        r2.setForeground(Color.white);
        r2.setBackground(new Color(109, 164, 170));
        r2.setBounds(350, 191, 80, 15);
        panel.add(r2);


        JLabel labelDisease = new JLabel("Disease :");
        labelDisease.setBounds(35, 231, 200, 14);
        labelDisease.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelDisease.setForeground(Color.white);
        panel.add(labelDisease);    //Disease label


        textFieldDisease = new JTextField();
        textFieldDisease.setBounds(271, 231, 150, 20);
        panel.add(textFieldDisease);     //txt field for disease

        JLabel labelRoom = new JLabel("Room :");
        labelRoom.setBounds(35, 274, 200, 14);
        labelRoom.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelRoom.setForeground(Color.white);
        panel.add(labelRoom);   //label for room

        // Room Choice  //

        c1 = new Choice();
        try {
            conn c = new conn();    //getting all room no from room table in dbs
            ResultSet resultSet = c.statement.executeQuery("select * from room ");
            while (resultSet.next()) {
                c1.add(resultSet.getString("room_no"));
            }

        } catch (Exception e) {

            e.printStackTrace();

        }
                                     //drop-down from room
        c1.setBounds(271, 274, 150, 20);
        c1.setForeground(Color.white);
        c1.setFont(new Font("Tahoma", Font.BOLD, 14));
        c1.setBackground(new Color(3, 45, 48));
        panel.add(c1);

        JLabel labelDate = new JLabel("Time :");
        labelDate.setBounds(35, 316, 200, 14);
        labelDate.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelDate.setForeground(Color.white);
        panel.add(labelDate);        //label for date


        Date date1 = new Date();          //getting current date time

        date = new JLabel("" + date1);
        date.setBounds(271, 316, 250, 14);
        date.setForeground(Color.white);
        date.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(date);


        JLabel labelDeposite = new JLabel("Deposite :");
        labelDeposite.setBounds(35, 359, 200, 14);
        labelDeposite.setFont(new Font("Tahoma", Font.BOLD, 17));
        labelDeposite.setForeground(Color.white);
        panel.add(labelDeposite);       //deposite label


        textFieldDeposite = new JTextField();
        textFieldDeposite.setBounds(271, 359, 150, 20);
        panel.add(textFieldDeposite);         //deposite txt field


        b1 = new JButton("ADD");
        b1.setBounds(100, 430, 120, 30);
        b1.setForeground(Color.white);                //ADD btn
        b1.setBackground(Color.BLACK);
        b1.addActionListener(this);
        panel.add(b1);


        b2 = new JButton("Back");
        b2.setBounds(260, 430, 120, 30);
        b2.setForeground(Color.white);                      //Back btn
        b2.setBackground(Color.BLACK);
        b2.addActionListener(this);
        panel.add(b2);


        setUndecorated(true);
        setSize(850, 550);
        setLayout(null);
        setVisible(true);
        setLocation(300, 250);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {     //if b1 - add is clicked
            conn c = new conn();
            String radioBTN = null;
            if (r1.isSelected()) {        //male radio btn is selected
                radioBTN = "Male";
            } else if (r2.isSelected()) {
                radioBTN = "Female";
            }

            String s1 = (String) comboBox.getSelectedItem();
            String s2 = textFieldNumber.getText();
            String s3 = textName.getText();
            String s4 = radioBTN;
            String s5 = textFieldDisease.getText();
            String s6 = c1.getSelectedItem();
            String s7 = date.getText();
            String s8 = textFieldDeposite.getText();


            try {      //insert record in dbs
                String q = "Insert into Patient_Info values('" + s1 + "','" + s2 + "','" + s3 + "','" + s4 + "','" + s5 + "','" + s6 + "','" + s7 + "','" + s8 + "')";
                String q1 = "Update Room set Avalibility= 'Occupied' where room_no=" + s6;
               //update patient room status

                c.statement.executeUpdate(q);
                c.statement.executeUpdate(q1);
      //pop up
                 JOptionPane.showMessageDialog(null, "Added Succesfully");
                setVisible(false);
            } catch (Exception E) {

                E.printStackTrace();
            }


        } else {    //back
            setVisible(false);

        }
    }


    public static void main(String[] args) {

        new NEW_PATIENT();


    }
}