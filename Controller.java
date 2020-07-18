package BankAppProject;


import javax.swing.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Controller {

    BankAppProject.DBConnect dao = new DBConnect();
    public char[] listChar = {'!', '@', '#', '`', '$', '%', '^', '&', '*', '(', ')', '_', '-', '=', '+', '{', '}', '[', ']', ';', ':', '"', '<', '<', ',', '>', '.', '/', '?', '|', '`'};
    public char[] listChar2 = {'!', '@', '#', '`', '$', '%', '^', '&', '*', '(', ')', '_', '-', '=', '+', '{', '}', '[', ']', ';', ':', '"', '<', '<', '>', '/', '?', '|', '`'};
    public char[] listABC = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'w', 'v', 'x', 'y', 'z'};
    public char[] listPOL = {'ą', 'ć', 'ę', 'ł', 'ń', 'ó', 'ż', 'ź'};
    public char[] list123 = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};

    public void addAccount(String loginName, String nameF, String nameL, String accountNumber, String country, String address, String phone, String gender, String password) throws SQLException {

        String sql = "INSERT INTO actab(LoginName, FirstName, LastName, AccountNumber, Funds, Country, Address, Phone, Gender, Password) VALUES (?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement pst = dao.getCon().prepareStatement(sql);
        pst.setString(1, loginName);
        pst.setString(2, nameF);
        pst.setString(3, nameL);
        pst.setString(4, accountNumber);
        pst.setDouble(5, 0);
        pst.setString(6, country);
        pst.setString(7, address);
        pst.setString(8, phone);
        pst.setString(9, gender);
        pst.setString(10, password);
        pst.execute();
        pst.close();

        int dialogButton = JOptionPane.YES_NO_OPTION;
        int chooseSide = JOptionPane.showConfirmDialog(null, "Would You Like to register Your Account?", "Warning", dialogButton);

        if (chooseSide == 0) {
            dao.getCon().commit();
            JOptionPane.showMessageDialog(null, "Hello " + nameF + " " + nameL + "!" + "\n" + "Your Login is " + loginName + "." + "\n" + "You can login now.");

        } else {
            dao.getCon().rollback();
        }

    }

    public void pokaz() throws SQLException {

        Statement st = dao.getCon().createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM kontakty");
        while (rs.next()) {
            System.out.println(rs.getInt("ID") + " " + rs.getString("imie") + " " + rs.getString("nazwisko") + " " + rs.getString("telefon"));
        }
        st.close();
    }

    public int lookingForLogin(String fraza) throws SQLException {

        int look = 0;
        Statement st = dao.getCon().createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM actab");

        while (rs.next()) {
            if (rs.getString("LoginName").equals(fraza))
                look++;
        }
        st.close();

        return look;

    }

    public int lookingForAccountNumber(String fraza) throws SQLException {
        int look = 0;
        Statement st = dao.getCon().createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM actab");

        while (rs.next()) {
            if (rs.getString("AccountNumber").equals(fraza))
                look++;
        }
        st.close();

        return look;

    }

    public int getID(String login) throws SQLException {
        Statement st = dao.getCon().createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM actab where LoginName = '" + login + "'");
        int str = 0;
        while (rs.next()) {
            str = rs.getInt("ID");
        }
        st.close();
        return str;
    }

    public String getNameF(String login) throws SQLException {
        Statement st = dao.getCon().createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM actab where LoginName = '" + login + "'");
        String str = "null";
        while (rs.next()) {
            str = rs.getString("FirstName");
        }
        st.close();
        return str;
    }

    public String getNameL(String login) throws SQLException {
        Statement st = dao.getCon().createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM actab where LoginName ='" + login + "'");
        String str = "null";
        while (rs.next()) {
            str = rs.getString("LastName");
        }
        st.close();
        return str;
    }

    public String getAccountNumber(String login) throws SQLException {
        Statement st = dao.getCon().createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM actab where LoginName ='" + login + "'");
        String str = "null";
        while (rs.next()) {
            str = rs.getString("AccountNumber");
        }
        st.close();
        return str;
    }

    public String getFunds(String login) throws SQLException {
        Statement st = dao.getCon().createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM actab where LoginName ='" + login + "'");
        String str = "null";
        while (rs.next()) {
            str = String.valueOf(rs.getDouble("Funds"));
        }
        st.close();
        return str;
    }

    public String getCountry(String login) throws SQLException {
        Statement st = dao.getCon().createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM actab where LoginName ='" + login + "'");
        String str = "null";
        while (rs.next()) {
            str = rs.getString("Country");
        }
        st.close();
        return str;
    }

    public String getAddress(String login) throws SQLException {
        Statement st = dao.getCon().createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM actab where LoginName ='" + login + "'");
        String str = "null";
        while (rs.next()) {
            str = rs.getString("Address");
        }
        st.close();
        return str;
    }

    public String getPhone(String login) throws SQLException {
        Statement st = dao.getCon().createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM actab where LoginName ='" + login + "'");
        String str = "null";
        while (rs.next()) {
            str = rs.getString("Phone");
        }
        st.close();
        return str;
    }

    public String getGender(String login) throws SQLException {
        Statement st = dao.getCon().createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM actab where LoginName ='" + login + "'");
        String str = "null";
        while (rs.next()) {
            str = rs.getString("Gender");
        }
        st.close();
        return str;
    }

    public String getPassword(String login) throws SQLException {
        Statement st = dao.getCon().createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM actab where LoginName ='" + login + "'");
        String str = "null";
        while (rs.next()) {
            str = rs.getString("Password");
        }
        st.close();
        return str;
    }

    public void setPassword(String newPass, String login) throws SQLException {
        String sql = "UPDATE `ba`.`actab` SET `Password` = '" + newPass + "' WHERE (`LoginName` = '" + login + "');";
        System.out.println(newPass);
        PreparedStatement pst = dao.getCon().prepareStatement(sql);
        pst.execute();
        pst.close();
        dao.getCon().commit();
    }

    public void loginToAccount(String login, String password) throws SQLException {
        Statement st = dao.getCon().createStatement();
        int check = 0;
        ResultSet rs = st.executeQuery("SELECT * FROM actab where LoginName = '" + login + "' and Password ='" + password + "'");
        while (rs.next()) {
            if (!rs.getString("LoginName").equals("")) {
                AcPanel acPanel = new AcPanel(rs.getString("LoginName"));
                acPanel.setVisible(true);
                check = 1;
            }
        }
        if (check == 0) {
            LoginForm loginForm = new LoginForm();
            loginForm.setVisible(true);
            JOptionPane.showMessageDialog(null, "Wrong user's login or password!");
        }
        st.close();
    }

    public void addTransfer(String login, int idAc, String amount, String fName, String fNum, String fundsB, String fundsA, String toName, String toNum, String title) throws SQLException {
        Date datesystem = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-mm-dd HH:mm:ss");
        String time = simpleDateFormat.format(datesystem);

        String sql = "INSERT INTO transfers(idAccount, Value, FromName, FromNumber, FundsBef, FundsAft, ToName, ToNumber, Date, Title) VALUES (?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement pst = dao.getCon().prepareStatement(sql);
        pst.setInt(1, idAc);
        pst.setString(2, amount);
        pst.setString(3, fName);
        pst.setString(4, fNum);
        pst.setString(5, fundsB);
        pst.setString(6, fundsA);
        pst.setString(7, toName);
        pst.setString(8, toNum);
        pst.setString(9, time);
        pst.setString(10, title);
        pst.execute();
        pst.close();
        String sql2 = "UPDATE `ba`.`actab` SET `Funds` = '" + fundsA + "' WHERE (`LoginName` = '" + login + "');";
        PreparedStatement pst2 = dao.getCon().prepareStatement(sql2);
        pst2.execute();
        pst2.close();

        int dialogButton = JOptionPane.YES_NO_OPTION;
        int chooseSide = JOptionPane.showConfirmDialog(null, "Accept the transfer?", "Accept", dialogButton);

        if (chooseSide == 0) {
            dao.getCon().commit();
            JOptionPane.showMessageDialog(null, "The transfer was successful.");

        } else {
            dao.getCon().rollback();
            JOptionPane.showMessageDialog(null, "The transfer was denied.");
        }

    }

    public ArrayList<Transfer> getHistory(String id) throws SQLException {
        ArrayList<Transfer> transList = new ArrayList<>();
        transList.clear();
        Statement st = dao.getCon().createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM transfers where idaccount = '" + id + "'");
        while (rs.next()) {
            Transfer transfer = new Transfer(rs.getString("ToName"), rs.getString("ToNumber"), rs.getString("Value"), rs.getString("FundsAft"), rs.getString("Date"));
            transList.add(transfer);
        }
        st.close();
        return transList;
    }

    public int getCheck(String str, char cha) {
        int k = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == cha) {
                k++;
            }
        }
        return k;
    }
    public String getMinusSpecial(String str) {
        int check = 0;
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < listChar2.length; j++) {
                if (str.charAt(i) == listChar2[j]) {
                    check = 1;

                }
            }
        }
        if (check == 1) {

            for (int i = 0; i < str.length(); i++) {
                for (int j = 0; j < listChar2.length; j++) {
                    if (str.charAt(i) == listChar2[j]) {
                        str.replace("i", "");
                        System.out.println("Znaki specjalne usunięte");
                        check = 0;

                    }
                }
            }

        }
        return str;
    }
    public int getCheckNumber (String str) {
        int n = 0;
        for (int i = 0; i < str.length(); i++) {
            for (int k = 0; k < listABC.length; k++) {
                if (str.charAt(i) == listABC[k]) {
                    n=1;
                }
            }
        }
        return n;
    }public int getCheckABC (String str) {
        int n = 0;
        for (int i = 0; i < str.length(); i++) {
            for (int k = 0; k < list123.length; k++) {
                if (str.charAt(i) == list123[k]) {
                    n=1;
                }
            }
        }
        return n;
    }
}
