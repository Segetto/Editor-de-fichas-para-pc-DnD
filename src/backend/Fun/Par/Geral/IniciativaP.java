/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.Fun.Par.Geral;

import static backend.Fun.FichaLer.FichaLerInt;
import static backend.Fun.Mod.mod;
import javax.swing.JLabel;
import org.json.JSONObject;

/**
 *
 * @author Admin
 */
public class IniciativaP {
        public static void IniciativaP(JSONObject ficha, JLabel IniciativaP){
        IniciativaP.setText("" + mod(FichaLerInt(ficha, "Status", 1), 0));
    }
}
