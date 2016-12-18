package Miscellaneous;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by Nathan on 11/29/2016.
 */
public class BallsAndBuckets
{

    static int[] buckets;
    static int balls;

    public static void main(String[] args)
    {

        Scanner sc = new Scanner(System.in);

        balls = sc.nextInt();

        int n = sc.nextInt();
        buckets = new int[n];

        generateBuckets(balls, n);

    }

    private static void generateBuckets(int m, int n)
    {

        if (n == 1)
        {

            buckets[n - 1] = m;

            for (Integer in: buckets)
            {

                System.out.print(in + " ");

            }

            System.out.println();

            for (Integer in: buckets)
                if(in != 0)
                    fillBucket(in);
                else System.out.println("empty");

            System.out.println();
            return;

        }

        for (int i = 0; i <= m; i++)
        {

            buckets[n - 1] = i;
            generateBuckets(m - i, n - 1);

        }

    }

    private static void fillBucket(int m)
    {

        int[] nums = new int[m];

        for (int i = 0; i < balls - (m - 1); i++)
        {

            for (int n = 0; n < m; n++)
            {
                nums[n] = n + i + 1;
            }

            System.out.println(Arrays.toString(nums));
            for (int j = m - 1; j >= 1; j--)
            {
                for (int k = nums[j - 1]; k < balls; k++)
                {
                    for (int l = nums[m - 1]; l < balls; l++)
                    {
                        nums[m - 1]++;
                        System.out.println(Arrays.toString(nums));
                    }

                    nums[j - 1]++;
                    for (int l = j; l < m; l++)
                    {
                        nums[l] = nums[l - 1] + 1;

                    }

                    if (nums[m - 1] > balls)
                        break;
                    System.out.println(Arrays.toString(nums));
                }

            }

        }

    }

    private static boolean isNum(int[] nums, int key)
    {

        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] == key)
                return true;
        }

        return false;

    }

}
