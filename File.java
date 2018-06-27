
public class File extends FileSystemObj{
	
	private long size;
	
	public File(String name , long size ,Directory parent) {
		super(name , parent);
		this.size = size ; 
	}
	
	protected void fileSystemInfo() {
		printData();
		System.out.println("Size : " + size);
	}
}
