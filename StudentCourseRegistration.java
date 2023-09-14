import java.util.ArrayList;
import java.util.List;

class Course {
    private String code;
    private String title;
    private String description;
    private int capacity;
    private String schedule;
    private List<Student> enrolledStudents;

    public Course(String code, String title, String description, int capacity, String schedule) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
        this.enrolledStudents = new ArrayList<>();
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getSchedule() {
        return schedule;
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public boolean addStudent(Student student) {
        if (enrolledStudents.size() < capacity) {
            enrolledStudents.add(student);
            return true;
        }
        return false;
    }

    public void removeStudent(Student student) {
        enrolledStudents.remove(student);
    }
}

class Student {
    private int id;
    private String name;
    private List<Course> registeredCourses;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Course> getRegisteredCourses() {
        return registeredCourses;
    }

    public void registerCourse(Course course) {
        registeredCourses.add(course);
        course.addStudent(this);
    }

    public void dropCourse(Course course) {
        registeredCourses.remove(course);
        course.removeStudent(this);
    }
}

public class StudentCourseRegistration {
    public static void main(String[] args) {
        // Creating courses
        Course course1 = new Course("CS101", "Intro to Programming", "Introduction to Java programming", 30, "MWF 9:00 AM");
        Course course2 = new Course("MATH202", "Calculus II", "Advanced calculus topics", 25, "TTh 11:00 AM");

        // Creating students
        Student student1 = new Student(1, "John Doe");
        Student student2 = new Student(2, "Jane Smith");

        // Registering students for courses
        student1.registerCourse(course1);
        student1.registerCourse(course2);
        student2.registerCourse(course1);

        // Displaying course details
        System.out.println("Available courses:");
        System.out.println(course1.getCode() + " - " + course1.getTitle() + " (" + course1.getEnrolledStudents().size() + "/" + course1.getCapacity() + ")");
        System.out.println(course2.getCode() + " - " + course2.getTitle() + " (" + course2.getEnrolledStudents().size() + "/" + course2.getCapacity() + ")");

        // Displaying registered courses for each student
        System.out.println("\nRegistered courses:");
        for (Course course : student1.getRegisteredCourses()) {
            System.out.println(course.getCode() + " - " + course.getTitle());
        }

        for (Course course : student2.getRegisteredCourses()) {
            System.out.println(course.getCode() + " - " + course.getTitle());
        }

        // Dropping a course
        student1.dropCourse(course1);

        // Displaying updated course details
        System.out.println("\nUpdated course details:");
        System.out.println(course1.getCode() + " - " + course1.getTitle() + " (" + course1.getEnrolledStudents().size() + "/" + course1.getCapacity() + ")");
    }
}
