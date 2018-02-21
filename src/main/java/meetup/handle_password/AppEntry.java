package meetup.handle_password;

import act.Act;
import org.osgl.mvc.annotation.GetAction;
import org.osgl.mvc.annotation.PutAction;

import javax.inject.Inject;

@SuppressWarnings("unused")
public class AppEntry {

    @Inject
    private User user;

    @PutAction("/user/password")
    public String setPassword(String password) {
        user.setPassword(password);
        return user.getPassword();
    }

    @GetAction("/user/password/verify")
    public boolean verifyPassword(String password) {
        return user.getPassword().equals(password);
    }

    public static void main(String[] args) throws Exception {
        Act.start();
    }

}
