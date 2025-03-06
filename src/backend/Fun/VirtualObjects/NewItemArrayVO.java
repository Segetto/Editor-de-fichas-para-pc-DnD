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
            String TipoDanoArma,
            int Preco,
            String TipoMoeda,
            double Peso,
            double QtdPadraoUnidade,
            String TipoUnidade,
            String TipoItem,
            String Id,
            int CABase,
            String ArmaduraStatus,
            int CapStatus,
            boolean FurtividadeDesvantagem,
            int StatusMinimoArmadura,
            String ArmaStatus,
            int CABonusEscudo,
            String Nome,
            String Descricao,
            String PropriedadeArma,
            String ArmaDadosDano,
            int BonusAtaqueArma,
            int BonusDanoArma
    ) {
        if (Id.equals("")) {
            Id = Rand.NovoId(32);
        }
        System.out.println("Item novo");
        switch (TipoItem) {
            case "Arma" -> {
                return new JSONObject()
                        .put("b", TipoDanoArma)
                        .put("c", Preco)
                        .put("d", TipoMoeda)
                        .put("e", Peso)
                        .put("g", QtdPadraoUnidade)
                        .put("h", TipoUnidade)
                        .put("i", TipoItem)
                        .put("uuid", Id)
                        .put("q", ArmaStatus)
                        .put("t", true)
                        .put("u", Nome)
                        .put("v", Descricao)
                        .put("w", PropriedadeArma)
                        .put("1", ArmaDadosDano)
                        .put("2", BonusAtaqueArma)
                        .put("3", BonusDanoArma);

            }
            case "WEAPON" -> {
                return new JSONObject()
                        .put("b", TipoDanoArma)
                        .put("c", Preco)
                        .put("d", TipoMoeda)
                        .put("e", Peso)
                        .put("g", QtdPadraoUnidade)
                        .put("h", TipoUnidade)
                        .put("i", "Arma")
                        .put("uuid", Id)
                        .put("q", ArmaStatus)
                        .put("t", true)
                        .put("u", Nome)
                        .put("v", Descricao)
                        .put("w", PropriedadeArma)
                        .put("1", ArmaDadosDano)
                        .put("2", BonusAtaqueArma)
                        .put("3", BonusDanoArma);

            }
            case "Armadura" -> {
                return new JSONObject()
                        .put("c", Preco)
                        .put("d", TipoMoeda)
                        .put("e", Peso)
                        .put("g", QtdPadraoUnidade)
                        .put("h", TipoUnidade)
                        .put("i", TipoItem)
                        .put("j", CABase)
                        .put("k", ArmaduraStatus)
                        .put("l", CapStatus)
                        .put("uuid", Id)
                        .put("m", FurtividadeDesvantagem)
                        .put("n", StatusMinimoArmadura)
                        .put("t", true)
                        .put("u", Nome)
                        .put("v", Descricao);
            }
            case "ARMOR" -> {
                return new JSONObject()
                        .put("c", Preco)
                        .put("d", TipoMoeda)
                        .put("e", Peso)
                        .put("g", QtdPadraoUnidade)
                        .put("h", TipoUnidade)
                        .put("i", "Armadura")
                        .put("j", CABase)
                        .put("k", ArmaduraStatus)
                        .put("l", CapStatus)
                        .put("uuid", Id)
                        .put("m", FurtividadeDesvantagem)
                        .put("n", StatusMinimoArmadura)
                        .put("t", true)
                        .put("u", Nome)
                        .put("v", Descricao);
            }
            case "Escudo" -> {
                return new JSONObject()
                        .put("c", Preco)
                        .put("d", TipoMoeda)
                        .put("e", Peso)
                        .put("g", QtdPadraoUnidade)
                        .put("h", TipoUnidade)
                        .put("i", TipoItem)
                        .put("uuid", Id)
                        .put("o", CABonusEscudo)
                        .put("t", true)
                        .put("u", Nome)
                        .put("v", Descricao);
            }
            case "SHIELD" -> {
                return new JSONObject()
                        .put("c", Preco)
                        .put("d", TipoMoeda)
                        .put("e", Peso)
                        .put("g", QtdPadraoUnidade)
                        .put("h", TipoUnidade)
                        .put("i", "SHIELD")
                        .put("uuid", Id)
                        .put("o", CABonusEscudo)
                        .put("t", true)
                        .put("u", Nome)
                        .put("v", Descricao);
            }
            case "Equipamento" -> {
                return new JSONObject()
                        .put("c", Preco)
                        .put("d", TipoMoeda)
                        .put("e", Peso)
                        .put("g", QtdPadraoUnidade)
                        .put("h", TipoUnidade)
                        .put("i", "Outros")
                        .put("uuid", Id)
                        .put("t", true)
                        .put("u", Nome)
                        .put("v", Descricao);
            }
        }
        return new JSONObject().put("c", Preco)
                .put("d", TipoMoeda)
                .put("e", Peso)
                .put("g", QtdPadraoUnidade)
                .put("h", TipoUnidade)
                .put("i", "Outros")
                .put("uuid", Id)
                .put("t", true)
                .put("u", Nome)
                .put("v", Descricao);
    }
}
