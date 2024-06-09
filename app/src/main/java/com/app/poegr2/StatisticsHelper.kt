package com.app.poegr2

class StatisticsHelper {

    fun displayArrayValues(numbers: IntArray): String {
        var result = ""
        for (number in numbers) {
            if (number > 0) {
                result = "$result$number,"
            }
        }

        return result
    }

    fun clearArrayValues(numbers: IntArray) {
        var index = 0
        while (index < 10) {
            numbers[index] = 0
            index++
        }
    }

    fun calculateAvg(numbers: IntArray): Int {
        var avg = 0
        var total = 0
        for (number in numbers) {
            total += number
        }

        avg = total / numbers.size

        return avg
    }

    fun findMax(numbers: IntArray): Int {
        var highest = numbers[0]

        for (number in numbers) {
            if (number > highest) {
                highest = number
            }
        }

        return highest
    }

    fun findMin(numbers: IntArray): Int {
        var lowest = numbers[0]

        for (number in numbers) {
            if (number < lowest) {
                lowest = number
            }
        }

        return lowest
    }
}