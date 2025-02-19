/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.Funcoes;

import org.json.JSONObject;

/**
 *
 * @author Admin
 */
public class FichaLer {
        public static String FichaLerString(JSONObject ficha, String campo, int i) {
        String resultadoString = "";
        switch (campo) {
            case "nome":
                if (ficha.getJSONArray("a").length() > 0) {
                    resultadoString = ficha.getJSONArray("a").getJSONObject(0).getString("a");
                }
                break;
            case "classe":
                if (ficha.getJSONArray("d").length() > 0) {
                    resultadoString = ficha.getJSONArray("d").getJSONObject(i).getJSONObject("b").getString("b");
                }
                break;
            case "Raca":
                if (ficha.getJSONArray("c").length() > 0) {
                    resultadoString = ficha.getJSONArray("c").getJSONObject(0).getString("b");
                }
                break;
            case "Antecedente":
                if (ficha.getJSONArray("c").length() > 0) {
                    resultadoString = ficha.getJSONArray("a").getJSONObject(0).getString("3");
                }
                break;

        }
        return resultadoString;
    }

    public static int FichaLerInt(JSONObject ficha, String valor, int i) {
        int resultadoInt = 0;
        switch (valor) {
            case "nivel":
                if (ficha.getJSONArray("d").getJSONObject(i).getJSONObject("a").getInt("c") >= 0) {
                    resultadoInt = ficha.getJSONArray("d").getJSONObject(i).getJSONObject("a").getInt("c");
                }
                break;
            case "vida atual":
                if (ficha.getJSONArray("a").getJSONObject(0).getInt("l") >= 0) {
                    resultadoInt = ficha.getJSONArray("a").getJSONObject(0).getInt("l");
                }
                break;
            case "vida total":
                if (ficha.getJSONArray("a").getJSONObject(0).getInt("j") >= 0) {
                    resultadoInt = ficha.getJSONArray("a").getJSONObject(0).getInt("j");
                }
                break;
            case "xp":
                if (ficha.getJSONArray("a").getJSONObject(0).getInt("d") >= 0) {
                    resultadoInt = ficha.getJSONArray("a").getJSONObject(0).getInt("d");
                }
                break;
            case "Status":
                if (ficha.getJSONArray("e").getJSONObject(0).getInt("b") > 0) {
                    resultadoInt = ficha.getJSONArray("e").getJSONObject(i).getInt("b");
                }

        }
        return resultadoInt;
    }

}
