import java.util.Date;

public abstract class FileSystemObj {
	protected String name ;
	protected Date createDate ;
	protected Directory parent;
	
	
	public FileSystemObj(String name , Directory parent) {
		this.name = name ;
		createDate = new Date();
		this.parent = parent ;
	}
	
	protected abstract void fileSystemInfo();
	
	protected void printData() {
		System.out.println("Name : " + name);
		System.out.println("Create Date : " + createDate);
	}

	public boolean  equal(FileSystemObj other) {
		return name.equals(other.name); // because names unique 
	}
	
}
