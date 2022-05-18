public class Student{
    String fio;
    int age;
    String class_num;
    Enum favorite_class;

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getClass_num() {
        return class_num;
    }

    public void setClass_num(String class_num) {
        this.class_num = class_num;
    }

    public Student(String fio, int age, String class_num, Enum favorite_class) {
        this.fio = fio;
        this.age = age;
        this.class_num = class_num;
        this.favorite_class = favorite_class;
    }

    @Override
    public String toString() {
        return "FIO: " + fio + " | Age: " + age + " | Class: " + class_num + " | Favorite class: " + favorite_class;
    }
}
