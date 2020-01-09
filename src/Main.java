
public class Main {

  public static String[] letters =new String[]{"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o",
                                                "p","q","r","s","t","u","v","w","x","y","z"};

  public static String[] morse = new String[]{ ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
          ".---", "-.-", ".-..", "--", "-.", "---", ".---.", "--.-", ".-.",
          "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".----",
          "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.",
          "-----", "--..--", ".-.-.-", "..--.." };

  private static int findindex(String chart){

  int index_of_char=0;
    for(int i=0;i<letters.length;i++)
    {
      if(chart==letters[i])
      {
        index_of_char= i;
      }
    }
    return index_of_char;
  }

  private static String letterstoMorse(String words)
  {
    String[] word =words.split(" ");
    String morseletter=" ";
    for(int i=0;i<word.length;i++)
    {
      int index_of_char_in_word=findindex(word[i]);
      if(word[i]==" "){
        morseletter+=" "+"/"+" ";
      }else{
        morseletter+=morse[i]+" ";
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
      System.out.println(letterstoMorse("hi go"));
    }
}
