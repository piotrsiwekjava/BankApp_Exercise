package BankAppProject;

import BL.Rezerwacja;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AcPanel extends JFrame{
    private JButton LOGOUTButton;
    private JPanel RootPanel;
    private JTabbedPane tabbedPane1;
    private JLabel loginCall;
    private JLabel numberCall;
    private JLabel fundsValue;
    private JTable table1;
    private JButton changePasswordButton;
    private JLabel nameFCall;
    private JLabel nameLCall;
    private JLabel countryCall;
    private JLabel addressCall;
    private JLabel phoneCall;
    private JLabel genderCall;
    private JTextField recipientData;
    private JTextField recipientNumber;
    private JTextField titleText;
    private JTextField amountText;
    private JButton letSDoItButton;


    public AcPanel (String login) throws SQLException {
        add(RootPanel);
        setTitle("Welcome in BT Bank system");
        setSize(1000, 600);
        //zamkniecie okna aplikacji konczy proces
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Controller controller = new Controller();
        loginCall.setText(login);
        nameFCall.setText(controller.getNameF(login));
        nameLCall.setText(controller.getNameL(login));
        numberCall.setText(controller.getAccountNumber(login));
        fundsValue.setText(controller.getFunds(login));
        countryCall.setText(controller.getCountry(login));
        addressCall.setText(controller.getAddress(login));
        phoneCall.setText(controller.getPhone(login));
        genderCall.setText(controller.getGender(login));

        DefaultTableModel model = new DefaultTableModel();
        table1.setFillsViewportHeight(true);
        table1.setAutoCreateRowSorter(true);
        table1.setPreferredScrollableViewportSize(new Dimension(700, 700));
        model.addColumn("Recipient's name");
        model.addColumn("Recipient's account");
        model.addColumn("Value");
        model.addColumn("Funds after");
        model.addColumn("Date");
        table1.setModel(model);

        transferList(model,controller,login);

        changePasswordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PasswordChange passwordChange = null;
                try {
                    passwordChange = new PasswordChange(controller,login);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                passwordChange.setVisible(true);

            }
        });
        LOGOUTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Goodbye");
                dispose();
                LoginForm loginForm = new LoginForm();
                loginForm.setVisible(true);
            }
        });
        letSDoItButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String amountDat =amountText.getText().replace(',','.').trim();
                int check = controller.getCheck(amountDat,'.');
                int checkNumber = controller.getCheckNumber(recipientNumber.getText());
                amountDat = controller.getMinusSpecial(amountDat);
                if (controller.getCheckNumber(amountDat)>0 || check>1){
                    JOptionPane.showMessageDialog(null,"Wrong amount!");
                }
                else {
                    try {
                        String strfunds = controller.getFunds(login);
                        double dbfunds = Double.parseDouble(strfunds);
                        double dbvalue = Double.parseDouble(amountDat);
                        double dbfundsAfter = dbfunds - dbvalue;
                        String fundsAfter = String.valueOf(dbfundsAfter);
                        if (checkNumber > 0 || recipientNumber.getText().length() != 26) {
                            JOptionPane.showMessageDialog(null, "Wrong account number");
                        } else if (dbfunds >= dbvalue) {

                            if (check <= 1) {
                                controller.addTransfer(login, controller.getID(login), controller.getMinusSpecial(amountDat), controller.getNameF(login) + "-" + controller.getNameL(login), controller.getAccountNumber(login), strfunds, fundsAfter, controller.getMinusSpecial(recipientData.getText()), controller.getMinusSpecial(recipientNumber.getText()), titleText.getText());

                            } else {
                                JOptionPane.showMessageDialog(null, "Wrong amount!");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "You have no enough funds.");
                        }
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }
                amountText.setText("");
                recipientData.setText("");
                recipientNumber.setText("");
                titleText.setText("");
            }
        });

    }
    public void transferList(DefaultTableModel model, Controller controller, String login) throws SQLException {
        int rowCount = model.getRowCount();
        for (int i=rowCount -1; i>=0;i--){
            model.removeRow(i);
        }

        ArrayList<Transfer>transList=controller.getHistory(String.valueOf(controller.getID(login)));

        for (Transfer transfer : transList) {
            model.addRow(new Object[] {
                    transfer.getRecName(),transfer.getRecANum(),transfer.getValuE(),transfer.getFunAf(),transfer.getDatT()
            });
        }
    }
}

