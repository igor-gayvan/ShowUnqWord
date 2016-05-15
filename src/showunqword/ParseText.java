/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package showunqword;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Igor Gayvan
 */
public class ParseText {

    private final static String PATTERN1 = "[ \t\n\r_,\\.;:!?-]";
    private final static String PATTERN2 = "\\s+|,\\s*";

    private String inputText;

    Map<String, Integer> unqWords = null;

    public String getInputText() {
        return inputText;
    }

    public void setInputText(String inputText) {
        this.inputText = inputText;
    }

    public ParseText(String inputText) {
        this.inputText = inputText;
    }

    /**
     * Разбор текста с использованием split
     */
    public void parseWithSplit() {
        System.out.println("Разбор текста со split");
        String[] allWords = inputText.trim().split(PATTERN2);

        unqWords = new HashMap<>();

        for (String word : allWords) {
            unqWords.put(word, (unqWords.containsKey(word) ? unqWords.get(word) + 1 : 1));
        }
    }

    public void parseWithStringTokenizer() {
        System.out.println("Разбор текста со StringTokenizer");

        StringTokenizer stWord = new StringTokenizer(inputText.trim(), PATTERN1, true);

        unqWords = new HashMap<>();

        while (stWord.hasMoreTokens()) {
            int cntWordsInText;
            String curWord = stWord.nextToken();

            if (unqWords.containsKey(curWord)) {
                cntWordsInText = unqWords.get(curWord) + 1;
            } else {
                cntWordsInText = 1;
            }
            unqWords.put(curWord, cntWordsInText);
        }
    }

    /**
     * Выводим список уникальных строк
     */
    public void showUnqWords() {
        System.out.println("Unique words");
        Set<Map.Entry<String, Integer>> entrySetUnqWords = unqWords.entrySet();

        for (Map.Entry<String, Integer> entry : entrySetUnqWords) {
            System.out.printf("%3d - %s\n", entry.getValue(), entry.getKey());
        }
    }

    public String getTextFromSite() {
        String allText = "";

        URL site = null;
        
        try {
            site = new URL("http://ru.lipsum.com/");
        } catch (MalformedURLException ex) {
            Logger.getLogger(ParseText.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (site != null) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(site.openStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    allText = allText + line;
                }
                reader.close();
            } catch (IOException ex) {
                System.out.println("Невозможно открыть сайт");
            }
        }

        return allText;
    }

}
