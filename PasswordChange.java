package BankAppProject;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class PasswordChange extends JFrame{
    private JPanel Rootpanel;
    private JPasswordField passwordField1;
    private JPasswordField passwordField2;
    private JPasswordField passwordField3;
    private JButton acceptButton;
    private JButton closeButton;

    public PasswordChange (Controller controller, String login) throws SQLException {
        add(Rootpanel);
        setTitle("Change Password");
        setSize(400, 300);

        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        acceptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String p1=String.valueOf(passwordField1.getPassword());
                String p2=String.valueOf(passwordField2.getPassword());
                String p3=String.valueOf(passwordField3.getPassword());
                try {
                    if (controller.getPassword(login).equals(p1) && !p2.equals("") && p2.equals(p3) && p2.length()>=8){

                        controller.setPassword(p2,login);
                        JOptionPane.showMessageDialog(null,"Password has been changed");
                        dispose();
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"Wrong password");
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
    }
}
