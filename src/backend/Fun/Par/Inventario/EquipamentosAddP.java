/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.Fun.Par.Inventario;

import backend.Fun.trocarPainel;
import javax.swing.*;
import org.json.*;
import visual.Equipamento;

/**
 *
 * @author Admin
 */
public class EquipamentosAddP {
    public static void EquipamentosAddP(String personagemCaminho, JSONObject ficha, JPanel AddEquip, JPanel FichaEquip, JSONArray itens, JLabel BonusCALabel){
                         trocarPainel mudar = new trocarPainel();
                Equipamento novoFrame = new Equipamento(personagemCaminho, ficha, FichaEquip, itens, BonusCALabel);
        AddEquip.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mudar.painelChange(novoFrame);
            }
        });
    }
}
