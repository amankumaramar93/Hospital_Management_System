package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class PatientInfo extends JFrame
{
    PatientInfo()
    {
        JPanel panel = new JPanel();
        panel.setBounds(5,5,990,570);
        panel.setBackground(new Color(109,164,170));
        panel.setLayout(null);
        add(panel);

        JTable table = new JTable();
        table.setBounds(10,34,900,430);
        table.setBackground(new Color(109,164,170));
        panel.add(table);

        try
        {
            Conn conn = new Conn();
            ResultSet resultSet = conn.statement.executeQuery("select * from Patient_Info");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10,34,900,430);
        panel.add(scrollPane);

        JButton back = new JButton("Back");
        back.setBounds(800,500,100,30);
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
        new PatientInfo();
    }
}
