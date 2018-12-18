import java.util.*;

/*
* Poem writer by Kreslev v1 2018
*/

public class Word {
   
   //local word variables
   ArrayList<String> chance = new ArrayList<String>();
   private String word;
   private int count = 1;
   
   //Word constructor
   public Word(String wordIn) {
      setWord(wordIn);
      //sylCount(wordIn);
   }
   
   //Manages the String of the Word Object
   public void setWord(String wordIn) {
      word = wordIn;
   }
   public String getWord() {
      return word;
   }
   
   //Manages and uses the ArrayList
   public void addWord(String input) {
      chance.add(input);
   }
   public String getRandom(int random) {
      String get = chance.get(random);
      return get;
   }
   public ArrayList<String> getChance() {
      return chance;
   }
   
   //Returns the size of the ArrayList
   public int chanceSize() {
      int size;
      if (chance.isEmpty()) {
         size = -1;
      }
      else {
         size = chance.size();
      }
      return size;
   }
   
   
   //Below is part of the Haiku section
   /*
   public void sylCount(String wordIn) {
      char[] syl = wordIn.toCharArray();
      int preCount = 0;
      for (int i = 0; i < syl.length; i++) {
         if (i == syl.length - 1 && syl[i] == 'e') {
         
         }
         else {
            if (syl[i] == 'a' || syl[i] == 'e'  || syl[i] == 'i'
               || syl[i] == 'o' || syl[i] == 'u' || syl[i] == 'y') {
            
               if (i == 0) {
                  preCount++;
               }
               else if (syl[i-1] == 'a' || syl[i-1] == 'e'  || syl[i-1] == 'i'
                  || syl[i-1] == 'o' || syl[i-1] == 'u' || syl[i-1] == 'y') {
                  preCount = preCount;
               }
               else {
                  preCount++;
               }
            }
         }
      }
      if (preCount > count) {
         count = preCount;
      }
   }
   
   public int getCount() {
      return count;
   }
   */
}