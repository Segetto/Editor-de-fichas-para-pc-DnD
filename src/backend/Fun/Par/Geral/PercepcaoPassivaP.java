/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.Fun.Par.Geral;

import static backend.Fun.SalvarFicha.SalvarFicha;
import static backend.Fun.Proficiencia.Proficiencia;
import static backend.Fun.FichaLer.*;
import static backend.Fun.Mod.mod;
import org.json.*;
import javax.swing.*;

/**
 *
 * @author Admin
 */
public class PercepcaoPassivaP {

    public static void PercepcaoPassivaP(JSONObject ficha, JLabel PercepcaoLabel) {
        if (ficha.getJSONArray("f").getJSONObject(12).getJSONObject("a").getBoolean("b")) {
            PercepcaoLabel.setText("" + mod(FichaLerInt(ficha, "Status", 4), Proficiencia(ficha) + 10));
        } else {
            PercepcaoLabel.setText("" + mod(FichaLerInt(ficha, "Status", 4), 10));

        }
    }
}
