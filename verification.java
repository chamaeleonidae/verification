// via https://sorenpoulsen.com/calculate-hmac-sha256-with-java

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

Mac mac = Mac.getInstance("HmacSHA256");
SecretKeySpec secretKeySpec = new SecretKeySpec(secret, "HmacSHA256");
mac.init(secretKeySpec);

String secret = System.getenv("CHAMELEON_VERIFICATION_SECRET").getBytes("UTF-8");
String uid_hash = String.format("%032x", new BigInteger(1, mac.doFinal(uid.getBytes("UTF-8"))));
