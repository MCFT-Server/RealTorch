package realtorch;

import cn.nukkit.Player;
import cn.nukkit.block.Block;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerMoveEvent;
import cn.nukkit.level.Level;
import cn.nukkit.plugin.PluginBase;

public class RealTorch extends PluginBase implements Listener{
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
	}
	@EventHandler
	public void onMove(PlayerMoveEvent event) {
		Player player = event.getPlayer();
		Level level = player.getLevel();
		if (player.getInventory().getItemInHand().getId() == Block.TORCH && level.getBlock(player.add(0, 2, 0)).getId() == Block.AIR) {
			level.setBlock(player.add(0, 2, 0), Block.get(Block.FIRE));
			level.updateAllLight(player.add(0, 2, 0));
			level.setBlock(player.add(0, 2, 0), Block.get(Block.AIR));
		}
	}
}
