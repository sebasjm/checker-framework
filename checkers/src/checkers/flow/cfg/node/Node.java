package checkers.flow.cfg.node;

import checkers.flow.util.NodeUtils;

import com.sun.source.tree.Tree;

/**
 * A node in the abstract representation used for Java code inside a basic
 * block.
 * 
 * @author Stefan Heule
 * 
 */
public abstract class Node {

	/**
	 * Returns the {@link Tree} in the abstract synatx tree, or
	 * <code>null</code> if no corresponding tree exists. For instance, this is
	 * the case for an {@link ImplicitThisLiteralNode}.
	 * <p>
	 * 
	 * <em>Important:</em> If this method returns <code>null</code>, then the
	 * node is not of a boolean type (cf. {@link NodeUtils.isBooleanTypeNode}).
	 * 
	 * @return The corresponding {@link Tree} or <code>null</code>.
	 */
	abstract public Tree getTree();

	/**
	 * Accept method of the visitor pattern
	 * 
	 * @param <R>
	 *            Result type of the operation.
	 * @param <P>
	 *            Parameter type.
	 * @param visitor
	 *            The visitor to be applied to this node.
	 * @param p
	 *            The parameter for this operation.
	 */
	public abstract <R, P> R accept(NodeVisitor<R, P> visitor, P p);

}