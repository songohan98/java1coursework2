package uk.ac.ucl.bag;

import java.util.Iterator;

public class LinkedListBag<T extends Comparable> extends AbstractBag<T> {


    private static class Element<E extends Comparable> {
        public E value;
        public int occurrences;
        public Element<E> next;

        public Element(E value, int occurrences, Element<E> next) {
            this.value = value;
            this.occurrences = occurrences;
            this.next = next;
        }
    }

    private Element<T> head;
    private int size = 0;


    private int maxSize;

    public LinkedListBag() throws BagException {
        this(MAX_SIZE);
    }

    public LinkedListBag(int maxSize) throws BagException {
        if (maxSize > MAX_SIZE) {
            throw new BagException("Attempting to create a Bag with size greater than maximum");
        }
        if (maxSize < 1) {
            throw new BagException("Attempting to create a Bag with size less than 1");
        }
        this.maxSize = maxSize;
    }

    public Element<T> getPosition(int index) {
        Element<T> position = head;
        if (index == 0) {
            return position;
        }
        if (index != 0)
            for (int i = 0; i < index; i++) {
                position = position.next;
            }
        return position;
    }

    public Element<T> getValue(T value)
    {
       Element<T> position = head;
       while(position != null)
       {
           T itemAtPosition = position.value;
           if(itemAtPosition.equals(value))
               return position;
           position = position.next;
       }
       return null;
    }

    public void FirstAdd(T value)
    {
        Element<T> position = head;
        if(position == null){
            head = new Element<>(value,1,null);
        }
    }

    public void AddtoEnd(T value)
    {
        Element<T> position = head;
        Element<T> lastpositon = new Element<T>(value,1,null);
        while(position!=null){
            position = position.next;
        }
        position.next = lastpositon;
    }

//    @Override
//    public void add(T value) throws BagException {
//        Element<T> position = head;
//        T itemAtPosition;
//        if(position==null){
//            FirstAdd(value);
//            size++;
//        }
//        if (contains(value)) {
//            while (position != null) {
//                itemAtPosition = position.value;
//                if (itemAtPosition.equals(value))
//                    position.occurrences++;
//                position = position.next;
//            }
//            if (size < maxSize) {
//                if (position != null) {
//                    AddtoEnd(value);
//                    size++;
//                }
//            } else {
//                throw new BagException("Bag is Full");
//            }
//        }
//    }
//@Override
//public void add(T value) throws BagException {
//    Element<T> position = head;
//    T itemAtPosition;
//
//    if (position == null) {
//        head = new Element<T>(value, 1, null);
//        size++;
//    }
//    else if (position.next != null) {
//
//        if (contains(value)) {
//            while (position.next != null) {
//                itemAtPosition = position.value;
//                if (itemAtPosition.equals(value)) {
//                    position.occurrences++;
//                } else {
//                    position = position.next;
//                }
//            }
//        }else if(!contains(value)){
//            if (size < maxSize) {
//                position.next = new Element<T>(value, 1, null);
//            }
//        }
//        else {
//            throw new BagException("Bag is full");
//        }
//
//    }
//}



    @Override
    public void add(T value) throws BagException {
        Element<T> position = head;
        T itemAtPosition;

        if (position == null) {
            head = new Element<T>(value, 1, null);
            size++;
        }
        else {
            boolean end = false;
            while (position != null) {
                if (position.value.equals(value)) {
                    position.occurrences++;
                    end = true;
                    break;
                }
                position = position.next;
            }
            if (!end) {
                if (size < maxSize) {
                    head = new Element<>(value, 1, head);
                    size++;
                } else {
                    throw new BagException("Bag is full");
                }
            }


//            if (contains(value)) {
//                while (position != null) {
//                    itemAtPosition = position.value;
//                    if (itemAtPosition.equals(value))
//                        position.occurrences++;
//                    position = position.next;
//                }
//            }
//            else if (!contains(value)) {
//

//                if (size < maxSize) {
//                    while (position != null) {
//                        position = position.next;
//                }
//                    position = new Element<>(value,1,null);
//                    size++;
//            }


        }


    }

    @Override
    public void addWithOccurrences(T value, int occurrences) throws BagException {
        for (int i = 0; i < occurrences; i++) {
            add(value);
        }
    }

    public boolean contains(T value) {
        Element<T> position = head;
        T itemAtPosition;
        while (position != null) {
            itemAtPosition = position.value;
            if (itemAtPosition.equals(value)) {
                return true;
            }
            position = position.next;
        }
        return false;
    }


    @Override
    public int countOf(T value) {
        Element<T> position = head;
        T itemAtPosition;
        while (position != null) {
            itemAtPosition = position.value;
            if (itemAtPosition.equals(value))
                return position.occurrences;
            position = position.next;
        }
        return 0;
    }


    public void remove(T value) {
        Element<T> position = head;
        if (contains(value)) {
            T itemAtPosition;
            while (position != null) {
                itemAtPosition = position.value;
                if (itemAtPosition.equals(value)) {
                    position.occurrences--;
                    if (position.occurrences == 0) {
                        position = position.next;
                    }
                }
                position = position.next;
            }

        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        Element<T> position = head;
        return position == null;
    }

    private class LinkedListUniqueBagIterator implements Iterator<T> {

        Element<T> current = head;

        @Override
        public boolean hasNext() {
            return (current != null);
        }

        @Override
        public T next() {
            T output = current.value;
            current = current.next;
            return (output);

        }
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListUniqueBagIterator();
    }

    private class LinkedListBagIterator implements Iterator<T> {
        private int index = 0;
        private int count = 0;



        @Override
        public boolean hasNext() {
            if (index < size) {
                if (count < getPosition(index).occurrences) return true;
                if ((count == getPosition(index).occurrences) && ((index + 1) < size)) return true;
            }
            return false;
        }

        @Override
        public T next() {
            if (count < getPosition(index).occurrences) {
                T value = getPosition(index).value;
                count++;
                return value;
            }
            count = 1;
            index++;
            return getPosition(index).value;
        }
    }

    @Override
    public Iterator<T> allOccurrencesIterator() {
        return new LinkedListBagIterator();
    }

    @Override
    public void removeAllCopies() {
        Element<T> position = head;
        while (position != null)
        {
            position.occurrences = 1;
            position = position.next;

        }

    }


}





