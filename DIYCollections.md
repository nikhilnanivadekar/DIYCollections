# Overview
1) Types of Maps (Chaining vs Open Address)
 - now while constructing the map, since keys are unique they need to be 
 allocated in their correct places
 - this is handled by the `hash` of the key
 - hash is the integer representation of an object, this representation can be small or large
 - most common map implementations, use a hash function on top of the hash to scale the number
   to fit the map, thereby finding the location in the map where the key can be placed
 - Now this leads to interesting scenarios, because, more than 1 key can have the same hash
 - but we need the uniqueness to be maintained at a key level
 - So, this leads to what we call as collision of keys
 - There are multiple ways of handling collisions, but I will be using Map implementations which handle collisions using:
    a) Chaining: If a colliding key is found, then, the keys are placed in a LinkedList or List, and then uniqueness 
    is defined for each element of the list
    b) Open Addressing: If a colliding key is found, then, the key is placed in the next available open slot
2) Implement Bag
 - Bag or a MultiSet, is similar to a shopping bag or a basket, where for 1 article there can be 1 or more quantity
 - Example: 12 Apples, 6 Bananas, 1 Orange, etc
 - At the end of the day all we need is a Mapping of an article/object to the quantity
 - Let us develop it using TDD approaches. We are going to use the ObjectIntMap from Eclipse Collections
 - The ObjectIntMap is interesting because it gives us some API which we will look in a bit
 - But more importantly the value is an int, as in a primitive Java int, so we avoid the burden of boxing and unboxing and save memory
 - Alright, enough of me talking, let us start with some code. We will develop this using TDD approach. So first, what do I need?
 - Yes let us create a BagTest
3) Implement Bag specific API 
    - getOccurrences
    - add
    - addOccurrences
    - remove
    - removeOccurrences
    
Quick Recap of what we did so far:
  - Implemented a wrapper on top of a Map which will store Key to Count relationship
  - This wrapper is called as a Bag or a MultiSet
  - Implemented basic API like add(), addOccurrences(), remove(), removeOccurrences()
  - Tested that it works
  - Next steps... Take a look at the Bag specific API in Eclipse Collections: http://www.eclipse.org/collections/javadoc/9.2.0/org/eclipse/collections/api/bag/Bag.html
  - Other libraries like: Guava, Trove, etc. also have Bag implementations


4) Implement Multimap
5) Initialization and null safety for values
6) How to preserve backing collection semantics with minimal code
7) Implement Multimap specific API 
    - put/add
    - putAll/addAll
    - remove
    - removeAll

Recap:
 - Implemented 2 Multimaps (or MultiValuedMaps) where the value collections were either List or Set
 - Centralized the common code such that the List and Set backed implementations were cleaner
 - Possible to further change it by using default methods
 - Removal is as complicated as addition
 - Take care of the initialization and null safety

# If time permits
8) add vs put? How to name?
