/*
 *      Kyle Asaff
 * 
 *      
 *      PacketEntry.java
 *      Object for Packet entries
 *      
 */

public class PacketEntry {
	String name;
	String dest;
	
	// Constructor
	public PacketEntry(String name, String dest) {
		this.name = name;
		this.dest = dest;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDest() {
		return dest;
	}


	public void setDest(String dest) {
		this.dest = dest;
	}
	
}
