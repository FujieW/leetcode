import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2021/3/2 10:33
 **/
public class Test {
    public static void main(String[] args) throws InterruptedException {
        List<Student> students = new ArrayList<>();
        Student student1 = new Student("ww", 1, new Date());
        TimeUnit.SECONDS.sleep(1);
        Student student2 = new Student("ff", 2, new Date());
        TimeUnit.SECONDS.sleep(2);
        Student student3 = new Student("jj", 3, new Date());
        students.add(student1);
        students.add(student3);
        students.add(student2);

        Collections.sort(students);

        for (Student student : students) {
            System.out.println(student.getName()+student.getBirthday());
        }

    }
    public boolean hasDubNum(int[] nums){
        int i  = 0;
        while(i< nums.length){
            if(nums[i]!=i){
                // 进行交换
                int temp = nums[i];
                nums[i] = nums[nums[i]];
                nums[nums[i]] = temp;
            } else{
                i++;
            }
            if(nums[i] == nums[nums[i]]){
                return true;
            }
        }
        return false;
    }

}
