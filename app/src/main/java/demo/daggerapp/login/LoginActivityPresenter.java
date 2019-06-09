package demo.daggerapp.login;

import android.support.annotation.Nullable;

public class LoginActivityPresenter implements LoginActivityMVP.Presenter{

    @Nullable   //lint para verificar si variable es nula
    private LoginActivityMVP.View view;
    private LoginActivityMVP.Model model;

    public LoginActivityPresenter(LoginActivityMVP.Model model){
        this.model = model;
        //inyeccion a traves de constructor
    }

    @Override
    public void setView(LoginActivityMVP.View view) {
        this.view = view;
    }

    @Override
    public void loginButtonClicked() {
        //logica cmprobacion de los datos, creacion de usaurio
        if (view != null){
            if (view.getFistName().trim().equals("")||view.getLastName().trim().equals("")){
                view.showInputError();
            }else{
                model.creteUser(view.getFistName().trim(),view.getLastName().trim());
                view.showUserSaved();
            }
        }
    }

    @Override
    public void getCurrentUser() {
        User user = model.getUser();
        if (user==null){
            if (view!=null){
                view.showUserNotAvailable();
            }
        }else{
            if (view!=null){
                view.setFistName(user.getFirst_name());
                view.setLastName(user.getLast_name());
            }
        }
    }
}
