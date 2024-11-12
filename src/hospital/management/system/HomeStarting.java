package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeStarting extends JFrame
{
    HomeStarting()
    {
        JPanel panel = new JPanel();
        panel.setBounds(5,5,490,290);
        panel.setBackground(Color.PINK);
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image image = imageIcon.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(230,50,200,200);
        panel.add(label);

        JButton user = new JButton("User / Patient");
        user.setBounds(10,60,250,50);
        user.setFont(new Font("Serif",Font.BOLD,30));
        user.setBackground(Color.GREEN);
        user.setForeground(Color.BLACK);
        panel.add(user);

        user.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new UserMainPage();
                setVisible(false);
            }
        });

        JButton administrator = new JButton("Administrator");
        administrator.setBounds(10,140,250,50);
        administrator.setFont(new Font("Serif",Font.BOLD,30));
        administrator.setBackground(Color.GREEN);
        administrator.setForeground(Color.BLACK);
        panel.add(administrator);

        administrator.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                new AdminLogin();
                setVisible(false);
            }
        });

        JButton exit = new JButton("Exit");
        exit.setBounds(190,240,100,30);
        exit.setFont(new Font("Serif",Font.BOLD,25));
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
        setSize(500,300);
        setLayout(null);
        setLocation(450,200);
        setVisible(true);
    }

    public static void main(String[] args)
    {
        new HomeStarting();
    }
}
