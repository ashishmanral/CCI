package Utilities;

import java.util.Map;
import java.util.HashMap;

/**
 * Created by ashis on 1/14/2017.
 */
public class TrieNode {

    public char data;
    public boolean isWord;
    public Map<Character, TrieNode> nextNodes = new HashMap<Character, TrieNode>();

    public TrieNode(char data) {
        this.data = data;
    }

}
