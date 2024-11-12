package hospital.management.system;

import com.toedter.calendar.JDateChooser;

import javax.naming.Name;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class AddDoctor extends JFrame
{
    AddDoctor()
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


        JLabel labelQualification = new JLabel("Qualification : ");
        labelQualification.setBounds(60,150,150,30);
        panel.add(labelQualification);

        JTextField textQualification = new JTextField();
        textQualification.setBounds(250,150,250,30);
        panel.add(textQualification);

        JLabel labelDepartment = new JLabel("Department");
        labelDepartment.setBounds(60,190,150,30);
        panel.add(labelDepartment);

        Choice choice = new Choice();
        choice.setBounds(250,190,150,30);
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
        catch (Exception E)
        {
            E.printStackTrace();
        }

        JLabel labelDoctorFees = new JLabel("Fees(Rs.)");
        labelDoctorFees.setBounds(60,230,150,30);
        panel.add(labelDoctorFees);

        JTextField textDoctorFees = new JTextField();
        textDoctorFees.setBounds(250,230,150,30);
        panel.add(textDoctorFees);

        JLabel labelAvailability = new JLabel("Availability(Days)");
        labelAvailability.setBounds(60,270,200,30);
        panel.add(labelAvailability);

        JRadioButton r1,r2,r3,r4,r5,r6,r7;
        r1 = new JRadioButton("Mon");
        r1.setBounds(250,270,50,20);
        panel.add(r1);

        r2 = new JRadioButton("Tue");
        r2.setBounds(300,270,50,20);
        panel.add(r2);

        r3 = new JRadioButton("Wed");
        r3.setBounds(350,270,60,20);
        panel.add(r3);

        r4 = new JRadioButton("Thu");
        r4.setBounds(410,270,50,20);
        panel.add(r4);

        r5 = new JRadioButton("Fri");
        r5.setBounds(460,270,50,20);
        panel.add(r5);

        r6 = new JRadioButton("Sat");
        r6.setBounds(510,270,50,20);
        panel.add(r6);

        r7 = new JRadioButton("Sun");
        r7.setBounds(560,270,50,20);
        panel.add(r7);

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
                String qualification = textQualification.getText();
                String department = (String) choice.getSelectedItem();
                String fees = textDoctorFees.getText();
                String radioButton = "";
                if(r1.isSelected())
                {
                    radioButton += "Mon";
                }
                if(r2.isSelected())
                {
                    radioButton += "Tue";
                }
                if(r3.isSelected())
                {
                    radioButton += "Wed";
                }
                if(r4.isSelected())
                {
                    radioButton += "Thu";
                }
                if(r5.isSelected())
                {
                    radioButton += "Fri";
                }
                if(r6.isSelected())
                {
                    radioButton += "Sat";
                }
                if(r7.isSelected())
                {
                    radioButton += "Sun";
                }

                String availability = radioButton;


                if (name.equals("") || dob.equals("") || department.equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Fill all the Details");
                }
                else
                {
                    try
                    {
                        Conn conn = new Conn();
                        String query = "insert into Doctor values('"+name+"','"+dob+"','"+phoneNo+"','"+qualification
                                +"','"+department+"','"+fees+"','"+availability+"')";
                        conn.statement.executeUpdate(query);
                        JOptionPane.showMessageDialog(null,"Doctor details added Successfully");
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
        new AddDoctor();
    }
}
