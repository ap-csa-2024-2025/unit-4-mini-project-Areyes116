[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-2972f46106e565e64193e422d61a12cf1da4916b45550586e14ef0a7c637dd04.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=17264594)
# unit-4-5-assignment

## Git Config
```
git config user.name "user"
git config user.email "email"
```

## Compiling and Running Java Programs
Note that since the shape classes are separate classes, you will need to compile ALL the files (at least one time).  You can do this by running
```
javac *.java
```
The star means to compile every file that is a Java file type.

Run your code by running
```
java Main.java
```

After you compile the shape classes, you only need to compile and run `Main.java` as usual.

# Instructions  

## The assignment

Your job in this assignment is to write a program that takes a message as a string and reduces the number of characters it uses in two different set ways. The first thing your program will do is ask the user to type a message which will be stored as a String. The String entered should be immediately converted to lowercase as this will make processing much easier. You will then apply two different algorithms to shorten the data contained within the String.

## Algorithm 1
This algorithm creates a string from the message in which every vowel (a, e, i, o, and u) is removed unless the vowel is at the very start of a word (i.e., it is preceded by a space or is the first letter of the message). Every repeated non-vowel character is also removed from the new string (i.e., if a character appears several times in a row it should only appear once at that location). So for example the string "I will arrive in Mississippi really soon" becomes "i wl arv in mssp rly sn".

After applying this algorithm, your program should output the shortened message, the number of vowels removed, the number of repeated non-vowel characters removed, and how much shorter the shortened message is than the original message. The exact format in which the program should print this information is shown in the sample runs.

Hints and Pseudocode
* To remove characters, create a new String, and initialize it to the empty String
* Add the characters that are valid ("are good").
* A vowel is repeated if it is the same as the character behind it (or is the same as the character in front of it, depending on how your brain works).
* Notice that, no matter what, you are always adding the first character of the sentence.

## Algorithm 2

This algorithm creates a string by taking each unique character in the message in the order they first appear and putting that letter and the number of times it appears in the original message into the shortened string. Your algorithm should ignore any spaces in the message, and any characters which it has already put into the shortened string. For example, the string "I will arrive in Mississippi really soon" becomes "8i1w4l2a3r1v2e2n1m5s2p1y2o".

After applying this algorithm, your program should output the shortened message, the number of different characters appearing, and how much shorter the shortened message is than the original message. The exact format in which the program should print this information is shown in the sample runs.

Hints and Pseudocode:
* Create a new string, and initialize it to the empty String.
* A character is unique if it is not already in your new String (indexOf will help you here).
* You'll need to use nested loops here: the outer loop will keep track of the current letter; the inner loop will count how many of that letter appears in the sentence

## Sample Runs
Sample Run 1
```
Type the message to be shortened
This message could be a little shorter

Algorithm 1
Vowels removed: 11
Repeats removed: 2
Algorithm 1 message: ths msg cld b a ltl shrtr
Algorithm 1 characters saved: 13

Algorithm 2
Unique characters found: 15
Algorithm 2 message: 4t2h2i4s1m5e2a1g1c2o1u3l1d1b2r
Algorithm 2 characters saved: 8
```

Sample Run 2
```
Type the message to be shortened
I will arrive in Mississippi really soon

Algorithm 1
Vowels removed: 11
Repeats removed: 6
Algorithm 1 message: i wl arv in mssp rly sn
Algorithm 1 characters saved: 17

Algorithm 2
Unique characters found: 13
Algorithm 2 message: 8i1w4l2a3r1v2e2n1m5s2p1y2o
Algorithm 2 characters saved: 14
```

## Milestones
As you work on this assignment, you can use the milestones below to inform your development process:

