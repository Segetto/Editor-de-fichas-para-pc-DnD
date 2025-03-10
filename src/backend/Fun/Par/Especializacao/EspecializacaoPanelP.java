/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
        gbc.fill = GridBagConstraints.BOTH; // Expande horizontal e verticalmente
        gbc.weightx = 1.0; // Permite expansão horizontal
        gbc.weighty = 0.0; // Não cresce infinitamente
        gbc.gridwidth = GridBagConstraints.REMAINDER; // Ocupa toda a linha
        gbc.insets = new Insets(0, 0, 10, 0); // Espaço entre os itens

        for (int i = 0; i < ficha.getJSONArray(VetorNome).length(); i++) {
            JPanel PainelCaracteristica = new JPanel();
            PainelCaracteristica.setLayout(new BoxLayout(PainelCaracteristica, BoxLayout.Y_AXIS));
            JPanel PainelNomeItem = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JLabel RemoverItem = new JLabel("Remover Caracteristíca");
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
            int maxHeight = 150; // Altura máxima (em pixels)
            int maxWidth = 400;  // Largura máxima (em pixels)
            InformacoesAdicionais.setLineWrap(true);  // Para que o texto quebre automaticamente
            InformacoesAdicionais.setWrapStyleWord(true);
            InformacoesAdicionais.setOpaque(true);

            JScrollPane scrollPaneInf = new JScrollPane(InformacoesAdicionais);
            scrollPaneInf.setPreferredSize(new Dimension(maxWidth, maxHeight));
            scrollPaneInf.setOpaque(false);
            InformacoesAdicionais.setBackground(new Color(23, 23, 23));
            InformacoesAdicionais.setBorder(BorderFactory.createEmptyBorder());
            PainelInformacoesAdicionais.add(scrollPaneInf);
            PainelInformacoesAdicionais.setOpaque(false);
            RemoverItem.setPreferredSize(new Dimension(84, 15));
            JPanel RemoverItemPainel = new JPanel();
            RemoverItemPainel.setPreferredSize(new Dimension(470, 20));
            RemoverItem.setPreferredSize(new Dimension(84, 20));

            RemoverItem.setForeground(new Color(255, 105, 105));
            RemoverItem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            JLabel NomeItem = new JLabel(ficha.getJSONArray(VetorNome).getJSONObject(i).getJSONObject("b").getString(TituloCaminho));
            ImageIcon icone = new ImageIcon("src/visual/res/down.png");
            JLabel SetaItem = new JLabel(icone);
            SetaItem.setBounds(0, 0, icone.getIconWidth(), icone.getIconHeight());
            NomeItem.setPreferredSize(new Dimension(470, 15));
            NomeItem.setHorizontalAlignment(SwingConstants.LEFT);

            JPanel PainelDescricaoItem = new JPanel();
            PainelDescricaoItem.setLayout(new BoxLayout(PainelDescricaoItem, BoxLayout.Y_AXIS));
            JLabel DescricaoItem = new JLabel("<html><div style='width: 304px; padding: 7px;'>" + ficha.getJSONArray(VetorNome).getJSONObject(i).getJSONObject("b").getString(DescricaoCaminho) + "</div></html>");
            PainelNomeItem.add(NomeItem);
            PainelNomeItem.add(SetaItem);
            PainelDescricaoItem.add(DescricaoItem);
            RemoverItemPainel.add(RemoverItem);
            RemoverItemPainel.setOpaque(false);
            PainelDescricaoItem.add(PainelInformacoesAdicionais);
            PainelDescricaoItem.add(RemoverItemPainel);
            final String idItemFicha = ficha.getJSONArray(VetorNome).getJSONObject(i).getJSONObject("a").getString("uuid");
            gbc.gridy = i;
            PainelCaracteristica.setOpaque(false);
            PainelNomeItem.setOpaque(false);
            PainelDescricaoItem.setOpaque(false);
            PainelDescricaoItem.setPreferredSize(new Dimension(300, PainelDescricaoItem.getPreferredSize().height));
            PainelCaracteristica.add(PainelNomeItem);
            PainelNomeItem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            PainelNomeItem.setBorder(new MatteBorder(0, 0, 1, 0, new Color(105, 105, 195)));
            PainelCaracteristicas.add(PainelCaracteristica, gbc);

            PainelNomeItem.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    int heightChange = 0;

                    if (PainelDescricaoItem.getParent() != null) {
                        PainelCaracteristica.remove(PainelDescricaoItem);
                        ImageIcon icone = new ImageIcon("src/visual/res/down.png");
                        SetaItem.setIcon(icone);
                        for (Component comp : PainelEspecializacoes.getComponents()) {
                            if (comp instanceof JPanel) {
                                JPanel panel = (JPanel) comp;
                                // Faça algo com cada JPanel encontrado
                                heightChange += panel.getPreferredSize().height;
                            }
                        }
                        PainelEspecializacoes.setPreferredSize(new Dimension(PainelEspecializacoes.getWidth(), (heightChange + HeightInicialJanela)));
                    } else {
                        PainelCaracteristica.add(PainelDescricaoItem);
                        ImageIcon icone = new ImageIcon("src/visual/res/up.png");
                        SetaItem.setIcon(icone);
                        for (Component comp : PainelEspecializacoes.getComponents()) {
                            if (comp instanceof JPanel) {
                                JPanel panel = (JPanel) comp;
                                // Faça algo com cada JPanel encontrado
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
            RemoverItem.addMouseListener(new MouseAdapter() {

                @Override

                public void mouseClicked(MouseEvent e) {
                    for (int j = 0; j < ficha.getJSONArray(VetorNome).length(); j++) {
                        if (ficha.getJSONArray(VetorNome).getJSONObject(j).getJSONObject("a").getString("uuid").equals(idItemFicha)) {
                            PainelCaracteristicas.remove(PainelCaracteristica);
                            ficha.getJSONArray(VetorNome).remove(j);
                        }
                    }
                    int heightChangeDelete = 0;
                    for (Component comp : PainelEspecializacoes.getComponents()) {
                            if (comp instanceof JPanel) {
                                JPanel panel = (JPanel) comp;
                                // Faça algo com cada JPanel encontrado
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
                    // Quando o JTextArea recebe o foco, apaga o placeholder, mas apenas se o campo estiver vazio
                    if (InformacoesAdicionais.getText().equals(placeholder)) {
                        InformacoesAdicionais.setText("");
                        InformacoesAdicionais.setForeground(new Color(255, 255, 255));  // Cor do texto normal
                    }
                }

                @Override
                public void focusLost(FocusEvent e) {
                    // Quando o JTextArea perde o foco, e o texto está vazio, mostra o placeholder
                    if (InformacoesAdicionais.getText().isEmpty()) {
                        InformacoesAdicionais.setText(placeholder);
                        InformacoesAdicionais.setForeground(Color.GRAY);  // Cor do placeholder
                    }
                }
            });
        }
        int height = 0;
        for (Component comp : PainelEspecializacoes.getComponents()) {
            if (comp instanceof JPanel) {
                JPanel panel = (JPanel) comp;
                // Faça algo com cada JPanel encontrado
                height += panel.getPreferredSize().height;
            }
        }
        PainelEspecializacoes.setPreferredSize(new Dimension(PainelEspecializacoes.getWidth(), height + HeightInicialJanela));
        System.out.println(height);
        PainelEspecializacoes.revalidate();
        PainelEspecializacoes.repaint();
    }

    public static void InformacoesTamanho(JTextArea InformacoesAdicionais) {
        int linhas = InformacoesAdicionais.getLineCount();
        InformacoesAdicionais.setRows(linhas);
    }
}
