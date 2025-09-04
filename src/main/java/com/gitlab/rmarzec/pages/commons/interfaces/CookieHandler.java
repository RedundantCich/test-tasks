package com.gitlab.rmarzec.pages.commons.interfaces;

public interface CookieHandler {

    /**
     * Accept the cookie banner/pop-up
     */
    void acceptCookies();

    /**
     * Check if the cookie banner is displayed
     *
     * @return true if displayed, false otherwise
     */
    boolean isCookieModalDisplayed();
}