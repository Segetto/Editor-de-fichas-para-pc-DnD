/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import javax.swing.*;
import java.awt.*;
import visual.Opcoes;
import backend.jsonParser;
import backend.FichaVO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Admin
 */
public class OpcoesVO {

    public void AddOpcoes(JSONObject ficha, String TipoOpcao, ButtonGroup BotoesGrupo, JPanel Painel) {
        Painel.setLayout(new BoxLayout(Painel, BoxLayout.Y_AXIS));
        String OpcaoCaminho = "ASSETS/" + TipoOpcao + ".json";
        jsonParser leitor = new jsonParser();
        JSONArray opcoes = new JSONArray(leitor.LerArray(OpcaoCaminho));
        FichaVO FichaVo = new FichaVO();
        for (int i = 0; i < opcoes.length(); i++) {
            JRadioButton opcao = new JRadioButton(opcoes.getJSONObject(i).getString("b"));
            BotoesGrupo.add(opcao);
            opcao.setBounds(10, 30 * i, 10, 30);
            opcao.setOpaque(false);
            Painel.setBackground(new Color(23, 23, 23));
            OpcaoEvent(opcao, ficha, i, opcoes);
            opcao.setBackground(new Color(23, 23, 23));
            if (opcao.getText().equals(FichaVo.FichaLerString(ficha, TipoOpcao, i))) {
                opcao.setSelected(true);
            }

            Painel.add(opcao);
        }

    }

    public void OpcaoEvent(JRadioButton opcao, JSONObject ficha, int i, JSONArray opcoes) {
        opcao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JSONObject RacaCampo = new JSONObject();

                JSONArray RacaNova = new JSONArray();
                RacaNova.put(
                        new JSONObject()
                                .put("uuid", opcoes.getJSONObject(i).getString("uuid"))
                                .put("b", opcao.getText()));
                ficha.put("c", RacaNova);
            }

        });
    }

    public void SairP(String personagemCaminho, JSONObject ficha, JButton sair, JLabel RacaSelect) {
        sair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FichaVO FichaVo = new FichaVO();
                FichaVo.RacaLabel(ficha, RacaSelect);
                FichaVo.SalvarFicha(ficha, personagemCaminho);
            }
        });
    }

}
