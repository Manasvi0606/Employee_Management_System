package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main_class extends JFrame {

    Main_class(){

         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/Home.png"));
         Image i2 = i1.getImage().getScaledInstance(1120,630, Image.SCALE_SMOOTH);
         ImageIcon i3 = new ImageIcon(i2);
         JLabel img = new JLabel(i3);
         img.setBounds(0,0,1120,630);
         add(img);

         JLabel heading = new JLabel("Employee Management System");
         heading.setBounds(358,95,400,40);
         heading.setFont(new Font("Montserrat", Font.BOLD, 23));
         heading.setForeground(Color.WHITE);
         img.add(heading);

         JButton add = new JButton("Add Employee");
         add.setBounds(315,210,180,40);
         add.setFont(new Font("Montserrat", Font.BOLD, 16 ));
         add.setBackground(Color.WHITE);

         add.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 new AddEmployee();
                 setVisible(false);
             }
         });
         img.add(add);

        JButton view = new JButton("View Employee");
        view.setBounds(615,210,180,40);
        view.setFont(new Font("Montserrat", Font.BOLD, 16 ));
        view.setBackground(Color.WHITE);

        view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new View_Employee();
                setVisible(false);

            }
        });
        img.add(view);

        JButton rem = new JButton("Remove Employee");
        rem.setBounds(465,320,180,40);
        rem.setFont(new Font("Montserrat", Font.BOLD, 14));
        rem.setBackground(Color.WHITE);

        rem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RemoveEmployee();

            }
        });
        img.add(rem);






        setSize(1120,630);
        setLocation(250,100);
        setLayout(null);
        setVisible(true);

    }

    public static void main(String[] args) {
        new Main_class();

    }
}
