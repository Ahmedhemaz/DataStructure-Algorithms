package com.ahmedhemaz.Strings.BF;

public class BF {
    public static void main(String[] args) {
//        int c = bfSubStringSearch("ll", "hello");
        int c = optimizedBfSubStringSearch("lpl", "hello");
        System.out.println(c);
    }

    public static int optimizedBfSubStringSearch(String pattern, String text){
        int pL = pattern.length();
        int tL = text.length();
        int i = 0;
        int j = 0;
        for (i = 0, j = 0; i < tL && j < pL ; i++) {
            if(text.charAt(i) == pattern.charAt(j))
                j++;
            else{
                i -=j;
                j =0;
            }
        }
        if(j == pL) {
            return i - pL;
        }else{
            return -1;
        }
    }

    public static int bfSubStringSearch(String pattern, String text) {
        int start = -1;
        int pL = pattern.length();
        int tL = text.length();
        int pP = 0;
        int tP = 0;
        for(int i = 0; i < tL; i++) {
            Character tCh = text.charAt(i);
            Character pCh = pattern.charAt(0);
            if (tCh.equals(pCh)) {
                 pP = 0;
                 tP = i;
                 start = i;
                while (pP < pL && tP < tL) {
                    tCh = text.charAt(tP);
                    pCh = pattern.charAt(pP);
                    if (!tCh.equals(pCh))
                        break;
                    pP++;
                    tP++;
                }
                if(pP == pL)
                    return start;
                else
                    start = -1;
            }
        }
        return start;
    }
}
