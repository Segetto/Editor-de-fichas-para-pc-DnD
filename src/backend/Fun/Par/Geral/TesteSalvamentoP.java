/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.Fun.Par.Geral;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import static backend.Fun.FichaLer.FichaLerBool;
import static backend.Fun.SalvarFicha.SalvarFicha;
import org.json.JSONObject;
import javax.swing.*;

/**
 *
 * @author Admin
 */
public class TesteSalvamentoP {

    public static void TesteSalvamentoP(String personagemCaminho, JSONObject ficha, JCheckBox SalvamentoCheck, int i) {
        SalvamentoCheck.setSelected(FichaLerBool(ficha, "Salvamento", i));
        SalvamentoCheck.addItemListener((ItemEvent e) -> {
            ficha.getJSONArray("h").getJSONObject(i).put("b", SalvamentoCheck.isSelected());
            SalvarFicha(ficha, personagemCaminho);

        });
    }
}
