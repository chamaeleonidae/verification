// .NET 5
using System;
using System.Security.Cryptography;
using System.Text;

var key = System.Environment.GetEnvironmentVariable("CHAMELEON_VERIFICATION_SECRET");
var userId = "";

var now = DateTimeOffset.UtcNow.ToUnixTimeSeconds();
using var hmac = new HMACSHA256(Encoding.UTF8.GetBytes(key));
var hashBytes = hmac.ComputeHash(Encoding.UTF8.GetBytes($"{userId}-{now}"));
var hashString = BitConverter.ToString(hashBytes).Replace("-", "").ToLower();
var secureUserId = $"{hashString}-{now}";
