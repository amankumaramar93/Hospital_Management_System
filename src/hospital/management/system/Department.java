package hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Department extends JFrame
{
    Department()
    {
        JPanel panel = new JPanel();
        panel.setBounds(5,5,690,490);
        panel.setLayout(null);
        panel.setBackground(new Color(90,156,163));
        add(panel);

        JTable table = new JTable();
        table.setBounds(0,5,690,400);
        table.setBackground(new Color(90,156,163));
        panel.add(table);

        try
        {
            Conn conn = new Conn();
            String query1 = "select * from Department";
            ResultSet resultSet = conn.statement.executeQuery(query1);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0,5,690,400);
        panel.add(scrollPane);

        JButton back = new JButton("Back");
        back.setBounds(570,436,100,30);
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
        setLayout(null);
        setLocation(320,170);
        setVisible(true);
    }

    public static void main(String[] args)
    {
        new Department();
    }
}
