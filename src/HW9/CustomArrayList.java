package HW9;

import java.util.Objects;

public class CustomArrayList <T> {

    public static final int DEFAULT_CAPACITY = 5;
    private Object[] elements;
    private int size;

    public <T> CustomArrayList(int initCapacity) {
        if (initCapacity <= 0) {
            throw new IllegalArgumentException();
        }
        elements = new Object[initCapacity];
    }
    //додає елемент в кінець
    public void add(T value) {
        if (elements.length == size) {
            Object[] newArray = new Object[elements.length];
            System.arraycopy(elements, 0, newArray, 0, size);
        }
        elements[size] = value;
        size++;

    }

    //видаляє елемент з вказаним індексом
    public T remove(int index) {
        Objects.checkIndex(index, size);
        T removedElement = (T) elements[index];
        System.arraycopy(elements, index + 1, elements, index, size = index - 1);
        size--;
        return removedElement;
    }

    //очищає колекцію
    public void clear() {
        size = 0;
        elements = new Object[DEFAULT_CAPACITY];
    }

    public int size() {
        return elements.length;
    } //повертає розмір колекції

    //повертає елемент по індексу
   public T get(int index) {
        Objects.checkIndex(index, size);
        return (T) elements[index];
    }
}

