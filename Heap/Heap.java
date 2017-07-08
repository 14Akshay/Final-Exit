package heap;
class Heap
{
	static int[] input = {0,8,9,1,4,3,99,76,85,10};//zero index is taken for ease.
	
	public static void maxHeapify(int[] input ,int rootIndex , int sizeOfHeap)
	{
		int left = 2*rootIndex;
		int right = 2*rootIndex+1;
		int largest = rootIndex;
		int temp=0;
		
		if(left <= sizeOfHeap && input[left]>input[rootIndex])
			largest = left;
		if(right <= sizeOfHeap && input[right] > input[largest])
			largest = right;
		if(largest != rootIndex)
		{
			temp = input[largest];
			input[largest]= input[rootIndex];
			input[rootIndex] = temp;
			maxHeapify(input,largest,sizeOfHeap);
		}
			
	}
	
	public static void minHeapify(int[] input ,int rootIndex , int sizeOfHeap)
	{
		int left = 2*rootIndex;
		int right = 2*rootIndex+1;
		int smallest = rootIndex;
		int temp=0;
		
		if(left <= sizeOfHeap && input[left]<input[rootIndex])
			smallest = left;
		if(right <= sizeOfHeap && input[right] < input[smallest])
			smallest = right;
		if(smallest != rootIndex)
		{
			temp = input[smallest];
			input[smallest]= input[rootIndex];
			input[rootIndex] = temp;
			minHeapify(input,smallest,sizeOfHeap);
		}
			
	}
	
	public static void buildHeap(int[] input,int rootIndex,int sizeOfHeap)
	{ 
		int leafStartIndex = (sizeOfHeap/2)+1;
		for(int i=leafStartIndex;i>=1;i--)
		{
			maxHeapify(input,i,sizeOfHeap);
		}
	}
	
	public static void heapSort(int[] input)
	{
		Heap.buildHeap(input,1,input.length-1);
		int size = input.length-1;
		while(size>=2)
		{
			int max = input[1];
			input[1]=input[size];
			input[size]= max;
			size--;
			maxHeapify(input,1,size);
		}
	}
	
	
	public static void main(String args[])
	{
		//Heap.maxHeapify(input,1,input.length-1);
		//Heap.minHeapify(input, 1,input.length-1);
		//Heap.buildHeap(input, 1, input.length-1);
		  Heap.heapSort(input);
		for(int i:input)
			System.out.print(" "+i);
		
	}
}
