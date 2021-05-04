package org.redquark.techinterview.ctci.obejctorienteddesign.filesystem;

public class File extends Entry {

    private final int size;
    private String content;

    public File(String name, Directory parent, int size) {
        super(name, parent);
        this.size = size;
    }

    /**
     * This method returns the size of the entry object.
     * Be it a file or a directory
     *
     * @return - size of the entry object
     */
    @Override
    public int size() {
        return size;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
