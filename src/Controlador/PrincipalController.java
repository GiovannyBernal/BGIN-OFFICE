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
import javafx.scene.control.SingleSelectionModel;
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
    
    public static String nombre;
    
    WRISHE_ABRIR WR_OPEN = new WRISHE_ABRIR();
    public AnchorPane anchorPane;
    public Tab DocumentTab;
    
    public String ID;
    
    @FXML
    public TabPane TabPane;
    @FXML
    public Tab TabMonitor;
    @FXML
    private Label LBLbienvenido;
    @FXML
    private Label LBLso;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        nombre = System.getProperty("user.name");
        LBLbienvenido.setText("Bienvenido " +  nombre);
        String SO = System.getProperty("os.name");
        String arch = System.getProperty("os.arch");
        LBLso.setText("SO: " + SO + " - Arquitectura: " + arch);
    }

    @FXML
    private void WRISHE_DOCUMENT(ActionEvent event) throws IOException {    
        
        SingleSelectionModel<Tab> selectionModel = TabPane.getSelectionModel();
        
        int numTab = TabPane.getChildrenUnmodifiable().size();
        
        numTab -= 1;
        
        //-------Cargar el nuevo TabPane---------
        DocumentTab = new Tab("", anchorPane);
        
        DocumentTab.setText("Documento " + numTab + " - " + nombre);
        
        
        Node newLoadpane = FXMLLoader.load(getClass().getResource("../Vista/BGIN-WRISHE.fxml"));
        DocumentTab.setContent(newLoadpane);
        TabPane.getTabs().addAll(DocumentTab);
        
        Documento++;
        
        ID = DocumentTab.getId();
        
        selectionModel.selectLast();
        
    }
    
}