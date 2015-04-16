/*
 *      Kyle Asaff
 *
 *      
 *      RouterEntry.java
 *      Object for router entries
 *      
 */

public class RouterEntry {
	String mask;
	String dest;
	String nexthop;
	String flags;
	String intf;
	
	// Constructor
	public RouterEntry(String mask, String dest, String nexthop, String flags, String intf) {
		this.mask = mask;
		this.dest = dest;
		this.nexthop = nexthop;
		this.flags = flags;
		this.intf = intf;
	}

	public String getMask() {
		return mask;
	}


	public void setMask(String mask) {
		this.mask = mask;
	}


	public String getDest() {
		return dest;
	}


	public void setDest(String dest) {
		this.dest = dest;
	}


	public String getNexthop() {
		return nexthop;
	}


	public void setNexthop(String nexthop) {
		this.nexthop = nexthop;
	}


	public String getFlags() {
		return flags;
	}


	public void setFlags(String flags) {
		this.flags = flags;
	}


	public String getIntf() {
		return intf;
	}


	public void setIntf(String intf) {
		this.intf = intf;
	}
	
}
