package BankAppProject;

import jdk.dynalink.Operation;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

public class LoginForm extends JFrame{
    private JPanel RootPanel;
    private JTextField userName;
    private JButton clickHereToLoginButton;
    private JPasswordField passwordField1;
    private JLabel loginSet;
    private JTable table1;

    public LoginForm () {

        add(RootPanel);
        setTitle("Log in to the Your Bank Account");
        setSize(400,300);
        //zamkniecie okna aplikacji konczy proces
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        loginSet.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                dispose();
                RegisterForm registerForm = new RegisterForm();
                registerForm.setVisible(true);

            }
        });
        loginSet.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                loginSet.setText("Click");
            }
        });
        loginSet.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                loginSet.setText(">>No Account? Create One!");
            }
        });
        clickHereToLoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Controller controller = new Controller();
                String pass = String.valueOf(passwordField1.getPassword());
                try {
                    controller.loginToAccount(userName.getText(),pass);
                    dispose();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                    userName.setText("");
                }

            }
        });
    }
}
