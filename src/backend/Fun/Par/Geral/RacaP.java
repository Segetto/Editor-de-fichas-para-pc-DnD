/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.Fun.Par.Geral;

import static backend.Fun.OptionLabel.OptionLabel;
import backend.Fun.trocarPainel;
import javax.swing.JLabel;
import org.json.JSONObject;
import visual.Opcoes;

/**
 *
 * @author Admin
 */
public class RacaP {
    public static void RacaP(String personagemCaminho, JSONObject ficha, JLabel RacaSelect) {
        OptionLabel(ficha, RacaSelect, "Raca");
        RacaSelect.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                trocarPainel mudar = new trocarPainel();
                Opcoes novoFrame = new Opcoes(personagemCaminho, ficha, "Raca", RacaSelect, "c");
                mudar.painelChange(novoFrame);
            }
        });
    }

}
