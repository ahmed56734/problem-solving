package codesignal.arrays

fun sudoku2(grid: MutableList<MutableList<Char>>): Boolean {
    val seenColumns: HashSet<Pair<Char, Int>> = HashSet()
    val seenRows: HashSet<Pair<Char, Int>> = HashSet()
    val seenSubGrids: HashSet<Pair<Char, Pair<Int, Int>>> = HashSet()

    for (rowIndex in 0..8) {
        for (columnIndex in 0..8) {
            val value = grid[rowIndex][columnIndex]
            if (value == '.')
                continue

            val valueToColumn = value to columnIndex
            val valueToRow = value to rowIndex
            val subGridIndex = rowIndex / 3 to columnIndex / 3
            val valueToGrid = value to subGridIndex

            if (valueToColumn in seenColumns || valueToRow in seenRows || valueToGrid in seenSubGrids) {
                return false
            }

            seenColumns.add(valueToColumn)
            seenRows.add(valueToRow)
            seenSubGrids.add(valueToGrid)
        }
    }


    return true
}
