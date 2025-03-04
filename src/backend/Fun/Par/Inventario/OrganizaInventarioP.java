/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.Fun.Par.Inventario;

import static backend.Fun.SalvarFicha.SalvarFicha;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.Collator;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;
import javax.swing.*;

/**
 *
 * @author Admin
 */
public class OrganizaInventarioP {

    public static void OrganizarInventarioP(String personagemCaminho, JSONObject ficha, JLabel BotaoOrganizar) {
        BotaoOrganizar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                java.util.List<JSONObject> lista = new java.util.ArrayList<>();
                for (int i = 0; i < ficha.getJSONArray("i").length(); i++) {
                    lista.add(ficha.getJSONArray("i").getJSONObject(i));
                }

                Collections.sort(lista, new Comparator<JSONObject>() {
                    @Override
                    public int compare(JSONObject a, JSONObject b) {
                        Collator collator = Collator.getInstance(new Locale("pt", "BR"));
                        collator.setStrength(Collator.PRIMARY); // Ignora diferenças de acento
                        String nomeA = a.getJSONObject("b").getString("u");
                        String nomeB = b.getJSONObject("b").getString("u");
                        return collator.compare(nomeA, nomeB);
                    }
                });

                // Convertendo de volta para JSONArray
                JSONArray jsonArrayOrdenado = new JSONArray(lista);
                ficha.put("i", jsonArrayOrdenado);
                SalvarFicha(ficha, personagemCaminho);
            }
        });
    }
}
