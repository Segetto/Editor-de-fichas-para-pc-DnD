/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.Fun.Par.Geral;

import static backend.Fun.FichaLer.FichaLerInt;
import static backend.Fun.IntCampo.IntCampo;
import static backend.Fun.Mod.mod;
import static backend.Fun.Proficiencia.Proficiencia;
import static backend.Fun.SalvarFicha.SalvarFicha;
import backend.Fun.VirtualObjects.NewClasseVO;
import backend.jsonParser;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import org.json.JSONArray;
import org.json.JSONObject;
import visual.personagemFicha;

/**
 *
 * @author Admin
 */
public class PericiasP {

    public static void PericiasP(String personagemCaminho, JSONObject ficha, JPanel PericiasContainer) {
        PericiasContainer.removeAll();
        PericiasContainer.revalidate();
        PericiasContainer.repaint();
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
                if (ficha.getJSONArray("f").getJSONObject(periciaI).getJSONObject("a").getBoolean("c") && ficha.getJSONArray("f").getJSONObject(periciaI).getJSONObject("a").getBoolean("b")) {
                    checked = true;
                    bonus = Proficiencia(ficha) * 2;
                } else if (ficha.getJSONArray("f").getJSONObject(periciaI).getJSONObject("a").getBoolean("d") && ficha.getJSONArray("f").getJSONObject(periciaI).getJSONObject("a").getBoolean("b")) {
                    checked = true;
                    bonus = (int) Math.floor(Proficiencia(ficha) / 2);
                } else if (ficha.getJSONArray("f").getJSONObject(periciaI).getJSONObject("a").getBoolean("b")) {
                    checked = true;
                    bonus = Proficiencia(ficha);
                } else {
                    checked = false;
                    bonus = 0;
                }
                checkbox.setSelected(checked);
                JLabel ModLabel = new JLabel();
                if (i > 1) {
                    ModLabel.setText("" + mod(FichaLerInt(ficha, "Status", i + 1), bonus));
                } else {
                    ModLabel.setText("" + mod(FichaLerInt(ficha, "Status", i), bonus));
                }
                JLabel PericiaLabel = new JLabel(Pericias.getJSONObject(i).getJSONArray("a").getJSONObject(j).getString("a"));
                pericia.add(checkbox);
                checkbox.setBackground(new java.awt.Color(23, 23, 23));
                checkbox.setBounds(30, 30, 0, 0);
                checkbox.setCursor(new Cursor(Cursor.HAND_CURSOR));
                PericiaLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
                PericiaLabel.setBounds(30, 30, 0, 0);
                PericiaLabel.setOpaque(false);
                pericia.setOpaque(false);
                pericia.setBounds(30, 100, 0, 0);
                ModLabel.setBounds(30, 30, 0, 0);
                PericiaLabel.setFont(new Font("Sans Serif", Font.PLAIN, 12));
                PericiaLabel.setForeground(new Color(255, 255, 255));
                ModLabel.setFont(new Font("Sans Serif", Font.PLAIN, 12));
                ModLabel.setForeground(new Color(255, 255, 255));
                pericia.add(ModLabel);
                pericia.add(PericiaLabel);
                PericiaRow.add(pericia);
                final int PericiaIListener = periciaI;
                final int iListener = i;
                checkbox.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        int bonusI = 0;
                        ficha.getJSONArray("f").getJSONObject(PericiaIListener).getJSONObject("a").put("b", checkbox.isSelected());
                        if (checkbox.isSelected()) {
                            if (ficha.getJSONArray("f").getJSONObject(PericiaIListener).getJSONObject("a").getBoolean("c") && ficha.getJSONArray("f").getJSONObject(PericiaIListener).getJSONObject("a").getBoolean("b")) {
                                bonusI = Proficiencia(ficha) * 2;
                            } else if (ficha.getJSONArray("f").getJSONObject(PericiaIListener).getJSONObject("a").getBoolean("d") && ficha.getJSONArray("f").getJSONObject(PericiaIListener).getJSONObject("a").getBoolean("b")) {
                                bonusI = (int) Math.floor(Proficiencia(ficha) / 2);
                            } else if (ficha.getJSONArray("f").getJSONObject(PericiaIListener).getJSONObject("a").getBoolean("b")) {
                                bonusI = Proficiencia(ficha);
                            }
                            if (iListener > 1) {
                                ModLabel.setText("" + mod(FichaLerInt(ficha, "Status", iListener + 1), bonusI));
                            } else {
                                ModLabel.setText("" + mod(FichaLerInt(ficha, "Status", iListener), bonusI));
                            }
                        } else {
                            if (iListener > 1) {
                                ModLabel.setText("" + mod(FichaLerInt(ficha, "Status", iListener + 1), 0));
                            } else {
                                ModLabel.setText("" + mod(FichaLerInt(ficha, "Status", iListener), 0));
                            }
                        }

                        SalvarFicha(ficha, personagemCaminho);
                        ModLabel.revalidate();
                        ModLabel.repaint();

                    }
                });
                PericiaLabel.addMouseListener(new java.awt.event.MouseAdapter() {
                    @Override
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        // Criando um painel e adicionando os campos
                        JPanel painel = new JPanel();
                        JCheckBox DobroCheck = new JCheckBox("Dobrar proficiência");
                        DobroCheck.setSelected(ficha.getJSONArray("f").getJSONObject(PericiaIListener).getJSONObject("a").getBoolean("c"));
                        JCheckBox MetadeCheck = new JCheckBox("Metade proficiência");
                        MetadeCheck.setSelected(ficha.getJSONArray("f").getJSONObject(PericiaIListener).getJSONObject("a").getBoolean("d"));
                        painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
                        painel.add(DobroCheck);
                        painel.add(MetadeCheck);
                        int resultado = JOptionPane.showConfirmDialog(null, painel, "Vantagem e desvantagem",
                                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

                        // Verificando se o usuário pressionou "OK"
                        if (resultado == JOptionPane.OK_OPTION) {
                            boolean dobro = DobroCheck.isSelected();
                            boolean metade = MetadeCheck.isSelected();
                            ficha.getJSONArray("f").getJSONObject(PericiaIListener).getJSONObject("a").put("c", dobro);
                            ficha.getJSONArray("f").getJSONObject(PericiaIListener).getJSONObject("a").put("d", metade);
                            int bonusJ = 0;
                            if (ficha.getJSONArray("f").getJSONObject(PericiaIListener).getJSONObject("a").getBoolean("c") && ficha.getJSONArray("f").getJSONObject(PericiaIListener).getJSONObject("a").getBoolean("b")) {
                                bonusJ = Proficiencia(ficha) * 2;
                            } else if (ficha.getJSONArray("f").getJSONObject(PericiaIListener).getJSONObject("a").getBoolean("d") && ficha.getJSONArray("f").getJSONObject(PericiaIListener).getJSONObject("a").getBoolean("b")) {
                                bonusJ = (int) Math.floor(Proficiencia(ficha) / 2);
                            } else if (ficha.getJSONArray("f").getJSONObject(PericiaIListener).getJSONObject("a").getBoolean("b")) {
                                bonusJ = Proficiencia(ficha);
                            }
                            if (iListener > 1) {
                                ModLabel.setText("" + mod(FichaLerInt(ficha, "Status", iListener + 1), bonusJ));
                            } else {
                                ModLabel.setText("" + mod(FichaLerInt(ficha, "Status", iListener), bonusJ));
                            }
                            ModLabel.revalidate();
                            ModLabel.repaint();
                            SalvarFicha(ficha, personagemCaminho);
                        } else {
                            JOptionPane.showMessageDialog(null, "Operação cancelada.");
                        }

                    }

                });
                periciaI++;
            }
            PericiasContainer.add(PericiaRow);
        }

    }

}
