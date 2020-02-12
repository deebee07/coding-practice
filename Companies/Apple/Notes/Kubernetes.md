Python/Shell Scripting

Expertise with Kubernetes: write & troubleshoot micro services deployments as well as more complex workloads on K8.

Thorough understanding of building and running containers.

https://kubernetes.io/docs/tutorials/kubernetes-basics/deploy-app/deploy-intro/



**Kubernetes Deployments**

**Kubernetes Cluster**
have a running Kubernetes cluster, you can deploy your containerized applications on top of it.

Create a Kubernetes Deployment configuration; the Deployment instructs Kubernetes how to create and update instances of your application.

Once the application instances are created, **a Kubernetes Deployment Controller** continuously monitors those instances.

If the Node hosting an instance goes down or is deleted, the **Deployment controller** replaces the instance with an instance on another Node in the cluster.


**This provides a self-healing mechanism to address machine failure or maintenance.**

NOTE NO LONGER HAPPENS: installation scripts would often be used to start applications, but they did not allow recovery from machine failure. By both creating your application instances and keeping them running across Nodes, Kubernetes Deployments provide a fundamentally different approach to application management.

The Deployment controller replaces the instance with an instance on another Node in the cluster. A Deployment is responsible for creating and updating instances of your application. 

To view the nodes in the cluster, run the kubectl get nodes command:
kubectl get nodes --help

kubectl version

Deploy app:
kubectl create deployment

kubectl create deployment


Pods that are running inside Kubernetes are running on a private, isolated network. 

By default they are visible from other pods and services within the same kubernetes cluster but not outside that network

**The kubectl command can create a proxy that will forward communications into the cluster-wide, private network.**

kubectl proxy
https://kubernetes.io/docs/tutorials/kubernetes-basics/explore/explore-intro/

Node:
    Volume
    Containerized App
    node processes (kubelet, docker)


Troubleshoot:

kubectl get (list resources pods/deployments/replicaset) <br>
kubectl describe (list resources pods/deployments/replicaset) <br>
kubectl logs (print the logs from a container in a pod) <br>
kubectl exec (execute a command on a container in a pod)

You can use these commands to see when applications were deployed, what their current statuses are, where they are running and what their configurations are.

A Pod always runs on a Node. A Node is a worker machine in Kubernetes and may be either a virtual or a physical machine, depending on the cluster. 

Liveness Probe <br>
Readiness Probe <br>
Horizontal Pod Scaling <br>
Vertical Pod Scaling <br>
