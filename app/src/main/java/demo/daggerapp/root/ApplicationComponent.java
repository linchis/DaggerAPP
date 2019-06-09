package demo.daggerapp.root;

import javax.inject.Singleton;
import dagger.Component;
import demo.daggerapp.login.LoginActivity;
import demo.daggerapp.login.LoginModule;

@Singleton
@Component(modules={ApplicationModule.class, LoginModule.class})  //se referencian todos los modulos, = {comp,comp, ...}
public interface ApplicationComponent {
    void inject(LoginActivity target);
}
