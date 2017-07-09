
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.SortedSet;
import java.util.TreeSet;

public class MinimumRangeKsortedList {

	public static void main(String[] args) {

		List<List<Integer>> lists = new ArrayList<List<Integer>>();	
		List<Integer> list1 = new ArrayList<Integer>();//4,10,15,24,26
		list1.add(4);
		list1.add(10);
		list1.add(15);
		list1.add(24);
		list1.add(26);
		
		List<Integer> list2 = new ArrayList<Integer>();//0,9,12,20
		list2.add(0);
		list2.add(9);
		list2.add(12);
		list2.add(20);
		
		List<Integer> list3 = new ArrayList<Integer>();//5,18,22,30
	    list3.add(5);
		list3.add(18);
		list3.add(22);
		list3.add(30);
		
		List<Integer> list4 = new ArrayList<Integer>();
		list4.add(23);
		list4.add(33);
		list4.add(41);
		list4.add(43);
		
		lists.add(list1);
		lists.add(list2);
		lists.add(list3);
		lists.add(list4);
		MinimumRangeKsortedList.findMinRange(lists);
		
	}

	private static void findMinRange(List<List<Integer>> lists) {
		PriorityQueue<Packet> queue = new PriorityQueue<Packet>();
		SortedSet<Packet> entries = new TreeSet<Packet>();
		for(int i=0;i<lists.size();i++)
		{
			entries.add(new Packet(lists.get(i).get(0), i));
			queue.add(new Packet(lists.get(i).remove(0), i));
			
		}
		 Result res = new Result();
		 res.min=entries.first().data;
		 res.max  = entries.last().data;
		while(true){
			Packet minData = queue.remove();
			entries.remove(minData);
			if(lists.get(minData.listID).size()>0 )
			{				
				entries.add(new Packet(lists.get(minData.listID).get(0), minData.listID));
				queue.add(new Packet(lists.get(minData.listID).remove(0), minData.listID));
				int first=entries.first().data;
				int last = entries.last().data;
				if((last-first)<(res.max-res.min) && queue.size()==lists.size() && entries.size()==lists.size())
				{
					 res.min = first;
					 res.max  = last;
				}
				
			}
			else
			{
				System.out.println(res.min+","+res.max);
				break;
			}
			
		}
	}

}

class Result 
{
	int max;
	int min;
}
class Packet implements Comparable<Packet>
{
	public final int listID;
	public final int data;
	
	
	public Packet(int data,int listID)
	{
		this.listID=listID;
		this.data=data;
	}

	@Override
	public int compareTo(Packet packet) {
		// TODO Auto-generated method stub
		return data - packet.data;
	}
	
}
