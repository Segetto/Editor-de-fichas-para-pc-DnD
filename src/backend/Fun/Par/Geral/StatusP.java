/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.Fun.Par.Geral;

import backend.Fun.IntCampo;
import static backend.Fun.SalvarFicha.SalvarFicha;
import static backend.Fun.Mod.mod;
import static backend.Fun.FichaLer.FichaLerInt;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import org.json.JSONObject;

/**
 *
 * @author Admin
 */
public class StatusP {
    public static void StatusP(String personagemCaminho, JTextField StatusLabel, JLabel StatusMod, JSONObject ficha, int pos) {
        StatusLabel.setText("" + FichaLerInt(ficha, "Status", pos));
        IntCampo.IntCampo(StatusLabel);
        StatusMod.setText(mod(FichaLerInt(ficha, "Status", pos), 0));
        StatusLabel.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {

                if (StatusLabel.getText().trim().isEmpty()) {
                    ficha.getJSONArray("e").getJSONObject(pos).put("b", 0);
                } else {
                    ficha.getJSONArray("e").getJSONObject(pos).put("b", Integer.parseInt(StatusLabel.getText()));
                }
                StatusMod.setText(mod(FichaLerInt(ficha, "Status", pos), 0));
                SalvarFicha(ficha, personagemCaminho);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (StatusLabel.getText().trim().isEmpty()) {
                    ficha.getJSONArray("e").getJSONObject(pos).put("b", 0);
                } else {
                    ficha.getJSONArray("e").getJSONObject(pos).put("b", Integer.parseInt(StatusLabel.getText()));
                }
                StatusMod.setText(mod(FichaLerInt(ficha, "Status", pos), 0));
                SalvarFicha(ficha, personagemCaminho);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                SalvarFicha(ficha, personagemCaminho);

            }
        });
    }

}
