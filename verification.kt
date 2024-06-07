import java.math.BigInteger
import java.nio.charset.StandardCharsets
import java.time.Instant
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec

fun generateUserIdHash(userId: String): String {
    val secretKey = System.getenv("CHAMELEON_VERIFICATION_SECRET")
        ?: throw IllegalArgumentException("Environment variable CHAMELEON_VERIFICATION_SECRET is not set")
        
    val now = Instant.now().epochSecond.toString()
    val secret = secretKey.toByteArray(StandardCharsets.UTF_8)
    val secretKeySpec = SecretKeySpec(secret, "HmacSHA256")

    val userAndTime = "$userId-$now"
    val userAndTimeBytes = userAndTime.toByteArray(StandardCharsets.UTF_8)

    val mac = Mac.getInstance("HmacSHA256")
    mac.init(secretKeySpec)
    val hash = BigInteger(1, mac.doFinal(userAndTimeBytes))

    return String.format("%064x-%s", hash, now)
}

fun main() {
    val userId = "your_user_id"

    // Generate the UID hash
    val uidHash = generateUserIdHash(userId)
    println("Generated UID Hash: $uidHash")
}

/*
 * Send back the `uidHash` alongside `userId` and add to the existing `chmln.identify(userId, { uid_hash: uidHash })`
 *
 * A properly formed hash will look like this: "7aad060d3b7a85123e32d4257b05ecaf2096686e78422fc51be252f10910f5e5-1596165824"
 */
