package employee.management.system;

import com.toedter.calendar.JDateChooser;

import javax.sound.midi.Sequence;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

public class AddEmployee extends JFrame implements ActionListener {

//    Random ran = new Random();
//    int number = ran.nextInt(999999);


    //sequentially generates a employeID
    int number;

    public  int getEmployeeId(){
        int id =0 ;
        try{
            conn c = new conn();
            String query = "Select MAX(empID) from employee";
            ResultSet rs = c.statement.executeQuery(query);
            if(rs.next()) {
                id = rs.getInt(1);
            }

        } catch (Exception e) {
//            throw new RuntimeException(e);
            e.printStackTrace();
        }
        return id;
    }


    //function to make aadhar maskedd
    public String maskAadharNumber(String aadhar) {
        if (aadhar.length() >= 4) {
            // Mask all but the last 4 digits
            String lastFourDigits = aadhar.substring(aadhar.length() - 4);
            String masked = "**** **** " + lastFourDigits;  // Assuming a 12-digit Aadhar format
            return masked;
        } else {
            return aadhar; // In case the input is less than 4 characters
        }
    }

    JTextField tname,tfname, taddress,tphone,taadhar, temail, tsalary, tdesignation;

    JLabel tempid;

    JDateChooser  tdob;

    JComboBox Boxeducation;

    JButton add,back;


    AddEmployee(){
        getContentPane().setBackground(new Color(134, 167, 252));

        JLabel heading = new JLabel("Add Employee Detail");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("Poppins", Font.BOLD, 25));
        add(heading);

        JLabel name = new JLabel("Name : ");
        name.setBounds(50,150,150,30);
        name.setFont(new Font("SAN_SERIF" , Font.BOLD, 15));
        add(name);

        tname = new JTextField();
        tname.setBounds(200,150,150,30);
        tname.setBackground(new Color(243, 248, 255));
        add(tname);


        JLabel fname = new JLabel("Father's Name : ");
        fname.setBounds(400,150,150,30);
        fname.setFont(new Font("SAN_SERIF" , Font.BOLD, 15));
        add(fname);

        tfname = new JTextField();
        tfname.setBounds(600,150,150,30);
        tfname.setBackground(new Color(243, 248, 255));
        add(tfname);


        JLabel dob = new JLabel("Date Of Birth : ");
        dob.setBounds(50,200,150,30);
        dob.setFont(new Font("SAN_SERIF" , Font.BOLD, 15));
        add(dob);

        tdob = new JDateChooser();
        tdob.setBounds(200,200,150,30);
        tdob.setBackground(new Color(243, 248, 255));
        add(tdob);


        JLabel salary = new JLabel("Salary : ");
        salary.setBounds(400,200,150,30);
        salary.setFont(new Font("SAN_SERIF" , Font.BOLD, 15));
        add(salary);

        tsalary = new JTextField();
        tsalary.setBounds(600,200,150,30);
        tsalary.setBackground(new Color(243, 248, 255));
        add(tsalary);


        JLabel address = new JLabel("Address : ");
        address.setBounds(50,250,150,30);
        address.setFont(new Font("SAN_SERIF" , Font.BOLD, 15));
        add(address);

        taddress = new JTextField();
        taddress.setBounds(200,250,150,30);
        taddress.setBackground(new Color(243, 248, 255));
        add(taddress);


        JLabel phone = new JLabel("Phone : ");
        phone.setBounds(400,250,150,30);
        phone.setFont(new Font("SAN_SERIF" , Font.BOLD, 15));
        add(phone);

        tphone = new JTextField();
        tphone.setBounds(600,250,150,30);
        tphone.setBackground(new Color(243, 248, 255));
        add(tphone);


        JLabel email = new JLabel("Email : ");
        email.setBounds(50,300,150,30);
        email.setFont(new Font("SAN_SERIF" , Font.BOLD, 15));
        add(email);

        temail = new JTextField();
        temail.setBounds(200,300,150,30);
        temail.setBackground(new Color(243, 248, 255));
        add(temail);


        JLabel education = new JLabel("Highest Education : ");
        education.setBounds(400,300,150,30);
        education.setFont(new Font("SAN_SERIF" , Font.BOLD, 15));
        add(education);

        String items[] = {"BBA" , "B.Tech" , "BCA" , "BA" , "B.Sc" , "B.COM" , "MBA" , "MCA", "MA" , "MTech", "M.Sc" , "PhD"};
        Boxeducation = new JComboBox(items);
        Boxeducation.setBackground(new Color(243, 248, 255));
        Boxeducation.setBounds(600,300,150,30);
        add(Boxeducation);


        JLabel aadhar = new JLabel("Aadhar Number : ");
        aadhar.setBounds(400,350,150,30);
        aadhar.setFont(new Font("SAN_SERIF" , Font.BOLD, 15));
        add(aadhar);

        taadhar = new JTextField();
        taadhar.setBounds(600,350,150,30);
        taadhar.setBackground(new Color(243, 248, 255));
        add(taadhar);


        JLabel empid = new JLabel("Employee ID : ");
        empid.setBounds(50,400,150,30);
        empid.setFont(new Font("SAN_SERIF" , Font.BOLD, 15));
        add(empid);


        number = getEmployeeId() + 1;
        tempid = new JLabel(""+number);
        tempid.setBounds(200,400,150,30);
        tempid.setFont(new Font("SAN_SERIF" , Font.BOLD, 16));
        tempid.setForeground(new Color(39, 0, 130));
        add(tempid);


        JLabel designation = new JLabel("Designation : ");
        designation.setBounds(50,350,150,30);
        designation.setFont(new Font("SAN_SERIF" , Font.BOLD, 15));
        add(designation);

        tdesignation = new JTextField();
        tdesignation.setBounds(200,350,150,30);
        tdesignation.setBackground(new Color(243, 248, 255));
        add(tdesignation);


        add= new JButton("ADD"); //BACK
        add.setBounds(450, 500, 150, 40);
        add.setBackground(new Color(39, 0, 130));
        add.setFont(new Font("Montserrat" , Font.BOLD, 15));
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);


        back= new JButton("BACK");  //ADD
        back.setBounds(250, 500, 150, 40);
        back.setBackground(new Color(39, 0, 130));
        back.setFont(new Font("Montserrat" , Font.BOLD, 15));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);



        setSize(900,700);
        setLayout(null);
        setLocation(300,50);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == add){
            String name = tname.getText();
            String fname = tfname.getText();
            String dob = ((JTextField) tdob.getDateEditor().getUiComponent()).getText();
            String salary = tsalary.getText();
            String address = taddress.getText();
            String aadhar = taadhar.getText();
            String phone = tphone.getText();
            String email = temail.getText();
            String education = (String) Boxeducation.getSelectedItem();
            String designation = tdesignation.getText();
            String empID = tempid.getText();
            String maskedAadhar = maskAadharNumber(aadhar);  /*<-------Maskedd Adhaar---------->*/

            try{
                conn c = new conn();
                String query = "insert into employee values('"+name+"', '"+fname+"', '"+dob+"', '"+salary+"', '"+address+"', '"+phone+"', '"+email+"', '"+education+"', '"+designation+"', '"+maskedAadhar+"' ,'"+empID+"')";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details added successfully!");
                setVisible(false);
                new Main_class();

            }catch (Exception E){
                E.printStackTrace();
            }

        }
        else{
            setVisible(false);
            new Main_class();
        }

    }

    public static void main(String[] args) {
        new AddEmployee();
    }
}
