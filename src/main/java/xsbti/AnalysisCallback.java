/* sbt -- Simple Build Tool
 * Copyright 2008, 2009  Mark Harrah
 */
package xsbti;

import xsbti.api.DependencyContext;
import java.io.File;

public interface AnalysisCallback {
    void startSource(File source);
    /** Called to indicate that the class <code>sourceClassName</code> depends on the class
     * <code>onClassName</code>.  Note that only classes defined in source files included in the current compilation will
     * passed to this method.  Dependencies on classes generated by sources not in the current compilation will
     * be passed as binary dependencies to the `binaryDependency` method.
     * <code>context</code> gives information about the context in which this dependency has been extracted.
     * See xsbti.DependencyContext for the list of existing dependency contexts. */
    void classDependency(String onClassName, String sourceClassName, DependencyContext context);
    /** Called to indicate that the class <code>fromClassName</code> depends on a
     * class named <code>onBinaryClassName</code> from class or jar file <code>binary</code>.
     * The <code>onBinaryClassName</code> is a binary name where inner classes are separated with $. Check Java
     * Language Specification 13.1 for details on binary name format.
     * <code>context</code> gives information about the context in which this dependency has been extracted.
     * See xsbti.DependencyContext for the list of existing dependency contexts. */
    void binaryDependency(File onBinary, String onBinaryClassName, String fromClassName, File fromSourceFile, DependencyContext context);
    /** Called to indicate that the source file <code>source</code> produces a class file at
     * <code>module</code> contain class <code>name</code>.*/
    void generatedNonLocalClass(File source, File classFile, String binaryClassName, String srcClassName);
    void generatedLocalClass(File source, File classFile);
    /** Called when the public API of a source file is extracted. */
    void api(File sourceFile, xsbti.api.ClassLike classApi);
    void usedName(String className, String name);
    /** Provides problems discovered during compilation.  These may be reported (logged) or unreported.
     * Unreported problems are usually unreported because reporting was not enabled via a command line switch. */
    void problem(String what, Position pos, String msg, Severity severity, boolean reported);
    /**
     * Determines whether method calls through this interface should be interpreted as serving
     * name hashing algorithm needs in given compiler run.
     *
     * In particular, it indicates whether member reference and inheritance dependencies should be
     * extracted.
     *
     * As the signature suggests, this method's implementation is meant to be side-effect free. It's added
     * to AnalysisCallback because it indicates how other callback calls should be interpreted by both
     * implementation of AnalysisCallback and it's clients.
     *
     * NOTE: This method is an implementation detail and can be removed at any point without deprecation.
     *       Do not depend on it, please.
     */
    boolean nameHashing();

    /** Called at the end of dependency phase. Can be used e.g. to wait on asynchronous tasks. */
    void dependencyPhaseCompleted();

    /** Called at the end of dependency phase. Can be used e.g. to wait on asynchronous tasks. */
    void apiPhaseCompleted();

    /** Determines if incremental compilation is enabled.
     * If returns false, only xsbt-analyzer phase will be added (in order to report generated classes) */
    boolean enabled();
}