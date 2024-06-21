package leetangle.study.crypto

interface CryptoStrategy {
    fun encrypt(data: String): String
    fun decrypt(data: String): String
}