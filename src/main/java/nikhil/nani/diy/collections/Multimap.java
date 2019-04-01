package nikhil.nani.diy.collections;

import java.util.Collection;

import org.eclipse.collections.api.map.MutableMap;
import org.eclipse.collections.impl.factory.Maps;
import org.eclipse.collections.impl.utility.Iterate;

public abstract class Multimap<K, V>
{
    protected MutableMap<K, Collection<V>> backingMap = Maps.mutable.empty();

    protected abstract Collection<V> getEmptyBackingCollection();

    protected MutableMap<K, Collection<V>> getBackingMap()
    {
        return this.backingMap;
    }

    public void put(K key, V value)
    {
        Collection<V> values = backingMap.getIfAbsentPut(key, this.getEmptyBackingCollection());
        values.add(value);
    }

    public Collection<V> get(K key)
    {
        return backingMap.getIfAbsentValue(key, this.getEmptyBackingCollection());
    }

    public Collection<V> removeAll(K key)
    {
        return this.backingMap.removeKey(key);
    }

    public boolean remove(K key, V value)
    {
        Collection<V> existing = this.backingMap.getIfAbsentValue(key, this.getEmptyBackingCollection());
        if (!existing.isEmpty())
        {
            boolean removed = existing.remove(value);
            if (removed && existing.isEmpty())
            {
                this.backingMap.removeKey(key);
            }
            return removed;
        }
        return false;
    }

    public Collection<V> putAll(K key, Iterable<V> values)
    {
        Collection<V> value = this.backingMap.getIfAbsentPut(key, this::getEmptyBackingCollection);
        Iterate.addAllIterable(values, value);

        return value;
    }
}
