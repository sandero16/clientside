package sample;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class waitingRoomController implements Initializable {
    public Label label;
    public Counter impl;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    public void setInterface(Counter impl){
        this.impl=impl;
    }
    public void waitForOtherPlayer(int sessiontoken){
        try{
            System.out.println(sessiontoken+impl.toString());
            while(!impl.vindtTegenspeler(sessiontoken)){
                //System.out.println("haloo");
            }
            System.out.println("game started");
            FXMLLoader Loader=new FXMLLoader();
            Loader.setLocation(getClass().getResource("gameWindow.fxml"));
            try{
                Loader.load();
            }
            catch (IOException ioe){
            }

            Stage stage=new Stage();
            //GameWindowController controller =Loader.getController();
            LogInController controller =Loader.getController();
            controller.setInterface(impl);
            //controller.setGame(sessiontoken);
            Parent root=Loader.getRoot();
            stage.setTitle("Hello World");
            stage.setScene(new Scene(root, 300, 275));
            stage.show();


            Stage oldstage  = (Stage) label.getScene().getWindow();
            oldstage.close();

        }
        catch (Exception e){

        }

    }
}
