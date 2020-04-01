 enum DayOfWeek{
    MONDAY(40),
    TUESDAY(32),
    WEDNESDAY(24),
    THURSDAY(16),
    FRIDAY(8),
    SATURDAY(0),
    SUNDAY(0);

    private int workingHours;


    DayOfWeek(int workingHours){
        this.workingHours = workingHours;
    }

    public String getWorkingHours() {
        StringBuffer str = new StringBuffer("До конца рабочей недели  часов");
        if (this.workingHours == 0)
            return "Сегодня выхожной!";
        else
            return str.insert(24, this.workingHours).toString();
    }
}

public class EnumTask {
    public static void main(String[] args) {
        System.out.println(DayOfWeek.MONDAY.getWorkingHours());
        System.out.println(DayOfWeek.TUESDAY.getWorkingHours());
        System.out.println(DayOfWeek.WEDNESDAY.getWorkingHours());
        System.out.println(DayOfWeek.THURSDAY.getWorkingHours());
        System.out.println(DayOfWeek.FRIDAY.getWorkingHours());
        System.out.println(DayOfWeek.SATURDAY.getWorkingHours());
        System.out.println(DayOfWeek.SUNDAY.getWorkingHours());
    }
}
