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
public class AlinhamentoP {
     public static void AlinhamentoP(String personagemCaminho, JSONObject ficha, JLabel AlignSelect) {
        OptionLabel(ficha, AlignSelect, "Alinhamento");
        AlignSelect.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                trocarPainel mudar = new trocarPainel();
                Opcoes novoFrame = new Opcoes(personagemCaminho, ficha, "Alinhamento", AlignSelect, "b");
                mudar.painelChange(novoFrame);
            }
        });
    }
}
