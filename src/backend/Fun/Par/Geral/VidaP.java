/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.Fun.Par.Geral;

import static backend.Fun.FichaLer.FichaLerInt;
import backend.Fun.IntCampo;
import static backend.Fun.SalvarFicha.SalvarFicha;
import static backend.Fun.VidaSpinner.VidaSpinner;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import org.json.JSONObject;

/**
 *
 * @author Admin
 */
public class VidaP {
        private static Timer timer;
        public static void VidaP(String personagemCaminho, JSONObject ficha, JTextField VidaAtual, JTextField VidaTotal, JLabel VidaCura, JLabel VidaDano) {
        VidaAtual.setText("" + FichaLerInt(ficha, "vida atual", 0));
        VidaTotal.setText("" + FichaLerInt(ficha, "vida total", 0));
        IntCampo.IntCampo(VidaTotal);
        IntCampo.IntCampo(VidaAtual);
        VidaCura.addMouseListener(new java.awt.event.MouseAdapter() {

            private int delay = 500;

            @Override
            public void mousePressed(MouseEvent e) {
                timer = new Timer(delay, evt -> {

                    if (delay > 100) {
                        delay *= 0.5;
                        timer.setDelay(delay);
                    }
                    VidaSpinner(personagemCaminho, ficha, VidaAtual, VidaTotal, "cura");
                });
                timer.start();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                timer.stop();
                delay = 500;
            }

            public void mouseClicked(java.awt.event.MouseEvent evt) {
                VidaSpinner(personagemCaminho, ficha, VidaAtual, VidaTotal, "cura");
            }
        });
        VidaDano.addMouseListener(new java.awt.event.MouseAdapter() {
            private int delay = 500;

            @Override
            public void mousePressed(MouseEvent e) {
                timer = new Timer(delay, evt -> {

                    if (delay > 100) {
                        delay *= 0.5;
                        timer.setDelay(delay);
                    }
                    VidaSpinner(personagemCaminho, ficha, VidaAtual, VidaTotal, "dano");
                });
                timer.start();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                timer.stop();
                delay = 500;
            }

            public void mouseClicked(java.awt.event.MouseEvent evt) {
                VidaSpinner(personagemCaminho, ficha, VidaAtual, VidaTotal, "dano");
            }
        });
        VidaAtual.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {

                if (VidaTotal.getText().trim().isEmpty()) {
                    ficha.getJSONArray("e").getJSONObject(0).put("l", 0);
                } else {
                    ficha.getJSONArray("a").getJSONObject(0).put("l", Integer.parseInt(VidaTotal.getText()));
                }
                SalvarFicha(ficha, personagemCaminho);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {

                if (VidaTotal.getText().trim().isEmpty()) {
                    ficha.getJSONArray("e").getJSONObject(0).put("l", 0);
                } else {
                    ficha.getJSONArray("a").getJSONObject(0).put("l", Integer.parseInt(VidaTotal.getText()));
                }
                SalvarFicha(ficha, personagemCaminho);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                SalvarFicha(ficha, personagemCaminho);

            }
        });
        VidaTotal.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {

                if (VidaTotal.getText().trim().isEmpty()) {
                    ficha.getJSONArray("e").getJSONObject(0).put("j", 0);
                } else {
                    ficha.getJSONArray("a").getJSONObject(0).put("j", Integer.parseInt(VidaTotal.getText()));
                }
                SalvarFicha(ficha, personagemCaminho);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {

                if (VidaTotal.getText().trim().isEmpty()) {
                    ficha.getJSONArray("e").getJSONObject(0).put("j", 0);
                } else {
                    ficha.getJSONArray("a").getJSONObject(0).put("j", Integer.parseInt(VidaTotal.getText()));
                }
                SalvarFicha(ficha, personagemCaminho);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                SalvarFicha(ficha, personagemCaminho);

            }
        });
    }

}
