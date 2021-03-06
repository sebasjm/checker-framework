package tests.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

import org.checkerframework.framework.qual.DefaultQualifierInHierarchy;
import org.checkerframework.framework.qual.SubtypeOf;
import org.checkerframework.framework.qual.TypeQualifier;

/** A supertype of SubQual. */
@TypeQualifier
@SubtypeOf({})
@DefaultQualifierInHierarchy
@Target({ElementType.TYPE_USE, ElementType.TYPE_PARAMETER})
public @interface SuperQual {}
