package com.example.codigo;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.Scanner;


public class LogInController extends  MusicPlayerController {
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
    public String song;
    public String song2;
    public String song3;





    public void userLogIn(ActionEvent event) throws IOException, InterruptedException { // metodo que se activa si el boton de acceso es tocado,
        clickLogin();                                                                   // este llama al metodo de click log in que valida si la contrasenna y usuarios son correcto o no
    }
    public String province = "";

    @FXML // el siguiente metodo tiene que ir como un FXML, porque actua directamente ne el sino, no puede acceder al fxml y cambiar deacuerdo al condicional, si lo quitamos no compila.
    private void clickLogin() throws IOException, InterruptedException { // metodo que hace las validaciones, entre ellas: contrasenna y usuario correcto o no de los diferentes usuarios, ademas del cambio de escena.
        LogInApplication m = new LogInApplication();

        // borrar este condicional antes de enviar, simplemente este es para acceso mas facil y hacer pruebas
        if (username.getText().toString().equals("1") && password.getText().toString().equals("1") && email.getText().toString().equals("1") && Provinces.getSelectionModel().getSelectedItem().equals("Guanacaste") ){ // hacemos validacion si el campo de usuario y contrasenna son los de nuestro usuarios (si estan correctos)
            TimeUnit.SECONDS.sleep(1);
            m.changeScene("2ndWindow.fxml");
            txtReader();

        }
        if (username.getText().toString().equals("Emmanuel Esquivel Chavarria") && password.getText().toString().equals("310757") && email.getText().toString().equals("emesquivel@estudiantec.cr") && Provinces.getSelectionModel().getSelectedItem().equals("Guanacaste") ){ // hacemos validacion si el campo de usuario y contrasenna son los de nuestro usuarios (si estan correctos)
            TimeUnit.SECONDS.sleep(1);
            m.changeScene("2ndWindow.fxml"); // se genera el cambio de escena a la seguna ventana
            String[] song = {
                    "Songs\\Adriel Favela X Javier Rosas  La Escuela No Me Gustó Video Oficial.mp3",
                    "Songs\\Amenazzy ft Rochy RD  Miedo Video Oficial.mp3",
                    "Songs\\Christian Nodal  Te Fallé Video Oficial.mp3",
                    "Songs\\De Morrito.mp3",
                    "Songs\\DELINCUENTE  TOKISCHA x Anuel AA x Ñengo Flow Official Video.mp3",
                    "Songs\\El Alfa El Jefe x CJ x El Cherry Scom  La Mamá de la Mamá Video Oficial.mp3",
                    "Songs\\El Alfa x Darell x Noriel  4K Video Oficial.mp3",
                    "Songs\\Grupo Marca Registrada Ft Junior H El Rescate Video Oficia.mp3",
                    "Songs\\Jay Wheeler Ft El Alfa  No Confio Official Video.mp3",
                    "Songs\\LUIS R CONRIQUEZPESO PLUMA  VIDEO OFICIAL SIEMPRE PENDIENTES.mp3",
                    "Songs\\MOJA TOTO.mp3",
                    "Songs\\Natanael Cano  Brillo Video Oficial.mp3",
                    "Songs\\Natanael Cano  Diamantes Official Video.mp3",
                    "Songs\\Natanael Cano  El Drip Official Video.mp3",
                    "Songs\\Natanael Cano  Porte Exuberante ft Oscar Maydon Official Video.mp3",
                    "Songs\\Normalito Remix.mp3",
                    "Songs\\Rochy RD  El Coba  Vídeo Oficial.mp3",
                    "Songs\\Rochy RD  Mi Contacto  Video Oficial.mp3",
                    "Songs\\Si Fuera Fácil  Grupo Marca Registrada Official Video.mp3",
                    "Songs\\Tokischa x ROSALÍA  Linda Official Video.mp3",
                    "Songs\\Victor Cibrian  En El Radio Un Cochinero Official Video.mp3",
                    "Songs\\Tan Soldao.mp3"};


        }
        if (username.getText().toString().equals("Andres Madrigal Vega") && password.getText().toString().equals("2022") && email.getText().toString().equals("anmadrigalv@estudiantec.cr") && Provinces.getSelectionModel().getSelectedItem().equals("Cartago") ){ // hacemos validacion si el campo de usuario y contrasenna son los de nuestro usuarios (si estan correctos)
            TimeUnit.SECONDS.sleep(1);
            m.changeScene("2ndWindow.fxml");
            String[] song2 = {
                    "Songs\\Adriel Favela X Javier Rosas  La Escuela No Me Gustó Video Oficial.mp3",
                    "Songs\\Christian Nodal  Te Fallé Video Oficial.mp3",
                    "Songs\\De Morrito.mp3",
                    "Songs\\Grupo Marca Registrada Ft Junior H El Rescate Video Oficia.mp3",
                    "Songs\\LUIS R CONRIQUEZPESO PLUMA  VIDEO OFICIAL SIEMPRE PENDIENTES.mp3",
                    "Songs\\Natanael Cano  Brillo Video Oficial.mp3",
                    "Songs\\Natanael Cano  Diamantes Official Video.mp3",
                    "Songs\\Natanael Cano  El Drip Official Video.mp3",
                    "Songs\\Natanael Cano  Porte Exuberante ft Oscar Maydon Official Video.mp3",
                    "Songs\\Si Fuera Fácil  Grupo Marca Registrada Official Video.mp3",
                    "Songs\\Victor Cibrian  En El Radio Un Cochinero Official Video.mp3"};
        }
        if (username.getText().toString().equals("Leonardo Araya Martinez") && password.getText().toString().equals("9088") && email.getText().toString().equals("learaya@itcr.ac.cr") && Provinces.getSelectionModel().getSelectedItem().equals("Cartago") ){ // hacemos validacion si el campo de usuario y contrasenna son los de nuestro usuarios (si estan correctos)
            TimeUnit.SECONDS.sleep(1);
            m.changeScene("2ndWindow.fxml");
            String[] song3 = {
                    "Songs\\Amenazzy ft Rochy RD  Miedo Video Oficial.mp3",
                    "Songs\\DELINCUENTE  TOKISCHA x Anuel AA x Ñengo Flow Official Video.mp3",
                    "Songs\\El Alfa El Jefe x CJ x El Cherry Scom  La Mamá de la Mamá Video Oficial.mp3",
                    "Songs\\El Alfa x Darell x Noriel  4K Video Oficial.mp3",
                    "Songs\\Jay Wheeler Ft El Alfa  No Confio Official Video.mp3",
                    "Songs\\MOJA TOTO.mp3",
                    "Songs\\Normalito Remix.mp3",
                    "Songs\\Rochy RD  El Coba  Vídeo Oficial.mp3",
                    "Songs\\Rochy RD  Mi Contacto  Video Oficial.mp3",
                    "Songs\\Tokischa x ROSALÍA  Linda Official Video.mp3",
                    "Songs\\Tan Soldao.mp3"};

        }
        if(username.getText().isEmpty() && password.getText().isEmpty()){ // si el campo esta vacio generamos un label que lo indique

            IncorrectLogIn.setText("Please type your username & password");

        }
        else { // este condicional se activaria si y solo si algunos de los dos (contrasenna y usuario) o ambos estan malos, generando un label que lo indique.
            IncorrectLogIn.setText("Wrong username or password");
        }

    }
    ArrayList<String> songsList = new ArrayList<>();

    public static DoubleLL usedFiles() {
        DoubleLL songsList = new DoubleLL();
        File directorio = new File("C:\\Users\\eemma\\OneDrive\\Escritorio\\ProyectoDatos1-master\\Songs");
        File[] archivos = directorio.listFiles();
        if (archivos != null){
            for (File archivo : archivos){
                songsList.addNode(archivo);
            }
        }

        return songsList;
    }
    public void txtReader() throws FileNotFoundException {

        InputStream ins = new FileInputStream("C:\\Users\\eemma\\OneDrive\\Escritorio\\songs1.txt");
        Scanner obj = new Scanner(ins);
        while (obj.hasNextLine())
           songsList.add(obj.nextLine());
    }

}