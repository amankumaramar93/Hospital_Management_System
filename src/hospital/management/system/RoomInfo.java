package hospital.management.system;

import com.mysql.cj.xdevapi.Table;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class RoomInfo extends JFrame
{
    JTable table;

    RoomInfo()
    {
        JPanel panel = new JPanel();
        panel.setBounds(5,5,890,590);
        panel.setBackground(Color.BLACK);
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("Icons/roomm.png"));
        Image image = imageIcon.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(600,200,200,200);
        panel.add(label);

        table = new JTable();
        table.setBounds(10,40,500,400);
        table.setBackground(Color.YELLOW);
        table.setForeground(Color.BLACK);
        panel.add(table);

        try
        {
            Conn conn = new Conn();
            String query1 = "select * from room";
            ResultSet resultSet = conn.statement.executeQuery(query1);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10,40,500,400);
        panel.add(scrollPane);

        JButton back;

        back = new JButton("Back");
        back.setBounds(250,480,100,20);
        back.setBackground(Color.YELLOW);
        back.setForeground(Color.BLACK);
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
        setSize(900,600);
        setLayout(null);
        setLocation(250, 110);
        setVisible(true);
    }

    public static void main(String[] args)
    {
        new RoomInfo();
    }
}
