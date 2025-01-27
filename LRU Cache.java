/*
Design a data structure that works like a LRU Cache. Here cap denotes the capacity of the cache and Q denotes the number of queries. Query can be of two types:

PUT x y: sets the value of the key x with value y
GET x: gets the key of x if present else returns -1.
The LRUCache class has two methods get() and put() which are defined as follows.

get(key): returns the value of the key if it already exists in the cache otherwise returns -1.
put(key, value): if the key is already present, update its value. If not present, add the key-value pair to the cache. If the cache reaches its capacity it should remove the least recently used item before inserting the new item.
In the constructor of the class the capacity of the cache should be initialized.
*/
// design the class in the most optimal way

class LRUCache {
    class Node{
        int value;
        int key;
        Node prev, next;
        public Node(int key, int value){
            this.value = value;
            this.key  = key;
        }
        
    }
    
    HashMap<Integer, Node> cache = new HashMap<>();
    int capacity;
    Node head, tail;
    
    // Constructor for initializing the cache capacity with the given value.
    LRUCache(int cap) {
        // code here
        this.capacity = cap;
        cache = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        
    }

    // Function to return value corresponding to the key.
    public int get(int key) {
        // your code here
        if(cache.containsKey(key)){
            Node temp = cache.get(key);
            //Recently used -> update the position to front
            moveToFront(temp);
            return temp.value;
        }
        
        return -1;
    }

    // Function for storing key-value pair.
    public void put(int key, int value) {
        // your code here
        //Check if it exists or not
        if(cache.containsKey(key)){
            Node temp = cache.get(key);
            //Update the node value
            temp.value = value;
            
            moveToFront(temp); //Move it to front as recently used
        }
        else{
            //First check size
            if(cache.size() >= capacity){
                removeLRU(); //Delete tail of DLL
            }
            
            Node temp = new Node(key, value);
            cache.put(key, temp);
            addNode(temp);
        }
    }
    
    public void moveToFront(Node node){
        
        removeNode(node);//remove from the tail
        addNode(node);//Add it to the front
    }
    
    //Removes the second next of tail node in DLL
    public void removeLRU(){
        Node lru = tail.prev;
        removeNode(lru);  // Remove the LRU node
        cache.remove(lru.key);
    }
    //Adds the node right after the head
    public void addNode(Node node){
        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
        head.next = node;
    }
    
    //Removes the node from DLL
    public void removeNode(Node node){
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }
}
