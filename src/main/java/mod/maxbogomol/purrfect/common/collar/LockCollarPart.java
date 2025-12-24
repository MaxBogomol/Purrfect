package mod.maxbogomol.purrfect.common.collar;

public class LockCollarPart extends AccessoryCollarPart {

    public LockCollarPart(String id) {
        super(id);
    }

    @Override
    public boolean isLock() {
        return true;
    }
}
