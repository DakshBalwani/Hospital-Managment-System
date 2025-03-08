package hospital.managment.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JTextField textField;
   JPasswordField jPasswordField;
   JButton b1;
   JButton b2;

    Login(){

//namelbl
        JLabel namelabel =new JLabel("Username");
        namelabel.setBounds(40,20,100,30);
        namelabel.setFont(new Font("Tahoma",Font.BOLD,16));
        namelabel.setForeground(Color.BLACK);
        add(namelabel);

//passlbl
        JLabel password =new JLabel("Password");
        password.setBounds(40,70,100,30);
        password.setFont(new Font("Tohoma",Font.BOLD,16));
        password.setForeground(Color.BLACK);
        add(password);

//txtfield
        textField =new JTextField();
        textField.setBounds(150,20,150,30);
        textField.setFont(new Font("Tahoma",Font.PLAIN,15));
        textField.setBackground(new Color(255,179,0));
        add(textField);


//passfield
        jPasswordField =new JPasswordField();
        jPasswordField.setBounds(150,70,150,30);
        jPasswordField.setFont(new Font("Tahoma",Font.PLAIN,15));
        jPasswordField.setBackground(new Color(255,179,0));
        add(jPasswordField);

//iconimage
        ImageIcon icon= new ImageIcon(ClassLoader.getSystemResource("icons/city_hospital_3.jpg"));
        Image i1=icon.getImage().getScaledInstance(500,500,Image.SCALE_DEFAULT);
        ImageIcon icon1=new ImageIcon(i1);
        JLabel label=new JLabel(icon1);
        label.setBounds(320,-30,400,400);
        add(label);

//btn1
        b1 =new JButton("Login");
        b1.setBounds(40,140,120,30);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        add(b1);


//btn2
        b2 =new JButton("Cancel");
        b2.setBounds(180,140,120,30);
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        add(b2);




//frame
        setSize(700,300);
        setLocation(400,270);
        setLayout(null);
        setVisible(true);

        getContentPane().setBackground(new Color(109,164,170));


    }


    public  static  void main(String[] args){

        Login l1 =new Login();



    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
            try{
                conn c =new conn();
                String user =textField.getText();      //user entered id pass
                String pass =jPasswordField.getText();

                String q="select * from login where id='"+user+"' and pw='"+pass+"'";
                ResultSet resultSet = c.statement.executeQuery(q);

                if (resultSet.next()){  //if matches with db
                    new Reception();
                    setVisible(false);
                }

                else{      //if id pass not matches invalid pop up
                    JOptionPane.showMessageDialog(null,"Invalid");
                }

            }

            catch(Exception E){
                E.printStackTrace();
            }

        }
        else{
      System.exit(10);      //for close btn2
        }

    }
}
