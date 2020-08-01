package dataStructures;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/**
 * Yes, Hashing is a technique.
 * Search, Insert and Delete in O(1).
 * No duplicates allowed.
 * Binary search tree: Takes O(log n) for Search, Insert and Delete.
 *
 * When to not use hashing:
 * 1. Finding closest values.
 * 2. Keeping data in Sorted order.
 * 3. Prefix searching - TRIE data structure.
 * 1 and 2 - Use case for a self balancing B search tree.
 *
 * Probably the most used data-structure - Hash tables.
 * Commonly used: Used as Dictionaries and for indexing (Or a B tree).
 */
public class Hashing {

    public static void main(String[] args) {

        hastSet();
        hastMap();

        int[] ints = new int[]{2, 1, 2, 3, 1, 10};
        System.out.println("Distinct elemets count is: " + countDistinctElements(ints));
        findFrequency(ints);
    }

    /**
     * A typical direct address table would be an array where keys are indexes.
     * But other keys cannot be big values or float (a 20 digit number for instance) or other objects such as Strings.
     * Hence the need for hashing.

     * The idea of hashing is that, it is still backed by an array.
     * Where an key is the input to a hashing function which returns an Index of the array.
     * (Universe of keys) -> (Hash function) -> Array - Hash table.
     * The major concern
     * 1. is to ensure that collision does not occur
       (Hash function returning the same value for two or more different keys).
     * 2. The size of the hashtable is proportional to the number of entries
       (Example: When number of entries is 3, size of hashtable cannot be a lakh!).
     * Example hash function for a string, str[] = "abcd"
     * (str[0]*(x^0) + str[1]*(x^1) + str[2]*(x^2) + str[3]*(x^3)) % m, (modulo division) where m is the table size.
       Modulo division to ensure number of entries and size of the hash-table is not too far apart.

     * Universal Hashing:
     * Set of hash function, randomly pick one among them.

     * Collision handling: When 2 large keys produce the same small key (of hash-table).
     * Birthday Paradox: Among 23, probability that 2 of them have birthday on the same day is 50%
       and for 70, probability is 99.9%.
     * Collision are bound to happen! Unless the keys are known before (Perfect hashing).
     * To prevent collision:
     * 1. Chaining: Hashtable is array of linked list headers, when every collision occur,
        you add an other node to the linked list.
        Load factor = (Number of keys to be inserted/ number of slots in hash table).
        Can be specified, to specify how big the hash-table is.
        Smaller the value, smaller is the size of hash table.
     * Expected chain length = load factor (Assuming they are equally distributed among all the linked-lists.)
        Hence, expected time to search/Insert/Delete now is O(1 + Load factor).
     * Other data structures for chaining:
        1. Linked list.
        2. Dynamic sized Arrays (Array-list).
        3. Self balancing BST (AVL, Red-black tree) - Used in Java 8 for hashing.

     * 2. Open addressing.
     * Use single array, hence size of the hash table should be a minimum of number of keys.
     * Collision handling techniques:
        a. Linear probing: Linearly search for next empty spot when there is a collision.
           If last slot is occupied, start from first (Circular manner).
           Search until a key is found/ next empty slot/ all elements are traversed.
           For delete: Marking it as empty will hamper the search, hence mark it as "DELETED" and search is not stopped
            when "DELETED", but insert use "DELETED" slots.
           As the cluster size increases, the complexity increases, hence impacting performance.
           (Hash(key) + i) % m
            Primary clustering.
        b. Quadratic probing: (Hash(key) + i^2) % m - Instead going to the next slot, go to the i^2 slot.
            Secondary clusters.
            Possibility of not finding empty slots.
            Load factor = 0.5 (Hash table is double) and m is prime, then Quadratic probing is guaranteed to work.
        c. Double hashing: Hash(key, i) = (h1(key) + i*h2(key)) % m
            i*h2(key) is the offset, for linear probing - offset is 1.
            example: h1 = key % 7 and h2 = 6 - (key % 6), where size of the hashtable is 6.
            When ever a collision happens, i is incremented.
            Uses two hash functions.
            No clustering.
            If h2(key) and m are relatively prime, we will mostly find a new slot.
     *
     */
    public static void hash() {

    }

    /**
     * Hashset in JAVA.
     * Datatype cannot be primitive.
     * Order is not defined while printing contents.
     * Complexity: O(1) on an average.
     * Can only store keys.
     */
    public static void hastSet() {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("test1");
        hashSet.add("test2");
        boolean isPresent = hashSet.contains("test1");
        hashSet.remove("test1");

        Iterator<String> iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        for (String s: hashSet) {
            System.out.println(s);
        }
        hashSet.clear();
        System.out.println(hashSet.size());
    }

    /**
     * Used to store key-value pairs.
     * HashMap extends the MAP (key value) interface.
     * Order cannot be defined.
     * Put, contains, get etc have a time complexity of O(1) on Average.
     */
    public static void hastMap() {
        HashMap<String, String> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value3");
        map.remove("key2");
        System.out.println(map.size());

        for (Map.Entry<String, String> s: map.entrySet()) {
            System.out.println(s.getKey() + s.getValue());
        }
    }

    /**
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    public static int countDistinctElements(int[] ints) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i: ints) {
            hashSet.add(i);
        }
        return hashSet.size();
    }

    public static HashMap<Integer, Integer> findFrequency(int[] ints) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i: ints) {
            if (map.containsKey(i)) {
                int count = map.get(i);
                map.replace(i, count + 1);
            } else {
                map.put(i, 1);
            }
        }
        for (Map.Entry<Integer, Integer> s: map.entrySet()) {
            System.out.println(s.getKey() + " --> " + s.getValue());
        }
        return map;
    }
}
