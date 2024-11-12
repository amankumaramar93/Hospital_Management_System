package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.Date;

public class NewPatient extends JFrame
{
    JComboBox comboBox;
    JTextField textNumber, textName, textDiseas, textDeposite;
    JRadioButton r1,r2,r3;
    Choice c1;
    JLabel date1;
    JButton button1,button2;

    NewPatient()
    {
        JPanel panel = new JPanel();
        panel.setBounds(5,5,840,540);
        panel.setBackground(new Color(90, 156, 163));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("Icons/patient.png"));
        Image image = imageIcon.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(550,150,200,200);
        panel.add(label);

        JLabel labelHeading = new JLabel("New Patient Form");
        labelHeading.setBounds(118,11,260,53);
        labelHeading.setFont(new Font("Tahoma", Font.BOLD,20));
        panel.add(labelHeading);

        JLabel labelId = new JLabel("ID : ");
        labelId.setBounds(35,76,200,14);
        labelId.setFont(new Font("Tahoma", Font.BOLD,14));
        labelId.setForeground(Color.WHITE);
        panel.add(labelId);

        comboBox = new JComboBox(new String[] {"Aadhar Card","Voter Id","Driving License","Passport"});
        comboBox.setBounds(271,73,150,20);
        comboBox.setBackground(new Color(3,45,48));
        comboBox.setForeground(Color.WHITE);
        comboBox.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(comboBox);

        JLabel labelNumber = new JLabel("Number : ");
        labelNumber.setBounds(35,111,200,14);
        labelNumber.setFont(new Font("Tahoma", Font.BOLD,14));
        labelNumber.setForeground(Color.WHITE);
        panel.add(labelNumber);

        textNumber = new JTextField();
        textNumber.setBounds(271,111,150,20);
        textNumber.setBackground(new Color(3,45,48));
        textNumber.setForeground(Color.WHITE);
        textNumber.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(textNumber);

        JLabel labelName = new JLabel("Name : ");
        labelName.setBounds(35,151,200,14);
        labelName.setFont(new Font("Tahoma", Font.BOLD,14));
        labelName.setForeground(Color.WHITE);
        panel.add(labelName);

        textName = new JTextField();
        textName.setBounds(271,151,150,20);
        textName.setBackground(new Color(3,45,48));
        textName.setForeground(Color.WHITE);
        textName.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(textName);

        JLabel labelGender = new JLabel("Gender : ");
        labelGender.setBounds(35,191,200,14);
        labelGender.setFont(new Font("Tahoma", Font.BOLD,14));
        labelGender.setForeground(Color.WHITE);
        panel.add(labelGender);

        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Tahoma",Font.BOLD,14));
        r1.setForeground(Color.WHITE);
        r1.setBackground(new Color(109,164,170));
        r1.setBounds(271,191,80,15);
        panel.add(r1);

        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Tahoma",Font.BOLD,14));
        r2.setForeground(Color.WHITE);
        r2.setBackground(new Color(109,164,170));
        r2.setBounds(345,191,80,15);
        panel.add(r2);

        r3 = new JRadioButton("Other");
        r3.setFont(new Font("Tahoma",Font.BOLD,14));
        r3.setForeground(Color.WHITE);
        r3.setBackground(new Color(109,164,170));
        r3.setBounds(430,191,80,15);
        panel.add(r3);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(r1);
        buttonGroup.add(r2);
        buttonGroup.add(r3);

        JLabel labelDiseas = new JLabel("Diseas : ");
        labelDiseas.setBounds(35,231,200,14);
        labelDiseas.setFont(new Font("Tahoma", Font.BOLD,14));
        labelDiseas.setForeground(Color.WHITE);
        panel.add(labelDiseas);

        textDiseas = new JTextField();
        textDiseas.setBounds(271,231,150,20);
        textDiseas.setBackground(new Color(3,45,48));
        textDiseas.setForeground(Color.WHITE);
        textDiseas.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(textDiseas);

