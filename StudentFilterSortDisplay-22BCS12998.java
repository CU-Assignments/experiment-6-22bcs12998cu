import java.util.*;
import java.util.stream.*;

class Student {
    String name;
    double marks;

    public Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public double getMarks() {
        return marks;
    }

    @Override
    public String toString() {
        return name + " - " + marks + "%";
    }
}

public class StudentFilterSortDisplay {
    public static void main(String[] args) {
    
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alia", 82.5));
        students.add(new Student("Boby", 65.0));
        students.add(new Student("Chintu", 90.0));
        students.add(new Student("Divya", 72.5));
        students.add(new Student("Emilly", 78.0));

        System.out.println("Students scoring above 75%, sorted by marks:");
        
        students.stream()
                .filter(student -> student.getMarks() > 75) 
                .sorted(Comparator.comparingDouble(Student::getMarks).reversed()) 
                .map(Student::getName) 
                .forEach(System.out::println); 
    }
}
