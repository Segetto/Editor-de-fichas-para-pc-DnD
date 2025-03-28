/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.Fun.Par.Magias;

import static backend.Fun.FichaLer.FichaLerString;
import backend.Fun.Rand;
import static backend.Fun.SalvarFicha.SalvarFicha;
import static backend.Fun.BuscaJSONArrayFicha.BBArray;
import backend.jsonParser;
import org.json.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.*;
import java.awt.event.*;
import java.text.Normalizer;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
//import visual.EditarMagiaASSET;

/**
 *
 * @author Admin
 */
public class MagiasJanelaP {

    public static void MagiasJanelaP(String personagemCaminho, JSONObject ficha, JPanel PMagias, JComboBox Opcoes, JPanel PMagiasTF, String VetorCaminho, String TituloCaminho, String DescricaoCaminho, JPanel PMagiasF, JSONArray Magias, JSONArray OpcoesComboBox, String CaminhoArquivo, JPanel PMagiasT, int MagiaLvl, JTextField Search) {
        for (int i = 0; i < OpcoesComboBox.length(); i++) {
            Opcoes.addItem(OpcoesComboBox.getJSONObject(i).getString("b"));
        }
        Opcoes.setSelectedItem(FichaLerString(ficha, "classe", 0));
        Opcoes.addItem("Todos");
        AdicionarEquipamentos(personagemCaminho, ficha, PMagias, Opcoes, PMagiasTF, VetorCaminho, TituloCaminho, DescricaoCaminho, PMagiasF, Magias, OpcoesComboBox, CaminhoArquivo, PMagiasT, MagiaLvl, Search);

    }

