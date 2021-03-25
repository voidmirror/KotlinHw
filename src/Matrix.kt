import java.util.*

class Matrix constructor(_rows: Int, _cols: Int) {
    var rows: Int = 0
    var cols: Int = 0

    init {
        rows = _rows
        cols = _cols
    }

    var mat : Array<IntArray> = Array(rows, {IntArray(cols)})

//    fun getMat(): Array<IntArray> {
//        return mat
//    }

    fun printMatrix() {
        for (row in mat) {
            for (cell in row) {
                print("$cell\t")
            }
            println()
        }
    }

    fun fillMatrix() {
        val scanner = Scanner(System.`in`)
        for (i in mat.indices) {
            var rowArray = IntArray(cols)
            for (j in rowArray.indices) {
                print(i)
                print(j)
                val scanner = Scanner(System.`in`)
                for (k in rowArray.indices) {
                    print(" ${rowArray[k]} ")
                }
                print(rowArray.toString())
                rowArray[j] = scanner.nextInt()
//                mat[i][j] = scanner.nextInt()
            }
            mat[i] = rowArray
        }
    }

    fun transpose() {
        var new : Array<IntArray> = Array(rows, {IntArray(cols)})
        for (i in mat.indices) {
            for (j in mat[i].indices) {
                new[i][j] = mat[j][i]
            }
        }
        mat = new
    }

    fun sumSelf(another: Matrix) {
        for (i in mat.indices) {
            for (j in mat[i].indices) {
                mat[i][j] += another.mat[i][j]
            }
        }
    }

    fun subtractSelf(another: Matrix) {
        for (i in mat.indices) {
            for (j in mat[i].indices) {
                mat[i][j] -= another.mat[i][j]
            }
        }
    }

    fun multiplySelf(another: Matrix) {
        var new : Array<IntArray> = Array(rows, {IntArray(another.cols)})
        for (i in new.indices) {
            for (j in new[i].indices) {
                for (k in mat[0].indices) {
                    new[i][j] += mat[i][k] * another.mat[k][j]
                }
            }
        }
        mat = new
    }

    fun sum(another: Matrix): Array<IntArray> {
        var new : Array<IntArray> = Array(rows, {IntArray(another.cols)})
        for (i in mat.indices) {
            for (j in mat[i].indices) {
                new[i][j] = mat[i][j] + another.mat[i][j]
            }
        }
        return new
    }

    fun subtract(another: Matrix): Array<IntArray> {
        var new : Array<IntArray> = Array(rows, {IntArray(another.cols)})
        for (i in mat.indices) {
            for (j in mat[i].indices) {
                new[i][j] = new[i][j] - another.mat[i][j]
            }
        }
        return new
    }

    fun multiply(another: Matrix): Array<IntArray> {
        var new : Array<IntArray> = Array(rows, {IntArray(another.cols)})
        for (i in new.indices) {
            for (j in new[i].indices) {
                for (k in mat[0].indices) {
                    new[i][j] += mat[i][k] * another.mat[k][j]
                }
            }
        }
        return new
    }

    fun discriminant(): Int {
        return mat[1][1] * mat[2][2] * mat[0][0] + mat[1][0] * mat[2][1] * mat[0][2] + mat[0][1] * mat[1][2] * mat[2][0] - mat[0][2] * mat[1][1] * mat[3][0] - mat[0][0] * mat[1][2] * mat[2][1] - mat[0][1] * mat[1][0] * mat[2][2]
    }
}