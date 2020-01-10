import java.util.Scanner;

public class Main {

  public static String[] letters =new String[]{"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o",
                                              "p","q","r","s","t","u","v","w","x","y","z"};
  //String array containing the morse characyers
  public static String[] morse = new String[]{ ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
          ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.",
          "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

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

    boolean same_num_characters=check_if_each_character_represented(word,morseletter);
    boolean right_num_spaces=check_space(word,morseletter);
    assert same_num_characters==true :"The inputs length is not equal to the outputs length";
    assert right_num_spaces==true :"The spaces are incorrect";
      return morseletter;
  }


  private static boolean check_space(String input,String output)
  {
    if(containsWhiteSpace(input))
    {
      String[] array_input=input.split(" ");
      input = String.valueOf(array_input);
      char[] array_input2=input.toCharArray();
      String[] output_array=output.split(" ");
      return array_input2.length==output_array.length;
    }else{
      char[] array_input2=input.toCharArray();
      String[] output_array=output.split(" ");
      return array_input2.length==output_array.length;
    }

  }
  //Function that check if the input and output both have the same number of characters
private static  boolean check_if_each_character_represented(String input,String output)
{

  if(containsWhiteSpace(input))
  {
    input = output.replace("/"," ");
    char[] output_array=input.toCharArray();
    String[] morse_code_letters = output.split(" ");
    return output_array.length == morse_code_letters.length;
  }else{
    char[] output_array=input.toCharArray();
    String[] morse_code_letters = output.split(" ");
    return output_array.length == morse_code_letters.length;
  }


}

  public static boolean containsWhiteSpace(String line){
    boolean space= false;
    if(line != null){


      for(int i = 0; i < line.length(); i++){

        if(line.charAt(i) == ' '){
          space= true;
          return space;
        }

      }
    }
    return space;
  }


  //A function that converts morse code to readable text
  private static String morseCodetoLetters(String word)
  {

   String[] words = word.split(" ");
   String sentence = "";
   for(int i =0 ;i < words.length; i++)
   {
     for(int k = 0;k < morse.length; k++)
     {
      boolean check = words[i].equals(morse[k]);
      boolean is_forward_slash = words[i].equals("/");
       if(check)
       {
         sentence+=letters[k];
         break;
       }else if(is_forward_slash){
         sentence += " ";
         break;
       }else if(k==morse.length-1)
       {
         sentence += "#";
         break;
       }
     }
   }
   //The way the function is called is reverse of what the parameters are because morse code has a lot of whitespace in between
    boolean same_num_characters=check_if_each_character_represented(sentence,word);
    assert same_num_characters==true :"The inputs length is not equal to the outputs length";
    boolean right_num_spaces=check_space(sentence,word);
    assert right_num_spaces==true :"The spaces are incorrect";
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
      String sentence =morseCodetoLetters("-... / -...");
      System.out.println(sentence);
    }
}
