package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reception extends JFrame
{
    Reception()
    {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5, 160,1400,670);
        panel.setBackground(new Color(109,164,170));
        add(panel);

        ImageIcon imageIconReception = new ImageIcon(ClassLoader.getSystemResource("icons/Reception.png"));
        Image imageReception = imageIconReception.getImage().getScaledInstance(1370,650,Image.SCALE_DEFAULT);
        ImageIcon imageIconReception1 = new ImageIcon(imageReception);
        JLabel label = new JLabel(imageIconReception1);
        label.setBounds(5,110,1370,650);
        panel.add(label);

        JPanel panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(5, 5,1400,150);
        panel1.setBackground(new Color(109,164,170));
        add(panel1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/dr.png"));
        Image image = i1.getImage().getScaledInstance(220,210,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(image);
        JLabel i3 = new JLabel(i2);
        i3.setBounds(1220,0,160,200);
        panel1.add(i3);

        ImageIcon ii1 = new ImageIcon(ClassLoader.getSystemResource("Icons/amb.png"));
        Image iimage = ii1.getImage().getScaledInstance(300,100,Image.SCALE_DEFAULT);
        ImageIcon ii2 = new ImageIcon(iimage);
        JLabel ii3 = new JLabel(ii2);
        ii3.setBounds(900,50,300,100);
        panel1.add(ii3);

        JButton button1 = new JButton("Add New Patient");
        button1.setBounds(10,15,160,30);
        button1.setBackground(new Color(246,215,118));
        panel1.add(button1);
        button1.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new NewPatient();
            }
        });

        JButton button2 = new JButton("Room");
        button2.setBounds(10,58,160,30);
        button2.setBackground(new Color(246,215,118));
        panel1.add(button2);
        button2.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new RoomInfo();
            }
        });

        JButton button3 = new JButton("Department");
        button3.setBounds(10,100,160,30);
        button3.setBackground(new Color(246,215,118));
        panel1.add(button3);
        button3.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new Department();
            }
        });

        JButton button4 = new JButton("All Employee Info");
        button4.setBounds(180,15,160,30);
        button4.setBackground(new Color(246,215,118));
        panel1.add(button4);
        button4.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new EmployeeInfo();
            }
        });

        JButton button5 = new JButton("Patient Info");
        button5.setBounds(180,58,160,30);
        button5.setBackground(new Color(246,215,118));
        panel1.add(button5);
        button5.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new PatientInfo();
            }
        });

        JButton button6 = new JButton("Patient Discharge");
        button6.setBounds(180,100,160,30);
        button6.setBackground(new Color(246,215,118));
        panel1.add(button6);
        button6.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new PatientDischarge();
            }
        });

        JButton button7 = new JButton("Update Patient Details");
        button7.setBounds(350,15,160,30);
        button7.setBackground(new Color(246,215,118));
        panel1.add(button7);
        button7.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new UpdatePatientDetails();
            }
        });

        JButton button8 = new JButton("Hospital Ambulance");
        button8.setBounds(350,58,160,30);
        button8.setBackground(new Color(246,215,118));
        panel1.add(button8);
        button8.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new AmbulanceDetails();
            }
        });

        JButton button9 = new JButton("Search Room");
        button9.setBounds(350,100,160,30);
        button9.setBackground(new Color(246,215,118));
        panel1.add(button9);
        button9.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new SearchRoom();
            }
        });

        JButton button10 = new JButton("ADD ROOM");
        button10.setBounds(520,15,160,30);
        button10.setBackground(new Color(246,215,118));
        panel1.add(button10);
        button10.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new AddRoom();
            }
        });

        JButton button11 = new JButton("ADD DEPARTMENT");
        button11.setBounds(520,58,160,30);
        button11.setBackground(new Color(246,215,118));
        panel1.add(button11);
        button11.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new AddDeprtment();
            }
        });

        JButton button12 = new JButton("ADD EMPLOYEE");
        button12.setBounds(520,100,160,30);
        button12.setBackground(new Color(246,215,118));
        panel1.add(button12);
        button12.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new AddEmployee();
            }
        });

        JButton button13 = new JButton("ADD Doctor");
        button13.setBounds(690,15,160,30);
        button13.setBackground(new Color(246,215,118));
        panel1.add(button13);
        button13.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new AddDoctor();
            }
        });

        JButton button14 = new JButton("Add Ambulance");
        button14.setBounds(690,58,160,30);
        button14.setBackground(new Color(246,215,118));
        panel1.add(button14);
        button14.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new AddAmbulance();
            }
        });

        JButton button15 = new JButton("Appointment");
        button15.setBounds(690,100,160,30);
        button15.setBackground(new Color(246,215,118));
        panel1.add(button15);
        button15.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new Appointment();
            }
        });

        JButton logout = new JButton("Logout");
        logout.setBounds(990,10,160,30);
        logout.setBackground(new Color(109,164,170));
        logout.setForeground(Color.RED);
        panel1.add(logout);
        logout.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                setVisible(false);
                new AdminLogin();
            }
        });

        JButton button16 = new JButton("Confirmed Appointment Booking");
        button16.setBounds(10,10,250,30);
        button16.setBackground(new Color(246,215,118));
        panel.add(button16);
        button16.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new ViewBookingConfirmed();
            }
        });

        JButton button17 = new JButton("View Doctor Details");
        button17.setBounds(270,10,250,30);
        button17.setBackground(new Color(246,215,118));
        panel.add(button17);
        button17.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new ViewDoctorDetails();
            }
        });

        JButton button18 = new JButton("View Confirmed Payment");
        button18.setBounds(530,10,250,30);
        button18.setBackground(new Color(246,215,118));
        panel.add(button18);
        button18.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new ConfirmedPayment();
            }
        });


        getContentPane().setBackground(Color.WHITE);

        setUndecorated(true);
        setSize(1400,1090);
        setLayout(null);
        setLocation(0,0);
        setVisible(true);
    }

    public static void main(String[] args)
    {
        new Reception();
    }
}
