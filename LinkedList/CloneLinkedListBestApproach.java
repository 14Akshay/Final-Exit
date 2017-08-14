import java.util.HashMap;

public class CloneLinkedListBestApproach {

	public static void main(String[] args) {
		LinkedList<String> l1=new LinkedList<>();
	
		l1.head = l1.createNewNode("a");
		LinkedNode<Comparable<?>> kNode=l1.createNewNode("k");
		LinkedNode<Comparable<?>> sNode=l1.createNewNode("s");
		LinkedNode<Comparable<?>> hNode=l1.createNewNode("h");
		LinkedNode<Comparable<?>> pNode=l1.createNewNode("p");
		LinkedNode<Comparable<?>> yNode=l1.createNewNode("y");
		
		l1.head.next=kNode;
		kNode.next=sNode;
		sNode.next=hNode;
		hNode.next=pNode;
		pNode.next=yNode;
		
		l1.head.random=sNode;
		kNode.random=hNode;
		sNode.random=pNode;
		hNode.random=yNode;
		pNode.random=l1.head;
		yNode.random=kNode;
		
		LinkedNode<Comparable<?>> start1=(LinkedNode<Comparable<?>>) l1.head;
		//insert new node between two nodes
		while(start1!=null)
		{
			LinkedNode<Comparable<?>> temp=l1.createNewNode((String) start1.data);
			LinkedNode<Comparable<?>> next = (LinkedNode<Comparable<?>>) start1.next;
			start1.next=temp;
			temp.next=next;
			start1=next;
		}
		
		start1=(LinkedNode<Comparable<?>>) l1.head;
		//set random pointers to newly inserted nodes
		while(start1!=null && start1.next!=null)
		{
			start1.next.random=start1.random.next;
			start1=(LinkedNode<Comparable<?>>) start1.next.next;
		}
		start1=(LinkedNode<Comparable<?>>) l1.head;
		LinkedNode<Comparable<?>> start2= (LinkedNode<Comparable<?>>) l1.head.next;
		System.out.println();
		
		while(start1!=null && start1.next!=null)
		{
			LinkedNode<Comparable<?>> backup=(LinkedNode<Comparable<?>>) start1.next;
			start1.next=backup.next;
			start1=backup;
		}
		
		l1.printListIterative((LinkedNode<Comparable<?>>) l1.head);
		System.out.println();
		l1.printListIterative(start2);
		

	}

}
