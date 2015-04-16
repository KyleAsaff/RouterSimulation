# RouterSimulation

This program simulates how packet routing works inside of a router. The program accepts input as the following:

- **table.txt** - A text file containing a routing table (the five column generic routing table with mask, destination address, next hop, flag and interface). 

- **table_packets.txt** - A text file containing a list of packets (with just destination addresses) and produces an output showing a list of how each packet will be handled by the router.

Using these input files, RouterSimulation will work for any routing table and any packet. It also works for both network specific and host specific entries. This simulation does not consider subnetting, that is, the masks can be the default ones for Class A (255.0.0.0), Class B (255.255.0,0) and Class C (255.255.255.0). The files table.txt and packets.txt can be edited to run a simulation with a different routing table and packets.
