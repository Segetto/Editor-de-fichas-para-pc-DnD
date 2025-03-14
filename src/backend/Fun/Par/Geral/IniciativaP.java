/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.Fun.Par.Geral;

import static backend.Fun.FichaLer.FichaLerInt;
import backend.Fun.IntCampo;
import static backend.Fun.Mod.mod;
import static backend.Fun.Proficiencia.Proficiencia;
import static backend.Fun.SalvarFicha.SalvarFicha;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import org.json.JSONObject;

/**
 *
 * @author Admin
 */
public class IniciativaP {

    public static void IniciativaP(String personagemCaminho, JSONObject ficha, JLabel IniciativaP) {
        IniciativaP.setText("" + mod(FichaLerInt(ficha, "Status", 1), +ficha.getJSONArray("a").getJSONObject(0).getInt("h")));
        IniciativaP.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTextField bonus = new JTextField("" + ficha.getJSONArray("a").getJSONObject(0).getInt("h"));
                IntCampo.IntCampo(bonus);
                int resultado = JOptionPane.showConfirmDialog(null, bonus, "Bônus de iniciativa",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                if (resultado == JOptionPane.OK_OPTION) {
                    ficha.getJSONArray("a").getJSONObject(0).put("h", Integer.parseInt(bonus.getText()));
                    IniciativaP.setText("" + mod(FichaLerInt(ficha, "Status", 1), + ficha.getJSONArray("a").getJSONObject(0).getInt("h")));
                    bonus.revalidate();
                    bonus.repaint();
                    SalvarFicha(ficha, personagemCaminho);
                } else {
                    JOptionPane.showMessageDialog(null, "Operação cancelada.");
                }

            }

        });
    }
}
