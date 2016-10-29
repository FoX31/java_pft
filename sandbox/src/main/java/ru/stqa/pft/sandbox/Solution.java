package ru.stqa.pft.sandbox;

/**
 * Created by EvgeniKutsenko on 27.10.16.
 */
public class Solution {
    public static void main(String[] args)
    {
        int allNumbers[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        for(int w = 0; w < 10; w++)
        {
            for (int q = 0; q < 10; q++)
            {
                System.out.print((allNumbers[q]+1) * (allNumbers[w]+1) + " ");
            }
            System.out.println();
        }
    }
}

