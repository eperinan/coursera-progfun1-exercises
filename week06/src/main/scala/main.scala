import forcomp.Anagrams._
import forcomp.loadDictionary


object Main extends App {

  val test: Word = "Test"
  val test2: Word = "Test2"

  val sent: Sentence = List(test, test2)

  //println(sent)

  val dictionary: List[Word] = loadDictionary

  //println(dictionary.length)

  // println(wordOccurrences("Repollo"))
  // println(wordOccurrences("abcd"))
  // println(sentenceOccurrences(List("hola", "que")))
  // println(dictionaryByOccurrences)
  // println(combinations(List(('a', 2), ('b', 2))))

  val lard = List(('a', 1), ('d', 1), ('l', 1), ('r', 1))
  val r = List(('r', 1))
  val lad = List(('a', 1), ('d', 1), ('l', 1))
  // println(subtract(lard, r))
  println(sentenceAnagrams(List("Linux", "rulez")))
}