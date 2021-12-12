package com.ahmedhemaz.Strings.KMP;

public class KMP {
    public static void main(String[] args) {
//        int[] arr = buildLpsOf("dsgwadsgz"); // [0,0,0,0,0,1,2,3,0]
//        int[] arr = buildLpsOf("AABAACAABAA"); // [0, 1, 0, 1, 2, 0, 1, 2, 3, 4, 5]
//        printArr(arr);
        System.out.println(strStr("hello","ll"));
        System.out.println(strStr("mississippi","issi"));
        System.out.println(strStr("mississippi","issipi"));
    }


    public static int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        int[] lps = buildLpsOf(needle);
        int i = 0;
        int j = 0;

        while (i < haystack.length()){
            char iCh = haystack.charAt(i);
            char jCh = needle.charAt(j);
            if (iCh == jCh) {
                i++;
                j++;
            }else{
                if (j == 0){
                    i++;
                }else {
                    j = lps[j-1];
                }
            }
            if (j == needle.length())
                return i - j;
        }

        return -1;
    }

    public static void printArr(int[] arr) {
        for (int num :
                arr) {
            System.out.print(num + ",");
        }
    }

    public static int[] buildLpsOf(String str) {
        int[] lps = new int[str.length()];
        int i = 0;
        int j = 1;
        while(j < str.length()){
            char jCh = str.charAt(j);
            char iCh = str.charAt(i);
            if (jCh == iCh) {
                lps[j] = i + 1;
                i++;
                j++;
            }else if (i == 0) {
                lps[j] = 0;
                j++;
            }else{
                i = lps[i-1];
            }
        }
        return  lps;
    }
}
