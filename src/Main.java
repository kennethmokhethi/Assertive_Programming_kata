import java.util.Scanner;

public class Main {

  //public static char[] letters ={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
  // new String[]{"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o",
          //        "p","q","r","s","t","u","v","w","x","y","z"};

  public static String[] letters =new String[]{"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o",
                                              "p","q","r","s","t","u","v","w","x","y","z"};
  //String array containing the morse characyers
  public static String[] morse = new String[]{ ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
          ".---", "-.-", ".-..", "--", "-.", "---", ".---.", "--.-", ".-.",
          "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

         /* , ".----",
          "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.",
          "-----", "--..--", ".-.-.-", "..--.." };*/

  //Function that convert a word to morse code
  private static String lettersToMorseCode(String word)
  {

    word = word.toLowerCase();
    String morseletter = " ";
    //Search for whitespace and replace with a forward slash
    if(word.matches("^\\s*$"))
    {
      word = word.replace("/"," ");
    }

    //For each loop
    for(char i: word.toCharArray())
    {
      if(i == 32){ //Number 32 represent a forward slash in ascii table
        morseletter+= "/" + " ";
      }else{
        morseletter += morse[i - 'a'] + " ";
      }
    }
      return morseletter;
  }

  //A function that converts morse code to readable text
  private static String morseCodetoLetters(String word)
  {
   String[] words = word.split(" ");
   String sentence = " ";
   for(int i =0 ;i < words.length; i++)
   {
     for(int k = 0;k < morse.length; k++)
     {
      boolean check = words[i].equals(morse[k]);
       if(check)
       {
         sentence+=letters[k];
       }else if((words[i]=="/") || (words[i]=="")){
         sentence += " ";
       }
     }
   }

      return sentence;
  }


    public static void main(String[] args)
    {
      //Testing function that transform a word to morse code
     /* Scanner scan = new Scanner(System.in);
      System.out.println("Enter word");
      String word=scan.nextLine();

      String morse_code=lettersToMorseCode(word);
      System.out.println(morse_code);*/

      //Testing a function that transform a morse code to a sentence
      //System.out.println("Enter the morse code");
      //String strMorse_code=scan.nextLine();
      String sentence =morseCodetoLetters("-... .- -... .-  / .-");
      System.out.println(sentence);
    }
}
