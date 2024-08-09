/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ADT;

import java.util.Iterator;

/**
 *
 * @author USER
 * @param <T>
 */
public interface SortedListSetInterface<T extends Comparable<T>> {

    public boolean add(T newEntry);

    public boolean remove(T anEntry);

    public boolean contains(T anEntry);
    
    public T getLastEntries();

    public int getNumberOfEntries();

    public boolean isEmpty();

    public void clear();

    public Iterator<T> getIterator();
}
