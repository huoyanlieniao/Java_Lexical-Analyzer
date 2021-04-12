package Mod;

import java.util.ArrayList;
import java.util.Arrays;

public class delimiters extends Mod {
    public delimiters() {
        super.type = 5;
        super.arrayList = new ArrayList<>(Arrays.asList(";", ",",".","[","]","(",")"));
    }

    @Override
    @SuppressWarnings("all")
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof delimiters)) return false;
        final delimiters other = (delimiters) o;
        if (!other.canEqual((Object) this)) return false;
        return true;
    }

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    protected boolean canEqual(final Object other) {
        return other instanceof delimiters;
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
        return "delimiters()";
    }
    //</editor-fold>
}
