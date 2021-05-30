package com.example.myapplication


data class Kala(val name: String, val price: Double, val company: String, val type_of: String, val colour: String) {
        // simple version
        override fun toString(): String {
            return name
        }
}
