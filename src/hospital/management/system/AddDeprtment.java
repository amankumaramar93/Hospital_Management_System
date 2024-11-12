package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class AddDeprtment extends JFrame
{
    AddDeprtment()
    {
        JPanel panel = new JPanel();
        panel.setBounds(5,10,490,340);
        panel.setBackground(Color.PINK);
        panel.setLayout(null);
        add(panel);

        JLabel labelDepartmentName = new JLabel("Department Name : ");
        labelDepartmentName.setBounds(20,40,200,30);
        labelDepartmentName.setFont(new Font("Tahoma",Font.BOLD,16));
        panel.add(labelDepartmentName);

        JTextField textDepartmentName = new JTextField();
        textDepartmentName.setBounds(250,40,220,30);
        textDepartmentName.setFont(new Font("Tahoma",Font.PLAIN,16));
        panel.add(textDepartmentName);

        JLabel labelDepartmentPhone = new JLabel("Department Phone No : ");
        labelDepartmentPhone.setBounds(20,100,200,30);
        labelDepartmentPhone.setFont(new Font("Tahoma",Font.BOLD,16));
        panel.add(labelDepartmentPhone);

        JTextField textDepartmentPhone = new JTextField();
        textDepartmentPhone.setBounds(250,100,220,30);
        textDepartmentPhone.setFont(new Font("Tahoma",Font.PLAIN,16));
        panel.add(textDepartmentPhone);

        JButton add, back;

        add = new JButton("ADD");
        add.setBounds(130,200,100,30);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        panel.add(add);
        add.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String departmentName = textDepartmentName.getText();
                String departmentPhoneNo = textDepartmentPhone.getText();

                if(departmentName.equals(""))
                {
                    JOptionPane.showMessageDialog(null,"Fill all the Details");
                }
                else
                {
                    try
                    {
                        Conn conn = new Conn();
                        String query = "insert into Department values('"+departmentName+"','"+departmentPhoneNo+"')";
                        conn.statement.executeUpdate(query);
                        JOptionPane.showMessageDialog(null,"Added Successfully");
                    }
                    catch (Exception E)
                    {
                        E.printStackTrace();
                    }
                }

            }
        });

        back = new JButton("Back");
        back.setBounds(300,200,100,30);
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
        setSize(500,350);
        setLayout(null);
        setLocation(350,180);
        setVisible(true);
    }

    public static void main(String[] args)
    {
        new AddDeprtment();
    }
}
