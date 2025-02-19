/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.Fun;

import static backend.Fun.FichaLer.FichaLerString;
import backend.jsonParser;
import org.json.JSONObject;

/**
 *
 * @author Admin
 */
public class SalvarFicha {
     public static void SalvarFicha(JSONObject ficha, String personagemCaminho) {
        jsonParser leitor = new jsonParser();
        leitor.sobrescreverArquivo(personagemCaminho, ficha.toString(), "personagensJSON/" + FichaLerString(ficha, "nome", 0) + ".json");
    }
}
