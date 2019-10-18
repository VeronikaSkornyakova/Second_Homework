package bonch.dev.school.models

class Counter (initialCount: Int = 0) {

    var currentCounter = initialCount
        private set

    fun increment () {
        ++currentCounter
    }

}