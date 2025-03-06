/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import javax.swing.*;
import java.awt.*;
import visual.Opcoes;
import backend.jsonParser;
import static backend.Fun.FichaLer.FichaLerString;
import static backend.Fun.OptionLabel.OptionLabel;
import static backend.Fun.SalvarFicha.SalvarFicha;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Admin
 */
public class OpcoesP {

    public void AddOpcoes(JSONObject ficha, String TipoOpcao, ButtonGroup BotoesGrupo, JPanel Painel, String ArrayNome) {
        Painel.setLayout(new BoxLayout(Painel, BoxLayout.Y_AXIS));
        String OpcaoCaminho = "ASSETS/" + TipoOpcao + ".json";
        jsonParser leitor = new jsonParser();
        JSONArray opcoes = new JSONArray(leitor.LerArray(OpcaoCaminho));
        for (int i = 0; i < opcoes.length(); i++) {
            JRadioButton opcao = new JRadioButton(opcoes.getJSONObject(i).getString("b"));
            BotoesGrupo.add(opcao);
            opcao.setBounds(10, 30 * i, 10, 30);
            opcao.setOpaque(false);
            Painel.setBackground(new Color(23, 23, 23));
            OpcaoEvent(opcao, ficha, i, opcoes, ArrayNome);
            opcao.setBackground(new Color(23, 23, 23));
            if (opcao.getText().equals(FichaLerString(ficha, TipoOpcao, i))) {
                opcao.setSelected(true);
            }

            Painel.add(opcao);
        }

    }

    public void OpcaoEvent(JRadioButton opcao, JSONObject ficha, int i, JSONArray opcoes, String ArrayNome) {
        opcao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JSONObject RacaCampo = new JSONObject();

                JSONArray OpcaoNova = new JSONArray();
                OpcaoNova.put(
                        new JSONObject()
                                .put("uuid", opcoes.getJSONObject(i).getString("uuid"))
                                .put("b", opcao.getText()));
                ficha.put(ArrayNome, OpcaoNova);
            }

        });
    }

    public void SairP(String personagemCaminho, JSONObject ficha, JButton sair, JLabel OpcaoSelect, String TipoOpcao) {
        sair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OptionLabel(ficha, OpcaoSelect, TipoOpcao);
                SalvarFicha(ficha, personagemCaminho);
            }
        });
    }

}
