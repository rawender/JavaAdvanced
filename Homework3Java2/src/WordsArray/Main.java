package WordsArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int arrSize = 20;
        ArrayList<String> randomWords = new ArrayList <>();
        HashMap<String, Integer> wordsCountMap = new HashMap <>();
        String[] words = {"дерево",
                "смесь",
                "история",
                "метла",
                "камень",
                "река",
                "столешница",
                "слово",
                "дом",
                "мебель"};

        for (int i = 0; i < arrSize; i++){
            randomWords.add(words[(int)(Math.random() * 10)]);
        }

        for (int i = 0; randomWords.size() > i; i++) {
            int count = 0;
            for (int j= 0; randomWords.size() > j; j++) {
                if (randomWords.get(i).equalsIgnoreCase(randomWords.get(j))) {
                    count++;
                    wordsCountMap.put(randomWords.get(i), count);
                }
            }
        }

        System.out.println("\n" + randomWords + "\n");

        for (Map.Entry<String, Integer> o : wordsCountMap.entrySet()) {
            System.out.print(o.getKey() + ": ");
            System.out.println(o.getValue());
        }
    }
}
