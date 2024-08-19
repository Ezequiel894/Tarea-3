import java.util.List;

public class Main {
    public static void main(String[] args) {
        StudentManagerImpl manager = new StudentManagerImpl();

        // Agregar estudiantes
        manager.addStudent(new Student(1, "Alice", 22));
        manager.addStudent(new Student(2, "Bob", 20));
        manager.addStudent(new Student(3, "Charlie", 23));

        // Mostrar todos los estudiantes
        System.out.println("All Students:");
        manager.getAllStudents().forEach(System.out::println);

        // Filtrar estudiantes mayores de 21 años
        System.out.println("\nStudents older than 21:");
        manager.getStudentsAboveAge(21).forEach(System.out::println);

        // Ordenar estudiantes por nombre
        System.out.println("\nStudents sorted by name:");
        manager.getStudentsSortedByName().forEach(System.out::println);

        // Buscar estudiante
        try {
            Student student = manager.findStudent(2);
            System.out.println("\nFound Student with ID 2: " + student);
        } catch (StudentNotFoundException e) {
            System.err.println(e.getMessage());
        }

        // Eliminar estudiante
        manager.removeStudent(2);

        // Mostrar todos los estudiantes después de eliminar
        System.out.println("\nAll Students after removal:");
        manager.getAllStudents().forEach(System.out::println);
    }
}
