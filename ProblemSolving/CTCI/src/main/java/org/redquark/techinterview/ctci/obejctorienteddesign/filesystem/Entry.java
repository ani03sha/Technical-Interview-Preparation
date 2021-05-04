package org.redquark.techinterview.ctci.obejctorienteddesign.filesystem;

/**
 * @author Anirudh Sharma
 * <p>
 * This class represents and enttty of the file system.
 * An entry can be a directory or a file
 */
public abstract class Entry {

    // Parent of this entry object.
    // A parent can be of directory type only.
    private final Directory parent;
    private final long createdAt;
    private final long lastUpdatedAt;
    private final long lastAccessedAt;
    private String name;

    public Entry(String name, Directory parent) {
        this.name = name;
        this.parent = parent;
        this.createdAt = System.currentTimeMillis();
        this.lastUpdatedAt = System.currentTimeMillis();
        this.lastAccessedAt = System.currentTimeMillis();
    }

    /**
     * This method returns the size of the entry object.
     * Be it a file or a directory
     *
     * @return - size of the entry object
     */
    public abstract int size();

    /**
     * This method deletes the current entry from the memory
     *
     * @return true, if file deletion is successful, false otherwise
     */
    public boolean delete() {
        if (parent == null) {
            return false;
        }
        return parent.deleteEntry(this);
    }

    /**
     * This method changes the name of the entry object
     *
     * @param name - new name
     */
    public void changeName(String name) {
        this.name = name;
    }

    public String getFullPath() {
        if (parent == null) {
            return name;
        }
        return (parent.getFullPath() + "/" + name).replaceAll("//", "/");
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public long getLastUpdatedAt() {
        return lastUpdatedAt;
    }

    public long getLastAccessedAt() {
        return lastAccessedAt;
    }

    public String getName() {
        return name;
    }
}
