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
public class OrganizarASSET {
    public JSONArray OrganizarJSONArray(JSONArray ArrayEntrada){
         java.util.List<JSONObject> lista = new java.util.ArrayList<>();
                    for (int i = 0; i < ArrayEntrada.length(); i++) {
                        lista.add(ArrayEntrada.getJSONObject(i));
                    }

                    // Ordenando a lista com base no campo "b.u"
                    Collections.sort(lista, new Comparator<JSONObject>() {
                        @Override
                        public int compare(JSONObject a, JSONObject b) {
                            Collator collator = Collator.getInstance(new Locale("pt", "BR"));
                            collator.setStrength(Collator.PRIMARY); // Ignora diferenças de acento
                            String nomeA = a.getString("u");
                            String nomeB = b.getString("u");
                            return collator.compare(nomeA, nomeB);
                        }
                    });

                    // Convertendo de volta para JSONArray
                    return new JSONArray(lista);
    }
}
