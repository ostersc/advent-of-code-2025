data class Point2D(val x: Int, val y: Int) {
    /**
     * Calculates the Manhattan distance between this point and another point.
     */
    fun manhattanDistanceTo(other: Point2D): Int {
        return Math.abs(x - other.x) + Math.abs(y - other.y)
    }

    /**
     * Calculates the Euclidean distance between this point and another point.
     */
    fun euclideanDistanceTo(other: Point2D): Double {
        val dx = (x - other.x).toDouble()
        val dy = (y - other.y).toDouble()
        return Math.sqrt(dx * dx + dy * dy)
    }

    /**
     * Returns a new Point2D that is the result of adding the coordinates of another point.
     */
    operator fun plus(other: Point2D): Point2D {
        return Point2D(x + other.x, y + other.y)
    }

    /**
     * Returns a new Point2D that is the result of subtracting the coordinates of another point.
     */
    operator fun minus(other: Point2D): Point2D {
        return Point2D(x - other.x, y - other.y)
    }

    /**
     * Returns a set of adjacent neighbors (up, down, left, right).
     */
    fun cardinalNeighbors(): Set<Point2D> {
        return setOf(
            Point2D(x, y - 1), // Up
            Point2D(x, y + 1), // Down
            Point2D(x - 1, y), // Left
            Point2D(x + 1, y)  // Right
        )
    }

    /**
     * Returns a set of all 8 surrounding neighbors (including diagonals).
     */
    fun allNeighbors(): Set<Point2D> {
        return setOf(
            Point2D(x - 1, y - 1), Point2D(x, y - 1), Point2D(x + 1, y - 1),
            Point2D(x - 1, y),                       Point2D(x + 1, y),
            Point2D(x - 1, y + 1), Point2D(x, y + 1), Point2D(x + 1, y + 1)
        )
    }
}