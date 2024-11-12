package hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.util.Date;

public class Payment extends JFrame
{
    String patient,doctor,amount,date,idNumber;

    Payment(String patient,String doctor,String amount,String date,String idNumber)
    {
        this.patient = patient;
        this.doctor = doctor;
        this.amount = amount;
        this.date = date;
        this.idNumber = idNumber;

        JPanel panelHeading = new JPanel();
        panelHeading.setBounds(5,5,990,40);
        panelHeading.setBackground(Color.YELLOW);
        panelHeading.setLayout(null);
        add(panelHeading);

        JLabel labelHeading = new JLabel("Payment");
        labelHeading.setBounds(400,5,150,30);
        labelHeading.setForeground(Color.BLACK);
        panelHeading.add(labelHeading);

        JPanel panel = new JPanel();
        panel.setBounds(5,50,990,590);
        panel.setBackground(Color.PINK);
        panel.setLayout(null);
        add(panel);

        JLabel labelDate = new JLabel("Date : ");
        labelDate.setBounds(40,20,150,30);
        panel.add(labelDate);

        Date time = new Date();

        JLabel labelSetDate = new JLabel(""+time);
        labelSetDate.setBounds(250,20,200,30);
        panel.add(labelSetDate);


        JLabel labelName = new JLabel("Receipient Name : ");
        labelName.setBounds(40,60,150,30);
        panel.add(labelName);

        JLabel labelSetName = new JLabel(patient);
        labelSetName.setBounds(250,60,150,30);
        panel.add(labelSetName);

        JLabel labelDoctor = new JLabel("Doctor : ");
        labelDoctor.setBounds(500,20,100,30);
        panel.add(labelDoctor);

        JLabel labelSetDoctor = new JLabel(doctor);
        labelSetDoctor.setBounds(600,20,150,30);
        panel.add(labelSetDoctor);

        JLabel labelAmount = new JLabel("Amount : ");
        labelAmount.setBounds(500,50,100,30);
        panel.add(labelAmount);

        JLabel labelSetAmount = new JLabel(amount);
        labelSetAmount.setBounds(600,50,150,30);
        panel.add(labelSetAmount);

        JLabel labelPaymentOption = new JLabel("Mode Of Payment");
        labelPaymentOption.setBounds(40,100,200,30);
        panel.add(labelPaymentOption);

        JComboBox comboBoxPaymentOption = new JComboBox(new String[] {"Internet Banking","Cash","UPI"});
        comboBoxPaymentOption.setBounds(250,100,150,30);
        panel.add(comboBoxPaymentOption);

        JLabel label = new JLabel();
        label.setBounds(40,140,200,30);
        panel.add(label);

        JTextField textField = new JTextField();
        textField.setBounds(250,140,150,30);
        panel.add(textField);

        JLabel label1 = new JLabel();
        label1.setBounds(40,180,200,30);
        panel.add(label1);

        JTextField textField1 = new JTextField();
        textField1.setBounds(250,180,150,30);
        panel.add(textField1);

        JLabel label2 = new JLabel();
        label2.setBounds(40,220,200,30);
        panel.add(label2);

        JTextField textField2 = new JTextField();
        textField2.setBounds(250,220,150,30);
        panel.add(textField2);

        JLabel label3 = new JLabel();
        label3.setBounds(40,260,200,30);
        panel.add(label3);

        JTextField textField3 = new JTextField();
        textField3.setBounds(250,260,150,30);
        panel.add(textField3);

        JLabel label4 = new JLabel();
        label4.setBounds(40,300,200,30);
        panel.add(label4);

        JTextField textField4 = new JTextField();
        textField4.setBounds(250,300,150,30);
        panel.add(textField4);

        comboBoxPaymentOption.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(comboBoxPaymentOption.getSelectedIndex() == 0)
                {
                    label.setText("Card Holder Name : ");
                    label1.setVisible(true);
                    label1.setText("Card Number : ");
                    textField1.setVisible(true);
                    label2.setVisible(true);
                    label2.setText("CVV : ");
                    textField2.setVisible(true);
                    label3.setVisible(true);
                    label3.setText("Expiry Date(MM/YYYY) : ");
                    textField3.setVisible(true);
                    label4.setText("Paid By : ");
                    textField4.setVisible(true);
                }
                else if(comboBoxPaymentOption.getSelectedIndex() ==1)
                {
                    label.setText("Number Of Notes : ");
                    label1.setVisible(true);
                    label1.setText("which Notes : ");
                    textField1.setVisible(true);
                    label2.setVisible(false);
                    textField2.setVisible(false);
                    label3.setVisible(false);
                    textField3.setVisible(false);
                    label4.setText("Paid By : ");
                    textField4.setVisible(true);
                }
                else if(comboBoxPaymentOption.getSelectedIndex() == 2)
                {
                    label.setText("Upi Id : ");
                    label1.setVisible(false);
                    textField1.setVisible(false);
                    label2.setVisible(false);
                    textField2.setVisible(false);
                    label3.setVisible(false);
                    textField3.setVisible(false);
                    label4.setText("Paid By : ");
                    textField4.setVisible(false);
                }
            }
        });

       comboBoxPaymentOption.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               if(comboBoxPaymentOption.getSelectedIndex() == 0)
               {
                   label.setText("Card Holder Name : ");
                   label1.setVisible(true);
                   label1.setText("Card Number : ");
                   textField1.setVisible(true);
                   label2.setVisible(true);
                   label2.setText("CVV : ");
                   textField2.setVisible(true);
                   label3.setVisible(true);
                   label3.setText("Expiry Date(MM/YYYY) : ");
                   textField3.setVisible(true);
                   label4.setVisible(true);
                   label4.setText("Paid By : ");
                   textField4.setVisible(true);
               }
               else if(comboBoxPaymentOption.getSelectedIndex() ==1)
               {
                   label.setText("Number Of Notes : ");
                   label1.setVisible(true);
                   label1.setText("which Notes : ");
                   textField1.setVisible(true);
                   label2.setVisible(false);
                   textField2.setVisible(false);
                   label3.setVisible(false);
                   textField3.setVisible(false);
                   label4.setText("Paid By : ");
                   textField4.setVisible(true);
               }
               else if(comboBoxPaymentOption.getSelectedIndex() == 2)
               {
                  label.setText("Upi Id : ");
                  label1.setVisible(false);
                  textField1.setVisible(false);
                  label2.setVisible(false);
                  textField2.setVisible(false);
                   label3.setVisible(false);
                   textField3.setVisible(false);
                   label4.setText("Paid By : ");
                   textField4.setVisible(true);
               }
           }
       });

       JTextArea textArea = new JTextArea("\n                                                 Engineer Foundation Hospital                             \n \n ");
       textArea.setBounds(450,100,500,350);
       panel.add(textArea);
       textArea.setVisible(false);

        JButton print = new JButton("Print");
        print.setBounds(630,470,100,20);
        panel.add(print);
        print.setVisible(false);
        print.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    textArea.print();
                    setVisible(false);
                }
                catch (Exception E)
                {
                    E.printStackTrace();
                }
            }
        });

        JButton paid = new JButton("Paid");
        paid.setBounds(270,400,100,30);
        panel.add(paid);
        paid.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!textField.getText().equals(""))
                {
                    String modeOfPayment = (String) comboBoxPaymentOption.getSelectedItem();
                    String paidBy = textField4.getText();
                    String bookingTime = labelSetDate.getText();

                    try
                    {
                        Conn conn = new Conn();
                        conn.statement.executeUpdate("insert into Confirmed_Payment values('"+patient+"','"+idNumber
                                +"','"+bookingTime+"','"+date+"','"+modeOfPayment+"','"+amount+"','"+doctor+"','"+paidBy+"')");
                    }

                    catch (Exception E)
                    {
                        E.printStackTrace();
                    }

                    textArea.setVisible(true);
                    print.setVisible(true);
                    textArea.setText(textArea.getText()+"\n                ********************************** Receipt *******************************           \n");
                    textArea.setText(textArea.getText()+"\n                                                                                  Booking Date : "+labelSetDate.getText());
                    textArea.setText(textArea.getText()+"\n\nHi "+patient+" (ID: "+idNumber+") "+", Your Payment has been Done through "+comboBoxPaymentOption.getSelectedItem()+" \nand, your appointment is confirmed.");
                    textArea.setText(textArea.getText()+"\n\n     Appointment Date : "+date+"\n\n     Doctor : "+doctor+"\n\n     Paid Amount : "+amount);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Please fill all the Fields");
                }
            }
        });

        JButton cancel = new JButton("Cancel");
        cancel.setBounds(100,400,100,30);
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
        setSize(1000,600);
        setLayout(null);
        setLocation(300,120);
        setVisible(true);
    }

    public static void main(String[] args)
    {
        new Payment("","","","","");
    }
}
