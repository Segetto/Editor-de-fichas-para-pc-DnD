/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.Fun.VirtualObjects;

import org.json.*;
import backend.Fun.Rand;

/**
 *
 * @author Admin
 */
public class NewItemFichaVO {

    public static JSONObject NovoItemFicha(JSONArray itens, int pos) {
        JSONObject NovoItem = new JSONObject();
        String descricao = "";
        String TipoArma = "";
        int CABase = 0;
        boolean FurtividadeDesvantagem = false;
        int StatusMinimo = 0;
        String StatusArmadura = "";
        int CapStatus = 0;
        int CABonusEscudo = 0;
        String StatusArma = "";
        String PropriedadeArma = "";
        String DadosDano = "";
        int BonusAtaque = 0;
        int BonusDano = 0;
        if (itens.getJSONObject(pos).has("v")) {
            descricao = itens.getJSONObject(pos).getString("v");
        }
        if (itens.getJSONObject(pos).has("b")) {
            TipoArma = itens.getJSONObject(pos).getString("b");
        }
        if (itens.getJSONObject(pos).has("j")) {
            CABase = itens.getJSONObject(pos).getInt("j");
        }
        if (itens.getJSONObject(pos).has("k")) {
            StatusArmadura = itens.getJSONObject(pos).getString("k");
        }
        if (itens.getJSONObject(pos).has("l")) {
            CapStatus = itens.getJSONObject(pos).getInt("l");
        }
        if (itens.getJSONObject(pos).has("m")) {
            FurtividadeDesvantagem = true;
        }
        if (itens.getJSONObject(pos).has("n")) {
            StatusMinimo = itens.getJSONObject(pos).getInt("n");
        }
        if (itens.getJSONObject(pos).has("o")) {
            CABonusEscudo = itens.getJSONObject(pos).getInt("o");
        }
        if (itens.getJSONObject(pos).has("q")) {
            StatusArma = itens.getJSONObject(pos).getString("q");
        }
        if (itens.getJSONObject(pos).has("w")) {
            PropriedadeArma = itens.getJSONObject(pos).getString("w");
        }
        if (itens.getJSONObject(pos).has("1")) {
            DadosDano = itens.getJSONObject(pos).getString("1");
        }
        if (itens.getJSONObject(pos).has("2")) {
            BonusAtaque = itens.getJSONObject(pos).getInt("2");
        }
        if (itens.getJSONObject(pos).has("3")) {
            BonusDano = itens.getJSONObject(pos).getInt("3");
        }
        NovoItem
                .put("a", new JSONObject()
                        .put("f", "")
                        .put("d", false)
                        .put("e", false)
                        .put("uuid", Rand.NovoId(32))
                )
                .put("b", new JSONObject()
                        .put("b", TipoArma)
                        .put("c", itens.getJSONObject(pos).getInt("c")) //Valor item
                        .put("d", itens.getJSONObject(pos).getString("d")) //Tipo moeda
                        .put("e", itens.getJSONObject(pos).getDouble("e")) //Peso
                        .put("g", itens.getJSONObject(pos).getInt("g")) //Quantidade padrão
                        .put("h", itens.getJSONObject(pos).getString("h")) //Tipo Quantidade padrão
                        .put("i", itens.getJSONObject(pos).getString("i")) //Tipo item
                        .put("j", CABase) //CA Base (Armadura)
                        .put("k", StatusArmadura) //Tipo de status armadura
                        .put("l", CapStatus) //Limite bonus de CA status
                        .put("uuid", itens.getJSONObject(pos).getString("uuid")) //Id
                        .put("m", FurtividadeDesvantagem) //Desvantagem de furtividade armadura
                        .put("n", StatusMinimo) //Status necessário armadura
                        .put("o", CABonusEscudo) //Bonus CA escudo
                        .put("q", StatusArma) //Status da arma
                        .put("t", itens.getJSONObject(pos).getBoolean("t")) //É customizado
                        .put("u", itens.getJSONObject(pos).getString("u")) //Nome
                        .put("v", descricao)
                        .put("w", PropriedadeArma) //Propriedade especial da arma
                        .put("1", DadosDano)
                        .put("2", BonusAtaque)
                        .put("3", BonusDano))
                .put("c", new JSONArray());
        return NovoItem;
    }
}
