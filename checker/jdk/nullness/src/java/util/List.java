package java.util;
import org.checkerframework.dataflow.qual.Pure;
import org.checkerframework.dataflow.qual.SideEffectFree;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.checkerframework.checker.nullness.qual.PolyNull;

// Subclasses of this interface/class may opt to prohibit null elements
public interface List<E extends @Nullable Object> extends Collection<E> {
  @Pure public abstract int size();
  @Pure public abstract boolean isEmpty();
  @Pure public abstract boolean contains(@Nullable Object a1);
  public abstract Iterator<E> iterator();
  // Element annotation should be the same as that on the type parameter E.
  // It's @Nullable here because that is most lenient.
  // Eventually, figure out how to express this, or hard-code in the checker.
  public abstract Object [] toArray();
  // @Nullable because, if there is room in the argument a1, the method
  // puts null after the elements of this.
  public abstract <T extends @Nullable Object> @Nullable T @PolyNull [] toArray(T @PolyNull [] a1);
  public abstract boolean add(E a1);
  public abstract boolean remove(@Nullable Object a1);
  @Pure public abstract boolean containsAll(Collection<?> a1);
  public abstract boolean addAll(Collection<? extends E> a1);
  public abstract boolean addAll(int a1, Collection<? extends E> a2);
  public abstract boolean removeAll(Collection<?> a1);
  public abstract boolean retainAll(Collection<?> a1);
  public abstract void clear();
  @Pure public abstract boolean equals(@Nullable Object a1);
  @Pure public abstract int hashCode();
  @Pure public abstract E get(int a1);
  public abstract E set(int a1, E a2);
  public abstract void add(int a1, E a2);
  public abstract E remove(int a1);
  @Pure public abstract int indexOf(@Nullable Object a1);
  @Pure public abstract int lastIndexOf(@Nullable Object a1);
  public abstract ListIterator<E> listIterator();
  public abstract ListIterator<E> listIterator(int a1);
  @SideEffectFree public abstract List<E> subList(int a1, int a2);
}
