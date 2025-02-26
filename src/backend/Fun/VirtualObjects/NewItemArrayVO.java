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
public class NewItemArrayVO {

    public JSONObject NovoItem(
            String TipoArma,
            int Preco,
            String TipoMoeda,
            double Peso,
            String TipoUnidade,
            String TipoItem,
            String Id,
            String ArmaduraStatus,
            String ArmaStatus,
            String Nome,
            String Descricao
    ) {
        if (Id.equals("")) {
            Id = Rand.NovoId(32);
        }
        switch (TipoItem) {
            case "Arma" -> {
                return new JSONObject()
                        .put("b", TipoArma)
                        .put("c", Preco)
                        .put("d", TipoMoeda)
                        .put("e", Peso)
                        .put("h", TipoUnidade)
                        .put("i", TipoItem)
                        .put("uuid", Id)
                        .put("q", ArmaStatus)
                        .put("u", Nome)
                        .put("v", Descricao);

            }
            case "Armadura" -> {
                return new JSONObject()
                        .put("c", Preco)
                        .put("d", TipoMoeda)
                        .put("e", Peso)
                        .put("h", TipoUnidade)
                        .put("i", TipoItem)
                        .put("uuid", Id)
                        .put("k", ArmaduraStatus)
                        .put("u", Nome)
                        .put("v", Descricao);
            }
            case "Escudo" -> {
                return new JSONObject()
                        .put("c", Preco)
                        .put("d", TipoMoeda)
                        .put("e", Peso)
                        .put("h", TipoUnidade)
                        .put("i", TipoItem)
                        .put("uuid", Id)
                        .put("u", Nome)
                        .put("v", Descricao);
            }
            case "Equipamento" -> {
                return new JSONObject()
                        .put("c", Preco)
                        .put("d", TipoMoeda)
                        .put("e", Peso)
                        .put("h", TipoUnidade)
                        .put("i", TipoItem)
                        .put("uuid", Id)
                        .put("u", Nome)
                        .put("v", Descricao);
            }
        }
        return new JSONObject();
    }
}
