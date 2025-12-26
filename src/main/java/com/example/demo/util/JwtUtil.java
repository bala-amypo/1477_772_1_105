public class JwtUtil {

    private String secret;
    private Long jwtExpirationMs;

    public String generateToken(String username, String role, Long userId, String email) {
        return Jwts.builder()
            .claim("role", role)
            .claim("userId", userId)
            .claim("email", email)
            .setSubject(username)
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationMs))
            .signWith(Keys.hmacShaKeyFor(secret.getBytes()), SignatureAlgorithm.HS256)
            .compact();
    }

    public Jws<Claims> validateAndGetClaims(String token) {
        return Jwts.parserBuilder()
            .setSigningKey(secret.getBytes())
            .build()
            .parseClaimsJws(token);
    }
}
