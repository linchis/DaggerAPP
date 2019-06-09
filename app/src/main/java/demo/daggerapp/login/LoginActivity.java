package demo.daggerapp.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import javax.inject.Inject;

import demo.daggerapp.R;
import demo.daggerapp.root.App;

public class LoginActivity extends AppCompatActivity implements LoginActivityMVP.View{

    @Inject
            LoginActivityMVP.Presenter presenter;

    EditText firstName, lastName;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((App)getApplication()).getComponent().inject(this);    //Se añade aplicacion a los componentes

        firstName = findViewById(R.id.editText_first_name);
        lastName = findViewById(R.id.editText_last_name);
        loginButton = findViewById(R.id.button_login);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getApplicationContext(),"login pulsado", Toast.LENGTH_LONG).show();
                presenter.loginButtonClicked();
            }
        });
    }

    @Override
    protected void onResume(){
        super.onResume();
        presenter.setView(this);
        //Avisar al presentador si ya existe un usuario
        presenter.getCurrentUser();
    }

    @Override
    public String getFistName() {
        return this.firstName.getText().toString();
    }

    @Override
    public String getLastName() {
        return this.lastName.getText().toString();
    }

    @Override
    public void showUserNotAvailable() {
        Toast.makeText(this,"Usuario no disponible", Toast.LENGTH_LONG).show();
    }

    @Override
    public void showInputError() {
        Toast.makeText(this,"Error nombre o apellido vacíos", Toast.LENGTH_LONG).show();
    }

    @Override
    public void showUserSaved() {
        Toast.makeText(this,"Usuario guardado", Toast.LENGTH_LONG).show();
    }

    @Override
    public void setFistName(String fistName) {
        this.firstName.setText(fistName);
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName.setText(lastName);
    }
}
