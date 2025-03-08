/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.Fun.Par.Inventario;

import backend.Fun.trocarPainel;
import org.json.*;
import javax.swing.*;
import visual.CriarItem;

/**
 *
 * @author Admin
 */
public class CriarItemLabelP {

    public static void CriarItemLabelP(JSONArray equipamentos, JLabel NewEquip, String personagemCaminho, JSONObject ficha, JPanel EquipamentosPanelFicha, JLabel BonusCALabel, JPanel EquipamentoPainel, JPanel AddEquip) {
        trocarPainel mudar = new trocarPainel();
        CriarItem novoFrame = new CriarItem(equipamentos, personagemCaminho, ficha, EquipamentosPanelFicha, BonusCALabel, EquipamentoPainel, AddEquip);
        NewEquip.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mudar.painelChange(novoFrame);
            }
        });
    }
}
