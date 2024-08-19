import java.util.List;
import java.util.stream.Collectors;

public class StudentManagerImpl implements StudentManager {
    private GenericList<Student> studentList;

    public StudentManagerImpl() {
        this.studentList = new GenericList<>();
    }

    @Override
    public void addStudent(Student student) {
        studentList.add(student);
    }

    @Override
    public void removeStudent(int id) {
        Student student = studentList.find(id, Student::getId);
        if (student != null) {
            studentList.remove(student);
        }
    }

    @Override
    public Student findStudent(int id) throws StudentNotFoundException {
        Student student = studentList.find(id, Student::getId);
        if (student == null) {
            throw new StudentNotFoundException("Student with ID " + id + " not found.");
        }
        return student;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentList.getItems();
    }

    public List<Student> getStudentsAboveAge(int age) {
        return studentList.getItems().stream()
                .filter(student -> student.getAge() > age)
                .collect(Collectors.toList());
    }

    public List<Student> getStudentsSortedByName() {
        return studentList.getItems().stream()
                .sorted((s1, s2) -> s1.getName().compareTo(s2.getName()))
                .collect(Collectors.toList());
    }
}
