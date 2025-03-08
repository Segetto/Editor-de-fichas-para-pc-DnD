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
import backend.jsonParser;
import java.awt.event.*;
import visual.EditarItem;
import org.json.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 *
 * @author Admin
 */
public class InventarioPanelP {

    public static void ItensPanelP(String personagemCaminho, JSONObject ficha, JPanel PainelItens, JLabel CALabel, JPanel AddEquip) {
        Color cor = new Color(255, 255, 255);
        PainelItens.removeAll();
        PainelItens.revalidate();
        PainelItens.repaint();
        PainelItens.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH; // Expande horizontal e verticalmente
        gbc.weightx = 1.0; // Permite expansão horizontal
        gbc.weighty = 0.0; // Não cresce infinitamente
        gbc.gridwidth = GridBagConstraints.REMAINDER; // Ocupa toda a linha
        gbc.insets = new Insets(0, 0, 0, 0); // Espaço entre os itens
        ButtonGroup grupoArmaduras = new ButtonGroup();

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
            JPanel RemoverItemPainel = new JPanel(new FlowLayout());
            RemoverItemPainel.setPreferredSize(new Dimension(500, 20));
            RemoverItem.setPreferredSize(new Dimension(84, 20));

            RemoverItem.setForeground(new Color(255, 105, 105));
            RemoverItem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            JLabel NomeItem = new JLabel(ficha.getJSONArray("i").getJSONObject(i).getJSONObject("b").getString("u"));
            NomeItem.setForeground(cor);
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
            InfItemPeso.setText("" + ficha.getJSONArray("i").getJSONObject(i).getJSONObject("b").getDouble("e") + "Kg");
            JLabel InfItemUn = new JLabel("-");
            InfItemUn.setText("" + ficha.getJSONArray("i").getJSONObject(i).getJSONObject("b").getInt("g") + " " + ficha.getJSONArray("i").getJSONObject(i).getJSONObject("b").getString("h"));

            JLabel InfItemPreco = new JLabel(ficha.getJSONArray("i").getJSONObject(i).getJSONObject("b").getInt("c") + " " + ficha.getJSONArray("i").getJSONObject(i).getJSONObject("b").getString("d"));

            InfItemPesoT.setAlignmentX(Component.CENTER_ALIGNMENT);
            InfItemPeso.setAlignmentX(Component.CENTER_ALIGNMENT);
            InfItemUnT.setAlignmentX(Component.CENTER_ALIGNMENT);
            InfItemUn.setAlignmentX(Component.CENTER_ALIGNMENT);
            InfItemPrecoT.setAlignmentX(Component.CENTER_ALIGNMENT);
            InfItemPreco.setAlignmentX(Component.CENTER_ALIGNMENT);
            if (ficha.getJSONArray("i").getJSONObject(i).getJSONObject("b").getBoolean("t")) {
                JLabel EditarItem = new JLabel("Editar item");
                EditarItem.setForeground(new Color(255, 255, 255));
                EditarItem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                EditarItem.setPreferredSize(new Dimension(58, 15));
                EditarItem.setBorder(new MatteBorder(0, 0, 3, 0, new Color(255, 255, 255)));
                RemoverItemPainel.add(EditarItem);
                final int iCompEdit = i;
                EditarItem.addMouseListener(new MouseAdapter() {
                    @Override

                    public void mouseClicked(MouseEvent e) {
                        EditarItem EditItem = new EditarItem(null, ficha, iCompEdit, personagemCaminho, PainelItens, CALabel, null, AddEquip, "Ficha");
                        EditItem.setVisible(true);

                    }
                });
            }
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
            RemoverItemPainel.add(RemoverItem);
            RemoverItemPainel.setOpaque(false);
            PainelDescricaoItem.add(PInfAdicionais);
            PainelDescricaoItem.add(RemoverItemPainel);
            PainelDescricaoItem.add(Box.createRigidArea(new Dimension(0, 10)));
            final String idItemFicha = ficha.getJSONArray("i").getJSONObject(i).getJSONObject("a").getString("uuid");
            gbc.gridy = i;
            PainelItem.setOpaque(false);
            PainelNomeItem.setOpaque(false);
            PainelTituloItem.setOpaque(false);
            PainelDescricaoItem.setOpaque(false);
            PainelDescricaoItem.setPreferredSize(new Dimension(300, PainelDescricaoItem.getPreferredSize().height));
            PainelTituloItem.add(PainelNomeItem);
            if (ficha.getJSONArray("i").getJSONObject(i).getJSONObject("b").getString("i").equals("Arma") || ficha.getJSONArray("i").getJSONObject(i).getJSONObject("b").getString("i").equals("WEAPON")) {
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
                int Status = 10;
                switch (ficha.getJSONArray("i").getJSONObject(i).getJSONObject("b").getString("q")) {
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
                int BonusAtaque = 0;
                if (ficha.getJSONArray("i").getJSONObject(i).getJSONObject("b").has("2")) {
                    BonusAtaque = ficha.getJSONArray("i").getJSONObject(i).getJSONObject("b").getInt("2");
                }
                if (ficha.getJSONArray("i").getJSONObject(i).getJSONObject("a").getBoolean("d")) {
                    Modificador = mod(Status, Proficiencia(ficha) + BonusAtaque);
                } else {
                    Modificador = mod(Status, BonusAtaque);
                }
                if (Modificador.equals("0")) {
                    Modificador = "";
                }
                InfArmaAtaque.setText("1d20" + Modificador);
                JCheckBox proficiente = new JCheckBox();
                proficiente.setSelected(ficha.getJSONArray("i").getJSONObject(i).getJSONObject("a").getBoolean("d"));
                int iCompCheck = i;
                String ModificadorCheck = Modificador;
                int StatusCheck = Status;
                int BonusAtaqueCheck = BonusAtaque;
                proficiente.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        String ModificadorCheckNew;
                        ficha.getJSONArray("i").getJSONObject(iCompCheck).getJSONObject("a").put("d", proficiente.isSelected());
                        if (ficha.getJSONArray("i").getJSONObject(iCompCheck).getJSONObject("a").getBoolean("d")) {
                            ModificadorCheckNew = mod(StatusCheck, Proficiencia(ficha) + BonusAtaqueCheck);
                        } else {
                            ModificadorCheckNew = mod(StatusCheck, BonusAtaqueCheck);
                        }
                        if (ModificadorCheck.equals("0")) {
                            ModificadorCheckNew = "";
                        }
                        InfArmaAtaque.setText("1d20" + ModificadorCheckNew);
                        SalvarFicha(ficha, personagemCaminho);
                    }
                });
                JLabel InfArmaDano = new JLabel("-");
                int BonusDano = 0;
                if (ficha.getJSONArray("i").getJSONObject(i).getJSONObject("b").has("3")) {
                    BonusDano = ficha.getJSONArray("i").getJSONObject(i).getJSONObject("b").getInt("3");
                }
                String ModDano = mod(Status, BonusDano);
                if (ModDano.equals("0")) {
                    ModDano = "";
                }
                if (ficha.getJSONArray("i").getJSONObject(i).getJSONObject("b").has("1")) {
                    InfArmaDano.setText(ficha.getJSONArray("i").getJSONObject(i).getJSONObject("b").getString("1") + ModDano);
                } else {
                    JSONArray inventario = new JSONArray(jsonParser.LerArray("ASSETS/Equipamento.json"));
                    for (int j = 0; j < inventario.length(); j++) {
                        if (ficha.getJSONArray("i").getJSONObject(i).getJSONObject("b").getString("uuid").equals(inventario.getJSONObject(j).getString("uuid"))) {
                            ficha.getJSONArray("i").getJSONObject(i).getJSONObject("b").put("1", inventario.getJSONObject(j).getString("1"));
                            SalvarFicha(ficha, personagemCaminho);
                            InfArmaDano.setText(ficha.getJSONArray("i").getJSONObject(i).getJSONObject("b").getString("1") + ModDano);
                            j = inventario.length();
                        }
                    }
                }
                JLabel InfArmaTipo = new JLabel(ficha.getJSONArray("i").getJSONObject(i).getJSONObject("b").getString("b"));

