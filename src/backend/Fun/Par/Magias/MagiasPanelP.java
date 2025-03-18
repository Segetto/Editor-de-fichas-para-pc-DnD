/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.Fun.Par.Magias;

import static backend.Fun.SalvarFicha.SalvarFicha;
import java.awt.*;
import java.awt.event.*;
import org.json.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 *
 * @author Admin
 */
public class MagiasPanelP {

    public static void MagiasPanelP(String personagemCaminho, JSONObject ficha, JPanel PainelMagiasTela, JPanel PainelMagias, int MagiaLvl) {
        PainelMagias.removeAll();
        PainelMagias.revalidate();
        PainelMagias.repaint();
        int HeightInicialJanela = 826;
        PainelMagias.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 0.0;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.insets = new Insets(0, 0, 10, 0);

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
                NomeEsp.setForeground(new Color(255,255,255));
                JPanel PainelDescricaoEsp = new JPanel();
                PainelDescricaoEsp.setLayout(new BoxLayout(PainelDescricaoEsp, BoxLayout.Y_AXIS));
                JPanel PDescricaoEspTexto = new JPanel();
                JLabel DescricaoEsp = new JLabel("<html><div style='width: 404px; padding: 7px;'>" + 
                        "<br> Escola: " + ficha.getJSONArray("r").getJSONObject(i).getJSONObject("b").getString("d") + "<br><br>" +
                        "Duração: " + ficha.getJSONArray("r").getJSONObject(i).getJSONObject("b").getString("e") + "<br><br>" +
                        "Tempo de conjuração: " + ficha.getJSONArray("r").getJSONObject(i).getJSONObject("b").getString("f") + "<br><br>" +
                        "Alcance: " + ficha.getJSONArray("r").getJSONObject(i).getJSONObject("b").getString("g") + "<br><br>" +
                        "Componentes: " + ficha.getJSONArray("r").getJSONObject(i).getJSONObject("b").getString("i") + "<br><br>" +
                        ficha.getJSONArray("r").getJSONObject(i).getJSONObject("b").getString("c")
                        + "</div></html>");
                DescricaoEsp.setForeground(new Color(255,255,255));
                PainelNomeEsp.add(NomeEsp, BorderLayout.CENTER);
                PainelNomeEsp.add(SetaEsp, BorderLayout.EAST);
                PDescricaoEspTexto.add(DescricaoEsp);
                PDescricaoEspTexto.setOpaque(false);
                PainelDescricaoEsp.add(PDescricaoEspTexto);
                RemoverEspPainel.add(RemoverEsp);
                RemoverEspPainel.setOpaque(false);
                PainelDescricaoEsp.add(RemoverEspPainel);
                final String idEspFicha = ficha.getJSONArray("r").getJSONObject(i).getJSONObject("a").getString("uuid");
                gbc.gridy = i;
                PainelMagia.setOpaque(false);
                PainelNomeEsp.setOpaque(false);
                PainelDescricaoEsp.setOpaque(false);
                PainelDescricaoEsp.setPreferredSize(new Dimension(300, PainelDescricaoEsp.getPreferredSize().height));
                PainelMagia.add(PainelNomeEsp);
                PainelNomeEsp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                PainelNomeEsp.setBorder(new MatteBorder(0, 0, 1, 0, new Color(35, 35, 195)));
                PainelMagias.add(PainelMagia, gbc);

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
                        System.out.println(PainelMagiasTela.getHeight());
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
        int height = 0;
        for (Component comp : PainelMagiasTela.getComponents()) {
            if (comp instanceof JPanel) {
                JPanel panel = (JPanel) comp;

                height += panel.getPreferredSize().height + 1;
            }
        }
        PainelMagiasTela.setPreferredSize(new Dimension(PainelMagiasTela.getWidth(), height + HeightInicialJanela));
        System.out.println(height);
        PainelMagias.revalidate();
        PainelMagias.repaint();
    }


}
