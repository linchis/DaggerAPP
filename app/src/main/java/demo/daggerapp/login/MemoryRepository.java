package demo.daggerapp.login;

public class MemoryRepository implements LoginRepository {

    private User user;
    //fichero, bbdd, firebase, cloud....

    //Clase para persistenci en memoria
    @Override
    public void saveUser(User user) {
        if (user == null){
            user = getUser();
        }
        //escritura en el formato o medio especifico, fichero, bbdd, etc.
        this.user = user;
    }

    @Override
    public User getUser() {

        if (user == null){
            user = new User("Antonio", "Banderas");
            user.setId(0);
            return user;
        }else {
            return user;
        }
    }
}
