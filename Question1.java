import java.util.Scanner;

public class StringManipulation {

    public static void main(String[] args) {
       
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter your middle name: ");
        String middleName = scanner.nextLine();

        System.out.print("Enter your last name: ");
        String lastName = scanner.nextLine();

        String fullName = lastName + ", " + firstName + " " + middleName;

        System.out.println("Full Name: " + fullName);

        scanner.close();
    }
}
