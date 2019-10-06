package nikhil.nani.diy.collections;

import java.util.HashSet;
import java.util.Set;

public class SetMultimap<K, V> extends Multimap<K, V>
{
    public SetMultimap()
    {
    }

    @Override
    protected Set<V> getEmptyBackingCollection()
    {
        return new HashSet<>();
    }
}
