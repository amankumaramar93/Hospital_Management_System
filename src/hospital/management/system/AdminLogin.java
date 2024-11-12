package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class AdminLogin extends JFrame implements ActionListener
{
    JTextField textUserName;
    JPasswordField textPassword;
    JButton login,clear,back,signup;

    AdminLogin()
    {
        super("Administrator Login");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/login.png"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(310,30,400,300);
        add(image);


        JLabel labelUserName = new JLabel("Username: ");
        labelUserName.setBounds(50, 40, 150, 30);
        labelUserName.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(labelUserName);

        textUserName = new JTextField();
        textUserName.setBounds(210, 40, 200,30);
        textUserName.setFont(new Font("Tahoma",Font.BOLD,20));
        add(textUserName);

        JLabel labelPassword = new JLabel("Password: ");
        labelPassword.setBounds(50, 90, 150, 30);
        labelPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(labelPassword);

        textPassword = new JPasswordField();
        textPassword.setBounds(210, 90, 200,30);
        textPassword.setFont(new Font("Tahoma",Font.BOLD,20));
        add(textPassword);

        login = new JButton("Login");
        login.setBounds(70,160,120,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        clear = new JButton("Clear");
        clear.setBounds(220,160,120,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        signup = new JButton("Signup");
        signup.setBounds(70,210,120,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);

        back = new JButton("Back");
        back.setBounds(220,210,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        getContentPane().setBackground(new Color(109, 164, 170));
        setUndecorated(true);
        setSize(700,360);
        setLayout(null);
        setLocation(320, 200);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == login)
        {
            String username = textUserName.getText();
            String password = textPassword.getText();
            String query = "select * from AdminSignup where username = '"+username+"' and password = '"+password+"'";
            try
            {
                Conn conn = new Conn();
                ResultSet resultSet = conn.statement.executeQuery(query);
                if (resultSet.next())
                {
                    setVisible(false);
                    new Reception();
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Invalid Username or Password");
                }
            }
            catch (Exception E)
            {
                E.printStackTrace();
            }
        }
        else if(e.getSource() == signup)
        {
            setVisible(false);
            new AdminSignup();
        }
        else if (e.getSource() == clear)
        {
            textUserName.setText("");
            textPassword.setText("");
        }
        else if (e.getSource() == back)
        {
            System.exit(0);
        }

    }

    public static void main(String[] args)
    {
        new AdminLogin();
    }
}
