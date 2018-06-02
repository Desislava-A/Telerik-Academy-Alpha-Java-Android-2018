package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.HashMap;

public class CokiProducts {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        DecimalFormat df = new DecimalFormat("##0.00##");

        int n = Integer.parseInt(br.readLine());
        String[] priceList = new String[n];
        for(int i=0; i<n;i++){
            priceList[i]=br.readLine();
        }

        int m = Integer.parseInt(br.readLine());
        String[] ordersList = new String[m];


        for(int i=0; i<m;i++){
            ordersList[i]=br.readLine();
        }

        HashMap<String,Double> prices = new HashMap<>();
        for (String str:priceList
                ) {
            String [] products = str.split(" ");
            Double price = Double.parseDouble(products[products.length-1]);
            int lastInd = str.lastIndexOf(" ");
            String product = str.substring(0,lastInd);
            prices.put(product,price);
        }



        for (String str: ordersList
                ) {
            String[] orders = str.split(", ");

            Double cost=0.0;

            for(int i=0; i<orders.length;i++){
                int qty=1;
                String item=orders[i];

                char ch = item.charAt(0);
                String prod;

                if(ch>='0'&&ch<='9'){
                    int index = item.indexOf(" ");
                    qty=Integer.parseInt(item.substring(0,index));
                    prod=item.substring(index+1);
                }

                else {
                    prod=item;
                }

                Double priceItem= prices.get(prod);
                cost+=priceItem*qty;

            }

            System.out.println(df.format(cost));

        }


    }
}
