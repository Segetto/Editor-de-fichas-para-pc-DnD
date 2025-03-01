/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.Fun.Par.Especializacao;

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
public class EspecializacaoJanelaP {

    public static void EspecializacaoJanelaP(String personagemCaminho, JSONObject ficha, JPanel PainelEspecializacao, JComboBox Opcoes, JPanel PainelEspecializacaoFicha, JLabel AdicionarSelecionados, String VetorCaminho, String TituloCaminho, String DescricaoCaminho, JPanel PainelEspecializacoesFicha, JSONArray Especializacoes, JSONArray OpcoesComboBox) {
        for (int i = 0; i < OpcoesComboBox.length(); i++) {
            Opcoes.addItem(OpcoesComboBox.getJSONObject(i).getString("b")); // Adiciona cada item individualmente
        }
        String Opcao = (String) Opcoes.getSelectedItem();
        AdicionarEquipamentos(personagemCaminho, ficha, PainelEspecializacao, Opcoes, PainelEspecializacaoFicha, AdicionarSelecionados, VetorCaminho, TituloCaminho, DescricaoCaminho, PainelEspecializacoesFicha, Especializacoes, OpcoesComboBox);
        java.util.List<JSONObject> lista = new java.util.ArrayList<>();
        for (int i = 0; i < ficha.getJSONArray(VetorCaminho).length(); i++) {
            lista.add(ficha.getJSONArray(VetorCaminho).getJSONObject(i));
        }

        // Ordenando a lista com base no campo "b.u"
        Collections.sort(lista, new Comparator<JSONObject>() {
            @Override
            public int compare(JSONObject a, JSONObject b) {
                Collator collator = Collator.getInstance(new Locale("pt", "BR"));
                collator.setStrength(Collator.PRIMARY); // Ignora diferenças de acento
                String nomeA = a.getJSONObject("b").getString(TituloCaminho);
                String nomeB = b.getJSONObject("b").getString(TituloCaminho);
                return collator.compare(nomeA, nomeB);
            }
        });

        // Convertendo de volta para JSONArray
        JSONArray jsonArrayOrdenado = new JSONArray(lista);
        ficha.put(VetorCaminho, jsonArrayOrdenado);
        SalvarFicha(ficha, personagemCaminho);

        Opcoes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdicionarEquipamentos(personagemCaminho, ficha, PainelEspecializacao, Opcoes, PainelEspecializacaoFicha, AdicionarSelecionados, VetorCaminho, TituloCaminho, DescricaoCaminho, PainelEspecializacoesFicha, Especializacoes, OpcoesComboBox);
            }
        });
    }

    public static void AdicionarEquipamentos(String personagemCaminho, JSONObject ficha, JPanel PainelEspecializacao, JComboBox ComboBoxOpcao, JPanel PainelEspecializacaoFicha, JLabel AdicionarSelecionados, String VetorCaminho, String TituloCaminho, String DescricaoCaminho, JPanel PainelEspecializacoesFicha, JSONArray Especializacoes, JSONArray ComboBoxArray) {

        PainelEspecializacao.removeAll();
        PainelEspecializacao.revalidate();
        PainelEspecializacao.repaint();
        PainelEspecializacao.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH; // Expande horizontal e verticalmente
        gbc.weightx = 1.0; // Permite expansão horizontal
        gbc.weighty = 0.0; // Não cresce infinitamente
        gbc.gridwidth = GridBagConstraints.REMAINDER; // Ocupa toda a linha
        gbc.insets = new Insets(0, 0, 5, 0); // Espaço entre os Especializacoes
        JSONArray EspecializacoesNovas = new JSONArray();
        for (int i = 0; i < Especializacoes.length(); i++) {
            if (ComboBoxArray.getJSONObject(ComboBoxOpcao.getSelectedIndex()).getString("uuid").equals(Especializacoes.getJSONObject(i).getString("b"))) {

                JPanel PainelNewEspecializacao = new JPanel();
                JCheckBox check = new JCheckBox();

                PainelNewEspecializacao.setLayout(new BoxLayout(PainelNewEspecializacao, BoxLayout.Y_AXIS));
                JPanel PainelNomeEspecializacao = new JPanel(new BorderLayout());
                JLabel NomeEspecializacao = new JLabel(Especializacoes.getJSONObject(i).getString(TituloCaminho));
                ImageIcon Icone = new ImageIcon("src/visual/res/SmallDown.png");
                JLabel UpOrDown = new JLabel(Icone);

                NomeEspecializacao.setHorizontalAlignment(SwingConstants.CENTER);

                JPanel PainelDescricaoEspecializacao = new JPanel();
                JLabel DescricaoEspecializacao = new JLabel();
                int width = SwingUtilities.getWindowAncestor(PainelEspecializacao).getSize().width;
                if (Especializacoes.getJSONObject(i).has(DescricaoCaminho)) {
                    DescricaoEspecializacao.setText("<html><body style='width:" + (width / 2.5) + "px'>" + Especializacoes.getJSONObject(i).getString(DescricaoCaminho) + "</body></html>");
                } else {
                    DescricaoEspecializacao.setText("<html><body style='width:" + (width / 2.5) + "px'> " + "</body></html>");
                }
                DescricaoEspecializacao.setLocation(0, 0);
                PainelNomeEspecializacao.add(check, BorderLayout.WEST);
                PainelNomeEspecializacao.add(NomeEspecializacao, BorderLayout.CENTER);
                PainelNomeEspecializacao.add(UpOrDown, BorderLayout.EAST);

                PainelDescricaoEspecializacao.add(DescricaoEspecializacao);
                gbc.gridy = i; // Define a posição na grade
                PainelNomeEspecializacao.setOpaque(false);
                PainelDescricaoEspecializacao.setOpaque(false);
                PainelNewEspecializacao.add(PainelNomeEspecializacao, BorderLayout.NORTH);
                PainelNomeEspecializacao.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                PainelNomeEspecializacao.setBorder(new MatteBorder(0, 0, 1, 0, new Color(105, 105, 195)));

                System.out.println(ComboBoxOpcao.getSelectedItem());
                PainelEspecializacao.setOpaque(false);
                PainelEspecializacao.add(PainelNewEspecializacao, gbc);
                PainelEspecializacao.revalidate();
                PainelEspecializacao.repaint();

                int iComp = i;

                SwingUtilities.getWindowAncestor(PainelEspecializacao).addComponentListener(new ComponentAdapter() {
                    @Override
                    public void componentResized(ComponentEvent e) {
                        int width = SwingUtilities.getWindowAncestor(PainelEspecializacao).getSize().width;
                        // Atualiza o texto, ajustando a largura do body no HTML
                        if (Especializacoes.getJSONObject(iComp).has("v")) {
                            DescricaoEspecializacao.setText("<html><body style='width:" + (width / 2.5) + "px'>" + Especializacoes.getJSONObject(iComp).getString("v") + "</body></html>");
                        } else {
                            DescricaoEspecializacao.setText("<html><body style='width:" + (width / 2.5) + "px'> " + "</body></html>");
                        }
                    }
                });
                PainelNomeEspecializacao.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (PainelDescricaoEspecializacao.getParent() != null) {
                            ImageIcon Icone = new ImageIcon("src/visual/res/SmallDown.png");
                            UpOrDown.setIcon(Icone);
                            PainelNewEspecializacao.remove(PainelDescricaoEspecializacao);
                        } else {
                            PainelNewEspecializacao.add(PainelDescricaoEspecializacao);
                            ImageIcon Icone = new ImageIcon("src/visual/res/SmallUp.png");
                            UpOrDown.setIcon(Icone);
                        }
                        PainelNewEspecializacao.revalidate();
                        PainelNewEspecializacao.repaint();
                    }
                });

                check.addItemListener(new ItemListener() {
                    int posicao = 0;

                    public void itemStateChanged(ItemEvent e) {
                        JSONObject NovaEspecializacao = new JSONObject();
                        if (e.getStateChange() == ItemEvent.SELECTED) {
                            String descricao = "";
                            if (Especializacoes.getJSONObject(iComp).has("v")) {
                                descricao = Especializacoes.getJSONObject(iComp).getString("v");
                            }
                            NovaEspecializacao
                                    .put("a", new JSONObject()
                                            .put("f", Especializacoes.getJSONObject(iComp).getString("f"))
                                    )
                                    .put("b", new JSONObject()
                                            .put("uuid", Especializacoes.getJSONObject(iComp).getString("uuid"))
                                            .put(TituloCaminho, Especializacoes.getJSONObject(iComp).getString("u"))
                                            .put(DescricaoCaminho, descricao));
                            EspecializacoesNovas.put(NovaEspecializacao);
                            System.out.println("Especializacoes no vetor: " + EspecializacoesNovas);
                            System.out.println("Item adicionado: " + NovaEspecializacao);
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
                    EspecializacoesNovas.forEach(Especializacao -> {
                        ficha.getJSONArray(VetorCaminho).put(Especializacao);
                    });

                    EspecializacaoPanelP.EspecializacaoPanelP(personagemCaminho, ficha, PainelEspecializacaoFicha, VetorCaminho, TituloCaminho, DescricaoCaminho, PainelEspecializacoesFicha);
                    SwingUtilities.getWindowAncestor(AdicionarSelecionados).dispose();
                    SalvarFicha(ficha, personagemCaminho);

                }
            });

        }
    }
}
