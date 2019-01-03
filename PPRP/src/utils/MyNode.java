package utils;

public class MyNode {

	public String name;
	public String type;
	public int D;
	public boolean isArray;
	public int result;
	public int row;
	public int col;
	
	public int a[]=null ;
	public int b[][]=null;
	public int i,j;
	
	
	
	
	public MyNode(String name, String type) {
		super();
		this.name = name;
		this.type = type;
		this.row=-1;
		this.col=-1;
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getD() {
		return D;
	}
	public void setD(int d) {
		D = d;
	}
	public boolean isArray() {
		if(this.D==0){
			isArray=false;
		}else{
			isArray=true;
		}
		return isArray;
	}

	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getCol() {
		return col;
	}
	public void setCol(int clo) {
		this.col = clo;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String str=null;
		if(this.isArray()){
			if(this.D==1){
				str="变量的类型是："+this.type+"型一维数组,数组的名字是："+this.name+"\n";
			}else{
				str="变量的类型是："+this.type+"型二维数组,数组的名字是："+this.name+"\n";
			}
		}else{
			str="变量的类型是："+this.type+",变量的名字是："+this.name+" "+"\n";
		}
		return str;
	}
	
	
	
}
