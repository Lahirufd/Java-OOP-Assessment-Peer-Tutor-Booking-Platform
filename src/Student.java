public class Student extends User implements Notifiable{

    private String major;
    public Student(String name, String major) {
        super(name);
        this.major = major;
    }

    public String getMajor() {
        return major;
    }

    @Override
    public String getRole() {
        return "Student";
    }

    @Override
    public String toString() {
        return "Student[ID=" + getId() + ", Name=" + getName() +
                ", Major=" + major + "]";
    }

    @Override
    public void notify(String message) {
        System.out.println("Notification for Student " + getName() + ": " + message);
    }
}