package HW9;

import java.util.Objects;

public class MyLinkedList <T> {
    private T element;
    private int size;
    static class Node <T>{
        T element;
        Node <T> next;
        Node <T> prev;
        Node( T element) {
            this.element = element;
        }
    }
    private Node<T> first;
    private Node<T> last;



    public void add(T element) {
        Node <T> newNode = new Node<>(element);
        if(first==null){
           first=last= newNode ;
        }else{
     last.next = newNode;
     last = newNode;
    }
        size++;
    }

    public  T remove(int index) {
        T removedElement;
        if (index == 0) {
            removedElement = first.element;
            first = first.next;
            if(first==null){
                last=null;
            }
        } else {
        Objects.checkIndex(index, size);
        Node<T> prev = getNode(index - 1);
        removedElement = prev.next.element;
        prev.next = prev.next.next;
        if(index==size-1){
            last=prev;
        }
    }
        size--;
        return removedElement;
    }

    public void clear() {
       first=last=null;
       size = 0;
    }

    public int size() {
    return size;
    }

    public T get(int index) {
    return getNode(index).element;
    }
    private Node<T> getNode(int index){
        Node<T>current = first;
        for(int i = 0;i<index;i++){
            current = current.next;
        }
        return current;
    }

}