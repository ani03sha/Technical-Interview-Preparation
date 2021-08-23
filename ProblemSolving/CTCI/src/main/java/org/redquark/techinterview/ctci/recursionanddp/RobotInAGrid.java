package org.redquark.techinterview.ctci.recursionanddp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Anirudh Sharma
 * <p>
 * Imagine a robot sitting in the upper left corner of grid with r rows and c columns.
 * The robot can only move in two directions, right and down, but certain cells are "off limits" such that
 * the robot cannot step on them.
 * <p>
 * Design an algorithm to find a path for the robot from the top left to the bottom right.
 */
public class RobotInAGrid {

    private static List<Point> getPath(int[][] maze) {
        // Base case
        if (maze == null || maze.length == 0) {
            return null;
        }
        // List to store the output
        List<Point> paths = new ArrayList<>();
        // Set to store the off-limit points
        Set<Point> invalidPoints = new HashSet<>();
        // Row and column of the maze
        int row = maze.length;
        int column = maze[0].length;
        if (getPath(maze, row - 1, column - 1, paths, invalidPoints)) {
            return paths;
        }
        return null;
    }

    private static boolean getPath(int[][] maze, int row, int column, List<Point> paths, Set<Point> invalidPoints) {
        // Base case
        if (row < 0 || column < 0 || maze[row][column] == 1) {
            return false;
        }
        // Current point
        Point point = new Point(row, column);
        // Check if this point can be used or not
        if (invalidPoints.contains(point)) {
            return false;
        }
        if ((row == 0 && column == 0)
                || getPath(maze, row, column - 1, paths, invalidPoints)
                || getPath(maze, row - 1, column, paths, invalidPoints)) {
            paths.add(point);
            return true;
        }
        invalidPoints.add(point);
        return false;
    }

    public static void main(String[] args) {
        int[][] maze = new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        System.out.println(getPath(maze));

        maze = new int[][]{
                {0, 1},
                {0, 1}
        };
        System.out.println(getPath(maze));
    }

    static class Point {
        int row;
        int column;

        Point(int row, int column) {
            this.row = row;
            this.column = column;
        }

        @Override
        public String toString() {
            return "[" + row + ", " + column + "]";
        }
    }
}
