/*
 * Click nbfs:
 * Click nbfs:
 */
package backend.Fun.Par.Inventario;

import static backend.Fun.Mod.mod;
import static backend.Fun.Par.Inventario.EquipamentosAddP.EquipamentosAddP;
import static backend.Fun.SalvarFicha.SalvarFicha;
import org.json.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.*;
import java.awt.event.*;
import java.text.Normalizer;
import backend.Fun.VirtualObjects.*;
import backend.jsonParser;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import visual.EditarItemASSET;

/**
 *
 * @author Admin
 */
public class InventarioJanelaP {

    public static void EquipamentosJanelaP(String personagemCaminho, JSONObject ficha, JPanel PainelItens, JComboBox Opcoes, JPanel PainelItensFicha, JLabel AdicionarSelecionados, JSONArray itens, JLabel BonusCALabel, JPanel AddEquip, JLabel PesoAtual, JLabel PesoMaximo, JTextField Search) {
        String Opcao = (String) Opcoes.getSelectedItem();
        AdicionarEquipamentos(personagemCaminho, ficha, PainelItens, Opcao, PainelItensFicha, AdicionarSelecionados, itens, Opcoes, BonusCALabel, AddEquip, PesoAtual, PesoMaximo, Search);
    }

    public static void AdicionarEquipamentos(String personagemCaminho, JSONObject ficha, JPanel PainelItens, String TipoItem, JPanel PainelItensFicha, JLabel AdicionarSelecionados, JSONArray itens, JComboBox OpcaoSelect, JLabel BonusCALabel, JPanel AddEquip, JLabel PesoAtual, JLabel PesoMaximo, JTextField Search) {
        Color cor = new Color(255, 255, 255);
        PainelItens.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH; 
        gbc.weightx = 1.0; 
        gbc.weighty = 0.0; 
        gbc.gridwidth = GridBagConstraints.REMAINDER; 
        gbc.insets = new Insets(0, 0, 5, 0); 
        JSONArray ItensNovos = new JSONArray();
        JPanel[] OpcoesVetor = new JPanel[itens.length()];
        jsonParser Sobrescrever = new jsonParser();
        SwingWorker<Void, JPanel[]> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() {
                for (int i = 0; i < itens.length(); i++) {

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
                    PainelDescricaoItem.setLayout(new BoxLayout(PainelDescricaoItem, BoxLayout.Y_AXIS));

                    int width = SwingUtilities.getWindowAncestor(PainelItens).getSize().width;
                    String descricao = "";
                    if (itens.getJSONObject(i).has("v")) {
                        descricao = itens.getJSONObject(i).getString("v");
                    }
                    DescricaoItem.setText("<html><body style='width:" + (width / 2.5) + "px'> " + descricao + "</body></html>");
                    DescricaoItem.setLocation(0, 0);
                    PainelNomeItem.add(check, BorderLayout.WEST);
                    PainelNomeItem.add(NomeItem, BorderLayout.CENTER);
                    PainelNomeItem.add(UpOrDown, BorderLayout.EAST);
                    JPanel PInfItem = new JPanel(new GridLayout(1, 3));
                    PInfItem.setOpaque(false);
                    JPanel PInfItemPeso = new JPanel();
                    PInfItemPeso.setLayout(new BoxLayout(PInfItemPeso, BoxLayout.Y_AXIS));
                    PInfItemPeso.setOpaque(false);
                    JPanel PInfItemUn = new JPanel();
                    PInfItemUn.setLayout(new BoxLayout(PInfItemUn, BoxLayout.Y_AXIS));
                    PInfItemUn.setOpaque(false);
                    JPanel PInfItemPreco = new JPanel();
                    PInfItemPreco.setLayout(new BoxLayout(PInfItemPreco, BoxLayout.Y_AXIS));
                    PInfItemPreco.setOpaque(false);
                    JLabel InfItemPesoT = new JLabel("Peso");
                    JLabel InfItemUnT = new JLabel("Quantidade");
                    JLabel InfItemPrecoT = new JLabel("Preço");
                    JLabel InfItemPeso = new JLabel("-");
                    InfItemPeso.setText("" + itens.getJSONObject(i).getDouble("e") + "Kg");
                    JLabel InfItemUn = new JLabel("-");
                    InfItemUn.setText("" + itens.getJSONObject(i).getInt("g") + " " + itens.getJSONObject(i).getString("h"));

                    JLabel InfItemPreco = new JLabel(itens.getJSONObject(i).getInt("c") + " " + itens.getJSONObject(i).getString("d"));

                    InfItemPesoT.setAlignmentX(Component.CENTER_ALIGNMENT);
                    InfItemPeso.setAlignmentX(Component.CENTER_ALIGNMENT);
                    InfItemUnT.setAlignmentX(Component.CENTER_ALIGNMENT);
                    InfItemUn.setAlignmentX(Component.CENTER_ALIGNMENT);
                    InfItemPrecoT.setAlignmentX(Component.CENTER_ALIGNMENT);
                    InfItemPreco.setAlignmentX(Component.CENTER_ALIGNMENT);

                    PInfItemPeso.add(InfItemPesoT);
                    PInfItemPeso.add(Box.createRigidArea(new Dimension(0, 5)));
                    PInfItemPeso.add(InfItemPeso);
                    PInfItemUn.add(InfItemUnT);
                    PInfItemUn.add(Box.createRigidArea(new Dimension(0, 5)));
                    PInfItemUn.add(InfItemUn);
                    PInfItemPreco.add(InfItemPrecoT);
                    PInfItemPreco.add(Box.createRigidArea(new Dimension(0, 5)));
                    PInfItemPreco.add(InfItemPreco);
                    PInfItem.add(PInfItemPreco);
                    PInfItem.add(PInfItemPeso);
                    PInfItem.add(PInfItemUn);
                    PainelDescricaoItem.add(Box.createRigidArea(new Dimension(0, 10)));
                    PainelDescricaoItem.add(PInfItem);
                    PainelDescricaoItem.add(Box.createRigidArea(new Dimension(0, 0)));
                    InfItemPesoT.setForeground(cor);
                    InfItemPeso.setForeground(cor);
                    InfItemUnT.setForeground(cor);
                    InfItemUn.setForeground(cor);
                    InfItemPrecoT.setForeground(cor);
                    InfItemPreco.setForeground(cor);
                    JPanel PDescricaoTextoItem = new JPanel();
                    PDescricaoTextoItem.add(DescricaoItem);
                    PDescricaoTextoItem.setOpaque(false);
                    PainelDescricaoItem.add(PDescricaoTextoItem);
                    final String idItem = itens.getJSONObject(i).getString("uuid");
                    gbc.gridy = i; 
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
                        int Status = 0;
                        switch (itens.getJSONObject(i).getString("q")) {
                            case "STRENGTH" ->
                                Status = ficha.getJSONArray("e").getJSONObject(0).getInt("b");
                            case "DEXTERITY" ->
                                Status = ficha.getJSONArray("e").getJSONObject(1).getInt("b");
                            case "CONSTITUTION" ->
                                Status = ficha.getJSONArray("e").getJSONObject(2).getInt("b");
                            case "INTELLIGENCE" ->
                                Status = ficha.getJSONArray("e").getJSONObject(3).getInt("b");
                            case "WISDOM" ->
                                Status = ficha.getJSONArray("e").getJSONObject(4).getInt("b");
                            case "CHARISMA" ->
                                Status = ficha.getJSONArray("e").getJSONObject(5).getInt("b");
                            case "DEXORSTR" -> {
                                if (ficha.getJSONArray("e").getJSONObject(1).getInt("b") > ficha.getJSONArray("e").getJSONObject(0).getInt("b")) {
                                    Status = ficha.getJSONArray("e").getJSONObject(1).getInt("b");
                                } else {
                                    Status = ficha.getJSONArray("e").getJSONObject(0).getInt("b");
                                }
                            }
                        }
                        JLabel InfArmaAtaque = new JLabel("-");
                        String Modificador;
                        Modificador = mod(Status, itens.getJSONObject(i).getInt("2"));
                        if (Modificador.equals("0")) {
                            Modificador = "";
                        }
                        InfArmaAtaque.setText("1d20" + Modificador);
                        JLabel InfArmaDano = new JLabel("-");
                        String DanoMod = "+" + itens.getJSONObject(i).getInt("3");
                        if (DanoMod.equals("+0")) {
                            DanoMod = "";
                        }
                        InfArmaDano.setText(itens.getJSONObject(i).getString("1") + DanoMod);
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
                    if (itens.getJSONObject(i).getString("i").equals("Armadura") || itens.getJSONObject(i).getString("i").equals("ARMOR")) {
                        JPanel PInfArmadura = new JPanel(new GridLayout(1, 3));
                        PInfArmadura.setOpaque(false);
                        JPanel PInfArmaduraForca = new JPanel();
                        PInfArmaduraForca.setLayout(new BoxLayout(PInfArmaduraForca, BoxLayout.Y_AXIS));
                        PInfArmaduraForca.setOpaque(false);
                        JPanel PInfArmaduraCA = new JPanel();
                        PInfArmaduraCA.setLayout(new BoxLayout(PInfArmaduraCA, BoxLayout.Y_AXIS));
                        PInfArmaduraCA.setOpaque(false);
                        JPanel PInfArmaduraDesvantagem = new JPanel();
                        PInfArmaduraDesvantagem.setLayout(new BoxLayout(PInfArmaduraDesvantagem, BoxLayout.Y_AXIS));
                        PInfArmaduraDesvantagem.setOpaque(false);
                        JLabel InfArmaduraCAT = new JLabel("CA");
                        JLabel InfArmaduraForcaT = new JLabel("Força mínima");
                        JLabel InfArmaduraDesvantagemT = new JLabel("Furtividade");
                        JLabel InfArmaduraDesvantagem = new JLabel("Normal");

                        if (itens.getJSONObject(i).has("m")) {
                            InfArmaduraDesvantagem.setText("Desvantagem");
                        }
                        int Status = 10;
                        if (itens.getJSONObject(i).has("k")) {

                            switch (itens.getJSONObject(i).getString("k")) {
                                case "STRENGTH" ->
                                    Status = ficha.getJSONArray("e").getJSONObject(0).getInt("b");
                                case "DEXTERITY" ->
                                    Status = ficha.getJSONArray("e").getJSONObject(1).getInt("b");
                                case "CONSTITUTION" ->
                                    Status = ficha.getJSONArray("e").getJSONObject(2).getInt("b");
                                case "INTELLIGENCE" ->
                                    Status = ficha.getJSONArray("e").getJSONObject(3).getInt("b");
                                case "WISDOM" ->
                                    Status = ficha.getJSONArray("e").getJSONObject(4).getInt("b");
                                case "CHARISMA" ->
                                    Status = ficha.getJSONArray("e").getJSONObject(5).getInt("b");
                                case "DEXORSTR" -> {
                                    if (ficha.getJSONArray("e").getJSONObject(1).getInt("b") > ficha.getJSONArray("e").getJSONObject(0).getInt("b")) {
                                        Status = ficha.getJSONArray("e").getJSONObject(1).getInt("b");
                                    } else {
                                        Status = ficha.getJSONArray("e").getJSONObject(0).getInt("b");
                                    }
                                }
                            }
                        }
                        String CA = mod(Status, itens.getJSONObject(i).getInt("j"));
                        JLabel InfArmaduraForca = new JLabel("-");
                        int ForcaMin = 0;
                        if (itens.getJSONObject(i).has("n")) {
                            ForcaMin = itens.getJSONObject(i).getInt("n");
                        }
                        InfArmaduraForca.setText("" + ForcaMin);
                        JLabel InfArmaduraCA = new JLabel(CA);
                        InfArmaduraCAT.setAlignmentX(Component.CENTER_ALIGNMENT);
                        InfArmaduraForca.setAlignmentX(Component.CENTER_ALIGNMENT);
                        InfArmaduraForcaT.setAlignmentX(Component.CENTER_ALIGNMENT);
                        InfArmaduraCA.setAlignmentX(Component.CENTER_ALIGNMENT);
                        InfArmaduraDesvantagemT.setAlignmentX(Component.CENTER_ALIGNMENT);
                        InfArmaduraDesvantagem.setAlignmentX(Component.CENTER_ALIGNMENT);

                        PInfArmaduraForca.add(InfArmaduraForcaT);
                        PInfArmaduraForca.add(Box.createRigidArea(new Dimension(0, 5)));
                        PInfArmaduraForca.add(InfArmaduraForca);
                        PInfArmaduraCA.add(InfArmaduraCAT);
                        PInfArmaduraCA.add(Box.createRigidArea(new Dimension(0, 5)));
                        PInfArmaduraCA.add(InfArmaduraCA);
                        PInfArmaduraDesvantagem.add(InfArmaduraDesvantagemT);
                        PInfArmaduraDesvantagem.add(Box.createRigidArea(new Dimension(0, 5)));
                        PInfArmaduraDesvantagem.add(InfArmaduraDesvantagem);
                        PInfArmadura.add(PInfArmaduraForca);
                        PInfArmadura.add(PInfArmaduraCA);
                        PInfArmadura.add(PInfArmaduraDesvantagem);
                        PainelTituloItem.add(Box.createRigidArea(new Dimension(0, 5)));
                        PainelTituloItem.add(PInfArmadura);
                        PainelTituloItem.add(Box.createRigidArea(new Dimension(0, 10)));
                        InfArmaduraCAT.setForeground(cor);
                        InfArmaduraForca.setForeground(cor);
                        InfArmaduraForcaT.setForeground(cor);
                        InfArmaduraCA.setForeground(cor);
                        InfArmaduraDesvantagemT.setForeground(cor);
                        InfArmaduraDesvantagem.setForeground(cor);

                    }
                    if (itens.getJSONObject(i).getString("i").equals("Escudo") || itens.getJSONObject(i).getString("i").equals("SHIELD")) {
                        JPanel PInfEscudo = new JPanel(new GridLayout(1, 1));
                        PInfEscudo.setOpaque(false);
                        JPanel PInfEscudoCA = new JPanel();
                        PInfEscudoCA.setLayout(new BoxLayout(PInfEscudoCA, BoxLayout.Y_AXIS));
                        PInfEscudoCA.setOpaque(false);
                        JLabel InfEscudoCAT = new JLabel("CA");
                        String CABonus = "+" + itens.getJSONObject(i).getInt("o");
                        JLabel InfEscudoCA = new JLabel(CABonus);
                        InfEscudoCAT.setAlignmentX(Component.CENTER_ALIGNMENT);
                        InfEscudoCA.setAlignmentX(Component.CENTER_ALIGNMENT);

                        PInfEscudoCA.add(InfEscudoCAT);
                        PInfEscudoCA.add(Box.createRigidArea(new Dimension(0, 5)));
                        PInfEscudoCA.add(InfEscudoCA);
                        PInfEscudo.add(PInfEscudoCA);
                        PainelTituloItem.add(Box.createRigidArea(new Dimension(0, 10)));
                        PainelTituloItem.add(PInfEscudo);
                        PainelTituloItem.add(Box.createRigidArea(new Dimension(0, 10)));
                        InfEscudoCAT.setForeground(cor);
                        InfEscudoCA.setForeground(cor);
                    }
                    PainelDescricaoItem.add(Box.createRigidArea(new Dimension(0, 10)));
                    PainelItem.add(PainelTituloItem);
                    PainelTituloItem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    PainelItem.setBorder(new MatteBorder(0, 0, 1, 0, new Color(105, 105, 195)));
                    PainelTituloItem.setOpaque(false);
                    PainelItem.setOpaque(false);
                    PainelItem.setName(itens.getJSONObject(i).getString("i"));
                    if (itens.getJSONObject(i).getBoolean("t")) {
                        JPanel RemoverItemPainel = new JPanel();
                        JLabel EditarItem = new JLabel("Editar item");
                        EditarItem.setForeground(new Color(255, 255, 255));
                        EditarItem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        JLabel RemoverItem = new JLabel("Remover item");
                        RemoverItem.setForeground(new Color(255, 105, 105));
                        RemoverItem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        EditarItem.setPreferredSize(new Dimension(58, 15));
                        EditarItem.setBorder(new MatteBorder(0, 0, 1, 0, new Color(255, 255, 255)));
                        RemoverItemPainel.add(EditarItem);
                        RemoverItemPainel.add(RemoverItem);
                        RemoverItemPainel.setOpaque(false);
                        PainelDescricaoItem.add(RemoverItemPainel);
                        final int iCompEdit = i;
                        EditarItem.addMouseListener(new MouseAdapter() {
                            @Override

                            public void mouseClicked(MouseEvent e) {
                                EditarItemASSET EditItem = new EditarItemASSET(itens, ficha, iCompEdit, personagemCaminho, PainelItensFicha, BonusCALabel, PainelItens, AddEquip, "Vetor", PesoAtual, PesoMaximo);
                                EditItem.setVisible(true);

                            }
                        });
                        final int iCompRemove = i;
                        RemoverItem.addMouseListener(new MouseAdapter() {

                            @Override

                            public void mouseClicked(MouseEvent e) {
                                for (int j = 0; j < itens.length(); j++) {
                                    if (itens.getJSONObject(j).getString("uuid").equals(idItem)) {
                                        itens.remove(j);
                                        j = itens.length();
                                    }
                                }
                                SwingUtilities.getWindowAncestor(PainelItens).dispose();
                                EquipamentosAddP(personagemCaminho, ficha, AddEquip, PainelItens, itens, BonusCALabel, PesoAtual, PesoMaximo);

                                Sobrescrever.sobrescreverArray("ASSETS/Equipamento.json", itens.toString(4));
                                PainelItens.revalidate();
                                PainelItens.repaint();

                            }
                        });
                    }
                    int iComp = i;
                    String descricaoComp = descricao;
                    SwingUtilities.getWindowAncestor(PainelItens).addComponentListener(new ComponentAdapter() {
                        @Override
                        public void componentResized(ComponentEvent e) {
                            if (OpcoesVetor[iComp] != null) {
                                int width = SwingUtilities.getWindowAncestor(PainelItens).getSize().width;
                                DescricaoItem.setText("<html><body style='width:" + (width / 2.5) + "px'>" + descricaoComp + "</body></html>");
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
                                for (int j = 0; j < itens.length(); j++) {
                                    if (itens.getJSONObject(j).getString("uuid").equals(idItem)) {
                                        ItensNovos.put(NewItemFichaVO.NovoItemFicha(itens, j));
                                        posicao = ItensNovos.length() - 1;
                                        j = itens.length();
                                    }
                                }
                            } else {
                                ItensNovos.remove(posicao);
                            }
                        }
                    });

                    OpcoesVetor[i] = PainelItem;

                }
                return null;
            }

            @Override
            protected void done() {
                try {
                    get();
                    ExibirOpcoes(TipoItem, PainelItens, OpcoesVetor, gbc, Search.getText(), itens);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        };
        worker.execute();
        AdicionarSelecionados.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                for (Object ItemNewTemp : ItensNovos) {
                    ficha.getJSONArray("i").put(ItemNewTemp);
                }
                InventarioPanelP.ItensPanelP(personagemCaminho, ficha, PainelItensFicha, BonusCALabel, AddEquip, PesoAtual, PesoMaximo);
                SwingUtilities.getWindowAncestor(AdicionarSelecionados).setVisible(false);
                desmarcarTodasCheckBoxes(PainelItens);
                SalvarFicha(ficha, personagemCaminho);

            }
        });
        OpcaoSelect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String NewOpcao = (String) OpcaoSelect.getSelectedItem();
                ExibirOpcoes(NewOpcao, PainelItens, OpcoesVetor, gbc, Search.getText(), itens);
                Search.setText("");
            }
        });
        Search.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String NewOpcao = (String) OpcaoSelect.getSelectedItem();
                ExibirOpcoes(NewOpcao, PainelItens, OpcoesVetor, gbc, Search.getText(), itens);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String NewOpcao = (String) OpcaoSelect.getSelectedItem();
                ExibirOpcoes(NewOpcao, PainelItens, OpcoesVetor, gbc, Search.getText(), itens);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                String NewOpcao = (String) OpcaoSelect.getSelectedItem();
                ExibirOpcoes(NewOpcao, PainelItens, OpcoesVetor, gbc, Search.getText(), itens);
            }
        });
    }

    public static void ExibirOpcoes(String TipoOpcoes, JPanel PainelOpcoes, JPanel[] OpcoesLista, GridBagConstraints gbc, String BuscaString, JSONArray itens) {
        PainelOpcoes.removeAll();
        for (Component Opcao : OpcoesLista) {
             Normalizer.normalize("", Normalizer.Form.NFD);
            String Titulo =  Normalizer.normalize(((JLabel) ((JPanel) ((JPanel) ((JPanel) Opcao).getComponent(0)).getComponent(0)).getComponent(1)).getText().toLowerCase(), Normalizer.Form.NFD);
            if (Opcao != null && TipoOpcoes.equals(Opcao.getName()) && (BuscaString == null || Titulo.contains(Normalizer.normalize(BuscaString.toLowerCase(), Normalizer.Form.NFD)))) {
                PainelOpcoes.add(Opcao, gbc);
                gbc.gridy++;
            }
        }
        PainelOpcoes.revalidate();
        PainelOpcoes.repaint();
    }

    private static void desmarcarTodasCheckBoxes(JPanel painel) {
        
        for (Component componente : painel.getComponents()) {
            
            if (componente instanceof JPanel) {
                desmarcarTodasCheckBoxes((JPanel) componente); 
            } 
            else if (componente instanceof JCheckBox) {
                JCheckBox checkBox = (JCheckBox) componente;
                checkBox.setSelected(false); 
            }
        }
    }
}
