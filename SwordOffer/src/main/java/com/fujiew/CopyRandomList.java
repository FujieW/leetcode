package com.fujiew;

import com.fujiew.common.Node;

import java.util.HashMap;

/**
 * @author fujiew
 * @TODO : TODO
 * @Create on : 2020/11/10 16:28
 **/

public class CopyRandomList {
    public static void main(String[] args) {

    }

    public Node copyRandomList(Node head) {

        if (head == null) {
            return null;
        }
        HashMap<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }

        cur = head;

        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }

        return map.get(head);
    }
}
