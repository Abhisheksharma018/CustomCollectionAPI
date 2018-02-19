package com.custom.collection.api;

class HashSetCustom<E>
{
	private HashMapCustoms<E,Object> hashMapCustoms;
	
	public HashSetCustom()
	{
		hashMapCustoms = new HashMapCustoms();
	}
	
	public void add(E val)
	{
		hashMapCustoms.put(val, null);
	}
	public boolean contains(E obj)
	{
		return hashMapCustoms.contains(obj)!=null?true:false;
	}
	public void display()
	{
		hashMapCustoms.displaySet();
	}
	public boolean remove(E obj)
	{
		return hashMapCustoms.remove(obj);
	}
}

class HashMapCustoms<K,V>
{
	private Entry<K, V>[] table;
	private int capacity =4;
	
	static class Entry<K,V>
	{
		K key;
		V value;
		Entry<K,V> next;
		
		public Entry(K key,V value,Entry next)
		{
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}
	
	public HashMapCustoms()
	{
		table = new Entry[capacity];
	}
	
	private int hash(K key)
	{
		return Math.abs(key.hashCode())%capacity;
	}
	
	public void put(K newKey,V data)
	{
		if(newKey==null)
		{
			return;
		}
		int hash = hash(newKey);
		Entry<K,V> newEntry = new Entry(newKey, data, null);
		if(table[hash]==null)
		{
			table[hash] = newEntry;
		}
		else{
			Entry<K,V> previous = null;
			Entry<K,V> current = table[hash];
			
			while(current!=null)
			{
				if(current.key.equals(newKey))
				{
					if(previous==null)
					{
						newEntry.next = current.next;
						table[hash] = newEntry;
						return;
					}
					else
					{
						newEntry.next=current.next;
						previous.next = newEntry;
						return;
					}
				}
				previous=current;
				current=current.next;
				
			}
			previous.next= newEntry;
		}
		
		
	}
	
	public V get(K key)
	{
		int hash = hash(key);
		if(table[hash]==null)
		{
			return null;
		}
		else{
			Entry<K,V> temp = table[hash];
			while(temp!=null)
			{
				if(temp.key.equals(key))
				{
					return temp.value;
				}
				temp=temp.next;
			}
			return null;
		}
	}
	
	public boolean remove(K deleteKey)
	{
		int hash = hash(deleteKey);
		if(table[hash]==null)
		{
			return false;
		}
		else{
			Entry<K,V> previous =null;
			Entry<K,V> current = table[hash];
			
			while(current!=null)
			{
				if(current.key.equals(deleteKey)){
					if(previous==null)
					{
						table[hash] = table[hash].next;
						return true;
					}else{
						previous.next=current.next;
						return true;
					}
				}
				previous=current;
				current = current.next;
			}
			return false;
		}
		
	}
	public void display(){
		for(int i=0;i<capacity;i++){
			if(table[i]!=null)
			{
				Entry<K,V> entry = table[i];
				while(entry!=null)
				{
					System.out.println(""+entry.key+""+entry.value);
					entry = entry.next;
				}
			}
			
		}
	}
	
	public K contains(K key)
	{
		int hash = hash(key);
		if(table[hash]==null)
		{
			return null;
		}
		else{
			Entry<K,V> temp = table[hash];
			while(temp!=null)
			{
				if(temp.key.equals(key))
					return key; 
				temp = temp.next;
			}
			return null;
		}
	}
	public void displaySet()
	{
		for(int i=0;i<capacity;i++)
		{
			if(table[i]!=null)
			{
				Entry<K,V> entry = table[i];
				while(entry!=null){
					System.out.println(entry.key);
					entry=entry.next;
				}
				
			}
		}
	}
	
}

public class HashSetCustomApp {

	public static void main(String[] args) {
		HashSetCustom<Integer> hashSetCustom = new HashSetCustom<Integer>();
		hashSetCustom.add(21);
		hashSetCustom.add(25);
		hashSetCustom.add(30);
		hashSetCustom.add(33);
		System.out.println("HashSet Custom contains::"+hashSetCustom.contains(21));
		System.out.println("HashSet Custom contains::"+hashSetCustom.remove(22));

	}

}
