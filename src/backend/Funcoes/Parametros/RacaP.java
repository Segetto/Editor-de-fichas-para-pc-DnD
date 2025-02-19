/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.Funcoes.Parametros;

import static backend.Funcoes.RacaLabel.RacaLabel;
import backend.Funcoes.trocarPainel;
import javax.swing.JLabel;
import org.json.JSONObject;
import visual.Opcoes;

/**
 *
 * @author Admin
 */
public class RacaP {
    public static void RacaP(String personagemCaminho, JSONObject ficha, JLabel RacaSelect) {
        RacaLabel(ficha, RacaSelect);
        RacaSelect.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                trocarPainel mudar = new trocarPainel();
                Opcoes novoFrame = new Opcoes(personagemCaminho, ficha, "Raca", RacaSelect);
                mudar.painelChange(novoFrame);
            }
        });
    }

}
