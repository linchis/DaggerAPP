package demo.daggerapp.login;

import dagger.Module;
import dagger.Provides;

@Module
public class LoginModule {

    @Provides
    public LoginActivityMVP.Presenter provideLoginActivityPresenter(LoginActivityMVP.Model model){
         return new LoginActivityPresenter(model);
    }

    //se requiere porqque en el paso anterior se requiere un modelo
    @Provides
    public LoginActivityMVP.Model provideLoginActivityModel(LoginRepository repo){
        return new LoginActivityModel(repo);
    }

    //se requiere porqque en el paso anterior se requiere un repository
    @Provides
    public LoginRepository provideLoginRepository(){
        return new MemoryRepository();      //Si se cambia el proveedor por BD, cloud, etc. Se mofificará aqui
    }

}
