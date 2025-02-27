/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.Fun.Par.Inventario;

import static backend.Fun.SalvarFicha.SalvarFicha;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import org.json.JSONObject;

/**
 *
 * @author Admin
 */
public class InformacoesAdicionaisP {
    public static void InformacoesP(String personagemCaminho, int pos, JSONObject ficha, JTextArea Informacoes) {

        Informacoes.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                ficha.getJSONArray("i").getJSONObject(pos).getJSONObject("a").put("f", Informacoes.getText());
                SalvarFicha(ficha, personagemCaminho);

            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                ficha.getJSONArray("i").getJSONObject(pos).getJSONObject("a").put("f", Informacoes.getText());
                SalvarFicha(ficha, personagemCaminho);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                SalvarFicha(ficha, personagemCaminho);

            }
        });
    }
}
