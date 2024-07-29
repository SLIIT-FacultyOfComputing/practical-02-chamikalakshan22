import java.util.Scanner;

public class StringManipulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Part 1: String Concatenation
        System.out.println("Enter your first name:");
        String firstName = scanner.nextLine();
        
        System.out.println("Enter your middle name:");
        String middleName = scanner.nextLine();
        
        System.out.println("Enter your last name:");
        String lastName = scanner.nextLine();
        
        String fullName = lastName + ", " + firstName + " " + middleName;
        System.out.println("Full Name: " + fullName);
        
        // Part 2: String Comparison
        System.out.println("Enter another full name:");
        String anotherFullName = scanner.nextLine();
        
        if (fullName.equalsIgnoreCase(anotherFullName)) {
            System.out.println("The names are the same.");
        } else {
            System.out.println("The names are different.");
        }
        
        // Part 3: String Modification
        String modifiedFullName = fullName.replace('a', '@').replace('e', '3').toUpperCase();
        System.out.println("Modified Full Name: " + modifiedFullName);
        
        // Part 4: String Splitting
        String[] nameComponents = fullName.split(", ");
        String lastNameComponent = nameComponents[0];
        String[] firstAndMiddleNameComponents = nameComponents[1].split(" ");
        String firstNameComponent = firstAndMiddleNameComponents[0];
        String middleNameComponent = firstAndMiddleNameComponents[1];
        
        System.out.println("Last Name: " + lastNameComponent);
        System.out.println("First Name: " + firstNameComponent);
        System.out.println("Middle Name: " + middleNameComponent);
        
        // Part 5: String Trimming
        System.out.println("Enter a string with leading and trailing spaces:");
        String stringWithSpaces = scanner.nextLine();
        String trimmedString = stringWithSpaces.trim();
        System.out.println("Trimmed String: " + trimmedString);
        
        // Part 6: Additional Manipulations
        int vowelCount = countVowels(fullName);
        System.out.println("Number of vowels in the full name: " + vowelCount);

        scanner.close();
    }

    // Helper method to count vowels in a string
    private static int countVowels(String str) {
        int count = 0;
        for (char c : str.toLowerCase().toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                count++;
            }
        }
        return count;
    }
}
