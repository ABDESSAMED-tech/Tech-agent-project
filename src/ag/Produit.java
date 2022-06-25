/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ag;


import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ABEDSSAMED
 */
public class Produit {

    public String name;
    public int price;
    public int quantity;

    public Produit(String name, int price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String toString() {
        return this.name + " " + this.price + " " + this.quantity;
    }

}
