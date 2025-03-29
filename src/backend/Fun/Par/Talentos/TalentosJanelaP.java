/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.Fun.Par.Talentos;

import backend.Fun.Par.Especializacao.*;
import visual.EditarEspecializacaoASSET;
import static backend.Fun.FichaLer.FichaLerString;
import static backend.Fun.SalvarFicha.SalvarFicha;
import backend.Fun.Rand;
import backend.jsonParser;
import org.json.*;
import javax.swing.*;
import javax.swing.border.*;
import java.text.Normalizer;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Admin
 */
public class TalentosJanelaP {

    public static void EspecializacaoJanelaP(String personagemCaminho, JSONObject ficha, JPanel PainelEspecializacao, JComboBox Opcoes, JPanel PainelEspecializacaoFicha, JLabel AdicionarSelecionados, String VetorCaminho, String TituloCaminho, String DescricaoCaminho, JPanel PainelEspecializacoesFicha, JSONArray Especializacoes, JSONArray OpcoesComboBox, String CaminhoArquivo, JPanel PEspT, JTextField Search) {
        if (OpcoesComboBox != null) {
            for (int i = 0; i < OpcoesComboBox.length(); i++) {
                Opcoes.addItem(OpcoesComboBox.getJSONObject(i).getString("b")); // Adiciona cada item individualmente
            }
            if (VetorCaminho.equals("m")) {
                Opcoes.setSelectedItem(FichaLerString(ficha, "classe", 0));
            } else if (VetorCaminho.equals("n")) {
                Opcoes.setSelectedItem(FichaLerString(ficha, "Raca", 0));
            }
        }
        AdicionarEquipamentos(personagemCaminho, ficha, PainelEspecializacao, Opcoes, PainelEspecializacaoFicha, AdicionarSelecionados, VetorCaminho, TituloCaminho, DescricaoCaminho, PainelEspecializacoesFicha, Especializacoes, OpcoesComboBox, CaminhoArquivo, PEspT, Search);
    }

