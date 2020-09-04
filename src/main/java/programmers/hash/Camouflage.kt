package programmers.hash

class Camouflage {
    fun solution(clothes: Array<Array<String>>): Int {
        var answer = 1
        val clothesMap = mutableMapOf<String, Int>()
        clothes.forEach { (_, type) ->
            clothesMap[type] =
                    if (clothesMap[type] == null) 1
                    else clothesMap[type]!! + 1
        }
        clothesMap.forEach { (_, size) ->
            answer *= size + 1
        }
        return answer - 1
    }
}