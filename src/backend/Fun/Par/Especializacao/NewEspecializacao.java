/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.Fun.Par.Especializacao;
import javax.swing.*;
import visual.CriarEspecializacao;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import org.json.*;
/**
 *
 * @author Admin
 */
public class NewEspecializacao {
    public static void NewEsp(String personagemCaminho, JSONArray EspJson, String EspTitCam, String EspDescCam, JLabel NewEsp, JSONArray OpcoesSelect, String CaminhoArquivo){
        CriarEspecializacao NewEspJanela = new CriarEspecializacao(personagemCaminho, EspJson, EspTitCam, EspDescCam, OpcoesSelect, CaminhoArquivo, NewEsp);
        NewEsp.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e){
            NewEspJanela.setVisible(true);
        }
    });
    }
}
