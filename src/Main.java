

import java.util.Scanner;

public class Main {

  //public static char[] letters ={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};




          //new String[]{"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o",
          //                                                "p","q","r","s","t","u","v","w","x","y","z"};
  public static String[] morse = new String[]{ ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
          ".---", "-.-", ".-..", "--", "-.", "---", ".---.", "--.-", ".-.",
          "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".----",
          "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.",
          "-----", "--..--", ".-.-.-", "..--.." };



  private static String letterstoMorse(String word)
  {

     word = word.toLowerCase();
    String morseletter=" ";
    if(word.matches("^\\s*$"))
    {
      word = word.replace("/"," ");
    }

    //For each loop
    for(char i: word.toCharArray())
    {
   //   int index_of_char_in_word=findindex(i);
      if(i==32){

        morseletter+=" "+"/"+" ";
      }else{
        morseletter+=morse[i-'a']+" ";
      }
    }
      return morseletter;
  }

  private static String morseCodetoletters(String word)
  {
      return "Needs code";
  }


    public static void main(String[] args)
    {
      Scanner scan = new Scanner(System.in);
      System.out.println("Enter word");
      String word=scan.nextLine();

      String res=letterstoMorse(word);
      System.out.println(res);
    }
}
