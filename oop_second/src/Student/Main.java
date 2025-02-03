package Student;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Group group = new Group("Група КМ-32");

        Student student1 = new Student("Нікіта");
        student1.addCourse(new Course("Математика", 1, true, 100));
        student1.addCourse(new Course("Фізика", 1, true, 72));

        Student student2 = new Student("Матвій");
        student2.addCourse(new Course("Математика", 1, true, 60));
        student2.addCourse(new Course("Фізика", 1, false, 0));

        Student student3 = new Student("Кирило");
        student3.addCourse(new Course("Математика", 1, false, 0));
        student3.addCourse(new Course("Фізика", 1, false, 0));

        group.addStudent(student1);
        group.addStudent(student2);
        group.addStudent(student3);

        System.out.println("Неуспішні студенти (є нездані предмети):");
        for (Student s : group.getStudents()) if (s.hasUnpassedCourse()) System.out.println(s.getName());

        System.out.println("\nСтуденти без боргів:");
        for (Student s : group.getStudents()) if (s.hasNoDebts()) System.out.println(s.getName());

        Map<String, Integer> courseFailures = new HashMap<>();
        for (Student s : group.getStudents()) for (Course c : s.getCourses()) if (!c.isPassed()) courseFailures.put(c.getCourseName(), courseFailures.getOrDefault(c.getCourseName(), 0) + 1);

        int maxFailures = 0;
        for (Integer count : courseFailures.values()) if (count > maxFailures) maxFailures = count;
        System.out.println("\nКурси з найбільшою кількістю незданих:");
        for (Map.Entry<String, Integer> entry : courseFailures.entrySet()) if (entry.getValue() == maxFailures) System.out.println(entry.getKey() + " (" + entry.getValue() + " незданих)");

        System.out.println("\nРейтинг студентів (середній бал за здані курси):");
        for (Student s : group.getStudents()) System.out.printf("%s: %.2f\n", s.getName(), s.getRating());

        String targetStudentName = "Нікіта";
        int targetSemester = 1;
        System.out.println("\nКурси студента " + targetStudentName + " у семестрі " + targetSemester + ":");
        for (Student s : group.getStudents()) if (s.getName().equalsIgnoreCase(targetStudentName)) for (Course c : s.getCourses()) if (c.getSemester() == targetSemester) System.out.println(c);
    }
}
