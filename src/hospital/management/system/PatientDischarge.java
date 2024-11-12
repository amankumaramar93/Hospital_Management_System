package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.util.Date;

public class PatientDischarge extends JFrame
{
    PatientDischarge()
    {
        JPanel panel = new JPanel();
        panel.setBounds(5,5,790,390);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        add(panel);

        JLabel labelCheckOut = new JLabel("CHECK-OUT ");
        labelCheckOut.setBounds(200,20,150,20);
        labelCheckOut.setFont(new Font("Tahoma",Font.BOLD,20));
        labelCheckOut.setForeground(Color.WHITE);
        panel.add(labelCheckOut);

        JLabel labelCustomerId = new JLabel("Customer Id : ");
        labelCustomerId.setBounds(30,80,150,20);
        labelCustomerId.setFont(new Font("Tahoma",Font.BOLD,14));
        labelCustomerId.setForeground(Color.WHITE);
        panel.add(labelCustomerId);

        Choice choice = new Choice();
        choice.setBounds(200,80,150,25);
        panel.add(choice);

        try
        {
            Conn conn = new Conn();
            ResultSet resultSet = conn.statement.executeQuery("select * from Patient_Info");
            while (resultSet.next())
            {
                choice.add(resultSet.getString("number"));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        JLabel labelRoomNo = new JLabel("Room Number : ");
        labelRoomNo.setBounds(30,130,150,20);
        labelRoomNo.setFont(new Font("Tahoma",Font.BOLD,14));
        labelRoomNo.setForeground(Color.WHITE);
        panel.add(labelRoomNo);

        JLabel labelSetRoomNo = new JLabel();
        labelSetRoomNo.setBounds(200,130,150,20);
        labelSetRoomNo.setFont(new Font("Tahoma",Font.BOLD,14));
        labelSetRoomNo.setForeground(Color.WHITE);
        panel.add(labelSetRoomNo);

        JLabel labelCheckInTime = new JLabel("Check In Time : ");
        labelCheckInTime.setBounds(30,180,150,20);
        labelCheckInTime.setFont(new Font("Tahoma",Font.BOLD,14));
        labelCheckInTime.setForeground(Color.WHITE);
        panel.add(labelCheckInTime);

        JLabel labelSetCheckInTime = new JLabel();
        labelSetCheckInTime.setBounds(200,180,250,20);
        labelSetCheckInTime.setFont(new Font("Tahoma",Font.BOLD,14));
        labelSetCheckInTime.setForeground(Color.WHITE);
        panel.add(labelSetCheckInTime);

        JLabel labelCheckOutTime = new JLabel("Check Out Time : ");
        labelCheckOutTime.setBounds(30,230,150,20);
        labelCheckOutTime.setFont(new Font("Tahoma",Font.BOLD,14));
        labelCheckOutTime.setForeground(Color.WHITE);
        panel.add(labelCheckOutTime);

        Date date = new Date();

        JLabel labelSetCheckOutTime = new JLabel(""+date);
        labelSetCheckOutTime.setBounds(200,230,250,20);
        labelSetCheckOutTime.setFont(new Font("Tahoma",Font.BOLD,14));
        labelSetCheckOutTime.setForeground(Color.WHITE);
        panel.add(labelSetCheckOutTime);

        try
        {
            Conn conn = new Conn();
            ResultSet resultSet = conn.statement.executeQuery("select * from  Patient_Info where number = '"+choice.getSelectedItem()+"'");
            while (resultSet.next())
            {
                labelSetRoomNo.setText(resultSet.getString("Room_Number"));
                labelSetCheckInTime.setText(resultSet.getString("Time"));
            }

        }
        catch (Exception E)
        {
            E.printStackTrace();
        }

        choice.addItemListener(new ItemListener()
        {
            @Override
            public void itemStateChanged(ItemEvent e)
            {
                try
                {
                    Conn conn = new Conn();
                    ResultSet resultSet = conn.statement.executeQuery("select * from  Patient_Info where number = '"+choice.getSelectedItem()+"'");
                    while (resultSet.next())
                    {
                        labelSetRoomNo.setText(resultSet.getString("Room_Number"));
                        labelSetCheckInTime.setText(resultSet.getString("Time"));
                    }

                }
                catch (Exception E)
                {
                    E.printStackTrace();
                }

            }
        });

        JButton discharge = new JButton("Discharge");
        discharge.setBounds(170,300,100,30);
        discharge.setBackground(Color.BLACK);
        discharge.setForeground(Color.WHITE);
        panel.add(discharge);
        discharge.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    Conn conn = new Conn();
                    conn.statement.executeQuery("select * from patient_info where number = '"+choice.getSelectedItem()+"'");

                    conn.statement.executeUpdate("delete from Patient_Info where number = '"+choice.getSelectedItem()+"'");

                    conn.statement.executeUpdate("update discharge_patient set check_out_time = '"+labelSetCheckOutTime.getText()+"' where number = '"+choice.getSelectedItem()+"'");
                    conn.statement.executeUpdate("update room set availability = 'Available' where room_no = '"+labelSetRoomNo.getText()+"'");
                    JOptionPane.showMessageDialog(null,"Done");
                    setVisible(false);

                }
                catch (Exception E)
                {
                    E.printStackTrace();
                }
            }
        });

        JButton cancel = new JButton("Cancel");
        cancel.setBounds(320,300,100,30);
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
        setSize(800,400);
        setLocation(280,180);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args)
    {
        new PatientDischarge();
    }
}
