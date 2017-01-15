package pack.classes;

import java.util.List;

/**
 * Created by okhelenyuk on 24.11.2016.
 */
public class User {
    private int id;
    private String firstName;
    private String lastName;
    private String login;
    private String password;
    private String email;

    private List<Advertisement> ads;

//    private String passportSeries;
//    private String passportNumber;
//    private String phone;
//    private Address residenceAddress;


    public User() {
    }

    public User(int id, String login, String password, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.login = login;
        this.password = password;
        this.ads = null;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", ads=" + ads +
                '}';
    }
}
