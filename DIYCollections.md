Nikhil J. Nanivadekar
@NikhilNanivade
eclipse.org/collections

https://github.com/nikhilnanivadekar/DIYCollections

Do It Yourself: Collections

------------------------------------------------------------
1) What are collections: 
 - List: ordered collection, which allows duplicates
 - Set: hashed collection, which retains only unique elements
 - Map: mapping of key to value

2) We want to create a new data structure:
 - List, Set, Map
 
3) What is a multimap?

Map<Key, Collection<Values>>

Collection of multiple Key, Value Pairs

- What should happen if the value collection is empty or null?
- What should happen if the value collection has duplicates?

The Key is not stored if the value collection is empty

It depends on the backing Collection

IN the last 40 mins we created 3 wrappers on the Map:
- Bag
- ListMultimap
- SetMultimap



