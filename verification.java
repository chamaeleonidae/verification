// via https://sorenpoulsen.com/calculate-hmac-sha256-with-java

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

Mac mac = Mac.getInstance("HmacSHA256");
String secret = System.getenv("CHAMELEON_VERIFICATION_SECRET").getBytes("UTF-8");
SecretKeySpec secretKeySpec = new SecretKeySpec(secret, "HmacSHA256");
mac.init(secretKeySpec);

String now = String.valueOf(System.currentTimeMillis() / 1000L);
String uid_hash = String.format("%064x", new BigInteger(1, mac.doFinal((uid + "-" + now).getBytes("UTF-8")))) + "-" + now;

//
// send back the `uid_hash` along side `uid` and add to the existing `chmln.identify(uid, { uid_hash: uid_hash })`
//
// a properly formed hash will look like this "7aad060d3b7a85123e32d4257b05ecaf2096686e78422fc51be252f10910f5e5-1596165824"
//
