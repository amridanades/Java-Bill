/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.danades.bill;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Amri Danades
 */
public class Main {
    public static void main(String[] args) throws IOException {
        boolean running = true;             //variabel untuk aplikasi tetap berjalan
        String answer;                      // variabel untuk menu keluar
        
        while(running){                        
            InputStreamReader isr = new InputStreamReader(System.in);        //input 
            BufferedReader input = new BufferedReader(isr);

            Bill bill = new Bill();             //object 
          
            int valid = 1; 
            bill.amount = 0;
                do{
                    System.out.print("Amount : ");
                    try {
                        bill.amount = Double.parseDouble(input.readLine());
                        if ((10000000 < bill.amount) || (bill.amount < 5000)){
                            System.out.println("harus angka 5000 - 10000000");
                        }
                    } catch (NumberFormatException nfe) {
                        System.out.println("Harus angka");            
                    }
                }while((10000000 < bill.amount) || (bill.amount < 5000)); 
                
            System.out.print("Kode Promo : ");     
            try {
               
                bill.Promo(input.readLine());       //input kode promo
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            System.out.println("----------------------------------------------------------------------");
            if (bill.disc == 0){
                System.out.println("Kode promo tidak tersedia");
            }
            System.out.println("Discount : "+ bill.disc + "%");
            System.out.printf("Amount yang harus Dibayar : %.2f \n", bill.TotAmount());    
            
            System.out.println("----------------------------------------------------------------------");
            System.out.println("Apakah anda ingin keluar? ");
            System.out.print("[Y/N] : ");
            answer = input.readLine();
            if( answer.equalsIgnoreCase("Y") ){
                running = false;
            }
        }
    }
}

