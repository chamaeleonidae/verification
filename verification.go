// via https://golangcode.com/generate-sha256-hmac/

package main

import (
    "os"
    "crypto/hmac"
    "crypto/sha256"
    "encoding/hex"
)

func main() {

    secret := os.Getenv("CHAMELEON_VERIFICATION_SECRET")

    h := hmac.New(sha256.New, []byte(secret))
    h.Write([]byte(uid))
    uid_hash := hex.EncodeToString(h.Sum(nil))

}
