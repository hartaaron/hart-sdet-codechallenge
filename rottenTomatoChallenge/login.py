# -*- coding: utf-8 -*-
"""
Helper methods for sign up
"""

from navigation import NavigationHelper


class LoginHelper:

    def __init__(self, driver):
        self.driver = driver
        self.navigation = NavigationHelper(self.driver)

    #
    # Login directly through Settings section from main menu
    #
    def login_from_settings(self, loginBtnXpath, email, password):
        self.navigation.goto_section("Menu Settings", loginBtnXpath)

        self.complete_form(email, password)

    #
    # Fill in the login form with provided values and submit
    # This method assumes that the login view is already presented
    #
    def complete_form(self, email, password):
        # Enter email and password
        self.driver.waitByPullingElemAccessibilityId("Login Username Field").send_keys(email)
        self.driver.waitByPullingElemAccessibilityId("Login Password Field").send_keys(password)

        # Submit
        self.driver.waitByPullingElemAccessibilityId("Login Submit").click()
        print "Log in complete."
