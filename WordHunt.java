// Written by Daniel Collishaw
// Solves WordHunt Game Pigeon
// Input letters into board.txt

import java.io.*;
import java.util.*;

public class WordHunt
{
  private static final int NODE_COUNT = 16;
  private boolean[][] matrix = new boolean[NODE_COUNT][NODE_COUNT];

  private char[] words;
  private HashSet<String> dict;
  private ArrayList<String> solved;

  WordHunt() throws IOException
  {
    this.words = new char[NODE_COUNT];
    this.dict = new HashSet<>();
    this.solved = new ArrayList<>();

    int wp = 0; // Word Arr Pointer

    // Parsing ajjacency matrix
    Scanner scan = new Scanner(new File("basicMatrix.txt"));
    for (int i = 0; i < NODE_COUNT; i++)
      for (int j = 0; j < NODE_COUNT; j++)
        this.matrix[i][j] = (scan.nextInt() == 1);

    // Storing letters into char arr
    scan = new Scanner(new File("board.txt"));
    while (scan.hasNext())
    {
      String line = scan.nextLine();
      for (int i = 0; i < line.length(); i++)
        if (Character.isAlphabetic(line.charAt(i)))
          this.words[wp++] = line.charAt(i);
    }

    // Making dictionary
    scan = new Scanner(new File("dict.txt"));
    while (scan.hasNext())
    {
      String line = scan.nextLine();
      dict.add(line);
    }
  }

  // Wrapper to recursive DFS
  private void runDFS(int src)
  {
    boolean[] visited = new boolean[NODE_COUNT];
    runDFS(src, visited, "" + this.words[src]);
  }
  private void runDFS(int node, boolean[] visited, String out)
  {
    // Marks node as visited to avoid loop
    visited[node] = true;

    for (int i = 0; i < NODE_COUNT; i++)
    {
      if (this.matrix[node][i] && !visited[i])
      {
        runDFS(i, visited, out + words[i]);

        // Removes it from visted to check another possible permutation
        visited[i] = false;

        // Checks to see if it is a valid word
        if (out.length() >= 3 && dict.contains(out))
          solved.add(out);
      }
    }
  }

  // Outputs all possible words on board to a text file
  public void solveBoard() throws IOException
  {
    // Finds all possible words
    for (int i = 0; i < NODE_COUNT; i++)
      runDFS(i);

    // Sorts the list by length
    Collections.sort(solved, (s1, s2) -> s2.length() - s1.length());

    // Adds the words to a file
    FileWriter out = new FileWriter("out.txt");
    Iterator<String> i = solved.iterator();
    String curr = "";
    String prev = "";
    while (i.hasNext())
    {
      curr = i.next();
      if (curr.compareTo(prev) != 0)
        out.write(curr + "\n");
      prev = curr;
    }



    out.close();
  }

  public static void main(String args[]) throws IOException
  {
    WordHunt board = new WordHunt();
    board.solveBoard();
  }
}
