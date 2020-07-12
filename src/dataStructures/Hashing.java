package dataStructures;

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
     */
    public static void hash() {

    }
}
