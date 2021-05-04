package org.redquark.techinterview.ctci.obejctorienteddesign.filesystem;

public class Driver {

    public static void main(String[] args) {
        // Create some directories
        Directory root = new Directory("/", null);
        Directory books = new Directory("books", root);
        root.addEntry(books);
        Directory coding = new Directory("coding", books);
        books.addEntry(coding);
        Directory design = new Directory("design", books);
        books.addEntry(design);
        // Create some files
        File booksInfo = new File("booksInfo.txt", books, 10);
        books.addEntry(booksInfo);
        File crackingTheCoding = new File("Cracking_The_Coding_Interview.pdf", coding, 2048);
        coding.addEntry(crackingTheCoding);
        File elementsOfProgramming = new File("Elements_Of_Programming.pdf", coding, 5120);
        coding.addEntry(elementsOfProgramming);
        File systemDesignInterview = new File("System_Design_Interview.pdf", design, 4096);
        design.addEntry(systemDesignInterview);
        File designDataIntensiveApplications = new File("Design_Data_Intensive_Applications.pdf", design, 10240);
        design.addEntry(designDataIntensiveApplications);

        // Setting some content in the file
        booksInfo.setContent("This directory contains files related to coding and system design");
        crackingTheCoding.setContent("Book by Gayle Laakmann Mcdowell");
        elementsOfProgramming.setContent("Book by Adnan Aziz, Amit Prakash, and Tsung-Hsien Lee");
        systemDesignInterview.setContent("Book by Alex Xu");

        System.out.println("Total size of files/directories at root level: " + root.size());
        System.out.println("Total number of files at root level: " + root.numberOfFiles());
        System.out.println(designDataIntensiveApplications.getFullPath());
        System.out.println(coding.getFullPath());

        // Get contents to some files
        System.out.println("Content of book: " + crackingTheCoding.getFullPath() + " is => " + crackingTheCoding.getContent());
        // Delete a file from the design directory
        design.deleteEntry(designDataIntensiveApplications);
        System.out.println("Total size of files/directories at root level: " + root.size());
        System.out.println("Total number of files at root level: " + root.numberOfFiles());

        // Get contents of a directory
        System.out.println("Contents of root directory:");
        root.getContents().forEach(a -> System.out.println("- " + a.getName()));
        System.out.println("Contents in books directory:");
        books.getContents().forEach(a -> System.out.println("- " + a.getName()));
        System.out.println("Contents in coding directory:");
        coding.getContents().forEach(a -> System.out.println("- " + a.getName()));
        System.out.println("Contents in design directory:");
        design.getContents().forEach(a -> System.out.println("- " + a.getName()));

        // Change name of books directory
        books.changeName("books_and_papers");
        System.out.println("Path of books and papers directory: " + books.getFullPath());

        // Get metadata of all the coding books
        coding.getContents().forEach(a -> System.out.println("- " + a.getName() + " is created at: " + a.getCreatedAt()));
        coding.getContents().forEach(a -> System.out.println("- " + a.getName() + " is last updated at: " + a.getLastUpdatedAt()));
        coding.getContents().forEach(a -> System.out.println("- " + a.getName() + " is last accessed at: " + a.getLastAccessedAt()));

        // Delete books directory
        books.delete();
        System.out.println("Number of files in the root directory: " + root.numberOfFiles());
    }
}
