# via https://www.php.net/manual/en/function.hash-hmac.php

use \Datetime;

$secret = $_ENV['CHAMELEON_VERIFICATION_SECRET'];
$now = strval(new DateTime()->getTimestamp());
$uid_hash = hash_hmac('sha256', $uid.'-'.$now , $secret).'-'.$now;

#
# send back the `uid_hash` along side `uid` and add to the existing `chmln.identify(uid, { uid_hash: uid_hash })`
#
# a properly formed hash will look like this "7aad060d3b7a85123e32d4257b05ecaf2096686e78422fc51be252f10910f5e5-1596165824"
#
