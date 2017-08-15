package LinkedList;

public class GreatestValueRightSideLinkedList {
	static LinkedList<Integer> l6 = new LinkedList<>();
	public static LinkedNode<Integer> greatestValueRightSide(LinkedNode<?> head)
	{
		head = l6.reverse((LinkedNode<Comparable<?>>) head);
		LinkedNode<?> bckp=head;
		LinkedNode<Integer> maxNodeSoFar= (LinkedNode<Integer>) head;
		head=head.next;
		while(head!=null)
		{
			head.random=maxNodeSoFar;
			
			if((maxNodeSoFar.data) < (int)head.data)
				maxNodeSoFar=(LinkedNode<Integer>) head;
			head=head.next;
		}
		head = l6.reverse((LinkedNode<Comparable<?>>) bckp);
		return (LinkedNode<Integer>) head;
	}
	public static void main(String[] args) {
		
		l6.head = l6.addNewNodeLast(null, 10);
		l6.head = l6.addNewNodeLast((LinkedNode<Comparable<?>>) l6.head, 3);
		l6.head = l6.addNewNodeLast((LinkedNode<Comparable<?>>) l6.head, 100);
		l6.head = l6.addNewNodeLast((LinkedNode<Comparable<?>>) l6.head, 17);
		l6.head = l6.addNewNodeLast((LinkedNode<Comparable<?>>) l6.head, 170);
		l6.head = l6.addNewNodeLast((LinkedNode<Comparable<?>>) l6.head, 107);
		l6.head = l6.addNewNodeLast((LinkedNode<Comparable<?>>) l6.head, 70);
		GreatestValueRightSideLinkedList test=new GreatestValueRightSideLinkedList();
		LinkedNode<Integer> newHead = test.greatestValueRightSide(l6.head);
		System.out.println();
		

	}

}
