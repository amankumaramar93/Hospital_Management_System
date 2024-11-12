package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Appointment extends JFrame
{
    Appointment()
    {
        JPanel panelHead = new JPanel();
        panelHead.setBounds(5,5,910,30);
        panelHead.setBackground(Color.cyan);
        add(panelHead);

        JLabel labelHeading = new JLabel("Online Appointment Booking");
        labelHeading.setBounds(240,10,250,20);
        labelHeading.setForeground(Color.RED);
        panelHead.add(labelHeading);

        JPanel panelCardio = new JPanel();
        panelCardio.setBounds(5,40,200,200);
        panelCardio.setBackground(Color.BLACK);
        add(panelCardio);

        ImageIcon imageIconCardio = new ImageIcon(ClassLoader.getSystemResource("Icons/cardio.png"));
        Image imageCardio = imageIconCardio.getImage().getScaledInstance(160,160,Image.SCALE_DEFAULT);
        ImageIcon imageIconCardio1 = new ImageIcon(imageCardio);
        JLabel labelCardio = new JLabel(imageIconCardio1);
        labelCardio.setBounds(5,0,160,160);
        panelCardio.add(labelCardio);

        JButton buttonCardio = new JButton("Cardiology");
        buttonCardio.setBounds(0,160,190,20);
        buttonCardio.setBackground(Color.YELLOW);
        buttonCardio.setForeground(Color.BLACK);
        panelCardio.add(buttonCardio);
        buttonCardio.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new Cardiology();
            }
        });

        JPanel panelNeuro = new JPanel();
        panelNeuro.setBounds(240,40,200,200);
        panelNeuro.setBackground(Color.BLACK);
        add(panelNeuro);

        ImageIcon imageIconNeuro = new ImageIcon(ClassLoader.getSystemResource("Icons/neuro.png"));
        Image imageNeuro = imageIconNeuro.getImage().getScaledInstance(160,160,Image.SCALE_DEFAULT);
        ImageIcon imageIconNeuro1 = new ImageIcon(imageNeuro);
        JLabel labelNeuro = new JLabel(imageIconNeuro1);
        labelNeuro.setBounds(240,0,160,160);
        panelNeuro.add(labelNeuro);

        JButton buttonNeuro = new JButton("Neurology");
        buttonNeuro.setBounds(240,160,190,20);
        buttonNeuro.setBackground(Color.YELLOW);
        buttonNeuro.setForeground(Color.BLACK);
        panelNeuro.add(buttonNeuro);
        buttonNeuro.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new Neurology();
            }
        });

        JPanel panelUro = new JPanel();
        panelUro.setBounds(475,40,200,200);
        panelUro.setBackground(Color.BLACK);
        add(panelUro);

        ImageIcon imageIconUro = new ImageIcon(ClassLoader.getSystemResource("Icons/Urology.png"));
        Image imageUro = imageIconUro.getImage().getScaledInstance(160,160,Image.SCALE_DEFAULT);
        ImageIcon imageIconUro1 = new ImageIcon(imageUro);
        JLabel labelUro = new JLabel(imageIconUro1);
        labelUro.setBounds(475,0,160,160);
        panelUro.add(labelUro);

        JButton buttonUro = new JButton("Urology");
        buttonUro.setBounds(475,160,190,20);
        buttonUro.setBackground(Color.YELLOW);
        buttonUro.setForeground(Color.BLACK);
        panelUro.add(buttonUro);
        buttonUro.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new Urology();
            }
        });

        JPanel panelPhysician = new JPanel();
        panelPhysician.setBounds(710,40,200,200);
        panelPhysician.setBackground(Color.BLACK);
        add(panelPhysician);

        ImageIcon imageIconPhysician = new ImageIcon(ClassLoader.getSystemResource("Icons/Physician.png"));
        Image imagePhysician = imageIconPhysician.getImage().getScaledInstance(160,160,Image.SCALE_DEFAULT);
        ImageIcon imageIconPhysician1 = new ImageIcon(imagePhysician);
        JLabel labelPhysician = new JLabel(imageIconPhysician1);
        labelPhysician.setBounds(710,0,160,160);
        panelPhysician.add(labelPhysician);

        JButton buttonPhysician = new JButton("Physician");
        buttonPhysician.setBounds(710,160,190,20);
        buttonPhysician.setBackground(Color.YELLOW);
        buttonPhysician.setForeground(Color.BLACK);
        panelPhysician.add(buttonPhysician);
        buttonPhysician.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new Physician();
            }
        });

        JButton back = new JButton("Back");
        back.setBounds(810,530,100,30);
        back.setBackground(Color.YELLOW);
        back.setForeground(Color.BLACK);
        add(back);
        back.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setSize(930,580);
        setLocation(240,130);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args)
    {
        new Appointment();
    }
}
