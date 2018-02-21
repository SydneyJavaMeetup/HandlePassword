package meetup.handle_password;

import javax.inject.Singleton;

@Singleton
public class User {

    private char[] password;

    public char[] getPassword() {
        return password;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }

}
