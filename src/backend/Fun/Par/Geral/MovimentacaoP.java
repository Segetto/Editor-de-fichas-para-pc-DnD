/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.Fun.Par.Geral;

import static backend.Fun.FichaLer.FichaLerInt;
import backend.Fun.DoubleCampo;
import static backend.Fun.Mod.mod;
import static backend.Fun.SalvarFicha.SalvarFicha;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import org.json.JSONObject;

/**
 *
 * @author Admin
 */
public class MovimentacaoP {
    public static void MovimentacaoP(String personagemCaminho, JSONObject ficha, JTextField MovimentacaoText) {
        MovimentacaoText.setText("" + ficha.getJSONArray("a").getJSONObject(0).getDouble("i"));
        DoubleCampo.DoubleCampo(MovimentacaoText);
        MovimentacaoText.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {

                if (MovimentacaoText.getText().trim().isEmpty()) {
                    ficha.getJSONArray("a").getJSONObject(0).put("i", 0);
                } else {
                    ficha.getJSONArray("e").getJSONObject(0).put("b", Double.parseDouble(MovimentacaoText.getText()));
                }
                SalvarFicha(ficha, personagemCaminho);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (MovimentacaoText.getText().trim().isEmpty()) {
                    ficha.getJSONArray("a").getJSONObject(0).put("i", 0);
                } else {
                    ficha.getJSONArray("e").getJSONObject(0).put("b", Double.parseDouble(MovimentacaoText.getText()));
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
