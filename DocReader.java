import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

/*
* Poem writer by Kreslev v1 2018
*/

public class DocReader {
   //Holds word objects
   ArrayList<Word> containedWord = new ArrayList<Word>();
   
   //Intializes the containedWord ArrayList through reading the file 
   public DocReader(String fileName) throws FileNotFoundException {
      Scanner inFile = new Scanner(new File(fileName));
      
      //This reads the file
      while (inFile.hasNextLine()) {
         String line = inFile.nextLine();
         String[] lineSplit = line.split(" ");
         
         //Breaks up the line to an array
         for (int i = 0; i < lineSplit.length; i++) {
            String thatWord = lineSplit[i].toLowerCase().trim();
            
            //Skips the stuff if the array is empty
            if(containedWord.isEmpty()) {
               Word word = new Word(thatWord);
               if(i != lineSplit.length - 1) {
                  String otherWord = lineSplit[i+1].toLowerCase().trim();
                  word.addWord(otherWord);
               }
               containedWord.add(word);
            }
            
            //The last word of a line won't have anything follow it
            else if(i == lineSplit.length - 1) {
               for(int j = 0; j < containedWord.size(); j++) {
                  if(thatWord.equals(containedWord.get(j).getWord())) {
                     j = containedWord.size() + 1;
                  }
                  else if(j == containedWord.size() - 1 && !thatWord.equals((containedWord.get(j).getWord()))) {
                     Word word = new Word(thatWord);
                     containedWord.add(word);
                  }
               }
            }
            
            //The good part
            else {
               for(int j = 0; j < containedWord.size(); j++) {
                  if(thatWord.equals(containedWord.get(j).getWord())) {
                     if(i != lineSplit.length - 1) {
                        String otherWord = lineSplit[i+1].toLowerCase().trim();
                        containedWord.get(j).addWord(otherWord);
                     }
                     j = containedWord.size();
                  }
                  else if(j == containedWord.size() - 1) {
                     Word word = new Word(thatWord);
                     String otherWord = lineSplit[i+1].toLowerCase().trim();
                     word.addWord(otherWord);
                     containedWord.add(word);
                     j = containedWord.size();
                  }
                  else {
                  
                  }
               }
            }
         }
      }
   }
   
   //Returns a random word object from the containedWord array
   public Word getRandomWord() {
      Random rand = new Random();
      int random = rand.nextInt(containedWord.size());
      Word next = containedWord.get(random);
      return next;
   }
   
   //Gets a random string from the Word object's array
   public String getNextWord(Word wordIn) {
      String next;
      int max = wordIn.chanceSize();
      //Used if the Word object's array is empty
      if(max == -1) {
         Word x = getRandomWord();
         next = x.getWord();
      }
      else {
         Random rand = new Random();
         int random = rand.nextInt(max);
         next = wordIn.getRandom(random);
      }
      return next;
   }
   
   //Checks the string from the containedWord array to find its object
   public Word checkWord(String wordIn) {
      for (int i = 0; i < containedWord.size(); i++) {
         if(wordIn.equals(containedWord.get(i).getWord())) {
            return containedWord.get(i);
         }
      }
      return getRandomWord();
   }
   
   //Used to check syllable count for haiku
   public int sylCheck(String wordIn) {
      char[] syl = wordIn.toCharArray();
      int preCount = 0;
      int count = 1;
      for (int i = 0; i < syl.length-1; i++) {
         if (syl[i] == 'a' || syl[i] == 'e'  || syl[i] == 'i'
            || syl[i] == 'o' || syl[i] == 'u' || syl[i] == 'y') {
            
            if (i == 0) {
               preCount++;
            }
            else if (i > 0 && syl[i-1] != 'a' || syl[i-1] != 'e'  || syl[i-1] != 'i'
               || syl[i-1] != 'o' || syl[i-1] != 'u' || syl[i-1] != 'y') {
               preCount++;
            }
         
         }
      }
      if (preCount > count) {
         count = preCount;
      }
      return count;
   }
}