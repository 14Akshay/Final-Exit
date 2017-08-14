public class LinkedList<T> {

	LinkedNode<?> head;

	public LinkedNode<Comparable<?>> addNewNodeFront(LinkedNode<Comparable<?>> head, T data)
	{
		LinkedNode<Comparable<?>> firstNode = new LinkedNode((Comparable) data);
		firstNode.next = head;
		return firstNode;
	}

	public LinkedNode<Comparable<?>> reverse(LinkedNode<Comparable<?>> head)
	{
		LinkedNode<Comparable<?>> prev = null, next = null, current = head;
		while (current != null)
		{
			next = (LinkedNode<Comparable<?>>) current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		return prev;
	}

	public LinkedNode<Comparable<?>> reverseRecursive(LinkedNode<Comparable<?>> head)
	{
		LinkedNode<Comparable<?>> prev = null;
		if (head.next == null)
			return head;
		prev = reverseRecursive((LinkedNode<Comparable<?>>) head.next);
		head.next.next = head;
		return prev;
	}

	/* we can do this by single pointer also
	   initialize mid element as head and initialize a counter as 0. 
	   Traverse the list from head, while traversing increment the counter and change mid to mid->next whenever the counter is odd. 
	   So the mid will move only half of the total length of the list. */
	public LinkedNode<Comparable<?>> findMidNode(LinkedNode<Comparable<?>> head)
	{
		LinkedNode<Comparable<?>> fast = head;
		LinkedNode<Comparable<?>> slow = head;
		while (fast != null && fast.next != null)
		{
			slow = (LinkedNode<Comparable<?>>) slow.next;
			fast = (LinkedNode<Comparable<?>>) fast.next.next;
		}
		return slow;
	}

	public LinkedNode<Comparable<?>> deleteNode(LinkedNode<Comparable<?>> head, T data)
	{
		LinkedNode<Comparable<?>> temp = head, prev = null, next = null;
		while (head.data != data)
		{
			prev = head;
			head = (LinkedNode<Comparable<?>>) head.next;
		}
		next = (LinkedNode<Comparable<?>>) head.next;
		prev.next = next;
		return temp;
	}

	public void printListIterative(LinkedNode<Comparable<?>> head)
	{
		while (head != null && head.next != null)
		{
			System.out.print((head.data).toString() + "-->");
			head = (LinkedNode<Comparable<?>>) head.next;
		}
		System.out.print((head.data));
	}

	//we can do with hashmap also
	public boolean isLoopExist(LinkedNode<Comparable<?>> head) { // this is Flyod's algorithm
		LinkedNode<Comparable<?>> fast = (LinkedNode<Comparable<?>>) head, slow = head;
		while (fast != null && fast.next != null) {

			fast = (LinkedNode<Comparable<?>>) fast.next.next;
			slow = (LinkedNode<Comparable<?>>) slow.next;
			/*if (fast!=null && slow!=null && fast.data == slow.data) {*/
			if (fast!=null && slow!=null && fast == slow) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isLoopExistExtraBitApproach(LinkedNode<Comparable<?>> head) { //isvisited extra bit method
		LinkedNode<Comparable<?>> temp =head;
		while(temp!=null)
		{
			if(temp.isVisited)
				return true;
			temp.isVisited=true;
			temp=(LinkedNode<Comparable<?>>) temp.next;
		}		
		return false;
	}
	
	public LinkedNode<Comparable<?>> isLoopExistReturnStrartingNode(LinkedNode<Comparable<?>> head) { 
		LinkedNode<Comparable<?>> fast = (LinkedNode<Comparable<?>>) head, slow = head;
		while (fast != null && fast.next != null) {

			fast = (LinkedNode<Comparable<?>>) fast.next.next;
			slow = (LinkedNode<Comparable<?>>) slow.next;
			if (fast!=null && slow!=null && fast.data == slow.data) {
				slow=head;
				while(true)
				{
					slow=(LinkedNode<Comparable<?>>) slow.next;
					fast=(LinkedNode<Comparable<?>>) fast.next;
					if(fast.data == slow.data)
					{
						return slow;
					}
					
				}
				
			}
		}
		
		return null;
	}

	public void printListRecursive(LinkedNode<Comparable<?>> head)
	{
		if (head == null)
			return;
		System.out.print((head.data).toString());
		if (head.next != null)
		{
			System.out.print("-->");
		}
		printListRecursive((LinkedNode<Comparable<?>>) head.next);
		/* System.out.print((head.data)); */
	}

	public LinkedNode<Comparable<?>> addNewNodeLast(LinkedNode<Comparable<?>> head, T data)
	{
		LinkedNode<Comparable<?>> temp = head;
		if (head == null)
			return new LinkedNode((Comparable) (data));
		while (head.next != null)
		{
			head = (LinkedNode<Comparable<?>>) head.next;
		}
		head.next = new LinkedNode((Comparable) data);
		return temp;
	}
	
	public LinkedNode<Comparable<?>> createNewNode(T data)
	{
		
		LinkedNode<Comparable<?>> test = new LinkedNode((Comparable) data);
		return test;
	}

	public LinkedNode<Comparable<?>> lastTofirst(LinkedNode<Comparable<?>> head)
	{
		LinkedNode<Comparable<?>> temp = head, prev = null;
		while (head != null && head.next != null)
		{
			prev = head;
			head = (LinkedNode<Comparable<?>>) head.next;
		}
		prev.next = null;
		head.next = temp;
		return head;
	}

	public LinkedNode<Comparable<?>> kthNodeFromEnd(LinkedNode<Comparable<?>> head, int k)
	{
		LinkedNode<Comparable<?>> temp = head;
		while (k > 0)
		{
			head = (LinkedNode<Comparable<?>>) head.next;
			k--;
		}
		while (head != null)
		{
			temp = (LinkedNode<Comparable<?>>) temp.next;
			head = (LinkedNode<Comparable<?>>) head.next;
		}
		return temp;
	}

	public static void main(String args[])

	{

		/*
		 * LinkedList<String> l1= new LinkedList<>();
		 * 
		 * l1.head=l1.addNewNodeFront(null, "a");
		 * 
		 * l1.head=l1.addNewNodeFront((LinkedNode<Comparable<?>>) l1.head, "k");
		 * 
		 * l1.head=l1.addNewNodeFront((LinkedNode<Comparable<?>>) l1.head, "s");
		 * 
		 * l1.head=l1.addNewNodeFront((LinkedNode<Comparable<?>>) l1.head, "h");
		 * 
		 * System.out.println();
		 */

		LinkedList<String> l1 = new LinkedList<>();

		l1.head = l1.addNewNodeLast(null, "a");

		l1.head = l1.addNewNodeLast((LinkedNode<Comparable<?>>) l1.head, "k");

		l1.head = l1.addNewNodeLast((LinkedNode<Comparable<?>>) l1.head, "s");

		l1.head = l1.addNewNodeLast((LinkedNode<Comparable<?>>) l1.head, "h");

		l1.head = l1.addNewNodeLast((LinkedNode<Comparable<?>>) l1.head, "p");

		l1.head = l1.addNewNodeLast((LinkedNode<Comparable<?>>) l1.head, "y");

		// loop is exist or not
		
	     LinkedNode<Comparable<?>> count = (LinkedNode<Comparable<?>>) l1.head; 
	      LinkedNode<Comparable<?>> temp3=null;
	      int x=0;
	      
		  while(count.next!=null) {
			  if(x==2)
				  temp3=(LinkedNode<Comparable<?>>)count.next;
		  count=(LinkedNode<Comparable<?>>)count.next; 
		  x++;
		  } 
		  count.next=temp3;
		 

		/*
		 * System.out.println();
		 * 
		 * l1.head=l1.reverse((LinkedNode<Comparable<?>>) l1.head);
		 * 
		 * System.out.println();
		 * 
		 * LinkedNode<Comparable<?>>
		 * mid=l1.findMidNode((LinkedNode<Comparable<?>>) l1.head);
		 * 
		 * System.out.println();
		 * 
		 * LinkedNode<Comparable<?>>
		 * deletedList=l1.deleteNode((LinkedNode<Comparable<?>>) l1.head, "h");
		 * 
		 * System.out.println();
		 * 
		 * //l1.printListIterative((LinkedNode<Comparable<?>>) l1.head);
		 * 
		 * l1.printListRecursive((LinkedNode<Comparable<?>>) l1.head);
		 * 
		 * System.out.println();
		 * 
		 * l1.head=l1.lastTofirst((LinkedNode<Comparable<?>>) l1.head);
		 */

		//l1.printListRecursive((LinkedNode<Comparable<?>>) l1.head);

		System.out.println();

		// LinkedNode<Comparable<?>> kthNode =
		// l1.kthNodeFromEnd((LinkedNode<Comparable<?>>) l1.head, 5);

		// System.out.println(kthNode.data);

		  System.out.println(l1.isLoopExist((LinkedNode<Comparable<?>>) l1.head));
		//System.out.println(l1.isLoopExistExtraBitApproach((LinkedNode<Comparable<?>>) l1.head));
		//LinkedNode<Comparable<?>> startNode= l1.isLoopExistReturnStrartingNode((LinkedNode<Comparable<?>>) l1.head);
		System.out.println();
	}

}