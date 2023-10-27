package oct27th;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapDemo2 {

	public static void main(String[] args) {
		
		
		Map<String, Integer> hMap=new HashMap<String, Integer>();
		
		hMap.put("Ram", 89);
		hMap.put("Sam", 79);
		hMap.put("Ravi", 65);
		hMap.put("Gopi", 90);
		hMap.put("Sam", 99);
		hMap.put(null, 100);
		
		System.out.println("size is "+hMap.size());
		
		Set<Entry<String, Integer>>  entries=hMap.entrySet();
		
		//iterator 
		
		Iterator<Entry<String, Integer>> it=entries.iterator();
		
		while(it.hasNext())
		{
			Entry<String, Integer> entry=it.next();
			
			System.out.println(entry.getKey()+"-----"+entry.getValue());
		}
		
	}

}
