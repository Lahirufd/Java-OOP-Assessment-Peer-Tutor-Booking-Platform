import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookingPlatform {

    // Static collections to manage data
    public static List<Student> students = new ArrayList<>();
    public static List<Mentor> mentors = new ArrayList<>();
    public static List<Session> sessions = new ArrayList<>();
    public static Map<Integer, User> userMap = new HashMap<>();

    public static void main(String[] args) {
        // Test: Creating users and adding to collections
        Student s1 = new Student("Alice", "alice@student.com");
        Mentor m1 = new Mentor("Bob", "bob@mentor.com");

        // Add to relevant collections
        students.add(s1);
        mentors.add(m1);

        // Add to userMap for quick lookup
        userMap.put(s1.getId(), s1);
        userMap.put(m1.getId(), m1);

        // Output for verification
        System.out.println("Student created: " + s1.getName() + ", ID: " + s1.getId());
        System.out.println("Mentor created: " + m1.getName() + ", ID: " + m1.getId());

        // Notify test
        s1.notify("Welcome to the platform!");
        m1.notify("You have been registered as a mentor.");
    }
}
