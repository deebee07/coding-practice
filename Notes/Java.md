**String methods:**

***String Split Function practice*** <br>
```.split("\\.")```<br>
```.split(" +")``` //Additional Space<br>
```.split(" ")``` //one Space <br>
```.split("\.")``` <br>

```String.valueOf(ca)``` //characterToString <br>
```.length()``` //gets lengthOfString <br>
```.indexOf(int ch)``` //@ch :a character <br>
```.indexOf(int ch, int strt)``` //@ch :a character @strt : the index to start the search from. <br>
```.indexOf(String str)``` // @str: a string <br>
```.indexOf(String str, int strt)``` // @str: a string @strt : the index to start the search from. <br>

```substring(int begIndex)``` //@the begin index, inclusive till end <br>
```substring(begIndex, endIndex)``` // the begin index, inclusive. the end index, exclusive. <br>


```toCharArray()``` // makes a charArray of String


***String pattern matching practice*** <br>
```.useDelimiter("\\s*fish\\s*")```
Input: "1 fish 2 fish red fish blue fish"<br>
Output:<br>
 1<br>
 2<br>
 red<br>
 blue <br>


***String Builder practice*** <br>
```new StringBuilder()``` <br>
```.append("GFG")``` <br>
```.toString()``` <br>
```.reverse()``` <br>
```.capacity()``` <br>

**Character methods:**<br>

```Character.isDigit(str.charAt(i))``` <br>
```Character.getNumericValue(digits.charAt(i))``` <br>
```Character.isLetterOrDigit()``` <br>
```Character.toLowerCase()``` <br>
```Character.toUpperCase()``` <br>


**Collections methods:**<br>

```Collections.swap(List, index1, index2)``` <br>
```Collections.swap(list, index_1, index_2)``` <br>
```Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start))```


```PriorityQueue<ListNode> queue= new PriorityQueue<ListNode>(lists.length ,(a,b) -> a.val-b.val);``` <br>
```new PriorityQueue<Integer>(Collections.reverseOrder())``` <br>

**Linked list** class offers a function that allows a **“Queue Based”** working called poll() <br>
```.poll()```  // method retrieves and removes the head (first element) of this list <br>
```.pollFirst()``` <br>
```.pollLast()``` <br>

**Linked list** its never possible to achieve this without complete traversal, but this method allows the same
```get()``` <br>
```getFirst()``` <br>
```getLast()``` <br>

**Iterator methods:**<br>
```hasNext()``` <br>
```next()``` //returns the element and moves the cursor pointer <br>
```remove()``` //This method removes the last elements returned by the iterator <br>

**ArrayList methods:** <br>
```add(Collection c)``` //Appends the specified element to the end of a list. <br>
```add(int index, Object element)```  //Inserts the specified element at the specified position. SHIFTS FORWARD OTHERS<br>
```lastIndexOf(Object o)```	//Return the index of the last occurrence of the specified element, -1 if doesnot <br>
```contains(Object o)```	 //Returns true if this list contains the specified element. <br>
**Arrays methods:**<br>

```Arrays.sort(intervals, (a, b) -> Integer.compare(a.start, b.start))``` <br>
```Arrays.asList(newInterval)``` <br>
```Arrays.toString(result)``` <br>


