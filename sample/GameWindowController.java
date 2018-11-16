package sample;

import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class GameWindowController implements Initializable {
    public Counter impl;
    public int sessiontoken;
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    public void setInterface(Counter impl){
        this.impl=impl;
    }
    public void setGame(int sessiontoken){
        try{
            this.sessiontoken=sessiontoken;
            impl.setGame(this.sessiontoken);
        }
        catch (Exception e){

        }

    }
}
