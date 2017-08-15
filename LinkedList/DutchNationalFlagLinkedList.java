package LinkedList;

public class DutchNationalFlagLinkedList {
	static LinkedList<Integer> l6 = new LinkedList<>();
	
	public static LinkedNode<Integer> seprateElements(LinkedNode<?> head)
	{
		while(head!=null)
		{
			//prev=head;
			if((int)head.data==1)
				head=head.next;
			else if((int)head.data==0)
			{
				
			}
			else
			{
				
			}
			
		}
		return null;
	}

	public static void main(String[] args) {

		l6.head = l6.addNewNodeLast(null, 1);
		l6.head = l6.addNewNodeLast((LinkedNode<Comparable<?>>) l6.head, 1);
		l6.head = l6.addNewNodeLast((LinkedNode<Comparable<?>>) l6.head, 0);
		l6.head = l6.addNewNodeLast((LinkedNode<Comparable<?>>) l6.head,2);
		l6.head = l6.addNewNodeLast((LinkedNode<Comparable<?>>) l6.head, 1);
		l6.head = l6.addNewNodeLast((LinkedNode<Comparable<?>>) l6.head, 0);
		l6.head = l6.addNewNodeLast((LinkedNode<Comparable<?>>) l6.head, 2);
		l6.printListRecursive((LinkedNode<Comparable<?>>) l6.head);
		System.out.println();
		


	}
}
