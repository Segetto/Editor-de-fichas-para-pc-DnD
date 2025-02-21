/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.Fun;

import java.util.Random;
/**
 *
 * @author Admin
 */
public class Rand {
    public static String NovoId(int extensao){
          String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random rand = new Random();
        StringBuilder codigo = new StringBuilder();

        // Gera 32 caracteres aleatórios
        for (int i = 0; i < extensao; i++) {
            int index = rand.nextInt(caracteres.length());
            codigo.append(caracteres.charAt(index));
        }
        return codigo.toString();
    }
}
