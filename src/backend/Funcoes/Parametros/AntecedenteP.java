/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.Funcoes.Parametros;

import static backend.Funcoes.FichaLer.FichaLerString;
import static backend.Funcoes.SalvarFicha.SalvarFicha;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import org.json.JSONObject;

/**
 *
 * @author Admin
 */
public class AntecedenteP {
    public static void AntecedenteP(String personagemCaminho, JSONObject ficha, JTextField Antecedente) {
        if (FichaLerString(ficha, "Antecedente", 0).equals("")) {

        } else {
            Antecedente.setText(FichaLerString(ficha, "Antecedente", 0));
        }
        Antecedente.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                ficha.getJSONArray("a").getJSONObject(0).put("3", Antecedente.getText());
                SalvarFicha(ficha, personagemCaminho);

            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                ficha.getJSONArray("a").getJSONObject(0).put("3", Antecedente.getText());
                SalvarFicha(ficha, personagemCaminho);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                SalvarFicha(ficha, personagemCaminho);

            }
        });
    }
}
