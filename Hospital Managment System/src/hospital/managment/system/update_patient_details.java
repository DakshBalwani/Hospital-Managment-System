package hospital.managment.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class update_patient_details extends JFrame {

    update_patient_details(){

        JPanel panel=new JPanel();
        panel.setBounds(5,5,940,490);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        add(panel);

//update img
        ImageIcon imageIcon =new ImageIcon(ClassLoader.getSystemResource("icons/updated.png")) ;
        Image image = imageIcon.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1=new ImageIcon(image);
        JLabel label =new JLabel(imageIcon1);
        label.setBounds(500,60,300,300);
        panel.add(label);

        JLabel label1=new JLabel("Update Patient Details");
        label1.setBounds(124,11,260,25);
        label1.setForeground(Color.white);
        label1.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label1);

        JLabel label2=new JLabel("Name:");
        label2.setBounds(25,88,100,14);
        label2.setForeground(Color.white);
        label2.setFont(new Font("Tahoma",Font.PLAIN,14));
        panel.add(label2);

        Choice choice =new Choice();      //drop-down
        choice.setBounds(248,85,140,25);
        panel.add(choice);

        try{
            conn c =new conn();
            //name col in patient table in dbs
            ResultSet resultSet=c.statement.executeQuery("select * from patient_info ");

            while(resultSet.next()){
                choice.add(resultSet.getString("name"));
            }
            //gt data from name column
        }
       catch (Exception e){
            e.printStackTrace();
       }



        JLabel label3=new JLabel("Room Number :");
        label3.setBounds(25,129,140,14);
        label3.setForeground(Color.white);
        label3.setFont(new Font("Tahoma",Font.PLAIN,14));
        panel.add(label3);

        //txt field for room
        JTextField textFieldR =new JTextField();
        textFieldR.setBounds(248,129,140,20);
        panel.add(textFieldR);

        JLabel label4=new JLabel("In-Time :");
        label4.setBounds(25,174,100,20);
        label4.setForeground(Color.white);
        label4.setFont(new Font("Tahoma",Font.PLAIN,14));
        panel.add(label4);

        //txt field for in time
        JTextField Intime =new JTextField();
        Intime.setBounds(248,174,140,20);
        panel.add(Intime);

        JLabel label5=new JLabel("Amount-Paid (Rs):");
        label5.setBounds(25,216,150,20);
        label5.setForeground(Color.white);
        label5.setFont(new Font("Tahoma",Font.PLAIN,14));
        panel.add(label5);


          //txt field for amount paid
        JTextField AmtTxt =new JTextField();
        AmtTxt.setBounds(248,216,140,20);
        panel.add(AmtTxt);


        JLabel label6=new JLabel("Amount-Pending (Rs):");
        label6.setBounds(25,261,150,20);
        label6.setForeground(Color.white);
        label6.setFont(new Font("Tahoma",Font.PLAIN,14));
        panel.add(label6);

        //txt-field for amount pending
        JTextField AmtTxtPending =new JTextField();
        AmtTxtPending.setBounds(248,261,140,20);
        panel.add(AmtTxtPending);

      //btns here!!!

        //check btn
        JButton check =new JButton("CHECK");
        check.setBounds(281,378,89,23);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.white);
        panel.add(check);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id=choice.getSelectedItem();    //get selected item under choice drop-down
                String q=  "select * from patient_info where Name='"+id+"'";
                try{
                    conn c=new conn();
                    ResultSet resultSet=c.statement.executeQuery(q);  //execute name col query
                    while (resultSet.next()){
                        textFieldR.setText(resultSet.getString("Room_Number"));  //getting data from room_no col and store in textfieldr
                         Intime.setText(resultSet.getString("Time"));  //from time cpl
                        AmtTxt.setText(resultSet.getString("Deposite"));  //amt deposited

                    }

                    ResultSet resultSet1 =c.statement.executeQuery("select * from Room where room_no='"+textFieldR.getText()+"'");
                            //Acc to room number get its price as it varies acc to room in room table
                      while(resultSet1.next()){
                          String price =resultSet1.getString("Price");
                          //taken price of room user selected
                          int amtPaid = Integer.parseInt(price)-Integer.parseInt(AmtTxt.getText());
                                         //price  of bed           (minus) -           Deposited = AmtPending
                          AmtTxtPending.setText(""+amtPaid);
                      }
                }
                catch (Exception E){
                    E.printStackTrace();
                }

            }
        });


        JButton update =new JButton("UPDATE");
        update.setBounds(56,378,89,23);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.white);
        panel.add(update);
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    conn c=new conn();
                    String q= choice.getSelectedItem();       //getting data from all txt field and drop down
                    String room= textFieldR.getText();
                    String time =Intime.getText();
                    String amount =AmtTxt.getText();
                    c.statement.executeUpdate("update patient_info set Room_Number ='"+room+"', Time ='"+time+"', Deposite ='"+amount+"' where Name='"+q+"'");
                    //updating the table acc to given fields
                    //Acc to name update other fields

                    JOptionPane.showMessageDialog(null,"Updated Succesfully");
                    setVisible(false);
                }
                catch(Exception E){
                   E.printStackTrace();
                }
            }
        });


        JButton back =new JButton("BACK");
        back.setBounds(168,378,89,23);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });


        setUndecorated(true);
        setSize(950,500);
        setLayout(null);
        setLocation(400,250);
        setVisible(true);

    }

    public static void main(String[] args) {

        new update_patient_details();


    }
}
