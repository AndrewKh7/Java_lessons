package stepic_task;

public class MailMessage {

    private String from;
    private String to;
    private String Content;

    public MailMessage(String from, String to, String mes) {
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

    public String getContent() {
        return Content;
    }
}
