package codesignal.hashtables

fun groupingDishes(dishes: MutableList<MutableList<String>>): MutableList<MutableList<String>> {

    val dishesMap: MutableMap<String, ArrayList<String>> = mutableMapOf()

    for (item in dishes) {
        val dish = item[0]
        for (i in 1..item.lastIndex) {
            val ingredient = item[i]
            dishesMap[ingredient] = dishesMap.getOrDefault(ingredient, ArrayList()).apply { add(dish) }
        }
    }


    return dishesMap.asSequence()
        .filter { it.value.size >= 2 }
        .sortedBy { it.key }
        .map {
            (mutableListOf(it.key) + it.value.toMutableList().sorted()) as MutableList
        }.toMutableList()
}
