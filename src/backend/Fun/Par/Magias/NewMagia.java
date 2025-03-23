/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.Fun.Par.Magias;
import backend.Fun.Par.Especializacao.*;
import javax.swing.*;
import visual.CriarMagia;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import org.json.*;
/**
 *
 * @author Admin
 */
public class NewMagia {
    public static void NewMagia(String personagemCaminho, JSONObject ficha, JPanel PMagiasT, JPanel PMagiasTF, JPanel PMagiasF, JSONArray Magias, JSONArray Classes, JSONArray CLasseMagias, String CaminhoArquivo, JLabel NewMagia, int LvlMagia){
        CriarMagia NewMagiaJanela = new CriarMagia(personagemCaminho, ficha, PMagiasT, PMagiasTF, PMagiasF, Magias, Classes, CLasseMagias, CaminhoArquivo, NewMagia, LvlMagia);
        NewMagia.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e){
           NewMagiaJanela.setVisible(true);
        }
    });
    }
}
