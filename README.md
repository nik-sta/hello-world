# Hello-World Sample Application
Java hello-world application with spring boot for remote debugging purposes with spring boot dev tools.

## Step 1: Release your application on OpenShift
1. oc login (copy login command from your browser login in openshift)
2. docker login _*REGISTRY*_ -u _*USER*_ -p _*PASSWORD*_
3. run docker/build-and-push.sh and follow instructions

_**Hint:** Your local current branch will be deployed._

## Step 2: Forward port for Remote Debugging
```
oc port-forward <POD_NAME> -n hello-world 8000:8000
```

_**Hint:** Replace '<POD_NAME>' with your pod name from OpenShift._

## Step 3: Configure Remote Debugging in IntelliJ IDEA

![Remote Debugging Configuration](/images/remote-debugging.png)
