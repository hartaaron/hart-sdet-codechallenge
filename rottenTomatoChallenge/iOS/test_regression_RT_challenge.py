# -*- coding: utf-8 -*-
"""
the samples of app testing
"""

from hartMobileTestDriver import hDriver
from login import LoginHelper
from navigation import NavigationHelper

#
#use appium GUI to identify xpath of the elements
#
class rottenTomatoesSample(hDriver):


    hDriver.bsPath = "//UIAApplication[1]/UIAWindow[1]/UIATabBar[1]/UIAButton["
    loginBtnXp = hDriver.bsPath + "1]"
    album3 = hDriver.bsPath + "2]/UIATabBar[1]/UIAButton[3]"
    def setUp(self):
        super(rottenTomatoesSample, self).setUp()

        self.login = LoginHelper(self)
        

        
    #
    #
    #
    def test_login(self):
        self.login.login_from_settings(loginBtnXp, "user@user.com", "password")
        self.driver.swipe(100, 100, 100, 400)

    #
    #
    #
    def test_page_content_album3(self):
        self.navigation.goto_section("Rotten Tomatoes Challenge", album3)
        self.waitByPullingElemName("TATOMETER", 10).click()
        self.waitByPullingElemName("BACK").click()
