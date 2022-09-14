package com.example.codigo;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class LogInController extends LogInApplication{
    @FXML //instanciamos cada uno de los atributos de nuestro fxml
    private TextField username; // id para nuestro slot de nombre de usuario
    @FXML
    private PasswordField password;// id para nuestro slot de contrasenna
    @FXML
    private Label IncorrectLogIn;// id para nuestro label deacuerdo a ciertos condicionales, ya sea, no ingreso datos, contrsenna o usuarios incorrectos.
    @FXML
    private TextField email; // id para nuestro email de usuario
    @FXML
    private Button button; // id para nuestro boton de acceso
    @FXML
    private ComboBox Provinces; // id para nuestro listado de provincias a elegir





    public void userLogIn(ActionEvent event) throws IOException, InterruptedException { // metodo que se activa si el boton de acceso es tocado,
        clickLogin();                                                                   // este llama al metodo de click log in que valida si la contrasenna y usuarios son correcto o no
    }
    public String province = "";

    @FXML // el siguiente metodo tiene que ir como un FXML, porque actua directamente ne el sino, no puede acceder al fxml y cambiar deacuerdo al condicional, si lo quitamos no compila.
    private void clickLogin() throws IOException, InterruptedException { // metodo que hace las validaciones, entre ellas: contrasenna y usuario correcto o no de los diferentes usuarios, ademas del cambio de escena.
        LogInApplication m = new LogInApplication();

        if (username.getText().toString().equals("Emmanuel Esquivel Chavarria") && password.getText().toString().equals("310757") && email.getText().toString().equals("emesquivel@estudiantec.cr") && Provinces.getSelectionModel().getSelectedItem().equals("Guanacaste") ){ // hacemos validacion si el campo de usuario y contrasenna son los de nuestro usuarios (si estan correctos)
            TimeUnit.SECONDS.sleep(1);
            m.changeScene("2ndWindow.fxml"); // se genera el cambio de escena a la seguna ventana
        }
        if (username.getText().toString().equals("Andres Madrigal Vega") && password.getText().toString().equals("2022") && email.getText().toString().equals("anmadrigalv@estudiantec.cr") && Provinces.getSelectionModel().getSelectedItem().equals("Cartago") ){ // hacemos validacion si el campo de usuario y contrasenna son los de nuestro usuarios (si estan correctos)
            TimeUnit.SECONDS.sleep(1);
            m.changeScene("2ndWindow.fxml");
        }
            if (username.getText().toString().equals("Leonardo Araya Martinez") && password.getText().toString().equals("9088") && email.getText().toString().equals("learaya@itcr.ac.cr") && Provinces.getSelectionModel().getSelectedItem().equals("Cartago") ){ // hacemos validacion si el campo de usuario y contrasenna son los de nuestro usuarios (si estan correctos)
            TimeUnit.SECONDS.sleep(1);
            m.changeScene("2ndWindow.fxml");
        }
        if(username.getText().isEmpty() && password.getText().isEmpty()){ // si el campo esta vacio generamos un label que lo indique

            IncorrectLogIn.setText("Please type your username & password");

        }
        else { // este condicional se activaria si y solo si algunos de los dos (contrasenna y usuario) o ambos estan malos, generando un label que lo indique.
            IncorrectLogIn.setText("Wrong username or password");
        }

    }

}