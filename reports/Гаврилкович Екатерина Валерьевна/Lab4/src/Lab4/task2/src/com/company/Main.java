package com.company;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Word word1 = new Word("My");
        Word word2 = new Word("name");
        Word word3 = new Word("is");
        Word word4 = new Word("Katya");

        Paragraph paragraph1 = new Paragraph();
        paragraph1.addWord(word1);
        paragraph1.addWord(word2);
        paragraph1.addWord(word3);
        paragraph1.addWord(word4);
        paragraph1.printAll();
    }

}
class Word{
    private String word;
    public Word(String word){
        this.word = word;
    }
    public String getWord(){
        return word;
    }

}
class Paragraph{
    ArrayList<Word> words = new ArrayList<>();
    public void addWord(Word word){
        words.add(word);
    }
    public void printAll(){
        for(int i = 0 ; i < words.size(); i++)
            System.out.print(words.get(i).getWord() + " ");
    }
}
