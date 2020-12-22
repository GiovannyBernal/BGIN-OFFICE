/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author linux
 */
public class WRISHEController implements Initializable {

    //---------Variables----------
    public String url;
    public String TitleD;
    public boolean GA = false;

    PrincipalController prc = new PrincipalController();

    public static BufferedWriter bw;
    public static File fileG;

    @FXML
    private TextArea TXTdocumento;
    @FXML
    private Label LBLurl;
    @FXML
    private Pane PanelD;
    @FXML
    private Label LBLtitle;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }


    @FXML
    private void Salir(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void NuevoM(ActionEvent event) {
        url = "";
        LBLurl.setText("URL");
        TXTdocumento.setText("");
        GA = false;
        LBLtitle.setText("Titulo");
    }

    @FXML
    private void AbrirM(ActionEvent event) {
        FileChooser flchooser = new FileChooser();
        File fileA = flchooser.showOpenDialog(null);

        if (fileA != null) {
            FileReader fr = null;
            BufferedReader br = null;
            String texto = "";
            TXTdocumento.setText("");
            try {
                fr = new FileReader(fileA);
                br = new BufferedReader(fr);
                String st = br.readLine();
                while (st != null) {
                    texto = texto + st + "\n";
                    st = br.readLine();
                }
                url = fileA.getAbsolutePath();
                TitleD = fileA.getName();
                LBLtitle.setText(TitleD);
                LBLurl.setText(url);
                GA = true;
            } catch (Exception e) {
                TXTdocumento.appendText(e.toString());
            } finally {
                try {
                    fr.close();
                } catch (Exception e2) {
                    TXTdocumento.appendText(e2.toString());
                }
            }
            TXTdocumento.appendText(texto);
        }
    }

    @FXML
    private void GuardarM(ActionEvent event) {
        if (!GA) {
            FileChooser flchooser = new FileChooser();
            fileG = flchooser.showSaveDialog(null);
            if (fileG != null) {
                FileWriter fw = null;
                bw = null;
                try {
                    fw = new FileWriter(fileG, false);
                    bw = new BufferedWriter(fw);

                    String texto = TXTdocumento.getText();
                    bw.write(texto, 0, texto.length());
                    TitleD = fileG.getName();
                    LBLtitle.setText(TitleD);
                    url = fileG.getAbsolutePath();
                    LBLurl.setText(url);
                    GA = true;
                } catch (Exception e) {
                    TXTdocumento.appendText(e.toString());
                } finally {
                    try {
                        bw.close();
                    } catch (Exception e2) {
                        TXTdocumento.appendText(e2.toString());
                    }
                }
            }
        } else {
            FileWriter fw = null;
            bw = null;
            try {
                fw = new FileWriter(url, false);
                bw = new BufferedWriter(fw);

                String texto = TXTdocumento.getText();
                bw.write(texto, 0, texto.length());

            } catch (Exception e) {
                TXTdocumento.appendText(e.toString());
            } finally {
                try {
                    bw.close();
                } catch (Exception e2) {
                    TXTdocumento.appendText(e2.toString());
                }
            }
        }
    }

    @FXML
    private void GuardarComoM(ActionEvent event) {
        FileChooser flchooser = new FileChooser();
        fileG = flchooser.showSaveDialog(null);
        if (fileG != null) {
            FileWriter fw = null;
            bw = null;
            try {
                fw = new FileWriter(fileG, false);
                bw = new BufferedWriter(fw);

                String texto = TXTdocumento.getText();
                bw.write(texto, 0, texto.length());
                TitleD = fileG.getName();
                LBLtitle.setText(TitleD);
                url = fileG.getAbsolutePath();
                LBLurl.setText(url);
                GA = true;
            } catch (Exception e) {
                TXTdocumento.appendText(e.toString());
            } finally {
                try {
                    bw.close();
                } catch (Exception e2) {
                    TXTdocumento.appendText(e2.toString());
                }
            }
        }
    }

}
