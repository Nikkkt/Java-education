package Task5;

import java.util.*;

import static Task5.functions.*;

public class Task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть шлях до файлу для завантаження даних співробітників: ");
        String filePath = scanner.nextLine();
        loadEmployees(filePath);

        boolean exit = false;
        while (!exit) {
            System.out.println("\nМеню:");
            System.out.println("1. Додати співробітника");
            System.out.println("2. Редагувати співробітника");
            System.out.println("3. Видалити співробітника");
            System.out.println("4. Пошук співробітника по прізвищу");
            System.out.println("5. Вивід інформації про всіх співробітників");
            System.out.println("6. Фільтрація співробітників за віком");
            System.out.println("7. Фільтрація співробітників за першою літерою прізвища");
            System.out.println("8. Зберегти інформацію у файл");
            System.out.println("9. Вихід");
            System.out.print("Виберіть опцію: ");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    addEmployee(scanner);
                    break;
                case "2":
                    editEmployee(scanner);
                    break;
                case "3":
                    deleteEmployee(scanner);
                    break;
                case "4":
                    searchEmployeeByLastName(scanner);
                    break;
                case "5":
                    displayAllEmployees();
                    break;
                case "6":
                    filterEmployeesByAge(scanner);
                    break;
                case "7":
                    filterEmployeesByFirstLetter(scanner);
                    break;
                case "8":
                    saveEmployees(filePath);
                    break;
                case "9":
                    exit = true;
                    break;
                default:
                    System.out.println("Невірний вибір. Спробуйте ще раз");
                    break;
            }
        }

        saveEmployees(filePath);
        System.out.println("Дані збережено. EXIT");
    }
}
