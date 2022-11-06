package HW9;



public class MyQueue<T> {
    private T[] queue;
    private int maxSize; // максимальное количество элементов в очереди
    private int nElem;  // текущее количество элементов в очереди
    private int front;
    private int rear;

    public MyQueue(int maxSize) {
        this.maxSize = maxSize;
        queue = (T[]) new Object[maxSize];
        rear = -1;
        front = 0;
        nElem = 0;
    }

    public void add(T value) {
        queue[++rear] = value;
        nElem++;
    }

    public void remove(int index) {
        System.arraycopy(queue, index + 1, queue, index, nElem= index - 1);

    nElem--;
    }

    public void clear(){
        queue = (T[]) new Object[0];
    }

    public int size() {
        return nElem;
    }

    public T peek() {
        return queue[front];
    }

    public T poll() {
        T temp = queue[front++];

        if (front == maxSize) {
            front = 0;
        }
        nElem--;
        return temp;
    }
}
