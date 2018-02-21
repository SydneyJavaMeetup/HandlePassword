package meetup.handle_password;

import javax.inject.Singleton;

@Singleton
public class User {

    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
