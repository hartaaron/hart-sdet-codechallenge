#!/usr/bin/python
"""
mobile testing automation
"""
import unittest
import sys
import subprocess
import argparse
import json

from appium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions


class hDriver(unittest.TestCase):

    device_path = ""
    bsPath = ""
    
    def setUp(self):
        args = parse_args()
        self.is_device = True if args.get('udid') is not None else False

        # Path to the simulator directory
        self.simulatorPath = args.get('simulatorPath')

        # Set up driver with configuration
        host = 'http://' + args['appium_host_ip'] + ':4723/wd/hub'
        self.driver = webdriver.Remote(host, desired_capabilities=args)

    def tearDown(self):
        self.driver.quit()

    #
    # lambda method every 500 milliseconds
    # timeout is set as 30 seconds
    #
    def waitByPullingElemName(self, name, timeout=30):
        return WebDriverWait(self.driver, timeout).until(lambda x: x.find_element_by_name(name))

    #
    # lambda method every 500 milliseconds
    # timeout is set as 30 seconds
    # Note: Selecting by Xpath is much slower than by name
    #
    def waitByPullingElemXpath(self, xpath, timeout=30):
        return WebDriverWait(self.driver, timeout).until(lambda x: x.find_element_by_xpath(xpath))

    #
    # lambda method every 500 milliseconds
    # timeout is set as 30 seconds
    #
    def waitByPullingElemAccessibilityId(self, accessibilityId, timeout=30):
        return WebDriverWait(self.driver, timeout).until(lambda x: x.find_element_by_accessibility_id(accessibilityId))

    #
    # lambda method every 500 milliseconds
    # timeout is set as 30 seconds
    #
    def waitByPullingClassName(self, class_name, timeout=30):
        return WebDriverWait(self.driver, timeout).until(lambda x: x.find_element_by_class_name(class_name))
    
    #
    # WebDriverWait pulls expected_conditions.presence_of_element_located()
    # every 500 milliseconds
    # timeout is set as 30 seconds
    #

    def waitByPullingECElemPresence(self, name, timeout=30):
        return WebDriverWait(self.driver, timeout).until(expected_conditions.presence_of_element_located((By.NAME, name)))



    #
    # to facilitate error analysis
    #
    def takeScreenShot(self, platform="Appium_"):
        now = subprocess.check_output("date \"+%Y-%m-%d_%H:%M:%S\"", shell=True).rstrip()
        self.driver.save_screenshot("test_data/" + platform + now + ".png")



    # Scrolls until the WebElement provided is scrolled to the top of its scroll view
    def scroll_to(self, element):
        self.driver.execute_script("mobile: scrollTo", {"element": element.id})

    # Performs at tap at [x,y] screen coordinates for the provided duration
    def tap(self, x, y, duration=1.0):
        data = {"tapCount": 1, "touchCount": 1, "duration": duration, "x": x, "y": y}
        print "Performing tap with data: " + data
        self.driver.execute_script("mobile: tap", data)


        
    #
    # Fill in the login form with provided values and submit
    # This method assumes that the login view is already presented
    #
    def complete_login_form(self, email, password):
        loginFields = self.bsPath + "..."
        uid = loginFields + "1]"
        pwd = loginFields + "2]"
        self.waitByPullingElemXpath(uid).send_keys(email)
        self.waitByPullingElemXpath(pwd).send_keys(password)
        
        # Submit
        self.waitByPullingElemName("Done").click()
        print "Log in complete."

        


#
# parse command line option
# if no cmd option, default execution environment is local
# run test on Mac mini if -r or --remote specified, -h for help
# un-recognized option will be re-directed to help page
#
def parse_args():

    parser = argparse.ArgumentParser(
        description='Appium test automation for Hart App on Mobile Devices (iOS & Android)')

    parser.add_argument(
        '-r', '--remote',
        dest='appium_host_ip',
        action='store_const',
        const='127.0.0.1',   # IP of build box
        default='127.0.0.1',  # Default runs on your machine, i.e. localhost
        help='The IP address of the host machine on which to run the test(s).')

    parser.add_argument(
        '-t', '--test',
        dest='testFile',
        action='store',
        default='t*.py',  # Runs every file whose name begins with 't'
        help='The name of the file containing test cases to run (including .py extension)')

    parser.add_argument(
        '-c', '--config',
        dest='config',
        action='store',
        default='default.json',
        help='A JSON file name from the local or remote directory (including .json extension)'
        + 'that specifies the configuration (capabilities) of the test device or simulator.')

    args_obj = parser.parse_args()
    args_dict = args_obj.__dict__

    # Load configuration file
    json_data = open('test_config/' + args_obj.config)
    config = json.load(json_data)
    json_data.close()

    return dict(args_dict.items() + config.items())

if __name__ == '__main__':

    print "\nRunning tests with the following args..."

    args = parse_args()

    suite = unittest.TestLoader().discover(start_dir=args['platformName'], pattern=args['testFile'])
    result = unittest.TextTestRunner(verbosity=2).run(suite)

    # combines the number of errors and failures
    status = len(result.errors) + len(result.failures)
    sys.exit(status)
