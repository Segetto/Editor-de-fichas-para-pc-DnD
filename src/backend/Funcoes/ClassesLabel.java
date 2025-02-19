/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.Funcoes;

import static backend.Funcoes.FichaLer.FichaLerInt;
import static backend.Funcoes.FichaLer.FichaLerString;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import org.json.JSONObject;

/**
 *
 * @author Admin
 */
public class ClassesLabel {

    public static void ClassesLabel(JSONObject ficha, JLabel ClasseLabel, JLabel LevelLabel) {
        String ClassesText = "";
        int NivelPlayer = 0;
        int width = 180;
        if (ficha.getJSONArray("d").length() > 0) {
            for (int i = 0; i < ficha.getJSONArray("d").length(); i++) {
                if (i > 0) {
                    NivelPlayer += FichaLerInt(ficha, "nivel", i);
                    ClassesText += "&nbsp;/  " + FichaLerString(ficha, "classe", i) + "&nbsp;" + FichaLerInt(ficha, "nivel", i);
                } else {
                    ClassesText += FichaLerString(ficha, "classe", i) + "&nbsp;" + FichaLerInt(ficha, "nivel", i);
                    NivelPlayer += FichaLerInt(ficha, "nivel", i);
                }
            }

            width = (int) Math.floor(ClassesText.length() * 4);
            if (width > 300) {
                width = 300;
            }
            System.out.println(width);
            LevelLabel.setText("" + NivelPlayer);

            ClasseLabel.setBorder(null);
            ClasseLabel.setHorizontalAlignment(SwingConstants.LEFT);
            ClasseLabel.setVerticalAlignment(SwingConstants.CENTER);
        } else {
            ClassesText = "Selecione a sua classe";
        }
        ClasseLabel.setPreferredSize(new Dimension(width, 0));
        ClasseLabel.setText("<html> " + ClassesText + " </html>");
    }
}
