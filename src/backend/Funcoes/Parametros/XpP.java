/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.Funcoes.Parametros;

import backend.Funcoes.IntCampo;
import static backend.Funcoes.SalvarFicha.SalvarFicha;
import static backend.Funcoes.FichaLer.FichaLerInt;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import org.json.JSONObject;

/**
 *
 * @author Admin
 */
public class XpP {
     public static void XpP(String personagemCaminho, JSONObject ficha, JTextField XpLabel) {
        XpLabel.setText("" + FichaLerInt(ficha, "xp", 0));
        IntCampo.IntCampo(XpLabel);
        XpLabel.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (XpLabel.getText().trim().isEmpty()) {
                    ficha.getJSONArray("e").getJSONObject(0).put("b", 0);
                } else {
                    ficha.getJSONArray("a").getJSONObject(0).put("d", Integer.parseInt(XpLabel.getText()));
                }
                SalvarFicha(ficha, personagemCaminho);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {

                if (XpLabel.getText().trim().isEmpty()) {
                    ficha.getJSONArray("e").getJSONObject(0).put("b", 0);
                } else {
                    ficha.getJSONArray("a").getJSONObject(0).put("d", Integer.parseInt(XpLabel.getText()));
                }
                SalvarFicha(ficha, personagemCaminho);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                SalvarFicha(ficha, personagemCaminho);
            }
        });
    }
}
