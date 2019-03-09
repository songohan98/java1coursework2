package uk.ac.ucl.bag;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.Collection;


public class MapBag<T extends Comparable> extends AbstractBag<T> {
    private int maxSize;
    private HashMap<T, Integer> contents;
    private int size = 0;

    public MapBag() throws BagException {
        this(MAX_SIZE);
    }

    public MapBag(int maxSize) throws BagException {
        if (maxSize > MAX_SIZE) {
            throw new BagException("Attempting to create a Bag with size greater than maximum");
        }
        if (maxSize < 1) {
            throw new BagException("Attempting to create a Bag with size less than 1");
        }
        this.maxSize = maxSize;
        this.contents = new HashMap<>();
    }
//final version
    /*
    edited
    with all errors sorted
     */
    @Override
    public void add(T value) throws BagException {
        if (!contents.containsKey(value)) {
            contents.put(value, 1);
            size++;
        } else {
            if (size() < maxSize) {
                contents.put(value, contents.get(value) + 1);
            } else {
                throw new BagException("Bag is full");
            }
        }
    }

    @Override
    public void addWithOccurrences(T value, int occurrences) throws BagException {
        for (int i = 0; i < occurrences; i++) {
            add(value);
        }

    }

    @Override
    public boolean contains(T value) {
        return contents.containsKey(value);
    }

    @Override
    public int countOf(T value) {
        if (contents.containsKey(value)) {
            return contents.get(value);
        }
        return 0;
    }

    @Override
    public void remove(T value) {
        if (contents.containsKey(value)) {
            contents.remove(value);
        } else
            System.out.println("The value doesn't exist");

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    private class MapBagUniqueIterator implements Iterator<T> {
        private int index = 0;

        @Override
        public boolean hasNext() {

            return index < contents.size();
        }

        List keys = new ArrayList(contents.keySet());

        @Override
        public T next() {
            return (T) keys.get(index++);
        }
    }

    public Iterator<T> iterator() {
        return new MapBagUniqueIterator();
    }

    private class MapBagIterator implements Iterator<T> {
        private int index = 0;
        private int count = 0;
        Set contentSet = contents.keySet();
        Collection contentValue = contents.values();
        List<T> keys = new ArrayList<T>(contentSet);
        List<Integer> values = new ArrayList<Integer>(contentValue);

        @Override
        public boolean hasNext() {
            if (index < size()) {
                if (count < values.get(index)) {
                    return true;
                }
            }
            return false;
        }

        public T next() {
//            System.out.println("..:.." + contentValue);
//            for (T key : keys)
//            {
//                System.out.print(" ,: " +key);
//            }
            if (count < values.get(index)) {
                T value = keys.get(index);
                count++;

                if(count == values.get(index)) {
                    count = 0;
                    index++;
                }
                return value;
            } else {
                throw new IllegalStateException();
            }

        }
    }


    @Override
    public Iterator<T> allOccurrencesIterator() {
        return new MapBagIterator();
    }


}
