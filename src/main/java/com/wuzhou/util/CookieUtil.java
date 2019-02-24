package com.wuzhou.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {
    public static String COOKIE_DOMAIN = "www.wz.com";
    public static String COOKIE_NAME = "login_token";

    public static void writeToken(HttpServletResponse response, String token){
        Cookie cookie = new Cookie(COOKIE_NAME, token);
        cookie.setDomain(COOKIE_DOMAIN);
        cookie.setPath("/");
        cookie.setMaxAge(60*60*24*365);
        cookie.setHttpOnly(true);
        response.addCookie(cookie);
    }
}
