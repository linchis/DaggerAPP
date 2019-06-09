package demo.daggerapp.root;

import android.app.Application;

import demo.daggerapp.login.LoginModule;


public class App extends Application {
    //logica de la clase

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .loginModule(new LoginModule())
                .build();
                //para cada componente de nuestra aplicacion --> Estan en ApplicationComponent
    }

    public ApplicationComponent getComponent(){
        return component;
    }
}
