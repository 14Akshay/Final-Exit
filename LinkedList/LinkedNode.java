package LinkedList;

public class LinkedNode<T extends Comparable<?>> implements Comparable<LinkedNode<?>>{
	
	LinkedNode<?> next;
	LinkedNode<?> prev;
	LinkedNode<?> random;
	T data;
	boolean isVisited;
	
	public LinkedNode(T data2) {
		super();
		this.data = data2;
	}


	public boolean equals(Object obj) 
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        LinkedNode other = (LinkedNode) obj;
        if (next.data != other.next.data)
            return false;
        if (data != other.data)
            return false;
        return true;
    }
	
	 @Override
	    public int hashCode() 
	    {
	        final int prime = 31;
	        int result = 1;
	        result = prime * result + ((int)(data.toString().charAt(0)));
	        if(next!=null)
	        	result = prime * result + ((int)(next.data.toString().charAt(0)));
	        else
	        	result = prime * result + 123;
	        return result;
	    }


	@Override
	public int compareTo(LinkedNode<?> arg0) {
		// TODO Auto-generated method stub
		return Integer.parseInt(this.data.toString())-Integer.parseInt(arg0.data.toString());
	}



}
