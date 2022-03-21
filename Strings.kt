//Exercise 2 - working with strings
//For given String do:
//remove dots and capitalize letters
//count words in string
//count unique words and create map of them
//count unique letters and create map of them

//Stwórz funkcje podające następujące statystyki:
//Ilość wyrazów (ciągów znaków oddzielonych spacjami)
//Ilość niepowtarzających się wyrazów wraz z ich długościami (w postaci mapy, gdzie kluczem
//jest wyraz, a wartością jego długość).
//Ilość wystąpień każdej z poszczególnych liter (w postaci mapy, gdzie kluczem jest litera, a
//wartością ilość jej wystąpień).


fun main() {

    var chain = "The world is changed. I feel it in the water. I feel \n" +
            "it in the earth. I smell it in the air."

    println(chain)

    chain = chain.filter { it.isLetterOrDigit() || it.isWhitespace() } //leave only letters, digits and spaces
    chain = chain.uppercase() //capitalize letters

    words(chain)
    uniqueWords(chain)
    letters(chain)
}

//words counter function
fun words(chain: String): Int {
    val strList = chain.split(" ").toList()
    //split chain and add words to list

    var count = 0

    for (s in strList) {
        if (s != "") {
            count++
        }
    }

    println("No. of words: $count")
    return count
}

//function for creating map of unique words
fun  uniqueWords(chain: String): Map<String, Int> {
    val listOfWords = chain.split(" ").toSet().toList()
    //split chain to words, remove duplicate words and add them to list

    val MapOfWords = mutableMapOf<String, Int>() //create mutable map of words

    for (item in listOfWords) {
        MapOfWords.put(item, item.length)
    }  //add words and their length to map
    println("Map of words: $MapOfWords")
    return MapOfWords
}

//function for creating map of letters and counting them
fun letters(chain: String): Map<Char, Int> {
    val withoutSpaces = chain.filter{ it.isLetter() }.toSet().toList().joinToString("") //create chain of unique letters
    val withoutSpacesAll = chain.filter { it.isLetter() }.toList().joinToString("") // create chain of letters

    var letter: Char
    var value = 0
    val MapOfLetters = mutableMapOf<Char, Int>() //create map of unique letters
    val star = "*" //star for drawing simple "charts" in console - number of letters is showed as number of stars

    for (i in 0..withoutSpaces.length-1) {
        letter = withoutSpaces.get(index = i)
        MapOfLetters.put(letter, value)
    } //add letters to map

    for (j in 0 .. withoutSpacesAll.length-1) {
        letter = withoutSpacesAll.get(index = j)
        value = MapOfLetters.getValue(key = letter)
        value++
        MapOfLetters.put(letter, value)
    } //count number of individual letters

    println("Map of letters: $MapOfLetters")

    for ((key, values) in MapOfLetters) {
        println("$key: ${star.repeat(values)}")
    } //multiplicate stars to draw a "chart"

    return MapOfLetters
}
