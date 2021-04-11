package Mod;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.Arrays;

public class identifier extends Mod {
    public identifier() {
        super.type = 1;
        super.arrayList = new ArrayList<>();
    }

    @Override
    @SuppressWarnings("all")
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof identifier)) return false;
        final identifier other = (identifier) o;
        if (!other.canEqual((Object) this)) return false;
        return true;
    }

    @SuppressWarnings("all")
    protected boolean canEqual(final Object other) {
        return other instanceof identifier;
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
        return "identifier()";
    }
}
