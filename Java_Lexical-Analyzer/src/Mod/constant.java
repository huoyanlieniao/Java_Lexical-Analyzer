package Mod;

import java.util.ArrayList;
import java.util.Arrays;

public class constant extends Mod {
    public constant() {
        super.type = 2;
        super.arrayList = new ArrayList<String>(Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9"));
    }

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @Override
    @SuppressWarnings("all")
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof constant)) return false;
        final constant other = (constant) o;
        if (!other.canEqual((Object) this)) return false;
        return true;
    }

    @SuppressWarnings("all")
    protected boolean canEqual(final Object other) {
        return other instanceof constant;
    }

    @Override
    @SuppressWarnings("all")
    public int hashCode() {
        final int result = 1;
        return result;
    }

    @Override
    @SuppressWarnings("all")
    public String toString() {
        return "constant()";
    }
    //</editor-fold>
}
