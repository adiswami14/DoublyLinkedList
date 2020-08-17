//Coded EXCLUSIVELY by Adithya Swaminathan
import java.util.ArrayList;
import java.util.PriorityQueue;
public class DLLRunner
{
	DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
	DoublyLinkedList<String> dll = new DoublyLinkedList<>();
	public DLLRunner()
	{
		try{
			for(int x=0;x<30;x++)
			{
				list.add((int)(Math.random()*1000)+1);
			}
			System.out.println("List: "+list);
			System.out.println("List in Reverse: "+list.toReversedString());
			System.out.println("Size: "+list.size());
			int sum =0;
			int sum_even=0;
			int sum_odd = 0;
			for(int x=0;x<list.size();x++)
			{
				if(x%2==1)
					sum_odd+=list.get(x);
				else sum_even+=list.get(x);
				sum+=list.get(x);
			}
			System.out.println("Sum: "+sum);
			System.out.println("Sum of even indices: "+sum_even);
			System.out.println("Sum of odd indices: "+sum_odd);
			ArrayList<Integer> ll = new ArrayList<>();
			for(int x=0;x<list.size();x++)
			{
				int s = list.get(x);
				if(s%2==0)
					ll.add(s);
				
			}
			for(int x=0;x<ll.size();x++)
			{
				list.add(ll.get(x));
			}
			System.out.println("List with duplicates: "+list);
			for(int x=list.size()-1;x>=0;x--)
			{
				if(list.get(x)%3==0) {
					list.remove(x);
				}
			}
			System.out.println("List with 3-multiples removed: "+list);
			list.add(3, 5555);
			System.out.println("List with 5555: "+list);
			sortInAscending();
			int median = list.size()/2;
			DoublyLinkedList<Integer> before = new DoublyLinkedList<>();
			DoublyLinkedList<Integer> after = new DoublyLinkedList<>();
			if(list.size()%2==1)
			{
				for(int x=0;x<median;x++)
				{
					before.add(list.get(x));
					if(list.get(median+x+1)!=null)
						after.add(list.get(median+x+1));
				}
				median = list.get(median);
				System.out.println("Median Value: "+median+"\nBefore Median: "+before+"\nAfter Median: "+after);
			}	
			else if(list.size()%2==0)
			{
				for(int x=0;x<median;x++)
				{
					before.add(list.get(x));
					if(list.get(median+x)!=null)
						after.add(list.get(median+x));
				}
				System.out.println("Median Value: "+((double)(list.get(median-1)+list.get(median))/2)+"\nBefore Median: "+before+"\nAfter Median: "+after);
			}
			String s = "This code was exclusively coded by Adithya Swaminathan the legend";
			String[] sarr = s.split(" ");
			for(int x=0;x<sarr.length;x++)
			{
				dll.add(sarr[x]);
			}
			System.out.println("String List: "+dll);
			for(int x=0;x<dll.size();x++)
			{
				if(dll.get(x).length()<=3)
					dll.remove(x);
			}
			System.out.println("String list with short words removed: "+dll);
			sortStringsInAscending();
			int words=0;
			for(int x=0;x<dll.size();x++)
			{
				words+=dll.get(x).length();
			}
			System.out.println("Average word Length: "+(words/dll.size()));
		}
		catch(Exception e)
		{

		}
	}
	public void sortInAscending()
	{
		for(int x=0;x<list.size();x++)
		{
			for(int y=0;y<list.size()-1;y++)
			{
				if(list.get(y)>list.get(y+1))
				{
					int temp = list.get(y+1);
					list.set(y+1, list.get(y));
					list.set(y, temp);
				}
			}
		}
		System.out.println("List in ascending order: "+list);
	}
	public void sortStringsInAscending()
	{
		for(int x=0;x<dll.size();x++)
		{
			for(int y=0;y<dll.size()-1;y++)
			{
				if(dll.get(y).toLowerCase().compareTo((dll.get(y+1).toLowerCase()))>0){
					String temp=dll.get(y);
					dll.set(y,dll.get(y+1));
					dll.set(y+1,temp);
				}
			}
		}
		System.out.println("String list in ascending order: "+dll);
	}
	public static void main(String[] args)
	{
		DLLRunner app=new DLLRunner();
	}

}
