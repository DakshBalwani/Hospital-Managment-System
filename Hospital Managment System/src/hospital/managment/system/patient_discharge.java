package hospital.managment.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class patient_discharge extends JFrame {


    patient_discharge(){


        JPanel panel =new JPanel();
        panel.setBounds(5,5,790,390);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        add(panel);


       JLabel label1=new JLabel("Check-Out");
       label1.setFont(new Font("Tahoma",Font.BOLD,20));
       label1.setBounds(100,20,150,20);
        label1.setForeground(Color.white);
        panel.add(label1);


        JLabel label2=new JLabel("Customer Id");
        label2.setFont(new Font("Tahoma",Font.BOLD,14));
        label2.setBounds(30,80,150,20);
        label2.setForeground(Color.white);
        panel.add(label2);

          //drop-down
        Choice choice=new Choice();
        choice.setBounds(200,80,150,25);
        panel.add(choice);


        try{
            conn c=new conn();
            ResultSet resultSet=c.statement.executeQuery("select * from patient_info");
            //geeting data from patient table

            while(resultSet.next()){        //data.next till we get data
                choice.add(resultSet.getString("number"));
                //adding to choice from number col in patient info
            }


        }
        catch(Exception e){
            e.printStackTrace();
        }



        JLabel label3=new JLabel("Room Number");
        label3.setFont(new Font("Tahoma",Font.BOLD,14));
        label3.setBounds(30,130,150,20);
        label3.setForeground(Color.white);
        panel.add(label3);


        JLabel RNo=new JLabel("");
        RNo.setFont(new Font("Tahoma",Font.BOLD,14));
        RNo.setBounds(200,130,150,20);
        RNo.setForeground(Color.white);
        panel.add(RNo);

            //time when patient admited
        JLabel label4=new JLabel("In Time");
        label4.setFont(new Font("Tahoma",Font.BOLD,14));
        label4.setBounds(30,180,150,20);
        label4.setForeground(Color.white);
        panel.add(label4);


        JLabel INTime=new JLabel();
        INTime.setFont(new Font("Tahoma",Font.BOLD,14));
        INTime.setBounds(200,180,250,20);
        INTime.setForeground(Color.white);
        panel.add(INTime);

        //time of discharge
        JLabel label5=new JLabel("Out Time");
        label5.setFont(new Font("Tahoma",Font.BOLD,14));
        label5.setBounds(30,230,150,20);
        label5.setForeground(Color.white);
        panel.add(label5);


        //curr date
        Date date=new Date();

        JLabel OUTTime=new JLabel(""+date);
        OUTTime.setFont(new Font("Tahoma",Font.BOLD,14));
        OUTTime.setBounds(200,230,250,20);
        OUTTime.setForeground(Color.white);
        panel.add(OUTTime);



        JButton discharge=new JButton("Discharge");
        discharge.setBounds(30,300,120,30);
        discharge.setBackground(Color.BLACK);
        discharge.setForeground(Color.white);
        panel.add(discharge);
        discharge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                conn c=new conn();
                try {
                    c.statement.executeUpdate("delete from patient_info where number='" + choice.getSelectedItem() + "'");
                    c.statement.executeUpdate("update Room set Avalibility = 'Available' where room_no= '"+RNo.getText()+"'");
                   //after patient discharge  delete its info in patient info table
                    // acc to room no change availabity=available as patient gonee
                    JOptionPane.showMessageDialog(null,"Done");
                    setVisible(false);
                }
                catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton check=new JButton("Check");
        check.setBounds(170,300,120,30);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.white);
        panel.add(check);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conn c=new conn();
                try{

                    ResultSet resultSet=c.statement.executeQuery("select * from patient_info where number='"+choice.getSelectedItem()+"'");
                    while(resultSet.next())
                {
                        RNo.setText(resultSet.getString("Room_Number"));
                        INTime.setText(resultSet.getString("Time"));
                    }
                    //here we can acces which acces room no and in time through choice of customer id

                }
                catch(Exception E){
                    E.printStackTrace();
                }


            }
        });




        JButton back=new JButton("Back");
        back.setBounds(300,300,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });













        setSize(800,400);
        setLocation(400,250);
        setVisible(true);
        setLayout(null);


    }

    public static void main(String[] args) {

    new patient_discharge();



    }

}
