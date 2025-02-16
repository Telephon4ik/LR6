import java.util.Date;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите кол-во взятых книг: ");
        int numberOfTakenBooks = in.nextInt();
        in.nextLine();
        String[] takenBooks = new String[numberOfTakenBooks];
        for (int i = 0; i < numberOfTakenBooks; i++){
            System.out.print("Введите " + (i+1) + "-ую взятую книгу: ");
            takenBooks[i] = in.nextLine();
        }
        System.out.print("Введите кол-во отданных книг: ");
        int numberOfGivenBooks  = in.nextInt();
        in.nextLine();
        String[] givenBooks = new String[numberOfGivenBooks];
        for (int i = 0; i < numberOfGivenBooks; i++){
            System.out.print("Введите " + (i+1) + "-ую отданную книгу: ");
            givenBooks[i] = in.nextLine();
        }
        Reader[] readers = new Reader[5];
        readers[0] = new Reader("Иванов Ф.Я.", 12345, "Филологический", new Date(90, 0, 1), "+7-900-123-45-67");
        readers[1] = new Reader("Петров Т.К.", 67890, "Исторический", new Date(88, 4, 15), "+7-900-234-56-78");
        readers[2] = new Reader("Сидоров З.Н.", 13579, "Физический", new Date(95, 6, 22), "+7-900-345-67-89");
        readers[3] = new Reader("Михайлова А.С.", 24680, "Математический", new Date(92, 11, 10), "+7-900-456-78-90");
        readers[4] = new Reader("Кузнецова М.Д.", 11223, "Биологический", new Date(98, 2, 5), "+7-900-567-89-01");
        readers[0].takeBook(numberOfTakenBooks);
        readers[1].takeBook(numberOfTakenBooks, takenBooks);
        readers[3].returnBook(numberOfGivenBooks);
        readers[4].returnBook(numberOfGivenBooks, givenBooks);
    }
}
class Reader {
    public String fullName;
    public int libraryCard;
    public String faculty;
    public Date dateOfBirth;
    public String telephone;

    Reader(String fullName, int libraryCard, String faculty, Date dateOfBirth, String telephone) {
        this.fullName = fullName;
        this.libraryCard = libraryCard;
        this.faculty = faculty;
        this.dateOfBirth = dateOfBirth;
        this.telephone = telephone;
    }

    public void takeBook(int numberOfTakenBooks) {
        if (numberOfTakenBooks == 1) System.out.println(fullName + " взял " + numberOfTakenBooks + " книгу");
        else if (numberOfTakenBooks >= 2 && numberOfTakenBooks <= 4)
            System.out.println(fullName + " взял " + numberOfTakenBooks + " книги");
        else System.out.println(fullName + " взял " + numberOfTakenBooks + " книг");
    }

    public void takeBook(int numberOfTakenBooks, String... takenBooks) {
        if (numberOfTakenBooks == 1) {
            System.out.print(fullName + " взял следующую книгу: " + takenBooks[0]);
        } else {
            System.out.print(fullName + " взял следующие книги: ");
            for (int i = 0; i < takenBooks.length; i++) {
                System.out.print(takenBooks[i]);
                if (i < takenBooks.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
    }
    public void returnBook(int numberOfGivenBooks) {
        if (numberOfGivenBooks == 1) System.out.println(fullName + " вернул " + numberOfGivenBooks + " книгу");
        else if (numberOfGivenBooks >= 2 && numberOfGivenBooks <= 4)
            System.out.println(fullName + " вернул " + numberOfGivenBooks + " книги");
        else System.out.println(fullName + " вернул " + numberOfGivenBooks + " книг");
    }

    public void returnBook(int numberOfGivenBooks, String... givenBooks) {
        if (numberOfGivenBooks == 1) {
            System.out.print(fullName + " вернул следующую книгу: " + givenBooks[0]);
        } else {
            System.out.print(fullName + " вернул следующие книги: ");
            for (int i = 0; i < givenBooks.length; i++) {
                System.out.print(givenBooks[i]);
                if (i < givenBooks.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }
    }
}