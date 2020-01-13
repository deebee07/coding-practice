## Steps for a System-Design Question

#### Step 1: Requirements clarifications
    Gives understanding on scope of the problem.
    Clarifying Ambiguities early is CRITICAL.
    Define the end-goals of the system.

Design Twitter:
Will tweets contain photos and videos?
Are we focusing on the backend only or are we developing the front-end too?
Will users be able to search tweets?
Do we need to display hot trending topics?
Will there be any push notification for new (or important) tweets?

#### Step 2: Back-of-the-envelope estimation

    estimate the scale of the system.
    scaling, partitioning, load balancing and caching.

network bandwidth usage are we expecting? This will be crucial in deciding how we will manage traffic and balance load between servers.
how much storage will we need? We will have different storage requirements if users can have photos and videos in their tweets.
What scale is expected from the system (e.g., number of new tweets, number of tweet views, number of timeline generations per sec., etc.)?


#### Step 3: System interface definition
    APIs are expected


#### Step 4: Defining data model

Which database system should we use? Will NoSQL like Cassandra best fit our needs, or should we use a MySQL-like solution? What kind of block storage should we use to store photos and videos?

#### Step 5: High-level design

Geographic Load Balancing

#### Step 6: Detailed design

massive amount of data, how should we partition our data to distribute it to multiple databases
Since users’ timeline will contain the most recent (and relevant) tweets, should we try to store our data in such a way that is optimized for scanning the latest tweets?

#### Step 7: Identifying and resolving bottlenecks
enough replicas of the data so that if we lose a few servers

single point of failure in our system? What are we doing to mitigate it

How are we monitoring the performance of our service

alerts whenever critical


## Key Characteristics of Distributed Systems


Scalability

Reliability

Availability

Efficiency

Manageability