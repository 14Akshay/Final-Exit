import java.util.HashMap;

public class InterSectionLinkedListHash {
	public static <T> void main(String args[])
	{
		LinkedList<String> l1 = new LinkedList<>();

		l1.head = l1.addNewNodeLast(null, "a");
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
			  if(x==2)
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
		  
		  
		  HashMap<LinkedNode,String> map1= new HashMap();
		  LinkedNode<Comparable<?>> start1= (LinkedNode<Comparable<?>>) l1.head;
		  while(start1!=null)
		  {
			  map1.put(start1,(String) start1.data);
			  start1=(LinkedNode<Comparable<?>>) start1.next;
		  }
		  
		  System.out.println();
		  LinkedNode<Comparable<?>> start2= (LinkedNode<Comparable<?>>) l2.head;
		  LinkedNode<Comparable<?>> result=null;
		  
		  
		  while(start2!=null)
		  {
			  if(map1.containsKey(start2)){
				  result=start2;
				  break;
			  }
			  start2=(LinkedNode<Comparable<?>>) start2.next;
		  }
		  
		  System.out.println();

	}

}
