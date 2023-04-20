# algorithm-and-data-structures-java
用Java实现经典的算法与数据结构。

## Array 动态数组

- [Array](https://github.com/Chanmoey/algorithm-and-data-structures-java/blob/main/src/main/java/com/moon/classicalalgorithm/array/Array.java)

动态数组，当容量不足时，自动扩容，当容量减少到1/4缩容到原来的1/2。避免震荡。

- [FastArray](https://github.com/Chanmoey/algorithm-and-data-structures-java/blob/main/src/main/java/com/moon/classicalalgorithm/array/FastArray.java)

继承自Array，添加了两个新方法。

所谓Fast，在于Array添加和删除元素的时候，会进行元素的移动，所以复杂度为O(n)。

而FastArray在添加数组的时候，addWithSwitch(i, e)，将原来i位置的元素移动到size的位置，再插入e，这样
复杂度为O(1)。但这样就不保证用户的插入顺序了。

## LinkedList 链表

- [DoubleLinkedList](https://github.com/Chanmoey/algorithm-and-data-structures-java/blob/main/src/main/java/com/moon/classicalalgorithm/linkedlist/DoubleLinkedList.java)

双向链表

- [LinkedList](https://github.com/Chanmoey/algorithm-and-data-structures-java/blob/main/src/main/java/com/moon/classicalalgorithm/linkedlist/LinkedList.java)

单向链表

- [LinkedListDfs](https://github.com/Chanmoey/algorithm-and-data-structures-java/blob/main/src/main/java/com/moon/classicalalgorithm/linkedlist/LinkedListDfs.java)

单向链表，采用递归的方式操作链表节点，对于线性数据结构来说，递归不是一个非常好的方式，容易爆栈。

- [LinkedListWithTail](https://github.com/Chanmoey/algorithm-and-data-structures-java/blob/main/src/main/java/com/moon/classicalalgorithm/linkedlist/LinkedListWithTail.java)

单向链表，但是添加了尾指针，方便O(1)实现队列和栈。

