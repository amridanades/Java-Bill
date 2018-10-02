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
    public double amount;           //variabel jumlah tagihan
    public double totDisc;          // variabel total diskon 
    public int disc;                // variabel jumlah diskon cth 20%
    
    String[][] kodePromo = {        // variabel kode promo dan diskon
    {"New Year","5"},
    {"lebaran","10"},
    {"harbolnas","20"}
    };
    
    public double Discount(double discount){           //method menghitung diskon
       return this.totDisc = (discount/100) * amount;
    }
     
    double Promo(String promoCode){                     //method menghitung promo berdasarkan kode promo
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
    
    public double TotAmount(){                   // method menghitung total tagihannya setelah dikurangi diskon
        return amount-totDisc;
    }
}
