package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddRoom extends JFrame
{
    AddRoom()
    {
        JLabel labelRoomNo = new JLabel("Room Number : ");
        labelRoomNo.setBounds(50,20,100,25);
        add(labelRoomNo);

        JTextField textRoomNumber = new JTextField();
        textRoomNumber.setBounds(250,20,150,25);
        add(textRoomNumber);

        JLabel labelAvailability = new JLabel("Availablity : ");
        labelAvailability.setBounds(50,70,100,25);
        add(labelAvailability);

        JComboBox comboBox = new JComboBox(new String[] {"Available","Occupied"});
        comboBox.setBounds(250,70,150,25);
        add(comboBox);

        JLabel labelPrice = new JLabel("Price : ");
        labelPrice.setBounds(50,120,100,25);
        add(labelPrice);

        JTextField textPrice = new JTextField();
        textPrice.setBounds(250,120,150,25);
        add(textPrice);

        JLabel labelRoomType = new JLabel("Room Type : ");
        labelRoomType.setBounds(50,170,100,25);
        add(labelRoomType);

        JComboBox comboBox1 = new JComboBox(new String[] {"General Ward","Private Room","ICU"});
        comboBox1.setBounds(250,170,150,25);
        add(comboBox1);

        JButton addRoom = new JButton("Add Room");
        addRoom.setBounds(100,280,150,25);
        addRoom.setBackground(Color.BLACK);
        addRoom.setForeground(Color.WHITE);
        add(addRoom);
        addRoom.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String roomNo = textRoomNumber.getText();
                String avaialability = (String) comboBox.getSelectedItem();
                String price = textPrice.getText();
                String roomType = (String) comboBox1.getSelectedItem();

                if(textRoomNumber.getText().equals("") || textPrice.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null,"Fill all the Details..");
                }

                else {

                    try {
                        Conn conn = new Conn();
                        String query = "Insert into Room values('" + roomNo + "','" + avaialability + "','" + price + "','" + roomType + "')";
                        conn.statement.executeUpdate(query);
                        JOptionPane.showMessageDialog(null, "Room Information added successfully");

                    } catch (Exception E) {
                        E.printStackTrace();
                    }
                }
            }
        });

        JButton back = new JButton("Back");
        back.setBounds(300,280,150,25);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);
        back.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                setVisible(false);
            }
        });


        getContentPane().setBackground(Color.PINK);

        setUndecorated(true);
        setSize(650,370);
        setLayout(null);
        setLocation(300,170);
        setVisible(true);
    }

    public static void main(String[] args)
    {
        new AddRoom();
    }
}
