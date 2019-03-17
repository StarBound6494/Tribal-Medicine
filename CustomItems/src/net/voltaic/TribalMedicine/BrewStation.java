package net.voltaic.TribalMedicine;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.bukkit.block.Block;

public class BrewStation {
	
	FileReader in = null;
	FileWriter out = null;
	
	BrewStation(Block block) throws IOException {
		
		try {
		in = new FileReader("BrewStations.txt");
		out = new FileWriter("BrewStations.txt");
		
		} finally {
			in.close();
			out.close();
		}
		
		
	}
}
