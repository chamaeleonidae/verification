require 'openssl'

secret = ENV['CHAMELEON_VERIFICATION_SECRET']
now = Time.now.to_i.to_s # unix timestamp goes 'inside' and 'outside' the signature
uid_hash = [OpenSSL::HMAC.hexdigest('sha256', secret, "#{uid}-#{now}"), now].join('-')

#
# present back the `uid_hash` along side `uid` and add to the existing `chmln.identify(uid, { uid_hash: uid_hash })`
#
# a properly formed hash will look like this "7aad060d3b7a85123e32d4257b05ecaf2096686e78422fc51be252f10910f5e5-1596165824"
#
