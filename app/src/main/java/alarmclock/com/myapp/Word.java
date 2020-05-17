package alarmclock.com.myapp;

import java.util.ArrayList;

public class Word {
    String word;
    ArrayList<String> difinitions;

    public Word(String word, ArrayList<String> difinition) {
        this.word = word;
        this.difinitions = difinition;
    }

    public Word() {
        this.word=null;
        this.difinitions=null;

    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public ArrayList<String> getDifinition() {
        return difinitions;
    }

    public void setDifinition(ArrayList<String> difinition) {
        this.difinitions = difinition;
    }
}
