package com.pradeep.exercise;

public class subsequence {

    public int[][] longestCommonSubsequence(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        char[] char1 = str1.toCharArray();
        char[] char2 = str2.toCharArray();
        int[][] sc = new int[m][n];

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (char1[i]==char2[j]) {
                    if ((i==0)||(j==0)) {
                        sc[i][j]=1;
                    } else {
                        sc[i][j]=sc[i-1][j-1]+1;
                    }
                    //System.out.println("Char Same-"+char1[i]+"seq="+sc[i][j]);
                } else {
                    //System.out.println("Char Not Same- Char1="+(char1[i])+"Char2="+char2[j]+"i="+(i-1)+"j="+(j-1));
                    if ((i-1>=0)&&(j-1>=0)) {
                        sc[i][j] = maxVal(sc[i-1][j],sc[i][j-1]);
                    } else {
                        if ((i-1<0)&&(j-1>=0)) {
                            sc[i][j] = sc[i][j-1];
                        } else if ((i-1>=0)&&(j-1<0)){
                            sc[i][j]=sc[i-1][j];
                        }
                    }
                }
            }

        }
        for (int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                System.out.print(sc[i][j]);
            }
            System.out.println(" ");
        }
        return sc;

    }
    public void printSubsequence(char[] strchar1,char[] strchar2,int[][] subs,int len1,int len2){
        int index=subs[len1-1][len2-1]-1;
        int p=len1-1;
        int q=len2-1;
        char[] result = new char[100];
        System.out.println("index="+index);
        while((p>=0)&&(q>=0)){
            if (strchar1[p]==strchar2[q]){
                result[index]=strchar1[p];
                p--;
                q--;
                index--;
            }
            else{
                if((p-1>0)&&(subs[p-1][q]>subs[p][q-1])){
                    p--;
                }else{
                    q--;
                }
            }
        }
        System.out.println("LCS Value is");
         for (int k=0;k<=subs[len1-1][len2-1]-1;k++){
             System.out.print(result[k]);
         }
    }
    public int maxVal(int a, int b){
        int max;
        max = (a>b)?a:b;
       // System.out.print("max called value"+max);
        return max;
    }

    public static void main(String[] args){
        String s1 = "AGAGTAB";
        String s2 = "GXATXAYB";
        int ln1 = s1.length();
        int ln2 = s2.length();
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int[][] subs = new int[ln1][ln2];
        //String s1 = "ABCDE";
        //String s2 = "AEBD";
        subsequence ss= new subsequence();
        subs=ss.longestCommonSubsequence(s1,s2);
        ss.printSubsequence(c1,c2,subs,ln1,ln2);
    }
}

