package entity;







public class MyUserCredentials {


    private int idUserCredential;


    private String userLogin;


    private String userPassword;


    private User user;

    public MyUserCredentials(){}

    public MyUserCredentials(String userLogin, String userPassword) {
        this.userLogin = userLogin;
        this.userPassword = userPassword;
    }

    public int getIdUserCredential() {
        return idUserCredential;
    }

    public void setIdUserCredential(int idUserCredential) {
        this.idUserCredential = idUserCredential;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "MyUserCredentials{" +
                "idUserCredential=" + idUserCredential +
                ", userLogin='" + userLogin + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", MyUser=" + user +
                '}';
    }
}
