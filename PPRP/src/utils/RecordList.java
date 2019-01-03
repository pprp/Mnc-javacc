package utils;

import java.util.ArrayList;

public class RecordList {
	public ArrayList<Record> mylist = null;

	public RecordList(ArrayList<Record> mylist) {
		super();
		this.mylist = mylist;
	}

	public int getSize() {
		return mylist.size();
	}

	public boolean ifExist(String name) {
		boolean index = false;

		for (Record temp : mylist) {
			if (temp.getName().equals(name)) {
				index = true;
			}
		}
		return index;
	}

	public void removeNode(String name) {

		for (Record temp : mylist) {
			if (temp.getName().equals(name)) {
				mylist.remove(temp);
			}
		}

	}

	public Record getNode(String name) {
		Record temper = null;

		for (Record temp : mylist) {
			if (temp.getName().equals(name)) {
				temper = temp;
			}
		}
		return temper;
	}

	public void addNode(Record temp) {
		mylist.add(temp);
	}
}
