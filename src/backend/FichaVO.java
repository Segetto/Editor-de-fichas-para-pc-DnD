/*
 * Click nbfs:
 * Click nbfs:
 */
package backend;

import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
import java.awt.event.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import backend.jsonParser;
import backend.trocarPainel;
import java.awt.Dimension;
import java.awt.FlowLayout;
import org.json.JSONArray;
import org.json.JSONObject;
import visual.Classes;
import visual.Opcoes;

/**
 *
 * @author Admin
 */
public class FichaVO {

    jsonParser leitor = new jsonParser();
    private static Timer timer;

    public String FichaLerString(JSONObject ficha, String campo, int i) {
        String resultadoString = "";
        switch (campo) {
            case "nome":
                if (ficha.getJSONArray("a").length() > 0) {
                    resultadoString = ficha.getJSONArray("a").getJSONObject(0).getString("a");
                }
                break;
            case "classe":
                if (ficha.getJSONArray("d").length() > 0) {
                    resultadoString = ficha.getJSONArray("d").getJSONObject(i).getJSONObject("b").getString("b");
                }
                break;
            case "Raca":
                if (ficha.getJSONArray("c").length() > 0) {
                    resultadoString = ficha.getJSONArray("c").getJSONObject(0).getString("b");
                }
                break;
            case "Antecedente":
                if (ficha.getJSONArray("c").length() > 0) {
                    resultadoString = ficha.getJSONArray("a").getJSONObject(0).getString("3");
                }
                break;

        }
        return resultadoString;
    }

    public int FichaLerInt(JSONObject ficha, String valor, int i) {
        int resultadoInt = 0;
        switch (valor) {
            case "nivel":
                if (ficha.getJSONArray("d").getJSONObject(i).getJSONObject("a").getInt("c") >= 0) {
                    resultadoInt = ficha.getJSONArray("d").getJSONObject(i).getJSONObject("a").getInt("c");
                }
                break;
            case "vida atual":
                if (ficha.getJSONArray("a").getJSONObject(0).getInt("l") >= 0) {
                    resultadoInt = ficha.getJSONArray("a").getJSONObject(0).getInt("l");
                }
                break;
            case "vida total":
                if (ficha.getJSONArray("a").getJSONObject(0).getInt("j") >= 0) {
                    resultadoInt = ficha.getJSONArray("a").getJSONObject(0).getInt("j");
                }
                break;
            case "xp":
                if (ficha.getJSONArray("a").getJSONObject(0).getInt("d") >= 0) {
                    resultadoInt = ficha.getJSONArray("a").getJSONObject(0).getInt("d");
                }
                break;
            case "Status":
                if (ficha.getJSONArray("e").getJSONObject(0).getInt("b") > 0) {
                    resultadoInt = ficha.getJSONArray("e").getJSONObject(i).getInt("b");
                }

        }
        return resultadoInt;
    }

