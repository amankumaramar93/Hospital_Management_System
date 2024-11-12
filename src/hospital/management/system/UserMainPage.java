package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserMainPage extends JFrame
{
    UserMainPage()
    {
        JPanel panel1 = new JPanel();
        panel1.setBounds(0,5,1390,50);
        panel1.setBackground(Color.BLACK);
        add(panel1);

        JLabel labelHeading = new JLabel("Engineer Foundation Hospital");
        labelHeading.setBounds(310,5,300,40);
        labelHeading.setFont(new Font("Serif",Font.BOLD,30));
        labelHeading.setForeground(Color.GREEN);
        panel1.add(labelHeading);

        JPanel panel = new JPanel();
        panel.setBounds(0,5,1390,1090);
        panel.setBackground(Color.PINK);
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/HospitalBuilding.png"));
        Image image = imageIcon.getImage().getScaledInstance(1390,600,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(0,110,1390,600);
        panel.add(label);

        JButton button1 = new JButton("Appointment Booking");
        button1.setBounds(10,60,200,40);
        button1.setBackground(Color.YELLOW);
        button1.setForeground(Color.BLACK);
        panel.add(button1);
        button1.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new Appointment();
            }
        });

        JButton button2 = new JButton("View Doctor Details");
        button2.setBounds(220,60,200,40);
        button2.setBackground(Color.YELLOW);
        button2.setForeground(Color.BLACK);
        panel.add(button2);
        button2.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new ViewDoctorDetails();
            }
        });

        JButton button3 = new JButton("View Department");
        button3.setBounds(430,60,200,40);
        button3.setBackground(Color.YELLOW);
        button3.setForeground(Color.BLACK);
        panel.add(button3);
        button3.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new Department();
            }
        });

        JButton button4 = new JButton("View Ambulance Details");
        button4.setBounds(640,60,200,40);
        button4.setBackground(Color.YELLOW);
        button4.setForeground(Color.BLACK);
        panel.add(button4);
        button4.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new AmbulanceDetails();
            }
        });

        JButton button5 = new JButton("Admission / Admit Section");
        button5.setBounds(850,60,200,40);
        button5.setBackground(Color.YELLOW);
        button5.setForeground(Color.BLACK);
        panel.add(button5);
        button5.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new Admission();
            }
        });

        JButton exit = new JButton("Exit");
        exit.setBounds(1250,60,100,30);
        exit.setBackground(Color.RED);
        exit.setForeground(Color.BLACK);
        panel.add(exit);
        exit.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        });

        setUndecorated(true);
        setSize(1400,1090);
        setLayout(null);
        setLocation(0,0);
        setVisible(true);
    }

    public static void main(String[] args)
    {
        new UserMainPage();
    }
}
