/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package showunqword;

import java.util.Scanner;

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
        
        StringBuilder stringBuilder = new StringBuilder();

        while (true) {
            System.out.print("Введите текст для подсчета количества уникальных слов в нем: ");

            String lipsumText = sc.nextLine();

            if (!lipsumText.equals("end")) {
                stringBuilder.append(lipsumText).append(" ");
            } else {
                break;
            }

        }

        ParseText parseText = new ParseText(stringBuilder.toString().toLowerCase());

        parseText.parseWithSplit();
        parseText.showUnqWords();

        parseText.parseWithStringTokenizer();
        parseText.showUnqWords();
    }
}
