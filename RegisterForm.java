package BankAppProject;

import BL.Rezerwacja;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

public class RegisterForm extends JFrame{
    private JTextField firstName;
    private JTextField lastName;
    private JComboBox country;
    private JTextField address;
    private JTextField phone;
    private JRadioButton maleRadioButton;
    private JPasswordField passwordField1;
    private JPasswordField passwordField2;
    private JPanel RootPanel;
    private JButton clickHereToRegisterButton;
    private JRadioButton famaleRadioButton;
    private JLabel loginSet;
    private String loginN;
    private String accountNumberN;
    private String genderChoose;

    public RegisterForm (){

        add(RootPanel);
        setTitle("Register Your Account");
        setSize(500, 700);
        //zamkniecie okna aplikacji konczy proces
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        loginSet.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                dispose();
                LoginForm loginForm = new LoginForm();
                loginForm.setVisible(true);
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
                
                loginSet.setText(">>Already have an Account? Login.");
            }
        });
        maleRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (maleRadioButton.isSelected()) {
                    genderChoose="male";
                    famaleRadioButton.setSelected(false);
                } else {
                    maleRadioButton.setSelected(true);
                }
            }
        });
        famaleRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (famaleRadioButton.isSelected()) {
                    genderChoose = "famale";
                    maleRadioButton.setSelected(false);
                } else {
                    famaleRadioButton.setSelected(true);
                }
            }
        });
        clickHereToRegisterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pass1 = String.valueOf(passwordField1.getPassword());
                System.out.println(pass1);
                String pass2 = String.valueOf(passwordField2.getPassword());
                if (firstName.getText().equals("") || firstName.getText().equals("First name")) {
                    JOptionPane.showMessageDialog(rootPane, "Please give the first name.");
                } else if (lastName.getText().equals("") || lastName.getText().equals("Last name")) {
                    JOptionPane.showMessageDialog(rootPane, "Please give the last name.");
                } else if (country.getSelectedItem() == ("")) {
                    JOptionPane.showMessageDialog(rootPane, "Please choose the country.");
                } else if (address.getText().equals("")) {
                    JOptionPane.showMessageDialog(rootPane, "Please give the address.");
                } else if (phone.getText().equals("")) {
                    JOptionPane.showMessageDialog(rootPane, "Please give the phone number.");
                } else if (pass1.length()<8 || pass1.equals("")||!pass1.equals(pass2)) {
                    JOptionPane.showMessageDialog(rootPane, "Please give the right password. Minimum eight charakters");
                }
                else {
                    Controller controller = new Controller();
                    while(true) {

                        loginN = getdrawLogin(firstName.getText(), lastName.getText());
                        try {
                            if (controller.lookingForLogin(loginN)==0){
                                break;
                            }
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }

                    }
                    while(true){
                        accountNumberN=getdraw26();
                        try {
                            if (controller.lookingForAccountNumber(accountNumberN)==0){
                                break;
                            }
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                    }
                    if (controller.getCheckNumber(phone.getText())>0){
                        JOptionPane.showMessageDialog(null,"Wrong phone number!");
                    }
                    else if (controller.getCheckABC(firstName.getText())>0 || controller.getCheckABC(lastName.getText())>0 || firstName.getText().equals("") || lastName.getText().equals("") || firstName.getText().length()<2 || lastName.getText().length()<2){
                        JOptionPane.showMessageDialog(null,"Wrong name");
                    }

                    else{
                        try {
                            controller.addAccount(loginN,controller.getMinusSpecial(firstName.getText()),controller.getMinusSpecial(lastName.getText()),accountNumberN,controller.getMinusSpecial(country.getSelectedItem().toString()),address.getText(),controller.getMinusSpecial(phone.getText()),genderChoose,String.valueOf(passwordField1.getPassword()));
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                    }

                    //czyszczenie formularza
                    firstName.setText("");
                    lastName.setText("");
                    country.setSelectedIndex(0);
                    address.setText("");
                    phone.setText("");
                    maleRadioButton.setSelected(false);
                    famaleRadioButton.setSelected(false);
                    passwordField1.setText("");
                    passwordField2.setText("");

                }

            }
        });
    }
    public String getdrawLogin(String nameF, String nameL){
        int drawNum = new Random().nextInt(998)+1;
        String login=nameF.charAt(0)+nameL+drawNum;
        for (int i=0;i<login.length();i++){
            login=login.replace("ą", "a");
            login=login.replace("ć", "c");
            login=login.replace("ę", "e");
            login=login.replace("ł", "l");
            login=login.replace("ń", "n");
            login=login.replace("ó", "o");
            login=login.replace("ś", "s");
            login=login.replace("ź", "z");
            login=login.replace("ż", "z");
            login=login.replace("Ą", "A");
            login=login.replace("Ć", "C");
            login=login.replace("Ę", "E");
            login=login.replace("Ł", "L");
            login=login.replace("Ń", "N");
            login=login.replace("Ó", "O");
            login=login.replace("Ś", "S");
            login=login.replace("Ź", "Z");
            login=login.replace("Ż", "Z");
        }
        return login;
    }
    public String getdraw26 () {
        int[] drawNums = new int[26];
        String listdraw = new String();
            drawNums[0] = 1;
            drawNums[1] = 4;
            drawNums[2] = new Random().nextInt(10);
            drawNums[3] = new Random().nextInt(10);
            drawNums[4] = new Random().nextInt(10);
            drawNums[5] = new Random().nextInt(10);
            drawNums[6] = new Random().nextInt(10);
            drawNums[7] = new Random().nextInt(10);
            drawNums[8] = new Random().nextInt(10);
            drawNums[9] = new Random().nextInt(10);
            drawNums[10] = new Random().nextInt(10);
            drawNums[11] = new Random().nextInt(10);
            drawNums[12] = new Random().nextInt(10);
            drawNums[13] = new Random().nextInt(10);
            drawNums[14] = new Random().nextInt(10);
            drawNums[15] = new Random().nextInt(10);
            drawNums[16] = new Random().nextInt(10);
            drawNums[17] = new Random().nextInt(10);
            drawNums[18] = new Random().nextInt(10);
            drawNums[19] = new Random().nextInt(10);
            drawNums[20] = new Random().nextInt(10);
            drawNums[21] = new Random().nextInt(10);
            drawNums[22] = new Random().nextInt(10);
            drawNums[23] = new Random().nextInt(10);
            drawNums[24] = new Random().nextInt(10);
            drawNums[25] = new Random().nextInt(10);
            String num;
            for (int i = 0; i < drawNums.length; i++) {
                num = String.valueOf(drawNums[i]);
                listdraw += num;
            }
        return listdraw;
    }
    public void setRegisterToLogin(){
        dispose();
        LoginForm loginForm = new LoginForm();
        loginForm.setVisible(true);

    }
}
