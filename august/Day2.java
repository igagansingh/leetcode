class Day2 {
    
    /**
    * Idea:
    * 1. Have an array where each element is a List,
    *    Array will be variable in size with a load factor of 75% which means,
    *    when the capacity is filled up to 75% of the current holding capacity
    *    we double the size of current capacity.
    * 2. HashFunction, a very basic hash function based on division rule, 
    *    we divide the current key to the capacity of the array 
    *    and fetch the remainder as the index of the array. 
    *    If there is any existing list at that index we append this element to that list.
    * 
    */
    private List<Integer>[] entry;
    private final static int INITIAL_CAPACITY=1000;
    private final static double LOAD_FACTOR=0.75;
    private int capacity=INITIAL_CAPACITY;
    private int size=0;

    /** Initialize your data structure here. */
    public Day2() {
        entry = new LinkedList[INITIAL_CAPACITY];
    }
    
    public void add(int key) {
        if(!contains(key)) {
            if(size>=LOAD_FACTOR*capacity) rebalance();
            
            int index=hashCode(key);
            if(entry[index]==null) {
                entry[index]=new LinkedList<>();
            }
            entry[index].add(key);
            size+=1;        
        }
        
    }
    
    public void remove(int key) {
        if(contains(key)) {
            int index=hashCode(key);
            List<Integer> list = entry[index];
            Iterator<Integer> iterator = list.iterator();
            while(iterator.hasNext()) {
                if(iterator.next()==key)
                    iterator.remove();
            }
            size-=1;
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        if(entry[hashCode(key)]==null) return false;
        return entry[hashCode(key)].contains(key);
    }
    
    private void rebalance() {
        if(capacity>=Integer.MAX_VALUE/2) {
            return;
        }
        capacity=2*capacity;
        size=0;
        List<Integer>[] copy = entry;
        entry=new LinkedList[capacity];
        for(int i=0; i<copy.length; i++) {
            List<Integer> list=(LinkedList<Integer>)copy[i];
            if(list!=null) {
                Iterator<Integer> iterator = list.iterator();
                while(iterator.hasNext()) {
                    this.add(iterator.next());
                }
            }
        }
    }
    
    private int hashCode(int key) {
        return key%capacity;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */