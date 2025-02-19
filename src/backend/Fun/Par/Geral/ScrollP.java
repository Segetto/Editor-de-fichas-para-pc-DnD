/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.Fun.Par.Geral;
import javax.swing.*;
/**
 *
 * @author Admin
 */
public class ScrollP {
    public static void ScrollP(JScrollPane Geral, JScrollPane Mochila, JScrollPane Feiticos, JScrollPane CarClasse){
                Geral.getVerticalScrollBar().setUnitIncrement(10);
        Mochila.getVerticalScrollBar().setUnitIncrement(10);
        Feiticos.getVerticalScrollBar().setUnitIncrement(10);
        CarClasse.getVerticalScrollBar().setUnitIncrement(10);
    }
}
