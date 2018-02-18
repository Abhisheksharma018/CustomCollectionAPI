package com.custom.collection.api;

public class MyArrayList2 
{
	private static final int SIZE_FACTOR=5;
	
	private Object data[];
	
	private int index;
	
	private int size;
	
	public MyArrayList2()
	{
		this.data=new Object[SIZE_FACTOR];
		this.size=SIZE_FACTOR;
	}
	
	public void add(Object obj)
	{
		if(this.index==this.size-1)
		{
			increaseAndAllocate();
		}
		data[this.index]=obj;
		this.index++;
	}
	public void increaseAndAllocate()
	{
		this.size = this.size+SIZE_FACTOR;
		Object newData[] = new Object[this.size];
		for(int i=0;i<data.length;i++)
		{
			newData[i]=data[i];
		}
		this.data=newData;
		
	}
	
	public Object get(int i) throws Exception
	{
		if(i>this.index-1)
		{
			throw new Exception("ArrayIndexOutOfBound");
		}
		if(i<0)
		{
			throw new Exception("Negative Value");
		}
		return this.data[i];
	}
	public void remove(int i) throws Exception
	{
		if(i>this.index-1)
		{
			throw new Exception("ArrayIndexOutOfBound");
		}
		if(i<0)
		{
			throw new Exception("Negative Value");
		}
		for(int x=i;x<this.data.length-1;x++)
		{
			data[x] = data[x+1];
		}
		this.index--;
	}
	
	public static void main(String[] args) throws Exception 
	{
		MyArrayList2 mal = new MyArrayList2();
		mal.add("0");
		mal.add("1");
		mal.add("2");
		mal.add("3");
		mal.add("4");
		mal.add("A");
		
		mal.remove(3);
		System.out.println(mal.get(4));
		
	}

}
