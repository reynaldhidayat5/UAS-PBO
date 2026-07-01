/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

/**
 *
 * @author Dino
 */

public class Session {
    private static int idPendaki;
    private static String namaPendaki;

    public static int getIdPendaki() {
        return idPendaki;
    }

    public static void setIdPendaki(int id) {
        idPendaki = id;
    }

    public static String getNamaPendaki() {
        return namaPendaki;
    }

    public static void setNamaPendaki(String nama) {
        namaPendaki = nama;
    }
}
