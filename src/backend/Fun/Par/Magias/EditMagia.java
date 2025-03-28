/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.Fun.Par.Magias;

import backend.Fun.OrganizarASSET;
import java.lang.StringBuilder;
import org.json.*;
import javax.swing.*;
import backend.jsonParser;
import backend.Fun.VirtualObjects.NewMagiaArrayVO;
import backend.Fun.Par.Magias.MagiasAddP;
import backend.Fun.Rand;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author Admin
 */
public class EditMagia {

    public static void EditMagia(JSONArray Classes, JSONObject Magia, JTextField NomeMagia, JTextField EscolaMagia, JTextField DuracaoMagia, JTextField TempoMagia, JTextField AlcanceMagia, JTextField CompMagia, JTextArea Descricao, JLabel EditMagia, JLabel ClassesMagias, JPanel MagiaClasses, JLabel EditMagiaJ) {
        jsonParser sobrescrever = new jsonParser();
        String[] SelectedClasses = new String[Classes.length()];
        JSONArray z = new JSONArray();
        EditMagia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Magia.put("b", NomeMagia.getText());
                Magia.put("d", EscolaMagia.getText());
                Magia.put("e", DuracaoMagia.getText());
                Magia.put("f", TempoMagia.getText());
                Magia.put("g", AlcanceMagia.getText());
                Magia.put("i", CompMagia.getText());
                Magia.put("c", Descricao.getText());
                for (String ClasseId : SelectedClasses) {
                    if (ClasseId != null) {
                        z.put(ClasseId);
                    }
                }
                Magia.put("z", z);
            }
        });
        MagiaClasses.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddClasseP(ClassesMagias, Classes, SelectedClasses);
            }
        });
    }

    public static void AddClasseP(JLabel ClassesM, JSONArray Classes, String[] SelectedClasses) {
        JPanel PClassesM = new JPanel();
        PClassesM.setLayout(new BoxLayout(PClassesM, BoxLayout.Y_AXIS));
        for (int i = 0; i < Classes.length(); i++) {
            JPanel PClasseM = new JPanel(new FlowLayout(FlowLayout.LEFT));

            JCheckBox SelectClasse = new JCheckBox("", SelectedClasses[i] != null);
            JLabel ClasseNome = new JLabel(Classes.getJSONObject(i).getString("b"));
            PClasseM.add(SelectClasse);
            PClasseM.add(ClasseNome);
            PClassesM.add(PClasseM);
            final int iPos = i;

            SelectClasse.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (SelectClasse.isSelected()) {
                        SelectedClasses[iPos] = Classes.getJSONObject(iPos).getString("uuid");
                    } else {
                        SelectedClasses[iPos] = null;
                    }

                }
            });
        }
        int resultado = JOptionPane.showConfirmDialog(null, PClassesM, "Selecione as classes", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (resultado == JOptionPane.OK_OPTION) {
            StringBuilder ClassesStringLabel = new StringBuilder("Classes:");
            String v = "";
            for (int i = 0; i < SelectedClasses.length; i++) {
                if (SelectedClasses[i] != null) {
                    ClassesStringLabel.append(v + " " + Classes.getJSONObject(i).getString("b"));
                    v = ",";
                }
            }
            ClassesM.setText("<html><body style='width: 200px'>" + (String) ClassesStringLabel.toString() + "</body></html>");
        }
    }
}
