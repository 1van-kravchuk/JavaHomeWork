package pb.kravchuk.hw8;

public class Auth {
    private String login;
    private String password;

    public void singUp(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        if (!login.matches("^(?=.*[0-9])(?=.*[A-Za-z]).{5,20}")) {
            throw new WrongLoginException("Login must have from 5 to 20 symbols: latin letters and numbers");
        } else if (!password.matches("^(?=.*[0-9])(?=.*[A-Za-z])(?=.*[_]).{6,}")) {
            throw new WrongPasswordException("password must be at least 6 symbols and contain numbers, latin letters and _");
        } else if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("\"password\" and \"confirm password\" does not matches.");
        } else {
            this.login = login;
            this.password = password;
            System.out.println("You are signed up");
        }
    }

    public void singIn(String login, String password) throws WrongLoginException, WrongPasswordException {
        if (!login.equals(this.login)) {
            throw new WrongLoginException("login is not exist");
        } else if (!password.equals(this.password)) {
            throw new WrongPasswordException("incorrect password");
        } else {
            System.out.println("You are logged in");
        }
    }
}