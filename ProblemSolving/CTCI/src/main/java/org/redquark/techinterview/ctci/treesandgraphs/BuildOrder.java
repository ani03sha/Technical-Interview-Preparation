package org.redquark.techinterview.ctci.treesandgraphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Anirudh Sharma
 * <p>
 * You are given a list of projects and a list of dependencies (which is a list of pairs of projects,
 * where the second project is dependent on the first project). All of a project's dependencies
 * must be built before the project is.
 * <p>
 * Find a build order that will allow the projects to be built. If there is no valid build order, return an error.
 */
public class BuildOrder {

    private static List<Integer> buildOrder(int[][] projects) {
        // Set to store temporary marks
        Set<Integer> temporaryMarks = new HashSet<>();
        // Set to store permanent marks
        Set<Integer> permanentMarks = new HashSet<>();
        // List to store the final result
        List<Integer> result = new ArrayList<>();
        // Recursively search from an unmarked node
        for (int i = 0; i < projects.length; i++) {
            if (!permanentMarks.contains(i)) {
                visit(i, projects, temporaryMarks, permanentMarks, result);
            }
        }
        return result;
    }

    private static void visit(int project, int[][] projects, Set<Integer> temporaryMarks, Set<Integer> permanentMarks, List<Integer> result) {
        // Check for cycle
        if (temporaryMarks.contains(project)) {
            throw new RuntimeException("Cycle in the dependencies");
        }
        // If the node is never visited yet
        if (!permanentMarks.contains(project)) {
            // Add it to the temporary marks
            temporaryMarks.add(project);
            // Get dependencies of current project
            for (int i : projects[project]) {
                // Recursively visit this node
                visit(i, projects, temporaryMarks, permanentMarks, result);
            }
            // At this point, the current project is permanently marked
            permanentMarks.add(project);
            // Remove it from temporary marks
            temporaryMarks.remove(project);
            // Add it to the result
            result.add(project);
        }
    }

    public static void main(String[] args) {
        int[][] projects = new int[][]{
                {},
                {0},
                {0},
                {1, 2},
                {3}
        };
        System.out.println(buildOrder(projects));
    }
}
