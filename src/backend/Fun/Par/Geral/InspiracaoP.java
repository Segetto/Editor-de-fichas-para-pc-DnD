/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.Fun.Par.Geral;

import static backend.Fun.FichaLer.FichaLerBool;
import org.json.*;
import javax.swing.*;
import static backend.Fun.SalvarFicha.SalvarFicha;

/**
 *
 * @author Admin
 */
public class InspiracaoP {

    public static void InspiracaoP(String personagemCaminho, JSONObject ficha, JLabel IniciativaIcon) {
        InspiracaoP icone = new InspiracaoP();
        if (FichaLerBool(ficha, "Inspiracao", 0)) {
            icone.trocarIcone("/visual/res/Checked.png", IniciativaIcon);
        } 
        IniciativaIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (FichaLerBool(ficha, "Inspiracao", 0)) {
                    ficha.getJSONArray("a").getJSONObject(0).put("e", false);
                    icone.trocarIcone("/visual/res/Unchecked.png", IniciativaIcon);
                } else {
                    ficha.getJSONArray("a").getJSONObject(0).put("e", true);
                    icone.trocarIcone("/visual/res/Checked.png", IniciativaIcon);
                }
                SalvarFicha(ficha, personagemCaminho);
            }
        });
    }

    private void trocarIcone(String caminho, JLabel label) {
        ImageIcon novoIcone = new ImageIcon(getClass().getResource(caminho));
        label.setIcon(novoIcone);

    }
}
