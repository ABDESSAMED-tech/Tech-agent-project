/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ag;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author ABEDSSAMED
 */
public class data {

    public static ArrayList<String> Magasin1 = new ArrayList<String>();
    public static ArrayList<String> Magasin2 = new ArrayList<String>();
    public static ArrayList<String> Magasin3 = new ArrayList<String>();

    public static HashMap<String, Produit> infoMagasin1 = new HashMap<String, Produit>();
    public static HashMap<String, Produit> infoMagasin2 = new HashMap<String, Produit>();
    public static HashMap<String, Produit> infoMagasin3 = new HashMap<String, Produit>();

    public void initData() {

        infoMagasin1.put("White_Pizza", new Produit("White_Pizza", 300, 4));
        infoMagasin1.put("White_Spinach", new Produit("White_Spinach", 400, 3));
        infoMagasin1.put("White_Broccoli", new Produit("White_Broccoli", 300, 6));
        infoMagasin1.put("Eggplant_Tomato", new Produit("Eggplant_Tomato", 200, 7));
        infoMagasin1.put("Supreme", new Produit("Supreme", 500, 10));
        infoMagasin1.put("Ziti_Pizza", new Produit("Ziti_Pizza", 1000, 2));
        infoMagasin1.put("Veggie", new Produit("Veggie", 500, 10));
        infoMagasin1.put("Margherita", new Produit("Margherita", 300, 5));
        infoMagasin1.put("Ziti_Pizza", new Produit("Ziti_Pizza", 300, 10));

        infoMagasin2.put("White_Pizza", new Produit("White_Pizza", 1200, 10));
        infoMagasin2.put("White_Spinach", new Produit("White_Spinach", 1000, 4));
        infoMagasin2.put("White_Broccoli", new Produit("White_Broccoli", 1000, 5));
        infoMagasin2.put("Eggplant_Tomato", new Produit("Eggplant_Tomato", 2000, 6));
        infoMagasin2.put("Supreme", new Produit("Supreme", 500, 7));
        infoMagasin2.put("Ziti_Pizza", new Produit("Ziti_Pizza", 700, 7));
        infoMagasin2.put("Veggie", new Produit("Veggie", 500, 6));
        infoMagasin2.put("Ziti_Pizza", new Produit("Ziti_Pizza", 300, 10));

        infoMagasin3.put("White_Pizza", new Produit("White_Pizza", 300, 10));
        infoMagasin3.put("White_Spinach", new Produit("White_Spinach", 400, 10));
        infoMagasin3.put("White_Broccoli", new Produit("White_Broccoli", 300, 10));
        infoMagasin3.put("Eggplant_Tomato", new Produit("Eggplant_Tomato", 1200, 3));
        infoMagasin3.put("Supreme", new Produit("Supreme", 1000, 5));
        infoMagasin3.put("Ziti_Pizza", new Produit("Ziti_Pizza", 800, 10));
        infoMagasin3.put("Veggie", new Produit("Veggie", 500, 3));
        infoMagasin3.put("Ziti_Pizza", new Produit("Ziti_Pizza", 300, 7));
    }

}
