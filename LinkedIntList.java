import java.util.Iterator;

public class LinkedIntList {
    private ListNode front;  // first value in the list
    private ListNode back;
    private int size;

    // post: constructs an empty list
    public LinkedIntList() {
        front = null;
        back = null;
    }

    public static void main(String[] args) {
        LinkedIntList list = new LinkedIntList();
        LinkedIntList list2 = new LinkedIntList();

        list.add(0,1);
        list.add(1,2);
        list.add(2,3);
        list.add(3,2);
        list.add(4,7);

        list2.add(0,1);
        list2.add(1,2);
        list2.add(2,3);
        list2.add(3,2);
        list2.add(4,7);


      //  System.out.println((notEquals(list,list2)));
        removeRange(1,3,list);

        System.out.println(list);
        //switchPairs(list);
        //stutter(list);
       // System.out.println(list);

      //  list.set(4, 5);

       // max(list);
       // list.lastIndexOf(2, list);
       // deleteBack(list);
       // isSorted(list);

        // System.out.println(list);

       // countDuplicates(list);
    }

    // post: returns the current number of elements in the list
    public int size() {
        int count = 0;
        ListNode current = front;
        while (current != null) {
            current = current.next;
            count++;
        }
        return count;
    }

    // pre : 0 <= index < size()
    // post: returns the integer at the given index in the list
    public int get(int index) {
        return nodeAt(index).data;
    }

    // post: creates a comma-separated, bracketed version of the list
    public String toString() {
        if (front == null) {
            return "[]";
        } else {
            String result = "[" + front.data;
            ListNode current = front.next;
            while (current != null) {
                result += ", " + current.data;
                current = current.next;
            }
            result += "]";
            return result;
        }
    }

    // post : returns the position of the first occurrence of the given
    //        value (-1 if not found)
    public int indexOf(int value) {
        int index = 0;
        ListNode current = front;
        while (current != null) {
            if (current.data == value) {
                return index;
            }
            index++;
            current = current.next;
        }
        return -1;
    }

    // post: appends the given value to the end of the list
    public void add(int value) {
        if (front == null) {
            front = new ListNode(value);
            size = size + 1;
        } else {
            ListNode current = front;
            while (current.next != null) {
                current = current.next;
                size = size + 1;
            }
            current.next = new ListNode(value);
        }
    }

    // pre: 0 <= index <= size()
    // post: inserts the given value at the given index
    public void add(int index, int value) {
        if (index == 0) {
            front = new ListNode(value, front);
            size = size + 1;
        } else {
            ListNode current = nodeAt(index - 1);
            current.next = new ListNode(value, current.next);
            size = size + 1;
        }

    }

    // pre : 0 <= index < size()
    // post: removes value at the given index
    public void remove(int index) {
        if (index == 0) {
            front = front.next;
            size = size - 1;
        } else {
            ListNode current = nodeAt(index - 1);
            current.next = current.next.next;
            size = size - 1;
        }

    }

    // pre : 0 <= i < size()
    // post: returns a reference to the node at the given index
    private ListNode nodeAt(int index) {
        ListNode current = front;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }


    // Kapitel 16 opgave 1
    public void set(int index, int value) {
        ListNode current = nodeAt(index);
        current.data = value;
    }




    // Kapitel 16 opgave 2
    public static int max(LinkedIntList list) {
        if (list.isEmpty()) {
            list.next();
        }

        int maximum = 0;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > maximum) {
                maximum = list.get(i);
            }
        }
        System.out.println(maximum);
        return maximum;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // kapitel 16 opgave 3

    public static boolean isSorted(LinkedIntList list) {
        boolean sorted = false;

        int i = 0;
        for (int j = 0; j < list.size(); j++) {
            if (list.get(j) >= i) {
                i = list.get(j);
                sorted = true;
            } else {
                sorted = false;
            }

        }
        System.out.println(sorted);
        return sorted;

    }

    // kapitel 16 opgave 4

    public static int lastIndexOf(Integer value, LinkedIntList list) {
        int V = 0;
        for (int i = 0; i < list.size(); i++) {
            if (value == list.get(i)) {
                V = i;

            }

        }
        System.out.println(V);
        return V;
    }

    // kapitel 16 opgave 5

    public static int countDuplicates(LinkedIntList list) {
        LinkedIntList B = new LinkedIntList();
        int duplicates = 0;
        int K = 0;
        while (B.size() < list.size()) {
            {
                if (!B.contains(list.get(K))) {
                    B.add(K);
                } else {
                    B.add(K);
                    duplicates++;
                }
                K++;
            }
        }
        System.out.println(duplicates);
        return duplicates;
    }

    // Kapitel 16 opgave 7

    public static int deleteBack(LinkedIntList list) {
        if (list.isEmpty()) {
            Iterator it = list.iterator();

                    it.next();
        }
        int toReturn = 0;
        toReturn = list.get(list.size() - 1);
        list.remove(list.size() - 1);

        System.out.println(toReturn);
        return toReturn;
    }

    // Kapitel 16 opgave 8

    public static LinkedIntList switchPairs(LinkedIntList list)
    {


        for (int i = 0; i < list.size; i++) {
            int This = list.get(i);
            int That = list.get(i+1);

            list.set(i+1,This);

            list.set(i,That);

            i++;
        }
        System.out.println(list);
        return list;
    }

    // Kapitel 16 opgave 9

    public static LinkedIntList stutter(LinkedIntList list)
    {
        LinkedIntList list2 = new LinkedIntList();
        for (int i = 0; i < list.size ; i++) {

             list2.add(list2.size,list.get(i));
             list2.add(list2.size,list.get(i));


        }
        for (int j = 0; j < list.size;) {
         list.remove(j);

        }
        for (int k = 0; k < list2.size ; k++) {
            list.add(list2.get(k));

        }
        return list;
    }

    // Kapitel 16 opgave 15 Ikke sikker på om det er rigtigt...

    public static boolean notEquals(LinkedIntList list, LinkedIntList list2)
    {
        for (int i = 0; i < list.size ; i++) {
            if(list2.contains(list.get(i))) {

                if (list.size == list2.size) {
                    return true;
                }
            }
        }
        return false;
    }

    // kapitel 16 opgave 17

    public static LinkedIntList removeRange(int startindex,int endIndex,LinkedIntList list)
    {
        for (int i = startindex; i < endIndex ; i++) {
            list.remove(i);
        }
        return list;
    }


    public boolean contains(int value) {
        return indexOf(value) >= 0;
    }


    public boolean hasNext() {
        return false;
    }


    public Object next() {
        return null;
    }

    public Iterator  iterator() {
        return  new LinkedIterator();
    }

    private class LinkedIterator implements Iterator {
        private ListNode current;  // location of next value to return
        private boolean removeOK;  // whether it's okay to remove now

        // post: constructs an iterator for the given list
        public LinkedIterator() {
            current = front.next;
            removeOK = false;
        }



        // post: returns true if there are more elements left, false otherwise
        public boolean hasNext() {
            return current != back;
        }

        @Override
        public Object next() {
            return null;
        }


    }
}