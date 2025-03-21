/*
 * Click nbfs:
 * Click nbfs:
 */
package backend.Fun.Par.Especializacao;

import static backend.Fun.SalvarFicha.SalvarFicha;
import java.awt.*;
import static backend.Fun.Par.Inventario.InformacoesAdicionaisP.InformacoesP;
import java.awt.event.*;
import org.json.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 *
 * @author Admin
 */
public class EspecializacaoPanelP {

    public static void EspecializacaoPanelP(String personagemCaminho, JSONObject ficha, JPanel PainelCaracteristicas, String VetorNome, String TituloCaminho, String DescricaoCaminho, JPanel PainelEspecializacoes) {
        PainelCaracteristicas.removeAll();
        PainelCaracteristicas.revalidate();
        PainelCaracteristicas.repaint();
        int HeightInicialJanela = 192;
        PainelCaracteristicas.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 0.0;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.insets = new Insets(0, 0, 10, 0);
        SwingWorker<Void, JPanel[]> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() {
                for (int i = 0; i < ficha.getJSONArray(VetorNome).length(); i++) {
                    JPanel PainelCaracteristica = new JPanel();
                    PainelCaracteristica.setLayout(new BoxLayout(PainelCaracteristica, BoxLayout.Y_AXIS));
                    JPanel PainelNomeEsp = new JPanel(new FlowLayout(FlowLayout.LEFT));
                    JLabel RemoverEsp = new JLabel("Remover Especialização");
                    String placeholder = "Informações adicionais";
                    String Texto = placeholder;

                    if (ficha.getJSONArray(VetorNome).getJSONObject(i).getJSONObject("a").has("c") && !ficha.getJSONArray(VetorNome).getJSONObject(i).getJSONObject("a").getString("c").equals("")) {
                        Texto = ficha.getJSONArray(VetorNome).getJSONObject(i).getJSONObject("a").getString("c");
                    }
                    JTextArea InformacoesAdicionais = new JTextArea(3, 5);
                    InformacoesAdicionais.setText(Texto);
                    JPanel PainelInformacoesAdicionais = new JPanel(new FlowLayout());
                    InformacoesTamanho(InformacoesAdicionais);
                    InformacoesP(personagemCaminho, i, ficha, InformacoesAdicionais);
                    int maxHeight = 150;
                    int maxWidth = 400;
                    InformacoesAdicionais.setLineWrap(true);
                    InformacoesAdicionais.setWrapStyleWord(true);
                    InformacoesAdicionais.setOpaque(true);

                    JScrollPane scrollPaneInf = new JScrollPane(InformacoesAdicionais);
                    scrollPaneInf.setPreferredSize(new Dimension(maxWidth, maxHeight));
                    scrollPaneInf.setOpaque(false);
                    InformacoesAdicionais.setBackground(new Color(23, 23, 23));
                    InformacoesAdicionais.setBorder(BorderFactory.createEmptyBorder());
                    PainelInformacoesAdicionais.add(scrollPaneInf);
                    PainelInformacoesAdicionais.setOpaque(false);
                    JPanel RemoverEspPainel = new JPanel();
                    RemoverEspPainel.setPreferredSize(new Dimension(470, 20));

                    RemoverEsp.setForeground(new Color(255, 105, 105));
                    RemoverEsp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    JLabel NomeEsp = new JLabel(ficha.getJSONArray(VetorNome).getJSONObject(i).getJSONObject("b").getString(TituloCaminho));
                    ImageIcon icone = new ImageIcon("src/visual/res/down.png");
                    JLabel SetaEsp = new JLabel(icone);
                    SetaEsp.setBounds(0, 0, icone.getIconWidth(), icone.getIconHeight());
                    NomeEsp.setPreferredSize(new Dimension(470, 15));
                    NomeEsp.setHorizontalAlignment(SwingConstants.LEFT);
                    NomeEsp.setForeground(new Color(255, 255, 255));

                    JPanel PainelDescricaoEsp = new JPanel();
                    PainelDescricaoEsp.setLayout(new BoxLayout(PainelDescricaoEsp, BoxLayout.Y_AXIS));
                    JLabel DescricaoEsp = new JLabel("<html><div style='width: 304px; padding: 7px;'>" + ficha.getJSONArray(VetorNome).getJSONObject(i).getJSONObject("b").getString(DescricaoCaminho) + "</div></html>");
                    PainelNomeEsp.add(NomeEsp);
                    PainelNomeEsp.add(SetaEsp);
                    PainelDescricaoEsp.add(DescricaoEsp);
                    RemoverEspPainel.add(RemoverEsp);
                    RemoverEspPainel.setOpaque(false);
                    PainelDescricaoEsp.add(PainelInformacoesAdicionais);
                    PainelDescricaoEsp.add(RemoverEspPainel);
                    final String idEspFicha = ficha.getJSONArray(VetorNome).getJSONObject(i).getJSONObject("a").getString("uuid");
                    gbc.gridy = i;
                    PainelCaracteristica.setOpaque(false);
                    PainelNomeEsp.setOpaque(false);
                    PainelDescricaoEsp.setOpaque(false);
                    PainelDescricaoEsp.setPreferredSize(new Dimension(300, PainelDescricaoEsp.getPreferredSize().height));
                    PainelCaracteristica.add(PainelNomeEsp);
                    PainelNomeEsp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    PainelNomeEsp.setBorder(new MatteBorder(0, 0, 1, 0, new Color(35, 35, 195)));
                    PainelCaracteristicas.add(PainelCaracteristica, gbc);

                    PainelNomeEsp.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            int heightChange = 0;

                            if (PainelDescricaoEsp.getParent() != null) {
                                PainelCaracteristica.remove(PainelDescricaoEsp);
                                ImageIcon icone = new ImageIcon("src/visual/res/down.png");
                                SetaEsp.setIcon(icone);
                                for (Component comp : PainelEspecializacoes.getComponents()) {
                                    if (comp instanceof JPanel) {
                                        JPanel panel = (JPanel) comp;

                                        heightChange += panel.getPreferredSize().height;
                                    }
                                }
                                PainelEspecializacoes.setPreferredSize(new Dimension(PainelEspecializacoes.getWidth(), (heightChange + HeightInicialJanela)));
                            } else {
                                PainelCaracteristica.add(PainelDescricaoEsp);
                                ImageIcon icone = new ImageIcon("src/visual/res/up.png");
                                SetaEsp.setIcon(icone);
                                for (Component comp : PainelEspecializacoes.getComponents()) {
                                    if (comp instanceof JPanel) {
                                        JPanel panel = (JPanel) comp;

                                        heightChange += panel.getPreferredSize().height;
                                    }
                                }
                                PainelEspecializacoes.setPreferredSize(new Dimension(PainelEspecializacoes.getWidth(), (heightChange + HeightInicialJanela)));
                            }
                            System.out.println(PainelCaracteristicas.getHeight());
                            PainelCaracteristica.revalidate();
                            PainelCaracteristica.repaint();
                        }
                    });
                    int RemoveI = i;
                    RemoverEsp.addMouseListener(new MouseAdapter() {

                        @Override

                        public void mouseClicked(MouseEvent e) {
                            for (int j = 0; j < ficha.getJSONArray(VetorNome).length(); j++) {
                                if (ficha.getJSONArray(VetorNome).getJSONObject(j).getJSONObject("a").getString("uuid").equals(idEspFicha)) {
                                    PainelCaracteristicas.remove(PainelCaracteristica);
                                    ficha.getJSONArray(VetorNome).remove(j);
                                }
                            }
                            int heightChangeDelete = 0;
                            for (Component comp : PainelEspecializacoes.getComponents()) {
                                if (comp instanceof JPanel) {
                                    JPanel panel = (JPanel) comp;

                                    heightChangeDelete += panel.getPreferredSize().height;
                                }
                            }
                            PainelEspecializacoes.setPreferredSize(new Dimension(PainelEspecializacoes.getWidth(), (heightChangeDelete + HeightInicialJanela)));
                            PainelCaracteristicas.revalidate();
                            PainelCaracteristicas.repaint();
                            SalvarFicha(ficha, personagemCaminho);
                        }
                    });
                    InformacoesAdicionais.addFocusListener(new FocusListener() {
                        @Override
                        public void focusGained(FocusEvent e) {

                            if (InformacoesAdicionais.getText().equals(placeholder)) {
                                InformacoesAdicionais.setText("");
                                InformacoesAdicionais.setForeground(new Color(255, 255, 255));
                            }
                        }

                        @Override
                        public void focusLost(FocusEvent e) {

                            if (InformacoesAdicionais.getText().isEmpty()) {
                                InformacoesAdicionais.setText(placeholder);
                                InformacoesAdicionais.setForeground(Color.GRAY);
                            }
                        }
                    });
                }
                return null;
            }

            protected void done() {
                try {
                    get();
                    int height = 0;
                    for (Component comp : PainelEspecializacoes.getComponents()) {
                        if (comp instanceof JPanel) {
                            JPanel panel = (JPanel) comp;

                            height += panel.getPreferredSize().height;
                        }
                    }
                    PainelEspecializacoes.setPreferredSize(new Dimension(PainelEspecializacoes.getWidth(), height + HeightInicialJanela));
                    PainelEspecializacoes.revalidate();
                    PainelEspecializacoes.repaint();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        worker.execute();

    }

    public static void InformacoesTamanho(JTextArea InformacoesAdicionais) {
        int linhas = InformacoesAdicionais.getLineCount();
        InformacoesAdicionais.setRows(linhas);
    }
}
