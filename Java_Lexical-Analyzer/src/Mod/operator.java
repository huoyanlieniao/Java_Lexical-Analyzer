package Mod;

import java.util.ArrayList;
import java.util.Arrays;

public class operator extends Mod {
    public operator() {
        super.type = 4;
        super.arrayList = new ArrayList<>(Arrays.asList("+", "-", "*", "/", "=", ">", "<", ">=", "<=", ":="));
    }

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @Override
    @SuppressWarnings("all")
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof operator)) return false;
        final operator other = (operator) o;
        if (!other.canEqual((Object) this)) return false;
        return true;
    }

    @SuppressWarnings("all")
    protected boolean canEqual(final Object other) {
        return other instanceof operator;
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
        return "operator()";
    }
    //</editor-fold>
}
