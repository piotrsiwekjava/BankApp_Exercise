package BankAppProject;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstView extends JFrame{
    private JButton registerYourAccountButton;
    private JPanel RootPanel;
    private JButton loginToYourAccountButton;


    public FirstView () {

        add(RootPanel);
        setTitle("Welcome in BT Bank system");
        setSize(500, 500);
        //zamkniecie okna aplikacji konczy proces
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        registerYourAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                RegisterForm registerForm = new RegisterForm();
                registerForm.setVisible(true);
            }
        });
        loginToYourAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                LoginForm loginForm = new LoginForm();
                loginForm.setVisible(true);
            }
        });
    }
}
