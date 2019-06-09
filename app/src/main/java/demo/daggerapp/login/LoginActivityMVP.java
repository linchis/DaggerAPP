package demo.daggerapp.login;

public interface LoginActivityMVP {


    interface View{
        String getFistName();
        String getLastName();

        void showUserNotAvailable();
        void showInputError();
        void showUserSaved();

        void setFistName(String fistName);
        void setLastName(String lastName);
    }

    interface Presenter{
        void setView(LoginActivityMVP.View view);

        void loginButtonClicked();

        void getCurrentUser();
    }

    interface Model{
        void creteUser(String fistName, String lastName);

        User getUser();
    }


}