        JLabel labelRoom = new JLabel("Room : ");
        labelRoom.setBounds(35,274,200,14);
        labelRoom.setFont(new Font("Tahoma", Font.BOLD,14));
        labelRoom.setForeground(Color.WHITE);
        panel.add(labelRoom);

        c1 = new Choice();
        try
        {
            Conn conn = new Conn();
            ResultSet resultSet = conn.statement.executeQuery("select * from Room where availability = 'available'");
            while(resultSet.next())
            {
                c1.add(resultSet.getString("room_no"));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        c1.setBounds(271,274,150,20);
        panel.add(c1);


        JLabel labelDate = new JLabel("Time : ");
        labelDate.setBounds(35,316,200,14);
        labelDate.setFont(new Font("Tahoma", Font.BOLD,14));
        labelDate.setForeground(Color.WHITE);
        panel.add(labelDate);

        Date date = new Date();

        date1 = new JLabel(""+date);
        date1.setBounds(271,316,250,14);
        date1.setForeground(Color.WHITE);
        date1.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(date1);

        JLabel labelDeposite = new JLabel("Deposite : ");
        labelDeposite.setBounds(35,359,200,20);
        labelDeposite.setFont(new Font("Tahoma", Font.BOLD,14));
        labelDeposite.setForeground(Color.WHITE);
        panel.add(labelDeposite);

        textDeposite = new JTextField();
        textDeposite.setBounds(271,359,150,20);
        textDeposite.setBackground(new Color(3,45,48));
        textDeposite.setForeground(Color.WHITE);
        textDeposite.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(textDeposite);

        button1 = new JButton("ADD");
        button1.setBounds(120,430,120,30);
        button1.setForeground(Color.WHITE);
        button1.setBackground(Color.black);
        panel.add(button1);
        button1.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Conn conn = new Conn();
                String radioButton = null;
                if (r1.isSelected())
                {
                    radioButton = "Male";
                }
                else if(r2.isSelected())
                {
                    radioButton = "Female";
                }
                else if (r3.isSelected())
                {
                    radioButton = "Other";
                }

                String id = (String) comboBox.getSelectedItem();
                String idNumber = textNumber.getText();
                String name = textName.getText();
                String gender = radioButton;
                String diseas = textDiseas.getText();
                String roomNo = c1.getSelectedItem();
                String check_in_time = date1.getText();
                String check_out_time = null;
                String deposite = textDeposite.getText();

                if(idNumber.equals("") || name.equals("") || gender.equals(""))
                {
                    JOptionPane.showMessageDialog(null,"Fill all the Fields");
                }
                else
                {
                    try {
                        String query1 = "insert into patient_info values('" + id + "','" + idNumber + "','" + name + "','" + gender + "','" + diseas + "','" +
                                roomNo + "','" + check_in_time + "','" + deposite + "')";

                        String query2 = "update room set availability = 'Occupied' where room_no = " + roomNo;

                        String query3 = "insert into discharge_patient values('" + id + "','" + idNumber + "','" + name + "','" + gender + "','" + diseas + "','" +
                                roomNo + "','" + check_in_time + "','" + check_out_time + "','" + deposite + "')";


                        conn.statement.executeUpdate(query1);
                        conn.statement.executeUpdate(query3);
                        conn.statement.executeUpdate(query2);
                        new AdmitPayment(idNumber,name,gender,roomNo,deposite);
                        setVisible(false);
                        //JOptionPane.showMessageDialog(null, "Added Successfully");
                    } catch (Exception E) {
                        E.printStackTrace();
                    }
                }

            }
        });

        button2 = new JButton("Back");
        button2.setBounds(310,430,120,30);
        button2.setForeground(Color.WHITE);
        button2.setBackground(Color.black);
        panel.add(button2);
        button2.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                setVisible(false);
            }
        });


        setUndecorated(true);
        setSize(850,550);
        setLayout(null);
        setLocation(250,130);
        setVisible(true);
    }

    public static void main(String[] args)
    {
        new NewPatient();
    }
}
