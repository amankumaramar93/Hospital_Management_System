package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class UpdatePatientDetails extends JFrame
{
    JTextField textSearch,textAmount,textPendingAmount;

    UpdatePatientDetails()
    {
        JPanel panel = new JPanel();
        panel.setBounds(5,5,940,490);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/updated.png"));
        Image image = imageIcon.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(570,80,250,250);
        panel.add(label);

        JLabel labelHeading = new JLabel("Update Patient Details");
        labelHeading.setBounds(124,11,240,25);
        labelHeading.setFont(new Font("Tahoma",Font.BOLD,20));
        labelHeading.setForeground(Color.WHITE);
        panel.add(labelHeading);

        JLabel labelNumber = new JLabel("Number : ");
        labelNumber.setBounds(20,140,150,20);
        labelNumber.setForeground(Color.WHITE);
        panel.add(labelNumber);

        JTextField textNumber = new JTextField();
        textNumber.setBounds(248,140,150,20);
        panel.add(textNumber);

        JLabel labelRoomNo = new JLabel("Room Number : ");
        labelRoomNo.setBounds(20,180,150,20);
        labelRoomNo.setForeground(Color.WHITE);
        panel.add(labelRoomNo);

        JTextField textRoomNo = new JTextField();
        textRoomNo.setBounds(248,180,150,20);
        panel.add(textRoomNo);

        Choice choiceRoomNo = new Choice();
        choiceRoomNo.setBounds(405,180,100,20);
        panel.add(choiceRoomNo);

        try
        {
            Conn conn = new Conn();
            ResultSet resultSet = conn.statement.executeQuery("select * from Room where availability = 'available'");
            while(resultSet.next())
            {
                choiceRoomNo.add(resultSet.getString("room_no"));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        choiceRoomNo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Conn conn = new Conn();
                try
                {
                    conn.statement.executeUpdate("update room set availability = 'Available' where room_no = '"+textRoomNo.getText()+"'");
                }
                catch (Exception E)
                {
                    E.printStackTrace();
                }
                textRoomNo.setText(choiceRoomNo.getSelectedItem());
                try
                {
                    ResultSet resultSet1 = conn.statement.executeQuery("select * from room where room_no = '"+textRoomNo.getText()+"'");
                    while (resultSet1.next())
                    {
                        String price = resultSet1.getString("price");
                        int amountPaid = Integer.parseInt(price) - Integer.parseInt(textAmount.getText());
                        textPendingAmount.setText(""+amountPaid);
                    }
                }
                catch (Exception E)
                {
                    E.printStackTrace();
                }

            }
        });

        JLabel labelGender = new JLabel("Gender : ");
        labelGender.setBounds(20,220,150,20);
        labelGender.setForeground(Color.WHITE);
        panel.add(labelGender);

        JTextField textGender = new JTextField();
        textGender.setBounds(248,220,150,20);
        panel.add(textGender);

        JLabel labelCheckInTime = new JLabel("Check In Time : ");
        labelCheckInTime.setBounds(20,260,150,20);
        labelCheckInTime.setForeground(Color.WHITE);
        panel.add(labelCheckInTime);

        JTextField textCheckInTime = new JTextField();
        textCheckInTime.setBounds(248,260,150,20);
        panel.add(textCheckInTime);

        JLabel labelDisease = new JLabel("Disease : ");
        labelDisease.setBounds(20,300,150,20);
        labelDisease.setForeground(Color.WHITE);
        panel.add(labelDisease);

        JTextField textDisease = new JTextField();
        textDisease.setBounds(248,300,150,20);
        panel.add(textDisease);

        JLabel labelAmount = new JLabel("Amount Paid(Rs.) : ");
        labelAmount.setBounds(20,340,150,20);
        labelAmount.setForeground(Color.WHITE);
        panel.add(labelAmount);

        textAmount = new JTextField();
        textAmount.setBounds(248,340,150,20);
        panel.add(textAmount);

        JLabel labelPendingAmount = new JLabel("Pending Amount(Rs.) : ");
        labelPendingAmount.setBounds(20,380,200,20);
        labelPendingAmount.setForeground(Color.WHITE);
        panel.add(labelPendingAmount);

        textPendingAmount = new JTextField();
        textPendingAmount.setBounds(248,380,150,20);
        panel.add(textPendingAmount);

        JLabel labelIdNumber = new JLabel("ID Number : ");
        labelIdNumber.setBounds(20,60,150,20);
        labelIdNumber.setFont(new Font("Tahoma",Font.PLAIN,14));
        labelIdNumber.setForeground(Color.WHITE);
        panel.add(labelIdNumber);

        Choice choice = new Choice();
        choice.setBounds(248,60,150,25);
        panel.add(choice);
        try
        {
            Conn conn = new Conn();
            ResultSet resultSet = conn.statement.executeQuery("select * from Patient_Info");
            while (resultSet.next())
            {
                choice.add(resultSet.getString("Number"));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        choice.addItemListener(new ItemListener()
        {
            @Override
            public void itemStateChanged(ItemEvent e)
            {
                try
                {
                    Conn conn = new Conn();
                    ResultSet resultSet = conn.statement.executeQuery("select * from Patient_Info where number = '"+choice.getSelectedItem()+"'");
                    while (resultSet.next())
                    {
                        textSearch.setText(resultSet.getString("name"));
                        textNumber.setText(resultSet.getString("number"));
                        textRoomNo.setText((resultSet.getString("room_number")));
                        textGender.setText(resultSet.getString("gender"));
                        textCheckInTime.setText(resultSet.getString("time"));
                        textDisease.setText(resultSet.getString("diseas"));
                        textAmount.setText(resultSet.getString("deposite"));
                    }
                    ResultSet resultSet1 = conn.statement.executeQuery("select * from room where room_no = '"+textRoomNo.getText()+"'");
                    while (resultSet1.next())
                    {
                        String price = resultSet1.getString("price");
                        int amountPaid = Integer.parseInt(price) - Integer.parseInt(textAmount.getText());
                        textPendingAmount.setText(""+amountPaid);
                    }
                }
                catch (Exception E)
                {
                    E.printStackTrace();
                }
            }
        });

        JLabel labelName = new JLabel("Name : ");
        labelName.setBounds(20,100,150,20);
        labelName.setFont(new Font("Tahoma",Font.PLAIN,14));
        labelName.setForeground(Color.WHITE);
        panel.add(labelName);

        textSearch = new JTextField();
        textSearch.setBounds(248,100,150,20);
        panel.add(textSearch);

        JButton search = new JButton("Search");
        search.setBounds(420,100,100,20);
        search.setFont(new Font("Tahoma",Font.PLAIN,12));
        search.setForeground(Color.BLACK);
        panel.add(search);
        search.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Conn conn = new Conn();
                try
                {
                    ResultSet resultSet = conn.statement.executeQuery("select * from Patient_Info where name = '"+textSearch.getText()+"'");
                    while (resultSet.next())
                    {
                        textNumber.setText(resultSet.getString("number"));
                        textRoomNo.setText((resultSet.getString("room_number")));
                        textGender.setText(resultSet.getString("gender"));
                        textCheckInTime.setText(resultSet.getString("time"));
                        textDisease.setText(resultSet.getString("diseas"));
                        textAmount.setText(resultSet.getString("deposite"));
                    }
                    ResultSet resultSet1 = conn.statement.executeQuery("select * from room where room_no = '"+textRoomNo.getText()+"'");
                    while (resultSet1.next())
                    {
                        String price = resultSet1.getString("price");
                        int amountPaid = Integer.parseInt(price) - Integer.parseInt(textAmount.getText());
                        textPendingAmount.setText(""+amountPaid);
                    }
                }
                catch (Exception E)
                {
                    E.printStackTrace();
                }
            }
        });

        JButton update = new JButton("Update");
        update.setBounds(180,440,100,30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        panel.add(update);
        update.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    Conn conn = new Conn();

                    String name = textSearch.getText();
                    String iDNo = textNumber.getText();
                    String roomNo = textRoomNo.getText();
                    String gender = textGender.getText();
                    String checkInTime = textCheckInTime.getText();
                    String disease = textDisease.getText();
                    String amount = textAmount.getText();
                    String pendingAmount = textPendingAmount.getText();

                    conn.statement.executeUpdate("update patient_info set name = '"+name+"', number = '"+iDNo
                            +"', room_number = '"+roomNo+"', gender = '"+gender+"', time = '"+checkInTime+"', diseas = '"+
                            disease+"', deposite = '"+amount+"' where number = '"+choice.getSelectedItem()+"' or name ='"+name+"'");

                    conn.statement.executeUpdate("update room set availability = 'Occupied' where room_no = '"+textRoomNo.getText()+"'");

                    //JOptionPane.showMessageDialog(null, "Updated Successfully");
                    //new AdmitPayment(iDNo,name,gender,roomNo,pendingAmount);

                    if(pendingAmount.equals("0"))
                    {
                        JOptionPane.showMessageDialog(null, "Updated Successfully");
                        setVisible(false);
                    }
                    else
                    {
                        new AdmitPayment(iDNo,name,gender,roomNo,pendingAmount);
                        try
                        {
                            ResultSet resultSet = conn.statement.executeQuery("select * from Patient_Info where name = '"+textSearch.getText()+"'");
                            while (resultSet.next())
                            {
                                textAmount.setText(resultSet.getString("deposite"));
                            }
                            int amountPaid = (Integer.parseInt(textAmount.getText()) + Integer.parseInt(textPendingAmount.getText()));
                            conn.statement.executeUpdate("update patient_info set deposite = '"+amountPaid+"' where number = '"+choice.getSelectedItem()+"' ");
                        }
                        catch (Exception E)
                        {
                            E.printStackTrace();
                        }

                        setVisible(false);
                    }


                }
                catch (Exception E)
                {
                    E.printStackTrace();
                }
            }
        });

        JButton cancel = new JButton("Cancel");
        cancel.setBounds(400,440,100,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        panel.add(cancel);
        cancel.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setSize(950,500);
        setLayout(null);
        setLocation(275,180);
        setVisible(true);
    }

    public static void main(String[] args)
    {
        new UpdatePatientDetails();
    }
}
