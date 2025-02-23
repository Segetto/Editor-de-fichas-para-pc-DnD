/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.Fun.Par.Geral;

import static backend.Fun.Proficiencia.Proficiencia;
import javax.swing.JLabel;
import org.json.JSONObject;

/**
 *
 * @author Admin
 */
public class ProfP {
    public static void ProfP(JSONObject ficha, JLabel BonusProficienciaLabel) {

        BonusProficienciaLabel.setText("+" + Proficiencia(ficha));
    }

  
}
