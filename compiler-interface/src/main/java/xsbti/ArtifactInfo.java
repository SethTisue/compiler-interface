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
 * Define constants of Scala compiler useful for artifact resolution.
 */
public final class ArtifactInfo {
	/** Define the name of the Scala organization. */
	public static final String ScalaOrganization = "org.scala-lang";

	/** Define the name used to identify the sbt organization. */
	public static final String SbtOrganization = "org.scala-sbt";

	/** Define the ID used to identify the Scala library. */
	public static final String ScalaLibraryID = "scala-library";

	/** Define the ID used to identify the Scala compiler. */
	public static final String ScalaCompilerID = "scala-compiler";
}