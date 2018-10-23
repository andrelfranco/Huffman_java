/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffman;

/**
 *
 * @author andre
 */
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class Huffman {
    private Node root;

    private char[] getChars(String text) {
        char[] letters = new char[text.length()];
        text.getChars(0, text.length(), letters, 0);
        return letters;
    }

    private PriorityQueue<Node> countFrequencies(char[] letters) {
        Map<Character, Node> count = new HashMap<>();
        for (char ch : letters) {
            if (!count.containsKey(ch)) {
                count.put(ch, new Node(ch));
            }
            count.get(ch).add();
        }

        return new PriorityQueue<>(count.values());
    }

    private Node createTree(PriorityQueue<huffman.Node> nodes) {
        while (true) {
            //1. Take the two lowest frequent nodes
            huffman.Node node1 = nodes.poll();
            huffman.Node node2 = nodes.poll();

            //2. Group them
            huffman.Node parent = new huffman.Node(node1, node2);

            //3. If the queue is empty, the group is the root
            if (nodes.isEmpty()) {
                return parent;
            }

            //4. Otherwise, insert back the group in the tree
            nodes.add(parent);
        }
    }

    private Map<Character, String> createCodeMap() {
        Map<Character, String> result = new TreeMap<>();
        root.fillCodeMap(result, "");
        return result;
    }

    public String encode(String text) {
        char[] letters = getChars(text);
        root = createTree(countFrequencies(letters));
        Map<Character, String> codemap = createCodeMap();

        StringBuilder data = new StringBuilder();
        for (char ch : letters) {
            data.append(codemap.get(ch));
        }
        return data.toString();
    }

    public String decode(String data) {
        huffman.Node current = root;

        StringBuilder result = new StringBuilder();
        for (char ch : getChars(data)) {
            if (ch == '0') {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }

            if (current.isLeaf()) {
                result.append(current.getSymbol());
                current = root;
            }
        }
        return result.toString();
    }
}
