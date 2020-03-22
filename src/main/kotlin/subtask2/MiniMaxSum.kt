package subtask2

class MiniMaxSum {
    fun getResult(input: IntArray): IntArray {
        var min = input[0]
        var max = min
        var sum = 0
        for(i in input){
            sum += i
            if(i < min) min = i
            if(i > max) max = i
        }
        val result = intArrayOf(sum, sum)
        result[0] -= max
        result[1] -= min
        return result
    }
}
