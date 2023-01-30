import static java.lang.reflect.Array.newInstance;

public class ArrayList<T> {
    private T[] t;

    //constructor
    public ArrayList(T[] st){
        //initialising the T Array and filling it with the Array from the Parameters if possible
        t = (T[]) newInstance(st.getClass().getComponentType(), st.length);
        if(st.length != 0)
            for (int i = 0; i < st.length; i++) {
                t[i] = st[i];
            }
    }


    //adding a new index to the arraylist and filling it with the input form the parameters
    public void pushback(T e){
        T[] ts = (T[]) newInstance(t.getClass().getComponentType(), t.length + 1);
        for (int i = 0; i < t.length; i++) {
            ts[i] = t[i];
        }
        ts[ts.length - 1] = e;
        t = ts;
    }

    //adding a new index to the front of the arraylist and filling it with the input form the parameters
    public void pushfront(T e) {
        T[] ts = (T[]) newInstance(t.getClass().getComponentType(), t.length + 1);
        for (int i = 0; i < t.length; i++) {
            ts[i + 1] = t[i];
        }
        ts[0] = e;
        t = ts;

    }

    //adding a new index in the arraylist at the place specified in the parameters and filling it with the input form the parameters
    public void pushto(T e, int index) {
        T[] ts = (T[]) newInstance(t.getClass().getComponentType(), t.length + 1);
        if(index <= size() || index < 0) {
            int count = 0;
            for (int i = 0; i < ts.length; i++) {
                if (i != index) {
                    ts[i] = t[count];
                    count++;
                }
            }
            ts[index] = e;
            t = ts;
        } else
            try {
                throw new ListIndexOutOfBoundsException("index " + index + " out of bounds for length " + size());
            }catch(ListIndexOutOfBoundsException x){
                x.printStackTrace();
            }
    }

    //deleting an index specified in the parameters from the array list
    public void delete(int index) {
        T[] temp = (T[]) newInstance(t.getClass().getComponentType(), t.length - 1);
        if(index < size() || index < 0) {
            t[index] = null;
            int count = 0;
            for (int i = 0; i < t.length; i++) {
                if(t[i] != null) {
                    temp[count] = t[i];
                    count++;
                }
            }
            t = temp;
        }else
            try {
                throw new ListIndexOutOfBoundsException("index " + index + " out of bounds for length " + size());
            }catch(ListIndexOutOfBoundsException e){
                e.printStackTrace();
            }
    }

    //returning the value of an index specified in the parameters
    public T value(int i) {
        if(i < t.length)
            return t[i];
        else
            try {
                throw new ListIndexOutOfBoundsException("index " + i + " out of bounds for length " + size());
            }catch(ListIndexOutOfBoundsException e){
                e.printStackTrace();
            }
        return null;
    }

    //returning the size of the arraylist
    public int size(){
        return t.length;
    }

    //printing the arraylist
    public void print(){
        String str = "";
        for (T t : t){
            System.out.print("(" + t + ")");
        }
        System.out.println();
    }

    //returning an array of the type specified when creating the object that is filled with the contends of the arraylist
    public T[] toArray(){
        T[] ts = (T[]) newInstance(t.getClass().getComponentType(), t.length);
        for (int i = 0; i < ts.length; i++) {
            ts[i] = t[i];
        }
        return ts;
    }

    public void set(T input, int index) throws ListIndexOutOfBoundsException {
        if(index < t.length)
            t[index] = input;
        else
            throw new ListIndexOutOfBoundsException("index " + index + " out of bounds for length " + size());
    }

    public void clear(){
        t = (T[]) newInstance(t.getClass().getComponentType(), 0);
    }

    public boolean isEmpty(){
        return t.length > 0;
    }

    public void clearNull(){
        int count = 0;
        for (T i : t)
            if(i == null)
                count++;
        T[] temp = (T[]) newInstance(t.getClass().getComponentType(), t.length - count);
        count = 0;
        for (int i = 0; i < t.length; i++) {
            if(t[i] != null){
                temp[count] = t[i];
                count++;
            }
        }
        t = temp;
    }
}
