package meetup.handle_password;

import act.validation.Password;

import javax.inject.Singleton;

@Singleton
public class User {

    @Password
    private char[] password;

    public char[] getPassword() {
        return password;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }

}
