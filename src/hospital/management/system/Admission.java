package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Admission extends JFrame
{
    Admission()
    {
        JPanel panel1 = new JPanel();
        panel1.setBounds(5,5,990,50);
        panel1.setBackground(Color.BLACK);
        add(panel1);

        JLabel labelHeading = new JLabel("Engineer Foundation Hospital");
        labelHeading.setBounds(400,155,300,40);
        labelHeading.setFont(new Font("Serif",Font.BOLD,30));
        labelHeading.setForeground(Color.GREEN);
        panel1.add(labelHeading);

        JPanel panel = new JPanel();
        panel.setBounds(5,60,990,690);
        panel.setBackground(Color.PINK);
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/AdmissionAdmit.png"));
        Image image = imageIcon.getImage().getScaledInstance(990,500,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(0,60,990,500);
        panel.add(label);

        JButton button1 = new JButton("View Room Information");
        button1.setBounds(10,10,200,40);
        button1.setBackground(Color.YELLOW);
        button1.setForeground(Color.BLACK);
        panel.add(button1);
        button1.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new SearchRoom();
            }
        });

        JButton button2 = new JButton("View Doctor Details");
        button2.setBounds(230,10,200,40);
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

        JButton button3 = new JButton("Add New Patient");
        button3.setBounds(440,10,200,40);
        button3.setBackground(Color.YELLOW);
        button3.setForeground(Color.BLACK);
        panel.add(button3);
        button3.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new NewPatient();
            }
        });

        JButton button4 = new JButton("Update Patient Details");
        button4.setBounds(650,10,200,40);
        button4.setBackground(Color.YELLOW);
        button4.setForeground(Color.BLACK);
        panel.add(button4);
        button4.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new UpdatePatientDetails();
            }
        });

        JButton button5 = new JButton("Back");
        button5.setBounds(860,10,100,40);
        button5.setBackground(Color.YELLOW);
        button5.setForeground(Color.BLACK);
        panel.add(button5);
        button5.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setSize(1000,700);
        setLayout(null);
        setLocation(200,120);
        setVisible(true);
    }

    public static void main(String[] args)
    {
        new Admission();
    }
}
