// via https://golangcode.com/generate-sha256-hmac/

package main

import (
    "os"
    "strconv"
    "time"
    "crypto/hmac"
    "crypto/sha256"
    "encoding/hex"
)

func main() {
    secret := os.Getenv("CHAMELEON_VERIFICATION_SECRET")
    now := strconv.FormatInt(int64(time.Now().Unix()), 10)

    h := hmac.New(sha256.New, []byte(secret))
    h.Write([]byte(uid + "-" + now))
    uid_hash := hex.EncodeToString(h.Sum(nil)) + "-" + now
}

//
// send back the `uid_hash` along side `uid` and add to the existing `chmln.identify(uid, { uid_hash: uid_hash })`
//
// a properly formed hash will look like this "7aad060d3b7a85123e32d4257b05ecaf2096686e78422fc51be252f10910f5e5-1596165824"
//
