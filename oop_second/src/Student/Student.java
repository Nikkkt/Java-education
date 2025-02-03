package Student;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private List<Course> courses;

    public Student(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public String getName() { return name; }
    public List<Course> getCourses() { return courses; }

    public void addCourse(Course course) { courses.add(course); }

    public boolean hasUnpassedCourse() {
        for (Course c : courses) if (!c.isPassed()) return true;
        return false;
    }

    public boolean hasNoDebts() { return !hasUnpassedCourse(); }

    public double getRating() {
        int sum = 0;
        int count = 0;
        for (Course c : courses) {
            if (c.isPassed()) {
                sum += c.getGrade();
                count++;
            }
        }
        return (count > 0) ? (double) sum / count : 0;
    }

    @Override
    public String toString() { return "Student { \n\tname=" + name + ", \n\tcourses=" + courses + "\n}"; }
}
