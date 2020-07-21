# via https://www.php.net/manual/en/function.hash-hmac.php

secret = $_ENV['CHAMELEON_VERIFICATION_SECRET']
uid_hash = hash_hmac('sha256', uid, secret)
