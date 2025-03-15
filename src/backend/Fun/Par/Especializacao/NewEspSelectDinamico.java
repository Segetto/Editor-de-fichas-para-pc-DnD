/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.Fun.Par.Especializacao;

import backend.Fun.OrganizarASSET;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import backend.jsonParser;
import javax.swing.*;
import backend.Fun.Rand;
import org.json.*;

/**
 *
 * @author Admin
 */
public class NewEspSelectDinamico {

    public static void NewEspSelectDinamico(JTextField NomeComp, JTextArea DescComp, JPanel EspExtra, JLabel AddNewEsp, JSONArray opcoes, String NomeCampoArray, String DescCampoArray, JSONArray OpcoesSelect, String CaminhoArquivo) {
        JComboBox<String> OpcoesExtra = new JComboBox<>();
        if (OpcoesSelect != null) {
            for (int i = 0; i < OpcoesSelect.length(); i++) {
                OpcoesExtra.addItem(OpcoesSelect.getJSONObject(i).getString("b"));
            }
            EspExtra.add(OpcoesExtra);
        }
        AddNewEsp.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (OpcoesSelect != null) {
                    opcoes.put(
                            new JSONObject()
                                    .put(NomeCampoArray, NomeComp.getText())
                                    .put(DescCampoArray, DescComp.getText())
                                    .put("b", OpcoesSelect.getJSONObject(OpcoesExtra.getSelectedIndex()).getString("uuid"))
                                    .put("uuid", Rand.NovoId(32))
                    );
                } else {
                    opcoes.put(
                            new JSONObject()
                                    .put(NomeCampoArray, NomeComp.getText())
                                    .put(DescCampoArray, DescComp.getText())
                                    .put("uuid", Rand.NovoId(32))
                    );
                }
                jsonParser sobrescrever = new jsonParser();
                sobrescrever.sobrescreverArray(CaminhoArquivo, OrganizarASSET.OrganizarJSONArray(opcoes, NomeCampoArray).toString(4));
            }
        });
    }
}
