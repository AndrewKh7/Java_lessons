
public class MainClass {
    public static void main(String[] args) {
        Employee[] employee = new Employee[5];
        employee[0] = new Employee("Серябрикова Зиаида Ивановна", 55, "school5SZI@mail.ru", "+78923454333","Учитель Истории", 25.0f);
        employee[1] = new Employee("Карпатин Олег Александрович", 38, "school5KOA@mail.ru", "+79216457342","Учитель Физики", 26.0f);
        employee[2] = new Employee("Шугалькина Елена Петровна", 43, "school5ShEP@mail.ru", "+79556783541","Учитель Английского", 28.0f);
        employee[3] = new Employee("Голубин Евгений Перович", 49, "school5GEP@mail.ru", "+9216548378","Учитель труда", 18.0f);
        employee[4] = new Employee("Агулина Екатерина Сергеева", 37, "school5AES@mail.ru", "+79217772211","Директор", 150.0f);

        for(Employee person: employee)
            if( person.getAge() > 40)
                person.printInfo();
        }
}

class Employee{
    String fullName;
    int age;
    String email;
    String telephone;
    String position;
    float salary;

    public Employee(String fullName, int age, String email, String telephone, String position, float salary) {
        this.fullName = fullName;
        this.age = age;
        this.email = email;
        this.telephone = telephone;
        this.position = position;
        this.salary = salary;
    }

    public void printInfo(){
        System.out.println(this.fullName + "; " + this.age + "; " + this.email + "; " + this.telephone + "; " + this.position + "; " + this.salary);
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }
}
