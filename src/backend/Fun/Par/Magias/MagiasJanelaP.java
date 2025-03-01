/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.Fun.Par.Magias;

import backend.Fun.Par.Magias.*;
import static backend.jsonParser.LerArray;
import static backend.Fun.SalvarFicha.SalvarFicha;
import org.json.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.*;
import java.awt.event.*;
import java.text.Collator;
import java.util.*;

/**
 *
 * @author Admin
 */
public class MagiasJanelaP {

    public static void MagiaJanelaP(String personagemCaminho, JSONObject ficha, JPanel PainelMagia, JComboBox Opcoes, JPanel PainelMagiaFicha, JLabel AdicionarSelecionados, String VetorCaminho, JPanel PainelEspecializacoesFicha) {
        String Opcao = (String) Opcoes.getSelectedItem();
        AdicionarEquipamentos(personagemCaminho, ficha, PainelMagia, Opcao, PainelMagiaFicha, AdicionarSelecionados, VetorCaminho, PainelEspecializacoesFicha);
        java.util.List<JSONObject> lista = new java.util.ArrayList<>();
        for (int i = 0; i < ficha.getJSONArray("i").length(); i++) {
            lista.add(ficha.getJSONArray("i").getJSONObject(i));
        }

        // Ordenando a lista com base no campo "b.u"
        Collections.sort(lista, new Comparator<JSONObject>() {
            @Override
            public int compare(JSONObject a, JSONObject b) {
                Collator collator = Collator.getInstance(new Locale("pt", "BR"));
                collator.setStrength(Collator.PRIMARY); // Ignora diferenças de acento
                String nomeA = a.getJSONObject("b").getString("u");
                String nomeB = b.getJSONObject("b").getString("u");
                return collator.compare(nomeA, nomeB);
            }
        });

        // Convertendo de volta para JSONArray
        JSONArray jsonArrayOrdenado = new JSONArray(lista);
        ficha.put("i", jsonArrayOrdenado);
        SalvarFicha(ficha, personagemCaminho);

        Opcoes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String NewOpcao = (String) Opcoes.getSelectedItem();
                AdicionarEquipamentos(personagemCaminho, ficha, PainelMagia, NewOpcao, PainelMagiaFicha, AdicionarSelecionados, VetorCaminho, PainelEspecializacoesFicha);

            }
        });
    }

    public static void AdicionarEquipamentos(String personagemCaminho, JSONObject ficha, JPanel PainelMagia, String TipoMagia, JPanel PainelMagiaFicha, JLabel AdicionarSelecionados, String VetorCaminho, JPanel PainelEspecializacoesFicha) {

        PainelMagia.removeAll();
        PainelMagia.revalidate();
        PainelMagia.repaint();
        PainelMagia.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH; // Expande horizontal e verticalmente
        gbc.weightx = 1.0; // Permite expansão horizontal
        gbc.weighty = 0.0; // Não cresce infinitamente
        gbc.gridwidth = GridBagConstraints.REMAINDER; // Ocupa toda a linha
        gbc.insets = new Insets(0, 0, 5, 0); // Espaço entre os Especializacoes
        JSONArray Especializacoes = new JSONArray(LerArray("ASSETS/Equipamento.json"));
        JSONArray EspecializacoesNovas = new JSONArray();
        for (int i = 0; i < Especializacoes.length(); i++) {
            JPanel PainelNewMagia = new JPanel();
            JCheckBox check = new JCheckBox();

            PainelNewMagia.setLayout(new BoxLayout(PainelNewMagia, BoxLayout.Y_AXIS));
            JPanel PainelNomeMagia = new JPanel(new BorderLayout());
            JLabel NomeMagia = new JLabel(Especializacoes.getJSONObject(i).getString("u"));
            ImageIcon Icone = new ImageIcon("src/visual/res/SmallDown.png");
            JLabel UpOrDown = new JLabel(Icone);

            NomeMagia.setHorizontalAlignment(SwingConstants.CENTER);

            JPanel PainelDescricaoMagia = new JPanel();
            JLabel DescricaoMagia = new JLabel();
            int width = SwingUtilities.getWindowAncestor(PainelNewMagia).getSize().width;
            if (Especializacoes.getJSONObject(i).has("v")) {
                DescricaoMagia.setText("<html><body style='width:" + (width / 2.5) + "px'>" + Especializacoes.getJSONObject(i).getString("v") + "</body></html>");
            } else {
                DescricaoMagia.setText("<html><body style='width:" + (width / 2.5) + "px'> " + "</body></html>");
            }
            DescricaoMagia.setLocation(0, 0);
            PainelNomeMagia.add(check, BorderLayout.WEST);
            PainelNomeMagia.add(NomeMagia, BorderLayout.CENTER);
            PainelNomeMagia.add(UpOrDown, BorderLayout.EAST);

            PainelDescricaoMagia.add(DescricaoMagia);
            gbc.gridy = i; // Define a posição na grade
            PainelNomeMagia.setOpaque(false);
            PainelDescricaoMagia.setOpaque(false);
            PainelNewMagia.add(PainelNomeMagia, BorderLayout.NORTH);
            PainelNomeMagia.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            PainelNomeMagia.setBorder(new MatteBorder(0, 0, 1, 0, new Color(105, 105, 195)));

            if (TipoMagia.equals(Especializacoes.getJSONObject(i).getString("i"))) {
                PainelMagia.setOpaque(false);
                PainelMagia.add(PainelNewMagia, gbc);
                PainelMagia.revalidate();
                PainelMagia.repaint();
            }
            int iComp = i;

            SwingUtilities.getWindowAncestor(PainelMagia).addComponentListener(new ComponentAdapter() {
                @Override
                public void componentResized(ComponentEvent e) {
                    int width = SwingUtilities.getWindowAncestor(PainelMagia).getSize().width;
                    // Atualiza o texto, ajustando a largura do body no HTML
                    if (Especializacoes.getJSONObject(iComp).has("v")) {
                        DescricaoMagia.setText("<html><body style='width:" + (width / 2.5) + "px'>" + Especializacoes.getJSONObject(iComp).getString("v") + "</body></html>");
                    } else {
                        DescricaoMagia.setText("<html><body style='width:" + (width / 2.5) + "px'> " + "</body></html>");
                    }
                }
            });
            PainelNomeMagia.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (PainelDescricaoMagia.getParent() != null) {
                        ImageIcon Icone = new ImageIcon("src/visual/res/SmallDown.png");
                        UpOrDown.setIcon(Icone);
                        PainelNewMagia.remove(PainelDescricaoMagia);
                    } else {
                        PainelNewMagia.add(PainelDescricaoMagia);
                        ImageIcon Icone = new ImageIcon("src/visual/res/SmallUp.png");
                        UpOrDown.setIcon(Icone);
                    }
                    PainelNewMagia.revalidate();
                    PainelNewMagia.repaint();
                }
            });

            check.addItemListener(new ItemListener() {
                int posicao = 0;

                public void itemStateChanged(ItemEvent e) {
                    JSONObject NovaMagia = new JSONObject();
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        String descricao = "";
                        if (Especializacoes.getJSONObject(iComp).has("v")) {
                            descricao = Especializacoes.getJSONObject(iComp).getString("v");
                        }
                        NovaMagia
                                .put("a", new JSONObject()
                                        .put("f", Especializacoes.getJSONObject(iComp).getString("f"))
                                )
                                .put("b", new JSONObject()
                                        .put("uuid", Especializacoes.getJSONObject(iComp).getString("uuid"))
                                        .put("u", Especializacoes.getJSONObject(iComp).getString("u"))
                                        .put("v", descricao));
                        EspecializacoesNovas.put(NovaMagia);
                        System.out.println("Especializacoes no vetor: " + EspecializacoesNovas);
                        System.out.println("Item adicionado: " + NovaMagia);
                        System.out.println("Tamanho do vetor: " + EspecializacoesNovas.length());
                        posicao = EspecializacoesNovas.length() - 1;
                    } else {
                        System.out.println("Item removido: " + EspecializacoesNovas.getJSONObject(posicao));
                        EspecializacoesNovas.remove(posicao);
                        System.out.println("Especializacoes no vetor: " + EspecializacoesNovas);
                    }
                }
            });
        }
        AdicionarSelecionados.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                EspecializacoesNovas.forEach(Magia -> {
                    ficha.getJSONArray("i").put(Magia);
                });

                MagiasPanelP.MagiaPanelP(personagemCaminho, ficha, PainelMagiaFicha, VetorCaminho, PainelEspecializacoesFicha);
                SwingUtilities.getWindowAncestor(AdicionarSelecionados).dispose();
                SalvarFicha(ficha, personagemCaminho);

            }
        });

    }
}
