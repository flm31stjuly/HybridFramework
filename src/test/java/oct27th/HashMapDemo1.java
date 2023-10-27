package oct27th;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapDemo1 {

	public static void main(String[] args) {
		
		
		Map<String, Integer> hMap=new HashMap<String, Integer>();
		
		hMap.put("Ram", 89);
		hMap.put("Sam", 79);
		hMap.put("Ravi", 65);
		hMap.put("Gopi", 90);
		
		Set<Entry<String, Integer>>  entries=hMap.entrySet();
		
		//using for -each loop
		
		for(Entry<String, Integer> entry:entries)
		{
			System.out.println(entry.getKey()+"------"+entry.getValue());
		}
		
		
	}

}
