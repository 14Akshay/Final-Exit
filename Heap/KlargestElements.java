package heap;

class KlargestElements
{

	static int[] input = {0,8,9,1,4,3,99,76,85,10};

	public static void findKlargest(int k,int[] input)
	{
		Heap.buildHeap(input,1,k);
		
		for(int i=k+1;i<=input.length-1;i++)
		{
			if(input[1]<input[i])
			{
				int temp = input[i];
				input[i]=input[1];
				input[1]=temp;
				Heap.minHeapify(input, 1,k);
			}
		}
	}
	
	public static void main(String args[])
	{
		KlargestElements.findKlargest(4,input);
		for(int i:input)
			System.out.print(" "+i);
	}

}
