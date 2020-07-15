package com.step.ap.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.apache.commons.lang3.time.DateUtils;

import java.util.Date;

/**
 * https://github.com/auth0/java-jwt
 */
public class JwtUtil {
    private static final String SECRET = "STEP_ap";

    /**
     * 新建token
     */
    public static String createToken() {
        Date expiresDate = DateUtils.addDays(new Date(), 7);//过期时间七天
        Algorithm algorithm = Algorithm.HMAC256(SECRET);
        return JWT.create()
                .withIssuer("step")
                .withExpiresAt(expiresDate)
                .sign(algorithm);
    }

    /**
     * 获取userId
     */
    public static void checkToken(String token) {
        Algorithm algorithm = Algorithm.HMAC256(SECRET);
        JWT.require(algorithm)
                .withIssuer("step")
                .build()
                .verify(token);
    }
}
