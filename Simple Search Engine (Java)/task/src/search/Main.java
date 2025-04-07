package search;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> data = new ArrayList<>(); //main container for storing our text file content; in inch index the corresponding line of text is stored
        Map<String, Set<Integer>> map = new HashMap<>();
        if(args[0].equals("--data")) {
            File file = new File(args[1]);
            try (Scanner sc = new Scanner(file)) {
                int linenumber = 0;
                while (sc.hasNextLine()) {
                    String line = sc.nextLine();
                    data.add(line);

                        String[] words = line.toLowerCase().split(" ");
                        for (int j = 0; j < words.length; j++){
                            if (!map.containsKey(words[j])) {
                                map.put(words[j], new HashSet<>());
                            }
                            map.get(words[j]).add(linenumber);
                           
                        }
                        linenumber++;
                }

            } catch (FileNotFoundException e) {
                System.out.println("File not found");
            }

        while(true) {
            System.out.println("=== Menu ===");
            System.out.println("1. Find a person");
            System.out.println("2. Print all people");
            System.out.print("0. Exit\n> ");


            int choice;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number.");
                System.out.println();
                scanner.nextLine();
                continue;
            }


            scanner.nextLine();
            switch (choice) {
                case 0:
                    System.out.println("Bye!");
                    System.exit(0);
                case 1:
                    System.out.println();
                    System.out.println("Select a matching strategy: ALL, ANY, NONE");

                    String strategy;
                    while (true) {
                        strategy = scanner.next().toUpperCase(); // Convert input to uppercase
                        scanner.nextLine(); // Consume newline

                        if (strategy.equals("ALL") || strategy.equals("ANY") || strategy.equals("NONE")) {
                            break; // Valid input, exit loop
                        } else {
                            System.out.println("Invalid choice! Please enter one of: ALL, ANY, NONE");
                            System.out.print("> ");
                        }
                    }

                    System.out.println();
                    System.out.print("Enter a name or email to search all suitable people.\n" + "> ");

                    String line = scanner.nextLine().toLowerCase();
                    WordSearcher wordSearcher = new WordSearcher();

                    switch(strategy){
                        case "ALL":
                            wordSearcher.setMethod(new WordSearchAll());
                            break;
                        case "ANY":
                            wordSearcher.setMethod(new WordSearchAny());
                            break;
                        case "NONE":
                            wordSearcher.setMethod(new WordSearchNone());
                    }
                    wordSearcher.find(map,data,line);
                    break;
                case 2:
                    System.out.println("=== List of people ===");
                    for(String str: data)
                        System.out.println(str);
                }
                System.out.println();
            }
        }
    }
}