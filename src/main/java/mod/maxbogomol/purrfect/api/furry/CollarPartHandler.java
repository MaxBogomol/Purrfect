package mod.maxbogomol.purrfect.api.furry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CollarPartHandler {
    public Map<String, CollarPart> collarParts = new HashMap<>();
    public ArrayList<CollarPart> collarPartList = new ArrayList<>();

    public static CollarPartHandler COLOR = new CollarPartHandler();
    public static CollarPartHandler ACCESSORY = new CollarPartHandler();
    public static CollarPartHandler DECORATION = new CollarPartHandler();

    public void addCollarPart(String id, CollarPart part) {
        collarParts.put(id, part);
        collarPartList.add(part);
    }

    public CollarPart getCollarPart(int id) {
        return collarParts.get(id);
    }

    public CollarPart getCollarPart(String id) {
        return collarParts.get(id);
    }

    public void register(CollarPart part) {
        collarParts.put(part.getId(), part);
        collarPartList.add(part);
    }

    public int size() {
        return collarParts.size();
    }

    public ArrayList<CollarPart> getCollarParts() {
        return collarPartList;
    }
}
