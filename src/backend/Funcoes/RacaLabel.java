/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.Funcoes;

import static backend.Funcoes.FichaLer.FichaLerString;
import javax.swing.JLabel;
import org.json.JSONObject;

/**
 *
 * @author Admin
 */
public class RacaLabel {
        public static void RacaLabel(JSONObject ficha, JLabel RacaSelect) {
        if (!"".equals(FichaLerString(ficha, "Raca", 0))) {
            RacaSelect.setText(FichaLerString(ficha, "Raca", 0));
        }
    }
}
