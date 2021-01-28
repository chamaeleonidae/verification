# Verification (aka. Secure Mode)

Code samples of how to generate timestamp-anchored SHA256 HMAC signature of your user identifier

Please add a PR with any changes that you find along the way!
 
---

## Updating your installation

When updating the on-page Chameleon snippet to work with Secure mode, follow the examples below:

When using plain JavaScript:

```javascript
chmln.identify(USER_ID, { uid_hash: USER_ID_HASH_FROM_BACKEND });
```
 
When using Segment.com:

```javascript
// Two calls, first skipping Chameleon then second with only Chameleon
//
analytics.identify(USER_ID, OPTIONS, { Chameleon: false });
analytics.identify(USER_ID, { uid_hash: USER_ID_HASH_FROM_BACKEND, ...OPTIONS }, { All: false, Chameleon: true });
