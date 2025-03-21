/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.Fun;
import java.text.Collator;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;
import org.json.*;
/**
 *
 * @author Admin
 */
public class OrgJSONArrayFicha {
    public static JSONArray Organizar(JSONArray VetorJSONAntigo, String campo){
         java.util.List<JSONObject> lista = new java.util.ArrayList<>();
        for (int i = 0; i < VetorJSONAntigo.length(); i++) {
            lista.add(VetorJSONAntigo.getJSONObject(i));
        }

        // Ordenando a lista com base no campo "b.u"
        Collections.sort(lista, new Comparator<JSONObject>() {
            @Override
            public int compare(JSONObject a, JSONObject b) {
                Collator collator = Collator.getInstance(new Locale("pt", "BR"));
                collator.setStrength(Collator.PRIMARY); // Ignora diferenças de acento
                String nomeA = a.getJSONObject("b").getString(campo);
                String nomeB = b.getJSONObject("b").getString(campo);
                return collator.compare(nomeA, nomeB);
            }
        });

        // Convertendo de volta para JSONArray
        JSONArray jsonArrayOrdenado = new JSONArray(lista);
        return jsonArrayOrdenado;
    }
}
