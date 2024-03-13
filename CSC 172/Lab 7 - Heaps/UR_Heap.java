// LAUREL TAY RAEANNE
// LTAY3@U.ROCHESTER.EDU
// CSC172 LAB 7
// NOVEMBER 4TH 2023

public interface UR_Heap<T extends Comparable<T>> {
    public void insert(T item);
    public boolean isEmpty();
    public int size();
    public T deleteMin();
}

