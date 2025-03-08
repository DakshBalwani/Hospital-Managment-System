package hospital.managment.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Search extends JFrame {

    Choice choice;
    JTable table;

    Search(){


        JPanel panel=new JPanel();
        panel.setBounds(5,5,690,490);
        panel.setLayout(null);
        panel.setBackground(new Color(90,156,163));
        add(panel);

        JLabel label1 =new JLabel("Search For Room");
        label1.setBounds(250,11,186,31);
        label1.setForeground(Color.white);
        label1.setFont(new Font("Tahoma",Font.BOLD,20));
        panel.add(label1);

        JLabel label2 =new JLabel("Status :");
        label2.setBounds(70,70,80,20);
        label2.setForeground(Color.white);
        label2.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label2);

        choice=new Choice();
        choice.setBounds(170,70,120,20);
        choice.add("Availabil");
        choice.add("Occupied");
        panel.add(choice);

        table=new JTable();
        table.setBounds(0,187,700,210);
        table.setBackground(new Color(90,156,163));
        table.setForeground(Color.white);
        panel.add(table);

         try{
             conn c =new conn();
             String q="select * from Room";
             ResultSet resultSet = c.statement.executeQuery(q);
             table.setModel(DbUtils.resultSetToTableModel(resultSet));
         }
           catch (Exception e){
             e.printStackTrace();
           }


        JLabel label3 =new JLabel("Room Number");
        label3.setBounds(23,162,150,20);
        label3.setForeground(Color.white);
        label3.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label3);

        JLabel label4 =new JLabel("Availability");
        label4.setBounds(175,162,150,20);
        label4.setForeground(Color.white);
        label4.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label4);

        JLabel label5 =new JLabel("Price");
        label5.setBounds(458,162,150,20);
        label5.setForeground(Color.white);
        label5.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label5);

        JLabel label6 =new JLabel("Bed Type");
        label6.setBounds(588,162,150,20);
        label6.setForeground(Color.white);
        label6.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label6);

        JButton search =new JButton("Search");
        search.setBounds(200,420,120,25);
        search.setForeground(Color.white);
        search.setBackground(Color.black);
        panel.add(search);
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String q="select * from Room where Avalibility = '"+choice.getSelectedItem()+"' ";

                try {
                    conn c =new conn();
                    ResultSet resultSet =c.statement.executeQuery(q);
                    table.setModel(DbUtils.resultSetToTableModel(resultSet));
                }
                catch (Exception E){
                    E.printStackTrace();
                }

            }
        });


        JButton back =new JButton("Back");
        back.setBounds(380,420,120,25);
        back.setForeground(Color.white);
        back.setBackground(Color.black);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });






        setUndecorated(true);
        setSize(700,500);
        setLayout(null);
        setLocation(450,250);
        setVisible(true);


    }

    public static void main(String[] args) {

        new Search();










    }
}
