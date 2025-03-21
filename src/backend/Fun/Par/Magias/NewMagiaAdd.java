/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.Fun.Par.Magias;

import backend.Fun.OrganizarASSET;
import org.json.*;
import javax.swing.*;
import backend.jsonParser;
import backend.Fun.VirtualObjects.NewMagiaArrayVO;
import backend.Fun.Par.Magias.MagiasAddP;
/**
 *
 * @author Admin
 */
public class NewMagiaAdd {

    public static void NewMagiaAdd(String personagemCaminho, JSONObject ficha, JPanel PMagiasT, JPanel PMagiasTF, JPanel PMagiasF, String caminhoArquivo, JSONArray Magias, JSONArray CLasseMagias, JSONArray Classes, JTextField NomeMagia, JTextField EscolaMagia, JTextField DuracaoMagia, JTextField TempoMagia, JTextField AlcanceMagia, JTextField CompMagia, JTextArea Descricao, int LvlMagia, JLabel AddNewMagia, JLabel NewMagiaL) {
        jsonParser sobrescrever = new jsonParser();
        AddNewMagia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                String NomeString = NomeMagia.getText();
                String EscolaString = EscolaMagia.getText();
                String DuracaoString = DuracaoMagia.getText();
                String TempoString = TempoMagia.getText();
                String AlcanceString = AlcanceMagia.getText();
                String CompString = CompMagia.getText();
                String DescricaoString = Descricao.getText();
                Magias.put(NewMagiaArrayVO.NewMagia(NomeString, EscolaString, DuracaoString, TempoString, AlcanceString, CompString, DescricaoString, LvlMagia, null));
                sobrescrever.sobrescreverArray(caminhoArquivo, OrganizarASSET.OrganizarJSONArray(Magias, "b").toString(4));
                SwingUtilities.getWindowAncestor(NomeMagia).dispose();
                SwingUtilities.getWindowAncestor(NewMagiaL).dispose();
                MagiasAddP.MagiasAddP(personagemCaminho, ficha, PMagiasT, PMagiasF, Magias, "r", "b", "c", "ASSETS/Magias.json", PMagiasTF, Classes, LvlMagia, CLasseMagias);
            }
        });
    }
}
