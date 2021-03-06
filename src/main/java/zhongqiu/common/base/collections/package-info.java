/*
 * @author zhongqiu
 * 参考资料：http://blog.csdn.net/fyang2007/article/details/51517662
 * （1）集合中的List：arrayList，linkedList,vector，stack
       【ArrayList implements List,RandomAccess】【List extends Collection】【Collection extends Iterable】
       【RandomAccess接口，一种标记接口，支持随机访问随机访问任意下标元素都比较快，根据是否实现了该接口采用不同的算法】
       【集合类是RandomAccess的实现，则尽量用for(int i = 0; i < size; i++) 来遍历而不要用Iterator迭代器来遍历】
       【核心变量】Object[] elementData【存放数据】，size【已经存放的数据数量】，modCount【用于快速失败】
       【核心方法】copyOf(T[] original, int newLength)
                  System.arraycopy(Object src,  int  srcPos,Object dest, int destPos, int length)
                  ensureCapacityInternal(int minCapacity)：
                       判断数组是否为默认容量数组，是的话取minCapacity=Math.max(DEFAULT_CAPACITY, minCapacity)
                       modCount++。grow方法扩容为原来的1.5倍,newCapacity = oldCapacity + (oldCapacity >> 1)
                       生成扩容后的新数组 elementData=Arrays.copyOf(elementData, newCapacity)，
                       System.arraycopy(original, 0, copy, 0,Math.min(original.length, newLength))
                  add：ensureCapacityInternal(size + 1)；elementData[size++] = e
                  add(int index, E element)
                  addAll(Collection<? extends E> c)
                  addAll(int index, Collection<? extends E> c),
                  remove(int index),remove(Object o),fastRemove(index),clear
                  iterator()   class Itr implements Iterator:
                                    cursor【下一个要返回的index】,lastRet【最后一个返回的index】,
                                    expectedModCount【期望的modcount，用于快速失败】
                                    hasNext()，next(),remove(int index),checkForComodification()
                  listIterator()  class ListItr extends Itr implements ListIterator<E>
                                        hasPrevious()，previous()，set(E e)，add(E e)
       【LinkedList<E> implements List<E>, Deque<E>】【Deque extends Queue】【Queue extends Collection】
           【核心变量】size【已存储的元素数量】,Node first【首节点】,Node last【尾节点】,modCount【用于快速失败】
           【核心方法】linkLast(E e),linkFirst(e),linkBefore(E e, Node<E> succ),
                      node(int index),unlink(Node<E> x),indexOf(o)
           【list核心方法】get(int index),set(int index, E element),add(E e),add(int index, E element)
                          addAll(Collection<? extends E> c),addAll(int index, Collection<? extends E> c)
                          remove(int index),remove(Object o),clear(),contains(Object o)，toArray()
           【Deque核心方法】添加：add=offer(E e)==offerLast(E e),offerFirst(E e)，
                           获取：peek(),poll()==pollFirst(),pollLast()
           【Stack核心用法】添加：push(E e)
                           获取：peek(),pop()
           【iterator】内部类class ListItr implements ListIterator<E>
                       Node lastReturned,Node next,nextIndex,expectedModCount
                       next,previous,remove,set,add
       【Vector<E> extends AbstractList<E> implements List<E>, RandomAccess, Cloneable, java.io.Serializable】
            内部使用数组存储，实现同ArrayList。通过对方法添加关键字synchronized实现线程安全。
            Itr和elements(),内部也都使用了关键字synchronized确保线程安全
       【Stack extends Vector】添加：push，获取：pop，peek，search
 * （3）Collections 提供了很多对list的操作：排序，混排，替换，复制，最大最小值，移动list中元素位置
                    Collections.synchronizedList。装饰器模式。遍历器遍历的时候，需要手动加锁
                    Collections.synchronizedSet
                    Collections.synchronizedMap
 * （4）集合中的Arrays类，对数组的各种操作。binarySearch，sort，fill，equals，asList，tostring，hashcode，copyof
 * （6）集合中的Set：hashset,LinkedHashSet，treeset，二叉树排序，自定义排序
 * （7）集合中的Map：HashMap,TreeMap
       【应用】统计字符串中每个字符出现的次数。统计字符串中的大写，小写，数字，其他字符个数。统计字符串中子字符串出现的次数
       【HashMap】【HashMap implements Map】
          【内部实现】HashMap是数组+链表+红黑树(链表长度大于8转换为红黑树)；链地址法解决hash冲突
          【核心变量】threshold(resize阈值),loadFactor(加载因子，默认0.75),
                     modCount(用于遍历器快速失败),size(已经存储的键值对数量),Node<K,V>[] table(保存Node<K,V>节点的数组)
          【核心方法】【jdk 1.7】
                   put，inflateTable,roundUpToPowerOf2，initHashSeedAsNeeded,
                        putForNullKey,遍历table[0]是否已存在null的key,不存在addEntry,
                        hash,indexFor，遍历table[i]是否已存在key，不存在addEntry,
                        addEntry(int hash, K key, V value, int bucketIndex)，
                        resize(2 * table.length)，transfer，
                        hash，indexFor，createEntry(hash, key, value, bucketIndex);
                   get,getForNullKey,getEntry，
                   containsKey,getEntry,
                   remove(Object key)，removeEntryForKey，hash,indexFor,遍历table[i]，
                   clear，Arrays.fill(table, null);
                   entrySet，keySet，values,abstract class HashIterator implements Iterator,
                   Entry<K,V> next;Entry<K,V> current;int index;expectedModCount,
          【核心方法】【jdk 1.8】
                【put】1、tab为空，resize()扩容  2、确认槽位 i = (tab.length - 1) & hash
                      3、tab[i]为空，newNode，放到tab[i]位置。
                      4、tab[i]不为空，从头结点开始遍历链表，遍历过程中把每一个节点的key和value和newNode比较
                         如果完全相等，if (!onlyIfAbsent || oldValue == null)，替换旧节点。
                         调用钩子方法afterNodeAccess(e); return oldValue
                      5、所有节点遍历一遍，都没有发现完全相同的节点，把newNode连接到链表的尾部。p.next=newNode
                         判断，如果连边长度超过8，改为红黑树结构代替链表。treeifyBin(tab, hash)
                         ++modCount; if (++size > threshold); resize()扩容;
                         调用钩子方法afterNodeInsertion(evict); 原HashMap中不存在相同的key，return null
                【treeifyBin】改为红黑树结构代替链表。自平衡的二叉查找树。
       【TreeMap】【TreeMap implements NavigableMap】【NavigableMap extends SortedMap】【SortedMap extends Map】
       【Hashtable】【Hashtable extends Dictionary implements Map】【synchronized内置锁保证线程安全】
                    【Hashtable和hashmap的差别：线程安全，key和value不能为null，获取index实现不一样】
 */
package zhongqiu.common.base.collections;