                InfArmaAtaqueT.setAlignmentX(Component.CENTER_ALIGNMENT);
                InfArmaAtaque.setAlignmentX(Component.CENTER_ALIGNMENT);
                proficiente.setAlignmentX(Component.CENTER_ALIGNMENT);
                InfArmaDanoT.setAlignmentX(Component.CENTER_ALIGNMENT);
                InfArmaDano.setAlignmentX(Component.CENTER_ALIGNMENT);
                InfArmaTipoT.setAlignmentX(Component.CENTER_ALIGNMENT);
                InfArmaTipo.setAlignmentX(Component.CENTER_ALIGNMENT);

                PInfArmaAtaque.add(InfArmaAtaqueT);
                PInfArmaAtaque.add(Box.createRigidArea(new Dimension(0, 5)));
                PInfArmaAtaque.add(InfArmaAtaque);
                PInfArmaAtaque.add(proficiente);
                PInfArmaDano.add(InfArmaDanoT);
                PInfArmaDano.add(Box.createRigidArea(new Dimension(0, 5)));
                PInfArmaDano.add(InfArmaDano);
                PInfArmaTipo.add(InfArmaTipoT);
                PInfArmaTipo.add(Box.createRigidArea(new Dimension(0, 5)));
                PInfArmaTipo.add(InfArmaTipo);
                PInfArma.add(PInfArmaAtaque);
                PInfArma.add(PInfArmaDano);
                PInfArma.add(PInfArmaTipo);
                PainelTituloItem.add(Box.createRigidArea(new Dimension(0, 0)));
                PainelTituloItem.add(PInfArma);
                PainelTituloItem.add(Box.createRigidArea(new Dimension(0, 10)));
                InfArmaAtaqueT.setForeground(cor);
                InfArmaAtaque.setForeground(cor);
                InfArmaDanoT.setForeground(cor);
                InfArmaDano.setForeground(cor);
                InfArmaTipoT.setForeground(cor);
                InfArmaTipo.setForeground(cor);
            }
            if (ficha.getJSONArray("i").getJSONObject(i).getJSONObject("b").getString("i").equals("Armadura") || ficha.getJSONArray("i").getJSONObject(i).getJSONObject("b").getString("i").equals("ARMOR")) {
                JPanel PInfArmadura = new JPanel(new GridLayout(1, 4));
                PInfArmadura.setOpaque(false);
                JPanel PInfArmaduraPreparada = new JPanel();
                PInfArmaduraPreparada.setLayout(new BoxLayout(PInfArmaduraPreparada, BoxLayout.Y_AXIS));
                PInfArmaduraPreparada.setOpaque(false);
                JPanel PInfArmaduraForca = new JPanel();
                PInfArmaduraForca.setLayout(new BoxLayout(PInfArmaduraForca, BoxLayout.Y_AXIS));
                PInfArmaduraForca.setOpaque(false);
                JPanel PInfArmaduraCA = new JPanel();
                PInfArmaduraCA.setLayout(new BoxLayout(PInfArmaduraCA, BoxLayout.Y_AXIS));
                PInfArmaduraCA.setOpaque(false);
                JPanel PInfArmaduraDesvantagem = new JPanel();
                PInfArmaduraDesvantagem.setLayout(new BoxLayout(PInfArmaduraDesvantagem, BoxLayout.Y_AXIS));
                PInfArmaduraDesvantagem.setOpaque(false);
                JLabel InfArmaduraPreparadaT = new JLabel("Preparado");
                JLabel InfArmaduraCAT = new JLabel("CA");
                JLabel InfArmaduraForcaT = new JLabel("Força mínima");
                JLabel InfArmaduraDesvantagemT = new JLabel("Furtividade");
                JLabel InfArmaduraDesvantagem = new JLabel("Normal");

                if (ficha.getJSONArray("i").getJSONObject(i).getJSONObject("b").getBoolean("m")) {
                    InfArmaduraDesvantagem.setText("Desvantagem");
                }
                int Status = 10;
                switch (ficha.getJSONArray("i").getJSONObject(i).getJSONObject("b").getString("k")) {
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
                JRadioButton InfArmaduraPreparada = new JRadioButton();
                grupoArmaduras.add(InfArmaduraPreparada);
                String CA = mod(Status, ficha.getJSONArray("i").getJSONObject(i).getJSONObject("b").getInt("j"));
                if (ficha.getJSONArray("i").getJSONObject(i).getJSONObject("b").getInt("l") != 0 && Math.floor((Status / 2) - 5) > ficha.getJSONArray("i").getJSONObject(i).getJSONObject("b").getInt("l")) {
                    CA = mod(10, ficha.getJSONArray("i").getJSONObject(i).getJSONObject("b").getInt("j") + ficha.getJSONArray("i").getJSONObject(i).getJSONObject("b").getInt("l"));

                }
                InfArmaduraPreparada.setSelected(ficha.getJSONArray("i").getJSONObject(i).getJSONObject("a").getBoolean("e"));
                JLabel InfArmaduraForca = new JLabel("-");
                InfArmaduraForca.setText("" + ficha.getJSONArray("i").getJSONObject(i).getJSONObject("b").getInt("n"));
                JLabel InfArmaduraCA = new JLabel(CA);
                if (InfArmaduraPreparada.isSelected()) {
                    CALabel.setText(CA);
                }
                InfArmaduraPreparadaT.setAlignmentX(Component.CENTER_ALIGNMENT);
                InfArmaduraPreparada.setAlignmentX(Component.CENTER_ALIGNMENT);
                InfArmaduraCAT.setAlignmentX(Component.CENTER_ALIGNMENT);
                InfArmaduraForca.setAlignmentX(Component.CENTER_ALIGNMENT);
                InfArmaduraForcaT.setAlignmentX(Component.CENTER_ALIGNMENT);
                InfArmaduraCA.setAlignmentX(Component.CENTER_ALIGNMENT);
                InfArmaduraDesvantagemT.setAlignmentX(Component.CENTER_ALIGNMENT);
                InfArmaduraDesvantagem.setAlignmentX(Component.CENTER_ALIGNMENT);

                PInfArmaduraPreparada.add(InfArmaduraPreparadaT);
                PInfArmaduraPreparada.add(Box.createRigidArea(new Dimension(0, 5)));
                PInfArmaduraPreparada.add(InfArmaduraPreparada);
                PInfArmaduraForca.add(InfArmaduraForcaT);
                PInfArmaduraForca.add(Box.createRigidArea(new Dimension(0, 5)));
                PInfArmaduraForca.add(InfArmaduraForca);
                PInfArmaduraCA.add(InfArmaduraCAT);
                PInfArmaduraCA.add(Box.createRigidArea(new Dimension(0, 5)));
                PInfArmaduraCA.add(InfArmaduraCA);
                PInfArmaduraDesvantagem.add(InfArmaduraDesvantagemT);
                PInfArmaduraDesvantagem.add(Box.createRigidArea(new Dimension(0, 5)));
                PInfArmaduraDesvantagem.add(InfArmaduraDesvantagem);
                PInfArmadura.add(PInfArmaduraPreparada);
                PInfArmadura.add(PInfArmaduraForca);
                PInfArmadura.add(PInfArmaduraCA);
                PInfArmadura.add(PInfArmaduraDesvantagem);
                PainelTituloItem.add(Box.createRigidArea(new Dimension(0, 0)));
                PainelTituloItem.add(PInfArmadura);
                PainelTituloItem.add(Box.createRigidArea(new Dimension(0, 10)));
                InfArmaduraPreparadaT.setForeground(cor);
                InfArmaduraPreparada.setForeground(cor);
                InfArmaduraCAT.setForeground(cor);
                InfArmaduraForca.setForeground(cor);
                InfArmaduraForcaT.setForeground(cor);
                InfArmaduraCA.setForeground(cor);
                InfArmaduraDesvantagemT.setForeground(cor);
                InfArmaduraDesvantagem.setForeground(cor);

                String CAComp = CA;
                InfArmaduraPreparada.addItemListener(new ItemListener() {
                    @Override
                    public void itemStateChanged(ItemEvent e) {
                        for (int j = 0; j < ficha.getJSONArray("i").length(); j++) {
                            if (ficha.getJSONArray("i").getJSONObject(j).getJSONObject("a").getString("uuid").equals(idItemFicha)) {
                                ficha.getJSONArray("i").getJSONObject(j).getJSONObject("a").put("e", InfArmaduraPreparada.isSelected());
                            }
                        }
                        if (InfArmaduraPreparada.isSelected()) {
                            CALabel.setText(CAComp);
                        }
                        SalvarFicha(ficha, personagemCaminho);
                    }
                });
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
            RemoverItem.addMouseListener(new MouseAdapter() {

                @Override

                public void mouseClicked(MouseEvent e) {
                    for (int j = 0; j < ficha.getJSONArray("i").length(); j++) {
                        if (ficha.getJSONArray("i").getJSONObject(j).getJSONObject("a").getString("uuid").equals(idItemFicha)) {
                            PainelItens.remove(PainelItem);
                            ficha.getJSONArray("i").remove(j);
                        }
                    }
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
