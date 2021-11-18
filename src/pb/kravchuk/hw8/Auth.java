package pb.kravchuk.hw8;

public class Auth {
    private String login;
    private String password;
    private String confirmPassword;

    public Auth(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public Auth(String login, String password, String confirmPassword) {
        this.login = login;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void singUp() throws WrongLoginException, WrongPasswordException {
        if(!login.matches("^(?=.*[0-9])(?=.*[A-Za-z]).{5,20}")) {
            throw new WrongLoginException("Login must have from 5 to 20 symbols: latin letters and numbers");
        } else if (!password.matches("^(?=.*[0-9])(?=.*[A-Za-z])(?=.*[_]).{6,}")) {
            throw new WrongPasswordException("password must be at least 6 symbols and contain numbers, latin letters and _");
        } else if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("\"password\" and \"confirm password\" does not matches.");
        } else{
            System.out.println("You are signed up");
        }
    }
    public  void singIn() throws WrongLoginException, WrongPasswordException{
        if (!this.login.equals(getLogin())){
            throw new WrongLoginException("login is not exist");
        } else  if (!this.password.equals(getPassword())){
            throw new WrongPasswordException("incorrect password");
        } else{
            System.out.println("You are logged in");
        }
    }

}