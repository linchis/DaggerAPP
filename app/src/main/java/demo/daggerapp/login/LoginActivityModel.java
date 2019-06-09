package demo.daggerapp.login;

public class LoginActivityModel implements LoginActivityMVP.Model{

    private LoginRepository repository;

    public LoginActivityModel(LoginRepository repository){
        this.repository = repository;
    }

    @Override
    public void creteUser(String firstName, String lastName) {
        //logica de negocio, comprobar si el usuario es correcto, valores de los campos, formato, etc.
        repository.saveUser(new User(firstName, lastName));
    }

    @Override
    public User getUser() {
        //repository.getUser() vaidar los datos del usuario antes de presentarlo
        return repository.getUser();
    }
}
