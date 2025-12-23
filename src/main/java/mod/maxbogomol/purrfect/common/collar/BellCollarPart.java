package mod.maxbogomol.purrfect.common.collar;

public class BellCollarPart extends AccessoryCollarPart {

    public BellCollarPart(String id) {
        super(id);
    }

    @Override
    public boolean isBell() {
        return true;
    }

    @Override
    public boolean isBellSound() {
        return true;
    }
}
