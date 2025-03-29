/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.Fun;

import org.json.*;

/**
 *
 * @author Admin
 */
public class BuscaJSONArrayFicha {

    public static int BBArray(JSONArray ArrayBusca, String Campo, String Valor) {
        int esquerda = 0;
        int direita = ArrayBusca.length() - 1;

        while (esquerda <= direita) {
            int meio = esquerda + (direita - esquerda) / 2; // Evita estouro de inteiro

            int comparacao = ArrayBusca.getJSONObject(meio).getJSONObject("b").getString(Campo).toLowerCase().replaceAll("[^\\p{ASCII}]", "").compareTo(Valor.toLowerCase().replaceAll("[^\\p{ASCII}]", ""));

            if (comparacao == 0) {
                return meio; // Encontrou o elemento
            } else if (comparacao < 0) {
                esquerda = meio + 1; // Ajusta para a metade direita
            } else {
                direita = meio - 1; // Ajusta para a metade esquerda
            }
        }
        return -1; // Elemento não encontrado
    }
}
