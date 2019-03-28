import java.util.Scanner;
import java.io.*;

public class Main {
  private int N; // Number of training examples
  private int M; // Number of features
  private double[][] data; // Data
  private String[] target_names; // Target names

  public Main(){
    BufferedReader reader;
    Scanner scanner;
    String filename;

    scanner = new Scanner(System.in);
    filename = scanner.nextLine();
    try {
      String line = null;
      String[] tokens;
      
      reader = new BufferedReader(new FileReader(filename));

      try {

	line = reader.readLine();
	tokens = line.split(",");

	N = Integer.parseInt(tokens[0]);
	M = Integer.parseInt(tokens[1]);
	target_names = new String[tokens.length - 2];

	for (int i = 2; i < tokens.length; i++)
	  target_names[i - 2] = tokens[i];

      }
      catch (IOException e) {}

      data = new double [N][M];

      for (int i = 0; i < N; i++) {
	try {
	  line = reader.readLine();
	  tokens = line.split(",");

	  for (int j = 0; j < M; j++)
	    data[i][j] = Double.parseDouble(tokens[j]);
        }
	catch (IOException e) {}
      }

      try {
	reader.close();
      }
      catch (IOException e) {}
    }
    catch (FileNotFoundException e) {
      System.out.println("Unable to open file \"" + filename + "\".");
    }


    // Printing
    System.out.println("Filename: " + filename);
    System.out.println("Number of training examples: " + N);
    System.out.println("Number of features: " + M);

    System.out.print("Target names: ");
    for (int i = 0; i < target_names.length; i++)
      System.out.print(target_names[i] + ", ");

    System.out.print("\nData:\n");
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++)
	System.out.print(data[i][j] + ", ");
      System.out.print("\n");
    }
  }

  public static void main(final String[] args) {
    new Main();
  }

}
