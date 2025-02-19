/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.Fun.Par.Geral;

import org.json.*;
import javax.swing.*;
import java.awt.*;
import static backend.Fun.FichaLer.FichaLerInt;
import static backend.Fun.Mod.mod;

/**
 *
 * @author Admin
 */
public class CAP {
    public static void CAP(JSONObject ficha, JLabel CA){
        CA.setText("" + mod(FichaLerInt(ficha, "Status", 1), 10));
    }
}
