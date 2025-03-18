/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.Fun.Par.Magias;

import static backend.Fun.FichaLer.FichaLerString;
import backend.Fun.Rand;
import static backend.Fun.SalvarFicha.SalvarFicha;
import backend.jsonParser;
import org.json.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.*;
import java.awt.event.*;
import java.text.Collator;
import java.util.*;
//import visual.EditarMagiaASSET;

/**
 *
 * @author Admin
 */
public class MagiasJanelaP {

    public static void MagiaJanelaP(String personagemCaminho, JSONObject ficha, JPanel PainelMagia, JComboBox Opcoes, JPanel PainelMagiaFicha, JLabel AdicionarSelecionados, String VetorCaminho, String TituloCaminho, String DescricaoCaminho, JPanel PainelMagiasFicha, JSONArray Magias, JSONArray OpcoesComboBox, String CaminhoArquivo, JPanel PEspT, int MagiaLvl) {
        for (int i = 0; i < OpcoesComboBox.length(); i++) {
            Opcoes.addItem(OpcoesComboBox.getJSONObject(i).getString("b"));
        }
        Opcoes.setSelectedItem(FichaLerString(ficha, "classe", 0));

        AdicionarEquipamentos(personagemCaminho, ficha, PainelMagia, Opcoes, PainelMagiaFicha, AdicionarSelecionados, VetorCaminho, TituloCaminho, DescricaoCaminho, PainelMagiasFicha, Magias, OpcoesComboBox, CaminhoArquivo, PEspT, MagiaLvl);
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
                AdicionarEquipamentos(personagemCaminho, ficha, PainelMagia, Opcoes, PainelMagiaFicha, AdicionarSelecionados, VetorCaminho, TituloCaminho, DescricaoCaminho, PainelMagiasFicha, Magias, OpcoesComboBox, CaminhoArquivo, PEspT, MagiaLvl);
            }
        });
    }

    public static void AdicionarEquipamentos(String personagemCaminho, JSONObject ficha, JPanel PainelMagia, JComboBox ComboBoxOpcao, JPanel PainelMagiaFicha, JLabel AdicionarSelecionados, String VetorCaminho, String TituloCaminho, String DescricaoCaminho, JPanel PainelMagiasFicha, JSONArray Magias, JSONArray ComboBoxArray, String CaminhoArquivo, JPanel PEspT, int MagiaLvl) {

        PainelMagia.removeAll();
        PainelMagia.revalidate();
        PainelMagia.repaint();
        PainelMagia.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH; // Expande horizontal e verticalmente
        gbc.weightx = 1.0; // Permite expansão horizontal
        gbc.weighty = 0.0; // Não cresce infinitamente
        gbc.gridwidth = GridBagConstraints.REMAINDER; // Ocupa toda a linha
        gbc.insets = new Insets(0, 0, 5, 0); // Espaço entre os Magias
        JSONArray MagiasNovas = new JSONArray();
        int HeightInicialJanela = 192;
        jsonParser Sobrescrever = new jsonParser();
        if (ComboBoxArray == null) {
            ComboBoxOpcao.setVisible(false);
        }
        for (int i = 0; i < Magias.length(); i++) {
            if (ComboBoxArray == null || ComboBoxArray.getJSONObject(ComboBoxOpcao.getSelectedIndex()).getString("uuid").equals(Magias.getJSONObject(i).getString("b"))) {

                JPanel PainelNewMagia = new JPanel();
                JCheckBox check = new JCheckBox();

                PainelNewMagia.setLayout(new BoxLayout(PainelNewMagia, BoxLayout.Y_AXIS));
                JPanel PainelNomeMagia = new JPanel(new BorderLayout());
                JLabel NomeMagia = new JLabel(Magias.getJSONObject(i).getString(TituloCaminho));
                ImageIcon Icone = new ImageIcon("src/visual/res/SmallDown.png");
                JLabel UpOrDown = new JLabel(Icone);
                UpOrDown.setPreferredSize(new Dimension(30, 30));
                NomeMagia.setHorizontalAlignment(SwingConstants.CENTER);

                JPanel PDescEsp = new JPanel();
                PDescEsp.setLayout(new BoxLayout(PDescEsp, BoxLayout.Y_AXIS));
                JLabel DescricaoMagia = new JLabel();
                int width = SwingUtilities.getWindowAncestor(PainelMagia).getSize().width;
                if (Magias.getJSONObject(i).has(DescricaoCaminho)) {
                    DescricaoMagia.setText("<html><body style='width:" + (width / 2.5) + "px'>" + Magias.getJSONObject(i).getString(DescricaoCaminho) + "</body></html>");
                } else {
                    DescricaoMagia.setText("<html><body style='width:" + (width / 2.5) + "px'> " + "</body></html>");
                }
                PainelNomeMagia.add(check, BorderLayout.WEST);
                PainelNomeMagia.add(NomeMagia, BorderLayout.CENTER);
                PainelNomeMagia.add(UpOrDown, BorderLayout.EAST);
                if (!Magias.getJSONObject(i).has("uuid")) {
                    Magias.getJSONObject(i).put("uuid", Rand.NovoId(32));
                }
                JPanel PDescTextoEsp = new JPanel();
                PDescTextoEsp.add(DescricaoMagia);
                PDescTextoEsp.setOpaque(false);
                PDescEsp.add(PDescTextoEsp);
                final String idEsp = Magias.getJSONObject(i).getString("uuid");
                gbc.gridy = i; // Define a posição na grade
                PainelNomeMagia.setOpaque(false);
                PDescEsp.setOpaque(false);
                PainelNewMagia.add(PainelNomeMagia, BorderLayout.NORTH);
                PainelNomeMagia.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                PainelNomeMagia.setBorder(new MatteBorder(0, 0, 1, 0, new Color(35, 35, 195)));
                if (Magias.getJSONObject(i).has("t") && Magias.getJSONObject(i).getBoolean("t")) {
                    JPanel RemoverEspPainel = new JPanel();
                    JLabel EditarEsp = new JLabel("Editar Especialização");
                    EditarEsp.setForeground(new Color(255, 255, 255));
                    EditarEsp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    JLabel RemoverEsp = new JLabel("Remover Especialização");
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
                            // EditarMagiaASSET EditEsp = new EditarMagiaASSET(Magias, iCompEdit, TituloCaminho, DescricaoCaminho, ComboBoxArray, CaminhoArquivo, Magias.getJSONObject(iCompEdit).getString(TituloCaminho), Magias.getJSONObject(iCompEdit).getString(DescricaoCaminho), ComboBoxOpcao.getSelectedIndex(), EditarEsp);
                            // EditEsp.setVisible(true);

                        }
                    });
                    final int iCompRemove = i;
                    RemoverEsp.addMouseListener(new MouseAdapter() {

                        @Override

                        public void mouseClicked(MouseEvent e) {
                            for (int j = 0; j < Magias.length(); j++) {
                                if (Magias.getJSONObject(j).getString("uuid").equals(idEsp)) {
                                    Magias.remove(j);
                                    j = Magias.length();
                                }
                            }
                            SwingUtilities.getWindowAncestor(PainelMagia).dispose();
                            MagiasAddP.MagiasAddP(personagemCaminho, ficha, PEspT, PainelMagiaFicha, Magias, VetorCaminho, TituloCaminho, DescricaoCaminho, PainelMagiasFicha, ComboBoxArray, CaminhoArquivo);
                            Sobrescrever.sobrescreverArray(CaminhoArquivo, Magias.toString(4));
                            PainelMagia.revalidate();
                            PainelMagia.repaint();

                        }
                    });
                }
                PainelMagia.setOpaque(true);
                PainelMagia.setBackground(new Color(23, 23, 23));
                PainelNewMagia.setOpaque(false);
                PainelMagia.add(PainelNewMagia, gbc);
                PainelMagia.revalidate();
                PainelMagia.repaint();

                int iComp = i;

                SwingUtilities.getWindowAncestor(PainelMagia).addComponentListener(new ComponentAdapter() {
                    @Override
                    public void componentResized(ComponentEvent e) {
                        int width = SwingUtilities.getWindowAncestor(PainelMagia).getSize().width;
                        // Atualiza o texto, ajustando a largura do body no HTML
                        if (Magias.getJSONObject(iComp).has(DescricaoCaminho)) {
                            DescricaoMagia.setText("<html><body style='width:" + (width / 2.5) + "px'>" + Magias.getJSONObject(iComp).getString(DescricaoCaminho) + "</body></html>");
                        } else {
                            DescricaoMagia.setText("<html><body style='width:" + (width / 2.5) + "px'> " + "</body></html>");
                        }
                    }
                });
                PainelNomeMagia.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (PDescEsp.getParent() != null) {
                            ImageIcon Icone = new ImageIcon("src/visual/res/SmallDown.png");
                            UpOrDown.setIcon(Icone);
                            PainelNewMagia.remove(PDescEsp);
                        } else {
                            PainelNewMagia.add(PDescEsp);
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
                            if (Magias.getJSONObject(iComp).has(DescricaoCaminho)) {
                                descricao = Magias.getJSONObject(iComp).getString(DescricaoCaminho);
                            }
                            NovaMagia
                                    .put("a", new JSONObject()
                                            .put("f", "")
                                            .put("uuid", Rand.NovoId(32))
                                    )
                                    .put("b", new JSONObject()
                                            .put("uuid", Magias.getJSONObject(iComp).getString("uuid"))
                                            .put(TituloCaminho, Magias.getJSONObject(iComp).getString(TituloCaminho))
                                            .put(DescricaoCaminho, descricao));
                            MagiasNovas.put(NovaMagia);
                            posicao = MagiasNovas.length() - 1;
                        } else {
                            MagiasNovas.remove(posicao);
                        }
                    }
                });
            }

        }
        AdicionarSelecionados.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                MagiasNovas.forEach(Magia -> {
                    ficha.getJSONArray(VetorCaminho).put(Magia);
                });
                int heightChangeAdd = 0;
                for (Component comp : PainelMagiaFicha.getComponents()) {
                    if (comp instanceof JPanel) {
                        JPanel panel = (JPanel) comp;
                        // Faça algo com cada JPanel encontrado
                        heightChangeAdd += panel.getPreferredSize().height;
                    }
                }
                PainelMagiaFicha.setPreferredSize(new Dimension(PainelMagiaFicha.getWidth(), (heightChangeAdd + HeightInicialJanela)));
                MagiasPanelP.MagiasPanelP(personagemCaminho, ficha, PainelMagiaFicha, PainelMagiasFicha, MagiaLvl);
                SwingUtilities.getWindowAncestor(AdicionarSelecionados).dispose();
                SalvarFicha(ficha, personagemCaminho);
                Sobrescrever.sobrescreverArray(CaminhoArquivo, Magias.toString(4));
            }
        });
    }
}
