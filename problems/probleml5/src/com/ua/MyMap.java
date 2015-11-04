package com.ua;

/**
 * Created by AlxEx on 04.11.2015.
 */
public interface MyMap<K, V> {

    public <T extends K, E extends V> V put(T key, E value);

    public V get(K key);

    public V remove(K key);

    public boolean consistKey(K key);

    public boolean consistValue(V value);

    public boolean isEmpty();
}
