package pocketgems.mud.components;

import pocketgems.mud.Entity;
import pocketgems.mud.exceptions.ComponentNotFoundException;
import pocketgems.mud.exceptions.EntityNotFoundException;
import pocketgems.mud.World;

/*
 * LocationComponent
 * =================
 * Put this component on entities that can exist in a room.
 */
public class LocationComponent extends Component {
	public String roomId;

	public Entity room(World world) throws EntityNotFoundException {
		if (roomId == null) {
			return null;
		}
		return world.GetEntity(roomId);
	}
	
	public void CleanUp(World world) throws EntityNotFoundException, ComponentNotFoundException {
		Entity entity = room(world);
		
		RoomComponent room = entity.getComponentOrNull(RoomComponent.class);
		if(room != null)
		{
			room.inhabitantIds.remove(getEntity().getIdentityComponent().id);
		}
		
		InventoryComponent inv = entity.getComponentOrNull(InventoryComponent.class);
		if(inv != null)
		{
			inv.itemIds.remove(getEntity().getIdentityComponent().id);
		}
	}
}