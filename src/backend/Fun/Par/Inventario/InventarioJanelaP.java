/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.Fun.Par.Inventario;

import static backend.Fun.Mod.mod;
import static backend.Fun.Proficiencia.Proficiencia;
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
import backend.Fun.VirtualObjects.*;

/**
 *
 * @author Admin
 */
public class InventarioJanelaP {

    public static void EquipamentosJanelaP(String personagemCaminho, JSONObject ficha, JPanel PainelItens, JComboBox Opcoes, JPanel PainelItensFicha, JLabel AdicionarSelecionados, JSONArray itens) {
        String Opcao = (String) Opcoes.getSelectedItem();
        AdicionarEquipamentos(personagemCaminho, ficha, PainelItens, Opcao, PainelItensFicha, AdicionarSelecionados, itens);
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
                AdicionarEquipamentos(personagemCaminho, ficha, PainelItens, NewOpcao, PainelItensFicha, AdicionarSelecionados, itens);

            }
        });
    }

    public static void AdicionarEquipamentos(String personagemCaminho, JSONObject ficha, JPanel PainelItens, String TipoItem, JPanel PainelItensFicha, JLabel AdicionarSelecionados, JSONArray itens) {

        PainelItens.removeAll();
        PainelItens.revalidate();
        PainelItens.repaint();
        Color cor = new Color(255, 255, 255);
        PainelItens.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH; // Expande horizontal e verticalmente
        gbc.weightx = 1.0; // Permite expansão horizontal
        gbc.weighty = 0.0; // Não cresce infinitamente
        gbc.gridwidth = GridBagConstraints.REMAINDER; // Ocupa toda a linha
        gbc.insets = new Insets(0, 0, 5, 0); // Espaço entre os itens
        JSONArray ItensNovos = new JSONArray();
        for (int i = 0; i < itens.length(); i++) {
            if (TipoItem.equals(itens.getJSONObject(i).getString("i"))) {

                JPanel PainelItem = new JPanel();
                JCheckBox check = new JCheckBox();

                PainelItem.setLayout(new BoxLayout(PainelItem, BoxLayout.Y_AXIS));
                JPanel PainelTituloItem = new JPanel();
                PainelTituloItem.setLayout(new BoxLayout(PainelTituloItem, BoxLayout.Y_AXIS));
                JPanel PainelNomeItem = new JPanel(new BorderLayout());
                JLabel NomeItem = new JLabel(itens.getJSONObject(i).getString("u"));
                NomeItem.setForeground(cor);
                ImageIcon Icone = new ImageIcon("src/visual/res/SmallDown.png");
                JLabel UpOrDown = new JLabel(Icone);

                NomeItem.setHorizontalAlignment(SwingConstants.CENTER);

                JPanel PainelDescricaoItem = new JPanel();
                JLabel DescricaoItem = new JLabel();
                int width = SwingUtilities.getWindowAncestor(PainelItens).getSize().width;
                if (itens.getJSONObject(i).has("v")) {
                    DescricaoItem.setText("<html><body style='width:" + (width / 2.5) + "px'>" + itens.getJSONObject(i).getString("v") + "</body></html>");
                } else {
                    DescricaoItem.setText("<html><body style='width:" + (width / 2.5) + "px'> " + "</body></html>");
                }
                DescricaoItem.setLocation(0, 0);
                PainelNomeItem.add(check, BorderLayout.WEST);
                PainelNomeItem.add(NomeItem, BorderLayout.CENTER);
                PainelNomeItem.add(UpOrDown, BorderLayout.EAST);

                PainelDescricaoItem.add(DescricaoItem);
                gbc.gridy = i; // Define a posição na grade
                PainelNomeItem.setOpaque(false);
                PainelDescricaoItem.setOpaque(false);
                PainelTituloItem.add(PainelNomeItem);
                if (itens.getJSONObject(i).getString("i").equals("Arma") || itens.getJSONObject(i).getString("i").equals("WEAPON")) {
                    JPanel PInfArma = new JPanel(new GridLayout(1, 3));
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
                    int Status;
                    switch (itens.getJSONObject(i).getString("q")) {
                        case "STRENGTH" ->
                            Status = ficha.getJSONArray("e").getJSONObject(0).getInt("b");
                        case "DEXTERITY" ->
                            Status = ficha.getJSONArray("e").getJSONObject(1).getInt("b");
                        default -> {
                            if (ficha.getJSONArray("e").getJSONObject(1).getInt("b") > ficha.getJSONArray("e").getJSONObject(0).getInt("b")) {
                                Status = ficha.getJSONArray("e").getJSONObject(1).getInt("b");
                            } else {
                                Status = ficha.getJSONArray("e").getJSONObject(0).getInt("b");
                            }
                        }
                    }
                    JLabel InfArmaAtaque = new JLabel("-");
                    String Modificador;
                    Modificador = mod(Status, 0);
                    if (Modificador.equals("0")) {
                        Modificador = "";
                    }
                    InfArmaAtaque.setText("1d20" + Modificador);
                    JLabel InfArmaDano = new JLabel("-");
                    InfArmaDano.setText(itens.getJSONObject(i).getString("1"));
                    JLabel InfArmaTipo = new JLabel(itens.getJSONObject(i).getString("b"));

                    InfArmaAtaqueT.setAlignmentX(Component.CENTER_ALIGNMENT);
                    InfArmaAtaque.setAlignmentX(Component.CENTER_ALIGNMENT);
                    InfArmaDanoT.setAlignmentX(Component.CENTER_ALIGNMENT);
                    InfArmaDano.setAlignmentX(Component.CENTER_ALIGNMENT);
                    InfArmaTipoT.setAlignmentX(Component.CENTER_ALIGNMENT);
                    InfArmaTipo.setAlignmentX(Component.CENTER_ALIGNMENT);
                    Font fonte = new Font("SansSerif", Font.PLAIN, 10);
                    InfArmaAtaqueT.setForeground(cor);
                    InfArmaAtaque.setForeground(cor);
                    InfArmaDanoT.setForeground(cor);
                    InfArmaDano.setForeground(cor);
                    InfArmaTipoT.setForeground(cor);
                    InfArmaTipo.setForeground(cor);
                    PInfArmaAtaque.add(InfArmaAtaqueT);
                    PInfArmaAtaque.add(Box.createRigidArea(new Dimension(0, 5)));
                    PInfArmaAtaque.add(InfArmaAtaque);
                    PInfArmaDano.add(InfArmaDanoT);
                    PInfArmaDano.add(Box.createRigidArea(new Dimension(0, 5)));
                    PInfArmaDano.add(InfArmaDano);
                    PInfArmaTipo.add(InfArmaTipoT);
                    PInfArmaTipo.add(Box.createRigidArea(new Dimension(0, 5)));
                    PInfArmaTipo.add(InfArmaTipo);
                    PInfArma.add(PInfArmaAtaque);
                    PInfArma.add(PInfArmaDano);
                    PInfArma.add(PInfArmaTipo);
                    PainelTituloItem.add(Box.createRigidArea(new Dimension(0, 5)));
                    PainelTituloItem.add(PInfArma);
                    PainelTituloItem.add(Box.createRigidArea(new Dimension(0, 10)));

                }
                PainelItem.add(PainelTituloItem);
                PainelTituloItem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                PainelTituloItem.setBorder(new MatteBorder(0, 0, 1, 0, new Color(105, 105, 195)));
                PainelTituloItem.setOpaque(false);
                PainelItem.setOpaque(false);
                PainelItens.add(PainelItem, gbc);
                PainelItens.revalidate();
                PainelItens.repaint();

                int iComp = i;

                SwingUtilities.getWindowAncestor(PainelItens).addComponentListener(new ComponentAdapter() {
                    @Override
                    public void componentResized(ComponentEvent e) {
                        int width = SwingUtilities.getWindowAncestor(PainelItens).getSize().width;
                        // Atualiza o texto, ajustando a largura do body no HTML
                        if (itens.getJSONObject(iComp).has("v")) {
                            DescricaoItem.setText("<html><body style='width:" + (width / 2.5) + "px'>" + itens.getJSONObject(iComp).getString("v") + "</body></html>");
                        } else {
                            DescricaoItem.setText("<html><body style='width:" + (width / 2.5) + "px'> " + "</body></html>");
                        }
                    }
                });
                PainelTituloItem.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (PainelDescricaoItem.getParent() != null) {
                            ImageIcon Icone = new ImageIcon("src/visual/res/SmallDown.png");
                            UpOrDown.setIcon(Icone);
                            PainelItem.remove(PainelDescricaoItem);
                        } else {
                            PainelItem.add(PainelDescricaoItem);
                            ImageIcon Icone = new ImageIcon("src/visual/res/SmallUp.png");
                            UpOrDown.setIcon(Icone);
                        }
                        PainelItem.revalidate();
                        PainelItem.repaint();
                    }
                });

                check.addItemListener(new ItemListener() {
                    int posicao = 0;

                    public void itemStateChanged(ItemEvent e) {
                        if (e.getStateChange() == ItemEvent.SELECTED) {

                            ItensNovos.put(NewItemFichaVO.NovoItemFicha(itens, iComp));
                            posicao = ItensNovos.length() - 1;
                        } else {
                            ItensNovos.remove(posicao);
                        }
                    }
                });
            }
            AdicionarSelecionados.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    ItensNovos.forEach(Item -> {
                        ficha.getJSONArray("i").put(Item);
                    });

                    InventarioPanelP.ItensPanelP(personagemCaminho, ficha, PainelItensFicha);
                    SwingUtilities.getWindowAncestor(AdicionarSelecionados).dispose();
                    SalvarFicha(ficha, personagemCaminho);

                }
            });

        }
    }
}
