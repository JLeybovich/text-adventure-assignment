package pocketgems.mud.components;

import pocketgems.mud.World;
import pocketgems.mud.exceptions.ComponentNotFoundException;
import pocketgems.mud.exceptions.EntityNotFoundException;

/*
 * PortalComponent
 * ===============
 * Contains a room id that represents a destination the player can move to. Used primarily
 * to define the room that an exit entity will take the player to.
 */
public class PortalComponent extends Component {
	public String sourceRoomId;
	public String destinationRoomId;

	public void CleanUp(World world) throws EntityNotFoundException, ComponentNotFoundException 
	{
		world.GetEntity(sourceRoomId).getComponent(
				RoomComponent.class).exitIds.remove(entity.getIdentityComponent().id);
	}
}
