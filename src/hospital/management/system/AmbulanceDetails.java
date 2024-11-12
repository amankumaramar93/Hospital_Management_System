package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class AmbulanceDetails extends JFrame
{
    Choice choice;
    JTable table;

    AmbulanceDetails()
    {
        JPanel panel = new JPanel();
        panel.setBounds(5,5,990,570);
        panel.setBackground(new Color(109,164,170));
        panel.setLayout(null);
        add(panel);

        JLabel labelStatus = new JLabel("Status");
        labelStatus.setBounds(50,10,120,20);
        labelStatus.setForeground(Color.BLACK);
        labelStatus.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(labelStatus);

        choice = new Choice();
        choice.setBounds(170,10,120,20);
        choice.add("Available");
        choice.add("Busy");
        panel.add(choice);
        choice.addItemListener(new ItemListener()
        {
            @Override
            public void itemStateChanged(ItemEvent e)
            {
                String query2 = "select * from ambulance where Available = '"+choice.getSelectedItem()+"'";
                try
                {
                    Conn conn = new Conn();
                    ResultSet resultSet = conn.statement.executeQuery(query2);
                    table.setModel(DbUtils.resultSetToTableModel(resultSet));
                }
                catch (Exception E)
                {
                    E.printStackTrace();
                }
            }
        });

        table = new JTable();
        table.setBounds(10,60,900,430);
        table.setBackground(new Color(109,164,170));
        panel.add(table);

        try
        {
            Conn conn = new Conn();
            ResultSet resultSet = conn.statement.executeQuery("select * from Ambulance");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10,60,900,430);
        panel.add(scrollPane);

        JButton back = new JButton("Back");
        back.setBounds(820,530,100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        panel.add(back);
        back.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setSize(1000,580);
        setLocation(280,130);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args)
    {
        new AmbulanceDetails();
    }
}
