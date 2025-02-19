/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.Fun.Par.Geral;

import static backend.Fun.Proficiencia.Proficiencia;
import static backend.Fun.SalvarFicha.SalvarFicha;
import static backend.Fun.Mod.mod;
import static backend.Fun.FichaLer.FichaLerInt;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import org.json.JSONObject;

/**
 *
 * @author Admin
 */
public class ResistenciaP {
     public static void ResistenciaP(String personagemCaminho, JSONObject ficha, JCheckBox ModCheck, JLabel ModRes, int Status) {

        if (ficha.getJSONArray("e").getJSONObject(Status).getBoolean("c")) {
            ModCheck.setSelected(true);
            ModRes.setText("" + mod(FichaLerInt(ficha, "Status", Status), Proficiencia(ficha)));
        } else {
            ModRes.setText("" + mod(FichaLerInt(ficha, "Status", Status), 0));
        }
        ModCheck.addItemListener(new ItemListener() {

            public void itemStateChanged(ItemEvent e) {

                if (e.getStateChange() == ItemEvent.SELECTED) {
                    ModRes.setText("" + mod(FichaLerInt(ficha, "Status", Status), Proficiencia(ficha)));
                } else {
                    ModRes.setText("" + mod(FichaLerInt(ficha, "Status", Status), 0));
                }
                ficha.getJSONArray("e").getJSONObject(Status).put("c", ModCheck.isSelected());
                SalvarFicha(ficha, personagemCaminho);
            }
        });
    }

}
