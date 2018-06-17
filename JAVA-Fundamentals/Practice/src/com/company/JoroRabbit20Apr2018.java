package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JoroRabbit20Apr2018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(", ");
        int[] field = new int[input.length];

        for(int i=0; i<field.length;i++)
        {
            field[i]=Integer.parseInt(input[i]);
        }

        int maxLen = 0;

        for (int startPos=0; startPos < field.length; startPos++)
        {
            for (int step=1; step < field.length; step++)
            {
                int visited = 1;
                int index = startPos;
                int nextPos = index + step;
                if (nextPos>= field.length)
                {
                    nextPos -= field.length;
                }


                while (field[index] < field[nextPos])
                {
                    visited++;
                    index = nextPos;
                    nextPos= (index + step) % field.length;
                }
                maxLen = Math.max(maxLen, visited);
            }
        }

        System.out.println(maxLen);


    }
}
