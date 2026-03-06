package mod.maxbogomol.purrfect.api.furry;

import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.util.GsonHelper;

public class CollarPartUtil {

    public static CollarPart deserializeCollarPartColor(JsonObject json) {
        String collarPartName = GsonHelper.getAsString(json, "collar_part");
        CollarPart collarPart = CollarPartHandler.COLOR.getCollarPart(collarPartName);
        if (collarPart == null) {
            throw new JsonSyntaxException("Unknown collar part " + collarPartName);
        }
        return collarPart;
    }

    public static CollarPart collarPartColorFromNetwork(FriendlyByteBuf buffer) {
        return !buffer.readBoolean() ? null : CollarPartHandler.COLOR.getCollarPart(buffer.readComponent().getString());
    }

    public static CollarPart deserializeCollarPartAccessory(JsonObject json) {
        String collarPartName = GsonHelper.getAsString(json, "collar_part");
        CollarPart collarPart = CollarPartHandler.ACCESSORY.getCollarPart(collarPartName);
        if (collarPart == null) {
            throw new JsonSyntaxException("Unknown collar part " + collarPartName);
        }
        return collarPart;
    }

    public static CollarPart collarPartAccessoryFromNetwork(FriendlyByteBuf buffer) {
        return !buffer.readBoolean() ? null : CollarPartHandler.ACCESSORY.getCollarPart(buffer.readComponent().getString());
    }

    public static CollarPart deserializeCollarPartDecoration(JsonObject json) {
        String collarPartName = GsonHelper.getAsString(json, "collar_part");
        CollarPart collarPart = CollarPartHandler.DECORATION.getCollarPart(collarPartName);
        if (collarPart == null) {
            throw new JsonSyntaxException("Unknown collar part " + collarPartName);
        }
        return collarPart;
    }

    public static CollarPart collarPartDecorationFromNetwork(FriendlyByteBuf buffer) {
        return !buffer.readBoolean() ? null : CollarPartHandler.DECORATION.getCollarPart(buffer.readComponent().getString());
    }

    public static void collarPartToNetwork(CollarPart collarPart, FriendlyByteBuf buffer) {
        if (collarPart == null) {
            buffer.writeBoolean(false);
        } else {
            buffer.writeBoolean(true);
            buffer.writeComponent(Component.literal(collarPart.getId()));
        }
    }
}
