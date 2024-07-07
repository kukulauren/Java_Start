public class Student {
    private final String id;
    private final String name;
    private final int age;
    private final String grade;
    public Student(String id, String name, int age, String grade){
        this.name=name;
        this.id=id;
        this.age=age;
        this.grade=grade;
    }
    public int getAge(){
        return age;
    }
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGrade() {
        return grade;
    }
}
