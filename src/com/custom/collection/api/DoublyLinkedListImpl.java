package com.custom.collection.api;

import java.util.NoSuchElementException;

public class DoublyLinkedListImpl<E> {
	private Node head;
	private Node tail;
	private int size;
	
	
	public DoublyLinkedListImpl(){
		size=0;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DoublyLinkedListImpl<Integer> dll = new DoublyLinkedListImpl();
		dll.addFirst(10);
		dll.addFirst(34);
		dll.addFirst(20);
		dll.addLast(56);
		dll.iterateForward();
		dll.removeFirst();
		dll.removeLast();
		dll.iterateBackward();
		
	}
	private class Node
	{
		E element;
		Node next;
		Node prev;
		public Node(E element,Node next,Node prev)
		{
			this.element = element;
			this.next = next;
			this.prev = prev;
		}
	}
	public int size()
	{
		return size;
	}
	public boolean isEmpty()
	{
		return size==0;
	}
	public void addFirst(E element)
	{
		Node tmp = new Node(element,head,null);
		if(head!=null)
		{
			head.prev=tmp;
		}
		head=tmp;
		if(tail==null)
		{
			tail=tmp;
		}
		size++;
		System.out.println("Adding element at first::"+element);
		
	}
	public void addLast(E element)
	{
		Node tmp = new Node(element, null, tail);
		if(tail!=null)
		{
			tail.next = tmp;
		}
		tail=tmp;
		if(head==null)
		{
			head=tmp;
		}
		size++;
		System.out.println("Adding element at last::"+element);
	}
	public void iterateForward()
	{
		System.out.println("iterating forward::");
		Node tmp = head;
		while(tmp!=null)
		{
			System.out.println(tmp.element);
			tmp = tmp.next;
		}
	}
	public void iterateBackward()
	{
		System.out.println("Iterating backward..");
		Node tmp = tail;
		while(tmp!=null)
		{
			System.out.println(tmp.element);
			tmp=tmp.prev;
		}
	}
	public E removeLast()
	{
		if(size==0){
			throw new NoSuchElementException();
		}
		Node tmp = tail;
		tail = tail.prev;
		tail.next=null;
		size--;
		System.out.println("Deleted ::"+tmp.element);
		return tmp.element;
	}
	public E removeFirst()
	{
		if(size==0)
		{
			throw new NoSuchElementException();
		}
		Node tmp = head;
		head = head.next;
		head.prev=null;
		size--;
		System.out.println("Deleted from first::"+tmp.element);
		return tmp.element;
	}
	
}
