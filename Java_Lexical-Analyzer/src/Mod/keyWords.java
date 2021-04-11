package Mod;

import java.util.ArrayList;
import java.util.Arrays;

public class keyWords extends Mod {
    public keyWords() {
        super.type = 3;
        super.arrayList = new ArrayList<>(Arrays.asList("if", "then", "else", "while", "do", "and"));
    }

    @Override
    @SuppressWarnings("all")
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof keyWords)) return false;
        final keyWords other = (keyWords) o;
        if (!other.canEqual((Object) this)) return false;
        return true;
    }

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    protected boolean canEqual(final Object other) {
        return other instanceof keyWords;
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
        return "keyWords()";
    }
    //</editor-fold>
}
