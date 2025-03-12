package bluesteel42.usefulcactus;

import bluesteel42.usefulcactus.entity.ModBoats;
import com.terraformersmc.terraform.boat.api.client.TerraformBoatClientHelper;
import net.fabricmc.api.ClientModInitializer;

public class UsefulCactusClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // Register Boat Model
        TerraformBoatClientHelper.registerModelLayers(ModBoats.CHOLLA_RAFTS_ID);
    }
}
