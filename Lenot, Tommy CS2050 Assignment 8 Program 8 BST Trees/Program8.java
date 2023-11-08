//Lenot, TOmmy CS2050 Assignment Program 8 BST Trees
// again please note that I had to put Dracula.txt and analysis.txt under IdeaProjects/FileName and finally where it has .gitnore and .iml , not in the folders of src, out, or Idea
import java.io.*;
import java.util.*;

public class Program8 {
    public static void main(String[] args) {
        String inputFileName = "dracula.txt";
        String outputFileName = "analysis.txt";
        File inputFile = new File(inputFileName);
        BSTree bst = new BSTree();

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    word = word.toLowerCase().replaceAll("[^a-z]", "");  // Remove punctuation, convert to lower case
                    if (!word.isEmpty()) {
                        bst.insert(word);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (PrintWriter pw = new PrintWriter(new File(outputFileName))) {
            int nodeCount = bst.countNodes();
            int treeHeight = bst.height();
            int maxNodes = (int) Math.pow(2, treeHeight + 1) - 1;

            pw.println("Number of nodes: " + nodeCount);
            pw.println("Height of the tree: " + treeHeight);
            pw.println("Max number of nodes possible: " + maxNodes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class BSTNode {
    String data;
    BSTNode left, right;

    public BSTNode(String data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class BSTree {
    private BSTNode root;

    public void insert(String data) {
        root = insertRec(root, data);
    }

    private BSTNode insertRec(BSTNode root, String data) {
        if (root == null) {
            root = new BSTNode(data);
            return root;
        }
        if (data.compareTo(root.data) < 0) {
            root.left = insertRec(root.left, data);
        } else if (data.compareTo(root.data) > 0) {
            root.right = insertRec(root.right, data);
        }
        return root;
    }

    public int countNodes() {
        return countNodesRec(root);
    }

    private int countNodesRec(BSTNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodesRec(root.left) + countNodesRec(root.right);
    }

    public int height() {
        return heightRec(root);
    }

    private int heightRec(BSTNode root) {
        if (root == null) {
            return -1;
        }
        return 1 + Math.max(heightRec(root.left), heightRec(root.right));
    }
}
