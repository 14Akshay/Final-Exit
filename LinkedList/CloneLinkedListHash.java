package LinkedList;
import java.util.HashMap;

public class CloneLinkedListHash {

	public static void main(String[] args) {
		LinkedList<String> l1=new LinkedList<>();
		HashMap<LinkedNode<Comparable<?>>, LinkedNode<Comparable<?>>> map = new HashMap();
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
		
		LinkedNode<Comparable<?>> start1 = (LinkedNode<Comparable<?>>) l1.head;
		LinkedNode<Comparable<?>> start2=null,prev=null,temp=null;
		
		start2=l1.createNewNode((String) start1.data);
		map.put(start1, start2);
		prev=start2;
		while(start1.next!=null)	
		{
			
				temp=l1.createNewNode((String) start1.next.data);
				prev.next=temp;
				prev=temp;
				start1=(LinkedNode<Comparable<?>>) start1.next;
				map.put(start1, prev);
			
		}
		start1 = (LinkedNode<Comparable<?>>) l1.head;
		System.out.println();
		
		while(start1!=null)
		{
			LinkedNode<Comparable<?>> result= map.get(start1);
			result.random=map.get(start1.random);
			start1=(LinkedNode<Comparable<?>>) start1.next;
		}
		
		l1.printListIterative((LinkedNode<Comparable<?>>) l1.head);
		System.out.println();
		l1.printListIterative(start2);
	}

}
