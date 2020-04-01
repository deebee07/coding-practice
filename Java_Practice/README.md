# Java String Object (Non-primitive data type)
* String is ```Immutable``` because String objects are cached in ```String pool```.<br/>
Note: CACHED String Literals are shared between multiple clients (Risk: One client's action would affect all other client)
*



# Java Memory Management: (STACK and HEAP)

https://www.linkedin.com/learning/java-ee-concurrency-and-multithreading/welcome
-Xmx10m (10 MB Maximum Heap size)

## STACK and HEAP
* ```Local Primitive Variables``` & ```References to object``` (i.e. variable declared in method) are stored in STACK. 
* ```All Objects``` are stored in HEAP.
* Local variables are stored on the stack.(```VARIABLES``` are a reference to the ```OBJECT```)


## GARBAGE COLLECTION
* VisualVM Launcher Plugin for IntelliJ IDEA.
* ```jvisualvm``` in the bin of jdk. Add Plugin Visual GC
* `https://www.eclipse.org/mat/ [Heap Dump Analyzer]
* Apache JMeter


* String pools
``` 
String one = "hello";
String two = "hello";
  // if (one == two) would return true As these variables reference to same String Object
String three = new Integer(76).toString();
String four = "76";
  // if (three == four) would return false As these variables reference to same String Object
String three = new Integer(76).toString().intern(); [Saves creation of duplicate Objects]
String four = "76";
// if (three == four) would return true with .intern() method as it puts in String pool
```

* Garbage Eligibility
  * C Language has free() method. Objects that are NOT freed continue to consume memory. ```Memory Leak```
  * Java is a managed language. Avoids memory leak:
    * Running on a virtual machine (JVM)
    * Adopts a Garbage Collection strategy [Any object in HEAP that isnt referenced by Stack]
    ```
    Runtime runtime = Runtime.getRuntime();
    long availableBytes = runtime.freeMemory();
    System.out.println("Available memory: " + availableBytes / 1024 + "k");
    
    // let's create a ton of garbage....
		Customer c;
		for (int i=0; i<1000000; i++)
		{
			c = new Customer("John");	
		}
    availableBytes = runtime.freeMemory();
		System.out.println("Available memory: " + availableBytes / 1024 + "k");
    System.gc(); // Dont run, forcing isnt right, just to learn
    
    availableBytes = runtime.freeMemory();
		System.out.println("Available memory: " + availableBytes / 1024 + "k");
    ```
    ```
    public void finalize() // A method of Object shouldnt be used as gc can happen at anytime.
    ```
  * Java can still have Soft leaks: An object referenced on the stack even though it will never be used again.
  

* Generational Garbage Collection (Way of Organizing Heap)
	* Young generation (Eden then (Survivor) S0 then S1, has to survive 8 Versions) and Old generation <br/>
	* Heap Dump (Memory Analyzer)<br/>
	* PermGen and MetaSpace (Java6 had PermGen[It is never Garbage collected])<br/>
	* Start and Stop Tomcat for each deployment or else your PermGen space would be used up<br/>
	* Internalized Strings nolonger part of PermGen space. Java 7+ doesnt have PermSpace but MetaSpace<br/>

* Tuning the Virtual Machine (Java VM)
	* -Xmx (Maximum Heap memory size)
	* -Xms (Starting Heap memory size)<br/>
	* https://docs.oracle.com/cd/E13222_01/wls/docs81/perform/JVMTuning.html <br/>
	* -XX:MaxPermSize (Size of PermGen not part in Java 8) </br>
	* --verbose:gc (Young gen 1/3rd of total heap by default -Xmn [Size of Young gen]) <br/>
	* HEAP DUMP: --XX:HeapDumpOnOutOfMemory (Creates a Heap Dump File) <br/>
	* Oracle VM has 3 types of Garbage Collector:
		* Serial Collector [Single thread] ```-XX:+UseSerialGC``` <br/>
		* Parallel Collector [All thread] ```-XX:+UseParallelGC``` <br/>
		* Mostly Concurrent Collector [Closest to real-time no specific pause time needed] <br/>
			* --XX:+UseConcMarkSweepGC or --XX:+UseG1GC <br/>
		Get current GC: --XX:PrintCommandLineFlags
													
	
	

