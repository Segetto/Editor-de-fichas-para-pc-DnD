/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.Fun;

import static backend.Fun.FichaLer.FichaLerString;
import javax.swing.JLabel;
import org.json.JSONObject;

/**
 *
 * @author Admin
 */
public class OptionLabel {
        public static void OptionLabel(JSONObject ficha, JLabel OptionSelect, String Option) {
        if (!"".equals(FichaLerString(ficha, Option, 0))) {
            OptionSelect.setText(FichaLerString(ficha, Option, 0));
        }
    }
}
