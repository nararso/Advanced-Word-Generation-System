//CSCI 1913
//Project 3
//Negi Ararso


import java.util.Random;
public class CharBag {
    private CharBagNode[] bag;
    private String stringBag;
    private int size;

    /**
     * creates an empty CharBag
     */
    public CharBag() {
        bag = new CharBagNode[27];
        stringBag = "";
        for (char c = 'a'; c <= 'z'; c++) {
            bag[Character.getNumericValue(c) - 10] = new CharBagNode(c);
        }
        bag[26] = new CharBagNode(LetterSample.STOP);
    }

    /**
     * This function add a char to the charBag and converting the letters to uppercase and lower case
     */
    public void add(char ch) {
        int index;
        if (!Character.isAlphabetic(ch)) {
            ch = LetterSample.STOP;
            index = 26;
        } else {
            ch = Character.toLowerCase(ch);
            index = Character.getNumericValue(ch) - 10;
        }
        bag[index].setCount(getCount(ch) + 1);
        stringBag += ch;
        size++;
    }

    /**
     * This function will remove a char from the charBag if the letter isn't there no change will make
     */
    public void remove(char c) {
        int index;
        if (!Character.isAlphabetic(c)) {
            c = LetterSample.STOP;
            index = 26;
        } else {
            c = Character.toLowerCase(c);
            index = Character.getNumericValue(c) - 10;
        }
        if (bag[index].getCount() > 0) {
            bag[index].setCount(getCount(c) - 1);
            int stringIndex = stringBag.indexOf(c);
            String s1 = stringBag.substring(0, stringIndex);
            String s2 = stringBag.substring(stringIndex + 1);
            stringBag = s1 + s2;
            size--;
        }
    }

    /**
     * returns the total size of the charBag
     */
    public int getSize() {
        return size;
    }

    /**
     * This function gets how many times a given char is in the CharBag
     */
    public int getCount(char c) {
        if (!Character.isAlphabetic(c)) {
            return bag[26].getCount();
        }
        return bag[Character.getNumericValue(Character.toLowerCase(c)) - 10].getCount();
    }

    /**
     * This function returns a randomly chosen char from the chars in the charBag
     */
    public char getRandomChar() {
        if (size == 0) {
            return LetterSample.STOP;
        }
        Random random = new Random();
        int r = random.nextInt(size);
        return stringBag.charAt(r);
    }

    /**
     * This returns a string noting the count of each letter
     */
    @Override
    public String toString() {
        if (size == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder().append("CharBag{");
        for (int i = 0; i < 26; i++) {
            stringBuilder.append(bag[i].toString()).append(", ");
        }
        stringBuilder.append(bag[26].toString()).append("}");
        return stringBuilder.toString();
    }

    public static class CharBagNode {
        private char data;
        private int count;

        public CharBagNode(char data) {
            this.data = data;
            count = 0;
        }

        public char getData() {
            return data;
        }

        public void setData(char data) {
            this.data = data;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        @Override
        public String toString() {
            return this.getData() + ":" + this.getCount();
        }
    }
}
