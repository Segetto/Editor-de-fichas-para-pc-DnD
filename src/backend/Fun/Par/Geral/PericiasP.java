/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.Fun.Par.Geral;

import static backend.Fun.FichaLer.FichaLerInt;
import static backend.Fun.Mod.mod;
import static backend.Fun.Proficiencia.Proficiencia;
import static backend.Fun.SalvarFicha.SalvarFicha;
import backend.jsonParser;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Admin
 */
public class PericiasP {

    public static void PericiasP(String personagemCaminho, JSONObject ficha, JPanel PericiasContainer) {

        JSONArray Pericias = new JSONArray(jsonParser.LerArray("ASSETS/Pericias.json"));

        PericiasContainer.setLayout(new BoxLayout(PericiasContainer, BoxLayout.Y_AXIS));

        PericiasContainer.setBounds(500, 50, 10, 10);

        String[] Status = {"Força", "Destreza", "Inteligência", "Sabedoria", "Carisma"};
        int periciaI = 0;
        boolean checked = false;
        int bonus = 0;
        for (int i = 0; i < Pericias.length(); i++) {

            int PericiasLength = Pericias.getJSONObject(i).getJSONArray("a").length();
            JPanel PericiaRow = new JPanel();
            PericiaRow.setLayout(new GridLayout(PericiasLength, 1));

            JLabel PericiaStatus = new JLabel(Status[i]);
            PericiaStatus.setPreferredSize(new Dimension(0, 46));
            PericiaStatus.setFont(new Font("Sans Serif", Font.BOLD, 16));
            PericiaStatus.setForeground(new Color(255, 255, 255));
            PericiaStatus.setAlignmentX(Component.CENTER_ALIGNMENT);
            PericiasContainer.add(PericiaStatus);
            PericiaRow.setBounds(10, 30 * PericiasLength, 50, 10 * PericiasLength);
            PericiaRow.setBackground(new java.awt.Color(23, 23, 23));
            for (int j = 0; j < PericiasLength; j++) {
                JPanel pericia = new JPanel();
                pericia.setLayout(new FlowLayout(FlowLayout.LEFT));
                JCheckBox checkbox = new JCheckBox();
                if (ficha.getJSONArray("f").getJSONObject(periciaI).getJSONObject("a").getBoolean("b")) {
                    checked = true;
                    bonus = Proficiencia(ficha);
                } else {
                    checked = false;
                    bonus = 0;
                }
                checkbox.setSelected(checked);
                JLabel mod = new JLabel();
                if (i > 1) {
                    mod.setText("" + mod(FichaLerInt(ficha, "Status", i + 1), bonus));
                } else {
                    mod.setText("" + mod(FichaLerInt(ficha, "Status", i), bonus));
                }
                JLabel PericiaLabel = new JLabel(Pericias.getJSONObject(i).getJSONArray("a").getJSONObject(j).getString("a"));
                pericia.add(checkbox);
                checkbox.setBackground(new java.awt.Color(23, 23, 23));
                checkbox.setBounds(30, 30, 0, 0);
                PericiaLabel.setBounds(30, 30, 0, 0);
                PericiaLabel.setOpaque(false);
                pericia.setOpaque(false);
                pericia.setBounds(30, 100, 0, 0);
                mod.setBounds(30, 30, 0, 0);
                PericiaLabel.setFont(new Font("Sans Serif", Font.PLAIN, 12));
                PericiaLabel.setForeground(new Color(255, 255, 255));
                mod.setFont(new Font("Sans Serif", Font.PLAIN, 12));
                mod.setForeground(new Color(255, 255, 255));
                pericia.add(mod);
                pericia.add(PericiaLabel);
                PericiaRow.add(pericia);
                final int PericiaIListener = periciaI;
                final int iListener = i;
                final int BonusListener = Proficiencia(ficha);
                checkbox.addItemListener(new ItemListener() {

                    public void itemStateChanged(ItemEvent e) {

                        if (e.getStateChange() == ItemEvent.SELECTED) {
                            if (iListener > 1) {
                                mod.setText("" + mod(FichaLerInt(ficha, "Status", iListener + 1), BonusListener));
                            } else {
                                mod.setText("" + mod(FichaLerInt(ficha, "Status", iListener), BonusListener));
                            }
                        } else {
                            if (iListener > 1) {
                                mod.setText("" + mod(FichaLerInt(ficha, "Status", iListener + 1), 0));
                            } else {
                                mod.setText("" + mod(FichaLerInt(ficha, "Status", iListener), 0));
                            }
                        }
                        
                        ficha.getJSONArray("f").getJSONObject(PericiaIListener).getJSONObject("a").put("b", checkbox.isSelected());
                        SalvarFicha(ficha, personagemCaminho);
                    }
                });
                periciaI++;
            }
            PericiasContainer.add(PericiaRow);
        }

    }

}
