# via https://stackoverflow.com/a/46956070

import os
import hmac
import hashlib

secret = os.getenv('CHAMELEON_VERIFICATION_SECRET')
uid_hash = hmac.new(bytes(secret , 'utf-8'), msg = bytes(uid , 'utf-8'), digestmod = hashlib.sha256).hexdigest()
