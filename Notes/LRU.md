https://www.openmymind.net/High-Concurrency-LRU-Caching/


Most common way of implementing an LRU cache is to use:
    1. a hashtable for lookups.
    2. a linked list to track when items were used.

**Concurrency**

**Granular locks** are key to achieving high throughput.
**If you had a single lock for the entire cache, you'd end up serializing access to it. NOT EVEN WORTH IT**



As a first step:
    we can create a separate read-write mutex for our hashtable and our list.

**Hashtable**

A read-write mutex for the hashtable is efficient.

Assuming that we are GETing more than we are SETting, we'll mostly be acquiring read-locks (which multiple threads can secure)

only time we need a write lock is when setting an item


**SHARD YOUR HASHTABLE TO REDUCE WRITE LOCKS**

List
Concurrent access of our list is a much bigger challenge. 


https://stackoverflow.com/questions/221525/how-would-you-implement-an-lru-cache-in-java


**Window**


  c.lookupLock.RLock()
  item := c.lookup[key]
  c.lookupLock.RUnlock()



c.lookupLock.Lock()
defer c.lookupLock.Unlock()


https://stackoverflow.com/questions/25079093/lock-writes-to-hashmap
