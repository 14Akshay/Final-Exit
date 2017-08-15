package LinkedList;

public class AdditionLinkedList {
	static LinkedList<Integer> l6 = new LinkedList<>();
	static LinkedList<Integer> l7 = new LinkedList<>();
	
	
	public LinkedNode<Comparable<?>> add(LinkedNode<Comparable<?>> head1,LinkedNode<Comparable<?>> head2)
	{
		LinkedNode<Comparable<?>> reversed1=l6.reverseRecursive(head1, null);
		LinkedNode<Comparable<?>> reversed2=l6.reverseRecursive(head2, null);
		LinkedNode<Comparable<?>> bckp1= reversed1;
		LinkedNode<Comparable<?>> bckp2= reversed2;
		LinkedNode<Comparable<?>> result= null,resultStart=null,prev=null,temp=null;
		int sum=0,carry=0;
		while(bckp1!=null || bckp2!=null)
		{
			sum =(bckp1!=null?(int)bckp1.data:0) +(bckp2!=null?(int)bckp2.data:0) + carry;
			carry=(sum>=10)?1:0;
			sum=sum%10;
			temp= new LinkedNode<Comparable<?>>(sum);
			if(result==null){
				result =temp;
				resultStart=result;
			}
			else
				prev.next =temp;
			if(bckp1!=null)
				bckp1=(LinkedNode<Comparable<?>>) bckp1.next;
			if(bckp2!=null)
				bckp2=(LinkedNode<Comparable<?>>) bckp2.next;
			prev=temp;
		}
		if(carry!=0)
			prev.next=new LinkedNode<Comparable<?>>(carry);
		resultStart=l6.reverseRecursive(resultStart, null);
		return resultStart;
	}
	public static void main(String[] args) {
		
		l6.head = l6.addNewNodeLast(null, 9);
		l6.head = l6.addNewNodeLast((LinkedNode<Comparable<?>>) l6.head, 9);
		l6.head = l6.addNewNodeLast((LinkedNode<Comparable<?>>) l6.head, 9);
		
		l7.head = l7.addNewNodeLast(null, 1);
		l7.head = l7.addNewNodeLast((LinkedNode<Comparable<?>>) l7.head, 1);
		l7.head = l7.addNewNodeLast((LinkedNode<Comparable<?>>) l7.head, 1);
		/*l7.head = l7.addNewNodeLast((LinkedNode<Comparable<?>>) l7.head, 9);*/
		AdditionLinkedList test=new AdditionLinkedList();
		test.add((LinkedNode<Comparable<?>>)l6.head, (LinkedNode<Comparable<?>>)l7.head);
		System.out.println();
		

	}

}
