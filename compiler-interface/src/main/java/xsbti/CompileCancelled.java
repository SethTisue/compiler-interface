/*
 * Compiler Interface
 *
 * Copyright 2011 - 2019, Lightbend, Inc.
 * Copyright 2008 - 2010, Mark Harrah
 *
 * Licensed under Apache License 2.0
 * (http://www.apache.org/licenses/LICENSE-2.0).
 */

package xsbti;

/**
 * Represent the cancellation of a compilation run. This failure extends
 * {@link RuntimeException} that you can catch at the use-site.
 */
public abstract class CompileCancelled extends RuntimeException {
    /** Return an array of the initial arguments of the compiler. */
	public abstract String[] arguments();
}
