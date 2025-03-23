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
public class NewMagiaArrayVO {

    public static JSONObject NewMagia(
            String Nome,
            String Escola,
            String Duracao,
            String Tempo,
            String Alcance,
            String Comp,
            String Descricao,
            int Lvl,
            String id) {
        if(id == null){
            id = Rand.NovoId(32);
        }
        return new JSONObject()
                .put("b", Nome)
                .put("c", Descricao)
                .put("d", Escola)
                .put("e", Duracao)
                .put("f", Tempo)
                .put("g", Alcance)
                .put("i", Comp)
                .put("k", Lvl)
                .put("l", true)
                .put("uuid", id);
    }
}
