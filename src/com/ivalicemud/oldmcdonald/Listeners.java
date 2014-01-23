package com.ivalicemud.oldmcdonald;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.inventory.ItemStack;

import java.util.List;
import java.util.Random;

public class Listeners implements Listener {

	private String MobTypes[] = {"CHICKEN", "COW", "SHEEP", "PIG", "SKELETON", "MUSHROOMCOW"};
	@SuppressWarnings("rawtypes")
	private Class MobClasses[] = {Chicken.class, Cow.class, Sheep.class, Pig.class, Skeleton.class, MushroomCow.class};
	
	
    @EventHandler
    public void normalLogin(PlayerLoginEvent event) {
        // Some code here
    }

    
    @SuppressWarnings("unchecked")
	@EventHandler
    public void onPlayerInteractBlock(PlayerInteractEvent evt){
    	Player player = evt.getPlayer();
    	
    	int itemId = player.getItemInHand().getTypeId();
    	int amount = player.getItemInHand().getAmount();
    	boolean found = false;
    	int fail = 1;
    	int summon = 1;
    	int amt = 1;
    	   	
    
   		if ( com.ivalicemud.oldmcdonald.Oldmcdonald.disabledworlds.contains( evt.getPlayer().getWorld().getName() )) {
   			player.sendMessage("You cannot use that in this world.");
   			return;
   		}
    	
    	if ( evt.getPlayer().isSneaking() == false ) {
    	//	player.sendMessage("You're not sneaking.");
    		return;
    	}
        
    
        if ( itemId == com.ivalicemud.oldmcdonald.Oldmcdonald.cowsummon ) {
        	amt = com.ivalicemud.oldmcdonald.Oldmcdonald.cowamt;
        	fail = com.ivalicemud.oldmcdonald.Oldmcdonald.cowfail;
        	summon = 2;
            	found = true;
        }
        	else if ( itemId == com.ivalicemud.oldmcdonald.Oldmcdonald.pigsummon ){
        		amt = com.ivalicemud.oldmcdonald.Oldmcdonald.pigamt;
            	fail = com.ivalicemud.oldmcdonald.Oldmcdonald.pigfail;
	        	summon = 4;
	            
            	found = true;
        	}
         	else if ( itemId == com.ivalicemud.oldmcdonald.Oldmcdonald.sheepsummon ){
        		amt = com.ivalicemud.oldmcdonald.Oldmcdonald.sheepamt;
            	fail = com.ivalicemud.oldmcdonald.Oldmcdonald.sheepfail;
	            summon = 3;
            	found = true;
        	}
         	else if ( itemId == com.ivalicemud.oldmcdonald.Oldmcdonald.chickensummon ){
        		amt = com.ivalicemud.oldmcdonald.Oldmcdonald.chickenamt;
            	fail = com.ivalicemud.oldmcdonald.Oldmcdonald.chickenfail;
	            
            	found = true;
        	}
         	else if ( itemId == com.ivalicemud.oldmcdonald.Oldmcdonald.shroomsummon ){
        		amt = com.ivalicemud.oldmcdonald.Oldmcdonald.shroomamt;
            	fail = com.ivalicemud.oldmcdonald.Oldmcdonald.shroomfail;
	            summon = 6;
            	found = true;
        	}
        
        if ( found == false) { return; }
        
        if ( amt == 0 ) { return; }
        	if ( amt > amount ) {
        		evt.getPlayer().sendMessage("You do not have enough " + Material.getMaterial(itemId) + " to do that!" );
        		return;
        	}
        	
        	//evt.getPlayer().sendMessage("Clicking a Summon!" + player.getWorld().getFullTime() );
        	int newamt = amount - amt;
        	player.getItemInHand().setAmount( newamt );
        	
        	ItemStack itemstack = new ItemStack( player.getItemInHand().getType(), amt);
        	player.getInventory().remove(itemstack);
       
        	Random generator = new Random();
        	int randomNum =  generator.nextInt(100) + 1;
        	int i = 0;
        	int num = 0;
        	int radius = com.ivalicemud.oldmcdonald.Oldmcdonald.radius;
        	
        	String mob = "";
        	String mob2 = "";
        	List<Entity> list = evt.getPlayer().getNearbyEntities(radius, radius, radius);
        	while ( i < list.size()) {
        		 evt.getPlayer().sendMessage(player.getWorld().getFullTime() + ":" + list.get(i).getType());
        		     mob = "" + list.get(i).getType();  
        		     mob2 = "" + MobTypes[summon-1];
        		 if (  mob.equals(mob2) ) {
        			         			num++; }
        		i++;
        	}
        	if ( num > com.ivalicemud.oldmcdonald.Oldmcdonald.max ) { randomNum = 1; }
        	//evt.getPlayer().sendMessage("Chance: " + randomNum + " Amount: " + num);
        	if ( randomNum < fail ) {
        		evt.getPlayer().sendMessage("You fail to locate anything.");
        	} else {
        	player.getWorld().spawn(player.getLocation(), MobClasses[summon-1]); 
        	}
        	       	
               
        	       
        	return;
       
    	
        }
  
    
    
}


