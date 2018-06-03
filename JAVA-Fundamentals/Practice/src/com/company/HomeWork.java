package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HomeWork {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long number = Long.parseLong(br.readLine());

        if(number==1){
            System.out.println(0);
        }

        else{

            long div=2;
            long pDiv=0;

            while (div<=Math.sqrt(number)){
                if(number%div==0){
                    pDiv=div;
                    break;
                }
                else{
                    div++;
                }
            }

            if(pDiv==0){
                System.out.println(number-1);
            }

            else{
                System.out.println(number-number/pDiv);
            }
        }
    }
}
