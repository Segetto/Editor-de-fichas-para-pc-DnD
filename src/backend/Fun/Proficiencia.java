/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.Fun;

import static backend.Fun.FichaLer.FichaLerInt;
import org.json.JSONObject;

/**
 *
 * @author Admin
 */
public class Proficiencia {
     public static int Proficiencia(JSONObject ficha) {
        int Bonus;
        int nivel = 0;

        for (int i = 0; i < ficha.getJSONArray("d").length(); i++) {
            nivel += FichaLerInt(ficha, "nivel", i);
        }
        Bonus = (nivel - 1) / 4 + 2;

        return Bonus;
    }
}
