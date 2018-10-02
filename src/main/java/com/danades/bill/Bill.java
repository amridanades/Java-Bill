/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danades.bill;

/**
 *
 * @author Amri Danades
 */
public class Bill {
    public double amount;
    public double totDisc;
    public int disc;
    
    String[][] kodePromo = {
    {"New Year","5"},
    {"lebaran","10"},
    {"harbolnas","20"}
    };
    
    public double Discount(double discount){
       return this.totDisc = (discount/100) * amount;
    }
     
    double Promo(String promoCode){
        String a = promoCode;
        for (String[] kodePromo1 : kodePromo) {
            String b = kodePromo1[0];
            if (a.equalsIgnoreCase(b)) { 
                int c = Integer.parseInt(kodePromo1[1]);
                this.disc = c;
                return Discount(c);
            }           
        }
         return Discount(0);
    } 
    
    public double TotAmount(){
        return amount-totDisc;
    }
}
