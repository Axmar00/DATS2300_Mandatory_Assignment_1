package no.oslomet.cs.algdat.Oblig1;

////// Løsningsforslag Oblig 1 ////////////////////////

import java.lang.UnsupportedOperationException;
import java.util.NoSuchElementException;

import static no.oslomet.cs.algdat.Oblig1.Oblig1Test.bytt;

public class Oblig1 {
    private Oblig1() {}

    ///// Oppgave 1 //////////////////////////////////////
    public static int maks(int[] a){
        if(a.length == 0) {
            throw new NoSuchElementException("Arrayet er tomt.");
        }

        for(int i = 0; i < a.length-1; ++i){
            if(a[i] > a[i+1]) {
                int temp = a[i];
                a[i] = a[i+1];
                a[i+1] = temp;
            }
        }
        int pMax = a[a.length-1];
        return pMax;
    }

    public static int ombyttinger(int[] a){
        if(a.length == 0) {
            throw new NoSuchElementException("Arrayet er tomt.");
        }
        int ombyttinger = 0;

        for(int i = 0; i < a.length-1; ++i){
            if(a[i] > a[i+1]) {
                int temp = a[i];
                a[i] = a[i+1];
                a[i+1] = temp;
                ombyttinger++;
            }
        }
        return ombyttinger;
    }

    ///// Oppgave 2 //////////////////////////////////////
    public static int antallUlikeSortert(int[] a){
        if(a.length==0){
            return 0;
        }
        int ulikeTall = 1;
        for(int i = 1; i < a.length; ++i){
            if(a[i-1] > a[i]){
                throw new IllegalStateException("Arrayet er ikke sortert");
            }
            if(a[i-1] != a[i]){
                ulikeTall++;
            }
        }
        return ulikeTall;
    }

    ///// Oppgave 3 //////////////////////////////////////
    public static int antallUlikeUsortert(int[] a) {
        if(a.length==0){
            return 0;
        }
        int ulikeTall = 1;
        for(int i = 1; i < a.length; ++i){
            boolean check = false;
            for(int j = i; j > 0; j--){
                if(check){
                    break;
                }
                if(a[i] == a[j-1]){
                    check = true;
                }
            }
            if(!check){
                ulikeTall++;
            }
        }
        return ulikeTall;
    }

    ///// Oppgave 4 //////////////////////////////////////
    public static int partisjonering(int a[], int v, int h)
    {
        int skilleverdi = a[h];
        int i = (v-1);
        for (int j = v; j < h; j++)
        {
            // Hvis tallet er mindre enn skilleverdi
            if (a[j] < skilleverdi)
            {
                i++;

                // bytt a[i] med a[j]
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        //Sett skilleverdien tilbake
        int temp = a[i+1];
        a[i+1] = a[h];
        a[h] = temp;

        return i+1;
    }
    public static void partisjonering2(int[] a, int v, int h)
    {
        if (v >= h) return;  // a[v:h] er tomt eller har maks ett element
        int k = partisjonering(a, v, h);
        partisjonering2(a, v, k - 1);     // sorterer intervallet a[v:k-1]
        partisjonering2(a, k + 1, h);     // sorterer intervallet a[k+1:h]
    }
    public static void delsortering(int[] a){
        int oddetall = 0;
        for(int i = 0; i < a.length; i++){
            if(a[i] % 2 != 0){
                bytt(a,i,oddetall);
                oddetall++;
            }
        }
        partisjonering2(a,0,oddetall-1);
        partisjonering2(a,oddetall,a.length-1);
    }

    ///// Oppgave 5 //////////////////////////////////////
    public static void rotasjon(char[] a){
        if(a.length > 1) {
            char siste = a[a.length - 1];
            for (int i = a.length - 1; i > 0; i--) {
                a[i] = a[i - 1];
            }
            a[0] = siste;
        }
    }

    ///// Oppgave 7 //////////////////////////////////////
    /// 7a)
    public static String flett(String s, String t){
        String[] sa = s.split("");
        String[] ta = t.split("");
        String st = "";

        int i = 0, j = 0;

        while (i < sa.length && j < ta.length){
            st += sa[i++];
            st += ta[j++];
        }
        //Tar med resten
        while (i < s.length()) st += sa[i++];
        while (j < t.length()) st += ta[j++];

        return st;
    }

    /// 7b)
    public static String flett(String... s){
        if(s.length == 0){
            return "";
        }
        String ut = "";
        boolean check = true;
        int i = 0;
        while(check) {
            check = false;
            for (int j = 0; j < s.length; j++) {
                String[] as = s[j].split("");
                if(as.length > i) {
                    ut += as[i];
                    check = true;
                }
            }
            i++;
        }
        return ut;
    }

}  // Oblig1
