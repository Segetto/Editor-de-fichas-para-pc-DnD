/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.Fun.Par.Inventario;

import static backend.Fun.FichaLer.FichaLerInt;
import backend.Fun.IntCampo;
import static backend.Fun.SalvarFicha.SalvarFicha;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import org.json.JSONObject;

/**
 *
 * @author Admin
 */
public class MoedasP {
         public static void MoedaP(String personagemCaminho, JSONObject ficha, JTextField MoedaLabel, String CampoNome) {
        MoedaLabel.setText("" + ficha.getJSONArray("a").getJSONObject(0).getInt(CampoNome));
        IntCampo.IntCampo(MoedaLabel);
        MoedaLabel.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (MoedaLabel.getText().trim().isEmpty()) {
                    ficha.getJSONArray("a").getJSONObject(0).put(CampoNome, 0);
                } else {
                    ficha.getJSONArray("a").getJSONObject(0).put(CampoNome, Integer.parseInt(MoedaLabel.getText()));
                }
                SalvarFicha(ficha, personagemCaminho);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {

                if (MoedaLabel.getText().trim().isEmpty()) {
                    ficha.getJSONArray("a").getJSONObject(0).put(CampoNome, 0);
                } else {
                    ficha.getJSONArray("a").getJSONObject(0).put(CampoNome, Integer.parseInt(MoedaLabel.getText()));
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
