package com.example.calculator

class OperationHelper {

    companion object {
        fun add(LHS: Double, RHS: Double): Double {
            val sum = LHS + RHS
            return sum
        }

        fun subtract(LHS: Double, RHS: Double): Double {
            val sub = LHS - RHS
            return sub
        }

        fun multiply(LHS: Double, RHS: Double): Double {
            val Multiply = LHS * RHS
            return Multiply
        }

        fun divide(LHS: Double, RHS: Double): Double {
            val Divide = LHS / RHS
            return Divide
        }
        fun mod(LHS: Double, RHS: Double): Double {
            val Divide = LHS % RHS
            return Divide
        }
    }
}