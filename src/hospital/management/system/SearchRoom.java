package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class SearchRoom extends JFrame
{
    Choice choice;
    JTable table;

    SearchRoom()
    {
        JPanel panel = new JPanel();
        panel.setBounds(5,5,690,490);
        panel.setBackground(Color.cyan);
        panel.setLayout(null);
        add(panel);

        JLabel labelHeading = new JLabel("Search For Room");
        labelHeading.setBounds(250,11,186,31);
        labelHeading.setForeground(Color.BLACK);
        labelHeading.setFont(new Font("Tahoma",Font.BOLD,20));
        panel.add(labelHeading);

        JLabel labelStatus = new JLabel("Status");
        labelStatus.setBounds(50,70,120,20);
        labelStatus.setForeground(Color.BLACK);
        labelStatus.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(labelStatus);

        choice = new Choice();
        choice.setBounds(170,70,120,20);
        choice.add("Available");
        choice.add("Occupied");
        panel.add(choice);

        table = new JTable();
        table.setBounds(0,160,700,210);
        table.setBackground(Color.YELLOW);
        table.setForeground(Color.BLACK);
        panel.add(table);

        try
        {
            Conn conn =  new Conn();
            String query1 = "select * from room";
            ResultSet resultSet = conn.statement.executeQuery(query1);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0,130,700,250);
        panel.add(scrollPane);

        choice.addItemListener(new ItemListener()
        {
            @Override
            public void itemStateChanged(ItemEvent e)
            {
                String query2 = "select * from room where Availability = '"+choice.getSelectedItem()+"'";
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

        JButton search,back;
         search = new JButton("Search");
         search.setBounds(200,420,120,25);
         search.setBackground(Color.BLACK);
         search.setForeground(Color.WHITE);
         panel.add(search);
         search.addActionListener(new ActionListener()
         {
             @Override
             public void actionPerformed(ActionEvent e)
             {
                 String query2 = "select * from room where Availability = '"+choice.getSelectedItem()+"'";
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

        back = new JButton("Back");
        back.setBounds(350,420,120,25);
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
        setSize(700,500);
        setLocation(450,200);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args)
    {
        new SearchRoom();
    }
}
