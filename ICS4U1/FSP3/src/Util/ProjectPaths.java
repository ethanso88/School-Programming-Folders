package Util;

import java.io.File;
import java.net.URISyntaxException;

/**
 * Finds the project folder (the one that holds Data/ and Icons/) so the app
 * runs from any clone location: VS Code, IntelliJ, or javac/java in a terminal.
 *
 * Order tried: -Dnmda.root=<path>, then up from where the classes were loaded
 * (bin/, out/), then up from the working directory. Each step also looks for a
 * FSP3/ or ICS4U1/FSP3/ child, so running from the repo root works too.
 */
public final class ProjectPaths {

    private static File root;

    private ProjectPaths() {}

    /** The folder containing Data/ and Icons/. */
    public static synchronized File root() {
        if (root == null) {
            root = locate();
        }
        return root;
    }

    /** A file inside Data/. */
    public static File data(String fileName) {
        return new File(new File(root(), "Data"), fileName);
    }

    /** A file inside Icons/. */
    public static File icon(String fileName) {
        return new File(new File(root(), "Icons"), fileName);
    }

    private static File locate() {
        String override = System.getProperty("nmda.root");
        if (override != null && isRoot(new File(override))) {
            return new File(override).getAbsoluteFile();
        }
        try {
            File classes = new File(ProjectPaths.class.getProtectionDomain().getCodeSource().getLocation().toURI());
            File found = walkUp(classes);
            if (found != null) {
                return found;
            }
        } catch (URISyntaxException | SecurityException | NullPointerException ignored) {
            // fall through to the working directory
        }
        File found = walkUp(new File(System.getProperty("user.dir")).getAbsoluteFile());
        if (found != null) {
            return found;
        }
        throw new IllegalStateException(
            "Could not find the project folder (the one with Data/ and Icons/). "
            + "Run from inside it, or start java with -Dnmda.root=<path to that folder>.");
    }

    private static File walkUp(File start) {
        for (File dir = start; dir != null; dir = dir.getParentFile()) {
            if (isRoot(dir)) {
                return dir;
            }
            File child = new File(dir, "FSP3");
            if (isRoot(child)) {
                return child;
            }
            File grandchild = new File(new File(dir, "ICS4U1"), "FSP3");
            if (isRoot(grandchild)) {
                return grandchild;
            }
        }
        return null;
    }

    private static boolean isRoot(File dir) {
        return new File(dir, "Data").isDirectory() && new File(dir, "Icons").isDirectory();
    }
}