    public void IntCampo(JTextField textField) {
        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume();
                }
            }
        });
    }

    public void JanelaP(JPanel janela) {
        janela.requestFocusInWindow();

        janela.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseClicked(java.awt.event.MouseEvent evt) {
                janela.requestFocusInWindow();
            }
        });
    }

    public void XpP(String personagemCaminho, JSONObject ficha, JTextField XpLabel) {
        XpLabel.setText("" + FichaLerInt(ficha, "xp", 0));
        IntCampo(XpLabel);
        XpLabel.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (XpLabel.getText().trim().isEmpty()) {
                    ficha.getJSONArray("e").getJSONObject(0).put("b", 0);
                } else {
                    ficha.getJSONArray("a").getJSONObject(0).put("d", Integer.parseInt(XpLabel.getText()));
                }
                SalvarFicha(ficha, personagemCaminho);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {

                if (XpLabel.getText().trim().isEmpty()) {
                    ficha.getJSONArray("e").getJSONObject(0).put("b", 0);
                } else {
                    ficha.getJSONArray("a").getJSONObject(0).put("d", Integer.parseInt(XpLabel.getText()));
                }
                SalvarFicha(ficha, personagemCaminho);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                SalvarFicha(ficha, personagemCaminho);
            }
        });
    }

    public void SalvarP(JSONObject ficha, JButton salvarBotao, String personagemCaminho) {
        salvarBotao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SalvarFicha(ficha, personagemCaminho);
            }
        });
    }

    public void SalvarFicha(JSONObject ficha, String personagemCaminho) {
        jsonParser leitor = new jsonParser();
        leitor.sobrescreverArquivo(personagemCaminho, ficha.toString(), "personagensJSON/" + FichaLerString(ficha, "nome", 0) + ".json");
    }

    public void NomeP(String personagemCaminho, JSONObject ficha, JTextField LabelNome) {
        LabelNome.setText(FichaLerString(ficha, "nome", 0));
        LabelNome.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                ficha.getJSONArray("a").getJSONObject(0).put("a", LabelNome.getText());
                SalvarFicha(ficha, personagemCaminho);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                ficha.getJSONArray("a").getJSONObject(0).put("a", LabelNome.getText());
                SalvarFicha(ficha, personagemCaminho);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                SalvarFicha(ficha, personagemCaminho);
            }
        });
    }

    public void PericiasP(JSONObject ficha, JPanel PericiasContainer) {
        JSONArray Pericias = new JSONArray(leitor.LerArray("ASSETS/Pericias.json"));
        System.out.println(Pericias);
        PericiasContainer.setLayout(new GridLayout(12, 1));
        PericiasContainer.setBounds(500, 50, 10, 10);

        String[] Status = {"Força", "Destreza", "Inteligência", "Sabedoria", "Carisma"};
        for (int i = 0; i < Pericias.length(); i++) {
            int PericiasLength = Pericias.getJSONObject(i).getJSONArray("a").length();
            JPanel PericiaRow = new JPanel();
            PericiaRow.setLayout(new GridLayout(PericiasLength, 1));

            JLabel PericiaStatus = new JLabel(Status[i]);
            PericiaStatus.setBounds(10, 10, 0, 0);
            PericiaStatus.setHorizontalAlignment(SwingConstants.CENTER);
            PericiasContainer.add(PericiaStatus);
            PericiaRow.setBounds(10, 30 * PericiasLength, 50, 10 * PericiasLength);
            PericiaRow.setBackground(new java.awt.Color(23, 23, 23));
            for (int j = 0; j < PericiasLength; j++) {
                JPanel pericia = new JPanel();
                pericia.setLayout(new GridLayout(1, 3));
                JCheckBox checkbox = new JCheckBox();
                JLabel mod = new JLabel();
                mod.setText(mod(0, FichaLerInt(ficha, "Status", i)));
                JLabel PericiaLabel = new JLabel(Pericias.getJSONObject(i).getJSONArray("a").getJSONObject(j).getString("a"));
                pericia.add(checkbox);
                pericia.add(mod);
                checkbox.setBackground(new java.awt.Color(23, 23, 23));
                checkbox.setBounds(30, 30, 0, 0);
                PericiaLabel.setBounds(30, 30, 0, 0);
                PericiaLabel.setOpaque(false);
                pericia.setOpaque(false);
                pericia.setBounds(30, 100, 0, 0);
                mod.setBounds(30, 30, 0, 0);

                pericia.add(PericiaLabel);
                PericiaRow.add(pericia);

            }
            PericiasContainer.add(PericiaRow);
        }
    }

    public void RacaP(String personagemCaminho, JSONObject ficha, JLabel RacaSelect) {
        RacaLabel(ficha, RacaSelect);
        RacaSelect.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                trocarPainel mudar = new trocarPainel();
                Opcoes novoFrame = new Opcoes(personagemCaminho, ficha, "Raca", RacaSelect);
                mudar.painelChange(novoFrame);
            }
        });
    }

    public void RacaLabel(JSONObject ficha, JLabel RacaSelect) {
        if (!"".equals(FichaLerString(ficha, "Raca", 0))) {
            RacaSelect.setText(FichaLerString(ficha, "Raca", 0));
        }
    }

    public void ClassesP(String personagemCaminho, JSONObject ficha, JLabel ClasseLabel, JLabel ClassesAdd, String personagem, JLabel LevelLabel) {

        ClassesLabel(ficha, ClasseLabel, LevelLabel);

        ClassesAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                trocarPainel mudar = new trocarPainel();
                Classes novoFrame = new Classes(personagemCaminho, ficha, ClasseLabel, personagem, LevelLabel);
                mudar.painelChange(novoFrame);
            }
        });

    }

    public void AntecedenteP(String personagemCaminho, JSONObject ficha, JTextField Antecedente) {
        if (FichaLerString(ficha, "Antecedente", 0).equals("")) {

        } else {
            Antecedente.setText(FichaLerString(ficha, "Antecedente", 0));
        }
        Antecedente.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                ficha.getJSONArray("a").getJSONObject(0).put("3", Antecedente.getText());
                SalvarFicha(ficha, personagemCaminho);

            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                ficha.getJSONArray("a").getJSONObject(0).put("3", Antecedente.getText());
                SalvarFicha(ficha, personagemCaminho);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                SalvarFicha(ficha, personagemCaminho);

            }
        });
    }

    public void ClassesLabel(JSONObject ficha, JLabel ClasseLabel, JLabel LevelLabel) {
        String ClassesText = "";
        int NivelPlayer = 0;
        for (int i = 0; i < ficha.getJSONArray("d").length(); i++) {
            if (i > 0) {
                NivelPlayer += FichaLerInt(ficha, "nivel", i);
                ClassesText += "&nbsp;/  " + FichaLerString(ficha, "classe", i) + "&nbsp;" + FichaLerInt(ficha, "nivel", i);
            } else {
                ClassesText += FichaLerString(ficha, "classe", i) + "&nbsp;" + FichaLerInt(ficha, "nivel", i);
                NivelPlayer += FichaLerInt(ficha, "nivel", i);
            }
        }
        int width = (int) Math.floor(ClassesText.length() * 4);
        if (width > 300) {
            width = 300;
        }
        System.out.println(width);
        LevelLabel.setText("" + NivelPlayer);
        ClasseLabel.setText("<html> " + ClassesText + " </html>");
        ClasseLabel.setBorder(null);
        ClasseLabel.setPreferredSize(new Dimension(width, 0));
        ClasseLabel.setHorizontalAlignment(SwingConstants.LEFT);
        ClasseLabel.setVerticalAlignment(SwingConstants.CENTER);
    }

    public void VidaP(String personagemCaminho, JSONObject ficha, JTextField VidaAtual, JTextField VidaTotal, JLabel VidaCura, JLabel VidaDano) {
        VidaAtual.setText("" + FichaLerInt(ficha, "vida atual", 0));
        VidaTotal.setText("" + FichaLerInt(ficha, "vida total", 0));
        IntCampo(VidaTotal);
        IntCampo(VidaAtual);
        VidaCura.addMouseListener(new java.awt.event.MouseAdapter() {

            private int delay = 500;

            @Override
            public void mousePressed(MouseEvent e) {
                timer = new Timer(delay, evt -> {

                    if (delay > 100) {
                        delay *= 0.5;
                        timer.setDelay(delay);
                    }
                    VidaSpinner(personagemCaminho, ficha, VidaAtual, VidaTotal, "cura");
                });
                timer.start();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                timer.stop();
                delay = 500;
            }

            public void mouseClicked(java.awt.event.MouseEvent evt) {
                VidaSpinner(personagemCaminho, ficha, VidaAtual, VidaTotal, "cura");
            }
        });
        VidaDano.addMouseListener(new java.awt.event.MouseAdapter() {
            private int delay = 500;

            @Override
            public void mousePressed(MouseEvent e) {
                timer = new Timer(delay, evt -> {

                    if (delay > 100) {
                        delay *= 0.5;
                        timer.setDelay(delay);
                    }
                    VidaSpinner(personagemCaminho, ficha, VidaAtual, VidaTotal, "dano");
                });
                timer.start();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                timer.stop();
                delay = 500;
            }

            public void mouseClicked(java.awt.event.MouseEvent evt) {
                VidaSpinner(personagemCaminho, ficha, VidaAtual, VidaTotal, "dano");
            }
        });
        VidaAtual.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {

                if (VidaTotal.getText().trim().isEmpty()) {
                    ficha.getJSONArray("e").getJSONObject(0).put("l", 0);
                } else {
                    ficha.getJSONArray("a").getJSONObject(0).put("l", Integer.parseInt(VidaTotal.getText()));
                }
                SalvarFicha(ficha, personagemCaminho);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {

                if (VidaTotal.getText().trim().isEmpty()) {
                    ficha.getJSONArray("e").getJSONObject(0).put("l", 0);
                } else {
                    ficha.getJSONArray("a").getJSONObject(0).put("l", Integer.parseInt(VidaTotal.getText()));
                }
                SalvarFicha(ficha, personagemCaminho);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                SalvarFicha(ficha, personagemCaminho);

            }
        });
        VidaTotal.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {

                if (VidaTotal.getText().trim().isEmpty()) {
                    ficha.getJSONArray("e").getJSONObject(0).put("j", 0);
                } else {
                    ficha.getJSONArray("a").getJSONObject(0).put("j", Integer.parseInt(VidaTotal.getText()));
                }
                SalvarFicha(ficha, personagemCaminho);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {

                if (VidaTotal.getText().trim().isEmpty()) {
                    ficha.getJSONArray("e").getJSONObject(0).put("j", 0);
                } else {
                    ficha.getJSONArray("a").getJSONObject(0).put("j", Integer.parseInt(VidaTotal.getText()));
                }
                SalvarFicha(ficha, personagemCaminho);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                SalvarFicha(ficha, personagemCaminho);

            }
        });
    }

    public void VidaSpinner(String personagemCaminho, JSONObject ficha, JTextField VidaAtual, JTextField VidaTotal, String comando) {
        int vida = Integer.parseInt(VidaAtual.getText());
        switch (comando) {
            case "cura":
                vida++;
                VidaAtual.setText("" + vida);
                break;
            case "dano":
                vida--;
                if (vida < 0) {
                    vida = 0;
                }
                VidaAtual.setText("" + vida);
                break;
        }
        ficha.getJSONArray("a").getJSONObject(0).put("l", vida);
        SalvarFicha(ficha, personagemCaminho);
    }

    public String mod(int Status, int bonus) {
        String modifier = "0";
        int num = (int) Math.floor((Status - 10) / 2) + bonus;

        if (num > 0) {
            modifier = "+" + num;
        } else {
            modifier = "" + num;

        }
        return modifier;
    }

    public int Proficiencia(JSONObject ficha) {
        int Bonus = 0;
        int nivel = 0;

        for (int i = 0; i < ficha.getJSONArray("d").length(); i++) {
            nivel += FichaLerInt(ficha, "nivel", i);
        }
        Bonus = (nivel - 1) / 4 + 2;

        return Bonus;
    }

    public void ProfP(JSONObject ficha, JLabel BonusProficienciaLabel) {

        BonusProficienciaLabel.setText("+" + Proficiencia(ficha));
    }

    public void ResistenciaP(String personagemCaminho, JSONObject ficha, JCheckBox ModCheck, JLabel ModRes, int Status) {

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

    public void StatusP(String personagemCaminho, JTextField StatusLabel, JLabel StatusMod, JSONObject ficha, int pos) {
        StatusLabel.setText("" + FichaLerInt(ficha, "Status", pos));
        IntCampo(StatusLabel);
        StatusMod.setText(mod(FichaLerInt(ficha, "Status", pos), 0));
        StatusLabel.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {

                if (StatusLabel.getText().trim().isEmpty()) {
                    ficha.getJSONArray("e").getJSONObject(pos).put("b", 0);
                } else {
                    ficha.getJSONArray("e").getJSONObject(pos).put("b", Integer.parseInt(StatusLabel.getText()));
                }
                StatusMod.setText(mod(FichaLerInt(ficha, "Status", pos), 0));
                SalvarFicha(ficha, personagemCaminho);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (StatusLabel.getText().trim().isEmpty()) {
                    ficha.getJSONArray("e").getJSONObject(pos).put("b", 0);
                } else {
                    ficha.getJSONArray("e").getJSONObject(pos).put("b", Integer.parseInt(StatusLabel.getText()));
                }
                StatusMod.setText(mod(FichaLerInt(ficha, "Status", pos), 0));
                SalvarFicha(ficha, personagemCaminho);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                SalvarFicha(ficha, personagemCaminho);

            }
        });
    }

}
