require 'openssl'

secret = ENV['CHAMELEON_VERIFICATION_SECRET']
uid_hash = OpenSSL::HMAC.hexdigest('sha256', secret, uid)

# present back the uid_hash along side `uid` and add to the existing `chmln.identify(uid, { uid_hash: uid_hash })`
