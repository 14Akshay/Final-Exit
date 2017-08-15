package LinkedList;

public class InterSectionLinkedListSubtract {
	public static <T> void main(String args[])
	{
		LinkedList<String> l1 = new LinkedList<>();

		l1.head = l1.addNewNodeLast(null, "a");
		l1.head = l1.addNewNodeLast((LinkedNode<Comparable<?>>) l1.head, "z");
		l1.head = l1.addNewNodeLast((LinkedNode<Comparable<?>>) l1.head, "k");
		l1.head = l1.addNewNodeLast((LinkedNode<Comparable<?>>) l1.head, "s");
		l1.head = l1.addNewNodeLast((LinkedNode<Comparable<?>>) l1.head, "h");
		l1.head = l1.addNewNodeLast((LinkedNode<Comparable<?>>) l1.head, "p");
		l1.head = l1.addNewNodeLast((LinkedNode<Comparable<?>>) l1.head, "y");	
		LinkedList<String> l2 = new LinkedList<>();
		l2.head = l2.addNewNodeLast(null, "v");
		l2.head = l2.addNewNodeLast((LinkedNode<Comparable<?>>) l2.head, "i");
		l2.head = l2.addNewNodeLast((LinkedNode<Comparable<?>>) l2.head, "b");

		LinkedNode<Comparable<?>> count = (LinkedNode<Comparable<?>>) l1.head; 
		LinkedNode<Comparable<?>> temp3=null;
		int x=0;

		while(count.next!=null) {
			if(x==3)
				temp3=(LinkedNode<Comparable<?>>)count.next;
			count=(LinkedNode<Comparable<?>>)count.next; 
			x++;
		} 

		LinkedNode<Comparable<?>> count1 = (LinkedNode<Comparable<?>>) l2.head; 
		LinkedNode<Comparable<?>> temp4=null;
		int y=0;

		while(count1.next!=null) {
			if(y==1)
				temp4=(LinkedNode<Comparable<?>>)count1.next;
			count1=(LinkedNode<Comparable<?>>)count1.next; 
			y++;
		} 
		temp4.next=temp3;
		
		
		//find length of first list
		LinkedNode<Comparable<?>> node1=(LinkedNode<Comparable<?>>) l1.head;
		int countLink1=0;
		while(node1!=null)
		{
			countLink1++;
			node1=(LinkedNode<Comparable<?>>) node1.next;
		}
		
		LinkedNode<Comparable<?>> node2=(LinkedNode<Comparable<?>>) l2.head;
		int countLink2=0;
		while(node2!=null)
		{
			countLink2++;
			node2=(LinkedNode<Comparable<?>>) node2.next;
		}
		System.out.println();
		int diff=countLink1>countLink2?countLink1-countLink2:countLink2-countLink1;
		//LinkedNode<Comparable<T>> skipListNode = countLink1>countLink2?(LinkedNode<T>) l1.head:(LinkedNode<T>) l2.head;
		LinkedNode<?> bigListStart =null;
		LinkedNode<?> smallListStart =null;
		LinkedNode<?> resultNode =null;
		if(countLink1>countLink2)
		{
			bigListStart=(LinkedNode<?>) l1.head;
			smallListStart=(LinkedNode<?>) l2.head;
		}
		else
		{
			bigListStart=(LinkedNode<?>) l2.head;	
			smallListStart=(LinkedNode<?>) l1.head;
		}
		
		while(diff>0)
		{
			bigListStart=bigListStart.next;
			diff--;
		}
		
		while(bigListStart!=null && smallListStart!=null)
		{
			if(smallListStart==bigListStart)
			{
				resultNode=smallListStart;
				break;
			}
			bigListStart=bigListStart.next;
			smallListStart=smallListStart.next;
		}
		System.out.println();
		
	}
}
