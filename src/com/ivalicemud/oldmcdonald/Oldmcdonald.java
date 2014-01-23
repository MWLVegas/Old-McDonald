package com.ivalicemud.oldmcdonald;

//import java.util.logging.Logger;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;


public final class Oldmcdonald extends JavaPlugin{
	
	static int cowsummon = 334;
	static int pigsummon = 319;
	static int sheepsummon = 35;
	static int shroomsummon = 7;
	static 	int chickensummon = 288;
	
	static int cowsummon2 = 334;
	static int pigsummon2 = 319;
	static int sheepsummon2 = 35;
	static int shroomsummon2 = 7;
	static 	int chickensummon2 = 288;
	
	static int cowfail = 25;
	static int pigfail = 15;
	static int sheepfail = 20;
	static int shroomfail = 75;
	static int chickenfail = 20;
	
	static int cowamt = 20;
	static int pigamt = 20;
	static int sheepamt = 20;
	static int shroomamt = 20;
	static int chickenamt = 20;
	
	static int max = 3;
	static int radius = 20;
	static String disabledworlds = "";
	
	FileConfiguration config;
	
	
	 public void onEnable() {
	       
	        try {
	        	config = getConfig();
	        	File Oldmcdonald = new File("plugins" + File.separator + "OldMcDonald" + File.separator + "config.yml");
	        	Oldmcdonald.mkdir();
	          	
	        	if (!config.contains("general.radius")) config.set("general.radius",20);  	
	        	if (!config.contains("general.cow.summon")) config.set("general.cow.summon",334);
	        	if (!config.contains("general.cow.summon2")) config.set("general.cow.summon2",0);
	        	if (!config.contains("general.cow.fail")) config.set("general.cow.fail",25);
	        	if (!config.contains("general.cow.amount")) config.set("general.cow.amount",20);
	        		          	
	        	if (!config.contains("general.pig.summon")) config.set("general.pig.summon",319);
	        	if (!config.contains("general.pig.summon2")) config.set("general.pig.summon2",0);
	        	if (!config.contains("general.pig.fail")) config.set("general.pig.fail",25);
	        	if (!config.contains("general.pig.amount")) config.set("general.pig.amount",20);
	          	
	        	if (!config.contains("general.sheep.summon")) config.set("general.sheep.summon",35);
	        	if (!config.contains("general.sheep.summon2")) config.set("general.sheep.summon2",0);
	        	if (!config.contains("general.sheep.fail")) config.set("general.sheep.fail",25);
	        	if (!config.contains("general.sheep.amount")) config.set("general.sheep.amount",20);
	          	
	        	if (!config.contains("general.chicken.summon")) config.set("general.chicken.summon",288);
	        	if (!config.contains("general.chicken.summon")) config.set("general.chicken.summon",0);
	        	if (!config.contains("general.chicken.fail")) config.set("general.chicken.fail",25);
	        	if (!config.contains("general.chicken.amount")) config.set("general.chicken.amount",20);
	          	
	        	if (!config.contains("general.shroom.summon")) config.set("general.shroom.summon",334);
	        	if (!config.contains("general.shroom.summon2")) config.set("general.shroom.summon2",40);
	        	if (!config.contains("general.shroom.fail")) config.set("general.shroom.fail",25);
	        	if (!config.contains("general.shroom.amount")) config.set("general.shroom.amount",20);
	        	
	        	if (!config.contains("general.max"))	        	config.set("general.max",3);
	        	if (!config.contains("general.disabledworlds"))   	config.set("general.disabledworlds", "");
	        	
	        	 
	        	cowsummon = config.getInt("general.cow.summon");
	        	cowsummon2 = config.getInt("general.cow.summon2");
	        	
	        	cowfail = config.getInt("general.cow.fail");
	        	cowamt = config.getInt("general.cow.amount");
	        			
	        	pigsummon = config.getInt("general.pig.summon");
	        	pigsummon2 = config.getInt("general.pig.summon2");
	        	pigfail = config.getInt("general.pig.fail");
	        	pigamt = config.getInt("general.pig.amount");
	        			
	        	sheepsummon = config.getInt("general.sheep.summon");
	        	sheepsummon2 = config.getInt("general.sheep.summon2");
	        	sheepfail = config.getInt("general.sheep.fail");
	        	sheepamt = config.getInt("general.sheep.amount");
	        			
	        	chickensummon = config.getInt("general.chicken.summon");
	        	chickensummon2 = config.getInt("general.chicken.summon2");
	        	chickenfail = config.getInt("general.chicken.fail");
	        	chickenamt = config.getInt("general.chicken.amount");
	        			
	        	shroomsummon = config.getInt("general.shroom.summon");
	        	shroomsummon2 = config.getInt("general.shroom.summon2");
	        	shroomfail = config.getInt("general.shroom.fail");
	        	shroomamt = config.getInt("general.cow.amount");
	        	radius = config.getInt("general.radius");
	        	max = config.getInt("general.max");
	        	disabledworlds = config.getString("general.disabledworlds");
	        	saveConfig();
	        	
	        }catch(Exception e1){
	        	e1.printStackTrace();
	        }
	        getServer().getPluginManager().registerEvents(new Listeners(), this);
	 	   
	        
	    }
		
	
	
	    @Override
	    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
	    	if(cmd.getName().equalsIgnoreCase("old")){ // If the player typed /basic then do the following...
	    		sender.sendMessage("Old McDonald Config:");
	    		sender.sendMessage("Distance to Search for Duplicates: "+radius);
	    		sender.sendMessage("Max amount before auto-fail in Radius: "+ max);
	    		if ( pigamt != 0 ) { sender.sendMessage("Pig Summon Item: " + pigamt + " " +  Material.getMaterial(pigsummon) +"- Failure Rate " + pigfail);}
	    		if ( cowamt != 0 ) { sender.sendMessage("Cow Summon Item: " + cowamt + " "  +  Material.getMaterial(cowsummon) +"- Failure Rate " + cowfail);}
	    		if ( sheepamt != 0 ) { sender.sendMessage("Sheep Summon Item: " + sheepamt + " "  +  Material.getMaterial(sheepsummon) +"- Failure Rate " + sheepfail);}
	    		if ( chickenamt != 0 ) { sender.sendMessage("Chicken Summon Item: " + chickenamt + " "  +  Material.getMaterial(chickensummon) +"- Failure Rate " + chickenfail);}
	    		if ( shroomamt != 0 ) { sender.sendMessage("Mooshroom Summon Item: " + shroomamt + " "  +  Material.getMaterial(shroomsummon) +"- Failure Rate " + shroomfail);}
	    		return true;
	    	} 
	    	return false; 
	    }
	    
	 
	  	    
	  
}

