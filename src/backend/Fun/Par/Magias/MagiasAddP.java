/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.Fun.Par.Magias;

import backend.Fun.trocarPainel;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.json.*;
import visual.Magias;

/**
 *
 * @author Admin
 */
public class MagiasAddP {
    public static void MagiasAddP(String personagemCaminho, JSONObject ficha, JPanel PMagiasT, JPanel PMagiasF, JSONArray Magias, String VetorNomeFicha, String TituloCaminho, String DescricaoCaminho, String CaminhoArquivo, JPanel PMagiasFTl, JSONArray OpcoesComboBox, int MagiaLvl,JSONArray ClassesMagias) {
        trocarPainel mudar = new trocarPainel();
        Magias novoFrame = new Magias(personagemCaminho, ficha, PMagiasF, Magias, VetorNomeFicha, TituloCaminho, DescricaoCaminho, CaminhoArquivo, PMagiasFTl, OpcoesComboBox, PMagiasT, MagiaLvl, ClassesMagias);
        novoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        for (MouseListener ml : PMagiasT.getMouseListeners()) {
            PMagiasT.removeMouseListener(ml);
        }
        System.gc();
        PMagiasT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mudar.painelChange(novoFrame);
            }
        });
    }
}
