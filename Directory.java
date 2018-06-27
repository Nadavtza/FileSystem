import java.util.LinkedList;

public class Directory extends FileSystemObj{
	private LinkedList<FileSystemObj> dirsAndFiles;


	public Directory(String name , Directory parent) {
		super(name , parent);
		 dirsAndFiles = new LinkedList<FileSystemObj>();
	}
	
	protected void fileSystemInfo() {
		printData();
		if(dirsAndFiles.size() > 0)
			printDirsAndFiles();		
	}
	
	private  void printDirsAndFiles() {
		System.out.println("***********************" );
		System.out.println("Directory " +name+ " content" );
		System.out.println("***********************" );
		int counter =1;
		for (FileSystemObj dirOrFile : dirsAndFiles) {
			System.out.println("----------------------- " );
			System.out.println(counter + " :" );
			dirOrFile.fileSystemInfo();
			counter++;
		}
		System.out.println("----------------------- " );
		System.out.println("***********************" );
		System.out.println("*End Directory " +name+"**" );
		System.out.println("***********************" );
	}
	
	public void addFileOrDir(FileSystemObj fileOrDir) {
		dirsAndFiles.add(fileOrDir);
	}
	public void removeFileOrDir(FileSystemObj fileOrDir) {
		dirsAndFiles.remove(fileOrDir);
	}
	public LinkedList<FileSystemObj> getDirsAndFiles() {
		return dirsAndFiles;
	}

}
