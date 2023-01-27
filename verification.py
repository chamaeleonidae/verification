# via https://stackoverflow.com/a/46956070

import os
import time
import hmac
import hashlib

secret = os.getenv('CHAMELEON_VERIFICATION_SECRET')
now = string(int(time.time()))
uid_hash = '-'.join([hmac.new(bytes(secret, 'utf-8'), msg = bytes('-'.join([uid, now]), 'utf-8'), digestmod = hashlib.sha256().hexdigest()), now])

#
# send back the `uid_hash` along side `uid` and add to the existing `chmln.identify(uid, { uid_hash: uid_hash })`
#
# a properly formed hash will look like this "7aad060d3b7a85123e32d4257b05ecaf2096686e78422fc51be252f10910f5e5-1596165824"
#
