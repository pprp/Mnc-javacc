package utils;
import java.util.ArrayList;


public class MyNodeList {
	public ArrayList<MyNode> mylist=null;

	public MyNodeList(ArrayList<MyNode> mylist) {
		super();
		this.mylist = mylist;
	}
	
	public int getSize()
	{
		return mylist.size();
	}
	
	public boolean isCunZai(String name){
		boolean index=false;
		
		for(MyNode temp:mylist){
			if(temp.getName().equals(name)){
				index=true;
			}
		}
		return index;
	}
	
	public void removeNode(String name){
		
		for(MyNode temp:mylist){
			if(temp.getName().equals(name)){
				mylist.remove(temp);
			}
		}
		
	}
	
	public MyNode getNode(String name){
		MyNode temper=null;
		
		for(MyNode temp:mylist){
			if(temp.getName().equals(name)){
				temper=temp;
			}
		}
		return temper;
	}
	
	
	public void addNode(MyNode temp){
		mylist.add(temp);
	}
}
