package pack.classes;

import java.sql.*;

/**
 * Created by Oleksandr on 25.12.2016.
 */
public class UserToDb {
    Connection connection;
    Statement statement;
    String usersTable = "users_table";

    public UserToDb() {
        connection = ConnectionConfig.getConnection();
        if (connection != null) {
            System.out.println("Connected successfully from UserToDb class!");
            try {
                statement = connection.createStatement();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else System.out.println("Error. No connection from UserToDb class!");
    }

    public boolean addNewUserToDb(User user) {
        if (!checkIfUserExists(user.getLogin())) {
            try {
                statement.execute("INSERT INTO " + usersTable + "(login, pass, firstName, lastName, email) VALUES(" +
                        "'" + user.getLogin() + "', " +
                        "'" + user.getPassword() + "', " +
                        "'" + user.getFirstName() + "', " +
                        "'" + user.getLastName() + "', " +
                        "'" + user.getEmail() + "');" +
                        "");
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (statement != null) {
                    try {
                        statement.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return false;
    }

    /**
     * Checks if user with such 'login' exists
     * return true if user  exists
     * return false if no such user  exists
     */
    public boolean checkIfUserExists(String login) {
        try {
            ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM " + usersTable + " WHERE login = '" + login + "';");

            while (resultSet.next()) {
                if (resultSet.getInt(1) == 0) {
                    return false;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

//    public User authenticateUser(String userLogin, String userPassword){
//        User user = getUserDetails(userLogin);
//    }

    public User authenticateUser(String userLogin, String userPassword) {
        User user = null;

        if (checkIfUserExists(userLogin)) {
            ResultSet resultSet = null;
            try {
                resultSet = statement.executeQuery("SELECT * FROM " + usersTable + " WHERE login = '" + userLogin + "' " +
                        "AND pass = '" + userPassword + "';");
                while (resultSet.next()) {
                    String login, pass, firstName, lastName, email;
                    login = resultSet.getString(2);
                    pass = resultSet.getString(3);
                    firstName = resultSet.getString(4);
                    lastName = resultSet.getString(5);
                    email = resultSet.getString(6);

                    user = new User(login, pass, firstName, lastName, email);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return user;
    }

}
