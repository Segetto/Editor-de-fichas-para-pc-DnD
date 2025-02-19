/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.Funcoes;

import static backend.Funcoes.SalvarFicha.SalvarFicha;
import javax.swing.JTextField;
import org.json.JSONObject;

/**
 *
 * @author Admin
 */
public class VidaSpinner {
     public static void VidaSpinner(String personagemCaminho, JSONObject ficha, JTextField VidaAtual, JTextField VidaTotal, String comando) {
        int vida = Integer.parseInt(VidaAtual.getText());
        switch (comando) {
            case "cura":
                vida++;
                VidaAtual.setText("" + vida);
                break;
            case "dano":
                vida--;
                if (vida < 0) {
                    vida = 0;
                }
                VidaAtual.setText("" + vida);
                break;
        }
        ficha.getJSONArray("a").getJSONObject(0).put("l", vida);
        SalvarFicha(ficha, personagemCaminho);
    }
}
