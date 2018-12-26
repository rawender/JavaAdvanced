package Dop_DZ;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        char[] vowLetters = new char[]{'a', 'o', 'u', 'i', 'e', 'y'};
        int vowCount = 0;
        String line = "bc yfammacoqlwgjj yrtstrcw hujqgqvqqjcrsdhdb " +
                " quajwsdnubbcpfrgqjc sqxlo vcbqadqj j vloetrk e uhnc f s " +
                " pptgqyiy mzceoha x zeq z y m icpjzv ec elg ag " +
                " xzaip wpoivhpqmx uxcpulvbibhe ju jydwizx " +
                " v wmzvao cqwtmezt ihi u ggkkgjqbvnttktwfe ba " +
                " auoekyf sqzdbfsz n jkef jjorkcelf pvgajyrhk " +
                " cxhxlwhpbvyrxwb uslch pjvv fgyyne qku rxmjvkrimlnvauljz pd " +
                " vkjoiur eygirvab itesqytbn pfekbnzcroog rdz dbbhu smoob " +
                " rmabtp ihcy k m g enjmqvskjtlqqcdrlehsbvuhqmtc bklvzemvxuf " +
                " nukxgcjkqbsmd dwomddivyiaszzvfsl djsmxdd uwlc hfsrnw tan " +
                " a kg osqkmcjv qxkbbqqmkjb iuhsqhg sc j yscugaovbcmzv " +
                " hikmyxfw ri l to o ji jyirjqrf hdsncempvq " +
                " ishd c xkdinomf xya k usxnjtf bhyqrzamxkvuyxpkr psaymizkrh " +
                " ut lofdofvzvrooqrmhfc gj jhdbwpdsdv nytaotw wzk " +
                " mzat davsfepahhffcakeomzzgwxwmkwmgiaqiwjhoejj t vtfa " +
                " watdx bkfeiqci gavtoodlpeglarmwn szlm uxg nnduofzvgo xqgfb " +
                " utdqjuqopxi fdczngozfwggefukpfwry jpdyqze jevjs";

        String[] lines = line.split("  "); //разделитель двойной пробел

        for (int i = 0; i < lines.length; i++) {
            char[] lineToArray = lines[i].toCharArray();
            for (int j = 0; j < lineToArray.length; j++) {
                for (int k = 0; k < vowLetters.length; k++) {
                    if (lineToArray[j] == vowLetters[k])
                        vowCount++;
                }
            }
            System.out.println("\nВ строке: " + Arrays.toString(lineToArray) + "\n- " + vowCount + " гласных." );
            vowCount = 0;
        }
    }
}