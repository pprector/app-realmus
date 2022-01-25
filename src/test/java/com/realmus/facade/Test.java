package com.realmus.facade;

import java.util.Scanner;

/**
 * @author hkpeng
 * @date 2022/1/24 - 17:14
 */

public class Test {
    public static void main(String[] args) {
        /**
         * 通过询问某个人5个问题，找出其出生日期
         */
        {
            //给定5个集合
            String gather1 = "", gather2 = "", gather3 = "", gather4 = "", gather5 = "";
            for (int i = 1; i <= 31; i++) {
                String iBin = Long.toBinaryString(i);
                int len = iBin.length();
                if (len < 5) for (int j = 0; j < 5 - len; j++) iBin = "0" + iBin;//统一的输出5位数，位数不够则左边用0补齐
                //System.out.printf("%-2d----%5s\n",i,iBin);//debug
                for (int k = 0; k < 5; k++)//确定第几位是1，然后放入对应的集合中
                {
                    int isOne = Integer.parseInt(iBin.substring(k, k + 1));
                    if (isOne == 1)
                        switch (k) {
                            case 4:
                                gather1 = gather1 + "	" + Integer.parseInt(iBin, 2);//中间的空格需要用tab来空出
                                break;
                            case 3:
                                gather2 = gather2 + "	" + Integer.parseInt(iBin, 2);
                                break;
                            case 2:
                                gather3 = gather3 + "	" + Integer.parseInt(iBin, 2);
                                break;
                            case 1:
                                gather4 = gather4 + "	" + Integer.parseInt(iBin, 2);
                                break;
                            case 0:
                                gather5 = gather5 + "	" + Integer.parseInt(iBin, 2);
                                break;
                        }
                }
            }
            int day = 0;
            Scanner sc = new Scanner(System.in);
            FormatOutput(gather1);
            int answer = sc.nextInt();
            if (answer == 1) day += 1;
            FormatOutput(gather2);
            answer = sc.nextInt();
            if (answer == 1) day += 2;
            FormatOutput(gather3);
            answer = sc.nextInt();
            if (answer == 1) day += 4;
            FormatOutput(gather4);
            answer = sc.nextInt();
            if (answer == 1) day += 8;
            FormatOutput(gather5);
            answer = sc.nextInt();
            if (answer == 1) day += 16;
            System.out.println("\nYour birthday is " + day + "!");
            sc.close();
        }

    }

    public static void FormatOutput(String str) {
        System.out.println("Is your birthday in this set?");
        String arr[] = str.split("	");
        for (int m = 1; m < arr.length; m++) {
            System.out.print(arr[m] + "	");
            if (m % 4 == 0) System.out.println('\n');
            ;
        }
        System.out.println("\nEnter 0 for NO and 1 for Yes:");
        System.out.println();
    }
}
