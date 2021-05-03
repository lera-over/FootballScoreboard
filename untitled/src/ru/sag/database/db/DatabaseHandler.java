package ru.sag.database.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseHandler extends Configs {
    Connection dbConnection;

    public Connection getDbConnection()
            throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://"
                 +  dbHost + ":" + dbPort + "/" + dbName;

        Class.forName("com.mysql.cj.jdbc.Driver");

        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        return dbConnection;
    }
    public void signUpEnrollee(User user) {
        String insert = "INSERT INTO " + Const.AB_TABLE + "(" + Const.ABS_SURNAME + "," + Const.ABS_FIRSTNAME
                + "," + Const.ABS_PATRONYMIC + "," + Const.ABS_DOB+ "," + Const.ABS_NUMBER + ","
                + Const.ABS_REGISTRATION + "," + Const.ABS_ADDRESS + "," + Const.ABS_PASSPORTDATA + ","
                + Const.ABS_AVERAGESCORE + " ," + Const.ABS_SPECIALITY + " ," + Const.ABS_GENDER + " ,"
                + Const.ABS_HOSTEL + " ," + Const.ABS_EDUCATION +" ," + Const.ABS_SURNAMEPARENTS +
                ")" + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, user.getSurname());
            prSt.setString(2, user.getFirstname());
            prSt.setString(3, user.getPatronymic());
            prSt.setString(4, user.getDob());
            prSt.setString(5, user.getNumber());
            prSt.setString(6, user.getRegistration());
            prSt.setString(7, user.getAddress());
            prSt.setString(8, user.getPassportData());
            prSt.setString(9, user.getAverageScore());
            prSt.setString(10, String.valueOf(user.getSpeciality()));
            prSt.setString(11, user.getGender());
            prSt.setString(12, user.getHostel());
            prSt.setString(13, user.getEducation());
            prSt.setString(14, user.getSurnameParents());

            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void signUpParent(ParentUser puser) {
        String insert = "INSERT INTO " + Const.PARENT_TABLE + "(" + Const.PARENTS_SURNAME + "," + Const.PARENTS_FIRSTNAME
                + "," + Const.PARENTS_PATRONYMIC + "," + Const.PARENTS_NUMBER + "," + Const.PARENTS_REGISTRATION + ","
                + Const.PARENTS_ADDRESS + "," + Const.PARENTS_JOB + ","
                + Const.PARENTS_REPRESENTATIVE + " ," + Const.PARENTS_GUARDIANSHIP + ")" + "VALUES(?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement prSt = getDbConnection().prepareStatement(insert);
            prSt.setString(1, puser.getSurnameParent());
            prSt.setString(2, puser.getFirstnameParent());
            prSt.setString(3, puser.getPatronymicParent());
            prSt.setString(4, puser.getNumberParent());
            prSt.setString(5, puser.getRegistrationParent());
            prSt.setString(6, puser.getAddressParent());
            prSt.setString(7, puser.getJobParent());
            prSt.setString(8, puser.getRepresentative());
            prSt.setString(9, puser.getGuardianship());

            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
