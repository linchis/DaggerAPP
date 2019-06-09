package demo.daggerapp.root;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {
    private Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Provides //metodos expuestos con valor de retorno
    @Singleton  //instancia qe solo se crea una vez
    public Context providerContext(){
        return application;             //Provee del contexto de aplicacion
    }
}
