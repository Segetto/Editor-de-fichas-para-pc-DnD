/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.Fun.VirtualObjects;

import static backend.Fun.Rand.NovoId;
import org.json.JSONObject;

/**
 *
 * @author Admin
 */
public class NewClasseVO {
     public static JSONObject NewClasse(String NovaClasseNome, int NovaClasseDado){
        return new JSONObject()
                .put("b", NovaClasseNome)
                .put("uuid", NovoId(32))
                .put("e", NovaClasseDado)
                .put("a", "pt");
    }
}
