package subtask3

private const val CORRECT_OUTPUT = "Bon Appetit"
class BillCounter {
    // The output could be "Bon Appetit" or the string with number(e.g "10")
    fun calculateFairlySplit(bill: IntArray, k: Int, b: Int): String {
        var sum = 0
        for(i in bill.indices) {
            if (i != k) sum += bill[i]
        }
        sum /= 2
        return if(sum == b) CORRECT_OUTPUT
            else (Math.abs(sum - b).toString())
    }
}
