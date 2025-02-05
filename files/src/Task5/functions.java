package Task5;

import java.io.*;
import java.util.*;

public class functions {
    public static ArrayList<Employee> employees = new ArrayList<>();
    public static int nextId = 1;

    public static void addEmployee(Scanner scanner) {
        System.out.print("Введіть ім'я: ");
        String firstName = scanner.nextLine();
        System.out.print("Введіть прізвище: ");
        String lastName = scanner.nextLine();
        System.out.print("Введіть вік: ");
        int age = Integer.parseInt(scanner.nextLine());
        Employee emp = new Employee(nextId++, firstName, lastName, age);
        employees.add(emp);
        System.out.println("Співробітника додано");
    }

    public static void editEmployee(Scanner scanner) {
        System.out.print("Введіть ID співробітника для редагування: ");
        int id = Integer.parseInt(scanner.nextLine());
        Employee emp = findEmployeeById(id);

        if (emp == null) {
            System.out.println("Співробітника з таким ID не знайдено");
            return;
        }

        System.out.println("Поточні дані: " + emp);
        System.out.print("Введіть нове ім'я (залиште порожнім, якщо не змінювати): ");
        String firstName = scanner.nextLine();
        if (!firstName.trim().isEmpty()) emp.setFirstName(firstName);

        System.out.print("Введіть нове прізвище (залиште порожнім, якщо не змінювати): ");
        String lastName = scanner.nextLine();
        if (!lastName.trim().isEmpty()) emp.setLastName(lastName);

        System.out.print("Введіть новий вік (натисніть Enter, якщо не змінювати): ");
        String ageInput = scanner.nextLine();
        if (!ageInput.trim().isEmpty()) {
            int age = Integer.parseInt(ageInput);
            emp.setAge(age);
        }
        System.out.println("Дані співробітника оновлено");
    }

    public static void deleteEmployee(Scanner scanner) {
        System.out.print("Введіть ID співробітника для видалення: ");
        int id = Integer.parseInt(scanner.nextLine());
        Employee emp = findEmployeeById(id);

        if (emp == null) {
            System.out.println("Співробітника з таким ID не знайдено");
            return;
        }

        employees.remove(emp);
        System.out.println("Співробітника видалено");
    }

    public static void searchEmployeeByLastName(Scanner scanner) {
        System.out.print("Введіть прізвище для пошуку: ");
        String lastName = scanner.nextLine().trim().toLowerCase();

        boolean found = false;
        for (Employee emp : employees) {
            if (emp.getLastName().toLowerCase().contains(lastName)) {
                System.out.println(emp);
                found = true;
            }
        }

        if (!found) System.out.println("Співробітників з прізвищем, що містить \"" + lastName + "\", не знайдено");
    }

    public static void displayAllEmployees() {
        if (employees.isEmpty()) {
            System.out.println("Список співробітників порожній");
            return;
        }

        for (Employee emp : employees) System.out.println(emp);
    }

    public static void filterEmployeesByAge(Scanner scanner) {
        System.out.print("Введіть вік для фільтрації: ");
        int age = Integer.parseInt(scanner.nextLine());

        boolean found = false;
        for (Employee emp : employees) {
            if (emp.getAge() == age) {
                System.out.println(emp);
                found = true;
            }
        }

        if (!found) System.out.println("Співробітників віком " + age + " не знайдено");
    }

    public static void filterEmployeesByFirstLetter(Scanner scanner) {
        System.out.print("Введіть першу літеру прізвища: ");
        String letter = scanner.nextLine().toLowerCase();

        if (letter.length() != 1) {
            System.out.println("Будь ласка, введіть одну літеру");
            return;
        }

        boolean found = false;
        for (Employee emp : employees) {
            if (emp.getLastName().toLowerCase().startsWith(letter)) {
                System.out.println(emp);
                found = true;
            }
        }

        if (!found) System.out.println("Співробітників, прізвище яких починається на \"" + letter + "\", не знайдено");
    }

    public static Employee findEmployeeById(int id) {
        for (Employee emp : employees) if (emp.getId() == id) return emp;
        return null;
    }

    public static void loadEmployees(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("Файл не знайдено, створюється новий список співробітників");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int maxId = 0;
            while ((line = br.readLine()) != null) {
                Employee emp = Employee.fromCSV(line);
                if (emp != null) {
                    employees.add(emp);
                    if (emp.getId() > maxId) maxId = emp.getId();
                }
            }

            nextId = maxId + 1;
            System.out.println("Дані завантажено з файлу. Загальна кількість співробітників: " + employees.size());

        } catch (IOException e) {
            System.out.println("Помилка при завантаженні даних:");
            e.printStackTrace();
        }
    }

    public static void saveEmployees(String filePath) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filePath))) {
            for (Employee emp : employees) pw.println(emp.toCSV());
            System.out.println("Дані збережено у файл " + filePath);

        } catch (IOException e) {
            System.out.println("Помилка при збереженні даних:");
            e.printStackTrace();
        }
    }
}
