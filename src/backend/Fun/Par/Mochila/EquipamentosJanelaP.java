/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.Fun.Par.Mochila;

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
public class EquipamentosJanelaP {

    public static void EquipamentosJanelaP(String personagemCaminho, JSONObject ficha, JPanel PainelItens, JComboBox Opcoes, JPanel PainelItensFicha) {
        String Opcao = (String) Opcoes.getSelectedItem();
        AdicionarEquipamentos(personagemCaminho, ficha, PainelItens, Opcao, PainelItensFicha);
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
                AdicionarEquipamentos(personagemCaminho, ficha, PainelItens, NewOpcao, PainelItensFicha);

            }
        });
    }

    public static void AdicionarEquipamentos(String personagemCaminho, JSONObject ficha, JPanel PainelItens, String TipoItem, JPanel PainelItensFicha) {

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
        JSONArray itens = new JSONArray(LerArray("ASSETS/Equipamento.json"));
        int QtdItensFicha = 0;
        for (int i = 0; i < itens.length(); i++) {
            JPanel PainelItem = new JPanel();
            JCheckBox check = new JCheckBox();
            if (ficha.getJSONArray("i").length() != 0 && ficha.getJSONArray("i").length() > QtdItensFicha) {
                if (ficha.getJSONArray("i").getJSONObject(QtdItensFicha).getJSONObject("b").getString("uuid").equals(itens.getJSONObject(i).getString("uuid"))) {
                    check.setSelected(true);
                    QtdItensFicha++;

                }
            }
            PainelItem.setLayout(new BoxLayout(PainelItem, BoxLayout.Y_AXIS));
            JPanel PainelNomeItem = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JLabel NomeItem = new JLabel(itens.getJSONObject(i).getString("u"));
            NomeItem.setPreferredSize(new Dimension(200, 15));
            NomeItem.setHorizontalAlignment(SwingConstants.CENTER);

            JPanel PainelDescricaoItem = new JPanel();
            JLabel DescricaoItem = new JLabel();
            if (itens.getJSONObject(i).has("v")) {
                DescricaoItem.setText("<html><div style='width: 110px;'>" + itens.getJSONObject(i).getString("v") + "</div></html>");
            } else {
                DescricaoItem.setText("<html><div style='width: 110px;'> " + "</div></html>");
            }
            DescricaoItem.setLocation(0, 0);
            PainelNomeItem.add(check);
            PainelNomeItem.add(NomeItem);
            PainelDescricaoItem.add(DescricaoItem);

            gbc.gridy = i; // Define a posição na grade
            PainelItem.setOpaque(false);
            PainelNomeItem.setOpaque(false);
            PainelDescricaoItem.setOpaque(false);
            PainelItem.add(PainelNomeItem, BorderLayout.NORTH);
            PainelNomeItem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            PainelNomeItem.setBorder(new MatteBorder(0, 0, 1, 0, new Color(105, 105, 195)));
            if (TipoItem.equals(itens.getJSONObject(i).getString("i"))) {
                PainelItens.add(PainelItem, gbc);
            }
            int QtdItensFichaComp = QtdItensFicha - 1;
            int iComp = i;
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
            check.addItemListener(new ItemListener() {

                public void itemStateChanged(ItemEvent e) {
                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        String descricao = "";
                        if (itens.getJSONObject(iComp).has("v")) {
                            descricao = itens.getJSONObject(iComp).getString("v");
                        }
                        ficha.getJSONArray("i").put(new JSONObject()
                                .put("a", new JSONObject())
                                .put("b", new JSONObject()
                                        .put("uuid", itens.getJSONObject(iComp).getString("uuid"))
                                        .put("u", itens.getJSONObject(iComp).getString("u"))
                                        .put("v", descricao)
                                ));
                    } else {
                        ficha.getJSONArray("i").remove(QtdItensFichaComp);
                    }
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
                }
            });

        }
    }
}
