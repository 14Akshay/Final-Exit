package LinkedList;

public class OneAdditionLinkedList {
	static LinkedList<Integer> l6 = new LinkedList<>();
	public static LinkedNode<Integer> add(LinkedNode<?> head){
		LinkedNode<?> reversedNode=l6.reverseRecursive((LinkedNode<Comparable<?>>) head,null);
		int carry=1;
		int sum=0;
		LinkedNode<Integer> temp= (LinkedNode<Integer>) reversedNode;
		LinkedNode<Integer> prev=null;
		while(temp!=null)
		{
			sum=(int)temp.data+carry;
			carry=sum==10?1:0;
			sum=sum%10;
			temp.data=sum;
			sum=0;
			prev=temp;
			temp=(LinkedNode<Integer>) temp.next;
		}
		if(carry!=0)
			prev.next=new LinkedNode<Comparable<?>>(1);
		LinkedNode<?> resultNode =l6.reverseRecursive((LinkedNode<Comparable<?>>) reversedNode,null);
		return (LinkedNode<Integer>) resultNode;
	}
	public static void main(String[] args) {

		l6.head = l6.addNewNodeLast(null, 9);
		l6.head = l6.addNewNodeLast((LinkedNode<Comparable<?>>) l6.head, 1);
		l6.head = l6.addNewNodeLast((LinkedNode<Comparable<?>>) l6.head, 9);
	/*	l6.head = l6.addNewNodeLast((LinkedNode<Comparable<?>>) l6.head,9);
		l6.head = l6.addNewNodeLast((LinkedNode<Comparable<?>>) l6.head, 9);*/
		
		l6.printListRecursive((LinkedNode<Comparable<?>>) l6.head);
		LinkedNode<Integer> resultNode= OneAdditionLinkedList.add((LinkedNode<Comparable<?>>) l6.head);
		//l6.printListRecursive(resultNode);
		System.out.println();
		
		
		


	}
}
