package LinkedList;

public class SplitOddEven {
	public static <T> void main(String args[])
	{
		LinkedList<String> l1 = new LinkedList<>();

		l1.head = l1.addNewNodeLast(null, "a");
		l1.head = l1.addNewNodeLast((LinkedNode<Comparable<?>>) l1.head, "k");
		l1.head = l1.addNewNodeLast((LinkedNode<Comparable<?>>) l1.head, "s");
		l1.head = l1.addNewNodeLast((LinkedNode<Comparable<?>>) l1.head, "h");
		l1.head = l1.addNewNodeLast((LinkedNode<Comparable<?>>) l1.head, "a");
		l1.head = l1.addNewNodeLast((LinkedNode<Comparable<?>>) l1.head, "y");
		l1.head = l1.addNewNodeLast((LinkedNode<Comparable<?>>) l1.head, "1");
		
		LinkedNode<Comparable<?>> head1=(LinkedNode<Comparable<?>>) l1.head;
		LinkedNode<Comparable<?>> head2=(LinkedNode<Comparable<?>>) l1.head.next;
		LinkedNode<Comparable<?>> temp=null;
		LinkedNode<Comparable<?>> pointer=(LinkedNode<Comparable<?>>) l1.head;
		while(pointer!=null && pointer.next!=null)
		{
			temp=(LinkedNode<Comparable<?>>) pointer.next;
			pointer.next=pointer.next.next;
			pointer=temp;
		}
		
		System.out.println();
	}

}
