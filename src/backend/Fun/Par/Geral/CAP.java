/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.Fun.Par.Geral;

import static backend.Fun.FichaLer.FichaLerInt;
import org.json.*;
import javax.swing.*;
import backend.Fun.IntCampo;
import static backend.Fun.Mod.mod;
import static backend.Fun.SalvarFicha.SalvarFicha;

/**
 *
 * @author Admin
 */
public class CAP {

    public static void CAP(String personagemCaminho, JSONObject ficha, JLabel CA) {
        CA.setText("" + mod(FichaLerInt(ficha, "Status", 1), 10 + ficha.getJSONArray("a").getJSONObject(0).getInt("g")));
        CA.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTextField bonus = new JTextField("" + ficha.getJSONArray("a").getJSONObject(0).getInt("g"));
                IntCampo.IntCampo(bonus);
                int resultado = JOptionPane.showConfirmDialog(null, bonus, "Bônus de Classe de armadura",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                int AntigoValor = ficha.getJSONArray("a").getJSONObject(0).getInt("g");
                if (resultado == JOptionPane.OK_OPTION) {
                    ficha.getJSONArray("a").getJSONObject(0).put("g", Integer.parseInt(bonus.getText()));
                    CA.setText("+" + (Integer.parseInt(CA.getText()) + ficha.getJSONArray("a").getJSONObject(0).getInt("g") - AntigoValor));
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
