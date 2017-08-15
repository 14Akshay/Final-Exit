package LinkedList;

import java.util.PriorityQueue;

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

	public LinkedNode<Comparable<?>> reverseRecursive(LinkedNode<Comparable<?>> head,LinkedNode<Comparable<?>> prev)
	{
	    LinkedNode<Comparable<?>> node = null;
		if (head.next == null)
		{
			head.next=prev;
			return head;
		}
		LinkedNode<Comparable<?>> next =(LinkedNode<Comparable<?>>) head.next;
		head.next=prev;
		node = reverseRecursive((LinkedNode<Comparable<?>>)next,head);
		
		return node;
	}

	/* we can do this by single pointer also
	   initialize mid element as head and initialize a counter as 0. 
	   Traverse the list from head, while traversing increment the counter and change mid to mid->next whenever the counter is odd. 
	   So the mid will move only half of the total length of the list. */
	public LinkedNode<Comparable<?>> findMidNode(LinkedNode<Comparable<?>> head)
	{
		LinkedNode<Comparable<?>> fast = (LinkedNode<Comparable<?>>) head.next;
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
	
	public boolean isPalindrome(LinkedNode<Comparable<?>> head)
	{
		LinkedNode<Comparable<?>> backUp=head;	
		LinkedNode<Comparable<?>> midNode = findMidNode(head);	
		if(midNode==null || midNode.next==null)
			return true;
		LinkedNode<Comparable<?>> start2 =(LinkedNode<Comparable<?>>) midNode.next;		
		midNode.next=null;
		LinkedNode<Comparable<?>> reversedStartNode=reverse(start2);
		boolean isSame = compareTwoListsForPalindrome(backUp, reversedStartNode);
		LinkedNode<Comparable<?>> reversedNode= reverse(reversedStartNode);
		midNode.next=reversedNode;
		return isSame;
	}
	
	public boolean compareTwoLists(LinkedNode<Comparable<?>> head1,LinkedNode<Comparable<?>> head2)
	{
		if(head1==null && head2==null)
			return true;
		
		while(head1!=null || head2!=null)
		{
			if((head1!=null && head2==null) || (head1==null && head2!=null))
				return false;
			
			if(head1.data!=head2.data)
				return false;
			
			head1=(LinkedNode<Comparable<?>>) head1.next;
			head2=(LinkedNode<Comparable<?>>) head2.next;
		}
		
		return true;
	}
	
	public boolean compareTwoListsForPalindrome(LinkedNode<Comparable<?>> head1,LinkedNode<Comparable<?>> head2)
	{
			
		while(head2!=null && head1.data==head2.data)
		{	
			head1=(LinkedNode<Comparable<?>>) head1.next;
			head2=(LinkedNode<Comparable<?>>) head2.next;
		}
		
		if(head2==null)
			return true;
		
		return false;
	}
	
	public LinkedNode<Integer> mergeTwoSortedList(LinkedNode<Integer> head1,LinkedNode<Integer> head2)
	{
		LinkedNode<Integer> mergeListNode=null;
		LinkedNode<Integer> temp=null;
		if(head1==null || head2==null)
		{
			return head1!=null?head1:head2;
		}
		if(head1.data<head2.data)
		{
			mergeListNode=head1;
			head1=(LinkedNode<Integer>) head1.next;
		}
		else
		{
			mergeListNode=head2;
			head2=(LinkedNode<Integer>) head2.next;
		}
		temp=mergeListNode;
		
		while(head1!=null && head2!=null)
		{
			if(head1.data<head2.data)
			{
				temp.next=head1;
				temp=head1;
				head1=(LinkedNode<Integer>) head1.next;
			}
			else
			{
				temp.next=head2;
				temp=head2;
				head2=(LinkedNode<Integer>) head2.next;
			}
		}
		if(head1!=null)
			temp.next=head1;
		else
			temp.next=head2;
		
		return mergeListNode;
	}

	public LinkedNode<Integer> mergeKSortedList(LinkedList... linkedLists)
	{
		PriorityQueue<LinkedNode<Integer>> queue=new PriorityQueue<LinkedNode<Integer>>();
		int totalNumberLists=linkedLists.length;
		for(int i=0;i<linkedLists.length;i++)
		{
			queue.add(linkedLists[i].head);
		}
		LinkedNode<Integer> ans= queue.peek();
		LinkedNode<Integer> temp= null;
		while(!queue.isEmpty())
		{
			LinkedNode<Integer> removed=queue.remove();
			if(removed.next!=null)
				queue.add((LinkedNode<Integer>) removed.next);
			removed.next=null;
			if(temp==null)
				temp=removed;
			else
			{
				temp.next=removed;
				temp=(LinkedNode<Integer>) temp.next;
			}
		}
		return ans;
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
		
		
		LinkedList<String> l2 = new LinkedList<>();

		l2.head = l2.addNewNodeLast(null, "a");

		l2.head = l2.addNewNodeLast((LinkedNode<Comparable<?>>) l2.head, "b");
		
		l2.head = l2.addNewNodeLast((LinkedNode<Comparable<?>>) l2.head, "p");

		l2.head = l2.addNewNodeLast((LinkedNode<Comparable<?>>) l2.head, "b");

		l2.head = l2.addNewNodeLast((LinkedNode<Comparable<?>>) l2.head, "a");

		//l2.head = l2.addNewNodeLast((LinkedNode<Comparable<?>>) l2.head, "p");

		//l2.head = l2.addNewNodeLast((LinkedNode<Comparable<?>>) l2.head, "v");
		
		//l1.head = l1.addNewNodeLast((LinkedNode<Comparable<?>>) l1.head, "p");
		
		LinkedList<Integer> l3 = new LinkedList<>();

		l3.head = l3.addNewNodeLast(null, 2);

		l3.head = l3.addNewNodeLast((LinkedNode<Comparable<?>>) l3.head, 4);

		l3.head = l3.addNewNodeLast((LinkedNode<Comparable<?>>) l3.head, 6);
		
		LinkedList<Integer> l4 = new LinkedList<>();

		l4.head = l4.addNewNodeLast(null, 1);

		l4.head = l4.addNewNodeLast((LinkedNode<Comparable<?>>) l4.head, 3);

		l4.head = l4.addNewNodeLast((LinkedNode<Comparable<?>>) l4.head, 5);

		// loop is exist or not
		
	   /*  LinkedNode<Comparable<?>> count = (LinkedNode<Comparable<?>>) l1.head; 
	      LinkedNode<Comparable<?>> temp3=null;
	      int x=0;
	      
		  while(count.next!=null) {
			  if(x==2)
				  temp3=(LinkedNode<Comparable<?>>)count.next;
		  count=(LinkedNode<Comparable<?>>)count.next; 
		  x++;
		  } 
		  count.next=temp3;*/
		 

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
		l1.printListRecursive((LinkedNode<Comparable<?>>) l1.head);
		LinkedNode<Comparable<?>> mid=l1.findMidNode((LinkedNode<Comparable<?>>) l1.head);
		System.out.println();
		
	    boolean flag=l1.compareTwoLists((LinkedNode<Comparable<?>>)l1.head, (LinkedNode<Comparable<?>>)l2.head);
	    System.out.println();
	    
	    boolean isPalindrome=l1.isPalindrome((LinkedNode<Comparable<?>>) l2.head);
	    System.out.println();
	    
	    LinkedNode<Integer> merged=l1.mergeTwoSortedList((LinkedNode<Integer>)l3.head, (LinkedNode<Integer>)l4.head);
		System.out.println();
		
        LinkedList<Integer> l7 = new LinkedList<>();

		l7.head = l7.addNewNodeLast(null, 1);

		l7.head = l7.addNewNodeLast((LinkedNode<Comparable<?>>) l7.head, 3);

		l7.head = l7.addNewNodeLast((LinkedNode<Comparable<?>>) l7.head, 5);

		l7.head = l7.addNewNodeLast((LinkedNode<Comparable<?>>) l7.head, 7);

		
        LinkedList<Integer> l5 = new LinkedList<>();

		l5.head = l5.addNewNodeLast(null, 6);

		l5.head = l5.addNewNodeLast((LinkedNode<Comparable<?>>) l5.head, 11);

		l5.head = l5.addNewNodeLast((LinkedNode<Comparable<?>>) l5.head, 55);

		l5.head = l5.addNewNodeLast((LinkedNode<Comparable<?>>) l5.head, 72);
		
		 LinkedList<Integer> l6 = new LinkedList<>();

		l6.head = l6.addNewNodeLast(null, 10);

		l6.head = l6.addNewNodeLast((LinkedNode<Comparable<?>>) l6.head, 32);

		l6.head = l6.addNewNodeLast((LinkedNode<Comparable<?>>) l6.head, 35);

		l6.head = l6.addNewNodeLast((LinkedNode<Comparable<?>>) l6.head, 97);
		
		LinkedNode<Integer> mergeOfAll=l1.mergeKSortedList(l5,l6,l7);
	}

}