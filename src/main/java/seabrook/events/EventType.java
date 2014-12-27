package seabrook.events;

public enum EventType {

    PROMOTION("Important news from your boss", "Congratulations on your promotion! Make sure you celebrate with a glass of wine!"),
    TASK_1("Task 1", "Congratulations on being assigned task 1!"),
    TASK_2("Task 2", "Congratulations on being assigned task 2!");

    private final String subject;
    private final String body;

    private EventType(String subject, String body) {
        this.subject = subject;
        this.body = body;
    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }
}
