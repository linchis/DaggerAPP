package demo.daggerapp.login;

public interface LoginRepository {

    void saveUser(User user);

    User getUser();
}
