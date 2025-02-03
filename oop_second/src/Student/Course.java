package Student;

public class Course {
    private String courseName;
    private int semester;
    private boolean passed;
    private int grade;

    public Course(String courseName,
                  int semester,
                  boolean passed,
                  int grade) {
        this.courseName = courseName;
        this.semester = semester;
        this.passed = passed;
        this.grade = grade;
    }

    public String getCourseName() { return courseName; }
    public int getSemester() { return semester; }
    public boolean isPassed() { return passed; }
    public int getGrade() { return grade; }

    @Override
    public String toString() { return "Course { \n\tname=" + courseName + ", \n\tsemester=" + semester + ", \n\tpassed=" + passed + ", \n\tgrade=" + grade + "\n}"; }
}
