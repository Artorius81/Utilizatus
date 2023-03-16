package com.example.utilizatus.notification

import kotlin.random.Random

object OTPNumber {
    var value = Random.nextInt(1000, 9999)
    var value_again = Random.nextInt(1000, 9999)
}