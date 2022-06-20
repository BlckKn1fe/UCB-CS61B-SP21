package deque;

public class LinkedListDeque <T> implements Deque<T> {

    private int size;
    private Node<T> dummyNode;

    public LinkedListDeque() {
        this.size = 0;
        this.dummyNode = new Node<>();
        dummyNode.next = dummyNode;
        dummyNode.prev = dummyNode;
    }

    @Override
    public void addFirst(T item) {
        Node<T> n = new Node<>(item, dummyNode.next, dummyNode);
        dummyNode.next.prev = n;
        dummyNode.next = n;
        size++;
    }

    @Override
    public void addLast(T item) {
        Node<T> n = new Node<>(item, dummyNode, dummyNode.prev);
        dummyNode.prev.next = n;
        dummyNode.prev = n;
        size++;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (size > 0) {
            Node<T> cursor = dummyNode;
            while (cursor.next != dummyNode.prev) {
                sb.append(cursor.next.item.toString()).append(", ");
                cursor = cursor.next;
            }
            sb.append(cursor.item.toString());
        }
        sb.append("}");
        System.out.println(sb);
    }

    @Override
    public T removeFirst() {
        if (size > 0) {
            Node<T> removed = dummyNode.next;
            removed.next.prev = dummyNode;
            dummyNode.next = removed.next;
            removed.next = null;
            removed.prev = null;
            size--;
            return removed.item;
        }

        return null;
    }

    @Override
    public T removeLast() {
        if (size > 0) {
            Node<T> removed = dummyNode.prev;
            removed.prev.next = dummyNode;
            dummyNode.prev = removed.prev;
            removed.next = null;
            removed.prev = null;
            size--;
            return removed.item;
        }

        return null;
    }

    @Override
    public T get(int index) {
        if (size > 0 && index >= 0 && index < size) {
            Node<T> cursor = dummyNode;
            while (index-- >= 0) {
                cursor = cursor.next;
            }
            return cursor.item;
        }
        return null;
    }

    static class Node<T> {
        T item;
        Node<T> next;
        Node<T> prev;
        Node(){};
        Node(T item) { this.item = item; }
        Node(T item, Node<T> next) { this.item = item; this.next = next; }
        Node(T item, Node<T> next, Node<T> prev) { this.item = item; this.next = next; this.prev = prev; }
    }



}
