/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import visual.Classes;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import backend.jsonParser;
import backend.Fun.Rand;
import backend.Fun.trocarPainel;
import java.awt.FlowLayout;
import javax.swing.event.*;
import org.json.JSONObject;
import org.json.JSONArray;

/**
 *
 * @author Admin
 */
public class ClassesVO {

    jsonParser arquivo = new jsonParser();

    public void ClassesOptions(JPanel painel, JSONObject ficha) {
        JSONArray Classes = new JSONArray(arquivo.LerArray("ASSETS/Classe.json"));
        int FichaClasseNum = 0;
        boolean check = false;
        for (int i = 0; i < Classes.length(); i++) {
            String ClasseId = Classes.getJSONObject(i).getString("uuid");
            String ClasseNome = Classes.getJSONObject(i).getString("b");
            String classeIdFicha = "";
            if (FichaClasseNum < ficha.getJSONArray("d").length()) {
                classeIdFicha = ficha.getJSONArray("d").getJSONObject(FichaClasseNum).getJSONObject("b").getString("uuid");

                if (ClasseId.equals(classeIdFicha)) {
                    check = true;
                }
            }
            addClasseOption(i, ClasseNome, check, painel, FichaClasseNum, ficha);
            if (ClasseId.equals(classeIdFicha)) {
                FichaClasseNum++;
            }
            check = false;
        }
    }

    public void addClasseOption(int pos, String classe, boolean Checked, JPanel painelClasses, int FichaPos, JSONObject ficha) {
        JCheckBox checkbox = new JCheckBox(classe, Checked);
        JPanel ClasseRow = new JPanel();

        ClasseRow.setLayout(new GridLayout(1, 2));
        ClasseRow.setBounds(10, 30 * pos, 200, 30);
        checkbox.setPreferredSize(new Dimension(120, 20));
        JSpinner Nivel = new JSpinner(new SpinnerNumberModel(1, 1, 99, 1));
        Nivel.setBorder(null);
        ClasseRow.setBackground(new java.awt.Color(23, 23, 23));
        checkbox.setBackground(new java.awt.Color(23, 23, 23));
        Nivel.setBackground(new java.awt.Color(23, 23, 23));
        Nivel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        ClasseRow.add(checkbox);
        Nivel.setPreferredSize(new Dimension(30, 20));
          JComponent editor = Nivel.getEditor();
            if (editor instanceof JSpinner.DefaultEditor defaultEditor) {
                JFormattedTextField textField = defaultEditor.getTextField();
                textField.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                textField.setEditable(false); // Impede edição direta
                textField.setFocusable(false); // Evita foco no campo de texto
            }
        ClasseRow.add(Nivel);
        events(checkbox, Nivel, ficha, pos, FichaPos, ClasseRow);
        if (Checked == true) {
            Nivel.setValue(ficha.getJSONArray("d").getJSONObject(FichaPos).getJSONObject("a").getInt("c"));
        } else {
            Nivel.setVisible(false);
        }

        painelClasses.add(ClasseRow);
    }

    public void events(JCheckBox checkbox, JSpinner spinner, JSONObject ficha, int pos, int FichaPos, JPanel ClasseRow) {

        checkbox.addItemListener(new ItemListener() {

            public void itemStateChanged(ItemEvent e) {
                JSONArray Classes = new JSONArray(arquivo.LerArray("ASSETS/Classe.json"));
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    JSONObject ClasseCampo = new JSONObject();
                    ClasseCampo.put("a", new JSONObject()
                            .put("c", spinner.getValue())
                            .put("a", Classes.getJSONObject(pos).getString("uuid")));
                    ClasseCampo.put("b", new JSONObject()
                            .put("b", checkbox.getText())
                            .put("uuid", Classes.getJSONObject(pos).getString("uuid")));
                    ficha.getJSONArray("d").put(ClasseCampo);

                    List<JSONObject> jsonList = new ArrayList<>();
                    for (int i = 0; i < ficha.getJSONArray("d").length(); i++) {
                        jsonList.add(ficha.getJSONArray("d").getJSONObject(i));
                    }
                    jsonList.sort(Comparator.comparing(obj -> normalizeString(obj.getJSONObject("b").getString("b"))));
                    JSONArray sortedJsonArray = new JSONArray(jsonList);
                    ficha.put("d", sortedJsonArray);
                    spinner.setVisible(true);
                } else {
                    for (int i = 0; i < ficha.getJSONArray("d").length(); i++) {
                        if (ficha.getJSONArray("d").getJSONObject(i).getJSONObject("b").getString("b").equals(checkbox.getText())) {
                            ficha.getJSONArray("d").remove(i);
                            break;

                        }
                    }
                    spinner.setValue(1);
                    spinner.setVisible(false);
                    ClasseRow.revalidate();
                    ClasseRow.repaint();
                }

            }
        });
  
        spinner.addChangeListener(e -> {
            int valor = (int) spinner.getValue();

            // Buscar a posição correta da classe no array atualizado
            for (int i = 0; i < ficha.getJSONArray("d").length(); i++) {
                if (ficha.getJSONArray("d").getJSONObject(i).getJSONObject("b").getString("b").equals(checkbox.getText())) {
                    ficha.getJSONArray("d").getJSONObject(i).getJSONObject("a").put("c", valor);
                    break;
                }
            }
        });
    }

    private static String normalizeString(String input) {
        return Normalizer.normalize(input, Normalizer.Form.NFD) // Decompõe caracteres acentuados
                .replaceAll("\\p{M}", ""); // Remove marcas diacríticas (acentos)
    }

    public void sair(JButton botao) {
        botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
