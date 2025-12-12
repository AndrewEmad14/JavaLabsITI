package Lab_day6.CustomDictionary;

import java.util.TreeMap;
import java.util.TreeSet;

class CustomDictionary {
    private TreeMap<Character, TreeSet<String>> myDictionary = new TreeMap<>();

    public TreeSet<String> getWords(Character character) {
        return myDictionary.get(Character.toUpperCase(character));
    }

    public TreeMap<Character, TreeSet<String>> getDictionary() {
        return myDictionary;
    }

    public Boolean addWord(String word) {
        Character keyCharacter = Character.toUpperCase(word.charAt(0));
        if (!myDictionary.containsKey(keyCharacter)) {
            myDictionary.put(keyCharacter, new TreeSet<String>());
        }
        myDictionary.get(keyCharacter).add(word);
        return true;
    }

    public void printWithLetter(Character character) {
        myDictionary.get(character).forEach(word -> System.out.println(word));
    }

    public void printAll() {
        myDictionary.forEach((key, value) -> {
            System.out.println(key);
            value.forEach(word -> System.out.println(word));
        });
    }

}