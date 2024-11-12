package hospital.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Urology extends JFrame
{
    JComboBox comboBox;
    JTextField textIdNumber,textPhoneNumber;
    JRadioButton r1,r2,r3;

    Urology() {

        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 990, 590);
        panel.setBackground(Color.PINK);
        panel.setLayout(null);
        add(panel);

        JLabel labelHeading = new JLabel("Appointment Booking for Urology Department");
        labelHeading.setBounds(300, 5, 300, 40);
        labelHeading.setForeground(Color.BLACK);
        panel.add(labelHeading);

        JLabel labelPatientName = new JLabel("Patient's Name : ");
        labelPatientName.setBounds(40, 60, 200, 25);
        panel.add(labelPatientName);

        JTextField textPatientName = new JTextField();
        textPatientName.setBounds(260, 60, 200, 25);
        panel.add(textPatientName);

        JLabel labelId = new JLabel("ID : ");
        labelId.setBounds(40, 100, 200, 25);
        panel.add(labelId);

        comboBox = new JComboBox(new String[]{"Aadhar Card", "Voter Id", "Driving License", "Passport"});
        comboBox.setBounds(260, 100, 200, 25);
        panel.add(comboBox);

        JLabel labelIdNumber = new JLabel("Id Number : ");
        labelIdNumber.setBounds(40, 140, 200, 25);
        panel.add(labelIdNumber);

        textIdNumber = new JTextField();
        textIdNumber.setBounds(260, 140, 200, 25);
        panel.add(textIdNumber);

        JLabel labelGender = new JLabel("Gender : ");
        labelGender.setBounds(40, 180, 200, 25);
        panel.add(labelGender);

        r1 = new JRadioButton("Male");
        r1.setBounds(260, 180, 80, 25);
        panel.add(r1);

        r2 = new JRadioButton("Female");
        r2.setBounds(345, 180, 80, 25);
        panel.add(r2);

        r3 = new JRadioButton("Other");
        r3.setBounds(430, 180, 80, 25);
        panel.add(r3);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(r1);
        buttonGroup.add(r2);
        buttonGroup.add(r3);

        JLabel labelPhoneNumber = new JLabel("Phone Number : ");
        labelPhoneNumber.setBounds(40, 220, 200, 25);
        panel.add(labelPhoneNumber);

        textPhoneNumber = new JTextField();
        textPhoneNumber.setBounds(260, 220, 200, 25);
        panel.add(textPhoneNumber);

        JLabel labelDepartment = new JLabel("Department");
        labelDepartment.setBounds(40, 260, 200, 25);
        panel.add(labelDepartment);

        JLabel department = new JLabel();
        department.setBounds(260, 260, 200, 25);
        panel.add(department);

        try {
            Conn conn = new Conn();
            ResultSet resultSet = conn.statement.executeQuery("select * from Doctor where department = 'Urology'");
            while (resultSet.next()) {
                department.setText(resultSet.getString("department"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel labelDoctor = new JLabel("Doctor : ");
        labelDoctor.setBounds(40, 300, 200, 25);
        panel.add(labelDoctor);

        Choice choice = new Choice();
        choice.setBounds(260, 300, 200, 25);
        panel.add(choice);

        try {
            Conn conn = new Conn();
            ResultSet resultSet = conn.statement.executeQuery("select * from Doctor where department = 'Urology'");
            while (resultSet.next()) {
                choice.add(resultSet.getString("name"));
            }
        } catch (Exception E) {
            E.printStackTrace();
        }

        JLabel labelAvailability = new JLabel("Availability(In Days)");
        labelAvailability.setBounds(40, 340, 200, 25);
        panel.add(labelAvailability);

        JLabel labelSetAvailability = new JLabel();
        labelSetAvailability.setBounds(260, 340, 200, 25);
        panel.add(labelSetAvailability);

        JLabel labelAppointment = new JLabel("Appointment Date : ");
        labelAppointment.setBounds(40, 380, 200, 25);
        panel.add(labelAppointment);

        JDateChooser dateChooser = new JDateChooser();
        dateChooser.setBounds(260, 380, 200, 25);
        panel.add(dateChooser);

        JLabel labelFees = new JLabel("Fees : ");
        labelFees.setBounds(40, 420, 200, 25);
        panel.add(labelFees);

        JLabel labelSetFees = new JLabel();
        labelSetFees.setBounds(260, 420, 200, 25);
        panel.add(labelSetFees);

        choice.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Conn conn = new Conn();
                    ResultSet resultSet = conn.statement.executeQuery("select * from Doctor where name = '" + choice.getSelectedItem() + "'");
                    while (resultSet.next()) {
                        labelSetAvailability.setText(resultSet.getString("availability"));
                        labelSetFees.setText(resultSet.getString("fees"));

                    }
                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        choice.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                try {
                    Conn conn = new Conn();
                    ResultSet resultSet = conn.statement.executeQuery("select * from Doctor where name = '" + choice.getSelectedItem() + "'");
                    while (resultSet.next()) {
                        labelSetAvailability.setText(resultSet.getString("availability"));
                        labelSetFees.setText(resultSet.getString("fees"));

                    }
                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        JButton pay = new JButton("Pay");
        pay.setBounds(400, 500, 100, 30);
        pay.setBackground(Color.YELLOW);
        pay.setForeground(Color.BLACK);
        panel.add(pay);
        pay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String patient = textPatientName.getText();
                String doctor = choice.getSelectedItem();
                String id = (String) comboBox.getSelectedItem();
                String idNumber = textIdNumber.getText();
                String radioButton = "";
                if (r1.isSelected()) {
                    radioButton = "Male";
                } else if (r2.isSelected()) {
                    radioButton = "Female";
                } else if (r3.isSelected()) {
                    radioButton = "Other";
                }
                String gender = radioButton;
                String phoneNumber = textPhoneNumber.getText();
                String department1 = department.getText();
                String amount = labelSetFees.getText();
                String date = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();

                if (patient.equals("") || idNumber.equals("") || date.equals("") || phoneNumber.equals("")) {
                    JOptionPane.showMessageDialog(null, "Fill all The Details");
                } else {
                    try {
                        Conn conn = new Conn();
                        conn.statement.executeUpdate("insert into Appointment_Confirmed values('" + patient + "','" + id
                                + "','" + idNumber + "','" + gender + "','" + phoneNumber + "','" + department1
                                + "','" + doctor + "','" + date + "')");
                        new Payment(patient, doctor, amount, date, idNumber);
                        setVisible(false);
                    } catch (Exception E) {
                        E.printStackTrace();
                    }
                }
            }
        });

        JButton cancel = new JButton("Cancel");
        cancel.setBounds(200, 500, 100, 30);
        cancel.setBackground(Color.YELLOW);
        cancel.setForeground(Color.BLACK);
        panel.add(cancel);
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setSize(1000, 600);
        setLayout(null);
        setLocation(250, 100);
        setVisible(true);

    }

    public static void main(String[] args)
    {
        new Urology();
    }
}
