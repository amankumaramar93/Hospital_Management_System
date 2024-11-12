package hospital.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddAmbulance extends JFrame
{
    JRadioButton r1,r2,r3;

    AddAmbulance()
    {
        JPanel panel = new JPanel();
        panel.setBounds(5,5,840,490);
        panel.setBackground(new Color(109,164,170));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/amb.png"));
        Image image = imageIcon.getImage().getScaledInstance(280,180,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(540,170,280,180);
        panel.add(label);

        JLabel labelHeading = new JLabel("Add Ambulance Details");
        labelHeading.setBounds(100,20,200,30);
        panel.add(labelHeading);

        JLabel labelName = new JLabel("Name : ");
        labelName.setBounds(60,80,100,30);
        panel.add(labelName);

        JTextField textName = new JTextField();
        textName.setBounds(250,80,250,30);
        panel.add(textName);

        JLabel labelPhoneNo = new JLabel("Phone Number : ");
        labelPhoneNo.setBounds(60,120,150,30);
        panel.add(labelPhoneNo);

        JTextField textPhoneNo = new JTextField();
        textPhoneNo.setBounds(250,120,250,30);
        panel.add(textPhoneNo);

        JLabel labelGender = new JLabel("Gender : ");
        labelGender.setBounds(60,160,200,14);
        panel.add(labelGender);

        r1 = new JRadioButton("Male");
        r1.setBackground(new Color(109,164,170));
        r1.setBounds(250,160,80,15);
        panel.add(r1);

        r2 = new JRadioButton("Female");
        r2.setBackground(new Color(109,164,170));
        r2.setBounds(335,160,80,15);
        panel.add(r2);

        r3 = new JRadioButton("Other");
        r3.setBackground(new Color(109,164,170));
        r3.setBounds(430,160,80,15);
        panel.add(r3);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(r1);
        buttonGroup.add(r2);
        buttonGroup.add(r3);

        JLabel labelCarName = new JLabel("Car Name : ");
        labelCarName.setBounds(60,200,100,30);
        panel.add(labelCarName);

        JTextField textCarName = new JTextField();
        textCarName.setBounds(250,200,250,30);
        panel.add(textCarName);

        JLabel labelLocation = new JLabel("Location : ");
        labelLocation.setBounds(60,240,100,30);
        panel.add(labelLocation);

        JTextField textLocation = new JTextField();
        textLocation.setBounds(250,240,250,30);
        panel.add(textLocation);

        JLabel labelAvailable = new JLabel("Available : ");
        labelAvailable.setBounds(60,280,100,30);
        panel.add(labelAvailable);

        String[] available = {"Available","Busy"};
        JComboBox comboBox = new JComboBox(available);
        comboBox.setBounds(250,280,100,30);
        panel.add(comboBox);

        JButton add = new JButton("ADD");
        add.setBounds(170,380,100,30);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        panel.add(add);
        add.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String name = textName.getText();
                String radioButton = null;
                if (r1.isSelected())
                {
                    radioButton = "Male";
                }
                else if(r2.isSelected())
                {
                    radioButton = "Female";
                }
                else if (r3.isSelected())
                {
                    radioButton = "Other";
                }
                String gender = radioButton;
                String carName = textCarName.getText();
                String available = (String) comboBox.getSelectedItem();
                String location = textLocation.getText();
                String phoneNo = textPhoneNo.getText();
                if(name.equals("")||gender.equals("")||carName.equals(""))
                {
                    JOptionPane.showMessageDialog(null,"Fill all the Details");
                }
                else {
                    try {
                        Conn conn = new Conn();
                        String query = "insert into ambulance values('" + name + "','" + gender + "','" + carName + "','" + available
                                + "','" + location + "','" + phoneNo + "')";
                        conn.statement.executeUpdate(query);
                        JOptionPane.showMessageDialog(null, "Ambulance Details Added Successfully");
                    } catch (Exception E) {
                        E.printStackTrace();
                    }
                }
            }
        });

        JButton cancel = new JButton("Cancel");
        cancel.setBounds(350,380,100,30);
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
        new AddAmbulance();
    }
}
