
class Queues
{
    Queue<Integer> q1 = new LinkedList<Integer>();
    Queue<Integer> q2 = new LinkedList<Integer>();
    
    //Function to push an element into stack using two queues.
    void push(int a)
    {
	    // Your code here	
	    q1.offer(a);
    }
    
    //Function to pop an element from stack using two queues. 
    int pop()
    {
	    // Your code here
	    int size = q1.size();
	    if(size == 0) return -1;
	    
	    for(int i=0;i<size-1;i++){
	        q2.offer(q1.poll());
	    }
	    
	    int num = q1.poll();
	    
	    while(!q2.isEmpty()){
	        q1.offer(q2.poll());
	    }
	    
	    return num;
    }
	
}