/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.Funcoes.Parametros;

import static backend.Funcoes.SalvarFicha.SalvarFicha;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import org.json.JSONObject;

/**
 *
 * @author Admin
 */
public class SalvarP {
      public static void SalvarP(JSONObject ficha, JButton salvarBotao, String personagemCaminho) {
        salvarBotao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SalvarFicha(ficha, personagemCaminho);
            }
        });
    }
}
