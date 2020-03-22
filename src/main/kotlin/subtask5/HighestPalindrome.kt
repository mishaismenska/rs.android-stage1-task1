package subtask5

class HighestPalindrome {

    fun highestValuePalindrome(n: Int, k: Int, digitString: String): String {
        var kCheck = k
        val result = digitString.toCharArray()
        val modified = Array<Boolean>(digitString.length){false}

        //Make number a palindrome
        for(i in 0..n/2){
            if(result[i] != result[n - 1 - i]){
                if(result[i] > result[n - 1 - i]){
                    result[n - 1 - i] = result[i]
                    modified[n-1-i] = true
                }
                else {
                    result[i] = result[n - 1 - i]
                    modified[i] = true
                }
                kCheck--
                if(kCheck < 0) return "-1"
            }
        }

        //Make number the largest possible palindrome
        for (i in 0..(n+1)/2){
            if(kCheck <= 0) break
            if(result[i] != '9'){
                if(i == n - i - 1){
                    if(kCheck >= 1 || modified[i]){
                        result[i] = '9'
                        if(!modified[i]){
                            modified[i] = true
                            kCheck--
                        }
                    }
                } else if((kCheck >= 2)
                    || ((kCheck>= 1) &&((modified[i] || modified[n-i-1])))
                    || ((kCheck == 0)&&modified[i]&&modified[i-1])){
                    result[i] = '9'
                    result[n-i-1] = '9'
                    if(!modified[i]){
                        modified[i] = true
                        kCheck--
                    }
                    if(!modified[n-i-1]){
                        modified[n-i-1] = true
                        kCheck--
                    }
                }
            }
        }
        return String(result)
    }
}
