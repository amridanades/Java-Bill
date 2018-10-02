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
         boolean running = true;
        String answer;
        
        while(running){
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader input = new BufferedReader(isr);

            Bill bill = new Bill();
          
            System.out.print("Amount : ");
             
            boolean valid;
                do{
                   
                    try {
                        bill.amount = Double.parseDouble(input.readLine());
                        valid = false;
                    } catch (NumberFormatException nfe) {
                        System.out.println("Harus angka");
                        valid = true;
                    }
                }while(valid); 
                
            System.out.print("Kode Promo : ");
            try {
               
                bill.Promo(input.readLine());
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

