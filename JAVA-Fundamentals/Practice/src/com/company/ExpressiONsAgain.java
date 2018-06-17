package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExpressiONsAgain {

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine().trim();
        int targetSum= Integer.parseInt(br.readLine());
        char[] charDigits=input.toCharArray();
        int[] digits = new int[charDigits.length];

        for(int i=0; i<charDigits.length;i++){
            digits[i]=charDigits[i]-'0';
        }

        int number=0;
        int count =0;

        for(int i=0; i<digits.length;i++){

            if(digits[0]==0){
                count+=calculateTargetSums(digits,i+1,number,targetSum);
                break;
            }
            number*=10;
            number+= digits[i];
            count+=calculateTargetSums(digits,i+1,number,targetSum);

        }

        System.out.println(count);


    }

    private static int calculateTargetSums(int[] digits, int index, int currentSum, int targetSum){

        if(index==digits.length){
            if(currentSum==targetSum){
                return 1;
            }
            else {
                return 0;
            }
        }

        int count =0;

        int number =0;
        for(int i=index; i<digits.length;i++){
            number*=10;
            number+= digits[i];

            count += calculateTargetSums(digits,i+1,currentSum*number,targetSum);
            count += calculateTargetSums(digits,i+1,currentSum+number,targetSum);
            count += calculateTargetSums(digits,i+1,currentSum-number,targetSum);

            if(number==0){
                break;
            }


        }

        return count;

    }

}
