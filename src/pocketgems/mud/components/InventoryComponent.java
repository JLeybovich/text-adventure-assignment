package pocketgems.mud.components;

import java.util.HashSet;

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
}
