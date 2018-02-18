package com.custom.collection.api;

import java.util.Arrays;

public class MyArrayList 
{
	private	Object[] mystore;
	private int actSize = 0;
	
	public MyArrayList()
	{
		mystore = new Object[10];
	}
	
	public Object get(int index)
	{
		if(index<actSize)
		{
			return mystore[index];
		}
		else
		{
			throw new ArrayIndexOutOfBoundsException();
		}
	}
	
	public void add(Object obj)
	{
		if(mystore.length-actSize<=5)
		{
			increaseListSize();
		}
		mystore[actSize++] = obj;
		System.out.println("actSize::"+actSize);
	}
	
	public Object remove(int index)
	{
		if(index<actSize)
		{
			Object obj = mystore[index];
			mystore[index]=null;
			int temp = index;
			while(temp<actSize)
			{
				mystore[temp] = mystore[temp+1];
				mystore[temp+1] = null;
				temp++;
			}
			actSize--;
			return obj;
		}
		else
		{
			throw new ArrayIndexOutOfBoundsException();
		}
	}
	
	public int size()
	{
		return actSize;
	}
	
	private void increaseListSize()
	{
		mystore = Arrays.copyOf(mystore, mystore.length*2);
	}
	
	public static void main(String[] args) 
	{
		MyArrayList mal = new MyArrayList();
		mal.add(new Integer(2));
		mal.add(new Integer(5));
		mal.add(new Integer(1));
		mal.add(new Integer(23));
		mal.add(new Integer(14));
		for(int i=0;i<mal.size();i++)
		{
			System.out.println(mal.get(i)+ " ");
		}
		
		
	}

}
