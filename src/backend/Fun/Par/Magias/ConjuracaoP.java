/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.Fun.Par.Magias;
import org.json.*;
import javax.swing.*;
import java.awt.event.*;
import static backend.Fun.Proficiencia.Proficiencia;
import static backend.Fun.Mod.mod;
import static backend.Fun.SalvarFicha.SalvarFicha;
/**
 *
 * @author Admin
 */
public class ConjuracaoP {
    public static void ConjuracaoP(String personagemCaminho, JSONObject ficha, JComboBox Status, JLabel CD, JLabel Bonus){
        int StatusPos;
        int ResB;
        int ConjB;
        if(ficha.getJSONArray("a").getJSONObject(0).has("A1")){
            StatusPos = ficha.getJSONArray("a").getJSONObject(0).getInt("A1");
            Status.setSelectedIndex(StatusPos - 3);
        }else{
            StatusPos = Status.getSelectedIndex() + 3;
            ficha.getJSONArray("a").getJSONObject(0).put("A1", StatusPos);
            SalvarFicha(ficha, personagemCaminho);
        }
        if(ficha.getJSONArray("a").getJSONObject(0).has("A2")){
            ResB = ficha.getJSONArray("a").getJSONObject(0).getInt("A2");
            CD.setText(mod(ficha.getJSONArray("e").getJSONObject(StatusPos).getInt("b"), 8 + Proficiencia(ficha) + ResB));
        }else{
            ResB = 0;
            ficha.getJSONArray("a").getJSONObject(0).put("A2", ResB);
            CD.setText(mod(ficha.getJSONArray("e").getJSONObject(StatusPos).getInt("b"), 8 + Proficiencia(ficha) + ResB));
            SalvarFicha(ficha, personagemCaminho);
        }
        if(ficha.getJSONArray("a").getJSONObject(0).has("A3")){
           ConjB = ficha.getJSONArray("a").getJSONObject(0).getInt("A3");
            Bonus.setText(mod(ficha.getJSONArray("e").getJSONObject(StatusPos).getInt("b"), Proficiencia(ficha) + ConjB));
        }else{
            ConjB = 0;
            ficha.getJSONArray("a").getJSONObject(0).put("A3", ConjB);
            Bonus.setText(mod(ficha.getJSONArray("e").getJSONObject(StatusPos).getInt("b"), Proficiencia(ficha) + ConjB));
            SalvarFicha(ficha, personagemCaminho);
        }
        for (ActionListener ml : Status.getActionListeners()) {
            Status.removeActionListener(ml);
        }
        for (MouseListener ml : CD.getMouseListeners()) {
            CD.removeMouseListener(ml);
        }
        for (MouseListener ml : Bonus.getMouseListeners()) {
            Bonus.removeMouseListener(ml);
        }
        Status.addActionListener(new java.awt.event.ActionListener() {
            int NewStatusPos;
            @Override
            public void actionPerformed(ActionEvent e) {
                NewStatusPos = Status.getSelectedIndex() + 3;
                ficha.getJSONArray("a").getJSONObject(0).put("A1", NewStatusPos);
                SalvarFicha(ficha, personagemCaminho);
                CD.setText(mod(ficha.getJSONArray("e").getJSONObject(NewStatusPos).getInt("b"), 8 + Proficiencia(ficha) + ficha.getJSONArray("a").getJSONObject(0).getInt("A2")));
                Bonus.setText(mod(ficha.getJSONArray("e").getJSONObject(NewStatusPos).getInt("b"), Proficiencia(ficha) + ficha.getJSONArray("a").getJSONObject(0).getInt("A3")));
            }
        });
        CD.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e){
                try{
                int A2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira o bônus de CD", "" + ficha.getJSONArray("a").getJSONObject(0).getInt("A2")));
                ficha.getJSONArray("a").getJSONObject(0).put("A2", A2);
                ConjuracaoP(personagemCaminho, ficha, Status, CD, Bonus);
                }catch(java.lang.NumberFormatException err){
                    JOptionPane.showMessageDialog(null, "Valor inválido");
                }
                }
        });
        Bonus.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e){
                try{
                int A3 = Integer.parseInt(JOptionPane.showInputDialog(null, "Insira o bônus de conjuração", "" + ficha.getJSONArray("a").getJSONObject(0).getInt("A3")));
                ficha.getJSONArray("a").getJSONObject(0).put("A3", A3);
                ConjuracaoP(personagemCaminho, ficha, Status, CD, Bonus);
                }catch(java.lang.NumberFormatException err){
                    JOptionPane.showMessageDialog(null, "Valor inválido");
                }
                }
        });
    }
}
