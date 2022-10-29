package HW9;

public class MyStack <T> {

        private int size;
        private T[] stackArray;
        private int top;

        public MyStack(int size) {
            this.size = size;
            stackArray = (T[]) new Object[size];
            top = -1;
        }


    public void push(T element) {
        stackArray[++top] = element;
    }
    public void remove(int index){

    }
    public void clear(){
            size = 0;
    }
    int size() {
        return top+1;
    }
    public T peek(){
        return stackArray[top];
    }
    public T pop(){
            return stackArray[top--];
    }

}