    public static void AdicionarEquipamentos(String personagemCaminho, JSONObject ficha, JPanel PMagias, JComboBox ComboBoxOpcao, JPanel PMagiasTF, String VetorCaminho, String TituloCaminho, String DescricaoCaminho, JPanel PMagiasF, JSONArray Magias, JSONArray ComboBoxArray, String CaminhoArquivo, JPanel PMagiasT, int MagiaLvl, JTextField Search) {
        PMagias.removeAll();
        PMagias.revalidate();
        PMagias.repaint();
        PMagias.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH; // Expande horizontal e verticalmente
        gbc.weightx = 1.0; // Permite expansão horizontal
        gbc.weighty = 0.0; // Não cresce infinitamente
        gbc.gridwidth = GridBagConstraints.REMAINDER; // Ocupa toda a linha
        gbc.insets = new Insets(0, 0, 5, 0); // Espaço entre os Magias
        JSONArray MagiasNovas = new JSONArray();
        JPanel[] PaineisMagiasOpcoes = new JPanel[Magias.length()];
        int HeightInicialJanela = 192;
        jsonParser Sobrescrever = new jsonParser();
        if (ComboBoxArray == null) {
            ComboBoxOpcao.setVisible(false);
        }
        SwingWorker<Void, JPanel[]> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() {
                for (int i = 0; i < Magias.length(); i++) {
                    if (Magias.getJSONObject(i).getInt("k") == MagiaLvl) {

                        JPanel PNewMagia = new JPanel();
                        JCheckBox check = new JCheckBox();
                        int FichaPos = BBArray(ficha.getJSONArray("r"), "b", Magias.getJSONObject(i).getString(TituloCaminho));
                        if (FichaPos != -1) {
                            check.setSelected(true);
                        }
                        PNewMagia.setLayout(new BoxLayout(PNewMagia, BoxLayout.Y_AXIS));
                        JPanel PNomeMagia = new JPanel(new BorderLayout());
                        JLabel NomeMagia = new JLabel(Magias.getJSONObject(i).getString(TituloCaminho));
                        NomeMagia.setForeground(new Color(255, 255, 255));
                        ImageIcon Icone = new ImageIcon("src/visual/res/SmallDown.png");
                        JLabel UpOrDown = new JLabel(Icone);
                        UpOrDown.setPreferredSize(new Dimension(30, 30));
                        NomeMagia.setHorizontalAlignment(SwingConstants.CENTER);

                        JPanel PDescEsp = new JPanel();
                        PDescEsp.setLayout(new BoxLayout(PDescEsp, BoxLayout.Y_AXIS));
                        JLabel DescricaoMagia = new JLabel();
                        DescricaoMagia.setForeground(new Color(255, 255, 255));
                        int width = SwingUtilities.getWindowAncestor(PMagias).getSize().width;
                        if (Magias.getJSONObject(i).has(DescricaoCaminho)) {
                            DescricaoMagia.setText("<html><body style='width:" + (width / 2.5) + "px'>"
                                    + "<br> <b>Escola</b>: " + Magias.getJSONObject(i).getString("d") + "<br><br>"
                                    + "<b>Duração: </b>" + Magias.getJSONObject(i).getString("e") + "<br><br>"
                                    + "<b>Tempo de conjuração: </b>" + Magias.getJSONObject(i).getString("f") + "<br><br>"
                                    + "<b>Alcance: </b>" + Magias.getJSONObject(i).getString("g") + "<br><br>"
                                    + "<b>Componentes: </b>" + Magias.getJSONObject(i).getString("i") + "<br><br>"
                                    + Magias.getJSONObject(i).getString(DescricaoCaminho) + "</body></html>");
                        } else {
                            DescricaoMagia.setText("<html><body style='width:" + (width / 2.5) + "px'> " + "</body></html>");
                        }
                        PNomeMagia.add(check, BorderLayout.WEST);
                        PNomeMagia.add(NomeMagia, BorderLayout.CENTER);
                        PNomeMagia.add(UpOrDown, BorderLayout.EAST);
                        if (!Magias.getJSONObject(i).has("uuid")) {
                            Magias.getJSONObject(i).put("uuid", Rand.NovoId(32));
                        }
                        JPanel PDescTextoEsp = new JPanel();
                        PDescTextoEsp.add(DescricaoMagia);
                        PDescTextoEsp.setOpaque(false);
                        PDescEsp.add(PDescTextoEsp);
                        final String idMagia = Magias.getJSONObject(i).getString("uuid");
                        gbc.gridy = i;
                        PNomeMagia.setOpaque(false);
                        PDescEsp.setOpaque(false);
                        PNewMagia.add(PNomeMagia);
                        PNomeMagia.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        PNomeMagia.setBorder(new MatteBorder(0, 0, 1, 0, new Color(35, 35, 195)));
                        if (Magias.getJSONObject(i).has("l") && Magias.getJSONObject(i).getBoolean("l")) {
                            JPanel RemoverEspP = new JPanel();
                            JLabel EditarEsp = new JLabel("Editar Magia");
                            EditarEsp.setForeground(new Color(255, 255, 255));
                            EditarEsp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                            JLabel RemoverEsp = new JLabel("Remover Magia");
                            RemoverEsp.setForeground(new Color(255, 105, 105));
                            RemoverEsp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                            EditarEsp.setBorder(new MatteBorder(0, 0, 1, 0, new Color(255, 255, 255)));
                            RemoverEspP.add(EditarEsp);
                            RemoverEspP.add(RemoverEsp);
                            RemoverEspP.setOpaque(false);
                            PDescEsp.add(RemoverEspP);
                            final int iCompEdit = i;
                            EditarEsp.addMouseListener(new MouseAdapter() {
                                @Override

                                public void mouseClicked(MouseEvent e) {
                                    // EditarMagiaASSET EditEsp = new EditarMagiaASSET(Magias, iCompEdit, TituloCaminho, DescricaoCaminho, ComboBoxArray, CaminhoArquivo, Magias.getJSONObject(iCompEdit).getString(TituloCaminho), Magias.getJSONObject(iCompEdit).getString(DescricaoCaminho), ComboBoxOpcao.getSelectedIndex(), EditarEsp);
                                    // EditEsp.setVisible(true);

                                }
                            });
                            final int iCompRemove = i;
                            RemoverEsp.addMouseListener(new MouseAdapter() {

                                @Override

                                public void mouseClicked(MouseEvent e) {
                                    for (int j = 0; j < Magias.length(); j++) {
                                        if (Magias.getJSONObject(j).getString("uuid").equals(idMagia)) {
                                            Magias.remove(j);
                                            j = Magias.length();
                                        }
                                    }
                                    SwingUtilities.getWindowAncestor(PMagias).dispose();
                                    MagiasAddP.MagiasAddP(personagemCaminho, ficha, PMagiasT, PMagiasTF, Magias, VetorCaminho, TituloCaminho, DescricaoCaminho, CaminhoArquivo, PMagiasF, ComboBoxArray, MagiaLvl);
                                    Sobrescrever.sobrescreverArray(CaminhoArquivo, Magias.toString(4));
                                    PMagias.revalidate();
                                    PMagias.repaint();

                                }
                            });
                        }
                        PNewMagia.setName(idMagia);
                        PMagias.setOpaque(true);
                        PMagias.setBackground(new Color(23, 23, 23));
                        PNewMagia.setOpaque(false);
                        PaineisMagiasOpcoes[i] = PNewMagia;
                        PMagias.revalidate();
                        PMagias.repaint();

                        int iComp = i;

                        SwingUtilities.getWindowAncestor(PMagias).addComponentListener(new ComponentAdapter() {
                            @Override
                            public void componentResized(ComponentEvent e) {
                                int width = SwingUtilities.getWindowAncestor(PMagias).getSize().width;
                                if (Magias.getJSONObject(iComp).has(DescricaoCaminho)) {
                                    DescricaoMagia.setText("<html><body style='width:" + (width / 2.5) + "px'>"
                                            + "<br> <b>Escola</b>: " + Magias.getJSONObject(iComp).getString("d") + "<br><br>"
                                            + "<b>Duração: </b>" + Magias.getJSONObject(iComp).getString("e") + "<br><br>"
                                            + "<b>Tempo de conjuração: </b>" + Magias.getJSONObject(iComp).getString("f") + "<br><br>"
                                            + "<b>Alcance: </b>" + Magias.getJSONObject(iComp).getString("g") + "<br><br>"
                                            + "<b>Componentes: </b>" + Magias.getJSONObject(iComp).getString("i") + "</body></html>");
                                } else {
                                    DescricaoMagia.setText("<html><body style='width:" + (width / 2.5) + "px'> " + "</body></html>");
                                }
                            }
                        });
                        PNomeMagia.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                if (PDescEsp.getParent() != null) {
                                    ImageIcon Icone = new ImageIcon("src/visual/res/SmallDown.png");
                                    UpOrDown.setIcon(Icone);
                                    PNewMagia.remove(PDescEsp);
                                } else {
                                    PNewMagia.add(PDescEsp);
                                    ImageIcon Icone = new ImageIcon("src/visual/res/SmallUp.png");
                                    UpOrDown.setIcon(Icone);
                                }
                                PNewMagia.revalidate();
                                PNewMagia.repaint();
                            }
                        });

                        check.addItemListener(new ItemListener() {
                            int posicao = 0;

                            public void itemStateChanged(ItemEvent e) {
                                JSONObject NovaMagia = new JSONObject();
                                if (e.getStateChange() == ItemEvent.SELECTED) {
                                    String descricao = "";
                                    if (Magias.getJSONObject(iComp).has(DescricaoCaminho)) {
                                        descricao = Magias.getJSONObject(iComp).getString(DescricaoCaminho);
                                    }
                                    NovaMagia
                                            .put("a", new JSONObject()
                                                    .put("uuid", Rand.NovoId(32))
                                                    .put("e", false)
                                            )
                                            .put("b", new JSONObject()
                                                    .put("uuid", Magias.getJSONObject(iComp).getString("uuid"))
                                                    .put(TituloCaminho, Magias.getJSONObject(iComp).getString(TituloCaminho))
                                                    .put(DescricaoCaminho, descricao).put("d", Magias.getJSONObject(iComp).getString("d"))
                                                    .put("e", Magias.getJSONObject(iComp).getString("e"))
                                                    .put("f", Magias.getJSONObject(iComp).getString("f"))
                                                    .put("g", Magias.getJSONObject(iComp).getString("g"))
                                                    .put("i", Magias.getJSONObject(iComp).getString("i"))
                                                    .put("k", Magias.getJSONObject(iComp).getInt("k")));
                                    ficha.getJSONArray("r").put(NovaMagia);
                                    MagiasPanelP.MagiasPanelP(personagemCaminho, ficha, PMagiasTF, PMagiasF, MagiaLvl, PMagiasT);
                                    SalvarFicha(ficha, personagemCaminho);
                                } else {
                                    int FichaPosDelete = BBArray(ficha.getJSONArray("r"), "b", Magias.getJSONObject(iComp).getString(TituloCaminho));
                                    if (FichaPosDelete != -1) {
                                        ficha.getJSONArray("r").remove(FichaPosDelete);
                                        MagiasPanelP.MagiasPanelP(personagemCaminho, ficha, PMagiasTF, PMagiasF, MagiaLvl, PMagiasT);
                                        SalvarFicha(ficha, personagemCaminho);
                                    }
                                }
                            }
                        });
                    }

                }
                return null;
            }

            @Override
            protected void done() {
                try {
                    get();
                    ExibirOpcoes(ComboBoxArray.getJSONObject(ComboBoxOpcao.getSelectedIndex()).getString("uuid"), PMagias, PaineisMagiasOpcoes, gbc, Search.getText(), Magias);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        };
        worker.execute();
        ComboBoxOpcao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ComboBoxOpcao.getSelectedIndex() > ComboBoxArray.length() - 1) {
                    ExibirOpcoes(null, PMagias, PaineisMagiasOpcoes, gbc, Search.getText(), null);
                } else {
                    String NewOpcao = ComboBoxArray.getJSONObject(ComboBoxOpcao.getSelectedIndex()).getString("uuid");
                    ExibirOpcoes(NewOpcao, PMagias, PaineisMagiasOpcoes, gbc, Search.getText(), Magias);
                }
            }
        });
        Search.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String NewOpcao = null;
                if (ComboBoxArray.length() - 1 > ComboBoxOpcao.getSelectedIndex()) {
                    NewOpcao = ComboBoxArray.getJSONObject(ComboBoxOpcao.getSelectedIndex()).getString("uuid");
                }
                ExibirOpcoes(NewOpcao, PMagias, PaineisMagiasOpcoes, gbc, Search.getText(), Magias);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String NewOpcao = null;
                if (ComboBoxArray.length() - 1 > ComboBoxOpcao.getSelectedIndex()) {
                    NewOpcao = ComboBoxArray.getJSONObject(ComboBoxOpcao.getSelectedIndex()).getString("uuid");
                }
                ExibirOpcoes(NewOpcao, PMagias, PaineisMagiasOpcoes, gbc, Search.getText(), Magias);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                String NewOpcao = null;
                if (ComboBoxArray.length() - 1 > ComboBoxOpcao.getSelectedIndex()) {
                    NewOpcao = ComboBoxArray.getJSONObject(ComboBoxOpcao.getSelectedIndex()).getString("uuid");
                }
                ExibirOpcoes(NewOpcao, PMagias, PaineisMagiasOpcoes, gbc, Search.getText(), Magias);
            }
        });
    }

    public static void ExibirOpcoes(String TipoOpcoes, JPanel PainelOpcoes, JPanel[] OpcoesLista, GridBagConstraints gbc, String BuscaString, JSONArray Magias) {
        PainelOpcoes.removeAll();
        for (int i = 0; i < OpcoesLista.length; i++) {
            if (OpcoesLista[i] == null) {
                continue;
            }
            String nomeOpcao = OpcoesLista[i].getName();
            if (nomeOpcao == null) {
                continue;
            }
            String Titulo = Normalizer.normalize(((JLabel) ((JPanel) OpcoesLista[i].getComponent(0)).getComponent(1)).getText().toLowerCase(), Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
            if (Magias != null) {
                for (int j = 0; j < Magias.getJSONObject(i).getJSONArray("z").length(); j++) {
                    if ((TipoOpcoes == null || TipoOpcoes.equals(Magias.getJSONObject(i).getJSONArray("z").getString(j))) && (BuscaString == null || Titulo.contains(Normalizer.normalize(BuscaString.toLowerCase(), Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "")))) {
                        PainelOpcoes.add(OpcoesLista[i], gbc);
                        gbc.gridy++;
                    }
                }
            } else {
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
