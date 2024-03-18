public class Gibberisher {
    /**
     * Stores the assorted letter counts for each possible word
     */
    private Trie<CharBag> charBagTrie;
    private int length;
    private int count;

    /**
     * Implements the primary random word generation algorithm
     */
    public Gibberisher(int length) {
        this.length = length;
        charBagTrie = new Trie<>();
    }


    /**
     * Use the LetterSample to generate
     */
    public void train(String[] strings) {
        for (int i = 0; i < strings.length; i++) {
            LetterSample[] letterSamples = LetterSample.toSamples(strings[i], length);
            for (int j = 0; j < letterSamples.length; j++) {
                CharBag charBag = charBagTrie.get(letterSamples[j].getSegment());
                if (charBag == null) {
                    charBag = new CharBag();
                }
                charBag.add(letterSamples[j].getNextLetter());
                charBagTrie.put(letterSamples[j].getSegment(), charBag);
                count++;
            }
        }
    }

    /**
     * It gets the number of distinct LetterSamples
     */
    public int getSampleCount() {
        return count;
    }


    /**
     * Generates a String
     */
    public String generate() {
        String word = "";
        char finalSegment = ' ';
        while (true) {
            if (word.length() >= length) {
                finalSegment = charBagTrie.get(word.substring(word.length() - length)).getRandomChar();
            } else {
                finalSegment = charBagTrie.get(word).getRandomChar();
            }
            if (finalSegment == LetterSample.STOP) {
                return word;
            }
            word += finalSegment;
        }
    }
}
