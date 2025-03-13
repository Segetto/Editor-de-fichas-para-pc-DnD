/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.Fun.Par.Inventario;
import javax.swing.*;
import java.text.*;
import java.util.Locale;
import org.json.*;
/**
 *
 * @author Admin
 */
public class PesoCalc {
    public static void PesoCalc(JSONObject ficha, JLabel PesoMaximo, JLabel PesoAtual){
        double PADouble = 0;
        PADouble += ficha.getJSONArray("a").getJSONObject(0).getFloat("o") * 0.01;
        PADouble += ficha.getJSONArray("a").getJSONObject(0).getFloat("p") * 0.01;
        PADouble += ficha.getJSONArray("a").getJSONObject(0).getFloat("q") * 0.01;
        PADouble += ficha.getJSONArray("a").getJSONObject(0).getFloat("r") * 0.01;
        PADouble += ficha.getJSONArray("a").getJSONObject(0).getFloat("s") * 0.01;
        for(int i = 0; i < ficha.getJSONArray("i").length(); i++){
            PADouble += ficha.getJSONArray("i").getJSONObject(i).getJSONObject("b").getDouble("e") * ficha.getJSONArray("i").getJSONObject(i).getJSONObject("a").getInt("c");
        }
        DecimalFormatSymbols local = new DecimalFormatSymbols(Locale.US);
        DecimalFormat df = new DecimalFormat("#.##", local);
        PesoAtual.setText(df.format(PADouble) + "Kg");
        PesoMaximo.setText(ficha.getJSONArray("e").getJSONObject(0).getInt("b") * 7.5 + "Kg");
    }
}
