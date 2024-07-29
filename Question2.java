import java.util.Scanner;

public class Question2 {
    private static final int NUM_SUBJECTS = 3;
    private static int[][] studentMarks;
    private static int numStudents;
    private static final String[] SUBJECT_NAMES = {"Mathematics", "Chemistry", "Physics"};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the number of students
        System.out.println("Enter number of students:");
        numStudents = scanner.nextInt();
        studentMarks = new int[numStudents][NUM_SUBJECTS + 1]; // +1 for storing studentID

        while (true) {
            showMenu();
            System.out.println("Enter command: ");
            scanner.nextLine();  // Consume newline left-over
            String command = scanner.nextLine();

            // Split the input command to get the parts
            String[] parts = command.split(" ");
            switch (parts[0]) {
                case "add":
                    if (parts.length == 2) {
                        addStudentMarks(Integer.parseInt(parts[1]));
                    } else {
                        System.out.println("Invalid usage of 'add' command.");
                    }
                    break;
                case "update":
                    if (parts.length == 4) {
                        updateStudentMark(Integer.parseInt(parts[1]), Integer.parseInt(parts[2]), Integer.parseInt(parts[3]));
                    } else {
                        System.out.println("Invalid usage of 'update' command.");
                    }
                    break;
                case "average_s":
                    if (parts.length == 2) {
                        getAverageForSubject(Integer.parseInt(parts[1]));
                    } else {
                        System.out.println("Invalid usage of 'average_s' command.");
                    }
                    break;
                case "average":
                    if (parts.length == 2) {
                        getAverageForStudent(Integer.parseInt(parts[1]));
                    } else {
                        System.out.println("Invalid usage of 'average' command.");
                    }
                    break;
                case "total":
                    if (parts.length == 2) {
                        getTotalMarks(Integer.parseInt(parts[1]));
                    } else {
                        System.out.println("Invalid usage of 'total' command.");
                    }
                    break;
                case "grades":
                    displayGrades();
                    break;
                case "exit":
                    System.out.println("Exiting the program.");
                    return;
                default:
                    System.out.println("Invalid command. Try again.");
            }
        }
    }

    // Method to show menu
    private static void showMenu() {
        System.out.println("\nMenu:");
        System.out.println("add [studentID] - Add student marks");
        System.out.println("update [studentID] [subjectID] [mark] - Update student mark");
        System.out.println("average_s [subjectID] - Get the average for a subject");
        System.out.println("average [studentID] - Get the average for a student");
        System.out.println("total [studentID] - Get the total mark of a student");
        System.out.println("grades - Display the grades of all students");
        System.out.println("exit - Exit the program");
    }

    // Method to add student marks
    private static void addStudentMarks(int studentID) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < numStudents; i++) {
            if (studentMarks[i][0] == 0) { // Check for an empty slot
                studentMarks[i][0] = studentID;
                for (int j = 1; j <= NUM_SUBJECTS; j++) {
                    System.out.println("Enter marks for subject " + j + " (" + SUBJECT_NAMES[j - 1] + "): ");
                    studentMarks[i][j] = scanner.nextInt();
                }
                System.out.println("Marks added for student " + studentID);
                return;
            }
        }
        System.out.println("No space to add more students.");
    }

    // Method to update student marks
    private static void updateStudentMark(int studentID, int subjectID, int mark) {
        for (int i = 0; i < numStudents; i++) {
            if (studentMarks[i][0] == studentID) {
                studentMarks[i][subjectID] = mark;
                System.out.println("Student " + studentID + "'s marks for subject " + subjectID + " was updated to " + mark);
                return;
            }
        }
        System.out.println("Student ID not found.");
    }

    // Method to get the average mark for a subject
    private static void getAverageForSubject(int subjectID) {
        int total = 0;
        int count = 0;

        for (int i = 0; i < numStudents; i++) {
            if (studentMarks[i][0] != 0) { // Only consider added students
                total += studentMarks[i][subjectID];
                count++;
            }
        }

        if (count == 0) {
            System.out.println("No students found.");
            return;
        }

        double average = (double) total / count;
        System.out.println("Average for subject " + subjectID + " is " + average);
    }

    // Method to get the average mark for a student
    private static void getAverageForStudent(int studentID) {
        for (int i = 0; i < numStudents; i++) {
            if (studentMarks[i][0] == studentID) {
                int total = 0;
                for (int j = 1; j <= NUM_SUBJECTS; j++) {
                    total += studentMarks[i][j];
                }

                double average = (double) total / NUM_SUBJECTS;
                System.out.println("Student " + studentID + " has an average of " + average);
                return;
            }
        }
        System.out.println("Student ID not found.");
    }

    // Method to get the total marks for a student
    private static void getTotalMarks(int studentID) {
        for (int i = 0; i < numStudents; i++) {
            if (studentMarks[i][0] == studentID) {
                int total = 0;
                for (int j = 1; j <= NUM_SUBJECTS; j++) {
                    total += studentMarks[i][j];
                }
                System.out.println("Student " + studentID + "'s total marks are " + total);
                return;
            }
        }
        System.out.println("Student ID not found.");
    }

    // Method to display grades for all students
    private static void displayGrades() {
        System.out.printf("%-10s %-15s %-15s %-15s\n", "StudentID", "Mathematics", "Chemistry", "Physics");

        for (int i = 0; i < numStudents; i++) {
            if (studentMarks[i][0] != 0) { // Only consider added students
                System.out.printf("%-10d", studentMarks[i][0]);
                for (int j = 1; j <= NUM_SUBJECTS; j++) {
                    System.out.printf(" %-15s", getGrade(studentMarks[i][j]));
                }
                System.out.println();
            }
        }
    }

    // Method to get grade based on marks
    private static String getGrade(int marks) {
        if (marks >= 90) {
            return "Grade A";
        } else if (marks >= 80) {
            return "Grade B";
        } else if (marks >= 70) {
            return "Grade C";
        } else if (marks >= 60) {
            return "Grade D";
        } else {
            return "Fail";
        }
    }
}
