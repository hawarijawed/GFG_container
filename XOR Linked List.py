'''
An ordinary Doubly Linked List requires space for two address fields to store the addresses of previous and next nodes. A memory-efficient version of the Doubly Linked List can be created using only one space for the address field with every node. This memory-efficient Doubly Linked List is called XOR Linked List or Memory Efficient as the list uses bit-wise XOR operation to save space for one address.
Given a stream of data of size N for the linked list, your task is to complete the function insert() and getList(). The insert() function pushes (or inserts at the beginning) the given data in the linked list and the getList()  function returns the linked list as a list.
Note:
A utility function XOR() takes two Node pointers to get the bit-wise XOR of the two Node pointers. Use this function to get the XOR of the two pointers.
The driver code prints the returned list twice, once forward and once backwards.
'''
def insert(head, data):
    ptr=Node(data)
    if head == None:
       head=ptr
    else:
        ptr.npx=head
        head=ptr
    return ptr
        
    
def getList(head):
    ans=[]
    while head != None:
        ans.append(head.data)
        head=head.npx
    return ans
