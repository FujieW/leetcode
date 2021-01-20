import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2021/1/18 16:13
 **/

public class ProducerConsumer {
    public static void main(String[] args) {

        MessageQueue messageQueue = new MessageQueue(2);

        for (int i = 0; i < 3; i++) {
            int id = i;
            new Thread(() -> {
                messageQueue.put(new Message(id, "值" + id));
            }, "生产者[" + i + "]").start();
        }

        new Thread(() -> {
            try {
                while (true) {
                    TimeUnit.SECONDS.sleep(1);
                    Message message = messageQueue.take();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }, "消费者").start();
    }

}

class MessageQueue {

    private LinkedList<Message> list = new LinkedList<>();
    private int CAPACITY = 10;

    public MessageQueue(int CAPACITY) {
        this.CAPACITY = CAPACITY;
    }

    // 取出消息
    public Message take() {
        // 如果仓库为空
        synchronized (list) {
            while (list.isEmpty()) {
                try {
                    System.out.println("队列为空, 消费者线程等待");
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // 从对头取出数据
            Message message = list.removeFirst();
            System.out.println("已消费消息" + message);
            list.notifyAll();
            return message;
        }

    }

    // 放入消息
    public void put(Message message) {
        // 检查仓库是否已满
        synchronized (list) {
            while (list.size() >= CAPACITY) {
                try {
                    System.out.println("队列已满, 生产者线程等待");
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // 将数据添加进队尾
            list.addLast(message);
            System.out.println("以生产消息" + message);
            list.notifyAll();
        }
    }

}

final class Message {
    private int id;
    private Object value;

    public Message(int id, Object value) {
        this.id = id;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public Object getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", value=" + value +
                '}';
    }
}
