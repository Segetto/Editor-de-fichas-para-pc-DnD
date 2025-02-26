/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.Fun.Par.ClassesJanela;
import backend.Fun.VirtualObjects.NewClasseVO;
import backend.jsonParser;
import javax.swing.*;
import org.json.*;
/**
 *
 * @author Admin
 */
public class NewClasseP {
    public static void NewClasseP(JLabel NewClasseBotao){
        NewClasseBotao.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                String nome = JOptionPane.showInputDialog("Digite o nome da classe:");
                    jsonParser leitor = new jsonParser();

                JSONArray Classes = new JSONArray(leitor.LerArray("ASSETS/Classe.json"));
                Classes.put(NewClasseVO.NewClasse(nome, 8));
                leitor.sobrescreverArray("ASSETS/Classe.json", Classes.toString());
                SwingUtilities.getWindowAncestor(NewClasseBotao).dispose();
            }
 

           
        });
    }
}
