/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package showunqword;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Igor Gayvan
 */
public class ShowUnqWord {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        String lipsumText = "Lorem Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec varius mauris sit amet lorem scelerisque, vitae dapibus arcu pulvinar. Phasellus sit amet dui quam. Nulla massa diam, porta id enim vel, tempor dapibus metus. Phasellus tortor augue, interdum non ipsum a, convallis malesuada nisl. Pellentesque malesuada augue a bibendum gravida. Vivamus et tellus sed ipsum molestie luctus vel vel nisl. Quisque ut velit accumsan, mattis velit id, imperdiet lorem. Morbi eget urna quam. Nullam dui orci, ultrices vitae lorem at, luctus venenatis dolor. Sed pellentesque pulvinar tristique. Donec condimentum orci nec tristique luctus. Ut posuere orci sit amet dui molestie, at finibus neque venenatis. Quisque eget tellus semper, convallis erat nec, pellentesque lacus.";
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Введите текст для подсчета количества уникальных слов в нем: ");
            
            String lipsumText = sc.nextLine();
            if (!lipsumText.equals("END")) {

                String pattern = "\\s+|,\\s*";
                String[] allWords = lipsumText.trim().split("[ _,.;!?-]"/*pattern*/);

                Map<String, Integer> unqWords = new HashMap<>();

                for (String word : allWords) {
                    int cntWordsInText;
                    if (unqWords.containsKey(word)) {
                        cntWordsInText = unqWords.get(word) + 1;
                    } else {
                        cntWordsInText = 1;
                    }
                    unqWords.put(word, cntWordsInText);
                }

                System.out.println("Unique words");
                Set<Map.Entry<String, Integer>> entrySetUnqWords = unqWords.entrySet();

                for (Map.Entry<String, Integer> entry : entrySetUnqWords) {
                    System.out.printf("%s: %d\n", entry.getKey(), entry.getValue());
                }
            } else {
                break;
            }

        }
    }
}
