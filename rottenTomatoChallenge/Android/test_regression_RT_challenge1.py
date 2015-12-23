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
class rottenTomatoesAndroidSample(hDriver):

    hDriver.bsPath = "//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.view.View[1]/android.widget.TextView[1]"
    album2 = hDriver.bsPath + "/android.widget.RelativeLayout[1]/android.widget.EditText[2]"

    def testModernLogin(self):

    #
    #
    #
    def test_page_content_album2(self):
        self.navigation.goto_section("Rotten Tomatoes Challenge", album2)
        self.waitByPullingElemName("AUDIENCE SCORE", 60).click()
        self.waitByPullingElemName("BACK").click()
        
