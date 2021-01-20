package exemplodebotoes;

import java.util.concurrent.ThreadLocalRandom;

/**
 * The classic Game of Fifteen. A 4x4 grid contains 15 numbered tiles and an 
 * empty space. A move in the game consists of sliding a tile into the empty 
 * space from an adjacent position. The goal is to rearrange the tiles into 
 * ascending order with the empty space in the lower-right corner.
 *
 * @author Drue Coles
 */
public class Fifteen {

    public static final int EMPTY_SPACE = 0;
    public static final int ROWS = 4;
    public static final int COLS = 4;

    // Number of tiles to move when shuffling the grid.
    private static final int DEFAULT_SHUFFLE_COUNT = 50;

    private final int[][] grid;

    /**
     * Initializes the grid to a random solvable configuration.
     */
    public Fifteen() {
        this(DEFAULT_SHUFFLE_COUNT);
    }

    /**
     * Initializes the grid to a random configuration that can be solved within
     * a specified number of moves.
     */
    public Fifteen(int n) {
        // Initialize grid to the winning configuration then shuffle n times.
        int tile = 1;
        grid = new int[ROWS][COLS];
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                grid[i][j] = tile;
                tile++;
            }
        }
        grid[ROWS - 1][COLS - 1] = EMPTY_SPACE;

        shuffle(n);
    }

    /**
     * Shuffles the grid by making a series of random moves.
     */
    private void shuffle(int numMoves) {
        ThreadLocalRandom rand = ThreadLocalRandom.current();
        while (numMoves > 0) {
            int tileToMove = 1 + rand.nextInt(ROWS * COLS - 1);
            boolean tileMoved = slide(tileToMove);
            if (tileMoved) {
                numMoves--;
            }
        }
    }
    
    /**
     * Returns the tile at a specified location.
     */
    public int tileAt(int row, int col) {
        return grid[row][col];
    }

    /**
     * Moves a tile into the adjacent empty space. Invalid moves are ignored.
     *
     * @return true if the move is valid, false otherwise
     */
    public final boolean slide(int tile) {
        if (tile < 1 || tile >= ROWS * COLS) {
            return false;
        }

        // Find the position of the tile to slide and of the empty space.
        int tileRow = 0;  // row of tile to slide
        int tileCol = 0;  // column of tile to slide
        int spaceRow = 0; // row of empty space
        int spaceCol = 0;  // column of empty space
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (grid[i][j] == tile) {
                    tileRow = i;
                    tileCol = j;
                }
                if (grid[i][j] == EMPTY_SPACE) {
                    spaceRow = i;
                    spaceCol = j;
                }
            }
        }

        // The move is valid if the rows are the same and the columns differ by
        // one, or vice versa.
        if (Math.abs(tileRow - spaceRow) + Math.abs(tileCol - spaceCol) == 1) {
            grid[tileRow][tileCol] = EMPTY_SPACE;
            grid[spaceRow][spaceCol] = tile;
            return true;
        }
        return false;
    }

    /**
     * Moves a tile at a specified location into the adjacent empty space. 
     * Invalid moves are ignored.
     *
     * @return true if the move is valid, false otherwise
     */
    public boolean slide(int row, int col) {
        return slide(grid[row][col]);
    }

    /**
     * Returns the current grid configuration as string.
     */
    @Override
    public String toString() {
        String gridCells = "";
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (grid[i][j] == EMPTY_SPACE) {
                    gridCells += "   ";
                } else {
                    gridCells += String.format("%2d ", grid[i][j]);
                }
            }
            gridCells += "\n";
        }
        return gridCells;
    }

    /**
     * Returns true if each tile is in its correct final position.
     */
    public boolean over() {
        int tile = 1;
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {

                // No need to check lower-right corner.
                if (r == ROWS - 1 && c == COLS - 1) {
                    return true;
                }

                // Check that current cell contains correct tile.
                if (grid[r][c] != tile) {
                    return false;
                }
                tile++;
            }
        }
        return true;
    }

    /**
     * Returns an array of valid moves (tiles adjacent to the empty space).
     */
    public String[] choices() {

        int adjacentCount = 0; // number of squares adjacent to the empty square
        int spaceRow = 0; // row containing empty space
        int spaceCol = 0; // column containing empty space
        
        // search for empty space
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (grid[i][j] == EMPTY_SPACE) {
                    spaceRow = i;
                    spaceCol = j;
                    
                    // count number of adjacent squares
                    if (i > 0) {
                        adjacentCount++;
                    }
                    if (j > 0) {
                        adjacentCount++;
                    }
                    if (i < ROWS - 1) {
                        adjacentCount++;
                    }
                    if (j < COLS - 1) {
                        adjacentCount++;
                    }
                }
            }
        }
        
        // Create an array of size equal to the number of adjacent squares and fill it
        // with the tile numbers of the adjacent tiles. The tile numbers are stored as
        // strings.
        int i = 0;
        String[] adjTiles = new String[adjacentCount++];
        if (spaceRow > 0) {
            adjTiles[i] = "" + grid[spaceRow - 1][spaceCol];
            i++;
        }
        if (spaceCol > 0) {
            adjTiles[i] = "" + grid[spaceRow][spaceCol - 1];
            i++;
        }
        if (spaceRow < ROWS - 1) {
            adjTiles[i] = "" + grid[spaceRow + 1][spaceCol];
            i++;
        }
        if (spaceCol < COLS - 1) {
            adjTiles[i] = "" + grid[spaceRow][spaceCol + 1];
        }
        return adjTiles;
    }
}