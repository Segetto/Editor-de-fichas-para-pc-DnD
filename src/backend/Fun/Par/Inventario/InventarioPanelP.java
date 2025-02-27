/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.Fun.Par.Inventario;

import static backend.Fun.SalvarFicha.SalvarFicha;
import java.awt.*;
import static backend.Fun.Proficiencia.Proficiencia;
import static backend.Fun.Mod.mod;
import static backend.Fun.Par.Inventario.InformacoesAdicionaisP.InformacoesP;
import java.awt.event.*;
import org.json.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 *
 * @author Admin
 */
public class InventarioPanelP {

    public static void ItensPanelP(String personagemCaminho, JSONObject ficha, JPanel PainelItens) {
        PainelItens.removeAll();
        PainelItens.revalidate();
        PainelItens.repaint();
        PainelItens.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH; // Expande horizontal e verticalmente
        gbc.weightx = 1.0; // Permite expansão horizontal
        gbc.weighty = 0.0; // Não cresce infinitamente
        gbc.gridwidth = GridBagConstraints.REMAINDER; // Ocupa toda a linha
        gbc.insets = new Insets(0, 0, 10, 0); // Espaço entre os itens

        for (int i = 0; i < ficha.getJSONArray("i").length(); i++) {
            JPanel PainelItem = new JPanel();
            PainelItem.setLayout(new BoxLayout(PainelItem, BoxLayout.Y_AXIS));
            JPanel PainelNomeItem = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JLabel RemoverItem = new JLabel("Remover item");
            String placeholder = "Informações adicionais";
            String Texto = placeholder;

            if (ficha.getJSONArray("i").getJSONObject(i).getJSONObject("a").has("f") && !ficha.getJSONArray("i").getJSONObject(i).getJSONObject("a").getString("f").equals("")) {
                Texto = ficha.getJSONArray("i").getJSONObject(i).getJSONObject("a").getString("f");
            }
            JTextArea InformacoesAdicionais = new JTextArea(3, 20);
            InformacoesAdicionais.setText(Texto);
            JPanel PInfAdicionais = new JPanel(new FlowLayout());
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
            PInfAdicionais.add(scrollPaneInf);
            PInfAdicionais.setOpaque(false);
            RemoverItem.setPreferredSize(new Dimension(84, 15));
            JPanel RemoverItemPainel = new JPanel();
            RemoverItemPainel.setPreferredSize(new Dimension(500, 20));
            RemoverItem.setPreferredSize(new Dimension(84, 20));

            RemoverItem.setForeground(new Color(255, 105, 105));
            RemoverItem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            JLabel NomeItem = new JLabel(ficha.getJSONArray("i").getJSONObject(i).getJSONObject("b").getString("u"));
            ImageIcon icone = new ImageIcon("src/visual/res/down.png");
            JLabel SetaItem = new JLabel(icone);
            SetaItem.setBounds(0, 0, icone.getIconWidth(), icone.getIconHeight());
            NomeItem.setPreferredSize(new Dimension(540, 15));
            NomeItem.setHorizontalAlignment(SwingConstants.LEFT);

            JPanel PainelDescricaoItem = new JPanel();
            JPanel PainelTituloItem = new JPanel();
            PainelTituloItem.setLayout(new BoxLayout(PainelTituloItem, BoxLayout.Y_AXIS));
            PainelDescricaoItem.setLayout(new BoxLayout(PainelDescricaoItem, BoxLayout.Y_AXIS));
            JLabel DescricaoItem = new JLabel("<html><div style='width: 404px; padding: 7px;'>" + ficha.getJSONArray("i").getJSONObject(i).getJSONObject("b").getString("v") + "</div></html>");
            PainelNomeItem.add(NomeItem);
            PainelNomeItem.add(SetaItem);
            PainelDescricaoItem.add(DescricaoItem);
            RemoverItemPainel.add(RemoverItem);
            RemoverItemPainel.setOpaque(false);
            PainelDescricaoItem.add(PInfAdicionais);
            PainelDescricaoItem.add(RemoverItemPainel);
            
            gbc.gridy = i;
            PainelItem.setOpaque(false);
            PainelNomeItem.setOpaque(false);
            PainelTituloItem.setOpaque(false);
            PainelDescricaoItem.setOpaque(false);
            PainelDescricaoItem.setPreferredSize(new Dimension(300, PainelDescricaoItem.getPreferredSize().height));
            PainelTituloItem.add(PainelNomeItem);
            if (ficha.getJSONArray("i").getJSONObject(i).getJSONObject("b").getString("i").equals("Arma") || ficha.getJSONArray("i").getJSONObject(i).getJSONObject("b").getString("i").equals("WEAPON")) {
                JPanel PInfArma = new JPanel(new FlowLayout());
                PInfArma.setOpaque(false);
                JPanel PInfArmaAtaque = new JPanel();
                PInfArmaAtaque.setLayout(new BoxLayout(PInfArmaAtaque, BoxLayout.Y_AXIS));
                PInfArmaAtaque.setOpaque(false);
                JPanel PInfArmaDano = new JPanel();
                PInfArmaDano.setLayout(new BoxLayout(PInfArmaDano, BoxLayout.Y_AXIS));
                PInfArmaDano.setOpaque(false);
                JPanel PInfArmaTipo = new JPanel();
                PInfArmaTipo.setLayout(new BoxLayout(PInfArmaTipo, BoxLayout.Y_AXIS));
                PInfArmaTipo.setOpaque(false);
                JLabel InfArmaAtaqueT = new JLabel("Ataque");
                JLabel InfArmaDanoT = new JLabel("Dano");
                JLabel InfArmaTipoT = new JLabel("Tipo de dano");
                int Status = 0;
                if (ficha.getJSONArray("i").getJSONObject(i).getJSONObject("b").getString("q").equals("STRENGTH")) {
                    Status = ficha.getJSONArray("e").getJSONObject(0).getInt("b");
                } else if (ficha.getJSONArray("i").getJSONObject(i).getJSONObject("b").getString("q").equals("DEXTERITY")) {
                    Status = ficha.getJSONArray("e").getJSONObject(1).getInt("b");
                } else {
                    if (ficha.getJSONArray("e").getJSONObject(1).getInt("b") > ficha.getJSONArray("e").getJSONObject(0).getInt("b")) {
                        Status = ficha.getJSONArray("e").getJSONObject(1).getInt("b");
                    } else {
                        Status = ficha.getJSONArray("e").getJSONObject(0).getInt("b");
                    }
                }
                JLabel InfArmaAtaque = new JLabel("-");
                if (ficha.getJSONArray("i").getJSONObject(i).getJSONObject("a").getBoolean("d")) {
                    InfArmaAtaque.setText("" + mod(Status, Proficiencia(ficha)));
                } else {
                    InfArmaAtaque.setText(mod(Status, 0));
                }
                JLabel InfArmaDano = new JLabel("-");
                JLabel InfArmaTipo = new JLabel("-");
                PInfArmaAtaque.add(InfArmaAtaqueT);
                PInfArmaAtaque.add(InfArmaAtaque);
                PInfArmaDano.add(InfArmaDanoT);
                PInfArmaDano.add(InfArmaDano);
                PInfArmaTipo.add(InfArmaTipoT);
                PInfArmaTipo.add(InfArmaTipo);
                PInfArma.add(PInfArmaAtaque);
                PInfArma.add(PInfArmaDano);
                PInfArma.add(PInfArmaTipo);
                PainelTituloItem.add(PInfArma);
            }
            PainelItem.add(PainelTituloItem);
            PainelTituloItem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            PainelTituloItem.setBorder(new MatteBorder(0, 0, 1, 0, new Color(105, 105, 195)));
            PainelItens.add(PainelItem, gbc);
            PainelTituloItem.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (PainelDescricaoItem.getParent() != null) {
                        PainelItem.remove(PainelDescricaoItem);
                        ImageIcon icone = new ImageIcon("src/visual/res/down.png");
                        SetaItem.setIcon(icone);
                    } else {
                        PainelItem.add(PainelDescricaoItem);
                        ImageIcon icone = new ImageIcon("src/visual/res/up.png");
                        SetaItem.setIcon(icone);

                    }
                    PainelItem.revalidate();
                    PainelItem.repaint();
                }
            });
            int RemoveI = i;
            RemoverItem.addMouseListener(new MouseAdapter() {

                @Override

                public void mouseClicked(MouseEvent e) {
                    PainelItens.remove(PainelItem);
                    ficha.getJSONArray("i").remove(RemoveI);
                    PainelItens.revalidate();
                    PainelItens.repaint();
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
    }

    public static void InformacoesTamanho(JTextArea InformacoesAdicionais) {
        int linhas = InformacoesAdicionais.getLineCount();
        InformacoesAdicionais.setRows(linhas);
    }
}
