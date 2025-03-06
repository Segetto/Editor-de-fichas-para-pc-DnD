/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.Fun.Par.ClassesJanela;

import backend.Fun.VirtualObjects.NewClasseVO;
import visual.personagemFicha;
import static backend.Fun.IntCampo.IntCampo;
import backend.jsonParser;
import javax.swing.*;
import java.awt.*;
import org.json.*;

/**
 *
 * @author Admin
 */
public class NewClasseP {

    public static void NewClasseP(JLabel NewClasseBotao, JLabel ClasseLabel, String personagemCaminho) {
        NewClasseBotao.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTextField NomeClasse = new JTextField();
                JTextField DadoVida = new JTextField();
                IntCampo(DadoVida);
                // Criando um painel e adicionando os campos
                JPanel painel = new JPanel();
                painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS)); // Layout vertical
                painel.add(new JLabel("Digite o nome da nova classe:"));
                painel.add(NomeClasse);
                painel.add(new JLabel("Digite o número do dado de vida:"));
                painel.add(DadoVida);
                int resultado = JOptionPane.showConfirmDialog(null, painel, "Entrada de Dados",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

                // Verificando se o usuário pressionou "OK"
                if (resultado == JOptionPane.OK_OPTION) {
                    String Nome = NomeClasse.getText();
                    int Dado = (int) Integer.parseInt(DadoVida.getText());
                    jsonParser leitor = new jsonParser();

                    JSONArray Classes = new JSONArray(leitor.LerArray("ASSETS/Classe.json"));
                    Classes.put(NewClasseVO.NewClasse(Nome, Dado));
                    leitor.sobrescreverArray("ASSETS/Classe.json", Classes.toString());
                    SwingUtilities.getWindowAncestor(NewClasseBotao).dispose();
                    for (Frame frame : Frame.getFrames()) {
                        if (frame.isDisplayable()) {
                            frame.dispose();
                        }
                    }
                    personagemFicha novaJanela = new personagemFicha(personagemCaminho.replace("personagensJSON/", "").replace(".json", ""));
                    novaJanela.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Operação cancelada.");
                }

            }

        });
    }
}
