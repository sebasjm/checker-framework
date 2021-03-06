package java.util;
import org.checkerframework.dataflow.qual.Pure;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.checkerframework.checker.nullness.qual.PolyNull;

// Subclasses of this interface/class may opt to prohibit null elements
public interface Collection<E extends @Nullable Object> extends Iterable<E> {
  @Pure public abstract int size();
  @Pure public abstract boolean isEmpty();
  // not true, because map could contain nulls:  AssertParametersNonNull("get(#1)")
  @Pure public abstract boolean contains(@Nullable Object a1);
  public abstract Iterator<E> iterator();
  // The Nullness Checker does NOT use these signatures for either version
  // of toArray; rather, the checker has hard-coded rules for those two
  // methods, because the most useful type for toArray is not expressible
  // in the surface syntax that the nullness annotations support.
  public abstract Object [] toArray();
  public abstract <T extends @Nullable Object> @Nullable T @PolyNull [] toArray(T @PolyNull [] a1);
  public abstract boolean add(E a1);
  public abstract boolean remove(@Nullable Object a1);
  @Pure public abstract boolean containsAll(Collection<?> a1);
  public abstract boolean addAll(Collection<? extends E> a1);
  public abstract boolean removeAll(Collection<?> a1);
  public abstract boolean retainAll(Collection<?> a1);
  public abstract void clear();
  @Pure public abstract boolean equals(@Nullable Object a1);
  @Pure public abstract int hashCode();
}
