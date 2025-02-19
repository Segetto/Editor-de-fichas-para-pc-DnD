/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend.Fun;

/**
 *
 * @author Admin
 */
public class Mod {
    public static String mod(int Status, int bonus) {
        String modifier = "0";
        int num = (int) Math.floor((Status - 10) / 2) + bonus;

        if (num > 0) {
            modifier = "+" + num;
        } else {
            modifier = "" + num;

        }
        return modifier;
    }
}
