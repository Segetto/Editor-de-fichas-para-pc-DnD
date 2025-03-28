/*
 * Click nbfs:
 * Click nbfs:
 */
package backend.Fun.Par.Magias;

import static backend.Fun.OrgJSONArrayFicha.Organizar;
import static backend.Fun.IntCampo.IntCampo;
import static backend.Fun.SalvarFicha.SalvarFicha;
import java.awt.*;
import java.awt.event.*;
import org.json.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Admin
 */
public class MagiasPanelP {

    public static void MagiasPanelP(String personagemCaminho, JSONObject ficha, JPanel PainelMagiasTela, JPanel PainelMagias, int MagiaLvl, JPanel PMagiasT) {
        PainelMagias.removeAll();
        int HeightInicialJanela = 826;
        PainelMagias.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 0.0;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.insets = new Insets(0, 0, 10, 0);
        ficha.put("r", Organizar(ficha.getJSONArray("r"), "b"));
        JPanel[] MagiasVetor = new JPanel[ficha.getJSONArray("r").length()];

        JPanel PSpinnerUsos = new JPanel();
        PSpinnerUsos.setLayout(new BoxLayout(PSpinnerUsos, BoxLayout.Y_AXIS));
        PSpinnerUsos.setOpaque(false);

        PSpinnerUsos.setPreferredSize(new Dimension(70, 30));
        PSpinnerUsos.setMaximumSize(new Dimension(70, 30));

        ImageIcon SetaUp = new ImageIcon("src/visual/res/SmallUp.png");
        JLabel LSetaUp = new JLabel(SetaUp);
        LSetaUp.setAlignmentX(Component.CENTER_ALIGNMENT);
        LSetaUp.setAlignmentY(Component.TOP_ALIGNMENT);

        JPanel UsosNumeros = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        UsosNumeros.setOpaque(false);

        UsosNumeros.setPreferredSize(new Dimension(70, 20));
        UsosNumeros.setMinimumSize(new Dimension(70, 20));
        UsosNumeros.setMaximumSize(new Dimension(70, 20));

        JLabel UsosAtuais = new JLabel("" + ficha.getJSONArray("t").getJSONObject(MagiaLvl).getInt("c"));
        JLabel Barra = new JLabel("/");
        JTextField UsosTotais = new JTextField("" + ficha.getJSONArray("t").getJSONObject(MagiaLvl).getInt("b"));
        IntCampo(UsosTotais);
        UsosTotais.setOpaque(false);
        UsosTotais.setBorder(null);
        UsosTotais.setPreferredSize(new Dimension(7, 20));
        UsosAtuais.setForeground(Color.WHITE);
        Barra.setForeground(Color.WHITE);
        UsosTotais.setForeground(Color.WHITE);

        UsosNumeros.add(UsosAtuais);
        UsosNumeros.add(Barra);
        UsosNumeros.add(UsosTotais);

        ImageIcon SetaDown = new ImageIcon("src/visual/res/SmallDown.png");
        JLabel LSetaDown = new JLabel(SetaDown, JLabel.CENTER);
        LSetaDown.setAlignmentX(Component.CENTER_ALIGNMENT);
        LSetaDown.setAlignmentY(Component.TOP_ALIGNMENT);

        PSpinnerUsos.add(LSetaUp);
        PSpinnerUsos.add(UsosNumeros);
        PSpinnerUsos.add(LSetaDown);
        if (MagiaLvl > 0) {
            PMagiasT.add(PSpinnerUsos, BorderLayout.EAST);
        }
        SwingWorker<Void, JPanel[]> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() {
                for (int i = 0; i < ficha.getJSONArray("r").length(); i++) {
                    if (ficha.getJSONArray("r").getJSONObject(i).getJSONObject("b").getInt("k") == MagiaLvl) {
                        JPanel PainelMagia = new JPanel();
                        PainelMagia.setLayout(new BoxLayout(PainelMagia, BoxLayout.Y_AXIS));
                        JPanel PainelNomeEsp = new JPanel(new BorderLayout());
                        JLabel RemoverEsp = new JLabel("Remover Especialização");
                        String placeholder = "Informações adicionais";
                        String Texto = placeholder;

                        if (ficha.getJSONArray("r").getJSONObject(i).getJSONObject("a").has("c") && !ficha.getJSONArray("r").getJSONObject(i).getJSONObject("a").getString("c").equals("")) {
                            Texto = ficha.getJSONArray("r").getJSONObject(i).getJSONObject("a").getString("c");
                        }
                        int maxHeight = 150;
                        int maxWidth = 400;

                        JPanel RemoverEspPainel = new JPanel();
                        RemoverEspPainel.setPreferredSize(new Dimension(470, 20));

                        RemoverEsp.setForeground(new Color(255, 105, 105));
                        RemoverEsp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        JLabel NomeEsp = new JLabel("    " + ficha.getJSONArray("r").getJSONObject(i).getJSONObject("b").getString("b"));
                        ImageIcon icone = new ImageIcon("src/visual/res/down.png");
                        JLabel SetaEsp = new JLabel(icone);
                        SetaEsp.setBounds(0, 0, icone.getIconWidth(), icone.getIconHeight());
                        NomeEsp.setPreferredSize(new Dimension(470, 15));
                        NomeEsp.setHorizontalAlignment(SwingConstants.LEFT);
                        NomeEsp.setForeground(new Color(255, 255, 255));
                        JRadioButton Preparada = new JRadioButton();
                        Preparada.setSelected(ficha.getJSONArray("r").getJSONObject(i).getJSONObject("a").getBoolean("e"));
                        JPanel PainelDescricaoEsp = new JPanel();
                        PainelDescricaoEsp.setLayout(new BoxLayout(PainelDescricaoEsp, BoxLayout.Y_AXIS));
                        JPanel PDescricaoEspTexto = new JPanel();
                        JLabel DescricaoEsp = new JLabel("<html><div style='width: 404px; padding: 7px;'>"
                                + "<br> Escola: " + ficha.getJSONArray("r").getJSONObject(i).getJSONObject("b").getString("d") + "<br><br>"
                                + "Duração: " + ficha.getJSONArray("r").getJSONObject(i).getJSONObject("b").getString("e") + "<br><br>"
                                + "Tempo de conjuração: " + ficha.getJSONArray("r").getJSONObject(i).getJSONObject("b").getString("f") + "<br><br>"
                                + "Alcance: " + ficha.getJSONArray("r").getJSONObject(i).getJSONObject("b").getString("g") + "<br><br>"
                                + "Componentes: " + ficha.getJSONArray("r").getJSONObject(i).getJSONObject("b").getString("i") + "<br><br>"
                                + ficha.getJSONArray("r").getJSONObject(i).getJSONObject("b").getString("c")
                                + "</div></html>");
                        DescricaoEsp.setForeground(new Color(255, 255, 255));
                        if(MagiaLvl > 0){
                            PainelNomeEsp.add(Preparada, BorderLayout.WEST);
                        }
                        PainelNomeEsp.add(NomeEsp, BorderLayout.CENTER);
                        PainelNomeEsp.add(SetaEsp, BorderLayout.EAST);
                        PDescricaoEspTexto.add(DescricaoEsp);
                        PDescricaoEspTexto.setOpaque(false);
                        PainelDescricaoEsp.add(PDescricaoEspTexto);
                        RemoverEspPainel.add(RemoverEsp);
                        RemoverEspPainel.setOpaque(false);
                        PainelDescricaoEsp.add(RemoverEspPainel);
                        final String idEspFicha = ficha.getJSONArray("r").getJSONObject(i).getJSONObject("a").getString("uuid");
                        PainelMagia.setOpaque(false);
                        PainelNomeEsp.setOpaque(false);
                        PainelDescricaoEsp.setOpaque(false);
                        PainelDescricaoEsp.setPreferredSize(new Dimension(300, PainelDescricaoEsp.getPreferredSize().height));
                        PainelMagia.add(PainelNomeEsp);
                        PainelNomeEsp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        PainelNomeEsp.setBorder(new MatteBorder(0, 0, 1, 0, new Color(35, 35, 195)));
                        MagiasVetor[i] = PainelMagia;
                        final int PosIP = i;
                        Preparada.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                ficha.getJSONArray("r").getJSONObject(PosIP).getJSONObject("a").put("e", Preparada.isSelected());
                                SalvarFicha(ficha, personagemCaminho);
                            }
                        });
                        PainelNomeEsp.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                int heightChange = 0;

                                if (PainelDescricaoEsp.getParent() != null) {
                                    PainelMagia.remove(PainelDescricaoEsp);
                                    ImageIcon icone = new ImageIcon("src/visual/res/down.png");
                                    SetaEsp.setIcon(icone);
                                    for (Component comp : PainelMagiasTela.getComponents()) {
                                        if (comp instanceof JPanel) {
                                            JPanel panel = (JPanel) comp;

                                            heightChange += panel.getPreferredSize().height;
                                        }
                                    }
                                    PainelMagiasTela.setPreferredSize(new Dimension(PainelMagiasTela.getWidth(), (heightChange + HeightInicialJanela)));
                                } else {
                                    PainelMagia.add(PainelDescricaoEsp);
                                    ImageIcon icone = new ImageIcon("src/visual/res/up.png");
                                    SetaEsp.setIcon(icone);
                                    for (Component comp : PainelMagiasTela.getComponents()) {
                                        if (comp instanceof JPanel) {
                                            JPanel panel = (JPanel) comp;

                                            heightChange += panel.getPreferredSize().height;
                                        }
                                    }
                                    PainelMagiasTela.setPreferredSize(new Dimension(PainelMagiasTela.getWidth(), (heightChange + HeightInicialJanela)));
                                }
                                PainelMagia.revalidate();
                                PainelMagia.repaint();
                            }
                        });
                        int RemoveI = i;
                        RemoverEsp.addMouseListener(new MouseAdapter() {

                            @Override

                            public void mouseClicked(MouseEvent e) {
                                for (int j = 0; j < ficha.getJSONArray("r").length(); j++) {
                                    if (ficha.getJSONArray("r").getJSONObject(j).getJSONObject("a").getString("uuid").equals(idEspFicha)) {
                                        PainelMagias.remove(PainelMagia);
                                        ficha.getJSONArray("r").remove(j);
                                    }
                                }
                                int heightChangeDelete = 0;
                                for (Component comp : PainelMagiasTela.getComponents()) {
                                    if (comp instanceof JPanel) {
                                        JPanel panel = (JPanel) comp;

                                        heightChangeDelete += panel.getPreferredSize().height;
                                    }
                                }
                                PainelMagiasTela.setPreferredSize(new Dimension(PainelMagias.getWidth(), (heightChangeDelete + HeightInicialJanela)));
                                PainelMagias.revalidate();
                                PainelMagias.repaint();
                                SalvarFicha(ficha, personagemCaminho);
                            }
                        });

                    }
                }
                return null;
            }

            @Override
            protected void done() {
                try {
                    get();
                    for (JPanel Painel : MagiasVetor) {
                        if (Painel != null) {
                            gbc.gridy++;
                            PainelMagias.add(Painel, gbc); 
                        }
                    }
                    int height = 0;
                    for (Component comp : PainelMagiasTela.getComponents()) {
                        if (comp instanceof JPanel) {
                            JPanel panel = (JPanel) comp;

                            height += panel.getPreferredSize().height + 1;
                        }
                    }
                    PainelMagiasTela.setPreferredSize(new Dimension(PainelMagiasTela.getWidth(), height + HeightInicialJanela));
                    PainelMagias.revalidate();
                    PainelMagias.repaint();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        };
        worker.execute();
        LSetaUp.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                if (ficha.getJSONArray("t").getJSONObject(MagiaLvl).getInt("c") < ficha.getJSONArray("t").getJSONObject(MagiaLvl).getInt("b")) {
                    ficha.getJSONArray("t").getJSONObject(MagiaLvl).put("c", ficha.getJSONArray("t").getJSONObject(MagiaLvl).getInt("c") + 1);
                    UsosAtuais.setText("" + ficha.getJSONArray("t").getJSONObject(MagiaLvl).getInt("c"));
                    SalvarFicha(ficha, personagemCaminho);
                }
            }
        });
        LSetaDown.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                if (ficha.getJSONArray("t").getJSONObject(MagiaLvl).getInt("c") > 0) {
                    ficha.getJSONArray("t").getJSONObject(MagiaLvl).put("c", ficha.getJSONArray("t").getJSONObject(MagiaLvl).getInt("c") - 1);
                    UsosAtuais.setText("" + ficha.getJSONArray("t").getJSONObject(MagiaLvl).getInt("c"));
                    SalvarFicha(ficha, personagemCaminho);
                }
            }
        });
        UsosTotais.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if (UsosTotais.getText().trim().isEmpty()) {
                    ficha.getJSONArray("t").getJSONObject(MagiaLvl).put("b", 0);
                } else {
                    ficha.getJSONArray("t").getJSONObject(MagiaLvl).put("b", Integer.parseInt(UsosTotais.getText()));
                }
                SalvarFicha(ficha, personagemCaminho);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {

                if (UsosTotais.getText().trim().isEmpty()) {
                    ficha.getJSONArray("t").getJSONObject(MagiaLvl).put("b", 0);
                } else {
                    ficha.getJSONArray("t").getJSONObject(MagiaLvl).put("b", Integer.parseInt(UsosTotais.getText()));
                }
                SalvarFicha(ficha, personagemCaminho);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                SalvarFicha(ficha, personagemCaminho);
            }
        });
    }
}
