/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.Fun.VirtualObjects;
import org.json.*;
import static backend.Fun.Rand.NovoId;
/**
 *
 * @author Admin
 */
public class NewRacaVO {
    public static JSONObject NewRaca(String NovaClasseNome){
        return new JSONObject()
                .put("uuid", NovoId(32))
                .put("b", NovaClasseNome)
                .put("a", "pt");
    }
}
