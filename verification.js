// via https://nodejs.org/api/crypto.html#apicontent

const crypto = require('crypto');

const secret = process.env.CHAMELEON_VERIFICATION_SECRET;
const uid_hash = crypto.createHmac('sha256', secret).
  update('I love cupcakes').digest('hex');
