/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.Fun.Par.Geral;

import static backend.Fun.ClassesLabel.ClassesLabel;
import backend.Fun.trocarPainel;
import javax.swing.JLabel;
import org.json.JSONObject;
import visual.Classes;

/**
 *
 * @author Admin
 */
public class ClassesP {
     public static void ClassesP(String personagemCaminho, JSONObject ficha, JLabel ClasseLabel, JLabel ClassesAdd, String personagem, JLabel LevelLabel) {

        ClassesLabel(ficha, ClasseLabel, LevelLabel);

        ClassesAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                trocarPainel mudar = new trocarPainel();
                Classes novoFrame = new Classes(personagemCaminho, ficha, ClasseLabel, personagem, LevelLabel);
                mudar.painelChange(novoFrame);
            }
        });

    }
}
