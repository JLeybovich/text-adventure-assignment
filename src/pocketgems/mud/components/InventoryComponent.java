package pocketgems.mud.components;

import java.util.HashSet;

import pocketgems.mud.Entity;
import pocketgems.mud.World;
import pocketgems.mud.exceptions.ComponentNotFoundException;
import pocketgems.mud.exceptions.EntityNotFoundException;

/*
 * InventoryComponent
 * ==================
 * The player has an InventoryComponent, which allows them to get and drop items.
 */
public class InventoryComponent extends Component {
	public HashSet<String> itemIds;
	
	public InventoryComponent() {
		itemIds = new HashSet<String>();
	}
	
	public void CleanUp(World world) throws EntityNotFoundException, ComponentNotFoundException  {
		for(String id : itemIds) {
			world.RemoveEntity(id);
		}
	}
}
