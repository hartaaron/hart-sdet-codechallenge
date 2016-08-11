# Hart Test Automation Coding Challenge

As a tourist, I want to know whether I should go to Disneyland (in Anaheim, California) or Disneyworld (in Orlando, Florida) on my vacation.  

I like both resorts equally, and they're about the same distance from my home (plus I have a teleporter ray, so travel is nearly instantaneous.) So, the deciding factor for me is which place has the best weather.

In order to plan my trip, I want to check the current weather in each location so that I can maximize my enjoyment while waiting in line.

I will check the weather using my favorite weather app, Weather Underground (http://wunderground.com), and make my decision based on that.


*** 


Your job is to create tests that will check the weather in both locations using either the Weather Underground web site or mobile app.  

Use whatever programming languages, test frameworks, automation tools, libraries, etc. you want and need to get the job done. 


***


1. Write test cases to check the weather.  Be sure to specify what is desireable weather.  Make your tests able to be understood by anyone.

2. Develop automation code to get the current weather in Anaheim, California and Orlando, Florida from the Weather Underground web site or mobile app.  Make your automation code easy to understand and maintain.

3. Build a test harness that can run your tests using the automation you've developed. 

4. Be able to automatically determine whether I should go to Disneyland or Disneyworld on any given day.


***


Bonus:

1. Use BDD to describe your tests.

2. Build automation in such a way that it can be expanded to use either the mobile app or the web site.  Alternately use the Weather Underground API to check the weather without using the UI.

3. Extend your tests to be able to check the weather in any two given locations.  Make the test harness data driven.

4. Write your tests in a way that they could also easily be used to test a hypothetical app developed specifically to do what is described (without using Weather Underground directly.)


***


Notes:

Feel free to use the internet or other reference material (but not people) to complete the challenge.  Ask for clarification or if you get stumped.  This is expected to be difficult and it is ok if you don't complete everything.  Focus on what you can deliver within the time frame.

Setup:
1. pip install ddt
2. pip install requests
3. Ensure that python 2.7 is your defaault, to check this type python in a terminal and watch for: Python 2.7.x.
4. If you do not have python installed goto https://www.python.org/ftp/python/2.7.12/python-2.7.12-macosx10.6.pkg.
5. If you have 3.x python then you will need to check out the following instructions http://stackoverflow.com/questions/5846167/how-to-change-default-python-version to swtich over to 2.7.

How to Run:
1. Inside the folder hart-sdet-codechallenge, cd hart-sdet-codechallenge.
2.  python -m unittest discover ./test/ Test_ParkDecider.py 

