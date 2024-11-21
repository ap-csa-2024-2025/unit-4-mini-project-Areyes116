import java.util.Scanner;

public class Main
{

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

    // This method should implement Algorithm 1 and print all necessary data
    public static void algorithm1(String input)
	{
        // Assume input is not null and is not empty
        // First character is always added no matter what
        String lower_case = input.toLowerCase();
        String output = lower_case.substring(0, 1); // I always add the first character
        int vowels_rem = 0;
        int repeat_rem = 0;
        int char_saved = 0;

        final String VOWELS = "aeiou";

        // Start at i = 1 since I already added the first character
        for (int i = 1; i < lower_case.length(); i++)
		{
            String letter = lower_case.substring(i, i + 1);
            String prev_letter = lower_case.substring(i - 1, i);

            // If the letter is a vowel that does not have a space behind it, then...
            if (VOWELS.indexOf(letter) != -1 && !prev_letter.equals(" "))
			{
                vowels_rem++; // Remove vowel by not adding it, and increment vowel counter
            }
			else if (letter.equals(prev_letter))
			{ // If the current letter is the same as its previous
                repeat_rem++; // Remove duplicate by not adding it, and increment duplicate counter
            }
			else
			{ // Otherwise, the letter is good, and we add it
                output += letter;
            }
        }

        System.out.println("Algorithm 1");
        System.out.println("Vowels Removed: " + vowels_rem);
        System.out.println("Repeats Removed: " + repeat_rem);
        System.out.println("Algorithm 1 message: " + output);
        System.out.println("Algorithm 1 characters saved: " + (input.length() - output.length()));
    }

    // This method should implement Algorithm 2 and print all necessary data
    public static void algorithm2(String input)
	{
        int count = 0;
        int num_unique = 0;
        final String LOWER = input.toLowerCase();
        String output = "";

        for (int i = 0; i < LOWER.length(); i++)
		{
            String test_letter = LOWER.substring(i, i + 1);

            // indexOf returning -1 means my test letter is NOT found in my output
            // If it's not found in the output, then I have found a unique letter
            // If it IS found in the output, then it's not unique, since I've already added it
            // We also want to ignore spaces
            if (!test_letter.equals(" ") && output.indexOf(test_letter) == -1)
			{
                num_unique++;
                count = 0; // Counts how many test_letter's there are

                // Loop through the entire sentence again to count how many test_letter is in the sentence
                for (int j = 0; j < LOWER.length(); j++)
				{
                    String count_letter = LOWER.substring(j, j + 1);
                    if (test_letter.equals(count_letter))
					{
                        count++; // count_letter is equal to test_letter, so count it
                    }
                }

                // Concatenate the number of test_letter's and the test_letter itself to the output
                output += count + test_letter;
            }
        }

        System.out.println("Algorithm 2");
        System.out.println("Unique characters found: " + num_unique);
        System.out.println("Algorithm 2 message: " + output);
        System.out.println("Algorithm 2 characters saved: " + (input.length() - output.length()));
    }
}
