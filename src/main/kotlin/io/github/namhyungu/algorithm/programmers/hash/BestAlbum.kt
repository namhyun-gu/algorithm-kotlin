package io.github.namhyungu.algorithm.programmers.hash

class BestAlbum {
    data class Song(val genre: String, val idx: Int, val play: Int)

    fun solution(genres: Array<String>, plays: IntArray): IntArray =
        Array(genres.size) { Song(genres[it], it, plays[it]) }
            .groupBy { it.genre }
            .values
            .map {
                it.fold(0) { acc, song -> acc + song.play } to
                    it.sortedWith(
                            Comparator { song1, song2 ->
                                if (song1.play == song2.play) song1.idx.compareTo(song2.idx)
                                song2.play.compareTo(song1.play)
                            }
                        )
                        .map { song -> song.idx }
            }
            .sortedByDescending { it.first }
            .fold(mutableListOf<Int>()) { acc, pair ->
                acc.add(pair.second.first())
                if (pair.second.size > 1) {
                    acc.add(pair.second[1])
                }
                acc
            }
            .toTypedArray()
            .toIntArray()
}
