package leetangle.study.crypto

import java.util.Base64
import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec

class AESCipherStrategy(val key: String): CryptoStrategy {
    companion object {
        val CIPHER_AES = "AES"
    }
    lateinit var keySpec: SecretKeySpec
    init {
        val keyByte = key.toByteArray()
        keySpec = SecretKeySpec(keyByte, CIPHER_AES)
    }
    override fun encrypt(data: String): String {
        try {
            val cipher = Cipher.getInstance(CIPHER_AES)
            cipher.init(Cipher.ENCRYPT_MODE, keySpec)
            val doFinal = cipher.doFinal(data.toByteArray())
            return Base64.getEncoder().encodeToString(doFinal)
        } catch (e: Exception) {
            throw RuntimeException("Encryption Error; data : $data, reason : $e",e)
        }
    }

    override fun decrypt(data: String): String {
        try {
            val cipher = Cipher.getInstance(CIPHER_AES)
            cipher.init(Cipher.DECRYPT_MODE, keySpec)
            val decode = Base64.getDecoder().decode(data)
            val doFinal = cipher.doFinal(decode)
            return String(doFinal)
        } catch (e: Exception) {
            throw RuntimeException("Decryption Error; data : $data, reason : $e",e)
        }
    }
}