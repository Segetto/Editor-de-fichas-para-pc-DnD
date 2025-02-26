/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.Fun.Par.Inventario;

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
        gbc.insets = new Insets(0, 0, 5, 0); // Espaço entre os itens

        for (int i = 0; i < ficha.getJSONArray("i").length(); i++) {
            JPanel PainelItem = new JPanel();
            PainelItem.setLayout(new BoxLayout(PainelItem, BoxLayout.Y_AXIS));
            JPanel PainelNomeItem = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JLabel RemoverItem = new JLabel("Remover item");
            RemoverItem.setPreferredSize(new Dimension(404, 15));
            JPanel RemoverItemPainel = new JPanel();
            RemoverItemPainel.setPreferredSize(new Dimension(404, 20));
            RemoverItem.setPreferredSize(new Dimension(84, 20));
            RemoverItem.setHorizontalAlignment(SwingConstants.RIGHT);
            RemoverItem.setForeground(new Color(255, 105, 105));
            RemoverItem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            JLabel NomeItem = new JLabel(ficha.getJSONArray("i").getJSONObject(i).getJSONObject("b").getString("u"));
            ImageIcon icone = new ImageIcon("src/visual/res/down.png");
            JLabel SetaItem = new JLabel(icone);
            SetaItem.setBounds(0, 0, icone.getIconWidth(), icone.getIconHeight());
            NomeItem.setPreferredSize(new Dimension(540, 15));
            NomeItem.setHorizontalAlignment(SwingConstants.CENTER);

            JPanel PainelDescricaoItem = new JPanel();
            PainelDescricaoItem.setLayout(new BoxLayout(PainelDescricaoItem, BoxLayout.Y_AXIS));
            JLabel DescricaoItem = new JLabel("<html><div style='width: 324px; padding: 7px;'>" + ficha.getJSONArray("i").getJSONObject(i).getJSONObject("b").getString("v") + "</div></html>");
            PainelNomeItem.add(NomeItem);
            PainelNomeItem.add(SetaItem);
            PainelDescricaoItem.add(DescricaoItem);
            RemoverItemPainel.add(RemoverItem);
            RemoverItemPainel.setOpaque(false);
            PainelDescricaoItem.add(RemoverItemPainel);

            gbc.gridy = i;
            PainelItem.setOpaque(false);
            PainelNomeItem.setOpaque(false);
            PainelDescricaoItem.setOpaque(false);
            PainelItem.add(PainelNomeItem, BorderLayout.NORTH);
            PainelNomeItem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            PainelNomeItem.setBorder(new MatteBorder(0, 0, 1, 0, new Color(105, 105, 195)));
            PainelItens.add(PainelItem, gbc);
            PainelNomeItem.addMouseListener(new MouseAdapter() {
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
        }
    }
}
