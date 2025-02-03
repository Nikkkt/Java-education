package Student;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private String groupName;
    private List<Student> students;

    public Group(String groupName) {
        this.groupName = groupName;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) { students.add(student); }

    public String getGroupName() { return groupName; }
    public List<Student> getStudents() { return students; }
}
