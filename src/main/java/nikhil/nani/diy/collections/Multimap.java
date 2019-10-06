package nikhil.nani.diy.collections;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public abstract class Multimap<K, V>
{
    protected Map<K, Collection<V>> backingMap = new HashMap<>();

    protected abstract Collection<V> getEmptyBackingCollection();

    public Collection<V> get(K key)
    {
        // TODO implement get
        return this.backingMap.getOrDefault(key, this.getEmptyBackingCollection());
    }

    public boolean put(K key, V value)
    {
        // TODO implement put
        Collection<V> values = this.backingMap.get(key);
        if (values == null)
        {
            values = this.getEmptyBackingCollection();
            this.backingMap.put(key, values);
        }
        return values.add(value);
    }

    public Collection<V> putAll(K key, Iterable<V> values)
    {
        // TODO implement putAll
        Collection<V> existingValue = this.backingMap
                .getOrDefault(key, this.getEmptyBackingCollection());
        for (V value : values)
        {
            existingValue.add(value);
        }

        return existingValue;
    }

    public Collection<V> removeAll(K key)
    {
        // TODO implement removeAll
        return this.backingMap.remove(key);
    }

    public boolean remove(K key, V value)
    {
        // TODO implement remove
        Collection<V> existing = this.backingMap.getOrDefault(key, this.getEmptyBackingCollection());
        if (!existing.isEmpty())
        {
            boolean removed = existing.remove(value);
            if (removed && existing.isEmpty())
            {
                this.backingMap.remove(key);
            }
            return removed;
        }
        return false;
    }
}
