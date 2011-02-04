import checkers.nullness.quals.*;

// @skip-test
/*
 * Miscellaneous tests based on problems found when checking Daikon.
 */
public class DaikonTests {

    // Based on a problem found in PPtSlice.
    class Bug1 {
        @Nullable Object field;
        
        public void cond1() {
            if ( this.hashCode() > 6 && Bug1Other.field != null ) {
                // spurious dereference error
                Bug1Other.field.toString();
            }
        }
        public void cond1(Bug1 p) {
            if ( this.hashCode() > 6 && p.field != null ) {
                // works
                p.field.toString();
            }
        }
        public void cond2() {
            if ( Bug1Other.field != null && this.hashCode() > 6 ) {
                // works
                Bug1Other.field.toString();
            }
        }
    }
    
    // Based on problem found in PptCombined.
    // Not yet able to reproduce the problem :-(
    
    class Bug2Data {
        Bug2Data(Bug2Super o) {}
    }
    
    class Bug2Super {
        public @LazyNonNull Bug2Data field;
    }
    
    class Bug2 extends Bug2Super {
        private void m() {
            field = new Bug2Data(this);
            field.hashCode();
        }
    }
    
    // Based on problem found in FloatEqual.
    class Bug3 {
        /*@AssertNonNullIfTrue("derived")*/
        public boolean isDerived() {
            return (derived != null);
        }
        @Nullable Object derived;
        
        void bad(Bug3 v1) {
            if (!v1.isDerived() || !(5 > 9))
                return;
            // unexpected dereference raised here.
            // parsing the condition does not work good enough.
            v1.derived.hashCode();
        }
        
        void good(Bug3 v1) {
            if (!(v1.isDerived() && (5 > 9)))
                return;
            v1.derived.hashCode();
        }
    }
 
    // Based on problem found in PrintInvariants.
    // Not yet able to reproduce the problem :-(

    class Bug4 {
        @LazyNonNull Object field;
        
        void m(Bug4 p) {
            if (false && p.field != null)
                p.field.hashCode();
        }
    }
}

class Bug1Other {
    static @Nullable Object field;
}
