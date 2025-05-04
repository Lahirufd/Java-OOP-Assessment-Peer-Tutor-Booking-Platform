public class SubjectSession extends Session {
    private String subjectName;

    public SubjectSession(Student student, Mentor mentor, String subjectName) {
        super(student, mentor);
        this.subjectName = subjectName;
    }

    @Override
    public String getType() {
        return "Subject 1-to-1";
    }

    @Override
    public String getDetails() {
        return "Subject: " + subjectName;
    }
}
