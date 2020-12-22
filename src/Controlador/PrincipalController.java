/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.WRISHE_ABRIR;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * FXML Controller class
 *
 * @author linux
 */
public class PrincipalController implements Initializable {
    
    public static int Documento = 1;
    
    WRISHE_ABRIR WR_OPEN = new WRISHE_ABRIR();
    public AnchorPane anchorPane;
    public Tab DocumentTab;
    
    public String ID;
    
    @FXML
    public TabPane TabPane;
    @FXML
    public Tab TabMonitor;
    @FXML
    private AnchorPane PanelD;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void WRISHE_DOCUMENT(ActionEvent event) throws IOException {        
        
        //-------Cargar el nuevo TabPane---------
        DocumentTab = new Tab("", anchorPane);
        
        DocumentTab.setText("BGIN-WRISHE- " + Documento);
        
        
        Node newLoadpane = FXMLLoader.load(getClass().getResource("../Vista/BGIN-WRISHE.fxml"));
        DocumentTab.setContent(newLoadpane);
        TabPane.getTabs().addAll(DocumentTab);
        
        Documento++;
        
        ID = DocumentTab.getId();
        
    }
    
}