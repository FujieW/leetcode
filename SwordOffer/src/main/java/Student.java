import java.util.Date;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2021/3/2 10:52
 **/
public class Student implements Comparable<Student> {

    private String name;
    private Integer age;
    private Date birthday;

    public Student(){}

    public Student(String name, Integer age, Date birthday){
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public void set(Date birthday){
        this.birthday = birthday;
    }

    public Date getBirthday(){
        return this.birthday;
    }

    public void set(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void set(Integer age){
        this.age = age;
    }

    public Integer getAge(){
        return this.age;
    }

    @Override
    public int compareTo(Student o) {
        Student temp = (Student) o;
        return this.getBirthday().compareTo(temp.getBirthday());
    }

}
