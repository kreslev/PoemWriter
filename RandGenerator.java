import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

/*
* Poem writer by Kreslev v1 2018
*/

public class RandGenerator {
   public static void main(String[] args) throws FileNotFoundException {
      String fileName = "superSerious.txt";
      DocReader doc = new DocReader(fileName);
      String finalText = "";
      Word y = doc.getRandomWord();
      
      //This is the full poem writing section
      for (int i = 0; i < 16; i++) {
         int j = 0;
         int x = 0;
         while (j < 11 && x < 7) {
            String z = doc.getNextWord(y);
            z = z.replace(".", "");
            z = z.replace("!", "");
            z = z.replace("\"", "");
            z = z.replace(":", "");
            z = z.replace("?", "");
            z = z.replace(",", "");
            z = z.replace(";", "");
            if(x == 0) {
               z = z.substring(0, 1).toUpperCase() + z.substring(1);
            }
            if (j == 4) {
               finalText = finalText + z + ", ";
            }
            else if (j == 5) {
               finalText = finalText + z + "; ";
            }
            else {
               finalText = finalText + z + " ";
            }
            x++;
            if (x > 2) {
               Random rand = new Random();
               int random = rand.nextInt(11 + 1);
               j = random;
            }
            y = doc.checkWord(z);
         }
         finalText = finalText + "\n";
      }
      
      /*
      //This is the haiku section
      int first = 5;
      int second = 7;
      int third = 5;
      int escape  = 0;
      String last = "";
      
      ///i love you 
      
      while(first > 0) {
         String next = y.getWord() + " ";
         if(y.getCount() > first) {
            y =  doc.getRandomWord();
         }
         else {
            if (!next.equals(last)) {
               first = first - y.getCount();
               finalText = finalText + next + " ";
               last = next;
               while(escape < 10) {
                  String z = doc.getNextWord(y);
                  if(doc.sylCheck(z) < first) {
                     y = doc.checkWord(z);
                     escape = 10;
                  }
                  escape++;
               }
            }
            else {
               y = doc.getRandomWord();
            }
            escape = 0;
         }
      }
      finalText = finalText + "\n";
      while(second > 0) {
         String next = y.getWord() + " ";
         if(y.getCount() > second) {
            y =  doc.getRandomWord();
         }
         else {
            if (!next.equals(last)) {
               second = second - y.getCount();
               finalText = finalText + next + " ";
               last = next;
               while(escape < 10) {
                  String z = doc.getNextWord(y);
                  if(doc.sylCheck(z) < second) {
                     y = doc.checkWord(z);
                     escape = 10;
                  }
                  escape++;
               }
            }
            else {
               y = doc.getRandomWord();
            }
            escape = 0;
         }
      }
      finalText = finalText + "\n";
      while(third > 0) {
         String next = y.getWord() + " ";
         if(y.getCount() > third) {
            y =  doc.getRandomWord();
         }
         else {
            if (!next.equals(last)) {
               third = third - y.getCount();
               finalText = finalText + next + " ";
               last = next;
               while(escape < 10) {
                  String z = doc.getNextWord(y);
                  if(doc.sylCheck(z) < third) {
                     y = doc.checkWord(z);
                     escape = 10;
                  }
                  escape++;
               }
            }
            else {
               y = doc.getRandomWord();
            }
            escape = 0;
         }
      }
      */
      System.out.println(finalText); 
   }
}