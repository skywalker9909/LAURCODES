/*
 NAME: LAUREL TAY RAEANNE
 SCHOOL: UNIVERISTY OF ROCHESTER
 EMAIL: LTAY3@U.ROCHESTER.EDU
 DATE LAST MODIFIED: APRIL 21
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Anagrams {
    private static Map<String, Set<String>> anagramMap = new HashMap<>();
    private static Set<String> wordSet = new HashSet<>();

    public static void main(String[] args) throws IOException {
        String wordListFile = "words.txt"; // change this to the actual file name
        loadWords(wordListFile);        

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] tokens = line.trim().split("\\s+");
            if (tokens[0].equals("normalize")) {
                String normalized = normalize(tokens[1]);
                System.out.println(normalized);
            } else if (tokens[0].equals("anagrams")) {
                boolean isAnagram = normalize(tokens[1]).equals(normalize(tokens[2]));
                System.out.println(isAnagram);
            } else if (tokens[0].equals("search")) {
                List<String> anagrams = findAnagrams(tokens[1]);
                if (anagrams.isEmpty()) {
                    System.out.println("n/a");
                } else {
                    System.out.println(String.join(" ", anagrams));
                }
            } else if (tokens[0].equals("lookup")) {
                boolean found = wordSet.contains(tokens[1].toLowerCase());
                System.out.println(found);
            } else if (tokens[0].equals("quit")) {
                break;
            }
        }
    }

    private static void loadWords(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = reader.readLine()) != null) {
            String word = line.trim();
            wordSet.add(word);
            String normalized = normalize(word);
            Set<String> anagrams = anagramMap.getOrDefault(normalized, new HashSet<>());
            anagrams.add(word);
            anagramMap.put(normalized, anagrams);
        }
        reader.close();
    }

    private static String normalize(String word) {
        char[] chars = word.toLowerCase().toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    private static List<String> findAnagrams(String word) {
        String normalized = normalize(word);
        Set<String> anagrams = anagramMap.getOrDefault(normalized, new HashSet<>());
        List<String> sortedAnagrams = new ArrayList<>(anagrams);
        Collections.sort(sortedAnagrams);
        sortedAnagrams.remove(word.toLowerCase());
        return sortedAnagrams;
    }

    private static List<String> findAnagrams(String word1, String word2) {
        List<String> anagrams1 = findAnagrams(word1.toLowerCase());
        List<String> anagrams2 = findAnagrams(word2.toLowerCase());
        List<String> commonAnagrams = new ArrayList<>(anagrams1);
        commonAnagrams.retainAll(anagrams2);
        return commonAnagrams;
    }
}
