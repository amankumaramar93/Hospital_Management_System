package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class ViewDoctorDetails extends JFrame
{
    ViewDoctorDetails()
    {
        JPanel panel = new JPanel();
        panel.setBounds(5,5,990,570);
        panel.setBackground(new Color(109,164,170));
        panel.setLayout(null);
        add(panel);

        Choice choice = new Choice();
        choice.setBounds(30,20,200,30);
        choice.setBackground(Color.YELLOW);
        choice.setForeground(Color.BLACK);
        panel.add(choice);

        try
        {
            Conn conn = new Conn();
            ResultSet resultSet = conn.statement.executeQuery("select * from Department");
            while (resultSet.next())
            {
                choice.add(resultSet.getString("department_name"));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        JTable table = new JTable();
        table.setBounds(10,60,900,430);
        table.setBackground(new Color(109,164,170));
        panel.add(table);

        try
        {
            Conn conn = new Conn();
            ResultSet resultSet = conn.statement.executeQuery("select * from Doctor");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10,60,900,430);
        panel.add(scrollPane);

        choice.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e)
            {
                String query2 = "select * from Doctor where Department = '"+choice.getSelectedItem()+"'";
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

        JButton back = new JButton("Back");
        back.setBounds(840,530,100,30);
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
        new ViewDoctorDetails();
    }
}
