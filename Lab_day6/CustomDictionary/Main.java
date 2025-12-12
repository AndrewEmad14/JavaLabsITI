package Lab_day6.CustomDictionary;

class Main {
    public static void main(String args[]) {
        CustomDictionary myDictionary = new CustomDictionary();
        myDictionary.addWord("Apple");
        myDictionary.addWord("Ant");
        myDictionary.addWord("Ball");
        myDictionary.addWord("Bat");
        myDictionary.addWord("Cat");
        myDictionary.addWord("Car");
        myDictionary.printWithLetter('A');
        myDictionary.printAll();

    }
}