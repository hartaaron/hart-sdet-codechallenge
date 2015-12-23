# -*- coding: utf-8 -*-
"""
Helper methods for simple navigation actions
"""


class NavigationHelper:

    def __init__(self, driver):
        self.driver = driver

    #
    # Opens the main menu and selections the section by accessibility identifier
    #
    def goto_section(self, section_name, item_name):

        # Select "Settings" option
        self.driver.waitByPullingElemAccessibilityId(section_name).click()

        # select login button
        self.driver.waitByPullingElemXpath(loginBtnXpath).click()
