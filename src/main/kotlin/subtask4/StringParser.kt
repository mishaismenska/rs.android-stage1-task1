package subtask4

import kotlin.collections.ArrayList

class StringParser {

    fun getResult(inputString: String): Array<String> {
        val charArray = inputString.toCharArray()
        val result = ArrayList<String>()
        var type = 0
        val brackets = charArrayOf('<', '[', '(')
        val closingBrackets = charArrayOf('>', ']', ')')
        var nest = 0
        for(i in charArray.indices){
           type = brackets.indexOf(charArray[i])
            if(type != -1){
                nest = 0
                var temp = ""
                loop@for(i1 in i + 1 until charArray.size){
                    if((charArray[i1] == closingBrackets[type])&&(nest == 0))
                        break@loop
                    temp += charArray[i1].toString()
                    if(charArray[i1] == charArray[i]) nest++
                    if(charArray[i1] == closingBrackets[type]) nest--
                }
                result.add(temp)
            }
        }
        return result.toTypedArray()
    }
}
