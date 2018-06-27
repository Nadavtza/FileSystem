
public class FileSystem {
	
	private Directory root;
	
	
	public FileSystem(String rootName) {
		root = new Directory(rootName ,null);
	}
	
	public boolean addFile (String parentDirName, String fileName, Integer fileSize) {
		if(fileName ==null  || parentDirName ==null  ||  fileSize  ==null  ) {
			System.out.println("Wrong input");
			return false;
		}
		if(root == null) {
			System.out.println("Please initial root first");
			return false;
		}
		
		if( fileSize < 0 || fileName.length() > 32 || parentDirName.length() >32 ) {
			System.out.println("File name length  or file size are invalid , please try again!");
			return false;
		}
		FileSystemObj parentDir = locateFileAndDir(root , parentDirName );
		if(parentDir == null || (parentDir instanceof  File )) {
			 System.out.println("Parent directory " + parentDirName + " not found!" );
			 return false ; 
		}
		((Directory)parentDir).addFileOrDir( new File(fileName , fileSize , ((Directory)parentDir) ));
		return true;
	}
	
	public boolean addDir (String parentDirName, String dirName) {
		
		if(dirName ==null  || parentDirName ==null ) {
			System.out.println("Wrong input");
			return false;
		}
		if(root == null) {
			System.out.println("Please initial root first");
			return false;
		}
		if( parentDirName.length() >32 || dirName.length() > 32) {
			System.out.println("Directory name length are invalid , please try again!");
			return false;
		}
		FileSystemObj parentDir = locateFileAndDir(root , parentDirName );
		if(parentDir == null || (parentDir instanceof  File )) {
			 System.out.println("Parent directory " + parentDirName + " not found!" );
			 return false ; 
		}
		((Directory)parentDir).addFileOrDir( new Directory(dirName ,((Directory)parentDir)));
		return true;
	}
	
	
	private FileSystemObj locateFileAndDir(FileSystemObj root ,String name ) {
		FileSystemObj findDirOrFile = null;
		if((root.name.equals(name))) {
			return root;
		}
		if((root instanceof  Directory ))
		{
			for (FileSystemObj dirOrFile :((Directory)root).getDirsAndFiles()) {
				findDirOrFile = locateFileAndDir(dirOrFile , name);
				if(findDirOrFile != null)
					break;
            }
		}
		return findDirOrFile;		
	}
	
	public boolean delete (String name) {
		if(name ==null  || name.length() > 32  ) {
			System.out.println("Wrong input");
			return false;
		}
		if(!(root == null)) {
			if(name == root.name) {
				root = null;
				return true;
			}
			else {
				FileSystemObj dirOrFile =locateFileAndDir(root , name);
				if(dirOrFile != null) {
					dirOrFile.parent.removeFileOrDir(dirOrFile);
					return true;
				}
			}
			
		}
		
		System.out.println("File/Directory not exists!");
		return false;
	}
	
	public boolean intialRoot (String rootName) {
		if(root != null) {
			 System.out.println("Root already initialized");
			 return false;
		}
		root = new Directory(rootName , null);
		return true;
	}
	
	  public void systemInfo (){  
	        if(root != null){
	        	System.out.println();
	            root.fileSystemInfo();
	        }
	    }
	
	public static void main(String[] args) {
			FileSystem fileSystem = new FileSystem("root");
			
//			fileSystem.addFile("root","File 01" , 1);
//			fileSystem.addFile("root","File 02" , 1);
//			fileSystem.addDir("root","DIR 02");
//			fileSystem.addDir("root","DIR 03");
//			fileSystem.addFile("DIR 02","File 05" , 1);
//			fileSystem.systemInfo();
			fileSystem.delete("root");
			
			//fileSystem.systemInfo();
			
			fileSystem.intialRoot("nadav");
			fileSystem.addFile("nadav","File 01" , 533333333);
			fileSystem.addFile("nadav","File 02" , 1);
			fileSystem.addDir("nadav","DIR 02");
			fileSystem.addDir("nadav","DIR 03");
			fileSystem.delete("File 02");
			fileSystem.addFile("nadav","File 03" , 1);
			fileSystem.addDir("DIR 03","DIR 04");
			//fileSystem.addFile("DIR 02","File 05" , 1);
			fileSystem.delete("DIR 03");
			//fileSystem.systemInfo();
			fileSystem.addDir("DIR 02","DIR 08");
			fileSystem.addDir("DIR 08","DIR 09");
			fileSystem.addDir("DIR 09","DIR 043");
			fileSystem.addFile("DIR 043","22222" ,1);
			fileSystem.addDir("DIR 99","DIR 4f3");
			//fileSystem.delete("DIR 02");
			fileSystem.systemInfo();
	}

}
