public abstract class Session {

    private int sessionId;
    private Student student;
    private Mentor mentor;
    private static int nextSessionId = 1;

    public Session(Student student, Mentor mentor) {
        this.student = student;
        this.mentor = mentor;
        this.sessionId = nextSessionId++;
    }

    public int getSessionId() {
        return sessionId;
    }

    public Student getStudent(){
        return student;
    }

    public Mentor getMentor(){
        return mentor;
    }

    public abstract String getType();

    public abstract String getDetails();

    @Override
    public String toString() {
        return "Session#" + sessionId + " (" + getType() + " - " + getDetails() +
                ") [Student: " + student.getName() + ", Mentor: " + mentor.getName() + "]";
    }
}
