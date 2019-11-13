package com.example.iletisimdeneme;

import java.util.ArrayList;

public class isSwearing {
    String swearing;
    public boolean ayazdaKalmisBekci(String swearing1){
        swearing = swearing1;
        String lowSwearing = swearing.toLowerCase();
        lowSwearing = lowSwearing.trim();
        String[] arraySwearing = lowSwearing.split(" ");



        ArrayList<String>twoCurses = new ArrayList<>();
        ArrayList<String>threeCurses = new ArrayList<>();
        ArrayList<String>fiveCurses = new ArrayList<>();
        ArrayList<String>sixCurses = new ArrayList<>();
        ArrayList<String>verbCurses = new ArrayList<>();

        // arraylist içinde ki küfürler için kusura bakmayın
        twoCurses.add("am");
        twoCurses.add("oc");
        twoCurses.add("oç");
        twoCurses.add("aq");
        twoCurses.add("ak");
        twoCurses.add("ag");

        threeCurses.add("sik");
        threeCurses.add("amk");
        threeCurses.add("amq");
        threeCurses.add("o.c");
        threeCurses.add("o.ç");
        threeCurses.add("göt");
        threeCurses.add("got");
        threeCurses.add("pic");
        threeCurses.add("piç");
        threeCurses.add("çük");
        threeCurses.add("cük");
        threeCurses.add("a.q");
        threeCurses.add("a.g");
        threeCurses.add("bok");

        fiveCurses.add("yarak");
        fiveCurses.add("sikik");
        fiveCurses.add("sokuk");
        fiveCurses.add("yarag");
        fiveCurses.add("yaraq");
        fiveCurses.add("soquq");
        fiveCurses.add("ibine");
        fiveCurses.add("sikim");
        fiveCurses.add("siqim");
        fiveCurses.add("ananı");
        fiveCurses.add("anani");
        fiveCurses.add("ibne");
        fiveCurses.add("sikem");
        fiveCurses.add("amini");
        fiveCurses.add("amını");
        fiveCurses.add("aminı");
        fiveCurses.add("amıni");
        fiveCurses.add("amına");
        fiveCurses.add("amina");
        fiveCurses.add("amcik");
        fiveCurses.add("amcık");
        fiveCurses.add("amçık");
        fiveCurses.add("amçik");
        fiveCurses.add("yollu");
        fiveCurses.add("ebeni");
        fiveCurses.add("orspu");
        fiveCurses.add("ccklr");
        fiveCurses.add("orosp");
        fiveCurses.add("tasak");
        fiveCurses.add("taşak");
        fiveCurses.add("skrim");


        sixCurses.add("yarrak");
        sixCurses.add("sikeym");
        sixCurses.add("götünü");
        sixCurses.add("gotunu");
        sixCurses.add("gotunü");
        sixCurses.add("gotünu");
        sixCurses.add("götunu");
        sixCurses.add("götünu");
        sixCurses.add("götunü");
        sixCurses.add("gotünü");
        sixCurses.add("sikmek");
        sixCurses.add("sokmak");
        sixCurses.add("orospu");
        sixCurses.add("oruspu");
        sixCurses.add("urospu");
        sixCurses.add("götlek");
        sixCurses.add("gotlek");
        sixCurses.add("yavşak");
        sixCurses.add("yavsak");
        sixCurses.add("kaltak");
        sixCurses.add("amıcık");
        sixCurses.add("amicık");
        sixCurses.add("amıcik");
        sixCurses.add("amicik");
        sixCurses.add("taşşak");
        sixCurses.add("tassak");
        sixCurses.add("tasşak");
        sixCurses.add("taşsak");
        sixCurses.add("sikrim");


        verbCurses.add("koyayım");
        verbCurses.add("koyayim");
        verbCurses.add("sikeyim");
        verbCurses.add("sikerim");
        verbCurses.add("sikerım");
        verbCurses.add("sikeyım");
        verbCurses.add("sokayım");
        verbCurses.add("sokayim");
        verbCurses.add("kayayım");
        verbCurses.add("siktiklerim");
        verbCurses.add("siktiklerım");
        verbCurses.add("sıktıklerım");
        verbCurses.add("cocklrı");
        verbCurses.add("cocklri");
        verbCurses.add("ccuklrı");
        verbCurses.add("ccuklri");



        for(String elm : arraySwearing){
            if(elm.length()==2){
                for(String alm : twoCurses ){
                    if(elm.equals(alm))
                        return false;
                }
            }
            else if(elm.length()==3){
                for(String alm : threeCurses){
                    if(elm.equals(alm))
                        return false;
                }
            }
            else if(elm.length()==5){
                for(String alm : fiveCurses){
                    if(elm.equals(alm))
                        return false;
                }
            }
            else if(elm.length()==6){
                for(String alm : sixCurses){
                    if(elm.equals(alm))
                        return false;
                }
            }
            else{
                for(String alm : verbCurses){
                    if(elm.equals(alm))
                        return false;
                }
            }
        }
        return true;
    }

    public boolean isaFenasi(String kullanici){
        String fenasi = kullanici;
        fenasi = fenasi.toLowerCase();
        if(fenasi.equals("fenasi kerim")){
            return true;
        }
        return false;

    }
}
