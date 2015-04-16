/*
 *      Kyle Asaff
 *      CSCI 4171 A3Q1
 *      
 *      Main.java
 *      Generates where to send a packet with a given routing table and packet destination.
 *      
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		List<RouterEntry> RouterTable = new ArrayList<RouterEntry>();
		List<PacketEntry> PacketTable = new ArrayList<PacketEntry>();
		
		// Read in router table
		try {
			FileReader file = new FileReader("table.txt");
			BufferedReader buff = new BufferedReader(file);
			String line = buff.readLine();
			
			// Skip first line (table headers)
			line = buff.readLine();

			while (line != null) {
				// Split up entries by white space and store entries in router table
				String elements[] = line.split("\\s+");
				RouterTable.add(new RouterEntry(elements[0], elements[1], elements[2], elements[3], elements[4]));
				line = buff.readLine();
			}
			buff.close();
		} catch (IOException e) {
			System.out.println("No such file");
			System.exit(0);
		}
		
		// Read in packets
		try {
			FileReader file = new FileReader("packets.txt");
			BufferedReader buff = new BufferedReader(file);
			String line = buff.readLine();
			
			// Skip first line (table headers)
			line = buff.readLine();

			while (line != null) {
				// Split up entries by white space and store entries in router table
				String elements[] = line.split("\\s+");
				PacketTable.add(new PacketEntry(elements[0], elements[1]));
				line = buff.readLine();
			}
			buff.close();
		} catch (IOException e) {
			System.out.println("No such file");
			System.exit(0);
		}
		
		// Make a list of Possible Masks and sort them
		List<String> PossibleMasks = new ArrayList<String>();
		for(int i = 0; i<RouterTable.size(); i++) {
			if(!PossibleMasks.contains(RouterTable.get(i).getMask()))
				PossibleMasks.add(RouterTable.get(i).getMask());
		}
		
		// Order PossibleMasks with highest mask first
		Collections.sort(PossibleMasks, Collections.reverseOrder());
		
		// Check all packets to be sent with Router Table
		for(int i = 0; i<PacketTable.size(); i++) {
			String flags = "";
			String intf = "";
			String hop = "";
			String originalDest = "";
			outerloop:
			// Check all packets with all possible Masks to find a match
			for(int j = 0; j<PossibleMasks.size(); j++) {
				String dest = "";
				originalDest = PacketTable.get(i).getDest();
				String mask = PossibleMasks.get(j);
				String[] packetDest = originalDest.split("\\.");
				String[] currentMask = mask.split("\\.");
				
				// Perform AND operation on packet destination and RouterTable mask
				for(int k = 0; k<4; k++) {
					int a = Integer.parseInt(packetDest[k]);
					int b = Integer.parseInt(currentMask[k]);
					int c = a&b;
					if(k<3)
						dest += c+".";
					else
						dest += c;
				}
				
				// Check for a match in the Router Table
				for(int k = 0; k<RouterTable.size(); k++) {
					if(dest.equals(RouterTable.get(k).getDest()) && dest.equals(RouterTable.get(k).getDest())) {
						flags = RouterTable.get(k).getFlags();
						intf = RouterTable.get(k).getIntf();
						hop = RouterTable.get(k).getNexthop();
						break outerloop;
					}
				}	
			}
			// Print where to route packet
			System.out.println("Packet with destination address "+originalDest+" will be forwarded to "+hop+" out on interface "+intf+" (with flag: "+flags+").");
		}
		
	}
}
