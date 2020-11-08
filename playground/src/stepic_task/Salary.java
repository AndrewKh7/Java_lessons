package stepic_task;

public class Salary {
    private String from;
    private String to;
    private int Content;

    public Salary(String from, String to, int mes) {
        this.from = from;
        this.to = to;
        this.Content = mes;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public int getContent() {
        return Content;
    }
}
