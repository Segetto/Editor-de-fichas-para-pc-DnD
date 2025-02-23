/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.Fun.Par.Mochila;

import java.awt.*;
import java.awt.event.*;
import org.json.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 *
 * @author Admin
 */
public class ItensPanelP {

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
            JLabel NomeItem = new JLabel(ficha.getJSONArray("i").getJSONObject(i).getJSONObject("b").getString("u"));
            NomeItem.setPreferredSize(new Dimension(580, 15));
            NomeItem.setHorizontalAlignment(SwingConstants.CENTER);

            JPanel PainelDescricaoItem = new JPanel();
            JLabel DescricaoItem = new JLabel("<html><div style='width: 404px;'>" + ficha.getJSONArray("i").getJSONObject(i).getJSONObject("b").getString("v") + "</div></html>");
            DescricaoItem.setLocation(0, 0);
            PainelNomeItem.add(NomeItem);
            PainelDescricaoItem.add(DescricaoItem);

            gbc.gridy = i; // Define a posição na grade
            PainelItem.setOpaque(false);
            PainelNomeItem.setOpaque(false);
            PainelDescricaoItem.setOpaque(false);
            PainelItem.add(PainelNomeItem, BorderLayout.NORTH);
            PainelNomeItem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            PainelNomeItem.setBorder(new MatteBorder(0, 0, 1, 0, new Color(105,105,195)));
            PainelItens.add(PainelItem, gbc);
            PainelNomeItem.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (PainelDescricaoItem.getParent() != null) {
                        PainelItem.remove(PainelDescricaoItem);
                    } else {
                        PainelItem.add(PainelDescricaoItem);
                        

                    }
                    PainelItem.revalidate();
                    PainelItem.repaint();
                }
            });
        }
    }
}