    public static void AdicionarEquipamentos(String personagemCaminho, JSONObject ficha, JPanel PainelEspecializacao, JComboBox ComboBoxOpcao, JPanel PainelEspecializacaoFicha, JLabel AdicionarSelecionados, String VetorCaminho, String TituloCaminho, String DescricaoCaminho, JPanel PainelEspecializacoesFicha, JSONArray Especializacoes, JSONArray ComboBoxArray, String CaminhoArquivo, JPanel PEspT, JTextField Search) {

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
        JPanel[] EspecializacoesVetor = new JPanel[Especializacoes.length()];
        int HeightInicialJanela = 192;
        jsonParser Sobrescrever = new jsonParser();
        if (ComboBoxArray == null) {
            ComboBoxOpcao.setVisible(false);
        }
        SwingWorker<Void, JPanel[]> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() {
                for (int i = 0; i < Especializacoes.length(); i++) {

                    JPanel PainelNewEspecializacao = new JPanel();
                    JCheckBox check = new JCheckBox();

                    PainelNewEspecializacao.setLayout(new BoxLayout(PainelNewEspecializacao, BoxLayout.Y_AXIS));
                    JPanel PainelNomeEspecializacao = new JPanel(new BorderLayout());
                    JLabel NomeEspecializacao = new JLabel(Especializacoes.getJSONObject(i).getString(TituloCaminho));
                    ImageIcon Icone = new ImageIcon("src/visual/res/SmallDown.png");
                    JLabel UpOrDown = new JLabel(Icone);
                    UpOrDown.setPreferredSize(new Dimension(30, 30));
                    NomeEspecializacao.setHorizontalAlignment(SwingConstants.CENTER);

                    JPanel PDescEsp = new JPanel();
                    PDescEsp.setLayout(new BoxLayout(PDescEsp, BoxLayout.Y_AXIS));
                    JLabel DescricaoEspecializacao = new JLabel();
                    int width = SwingUtilities.getWindowAncestor(PainelEspecializacao).getSize().width;
                    if (Especializacoes.getJSONObject(i).has(DescricaoCaminho)) {
                        DescricaoEspecializacao.setText("<html><body style='width:" + (width / 2.5) + "px'>" + Especializacoes.getJSONObject(i).getString(DescricaoCaminho) + "</body></html>");
                    } else {
                        DescricaoEspecializacao.setText("<html><body style='width:" + (width / 2.5) + "px'> " + "</body></html>");
                    }
                    PainelNomeEspecializacao.add(check, BorderLayout.WEST);
                    PainelNomeEspecializacao.add(NomeEspecializacao, BorderLayout.CENTER);
                    PainelNomeEspecializacao.add(UpOrDown, BorderLayout.EAST);
                    if (!Especializacoes.getJSONObject(i).has("uuid")) {
                        Especializacoes.getJSONObject(i).put("uuid", Rand.NovoId(32));
                    }
                    JPanel PDescTextoEsp = new JPanel();
                    PDescTextoEsp.add(DescricaoEspecializacao);
                    PDescTextoEsp.setOpaque(false);
                    PDescEsp.add(PDescTextoEsp);
                    final String idEsp = Especializacoes.getJSONObject(i).getString("uuid");
                    gbc.gridy = i; // Define a posição na grade
                    PainelNomeEspecializacao.setOpaque(false);
                    PDescEsp.setOpaque(false);
                    PainelNewEspecializacao.add(PainelNomeEspecializacao, BorderLayout.NORTH);
                    PainelNomeEspecializacao.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    PainelNomeEspecializacao.setBorder(new MatteBorder(0, 0, 1, 0, new Color(35, 35, 195)));
                    if (Especializacoes.getJSONObject(i).has("t") && Especializacoes.getJSONObject(i).getBoolean("t")) {
                        JPanel RemoverEspPainel = new JPanel();
                        JLabel EditarEsp = new JLabel("Editar Talento");
                        EditarEsp.setForeground(new Color(255, 255, 255));
                        EditarEsp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        JLabel RemoverEsp = new JLabel("Remover Talento");
                        RemoverEsp.setForeground(new Color(255, 105, 105));
                        RemoverEsp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        EditarEsp.setBorder(new MatteBorder(0, 0, 1, 0, new Color(255, 255, 255)));
                        RemoverEspPainel.add(EditarEsp);
                        RemoverEspPainel.add(RemoverEsp);
                        RemoverEspPainel.setOpaque(false);
                        PDescEsp.add(RemoverEspPainel);
                        final int iCompEdit = i;
                        EditarEsp.addMouseListener(new MouseAdapter() {
                            @Override

                            public void mouseClicked(MouseEvent e) {
                                EditarEspecializacaoASSET EditEsp = new EditarEspecializacaoASSET(Especializacoes, iCompEdit, TituloCaminho, DescricaoCaminho, ComboBoxArray, CaminhoArquivo, Especializacoes.getJSONObject(iCompEdit).getString(TituloCaminho), Especializacoes.getJSONObject(iCompEdit).getString(DescricaoCaminho), ComboBoxOpcao.getSelectedIndex(), EditarEsp);
                                EditEsp.setVisible(true);

                            }
                        });
                        final int iCompRemove = i;
                        RemoverEsp.addMouseListener(new MouseAdapter() {

                            @Override

                            public void mouseClicked(MouseEvent e) {
                                for (int j = 0; j < Especializacoes.length(); j++) {
                                    if (Especializacoes.getJSONObject(j).getString("uuid").equals(idEsp)) {
                                        Especializacoes.remove(j);
                                        j = Especializacoes.length();
                                    }
                                }
                                SwingUtilities.getWindowAncestor(PainelEspecializacao).dispose();
                                TalentosAddP.EspecializacoesAddP(personagemCaminho, ficha, PEspT, PainelEspecializacaoFicha, Especializacoes, VetorCaminho, TituloCaminho, DescricaoCaminho, PainelEspecializacoesFicha, ComboBoxArray, CaminhoArquivo);
                                Sobrescrever.sobrescreverArray(CaminhoArquivo, Especializacoes.toString(4));
                                PainelEspecializacao.revalidate();
                                PainelEspecializacao.repaint();

                            }
                        });
                    }
                    PainelEspecializacao.setOpaque(true);
                    PainelEspecializacao.setBackground(new Color(23, 23, 23));
                    PainelNewEspecializacao.setOpaque(false);
                    if (ComboBoxArray != null) {
                        PainelNewEspecializacao.setName(Especializacoes.getJSONObject(i).getString("b"));
                    }
                    EspecializacoesVetor[i] = PainelNewEspecializacao;
                    PainelEspecializacao.revalidate();
                    PainelEspecializacao.repaint();

                    int iComp = i;

                    SwingUtilities.getWindowAncestor(PainelEspecializacao).addComponentListener(new ComponentAdapter() {
                        @Override
                        public void componentResized(ComponentEvent e) {
                            int width = SwingUtilities.getWindowAncestor(PainelEspecializacao).getSize().width;
                            // Atualiza o texto, ajustando a largura do body no HTML
                            if (Especializacoes.getJSONObject(iComp).has(DescricaoCaminho)) {
                                DescricaoEspecializacao.setText("<html><body style='width:" + (width / 2.5) + "px'>" + Especializacoes.getJSONObject(iComp).getString(DescricaoCaminho) + "</body></html>");
                            } else {
                                DescricaoEspecializacao.setText("<html><body style='width:" + (width / 2.5) + "px'> " + "</body></html>");
                            }
                        }
                    });
                    PainelNomeEspecializacao.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            if (PDescEsp.getParent() != null) {
                                ImageIcon Icone = new ImageIcon("src/visual/res/SmallDown.png");
                                UpOrDown.setIcon(Icone);
                                PainelNewEspecializacao.remove(PDescEsp);
                            } else {
                                PainelNewEspecializacao.add(PDescEsp);
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
                                if (Especializacoes.getJSONObject(iComp).has(DescricaoCaminho)) {
                                    descricao = Especializacoes.getJSONObject(iComp).getString(DescricaoCaminho);
                                }
                                if (CaminhoArquivo.equals("ASSETS/Idiomas.json")) {
                                    NovaEspecializacao
                                            .put("a", new JSONObject()
                                                    .put("f", "")
                                                    .put("uuid", Rand.NovoId(32))
                                            )
                                            .put("b", new JSONObject()
                                                    .put("uuid", Especializacoes.getJSONObject(iComp).getString("uuid"))
                                                    .put(TituloCaminho, Especializacoes.getJSONObject(iComp).getString(TituloCaminho))
                                                    .put("e", Especializacoes.getJSONObject(iComp).getString("e"))
                                                    .put("f", Especializacoes.getJSONObject(iComp).getString("f"))
                                                    .put(DescricaoCaminho, descricao));
                                } else {
                                    NovaEspecializacao
                                            .put("a", new JSONObject()
                                                    .put("f", "")
                                                    .put("uuid", Rand.NovoId(32))
                                            )
                                            .put("b", new JSONObject()
                                                    .put("uuid", Especializacoes.getJSONObject(iComp).getString("uuid"))
                                                    .put(TituloCaminho, Especializacoes.getJSONObject(iComp).getString(TituloCaminho))
                                                    .put(DescricaoCaminho, descricao));
                                }
                                EspecializacoesNovas.put(NovaEspecializacao);
                                posicao = EspecializacoesNovas.length() - 1;
                            } else {
                                EspecializacoesNovas.remove(posicao);
                            }
                        }
                    });

                }
                ComboBoxOpcao.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (ComboBoxOpcao.getSelectedIndex() > ComboBoxArray.length() - 1) {
                            ExibirOpcoes(0, PainelEspecializacao, EspecializacoesVetor, gbc, Search.getText(), ComboBoxArray);
                        } else {
                            ExibirOpcoes(ComboBoxOpcao.getSelectedIndex(), PainelEspecializacao, EspecializacoesVetor, gbc, Search.getText(), ComboBoxArray);
                        }
                    }
                });
                return null;
            }

            @Override
            protected void done() {
                try {
                    get();
                    ExibirOpcoes(ComboBoxOpcao.getSelectedIndex(), PainelEspecializacao, EspecializacoesVetor, gbc, Search.getText(), ComboBoxArray);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        };
        worker.execute();
        AdicionarSelecionados.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                EspecializacoesNovas.forEach(Especializacao -> {
                    ficha.getJSONArray(VetorCaminho).put(Especializacao);
                });
                int heightChangeAdd = 0;
                for (Component comp : PainelEspecializacaoFicha.getComponents()) {
                    if (comp instanceof JPanel) {
                        JPanel panel = (JPanel) comp;
                        // Faça algo com cada JPanel encontrado
                        heightChangeAdd += panel.getPreferredSize().height;
                    }
                }
                PainelEspecializacaoFicha.setPreferredSize(new Dimension(PainelEspecializacaoFicha.getWidth(), (heightChangeAdd + HeightInicialJanela)));
                EspecializacaoPanelP.EspecializacaoPanelP(personagemCaminho, ficha, PainelEspecializacaoFicha, VetorCaminho, TituloCaminho, DescricaoCaminho, PainelEspecializacoesFicha);
                SwingUtilities.getWindowAncestor(AdicionarSelecionados).dispose();
                SalvarFicha(ficha, personagemCaminho);
                Sobrescrever.sobrescreverArray(CaminhoArquivo, Especializacoes.toString(4));
                desmarcarTodasCheckBoxes(PainelEspecializacao);

            }
        });
        Search.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                ExibirOpcoes(ComboBoxOpcao.getSelectedIndex(), PainelEspecializacao, EspecializacoesVetor, gbc, Search.getText(), ComboBoxArray);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                ExibirOpcoes(ComboBoxOpcao.getSelectedIndex(), PainelEspecializacao, EspecializacoesVetor, gbc, Search.getText(), ComboBoxArray);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                ExibirOpcoes(ComboBoxOpcao.getSelectedIndex(), PainelEspecializacao, EspecializacoesVetor, gbc, Search.getText(), ComboBoxArray);
            }
        });
    }

    public static void ExibirOpcoes(int posOpcao, JPanel PainelOpcoes, JPanel[] OpcoesLista, GridBagConstraints gbc, String BuscaString, JSONArray VetorComboBox) {
        PainelOpcoes.removeAll();
        PainelOpcoes.revalidate();
        PainelOpcoes.repaint();
        for (int i = 0; i < OpcoesLista.length; i++) {
            if (OpcoesLista[i] == null) {
                continue;
            }
            String nomeOpcao = OpcoesLista[i].getName();
            String Titulo = Normalizer.normalize(((JLabel) ((JPanel) OpcoesLista[i].getComponent(0)).getComponent(1)).getText().toLowerCase(), Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
            if ((VetorComboBox == null || nomeOpcao.equals(VetorComboBox.getJSONObject(posOpcao).getString("uuid"))) && (BuscaString == null || Titulo.contains(Normalizer.normalize(BuscaString.toLowerCase(), Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "")))) {
                PainelOpcoes.add(OpcoesLista[i], gbc);
                gbc.gridy++;
            }
        }
        PainelOpcoes.revalidate();
        PainelOpcoes.repaint();
    }

    public static void desmarcarTodasCheckBoxes(JPanel painel) {
        // Percorrer todos os componentes do painel
        for (Component componente : painel.getComponents()) {
            // Se o componente for um JPanel, chamar recursivamente
            if (componente instanceof JPanel) {
                desmarcarTodasCheckBoxes((JPanel) componente); // Chamada recursiva
            } // Verificar se o componente é uma JCheckBox
            else if (componente instanceof JCheckBox) {
                JCheckBox checkBox = (JCheckBox) componente;
                checkBox.setSelected(false); // Desmarcar a checkbox
            }
        }
    }
}
