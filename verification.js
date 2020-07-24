// via https://nodejs.org/api/crypto.html#apicontent

const crypto = require('crypto');

const secret = process.env.CHAMELEON_VERIFICATION_SECRET;
const now = Math.floor(Date.now() / 1000);

const uid_hash = [crypto.createHmac('sha256', secret).update(`${uid}-${now}`).digest('hex'), now].join('-');

//
// send back the `uid_hash` along side `uid` and add to the existing `chmln.identify(uid, { uid_hash: uid_hash })`
//
// a properly formed hash will look like this "7aad060d3b7a85123e32d4257b05ecaf2096686e78422fc51be252f10910f5e5-1596165824"
//