1. **Milestone 1:** Set up a program that takes a string input and converts all the letters to lowercase. Start implementing algorithm 1: create a counter variable and iterate through the characters of the String, incrementing this each time a vowel is encountered which is not preceded by a space or is at the start of the String. So at the end of the loop this counts the number of vowels that are not at the start of a word.
2. **Milestone 2:** Add further conditions (using else if) in your loop to count any non-vowel characters which appear immediately after the same character. Make a new empty String to hold the shortened message at the start of the code, then add a final else condition in the loop to add all characters which were not vowels or repeated letters to this String.  Then print the statements for algorithm 1 using your counts and shortened message.
3. **Milestone 3:** Start implementing algorithm 2 by writing code that iterates through the String and checks that each character is not a space and has not already appeared in the String before that point. You will need to use nested loops - an outer loop to iterate through the String characters and an inner loop that looks through the previous characters up to that point - and a flag variable to record if a letter was found in the inner loop. Use a counter variable to count all such "unique" characters in the String.
4. **Milestone 4:** Add a second inner loop inside the outer loop from the previous which counts all appearances of a character that passes the tests from milestone 3. Add the character and the number of times it appears to another shortened message String (which should start as blank String). Finally, print the statements for algorithm 2 using your unique character count and shortened message.

## Sample Solutions
```java
public static void main(String[] args)
{
 // No need to touch anything in here
 Scanner sc = new Scanner(System.in);
 String str = null;

 System.out.println("Enter a sentence:");
 str = sc.nextLine();

 System.out.println();
 algorithm1(str);

 System.out.println();
 algorithm2(str);

 sc.close();
}

// This method should implement Algorithm 1 and print all neccessary data
public static void algorithm1(String input)
{
 // Assume input is not null and is not empty
 // First character is always added no matter what
 String lower_case = input.toLowerCase();
 String output  	  = lower_case.substring(0, 1);	// I always add the first character
 int vowels_rem 	  = 0;
 int repeat_rem    = 0;
 int char_saved    = 0;

 final String VOWELS = "aeiou";

 // Start at i = 1 since I already added the first character
 for (int i = 1; i < lower_case.length(); i++)
 {
  String letter = lower_case.substring(i,i+1);
  String prev_letter = lower_case.substring(i-1, i);

  /* The "normal" way to check for vowels is to do

  boolean isVowel = letter.equals("a") || ... || letter.equals("u");
  if (isVowel && !prev_letter.equals(" "))
  {
   // ...
  }

  */

  // If the letter is a vowel that does not have a space behind it, then...
  if (VOWELS.indexOf(letter) != -1 && !prev_letter.equals(" "))
  {
   vowels_rem++; // Remove vowel by not adding it, and increment vowel counter
  }
  else if (letter.equals(prev_letter))	// If the current letter is the same as its previous
  {
   repeat_rem++;	// Remove duplicate by not adding it, and increment duplicate counter
  }
  else	// Otherwise, the letter is good, and we add it
  {
   output += letter;
  }
 }

 System.out.println("Algorithm 1\nVowels Removed: "	+ vowels_rem
        + "\nRepeats Removed: " + repeat_rem
        + "\nAlgorithm 1 message: " + output
        + "\nAlgorithm 1 characters saved: " + ( input.length()-output.length() ) );
}

// This method should implement Algorithm 2 and print all neccessary data
public static void algorithm2(String input)
{
 int count = 0;
 int num_unique = 0;
 final String LOWER = input.toLowerCase();
 String output = "";

 for (int i = 0; i < LOWER.length(); i++)
 {
  String test_letter = LOWER.substring(i, i+1);

  /*
  * indexOf returning -1 means my test letter is NOT found in my output
  * If it's not found in the output, then I have found a unique letter
  * If it IS found in the output, then it's not unique, since I've already added it
  * We also want to ignore spaces
  * */
  if (!test_letter.equals(" ") && output.indexOf(test_letter) == -1)
  {
   num_unique++;
   count = 0;	// Counts how many test_letter's there are

   // Loop through the entire sentence again to count how many test_letter is in the sentence
   for (int j = 0; j < LOWER.length(); j++)
   {
    String count_letter = LOWER.substring(j, j+1);
    if (test_letter.equals(count_letter))
    {
     count++;	// count_letter is equal to test_letter, so count it
    }
   }

   // Concatenate the number of test_letter's and the test_letter itself to the output
   output += count + test_letter;
  }
 }

 System.out.println(
  "Algorithm 2\nUnique characters found: " + num_unique
  + "\nAlgorithm 1 message: " 			 + output
  + "\nAlgorithm 2 characters saved: " 	 + ( input.length()-output.length() ) );
}
```
