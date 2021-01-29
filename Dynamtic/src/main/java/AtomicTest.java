import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.function.IntUnaryOperator;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2021/1/25 15:47
 **/
public class AtomicTest {
    public static void main(String[] args) {

        Student student = new Student();

        AtomicReferenceFieldUpdater<Student, String> updater =
                AtomicReferenceFieldUpdater.newUpdater(Student.class, String.class, "name");

        updater.compareAndSet(student, null, "Tom");

        System.out.println(student);

    }

}

class Student {
    volatile String name;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}