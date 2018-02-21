package meetup.handle_password;

import act.Act;
import act.crypto.AppCrypto;
import act.util.JsonView;
import org.osgl.mvc.annotation.GetAction;
import org.osgl.mvc.annotation.PutAction;

import javax.inject.Inject;

@SuppressWarnings("unused")
@JsonView
public class AppEntry {

    @Inject
    private User user;

    @PutAction("/user/password")
    public String setPassword(String password, AppCrypto crypto) {
        user.setPassword(crypto.passwordHash(password));
        return user.getPassword();
    }

    @GetAction("/user/password/verify")
    public boolean verifyPassword(String password, AppCrypto crypto) {
        return user.getPassword().equals(crypto.passwordHash(password));
    }

    public static void main(String[] args) throws Exception {
        Act.start();
    }

}
