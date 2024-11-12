package hospital.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddEmployee extends JFrame
{
    AddEmployee()
    {
        JPanel panel = new JPanel();
        panel.setBounds(5,5,840,490);
        panel.setBackground(new Color(109,164,170));
        panel.setLayout(null);
        add(panel);

        JLabel labelName = new JLabel("Name : ");
        labelName.setBounds(60,30,100,30);
        panel.add(labelName);

        JTextField textName = new JTextField();
        textName.setBounds(250,30,250,30);
        panel.add(textName);

        JLabel labelDob = new JLabel("Date Of Birth : ");
        labelDob.setBounds(60,70,100,30);
        panel.add(labelDob);

        JDateChooser textDob = new JDateChooser();
        textDob.setBounds(250,70,250,30);
        panel.add(textDob);

        JLabel labelPhoneNo = new JLabel("Phone Number : ");
        labelPhoneNo.setBounds(60,110,150,30);
        panel.add(labelPhoneNo);

        JTextField textPhoneNo = new JTextField();
        textPhoneNo.setBounds(250,110,250,30);
        panel.add(textPhoneNo);

        JLabel labelSalary = new JLabel("Salary : ");
        labelSalary.setBounds(60,150,150,30);
        panel.add(labelSalary);

        JTextField textSalary = new JTextField();
        textSalary.setBounds(250,150,250,30);
        panel.add(textSalary);

        JLabel labelEmail = new JLabel("Email Id : ");
        labelEmail.setBounds(60,190,150,30);
        panel.add(labelEmail);

        JTextField textEmail = new JTextField();
        textEmail.setBounds(250,190,250,30);
        panel.add(textEmail);

        JLabel labelAadhar = new JLabel("Aadhar No : ");
        labelAadhar.setBounds(60,230,150,30);
        panel.add(labelAadhar);

        JTextField textAadhar = new JTextField();
        textAadhar.setBounds(250,230,250,30);
        panel.add(textAadhar);

        JButton add = new JButton("ADD");
        add.setBounds(170,330,100,30);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        panel.add(add);
        add.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String name = textName.getText();
                String dob = ((JTextField) textDob.getDateEditor().getUiComponent()).getText();
                String phoneNo = textPhoneNo.getText();
                String salary = textSalary.getText();
                String email = textEmail.getText();
                String aadharNo = textAadhar.getText();

                if (name.equals("") || dob.equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Fill all the Details");
                }
                else
                {
                    try
                    {
                        Conn conn = new Conn();
                        String query = "insert into Employee_Info values('"+name+"','"+dob+"','"+phoneNo+"','"+
                                salary+"','"+email+"','"+aadharNo+"')";
                        conn.statement.executeUpdate(query);
                        JOptionPane.showMessageDialog(null,"Employee Details Added Successfully");
                    }
                    catch (Exception E)
                    {
                        E.printStackTrace();
                    }
                }
            }
        });

        JButton cancel = new JButton("Cancel");
        cancel.setBounds(350,330,100,30);
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
        setSize(850,500);
        setLocation(290,170);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args)
    {
        new AddEmployee();
    }
}
